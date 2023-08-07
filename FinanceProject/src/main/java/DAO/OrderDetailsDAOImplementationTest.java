package DAO;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.OrderDetails;

class OrderDetailsDAOImplementationTest {
	OrderDetailsDAO orddao = new OrderDetailsDAOImplementation();

	@Test
	void test() {
		System.out.println("Test started..");
		Assertions.assertTrue(orddao != null);
		System.out.println("Got the DAO : " + orddao);

//		OrderDetails ord1 = new OrderDetails(567, Date.valueOf("2023-04-03"), 3, 1, 6);
		// orddao.insertOrderDetails(ord1);
		// orddao.updateOrderDetails(ord1);
//		orddao.deleteOrderDetails(567);
		List<OrderDetails> ordobj = orddao.selectCustomerOrders(1);
		// List<OrderDetails> ordobj = orddao.selectAllOrders();
		System.out.println("ORD Obj : " + ordobj);
		System.out.println("Test over...");
	}

}

/*
 * 
 * 
 * 
 * 
 * void insertOrderDetails(OrderDetails orderDetails);
 * 
 * void updateOrderDetails(OrderDetails orderDetails);
 * 
 * void deleteOrderDetails(int orderId);
 */
