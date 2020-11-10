import java.util.Scanner;

public class BankAccount {
	String userName;
	String password;
	String newUserName;
	String newPassword;
	int balance;
	int previousTransaction;
	String customerName;
	int customerId = 1000;
	
	BankAccount() {
		enterInfo();
	}
	BankAccount(String name, String pwd) {
		newUserName = name;
		newPassword = pwd;
		enterInfo();
	}
	
	void startMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello, " + userName + "\n");
		while(true) {
			System.out.println("Please choose an option: ");
			System.out.println("1 - Check balance"
					+ "\n2 - Check Acct info	"
					+ "\n3 - Deposit funds	"
					+ "\n4 - Withdraw funds	"
					+ "\n5 - Get Previous Transaction	"
					+ "\n6 - Exit			");
			int ans = scan.nextInt();
			switch(ans) {
			  case 1:
				  	checkBalance();
				  	break;
			  case 2:
				  	checkAcctInfo();
				  	break;
			  case 3:
				  	deposit();
				  	break;
			  case 4:
				  	withdraw();
				    break;
			  case 5:
				  	getPreviousTransaction();
				    break;
			  case 6:
				  	System.out.println("Logged out.");
				    System.exit(0);
				    break;
			  default:
			    // code block
			 } 
		}
		
	}
	void enterInfo() {
		int login;
		Scanner scan = new Scanner(System.in);
			System.out.println("Welcome!");
			while(true) {
			System.out.println("Press 1 to login, 2 to create new account or 3 to exit: ");
			login = scan.nextInt();
			if(login == 1) {
				System.out.println("Please enter username and password.");
				userName = scan.next();
				password = scan.next();
				if(userName.equalsIgnoreCase("JP7") && password.equalsIgnoreCase("bears2020")) {
					startMenu();
				}
				else if(userName.equalsIgnoreCase(newUserName) && password.equalsIgnoreCase(newPassword)) {
					startMenu();
				}
				else  {
					System.out.println("Invalid info. Try again.");
				}
				
			}
			else if(login == 2) {
				createAcct();
			}
			else if(login == 3) {
				System.out.println("Exiting....");
				System.out.println("Done.");
				System.exit(0);
			}
			
		}
	}
	
	void createAcct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Create a username: ");
		newUserName = scan.next();
		System.out.println("Create a password: ");
		newPassword = scan.next();
		BankAccount acct = new BankAccount(newUserName,newPassword);
		System.out.println("New Account created. "
				+ "\nUsername = " + acct.newUserName
				+ "\nPassword = " + acct.newPassword);
		balance = 0;
		customerId++;
		
	}
	void deposit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter amount to deposit: ");
		int amt = scan.nextInt();
		if(amt > 0 && amt < 10000) {
			balance += amt;
			previousTransaction = amt;
			System.out.println("$" + amt + " has been deposited. Thank you.");
		}
		else if (amt < 0 || amt == 0){
			System.out.println("Error. Invalid dollar amount entered.");
		}
		else {
			System.out.println("Deposit amount exceeds maximum dollar amount.");
		}
	}
	void withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter amount to withdraw: ");
		int withDrawAmt = scan.nextInt();
		if(withDrawAmt > balance) {
			System.out.println("Insufficient funds.");
		}
		else {
			balance -= withDrawAmt;
			previousTransaction = -withDrawAmt;
			System.out.println("$" + withDrawAmt + " has been withdrawn. Thank you.");
		}
	}
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: $"+ previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: $" + Math.abs(previousTransaction));
		}
		else
			System.out.println("No transaction occurred.");
	}
	
	void checkAcctInfo() {
		System.out.println("Account name: " + customerName + "\nAccount ID: " + customerId + "\nBalance: $"+ balance);
	}
	void checkBalance(){
		System.out.println("Balance is: $" + balance);
	}
	void setUserName(String newUserName) {
		this.userName = newUserName;
	}
	void setPassword(String newPassword) {
		this.password = newPassword;
	}
	String checkPassword() {
		return password;
	}
	String checkUserName() {
		return userName;
	}
}

