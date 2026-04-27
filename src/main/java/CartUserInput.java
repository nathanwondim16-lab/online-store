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
                    if(cart.getNumOfCartItems() == 0) {
                        System.out.println("There's nothing for you to checkout because your cart is currently empty.");
                    } else {
                        CheckingOut checkout = new CheckingOut(cart);
                        checkout.checkout();
                    }
                }

                case "R" -> {
                    System.out.print("Enter the name of the product you want to remove from your cart: ");
                    String productName = scanner.nextLine().strip();
                    Product removeProduct = cart.searchCart(productName);
                    if(removeProduct != null) {
                        cart.remove(removeProduct);
                    } else {
                        System.out.println("\nProduct not found.");
                    }
                }
                default -> System.out.println("Invalid option. Please try again.");

            }
            System.out.print(message);
            choice = scanner.nextLine().strip().toUpperCase();
        }
        backToHomepage();
    }
}