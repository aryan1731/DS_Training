package DAO;

import java.util.List;

import entities.Product;

public interface ProductDAO {

	Product selectProduct(int productId);

	List<Product> selectAllProducts();

	void insertProduct(Product product1);

	void updateProduct(Product product1);

	void deleteProduct(int productId);
}
