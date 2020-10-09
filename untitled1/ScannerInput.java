import java.util.Scanner;
public class Main {
 public static void main(String[] args) {
 Scanner kb = null;
 String manufact = "";
 String model = "";
 double price = 0.0;
 kb = new Scanner(System.in);
 int count = 0;
 while (count++ < 3) {
 manufact = kb.nextLine();
 model = kb.nextLine();
 price = kb.nextDouble();
 System.out.printf("%s %s retails for $%.2f\n", manufact, model, price);
 }
 kb.close();
 return;
 }
}