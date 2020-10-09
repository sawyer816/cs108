import java.util.Scanner;
import java.util.ArrayList;

public class hi {

    public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {

        for (int index=0; index <= permList.size(); index++) {
            ArrayList<String> temp = new ArrayList<>(permList);
            temp.add(index, permList.get(0));

        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> permList = new ArrayList<String>();
        String name;
        while (true) {
            name = scnr.next();
            if (name.equals("-1")) break;
            nameList.add(name);
        }
        allPermutations(permList, nameList);
    }
}