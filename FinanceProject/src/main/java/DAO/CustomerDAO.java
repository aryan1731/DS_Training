package DAO;

import java.util.List;

import entities.Customer;

public interface CustomerDAO {

	Customer selectCustomer(int customerId);

	List<Customer> selectAllCustomers();

	void insertCustomer(Customer customer1);

	void updateCustomer(Customer customer1);

	void deleteCustomer(int customerId);

}
