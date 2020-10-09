/**
 * Interface: Account
 * This class sets up variables that will be implemented by the deposit class.
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section 1
 */
public interface Account{
    public boolean addAccountHolder();
    public boolean updateAccount(Customer customer);
    public boolean updateAccount(Customer customer, int integer);
    public Account deleteAccount();
    public int getAccountID();
}