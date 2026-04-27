import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class ProductInventory {
    protected final String file;
    private final ArrayList<Product> inventory;


    ProductInventory(String file) {
        inventory = new ArrayList<>();
        this.file = file;
        loadProducts();
    }


    private void loadProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\\|");

                String sku = columns[0];
                String productName = columns[1];
                double price = Double.parseDouble(columns[2]);
                String department = columns[3];

                inventory.add(new Product(sku, productName, price, department));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong when reading the file: " + e.getMessage());
        }
    }

    public void displayProducts() {
        System.out.println("Here are all the available products that you can purchase\n");
        inventory.forEach(product -> System.out.println(product.getProduct()));
    }

    public Product searchProducts(String itemName) {
        return inventory.stream()
                .filter(product -> product.getProductName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public void filterProducts(double maxPrice) {
        inventory.stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product -> System.out.println(product.getProduct()));
    }
}
