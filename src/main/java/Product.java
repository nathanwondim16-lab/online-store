import java.util.Objects;

public class Product {
    private final String sku;
    private final String productName;
    private final double price;
    private final String department;


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
               + Colors.CRIMSON.printWithColor(String.format("$%.2f", price))
               + ", " + Colors.CHAMPAGNE_SILVER.printWithColor(department);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Product p)) return false;

        return Double.compare(p.price, price) == 0 &&
                Objects.equals(productName, p.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }

}