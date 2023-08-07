package DAO;

import java.util.List;

import entities.OrderDetails;

public interface OrderDetailsDAO {
	OrderDetails selectOrder(int orderId);

	List<OrderDetails> selectCustomerOrders(int customerId);

	List<OrderDetails> selectAllOrders();

	void insertOrderDetails(OrderDetails orderDetails);

	void updateOrderDetails(OrderDetails orderDetails);

	void deleteOrderDetails(int orderId);
}