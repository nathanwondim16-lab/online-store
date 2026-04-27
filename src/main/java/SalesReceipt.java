import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalesReceipt {
    private final LocalDateTime dateTime;
    private final int itemsPurchased;
    private final double salesTotal;
    private final double amountPaid;
    private final double changeGiven;
    private final String name;

    public SalesReceipt(String name, LocalDateTime dateTime, int itemsPurchased,
                        double salesTotal, double amountPaid, double changeGiven) {
        this.name = name;
        this.dateTime = dateTime;
        this.itemsPurchased = itemsPurchased;
        this.salesTotal = salesTotal;
        this.amountPaid = amountPaid;
        this.changeGiven = changeGiven;
    }

    protected void generateReceipt() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mma");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt"))) {
            writer.write("<-------------------SALES RECEIPT------------------->\n");

            writer.write(String.format("%-20s %s%n", "Name:", name));
            writer.write(String.format("%-20s %s%n", "Date purchased:", dateTime.format(format)));
            writer.write(String.format("%-20s %d%n", "Items purchased:", itemsPurchased));
            writer.write(String.format("%-20s $%.2f%n", "Sales total:", salesTotal));
            writer.write(String.format("%-20s $%.2f%n", "Amount paid:", amountPaid));
            writer.write(String.format("%-20s $%.2f%n", "Change given:", changeGiven));
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    protected void printReceipt() {

    }


}
