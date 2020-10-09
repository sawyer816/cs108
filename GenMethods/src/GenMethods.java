/**
 * GenMethods
 * This class works with general methods to create and test different arrays
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section 1
 */
import java.util.*;

public class GenMethods {


    public static void main(String[] args) {
        //initializes the position variable that is used to linear search key.
        int position = -1;
        //reads input
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Integer[] list = new Integer[num];
        LinkedList <Integer> linked = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            //adds the elements to the linked list and array
            int cycle = input.nextInt();
            linked.add(cycle);
            list[i] = cycle;
        }
        Integer key = input.nextInt();
        // searches for the key using the linearSearch method
        position = linearSearch(list, key);
        //prints out the list and linked list.
        System.out.println(Arrays.toString(list));
        System.out.println(linked);
        if(position != -1) {
            System.out.println("Key " + key + " was found at position " + position);
        }
        else
        {
            System.out.println("Key " + key + " was not found");
        }
        System.out.println(max(list) + " is the max element");
        //reads in input for the length and width of the 2D array
        int m = input.nextInt();
        int p = input.nextInt();
        Integer[][] list2 = new Integer[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                //adds values to the 2D array
                list2[i][j] = input.nextInt();
                System.out.print(list2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(max(list2) + " is the max element");
        ArrayList<Integer> alist = new ArrayList<>(linked);
        System.out.println(alist);
        removeDuplicates(alist);
        System.out.println(alist);
        shuffle(alist);
        System.out.println(alist);
        System.out.println(max(alist) + " is the max element");
    }


    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        int size = list.size();
        //hits each element and then loops it back through to remove duplicates
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                    size --;
                    j --;
                }
            }
        }
        return list;
    }

    public static <E> void shuffle(ArrayList<E> list){
        //creates randomizer
        Random rand = new Random(340L);
        for (int i = 0; i < 30; i++) {
            //bounds each randomizer so it isn't larger than the list's size
            int swap1 = rand.nextInt(list.size());
            int swap2 = rand.nextInt(list.size());
            //swaps random locations with each other
            Collections.swap(list, swap1,swap2);
        }
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E max = list.get(0);
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
        //compares the elements to one another and sets max to the max element
            if(list.get(i).compareTo(list.get(i-1))>0){
                max = list.get(i);
            }

        }
        return max;
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(key))
                return i;
        }
        return -1;
    }

    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        for (int i = 0; i < list.length; i++) {
        //compares the elements to one another and sets max to the max element
            if(list[i].compareTo(max)>0){
               max=list[i];
            }
        }
        return max;
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
            //sorts each line of the array into ascending order
                Arrays.sort(list[i]);
            //compares the elements to one another and sets max to the max element
                if(list[i][j].compareTo(max)>0){
                    max=list[i][j];
                }
            }
        }
        return max;
    }

    public String getIdentificationString(){
        return "Program 6, Sawyer Thompson";
    }
}
