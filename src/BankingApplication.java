/*
 * Simple Banking application class uses BankAccount class ...
 * ..to create user account, check balance, deposit and withdraw funds.
 * Ask for username and password and match against given username and password to login.
 * If username and password are not recognized, let user know.
 * Login and view menu. Keep performing menu tasks or press 5 to exit while logged in.
 * 
 * 1 - Check balance
 * 2 - Check Acct info
 * 3 - Deposit funds
 * 4 - Withdraw funds
 * 5 - Exit
 * 
 */

public class BankingApplication  {
	public static void main(String[] args) {
		startApplication();
	}
	static void startApplication() {
		int x = 1;
		while(x != 0) {
			BankAccount acct = new BankAccount();
		}
	}
}
