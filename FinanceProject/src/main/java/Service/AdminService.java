package Service;

import java.util.List;

import entities.Customer;
import entities.Product;

public interface AdminService{
	//cutomerdao, 
	void ApproveUser(Customer customer1) throws CustomerNotEligibleException, CustomerAlreadyPresentException;

	void ModifyUser(Customer customer1) throws CustomerNotFoundException;

	void RevokeUser(int customerID);
	
	public void AddProductService(Product product1) throws ProductAlreadyExistsException; 
	
	List<Customer> Viewalluser();

//	int login(String userName, String password);
	
}
//package Service;
//
//import java.util.List;
//
//import entities.Customer;
//
//public interface UserService {
//
//	void ApproveUser(Customer customer1) throws CustomerNotEligibleException, CustomerAlreadyPresentException;
//
//	void ModifyUser(Customer customer1) throws CustomerNotFoundException;
//
//	List<Customer> Viewalluser();
//
//	int login(String userName, String password);
//
//}

