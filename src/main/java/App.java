import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInput input = new UserInput(scanner); // Ask Gregor if passing in a scanner is the correct approach or should the creation of the scanner be handled in the UserInput class
        input.beginShopping();
        ProductInventory inventory = new ProductInventory("products.csv");
    }
}
