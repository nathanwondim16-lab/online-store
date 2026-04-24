import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductInventory {
    private final String file;
    private ArrayList<Product> inventory;


    ProductInventory(String file) {
        inventory = new ArrayList<>();
        this.file = file;
    }


    public void loadProducts() {
        try { // Ask gregor how to do the try with resources approach so I don't have to manually close the bufferedreader.
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine(); // Skips the header of the file
            while((line = reader.readLine()) != null) {
                String[] columns = line.split("\\|"); // Stores each line into an array of 4 indexes. elements

                String sku = columns[0];
                String productName = columns[1];
                double price = Double.parseDouble(columns[2]);
                String department = columns[3];

                inventory.add(new Product(sku,productName,price,department)); // Adds each product to the inventory


            }
        } catch (Exception e) {
            System.out.println("Something went wrong when reading the file: " + e.getMessage());
        }

    }

    public void displayProducts() {
        System.out.println("Here are all the available products that you can purchase\n");
        for(Product product : inventory) {
            System.out.println(product.getProduct());
        }
        System.out.println("""
                \n--------------------------------------
                What would you like to do?
                (S)earch for a product
                (F)ilter through products
                (A)dd product to your cart
                (H) Go back to the Home page
                --------------------------------------
                """);
    }

    public void searchProduct() {

    }
}
