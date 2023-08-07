package entities;

import java.sql.Date;

public class OrderDetails { // OrderDetails bean class.
	private int orderId;
	private Date orderDate;
	private int emiPeriod;
	private int customerId;
	private int productId;

	public OrderDetails(int orderId, Date orderDate, int emiPeriod, int customerId, int productId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.emiPeriod = emiPeriod;
		this.customerId = customerId;
		this.productId = productId;
	}

	public OrderDetails() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getEmiPeriod() {
		return emiPeriod;
	}

	public void setEmiPeriod(int emiPeriod) {
		this.emiPeriod = emiPeriod;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", emiPeriod=" + emiPeriod
				+ ", customerId=" + customerId + ", productId=" + productId + "]";
	}
}
