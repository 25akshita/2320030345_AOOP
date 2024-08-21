package shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItem() {
        Item item1 = new Item("Apple", 0.99, 3);
        cart.addItem(item1);

        assertEquals(1, cart.getTotalCost(), "Cart should contain one item.");
        assertEquals(2.97, cart.getTotalCost(), 0.01, "Total cost should be calculated correctly.");
    }

    @Test
    void testAddSameItem() {
        Item item1 = new Item("Banana", 0.59, 2);
        cart.addItem(item1);

        Item item2 = new Item("Banana", 0.59, 3);
        cart.addItem(item2);

        assertEquals(1, cart.getTotalCost(), "Cart should contain one item (Banana).");
        assertEquals(5, cart.getTotalCost(), 0.01, "Total cost should be calculated correctly.");
    }

    @Test
    void testUpdateItemQuantity() {
        Item item1 = new Item("Orange", 1.29, 1);
        cart.addItem(item1);

        cart.updateItemQuantity("Orange", 5);

        assertEquals(1, cart.getTotalCost(), "Cart should contain one item (Orange).");
        assertEquals(6.45, cart.getTotalCost(), 0.01, "Total cost should be calculated correctly.");
    }

    @Test
    void testRemoveItem() {
        Item item1 = new Item("Apple", 0.99, 3);
        cart.addItem(item1);

        cart.removeItem("Apple");

        assertEquals(0, cart.getTotalCost(), "Cart should be empty after removing the item.");
    }

    @Test
    void testUpdateItemQuantityToZero() {
        Item item1 = new Item("Apple", 0.99, 3);
        cart.addItem(item1);

        cart.updateItemQuantity("Apple", 0);

        assertEquals(0, cart.getTotalCost(), "Cart should be empty after setting item quantity to zero.");
    }

    @Test
    void testTotalCostCalculation() {
        Item item1 = new Item("Apple", 0.99, 3);
        Item item2 = new Item("Banana", 0.59, 2);
        Item item3 = new Item("Orange", 1.29, 1);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        assertEquals(7.73, cart.getTotalCost(), 0.01, "Total cost should be calculated correctly.");
    }

    @Test
    void testEmptyCart() {
        assertEquals(0, cart.getTotalCost(), "Cart should be empty initially.");
    }
}
