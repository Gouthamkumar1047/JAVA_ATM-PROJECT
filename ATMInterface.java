import java.util.Scanner;

class ATMInterface {
	int balance;
	String transac;
	String username;
	int userpin;

	public ATMInterface(String username, int pin) {
		
		this.username = username;
		this.userpin = pin;
	}

	public void deposit(int amount) {
		if (amount > 0) {
			balance = balance + amount;
			transac = "\nadded: " + amount + ".\n";
		}
		System.out.println( amount + " successfully deposited in your account\n");

		
	}

	public void withdraw(int amount) {
		if (amount <= balance) {
			balance = balance - amount;
			transac += "\nYou withdraw " + amount + ".\n";
			System.out.println(amount + " withdraw Successfully\n");
		} else {
			System.out.println("\nYou have not sufficient amount to withdraw " + amount);
		}

		System.out.println("\nYour current balance is " + balance);
	}

	public void transacHistory() {
		if (transac != null) {
			System.out.println("\nAccount history\n");
			System.out.println(transac);
		} else {
			System.out.println("\nNo transaction occur");
		}
	}

	public void transfer(int amount, String name) {
		if (amount > 0 && name != null) {
			balance = balance - amount;
			System.out.println("\nYou have tranfered " + amount + " to " + name);
		}
		System.out.println("\nYour current balance is " + balance);
		transac += "\nYou have transfered " + amount + " to " + name + ".\n";
	}

	public void displayDetails() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome " + username);
		System.out.println("\n");

		System.out.println("1. Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Transaction History");
		System.out.println("5. Transfer");
		System.out.println("6. Quit");

		do {
			System.out.println("============================================");
			System.out.println("Enter an option");
			System.out.println("============================================");
			choice= sc.nextInt();
			System.out.println("\n");

			switch (choice) {

			case 1:
				System.out.println("1. Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transaction History");
				System.out.println("5. Transfer");
				System.out.println("6. Quit");
				System.out.println("---------------------------------------");
				System.out.println(" Balance = " + balance);
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;

			case 2:
				System.out.println("1. Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transaction History");
				System.out.println("5. Transfer");
				System.out.println("6. Quit");
				System.out.println("---------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("---------------------------------------");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;

			case 3:
				System.out.println("1. Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transaction History");
				System.out.println("5. Transfer");
				System.out.println("6. Quit");
				System.out.println("----------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("----------------------------------------");
				int amount1 = sc.nextInt();
				withdraw(amount1);
				System.out.println("\n");
				break;

			case 4:
				System.out.println("1. Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transaction History");
				System.out.println("5. Transfer");
				System.out.println("6. Quit");
				System.out.println("---------------------------------------");
				transacHistory();
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;

			case 5:
				System.out.println("1. Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transaction History");
				System.out.println("5. Transfer");
				System.out.println("6. Quit");
				System.out.println("----------------------------------------");
				System.out.println("\nEnter the details to transfer the amount: ");
				System.out.println("---------------------------------------");
				System.out.println("\nEnter the amount");
				int amount2 = sc.nextInt();
				System.out.println("\nEnter the name of receiver");
				String recname = sc.next();
				transfer(amount2, recname);
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;

			case 6:
				System.out.println("*");
				break;

			default:
				System.out.println("Invalid option!!..Please enter again");
				break;

			}
		} while (choice != 6);

		System.out.println("Thank you for using our services");
		System.out.println("*");

		sc.close();
	}

	


}

public class ATM {

	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);

		boolean flag=true;
		while (flag) {
			
			System.out.println("\nEnter Your Name: \n");
			String username = scanner1.nextLine();

			if (username == "") {
				System.out.print("\nError! Please Try Again\n");
			} else {
				System.out.println("\nEnter Your Pin " + username + " : ");
				int pin = scanner1.nextInt();
				int len = (int) (Math.log10(pin) + 1);
				if (len == 4) {
					ATMInterface app = new ATMInterface(username, pin);
					app.displayDetails();
				} else {
					System.out.println("\nError!Please enter the right pin number\n");
				}

			}

		}
				scanner1.close();
	}

}
