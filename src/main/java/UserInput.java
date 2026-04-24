import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;


    UserInput(Scanner scanner) {
        this.scanner = scanner;
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
                    ProductInventory inventory = new ProductInventory("products.csv");
                    inventory.displayProducts();
                    displayProductInformationToUser(inventory);
                }

                case "C" -> {
                    Cart cart = new Cart();
                    cart.displayCart();
                }

            }
            welcomeMessage();
            choice = scanner.nextLine().strip().toUpperCase();
        }
        System.out.println("Goodbye for now 👋🏾");
    }


    // Method will be responsible for handling user input specifically related to products.
    private void displayProductInformationToUser(ProductInventory inventory) {
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
                    inventory.searchProducts(itemName);
                }
            }
            System.out.print(message);
            choice = scanner.nextLine();
        }

        try {
            System.out.print("\n\rGoing back to homepage....");
            Thread.sleep(2000);
            System.out.print("\r "); // Clears previous print statement
        } catch(InterruptedException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}

