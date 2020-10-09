import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BankApp Class (Main File)
 * This is the main file that runs the entire bank application and includes
 * user input as well as arrays that store the accounts and customers in a bank
 * @author Sawyer Thompson
 * @date 03/25/20
 * CS 108 Section 1
 */
 
public class BankApp {
	static Bank bank = new Bank();
	static ArrayList<Deposit> deposits = new ArrayList<Deposit>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static Scanner scan = new Scanner(System.in);

	public static ArrayList<Deposit> getDeposits() {
		return deposits;
	}

	public static Bank getBank() {
		return bank;
	}

	public static void setDeposits(Deposit newer) {
		deposits.add(newer);
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(Customer customer) {
		customers.add(customer);
	}

	public static void main(String[] args) {
		System.out.println("The Local Union");
		int count = -1;
		while(count!=0) {
			printMenu();

			while (!scan.hasNextInt()) {
			scan.nextLine();
			}
			int num = scan.nextInt();
			while (num > 9 || num < 0) {
				System.out.println("Enter a relevant option:");
				num = scan.nextInt();
			}
			if (num == 1) {
				numOne();
			}
			if (num == 2) {
				numTwo();
			}
			if (num == 3) {
				numThree();
			}
			if (num == 4) {
				numFour();
			}
			if (num == 5) {
				numFive();
			}
			if (num == 6) {
				numSix();
			}
			if (num == 7) {
				numSeven();
			}
			if (num == 8) {
				numEight();
			}
			if (num == 9) {
				numNine();
			}
			if (num == 0) {
				System.out.println("Thanks for using the bank application");
				count = 0;
			}
		}
   }

   public static void numOne(){
	   enterAccount();
	   int num1 = scan.nextInt();
	   while (num1 > 2 || num1 < 0) {
		   System.out.println("Enter the type of account you wish to open:");
		   num1 = scan.nextInt();
	   }
	   if (num1 == 0){
		   System.out.println("Exiting to main menu");
	   }
	   if (num1 == 1) {
		   Checking check = new Checking();
		   deposits.add(check);
	   }
	   if (num1 == 2) {
		   Savings save = new Savings();
		   deposits.add(save);
	   }
   }

   public static void numTwo(){
	   int num2;
	   System.out.println("Enter your account ID: ");
	   num2 = scan.nextInt();
	   for(int i = 0; i < deposits.size(); i++) {
		   if(deposits.get(i).getAccountID()== num2){
			   if(deposits.get(i).addAccountHolder()){
				   System.out.println("For Account ID: " + deposits.get(i).getAccountID());
				   System.out.println("First Holder: " + deposits.get(i).getFirst().toString());
				   System.out.println("Second Holder: " + deposits.get(i).getSecond().toString());
			   }
		   }
	   }
   }

   public static void numThree(){
	   System.out.println("Enter your account ID: ");
	   int num3 = scan.nextInt();
	   for(int i=0; i<deposits.size(); i++) {
		   if (deposits.get(i).getAccountID() == num3) {
			   System.out.println("1. Deposit ");
			   System.out.println("2. Withdraw ");
			   System.out.println("0. Return to Main Menu ");
			   num3= scan.nextInt();
			   if (num3 == 1) {
				   System.out.println("Enter the amount you wish to deposit: ");
				   int deposit = scan.nextInt();
				   deposits.get(i).depositMoney(deposit);
			   }
			   else if (num3 == 2) {
				   System.out.println("Enter the amount you wish to withdraw: ");
				   int withdrawal = scan.nextInt();
				   deposits.get(i).withdrawMoney(withdrawal);
				   break;
			   }
			   else{
					   System.out.println("Exiting to main menu");
			   }
		   }
	   }
   }

   public static void numFour(){
	   System.out.println("Enter your account ID: ");
	   int num4 = scan.nextInt();
	   for (Deposit deposit : deposits) {
		   if (deposit.getAccountID() == num4) {
			   deposit.deleteAccount();
		   }
	   }
   }

	public static void numFive(){
		System.out.println("Enter your account ID: ");
		int num4 = scan.nextInt();
		for (Deposit deposit : deposits) {
			if (deposit.getAccountID() == num4) {
				System.out.println(deposit.toString());
			}
		}
	}

	public static void numSix(){
		System.out.println("Enter your customer ID: ");
		int num4 = scan.nextInt();
		for (Customer customer : customers) {
			if (customer.getCustomerID() == num4) {
				System.out.println(customer.toString());
			}
		}
	}

	public static void numSeven(){
		bank.endOfMonth();
		for (Deposit deposit : deposits) {
			deposit.addInterest();
			deposit.resetWithdrawals();
		}
	}

	public static void numEight(){
		bank.nextMonth();
		bank.setFlag(false);
	}

	public static void numNine(){
		System.out.println("Current Month: " + bank.getMonth());
		System.out.println("Month End Flag:" + bank.isFlag());
	}

   public static void printMenu() {
		System.out.println();
		System.out.println("1. Open a new account.");
		System.out.println("2. Add a second holder to an existing account.");
		System.out.println("3. Deposit/Withdraw");
		System.out.println("4. Delete a current account.");
		System.out.println("5. Print details about a account.");
		System.out.println("6. Print details about a customer.");
		System.out.println("7. Update to end month [reset withdrawals & add interest].");
		System.out.println("8. Update to next month.");
		System.out.println("9. Print details about month.");
		System.out.println("0. Exit");
		System.out.println();
		System.out.println("Enter a relevant option:");
	}

	public static void enterAccount(){
		System.out.println("1. Deposit Account: Checking");
		System.out.println("2. Deposit Account: Savings");
		System.out.println("0. Return to the main menu ");
		System.out.println("Enter the type of account you wish to open:");
	}
}