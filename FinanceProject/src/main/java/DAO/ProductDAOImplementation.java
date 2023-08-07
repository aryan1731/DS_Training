package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductDAOImplementation implements ProductDAO {

	Connection conn;

	public ProductDAOImplementation() {
		try {

			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/finance", "root", "root");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product selectProduct(int productId) {
		// TODO Auto-generated method stub

		Product product1 = null;

		try {
			Statement statement1 = conn.createStatement();

			ResultSet result = statement1.executeQuery("SELECT * FROM Product where ProductId=" + productId);
			if (result.next()) {
				product1 = new Product();

				product1.setProductId(result.getInt(1));
				product1.setProductName(result.getString(5));
				product1.setProductDesc(result.getString(3));
				product1.setProductPrice(result.getInt(4));
				product1.setImageURL(result.getString(5));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product1;

	}

	@Override
	public List<Product> selectAllProducts() {
		// TODO Auto-generated method stub

		List<Product> allproductlist = new ArrayList<Product>();

		try {
			Statement statement1 = conn.createStatement();
			ResultSet result = statement1.executeQuery("SELECT * FROM Product");

			while (result.next()) {
				Product product1 = new Product();
				product1.setProductId(result.getInt(1));
				product1.setProductName(result.getString(2));

				product1.setProductDesc(result.getString(3));
				product1.setProductPrice(result.getInt(4));
				product1.setImageURL(result.getString(5));
				allproductlist.add(product1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allproductlist;
	}

	@Override
	public void insertProduct(Product product1) {
		// TODO Auto-generated method stub

		System.out.println(product1);
		try {
			PreparedStatement pst1 = conn.prepareStatement(
					"insert into Product (productId,productName,productDesc,productPrice,imageURL) values (?,?,?,?,?)");

			pst1.setInt(1, product1.getProductId());
			pst1.setString(2, product1.getProductName());

			pst1.setString(3, product1.getProductDesc());
			pst1.setInt(4, product1.getProductPrice());
			pst1.setString(5, product1.getImageURL());

			int rows = pst1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateProduct(Product product1) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst1 = conn.prepareStatement(
					"UPDATE Product set productName=?,ProductDesc=?,productPrice=?,imageURL=? where productId=?");

			pst1.setString(1, product1.getProductName());
			pst1.setString(2, product1.getProductDesc());
			pst1.setInt(3, product1.getProductPrice());

			pst1.setString(4, product1.getImageURL());
			pst1.setInt(5, product1.getProductId());

			int rows = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM Product where productId=?");

			pst.setInt(1, productId);

			int rows = pst.executeUpdate(); // run the insert query

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
