import java.util.ArrayList;

public class Cart {
    private final ArrayList<Product> cart;
    private double cartTotal;

    Cart() {
        cart = new ArrayList<>();
    }

    public void add(Product product) {
        if(product != null) {
            cart.add(product);
            cartTotal += product.getPrice();
            System.out.println(Colors.ORANGE.printWithColor(product.getProductName() + " has been added to your cart 🛒"));
        } else {
            System.out.println("Couldn't add the product to your cart because it was not found.");
        }
    }

    public void remove(Product product) {
        if(product != null && cart.remove(product)) {
            cartTotal -= product.getPrice();
            System.out.println(Colors.ORANGE.printWithColor(product.getProductName() + " has been removed from your cart 🛒"));
        } else {
            System.out.println("Couldn't remove the product from your cart because it was not found.");
        }
    }

    public void displayCart() {
        if(cart.isEmpty()) {
            System.out.println("Your cart is currently empty.");
        } else {
            System.out.println("Here are all the items you currently have saved to your cart:\n");
            int index = 1;
            for(Product product : cart) {
                System.out.println("Item " + index++ + ": " + product.getProduct());
            }
            System.out.printf(Colors.GREEN.printWithColor("Cart total: $%.2f\n"), cartTotal);
        }
    }
}
