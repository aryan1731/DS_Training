package Service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.OrderDetails;

class OrderDetailsServiceImplementationTest {

	OrderDetailsService orderservice = new OrderDetailsServiceImplementation();

	@Test
	void test() {
		System.out.println("Test started..");
		Assertions.assertTrue(orderservice != null);
		System.out.println("Got the Service : " + orderservice);
		// OrderDetails ordobj = orderservice.viewAnOrder(1234);
		// try {
		// orderservice.placeOrder(3, 1, 4);
		// } catch (InsufficientCreditLimitException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		OrderDetails ordobj = orderservice.viewAnOrder(1234);
		List<OrderDetails> orderList = orderservice.viewAllCutomersOrderHistory();
		System.out.println("Order Obj : " + ordobj);
		System.out.println("Order Obj : " + orderList);
		System.out.println("Test over...");
	}

}
