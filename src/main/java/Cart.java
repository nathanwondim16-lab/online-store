import java.util.ArrayList;

public class Cart {
    private final ArrayList<Product> cart;
    private double cartTotal;

    Cart() {
        cart = new ArrayList<>();
    }

    public void add(Product product) {
        cart.add(product);
        cartTotal += product.getPrice();
        System.out.println(Colors.ORANGE.printWithColor(product.getProductName() + " has been added to your cart 🛒"));
    }

    public void remove(Product product) {
        if(!cart.isEmpty()) {
            cartTotal -= product.getPrice();
        }
        cart.remove(product);
        System.out.println(Colors.ORANGE.printWithColor(product.getProductName() + " has been removed from your cart 🛒"));
    }

    public void displayCart() {
        if(cart.isEmpty()) {
            System.out.println("Your cart is currently empty ");
        } else {
            System.out.println("Here are all the items you currently have saved to your cart:\n");
            int index = 1;
            for(Product product : cart) {
                System.out.println("Item " + index++ + ": " + product.getProduct());
            }
            System.out.println(Colors.GREEN.printWithColor("Cart total: $" + cartTotal));
        }
    }
}
