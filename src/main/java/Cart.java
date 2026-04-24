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


    @Override
    public String toString() {
        return ""; // Fix this later
    }
}
