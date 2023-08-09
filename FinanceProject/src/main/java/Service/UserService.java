package Service;

import java.util.List;
import DAO.*;
import entities.Customer;
import entities.Product;

public interface UserService {
//	Product product1 = null;
	/*add product to orderlist	 */
	void PlaceOrder(int productId, int customerId, int emiPeriod);

	int ViewEMI(int customerId);
	
	int ViewBalance(int customerId);
}
