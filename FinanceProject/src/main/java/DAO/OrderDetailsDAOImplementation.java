package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.OrderDetails;

public class OrderDetailsDAOImplementation implements OrderDetailsDAO {
	Connection conn;

	public OrderDetailsDAOImplementation() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/finance", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderDetails selectOrder(int orderId) {
		OrderDetails order = null;

		try {
			Statement cst = conn.createStatement();
			ResultSet result = cst.executeQuery("select * from orderDetails where orderId=" + orderId);

			if (result.next()) {
				order = new OrderDetails();
				order.setOrderId(result.getInt(1));
				order.setOrderDate(result.getDate(2));
				order.setEmiPeriod(result.getInt(3));
				order.setCustomerId(result.getInt(4));
				order.setProductId(result.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public List<OrderDetails> selectCustomerOrders(int customerId) {
		List<OrderDetails> orderList = new ArrayList<OrderDetails>();

		try {
			Statement cst = conn.createStatement();
			ResultSet result = cst.executeQuery("select * from orderDetails where customerId=" + customerId);

			while (result.next()) {
				OrderDetails order = new OrderDetails();
				order.setOrderId(result.getInt(1));
				order.setOrderDate(result.getDate(2));
				order.setEmiPeriod(result.getInt(3));
				order.setCustomerId(result.getInt(4));
				order.setProductId(result.getInt(5));

				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	@Override
	public List<OrderDetails> selectAllOrders() {
		List<OrderDetails> orderList = new ArrayList<OrderDetails>();

		try {
			Statement cst = conn.createStatement();
			ResultSet result = cst.executeQuery("select * from orderDetails");

			while (result.next()) {
				OrderDetails order = new OrderDetails();
				order.setOrderId(result.getInt(1));
				order.setOrderDate(result.getDate(2));
				order.setEmiPeriod(result.getInt(3));
				order.setCustomerId(result.getInt(4));
				order.setProductId(result.getInt(5));

				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	@Override
	public void insertOrderDetails(OrderDetails orderDetails) {
		try {
			PreparedStatement pst = conn.prepareStatement(
					"insert into orderDetails(OrderId,orderDate,emiPeriod,customerId,productId) values(?,?,?,?,?)");
			pst.setInt(1, orderDetails.getOrderId());
			pst.setDate(2, orderDetails.getOrderDate());
			pst.setInt(3, orderDetails.getEmiPeriod());
			pst.setInt(4, orderDetails.getCustomerId());
			pst.setInt(5, orderDetails.getProductId());

			int rows = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE orderDetails set emiPeriod=? where orderId=?");

			pst.setInt(1, orderDetails.getEmiPeriod());
			pst.setInt(2, orderDetails.getOrderId());

			int rows = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteOrderDetails(int orderId) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM orderDetails where orderId=?");

			pst.setInt(1, orderId);

			int rows = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
