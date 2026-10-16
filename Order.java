package Oct_15ZomatoFoodDeliveryApp;

import java.util.List;

public class Order {
	
	private int orderId;
	private Customer customerName;
	private List<FoodItem> orderedItems; 
	private double totalAmount; 
	private String status;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, Customer customerName, List<FoodItem> orderedItems, double totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderedItems = orderedItems;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public Customer getCustomerName() {
		return customerName;
	}

	public List<FoodItem> getOrderedItems() {
		return orderedItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setCustomerName(Customer customerName) {
		this.customerName = customerName;
	}

	public void setOrderedItems(List<FoodItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", orderedItems=" + orderedItems
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}

	
	
	

}
