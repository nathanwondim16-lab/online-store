import java.util.ArrayList;

public class Product {
    private String sku;
    private String productName;
    private double price;
    private String department;


    Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    public String getProduct() {
       return Colors.TRON.printWithColor(sku) + ", "
               + Colors.AMBER.printWithColor(productName) + ", "
               + Colors.CRIMSON.printWithColor("$" + String.valueOf(price))
               + ", " + Colors.CHAMPAGNE_SILVER.printWithColor(department);
    }

}
