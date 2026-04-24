import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);
    private static final ProductInventory inventory = new ProductInventory("products.csv");
    private static final Cart cart = new Cart();


    UserInput() {
    }

    private void welcomeMessage() {
        System.out.println("----------Welcome to my online store----------");
        System.out.print("""
                \nChoose from the options below:
                (P) Display Products
                (C) Display Cart
                (E)xit - closes out of the application\n
              
                Select option:\s""");
    }

    public void beginShopping() {
        welcomeMessage();
        String choice = scanner.nextLine().strip().toUpperCase();
        while(!choice.equals("E")) {
            switch(choice) {
                case "P" -> {
                    inventory.displayProducts();
                    displayProductInformationToUser();
                }

                case "C" -> {
                    cart.displayCart();
                    displayCartInformationToUser();
                }
            }
            welcomeMessage();
            choice = scanner.nextLine().strip().toUpperCase();
        }
        System.out.println("Goodbye for now 👋🏾");
    }


    // Method will be responsible for handling user input specifically related to products.
    private void displayProductInformationToUser() {
        String message = """
                \n--------------------------------------
                What would you like to do?
                (S)earch for a product
                (F)ilter through products
                (A)dd product to your cart
                (H) Go back to the Home page
                --------------------------------------
                \nSelect option:\s""";
        System.out.print(message);
        String choice = scanner.nextLine().strip().toUpperCase();
        while(!choice.equalsIgnoreCase("H")) {
            switch(choice) {
                case "S" -> {
                    System.out.print("Enter the name of the product: ");
                    String itemName = scanner.nextLine().strip();
                    Product product = inventory.searchProducts(itemName);
                    System.out.println("\nHere's the product you're looking for: " + product.getProduct());
                }

                case "F" -> {
                    System.out.println(); // Add filter functionality later
                }

                case "A" -> {
                    System.out.print("Enter the name of the product you want to add to your cart: ");
                    String productName = scanner.nextLine().strip();
                    cart.add(inventory.searchProducts(productName));
                }
            }
            System.out.print(message);
            choice = scanner.nextLine().strip().toUpperCase();
        }
        backToHomepage();
    }

    // Method handles all input with c
    private void displayCartInformationToUser() {
        String message = """
                \n--------------------------------------
                What would you like to do?
                (C)heck out
                (R)emove Product from the cart
                (H) Go back to the Home page
                --------------------------------------
                \nSelect option:\s""";
        System.out.print(message);
        String choice = scanner.nextLine().strip().toUpperCase();
        while(!choice.equalsIgnoreCase("H")) {
            switch(choice) {
                case "C" -> {
                    // Add check out here later
                }

                case "R" -> {
                    System.out.print("Enter the name of the product you want to remove from your cart: ");
                    String productName = scanner.nextLine().strip();
                    cart.remove(inventory.searchProducts(productName));
                }

            }
            System.out.print(message);
            choice = scanner.nextLine().strip().toUpperCase();
        }
        backToHomepage();
    }

    // Method prints "Going back to the homepage" message
    private void backToHomepage() {
        try {
            System.out.print("\n\rGoing back to homepage....");
            Thread.sleep(2000);
            System.out.print("\r "); // Clears previous print statement
        } catch(InterruptedException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}

