package DAO;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Customer;

class CustomerDAOTest {
	CustomerDAO custdao = new CustomerDAOImplementation();

	@Test
	void test() {
		System.out.println("Test started..");
		Assertions.assertTrue(custdao != null);
		System.out.println("Got the DAO : " + custdao);
		// Customer custobj = custdao.selectCustomer(1);
		// Customer cust1 = new Customer(5, "Piya", 278398126, "ry@gmail.com", "riy",
		// "pass", "Mum", 21, 40000, "Gold");
		// int customerId, String name, long phoneNo, String email, String userName,
		// String password,
		// String address, int age, int salary, String cardType
		// custdao.insertCustomer(cust1);
		// custdao.updateCustomer(cust1);
		// custdao.deleteCustomer(5);
		// System.out.println("Customer Obj : " + custobj);
		List<Customer> custobj = custdao.selectAllCustomers();
		System.out.println("Customer Obj : " + custobj);
		System.out.println("Test over...");
	}

}

/*
 * List<Customer> selectAllCustomers();
 * 
 * void insertCustomer(Customer customer1);
 * 
 * void updateCustomer(Customer customer1);
 * 
 * void deleteCustomer(int customerId);
 */
