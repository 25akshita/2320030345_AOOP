package shoppingcart;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        for (Item cartItem : items) {
            if (cartItem.getName().equals(item.getName())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equals(itemName));
    }

    public void updateItemQuantity(String itemName, int quantity) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                item.setQuantity(quantity);
                if (quantity <= 0) {
                    removeItem(itemName);
                }
                return;
            }
        }
    }

    public double getTotalCost() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println("Total: rupees " + getTotalCost());
        }
    }
}
