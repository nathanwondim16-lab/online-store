import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> cart;

    Cart() {
        cart = new ArrayList<>();
    }

    public void add(Product product) {
        cart.add(product);

    }

    public void remove(Product product) {
        cart.remove(product);
    }

    public void displayCart() {
        System.out.println("Here are all the items you currently have saved to your cart\n");
        int counter = 1; // Counter used to order
        for(Product item : cart) {
            System.out.println("Item: " + item);
        }

        System.out.println("""
                \n--------------------------------------
                What would you like to do?
                (C)heck out
                (R)emove Product from the cart
                (H) Go back to the Home page
                --------------------------------------
                """);
        // Either store user input here or create another class that handles that
    }




    @Override
    public String toString() {
        return ""; // Fix this later
    }
}
