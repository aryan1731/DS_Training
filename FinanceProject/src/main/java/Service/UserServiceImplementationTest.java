package Service;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserServiceImplementationTest {
	UserServiceImplementation userService = new UserServiceImplementation();
	@Test
	public void testPlaceOrder() {
		userService.PlaceOrder(9, 7, 3);
	}

	@Test
	public void testViewEMI() {
		System.out.println(userService.ViewEMI(7));
	}

	@Test
	public void testViewBalance() {
		System.out.println(userService.ViewBalance(7));
	}

}
