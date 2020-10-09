import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BogoSort {
    public ArrayList<Integer> input= new ArrayList<>();
    public int noOfRuns;
    public long randomSeed;
    public Random rand = new Random(randomSeed);
    public BogoSort(String file)  {
        readFromFile(file);
        System.out.print("Initial List: ");
        printList();
        sort();
        System.out.print("Sorted List in " + noOfRuns + " attempt(s): ");
        printList();
    }
    private void readFromFile(String file) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File(file));
                if (scan.hasNext()) {
                    randomSeed = scan.nextInt();
                }
                while (scan.hasNext()) {
                    input.add(scan.nextInt());
                }
        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void sort(){
        while (!sorted()){
            for (int i = 0; i < input.size(); i++) {
                int swap1 = rand.nextInt(input.size());
                int swap2 = rand.nextInt(input.size());
                Collections.swap(input, swap1,swap2);
                noOfRuns++;
            }
        }

    }
    public boolean sorted(){
        for (int i=1; i<input.size(); i++)
            if (input.get(i) < input.get(i-1))
                return false;
        return true;
    }

    private void printList(){
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i));
            if(i!= input.size()-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String testFileName = "testFile";
        BogoSort tester = new BogoSort(testFileName);
    }
}
