import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------Welcome to my online store----------");

        ProductInventory inventory = new ProductInventory("products.csv");
        inventory.loadProducts(); // Loads the products
        inventory.displayProducts(); // Displays the products to customer

    }
}
