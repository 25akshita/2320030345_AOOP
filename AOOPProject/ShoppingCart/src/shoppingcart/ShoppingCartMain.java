package shoppingcart;

public class ShoppingCartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Apple", 40, 3);
        Item item2 = new Item("Banana", 50, 2);
        Item item3 = new Item("Orange", 60, 1);

        // Test adding items
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.displayCart();

        // Test updating item quantity
        System.out.println("\nUpdating quantity of Bananas to 5.");
        cart.updateItemQuantity("Banana", 5);
        cart.displayCart();

        // Test removing an item
        System.out.println("\nRemoving Oranges.");
        cart.removeItem("Orange");
        cart.displayCart();

        // Test updating item quantity to 0
        System.out.println("\nUpdating quantity of Apples to 0.");
        cart.updateItemQuantity("Apple", 0);
        cart.displayCart();

	}

}
