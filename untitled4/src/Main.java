import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Are you an existing customer? [Y: Yes; N: No]");
        Scanner input = new Scanner(System.in);
        if (input.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Enter Customer ID:");
            String id = input.nextLine();
        }
    }
}
