import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add("h");
        list.add("k");
        list2.add("h");
        list2.add("k");
        list2.add("l");
        System.out.println(list.contains(list2));System.out.println(list2.contains(list));
        System.out.println(list.contains(list2.get(2)));
        System.out.println(list2.contains(list.get(0)));
    }
}
