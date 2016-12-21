package cn.hjycjc.spring.hibernate.helloworld.n21.both;

public class Order {
	
	private Integer orderId;
	
	private String orderName;
	
	private Customer customer;

	public Order() {
		//super();
		// TODO Auto-generated constructor stub
	}


	public Order(Integer orderId, String orderName, Customer customer) {
		//super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.customer = customer;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", customer=" + customer + "]";
	}
	
}
