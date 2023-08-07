package Service;

import java.util.List;

import DAO.ProductDAO;
import DAO.ProductDAOImplementation;
import entities.Product;

public class ProductServiceImplementation implements ProductService {

	ProductDAO productdao;

	public ProductServiceImplementation() {

		this.productdao = new ProductDAOImplementation();
	}

	@Override
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
	public void EditProduct(Product Product1) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		List<Product> allproduct = productdao.selectAllProducts();
		boolean productFound = false;
		for (Product product : allproduct) {
			if (product.getProductId() == Product1.getProductId()) {
				productFound = true;
				break;
			}
		}

		if (productFound == false)
			throw new ProductNotFoundException("Customer is already present.");
		else
			productdao.updateProduct(Product1);

	}

	@Override
	public List<Product> Viewallproducts() {
		return productdao.selectAllProducts();
	}

	@Override
	public void RemoveProduct(int ProductId) throws ProductNotFoundException {
		// TODO Auto-generated method stub

		List<Product> allproduct = productdao.selectAllProducts();
		boolean productFound = false;
		for (Product product : allproduct) {
			if (product.getProductId() == ProductId) {
				productFound = true;
				break;
			}
		}

		if (productFound == false)
			throw new ProductNotFoundException("Not Found");
		else
			productdao.deleteProduct(ProductId);

	}

	@Override
	public Product viewsingleproduct(int ProductId) {
		// TODO Auto-generated method stub
		return productdao.selectProduct(ProductId);
	}

}