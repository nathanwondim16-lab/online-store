import java.util.Scanner;

public abstract class UserInput {
    protected final Scanner scanner = new Scanner(System.in);
    protected static final ProductInventory inventory = new ProductInventory("products.csv");
    protected static final Cart cart = new Cart();



    protected void welcomeMessage() {
        System.out.println("----------Welcome to my online store----------");
        System.out.print("""
                \nChoose from the options below:
                (P) Display Products
                (C) Display Cart
                (E)xit - closes out of the application
                
                Select option:\s""");
    }

    abstract void displayInformation();

    public void beginShopping() {
        welcomeMessage();
        String choice = scanner.nextLine().strip().toUpperCase();
        while(!choice.equals("E")) {
            switch(choice) {
                case "P" -> {
                    inventory.displayProducts();
                    ProductUserInput productUserInput = new ProductUserInput();
                    productUserInput.displayInformation();
                }

                case "C" -> {
                    cart.displayCart();
                    CartUserInput cartUserInput = new CartUserInput();
                    cartUserInput.displayInformation();
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
            welcomeMessage();
            choice = scanner.nextLine().strip().toUpperCase();
        }
        System.out.println("Goodbye for now 👋🏾");
    }

    // Method prints "Going back to the homepage" message
    protected void backToHomepage() {
        try {
            System.out.print("\n\rGoing back to homepage....");
            Thread.sleep(2000);
            System.out.print("\r "); // Clears previous print statement
        } catch(InterruptedException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}

