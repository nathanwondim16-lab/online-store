public class CartUserInput extends UserInput {

    // Method handles all input about customer's cart

    @Override
    void displayInformation() {
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
                    System.out.println("Check out feature not available rn 💀");
                    // Add check out here later
                }

                case "R" -> {
                    System.out.print("Enter the name of the product you want to remove from your cart: ");
                    String productName = scanner.nextLine().strip();
                    Product removeProduct = inventory.searchProducts(productName);
                    if(removeProduct != null) {
                        cart.remove(removeProduct);
                    } else {
                        System.out.println("\nProduct not found.");
                    }
                }

            }
            System.out.print(message);
            choice = scanner.nextLine().strip().toUpperCase();
        }
        backToHomepage();
    }
}