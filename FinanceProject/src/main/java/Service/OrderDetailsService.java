package Service;

import java.util.List;

import entities.OrderDetails;

public interface OrderDetailsService {
	void placeOrder(int emiPeriod, int customerId, int productId) throws InsufficientCreditLimitException;

	OrderDetails viewAnOrder(int orderId);

	List<OrderDetails> viewAllCutomersOrderHistory();
}
