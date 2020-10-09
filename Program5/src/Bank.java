/**
 * Concrete Class: Bank
 * The Bank class holds variables and methods like the month and total accounts
 * and customers. This is used to create accountId's and Customer Id's.
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section 1
 */
public class Bank{
     private static int accounts;
     private static int customers;
    private static int month;
    private static boolean MONTH_END;
    Bank(){
        month = 0;
        MONTH_END = false;
    }
    static int getCustomers() {
        return customers;
    }

    static int getAccounts(){
        return accounts;
    }

    static void incrementAccounts(){
        accounts++;
    }

    static void incrementCustomers(){
        customers++;
    }

    public int getMonth() {
        return month;
    }


    public int nextMonth(){
        if(!MONTH_END){
            System.out.println("It is not the end of month!");
            return -1;
        }
        if(month==11){
            month = 0;
        }
        else
        {
            month++;
        }
        return month;
    }

    public boolean isFlag() {
        return MONTH_END;
    }

    public void setFlag(boolean k){
        MONTH_END= k;
    }

    public int endOfMonth() {
        if(MONTH_END){
            System.out.println("It is already end of month!");
            return -1;
        }
        MONTH_END = true;
        System.out.println("It is now end of month!");
        return month;
    }
}