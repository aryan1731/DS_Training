package Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import DAO.OrderDetailsDAO;
import DAO.OrderDetailsDAOImplementation;
import DAO.ProductDAO;
import DAO.ProductDAOImplementation;
import entities.EMICard;
import entities.OrderDetails;
import entities.Product;

public class OrderDetailsServiceImplementation implements OrderDetailsService {
	OrderDetailsDAO orderDao;

	public OrderDetailsServiceImplementation() {
		orderDao = new OrderDetailsDAOImplementation();
	}

	@Override
	public void placeOrder(int emiPeriod, int customerId, int productId) throws InsufficientCreditLimitException {
		EMICardService emiCardService = new EMICardServiceImplementation();
		ProductDAO productDao = new ProductDAOImplementation();

		EMICard card = emiCardService.viewEMICard(customerId);
		Product product = productDao.selectProduct(productId);

		int remCredit = card.getRemainingCredit();
		int productPrice = product.getProductPrice();

		if (productPrice > remCredit) {
			throw new InsufficientCreditLimitException(
					"The product price exceeds available credit limit. Current remaining credit limit is " + remCredit
							+ ".");
		} else {
			OrderDetails order = new OrderDetails();
			order.setOrderDate(Date.valueOf(LocalDate.now()));
			order.setEmiPeriod(emiPeriod);
			order.setCustomerId(customerId);
			order.setProductId(productId);

			orderDao.insertOrderDetails(order);
			int pricePerMonth = 0;
			pricePerMonth = productPrice / emiPeriod;
			remCredit = remCredit - pricePerMonth;
			card.setRemainingCredit(remCredit);
			emiCardService.updateEMICardService(card);
		}

	}

	@Override
	public String toString() {
		return "OrderDetailsServiceImplementation [orderDao=" + orderDao + "]";
	}

	@Override
	public OrderDetails viewAnOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.selectOrder(orderId);
	}

	@Override
	public List<OrderDetails> viewAllCutomersOrderHistory() {
		// TODO Auto-generated method stub
		return orderDao.selectAllOrders();
	}

}