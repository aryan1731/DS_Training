package Service;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import DAO.OrderDetailsDAO;
import DAO.OrderDetailsDAOImplementation;
import DAO.CustomerDAO;
import DAO.CustomerDAOImplementation;
import DAO.EMICardDAO;
import DAO.EMICardDAOImplementation;
import DAO.ProductDAOImplementation;
import DAO.ProductDAO;
import entities.Customer;
import entities.EMICard;
import entities.Product;

public class AdminServiceImplementation implements AdminService {
	
	CustomerDAO customerdao = new CustomerDAOImplementation();
	ProductDAO productdao = new ProductDAOImplementation();
	EMICardDAO emidao = new EMICardDAOImplementation();
	OrderDetailsDAO ordDAO = new OrderDetailsDAOImplementation();
	
//	public AdminServiceImplementation() {
//		customerdao = 
//	}

	@Override
	public void ApproveUser(Customer customer1) throws CustomerNotEligibleException, CustomerAlreadyPresentException {
		// TODO Auto-generated method stub

		List<Customer> alluser = customerdao.selectAllCustomers();
		boolean customerFound = false;
		for (Customer customer : alluser) {
			if (customer.getPhoneNo() == customer1.getPhoneNo()) {
				customerFound = true;
				break;
			}
		}

		int age1 = customer1.getAge();
		int salary1 = customer1.getSalary();

		if (customerFound == true)
			throw new CustomerAlreadyPresentException("Customer is already present");
		else if (age1 < 20 || salary1 < 20000)
			throw new CustomerNotEligibleException("Customer is Not Eligible");
		else
			customerdao.insertCustomer(customer1);
	}

	@Override
	public void ModifyUser(Customer customer1) throws CustomerNotFoundException {
		// TODO Auto-generated method stub

		List<Customer> alluser = customerdao.selectAllCustomers();
		boolean customerFound = false;
		for (Customer customer : alluser) {
			if (customer.getCustomerId() == customer1.getCustomerId()) {
				customerFound = true;
				break;
			}
		}
		if (customerFound == false)
			throw new CustomerNotFoundException("Customer not found exception");
		else
			customerdao.updateCustomer(customer1);

	}

	public void AddProductService(Product product1) throws ProductAlreadyExistsException {
		// TODO Auto-generated method stub
		List<Product> allproduct = productdao.selectAllProducts();
		boolean productFound = false;
		for (Product product : allproduct) {
			if (product.getProductName().equals(product1.getProductName())
					&& (product.getProductPrice() == product1.getProductPrice())) {
				productFound = true;
				break;
			}
		}

		if (productFound == true)
			throw new ProductAlreadyExistsException("Product is already present.");
		else
			productdao.insertProduct(product1);

	}
	@Override
	public List<Customer> Viewalluser() {
		// TODO Auto-generated method stub

		return customerdao.selectAllCustomers();
	}

	public void RevokeUser(int customerID) {
		// TODO Auto-generated method stub

		
//		EMICardService emiservice = new EMICardServiceImplementation();
		
//		EMICard emiobj = emiservice.viewEMICard(1);
		
		emidao.deleteEMICard(customerID);
		ordDAO.deleteOrderDetails(customerID);
//		EMICard emiCard= emiservice.viewEMICard(customer1.getCustomerId());
		customerdao.deleteCustomer(customerID);
		
		System.out.println("cutomer id : " +customerID+" was deleted");
//		emiCard.deleteEMICard(1);


	}

//	@Override
//	public int login(String userName, String password) {
//		// TODO Auto-generated method stub
//		List<Customer> alluser = customerdao.selectAllCustomers();
//		int customerFound = 0;
//		for (Customer customer : alluser) {
//			if (customer.getUserName().equals(userName) && (customer.getPassword().equals(password))) {
//				customerFound = 1;
//
//			}
//		}
//		// example:
//		if (userName.equals("Shruti") && password.equals("shruti123")) {
//			customerFound = 2;
//
//		}
//
//		return customerFound;
//
//	}
}
