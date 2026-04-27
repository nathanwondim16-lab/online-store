import java.time.LocalDateTime;
import java.util.Scanner;

public class CheckingOut {
    private Cart cart;
    private Scanner scanner = new Scanner(System.in);


    CheckingOut(Cart cart) {
        this.cart = cart;
    }

    public void checkout() {
        System.out.print("Enter your name: ");
        String customer = scanner.nextLine().strip();
        System.out.printf("Sales total: $%.2f\n", cart.getCartTotal());
        System.out.print("Enter payment amount: $");
        double amountPaid = Double.parseDouble(scanner.nextLine());
        if(amountPaid < cart.getCartTotal()) {
            System.out.println("Insufficient payment.");
            return;
        }

        SalesReceipt receipt = new SalesReceipt(customer, LocalDateTime.now(), cart.getNumOfCartItems(),
                cart.getCartTotal(), amountPaid, amountPaid - cart.getCartTotal());

        receipt.generateReceipt();
        cart.clearCart();
        System.out.println("\n\nThank you for shopping with us 😁");
        System.exit(0);

    }
}
