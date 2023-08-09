package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Customer;
import entities.EMICard;

public class CustomerDAOImplementation implements CustomerDAO {

	Connection conn;

	public CustomerDAOImplementation() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/finance", "root", "root");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer selectCustomer(int customerId) {
		// TODO Auto-generated method stub

		Customer customer1 = null;

		try {

			Statement statement1 = conn.createStatement();

			ResultSet result = statement1.executeQuery("SELECT * FROM Customer where customerId=" + customerId);
			if (result.next()) {
				customer1 = new Customer();

				customer1.setCustomerId(result.getInt(1));
				customer1.setName(result.getString(5));
				customer1.setPhoneNo(result.getLong(3));
				customer1.setEmail(result.getString(4));
				customer1.setUserName(result.getString(2));
				customer1.setPassword(result.getString(6));
				customer1.setAddress(result.getString(7));
				customer1.setAge(result.getInt(8));
				customer1.setSalary(result.getInt(9));
				customer1.setCardType(result.getString(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer1;

	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub

		List<Customer> allcustomerlist = new ArrayList<Customer>();

		try {
			Statement statement1 = conn.createStatement();
			ResultSet result = statement1.executeQuery("SELECT * FROM Customer");

			while (result.next()) {
				Customer customer1 = new Customer();
				customer1.setCustomerId(result.getInt(1));
				customer1.setName(result.getString(2));
				customer1.setPhoneNo(result.getLong(3));
				customer1.setEmail(result.getString(4));
				customer1.setUserName(result.getString(2));
				customer1.setPassword(result.getString(6));
				customer1.setAddress(result.getString(7));
				customer1.setAge(result.getInt(8));
				customer1.setSalary(result.getInt(9));
				customer1.setCardType(result.getString(10));

				allcustomerlist.add(customer1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allcustomerlist;
	}

	@Override
	public void insertCustomer(Customer customer1) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pst1 = conn.prepareStatement(
					"insert into customer (customerid,name,phoneNo,email,userName,password,address,age,salary,cardType) values (?,?,?,?,?,?,?,?,?,?)");

			/*
			 * pst1.setString(1, customer1.getName()); pst1.setLong(2,
			 * customer1.getPhoneNo()); pst1.setString(3, customer1.getEmail());
			 * pst1.setString(4, customer1.getUserName()); pst1.setString(5,
			 * customer1.getPassword()); pst1.setString(6, customer1.getAddress());
			 * pst1.setInt(7, customer1.getAge()); pst1.setInt(8, customer1.getSalary());
			 * pst1.setString(9, customer1.getCardType());
			 */
			pst1.setInt(1, customer1.getCustomerId());
			pst1.setString(2, customer1.getName());
			pst1.setLong(3, customer1.getPhoneNo());
			pst1.setString(4, customer1.getEmail());
			pst1.setString(5, customer1.getUserName());
			pst1.setString(6, customer1.getPassword());
			pst1.setString(7, customer1.getAddress());
			pst1.setInt(8, customer1.getAge());
			pst1.setInt(9, customer1.getSalary());
			pst1.setString(10, customer1.getCardType());

			int rows = pst1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		EMICard emicard = new EMICard(customer1.getCustomerId(),Date.valueOf(LocalDate.now()), 5,customer1.getSalary()> 100000 ? 100000:50000, customer1.getCardType(),customer1.getCustomerId());
//		 CardNo | CardIssueDate | ValidityYears | RemainingCredit | CardType | CustomerID
		EMICardDAO emidao = new EMICardDAOImplementation();
		emidao.insertEMICard(emicard);

	}

	@Override
	public void updateCustomer(Customer customer1) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst1 = conn.prepareStatement(
					"UPDATE Customer set name=?,phoneNo=?,email=?,userName=?,password=?,address=?,age=?,salary=?,cardType = ? where customerId=?");

			pst1.setString(1, customer1.getName());
			pst1.setLong(2, customer1.getPhoneNo());
			pst1.setString(3, customer1.getEmail());
			pst1.setString(4, customer1.getUserName());
			pst1.setString(5, customer1.getPassword());
			pst1.setString(6, customer1.getAddress());
			pst1.setInt(7, customer1.getAge());
			pst1.setInt(8, customer1.getSalary());
			pst1.setString(9, customer1.getCardType());

			pst1.setInt(10, customer1.getCustomerId());

			int rows = pst1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM Customer where customerId=?");

			pst.setInt(1, customerId);

			int rows = pst.executeUpdate(); // run the insert query

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
