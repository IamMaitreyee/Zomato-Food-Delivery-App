package Oct_15ZomatoFoodDeliveryApp;

public class FoodItem {

	private int foodId;
	private String foodName;
	private String category;
	private double price;
	
	public FoodItem() {
		// TODO Auto-generated constructor stub
	}

	public FoodItem(int foodId, String foodName, String category, double price) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.category = category;
		this.price = price;
	}

	public int getFoodId() {
		return foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return " FoodItem >>> foodId=" + foodId + ", "+"foodName=" + foodName + ", category=" + category + ", price=" + price
				+ "]";
	}
	
	
}
