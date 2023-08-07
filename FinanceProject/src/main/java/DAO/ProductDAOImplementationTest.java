package DAO;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Product;

class ProductDAOImplementationTest {
	ProductDAO proddao = new ProductDAOImplementation();

	@Test
	void test() {

		System.out.println("Test started..");
		Assertions.assertTrue(proddao != null);
		System.out.println("Got the DAO : " + proddao);
		 Product prod1 = new Product(10, "Mouse", "Scroll", 3000, "mouse.in");
		 proddao.insertProduct(prod1);
		// proddao.updateProduct(prod1);
		 List<Product> prodobj = proddao.selectAllProducts();
//		proddao.deleteProduct(10);
		 System.out.println("PROD Obj : " + prodobj);
		System.out.println("Test over...");
	}

}

/*
 * Product selectProduct(int productId);
 * 
 * List<Product> selectAllProducts();
 * 
 * void insertProduct(Product product1);
 * 
 * void updateProduct(Product product1);
 * 
 * void deleteProduct(int productId);
 */
