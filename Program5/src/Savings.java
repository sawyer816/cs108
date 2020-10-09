/**
 * Concrete Class: Checking
 * This class creates a saving account that can be used to update an account
 *  if withdrawals or deposits are made.
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section X (1 or 3)
 */
public class Savings extends Deposit {
    private final int interestRate = 4;
    public Savings(){
        super();
    }
    @Override
    public boolean withdrawMoney(int integer) {
        if(integer<0) {
            System.out.println("Invalid Amount");
            return false;
        }
        else if(getWithdrawals()==3){
            System.out.println("Withdrawals Limit Exceeded");
        }else if(integer> getAccountBalance()){
            System.out.println("Not Enough Balance");
            return false;
        }
        else{
            setAccountBalance(getAccountBalance()-integer);
            setWithdrawals(getWithdrawals()+1);
            System.out.println("Updated Balance: " + getAccountBalance());
            System.out.println("Remaining Withdrawals: " + (3- getWithdrawals()));
            return true;
        }
        return false;
    }

    @Override
    public int calcInterest() {
        return ((getAccountBalance()*interestRate)/100)/12;
    }

    @Override
    public boolean addInterest() {
        if(BankApp.getBank().isFlag()){
            setAccountBalance(calcInterest()+getAccountBalance());
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return  "Savings | Balance: " + getAccountBalance() + "| Withdrawals: " + getWithdrawals()
                + " | Potential Interest:"  + calcInterest();
    }
}
