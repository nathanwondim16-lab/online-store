import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart {
    private final Map<Product, Integer> cart;

    Cart() {
        cart = new HashMap<>();
    }

    public void add(Product product) {
//        if(product != null) {
//            if(cart.containsKey(product)) {
//                System.out.println("Product: " + product.getProductName() + "");
//            }
//            cart.put(product,);
//            System.out.println(Colors.ORANGE.printWithColor(product.getProductName() + " has been added to your cart 🛒"));
//        } else {
//            System.out.println("Couldn't add the product to your cart because it was not found.");
//        }
        if(product != null) {
            cart.put(product, cart.getOrDefault(product, 0) + 1);
            System.out.println(Colors.ORANGE.printWithColor(product.getProductName() + " has been added to your cart 🛒"));
        } else {
            System.out.println("Couldn't add the product to your cart because it was not found.");
        }
    }

    public void remove(Product product) {
        if(product != null && cart.containsKey(product)) {
            int productQuantity = cart.get(product);
            if(productQuantity > 1) {
                cart.put(product, productQuantity - 1);
            } else {
                cart.remove(product);
            }
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
            cart.entrySet().stream().forEach(entry -> {});
            cart.forEach((key, value) -> System.out.println("Item: " + key.getProduct() + " Quantity: " + value));
            System.out.printf(Colors.GREEN.printWithColor("Cart total: $%.2f\n"), getCartTotal());
        }
    }

    public int getNumOfCartItems() {
        return cart.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double getCartTotal() {
        return cart.entrySet().stream()
                .mapToDouble(p -> p.getKey().getPrice() * p.getValue())
                .sum();
    }

    public Product searchCart(String productName) {
        return cart.keySet().stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    protected void clearCart() {
        cart.clear();
    }
}
