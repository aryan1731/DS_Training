package Service;

import java.util.List;

import entities.Product;

public interface ProductService {

	void AddProductService(Product product1) throws ProductAlreadyExistsException;

	void EditProduct(Product Product1) throws ProductNotFoundException;

	List<Product> Viewallproducts();

	Product viewsingleproduct(int ProductId) throws ProductNotFoundException;

	void RemoveProduct(int ProductId) throws ProductNotFoundException;

}
