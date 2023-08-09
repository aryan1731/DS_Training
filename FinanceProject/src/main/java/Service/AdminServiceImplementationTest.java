package Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import DAO.CustomerDAO;
import DAO.CustomerDAOImplementation;
import DAO.EMICardDAO;
import DAO.EMICardDAOImplementation;
import DAO.ProductDAO;
import DAO.ProductDAOImplementation;
import entities.Customer;
import entities.Product;

class AdminServiceImplementationTest {
	AdminService adminService = new AdminServiceImplementation();
//	@Test
//	void testApproveUser() {
//		
//	}

	@Test
	void TestModifyUser() {
		System.out.println("test started");
		Assertions.assertTrue(adminService != null);
		System.out.println("Got the Service : " + adminService);
		Customer cust1 = new Customer(1, "Piya", 278398126, "ry@gmail.com", "riy","pass", "Mum", 21, 40000, "Gold");
		try {// 1 | Roy   | 62325263 | r@gmail.com | rew      | pass     | mumbai  |   21 |  24000 | Gold
			adminService.ModifyUser(cust1);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test over...");

	}

	@Test
	void testAddProductService() {
		System.out.println("test started");
		Assertions.assertTrue(adminService != null);
		System.out.println("Got the Service : " + adminService);
		Product prod1 = new Product(1, "microwave", "garam" , 20000, "xv.com");
		try {
			adminService.AddProductService(prod1);
		} catch (ProductAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test over...");
	}

	@Test
	void TestViewalluser() {
		System.out.println(adminService.Viewalluser());
	}

	@Test
	void testRevokeUser() {
		adminService.RevokeUser(12);
	}

}
