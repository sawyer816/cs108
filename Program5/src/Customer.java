
/**
 * Concrete Class: Customer
 * This class holds methods + variables to create and build a bank customer.
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section 1
 */
public class Customer extends Bank{
    private final int customerID;
    private String name;
    private int numAccountsOpen;
    Customer(){
        customerID = Bank.getCustomers();
        Bank.incrementCustomers();
        name = "Customer" + customerID;
        numAccountsOpen = 0;
    }
    public Customer(String name){
        customerID = Bank.getCustomers();
        Bank.incrementCustomers();
        this.name = name;
        numAccountsOpen = 0;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumAccountsOpen() {
        return numAccountsOpen;
    }

    public void setNumAccountsOpen(int numAccountsOpen) {
       this.numAccountsOpen = numAccountsOpen;
    }

    public String toString() {
        return "Customer: " + name + " | Customer ID: " + customerID;
    }
}