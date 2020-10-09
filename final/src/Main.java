import com.sun.codemodel.internal.JCatchBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter info: ");
        Scanner keyboard = new Scanner(System.in);
        String info = keyboard.nextLine();
        Scanner inputScnr = new Scanner(info);
        int item1 = inputScnr.nextInt();
        String item2 = inputScnr.next();
        String item3 = inputScnr.next();
        System.out.println(item3 + " " + item1);
    }
}
