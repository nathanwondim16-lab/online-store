public class ProductUserInput extends UserInput {

    // Method will be responsible for handling user input specifically related to products.

    @Override
    void displayInformation() {
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
                    if(product != null) {
                        System.out.println("\nHere's the product you're looking for: " + product.getProduct());
                    } else {
                        System.out.println("\nProduct not found.");
                    }
                }

                case "F" -> {
                    System.out.print("Show products under what price? ");
                    double maxPrice = Double.parseDouble(scanner.nextLine().strip());
                    inventory.filterProducts(maxPrice);
                }

                case "A" -> {
                    System.out.print("Enter the name of the product you want to add to your cart: ");
                    String productName = scanner.nextLine().strip();
                    Product productFound = inventory.searchProducts(productName);
                    if(productFound != null) {
                        cart.add(productFound);
                    } else {
                        System.out.println("\nProduct not found");
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