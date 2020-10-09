/**
 * Concrete Class: Checking
 * This class creates a checking account that can be used to deposit or withdraw.
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section X (1 or 3)
 */
public class Checking extends Deposit{
    final int interestRate = 1;
    public Checking(){
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
            System.out.println("Updated Balance: " + getAccountBalance());
            setWithdrawals(getWithdrawals()+1);
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
        return  "Checking | Balance: " + getAccountBalance() + "| Withdrawals: " + getWithdrawals()
                + " | Potential Interest:"  + calcInterest();
    }
}