package Oct_15ZomatoFoodDeliveryApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainZomato {

	public static void main(String[] args) {

		// Static block
		{
			System.out.println("@Zomato Food Delivery App");
		}

		// List of Food Item
		List<FoodItem> fooditems = new ArrayList<>();

		fooditems.add(new FoodItem(101, "Veg Pizza", "Pizza", 250));
		fooditems.add(new FoodItem(102, "Chicken Burger", "Burger", 180));
		fooditems.add(new FoodItem(103, "Veg Biryani", "Biryani", 150));
		fooditems.add(new FoodItem(104, "Chicken Biryani", "Biryani", 280));
		fooditems.add(new FoodItem(105, "Masala Dosa", "South Indian", 100));
		fooditems.add(new FoodItem(106, "Paneer Tikka", "Starter", 220));
		fooditems.add(new FoodItem(107, "French Fries", "Snacks", 120));
		fooditems.add(new FoodItem(108, "Cold Coffee", "Beverage", 90));

		// customer
		Map<Integer, Customer> customer = new HashMap<>();

		customer.put(1, new Customer(1, "Sapna Patil", "9005350001", "Kothrud, Pune"));
		customer.put(2, new Customer(2, "Rahul Sharma", "9075744202", "Baner, Pune"));
		customer.put(3, new Customer(3, "Priya Deshmukh", "9090869003", "Wakad, Pune"));
		customer.put(4, new Customer(4, "Amit Kulkarni", "9853434004", "Hinjawadi, Pune"));
		customer.put(5, new Customer(5, "Sneha Joshi", "946436545", "Viman Nagar, Pune"));
		customer.put(6, new Customer(6, "Rohan Patil", "9985343406", "Hadapsar, Pune"));
		customer.put(7, new Customer(7, "Pooja Shah", "9057442007", "Pimple Saudagar, Pune"));

		// food Categories
		Set<String> categories = new HashSet<>();

		// Orders
		List<Order> orders = new ArrayList<>();
		int orderId = 1001;

		// menu
		Map<Integer, FoodItem> menu = new HashMap<>();

		for (FoodItem fi : fooditems) {
			menu.put(fi.getFoodId(), fi);
		}

		// order Items
		List<FoodItem> orderedItems = new ArrayList<>();

		// Food Delievery
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n========== ZOMATO FOOD DELIVERY ==========");
			System.out.println("1. Display Food Menu");
			System.out.println("2. Search Food by ID or Name");
			System.out.println("3. Filter Food by Category");
			System.out.println("4. Sort Food by Price");
			System.out.println("5. Register Customer");
			System.out.println("6. Display All Customers");
			System.out.println("7. Search Customer by ID");
			System.out.println("8. Place Order");
			System.out.println("9. Display All Orders");
			System.out.println("10. Display Orders by Customer ID");
			System.out.println("11. Update Order Status");
			System.out.println("12. Display Unique Food Categories");
			System.out.println("13. Find Top 3 Expensive Food Items");
			System.out.println("14. Exit");
			System.out.println("\n=========================================");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Display food menu
				for (FoodItem fi : fooditems) {
					System.out.println(fi);

				}
				break;

			case 2:
				// Search food
				System.out.println("\nSearch food item by name: ");
				sc.nextLine();
				System.out.println("Enter food name: ");
				String searchName = sc.nextLine();
				boolean found = false;

				for (FoodItem fi : fooditems) {

					if (fi.getFoodName().equalsIgnoreCase(searchName)) {

						found = true;
						System.out.println(fi);
						break;

					}
				}
				if (!found)
					System.out.println("Food item not found");

				break;

			case 3:
				// Filter by category
				sc.nextLine();
				System.out.print("\nEnter food category: ");
				String category = sc.nextLine();

				boolean found1 = false;

				for (FoodItem foodItem : fooditems) {
					if (foodItem.getCategory().equalsIgnoreCase(category)) {
						System.out.println(foodItem);
						found1 = true;
					}
				}

				if (!found1) {
					System.out.println("No food items found in this category.");
				}
				break;

			case 4:
				// Sort food by price
				break;

			case 5:
				// Register customer
				System.out.println("\nRegister Customer: ");
				System.out.println("Enter Customer Id: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Customer name: ");
				String name = sc.nextLine();

				System.out.println("Enter Mobile number: ");
				String phone = sc.nextLine();

				System.out.println("Enter Address: ");
				String add = sc.nextLine();

				Customer c = new Customer(id, name, phone, add);
				customer.put(id, c);

				System.out.println("Customer Registration Successfull!");
				System.out.println(customer);

				break;

			case 6:
				// Display all customers
				System.out.println("\nAll Registered Customers:");

				for (Customer cust : customer.values()) {
					System.out.println(cust);
				}

				break;
			case 7:
				// Search customer
				System.out.println("\nSearch Customer: ");
				System.out.println("Enter customer id: ");
				int cid = sc.nextInt();
				boolean cfound = false;

				for (Customer ct : customer.values()) {
					if (ct.getCustomerId() == cid) {
						cfound = true;
						System.out.println(ct);
					}
				}
				if (!cfound)
					System.out.println("Customer not found");
				break;

			case 8:
				System.out.println("\n========== PLACE ORDER ==========");
				System.out.print("Enter Customer ID: ");
				int custId = sc.nextInt();

				Customer selectedCustomer = customer.get(custId);

				if (selectedCustomer == null) {
					System.out.println("Customer not found! Please register first.");
					break;
				}

				char ch = 'Y';

				while (ch == 'Y' || ch == 'y') {

					System.out.println("\n========== FOOD MENU ==========");

					for (FoodItem fi : fooditems) {
						System.out.println(fi.getFoodId() + " ->> " + fi.getFoodName() + " - Rs. " + fi.getPrice());
					}

					FoodItem selectedFood = null;

					while (selectedFood == null) {
						System.out.print("\nEnter Food ID to order: ");
						int foodId = sc.nextInt();

						selectedFood = menu.get(foodId);

						if (selectedFood == null) {
							System.out.println("Food item not found! Please try again.");
						}
					}

					orderedItems.add(selectedFood);
					System.out.println(selectedFood.getFoodName() + " added to order!");

					System.out.print("\nDo you want to add more food items? (Y/N): ");
					ch = sc.next().charAt(0);
				}

				if (orderedItems.isEmpty()) {
					System.out.println("No food items selected. Order cancelled.");
					break;
				}

				double totalAmount = 0;

				for (FoodItem fi : orderedItems) {
					totalAmount += fi.getPrice();
				}

				Order order = new Order(orderId, selectedCustomer, orderedItems, totalAmount, "PLACED");

				orders.add(order);

				System.out.println("\n========== ORDER BILL ==========");
				System.out.println("Order ID: " + orderId);
				System.out.println("Customer ID: " + selectedCustomer.getCustomerId());
				System.out.println("Customer Name: " + selectedCustomer.getCustomerName());

				System.out.println("\nOrdered Items:");

				for (FoodItem fi : orderedItems) {
					System.out.println(fi.getFoodName() + " - Rs. " + fi.getPrice());
				}

				System.out.println("--------------------------------");
				System.out.println("Grand Total: Rs. " + totalAmount);
				System.out.println("Order Status: PLACED");
				System.out.println("Order placed successfully!");

				orderId++;
				break;
			case 9:
				// Display all orders
				System.out.println("\n========== ALL ORDERS ==========");

				if (orders.isEmpty()) {
					System.out.println("No orders placed yet.");
				} else {
					for (Order o : orders) {
						System.out.println(o);
					}
				}

				break;

			case 10:
				// Display orders by customer ID
				System.out.println("\n========== ORDERS BY CUSTOMER ID ==========");

				System.out.print("Enter Customer ID: ");
				int searchId = sc.nextInt();

				boolean orderFound = false;

				for (Order o : orders) {
					if (o.getCustomerName().getCustomerId() == searchId) {
						System.out.println(o);
						orderFound = true;
					}
				}

				if (!orderFound) {
					System.out.println("No orders found for this customer!");
				}

				break;
			case 11:
				// Update Order Status
				System.out.println("\n========== UPDATE ORDER STATUS ==========");

				System.out.print("Enter Order ID: ");
				int searchOrderId = sc.nextInt();

				boolean orderFound1 = false;

				for (Order o : orders) {
					if (o.getOrderId() == searchOrderId) {
						orderFound1 = true;

						System.out.println("Current Status: " + o.getStatus());

						System.out.println("\nSelect New Status:");
						System.out.println("1. PREPARING");
						System.out.println("2. OUT_FOR_DELIVERY");
						System.out.println("3. DELIVERED");
						System.out.print("Enter your choice: ");

						int statusChoice = sc.nextInt();

						switch (statusChoice) {
						case 1:
							o.setStatus("PREPARING");
							break;

						case 2:
							o.setStatus("OUT_FOR_DELIVERY");
							break;

						case 3:
							o.setStatus("DELIVERED");
							break;

						default:
							System.out.println("Invalid status choice!");
							break;
						}

						System.out.println("Updated Order Status: " + o.getStatus());
						break;
					}
				}

				if (!orderFound1) {
					System.out.println("Order not found!");
				}

				break;

			case 12:
				// Display unique categories
				System.out.println("Unique Food Categories:");

				for (FoodItem fi : fooditems) {
					categories.add(fi.getCategory());
				}
				for (String string : categories) {
					System.out.println(string);

				}
				break;

			case 13:
				// Find top 3 expensive food items
				System.out.println("Top 3 Expensive Food items: ");
				double max = Integer.MIN_VALUE;
				double secmax = Integer.MIN_VALUE;
				double thirdmax = Integer.MIN_VALUE;

				FoodItem maxfood = null;
				FoodItem secfood = null;
				FoodItem thirdfood = null;

				for (FoodItem fi : fooditems) {
					if (fi.getPrice() > max) {
						thirdmax = secmax;
						thirdfood = secfood;

						secmax = max;
						secfood = maxfood;

						max = fi.getPrice();
						maxfood = fi;
					} else if (max != secmax && fi.getPrice() > secmax) {
						thirdmax = secmax;
						thirdfood = secfood;

						secmax = fi.getPrice();
						secfood = fi;
					} else if (secmax != thirdmax && fi.getPrice() > thirdmax) {
						thirdmax = fi.getPrice();
						thirdfood = fi;
					}
				}
				System.out.println("1 -->" + maxfood);
				System.out.println("2 -->" + secfood);
				System.out.println("3 -->" + thirdfood);
				break;

			case 14:
				System.out.println("Thank you for using Zomato!");
				break;

			default:
				System.out.println("Invalid choice! Please try again.");
			}

		} while (choice != 14);

	}
}
