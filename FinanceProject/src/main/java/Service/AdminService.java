package Service;

import java.util.List;

import entities.Customer;

public interface AdminService{
	
	void ApproveUser(Customer customer1) throws CustomerNotEligibleException, CustomerAlreadyPresentException;

	void ModifyUser(Customer customer1) throws CustomerNotFoundException;

	void RevokeUser(Customer customer1);
	
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

