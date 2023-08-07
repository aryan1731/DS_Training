package Service;

import java.util.List;
import DAO.*;
import entities.Customer;
import entities.Product;

public interface UserService {
//	Product product1 = null;
	/*add product to orderlist	 */
	void PlaceOrder(Product product1, int customerId);

	void ViewEMI(int customerId);
	
	void ViewBalance(int customerId);
}
