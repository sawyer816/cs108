import java.util.ArrayList;
/**
 *  Program #2
 *  This program creates recursive methods for an ArrayList of Integers that
 *  reverse it, find the oddIndexed numbers, reverse the Even Indexed Numbers,
 *  and return the final integer value of the ArrayList.
 *  CS108-1
 *  01/29/20
 *  @author  Sawyer Thompson
 */
public class RecursionP2 {
    public ArrayList<Integer> classList; //class ArrayList

    /**
     *Is the constructor and adds all the values of the array to the ArrayList
     * @param arr takes in an array of integers
     */
    public RecursionP2 (int[] arr){
        classList= new ArrayList<Integer>();
        for(int i=0; i<arr.length;i++){
            classList.add(arr[i]);
        }
    }
    /**
     *Clones the ArrayList
     * @param arrList takes in an array of integers
     * @return a newArrayList of type integers which is a clone of arrList
     */
    public ArrayList<Integer> cloneList(ArrayList<Integer> arrList){
        ArrayList<Integer> newArrList = new ArrayList<Integer>();
        //creates the new ArrayList
        for (int i = 0; i < arrList.size(); i++) {
            newArrList.add(arrList.get(i));
        }
        return newArrList;
    }
    /**
     * Is a helper method for reverseList. It recursively reverses
     * an ArrayList of Integers
     * @param arrList is an ArrayList of Integers that gets reversed.
     * @param n is originally the newArrList.size-1 easy cycling through the
     *          ArrayList size recursively
     * @return a reversed ArrayList
     */
    public ArrayList<Integer> reverse(ArrayList<Integer> arrList, int n){
        if(n <1){
            return arrList;
        }
        int temp = arrList.remove(0); //holds the value at index 0
        reverse(arrList, n-1); //recursive
        arrList.add(temp);
        return arrList;
    }

    /**
     * calls on reverse, and reverses a clone of the arrList parameter.
     * @param arrList is an ArrayList of Integers that gets cloned and reversed
     * @return a new ArrayList that is a reverse and clone of arrList
     */
    public ArrayList<Integer> reverseList(ArrayList<Integer> arrList){
        ArrayList<Integer> newArrList = cloneList(arrList);
        reverse(newArrList,newArrList.size()-1);
        return newArrList;
    }
    /**
     * calls on reverseList.
     * @return the class ArrayList reversed.
     */
    public ArrayList<Integer> reverseList(){
        return reverseList(classList);
    }

    /**
     * It is a helper method for the toOddList and the toEvenRevList.
     * @param arrList is an ArrayList of Integers
     * @param n is originally the arList.size easy cycling through the
     *          ArrayList size recursively
     * @param oddOrEven if the param is given a 1 it gives the odd indexes
     *                  if a 0 is given in the param it is even.
     * @return either all the even indexes or all the odd indexes.
     */
    public ArrayList<Integer> toOddOrEven(ArrayList<Integer> arrList, int n,
                                          int oddOrEven){
        int temp = 0;
        //assumes there is no 0 in the ArrayList: but it is
        // necessary to init the variable if running through recursively.
        if(n <=0){
            return arrList;
        }
        if(n%2==oddOrEven) {
            temp = arrList.get(0);
        }
        arrList.remove(0);
        if(temp!=0){ // doesn't add the zeros of temp each time it runs through
            arrList.add(temp);
        }
        toOddOrEven(arrList, n-1,oddOrEven); // recursive
        return arrList;
    }

    /**
     * It returns only the odd index's of a cloned arrList
     * @param arrList is an ArrayList of Integers
     * @return the odd indexes of the cloned arrList
     */
    public ArrayList<Integer> toOddList(ArrayList<Integer> arrList){
        ArrayList<Integer> newArrList = cloneList(arrList);
        if(newArrList.size()%2==1){
            newArrList.add(0);
            /*adds a zero because in the helper method it removes all the zeros
            * it is necessary as the helper runs through the arrList backwards
            * ensures the size doesn't through the odd or even off by one.
            */
        }
            toOddOrEven(newArrList, newArrList.size(),1);
        return newArrList;
    }

    /**
     * calls on tOddList.
     * @return the class ArrayList's odd indexes.
     */
    public ArrayList<Integer> toOddList(){
      return toOddList(classList);
    }

    /**
     * It returns the even index's of a cloned arrList, and reverses them
     * @param arrList is an ArrayList of Integers
     * @return the reversed even indexes of the cloned arrList
     */
    public ArrayList<Integer> toEvenRevList(ArrayList<Integer> arrList){
        ArrayList<Integer> newArrList = cloneList(arrList);
        if(newArrList.size()%2==1){
            newArrList.add(0);
            /*adds a zero because in the helper method it removes all the zeros
             * it is necessary as the helper runs through the arrList backwards
             * ensures the size doesn't through the odd or even off by one.
             */
        }
        toOddOrEven(newArrList, newArrList.size(), 0);
        return reverseList(newArrList);
    }

    /**
     * calls on toEvenRevList.
     * @return the class ArrayList's even indexes reversed.
     */
    public ArrayList<Integer> toEvenRevList(){
        return toEvenRevList(classList);
    }

    /**
     * Is a helper method for retPenultimate. It finds and returns the last
     * integer of the ArrayList.
     * @param arrList is an ArrayList of Integers
     * @param n is originally the arList.size easy cycling through the
     *          ArrayList size recursively
     * @return the final integer of the ArrayList
     */
    public int lastInt(ArrayList<Integer> arrList, int n){
        if(n <=1){
            return arrList.get(0);
        }
        arrList.remove(0);
        lastInt(arrList,n-1);//recursive
        return arrList.get(0);
    }

    /**
     * ensures that the the ArrayList isn't null or the size is 0, and then
     * runs it through the helper to find and return the final integer in arrList.
     * @param arrList is an ArrayList of Integers
     * @return the last element of arrList.
     */
    public int retPenultimate(ArrayList<Integer> arrList){
        if(arrList.size()==0|| arrList==null){
            return -1;
        }
        return lastInt(arrList, arrList.size());
    }

    /**
     * @return the class ArrayList.
     */
    public ArrayList<Integer> getList(){
        return classList;
    }

    /**
     * The main method, used for testing.
     */
    public static void main(String[] args) {
        int[]arr = {1,0,1,2};
        ArrayList<Integer>arr2 = new ArrayList<Integer>();
        arr2.add(4);
        arr2.add(1);
        arr2.add(1);
        arr2.add(1);
        arr2.add(1);
        arr2.add(1);
        arr2.add(1);
        arr2.add(1);
        arr2.add(6);
        RecursionP2 a = new RecursionP2(arr);
        //System.out.println(a.reverseList());
        //System.out.println(a.reverseList(arr2));
        //System.out.println(a.toOddList());
        //System.out.println(a.toOddList(arr2));
        //System.out.println(a.toEvenRevList(arr2));
        //System.out.println(a.toEvenRevList());
        //System.out.println(a.retPenultimate(arr2));
    }
}
