import java.util.Scanner;

/**
 * Abstract Class: Deposit
 * This class has methods to create accounts and update those accounts.
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section X (1 or 3)
 */
public abstract class Deposit implements Account {
    private Customer first;
    private Customer second;
    private int accountID;
    private int accountBalance;
    private int withdrawals;
    private int fees;

    public Deposit(){
        accountID= Bank.getAccounts();
        Bank.incrementAccounts();
        first = checkCustomer();
        accountBalance = 0;
        withdrawals = 0;
        System.out.println("A new account was created with account ID: " + accountID +
                "\n The first holder is: " + first.toString());
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID=accountID;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance=accountBalance;
    }

    public int getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(int withdrawals) {
        this.withdrawals=withdrawals;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees=fees;
    }

    public Customer getFirst() {
        return first;
    }

    public void setFirst(Customer first) {
        this.first=first;
    }

    public Customer getSecond() {
        return second;
    }

    public boolean depositMoney(int money){
        accountBalance+=money;
        System.out.println("Updated Balance: " + accountBalance);
        return money >= 0;
    }

    //either creates a new customer or returns an existing one.
    public Customer checkCustomer(){
        BankApp.scan.nextLine();
        String input;
        System.out.println("Are you an existing customer? [Y: Yes; N: No]");
        input = BankApp.scan.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Enter Customer ID:");
            int id = BankApp.scan.nextInt();
            for (int i = 0; i < BankApp.customers.size(); i++) {
                if(BankApp.customers.get(i).getCustomerID()==id){
                    return BankApp.customers.get(i);
                }
            }
            System.out.println("There was no record of the ID. A new ID will be created");
            input="N";
            BankApp.scan.nextLine();
        }
        if (input.equalsIgnoreCase("N")) {
            Customer newCustomer;
            System.out.println("Enter your name: ");
            input = BankApp.scan.nextLine();
            if (input.length() == 0) {
                newCustomer = null;
            }
            newCustomer = new Customer(input);
            BankApp.customers.add(newCustomer);
            return newCustomer;
        }
            return null;
    }

    public boolean addAccountHolder(){
        if(second == null){
            //Bank.customer;
            second=checkCustomer();
            return true;
        }
        System.out.println("Can not add more than 2 account holders");
        return false;
    }

    public boolean updateAccount(Customer customer){
        if(customer != null){
            first=customer;
            return true;
        }
        return false;
    }

    public boolean updateAccount(Customer customer, int holder){
        if(customer != null && holder<=2&&holder>=1) {
            if (holder == 1) {
                first = customer;
            }
            if (holder == 2) {
                second = customer;
            }
            return true;
        }
        return false;
    }

    public Account deleteAccount() {
        System.out.println("Are you sure you want to delete your account?");
        BankApp.scan.nextLine();
        String input = BankApp.scan.nextLine();
        if(input.equalsIgnoreCase("Y")){
            System.out.println("Enter your Customer ID: ");
            int id = BankApp.scan.nextInt();
            for (int i = 0; i < BankApp.deposits.size(); i++) {
                if(BankApp.deposits.get(i).getFirst().getCustomerID() == id){
                    System.out.println("Do you want to delete your savings account with AccID: " +
                            BankApp.deposits.get(i).getAccountID()+ "?");
                    String in = BankApp.scan.nextLine();
                    BankApp.scan.nextLine();
                    if(in.equalsIgnoreCase("Y")){
                        return BankApp.deposits.remove(i);
                    }
                }
            }
        }
        if(input.equalsIgnoreCase("N")){
            System.out.println("No accounts were deleted");
        }
        return null;
    }

    public void resetWithdrawals(){
        withdrawals=0;
    }

    //methods that must be added in future classes that extend this one.
    public abstract boolean withdrawMoney(int integer);
    public abstract int calcInterest();
    public abstract boolean addInterest();

}
