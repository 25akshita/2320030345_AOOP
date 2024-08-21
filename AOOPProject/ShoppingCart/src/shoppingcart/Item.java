package shoppingcart;

public class Item {

	public static void main(String[] args) {
		
	}
		// TODO Auto-generated method stub
		   private String name;
		    private double price;
		    private int quantity;

		    public Item(String name, double price, int quantity) {
		        this.name = name;
		        this.price = price;
		        this.quantity = quantity;
		    }

		    public String getName() {
		        return name;
		    }

		    public double getPrice() {
		        return price;
		    }

		    public int getQuantity() {
		        return quantity;
		    }

		    public void setQuantity(int quantity) {
		        this.quantity = quantity;
		    }

		    public double getTotalPrice() {
		        return price * quantity;
		    }

		    @Override
		    public String toString() {
		        return name + " - rupees" + price + " x " + quantity + " = rupees" + getTotalPrice();
		    }

	}


