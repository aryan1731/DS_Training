package Service;

import java.util.List;

import DAO.CustomerDAO;
import DAO.CustomerDAOImplementation;
import DAO.EMICardDAO;
import DAO.EMICardDAOImplementation;
import entities.Customer;
import entities.EMICard;
import entities.Product;

public class UserServiceImplementation implements UserService {

	CustomerDAO customerdao;

	public UserServiceImplementation() {
		customerdao = new CustomerDAOImplementation();
	}

	@Override
	public void PlaceOrder(Product product1, int customerId) {
		// TODO Auto-generated method stub
		EMICardDAO emidao = new EMICardDAOImplementation();
		EMICard emiCard = emidao.selectEMICard(customerId);
		if(product1.getProductPrice() <= emiCard.getRemainingCredit()) {
			
			
		}
		
	}

	@Override
	public void ViewEMI(int customerId) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void ViewBalance(int customerId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void ApproveUser(Customer customer1) throws CustomerNotEligibleException, CustomerAlreadyPresentException {
//		// TODO Auto-generated method stub
//
//		List<Customer> alluser = customerdao.selectAllCustomers();
//		boolean customerFound = false;
//		for (Customer customer : alluser) {
//			if (customer.getPhoneNo() == customer1.getPhoneNo()) {
//				customerFound = true;
//				break;
//			}
//		}
//
//		int age1 = customer1.getAge();
//		int salary1 = customer1.getSalary();
//
//		if (customerFound == true)
//			throw new CustomerAlreadyPresentException("Customer is already present");
//		else if (age1 < 20 || salary1 < 20000)
//			throw new CustomerNotEligibleException("Customer is Not Eligible");
//		else
//			customerdao.insertCustomer(customer1);
//	}
//
//	@Override
//	public void ModifyUser(Customer customer1) throws CustomerNotFoundException {
//		// TODO Auto-generated method stub
//
//		List<Customer> alluser = customerdao.selectAllCustomers();
//		boolean customerFound = false;
//		for (Customer customer : alluser) {
//			if (customer.getCustomerId() == customer1.getCustomerId()) {
//				customerFound = true;
//				break;
//			}
//		}
//		if (customerFound == false)
//			throw new CustomerNotFoundException("Customer not found exception");
//		else
//			customerdao.updateCustomer(customer1);
//
//	}
//
//	@Override
//	public List<Customer> Viewalluser() {
//		// TODO Auto-generated method stub
//
//		return customerdao.selectAllCustomers();
//	}

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
