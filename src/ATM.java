
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Russell Tan
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ATM self = new ATM();
        
        Account[] bankAccount = new Account[2]; // array of Account type
        
        bankAccount[0] = new Account("Russell Tan", 101);
        bankAccount[1] = new Account("Jim Carry", 102);

        bankAccount[0].setBalance(50);
        bankAccount[1].setBalance(1000);

        bankAccount[0].setAnnualInterestRate(5);
        bankAccount[1].setAnnualInterestRate(5);

        while (true) { // Always true so program won't stop

            Scanner account = new Scanner(System.in);
            System.out.print("Enter an account ID: ");

            int id;     // id of the account user wants to access

            try {
                id = account.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid Input");
                System.out.println();
                account.nextLine();         //catch and discard invalid input 
                continue;                  //retries the loop
            }
            System.out.println();

            Account acount;

            switch (id) {       // determines which account to access
                case 101:
                    acount = bankAccount[0];
                    break;
                case 102:
                    acount = bankAccount[1];
                    break;
                default:
                    System.out.println("Please enter a valid account number.");
                    System.out.println();
                    continue;
            }

            self.menu(acount); // calls the menu method
        }
    }// end of main method

    //allows transaction to be performed and check account info
    public void menu(Account acct) {

        while (true) {          // loops until user exits 
            System.out.println("Main Menu");
            System.out.println("1: Account Information");
            System.out.println("2: Withdraw");
            System.out.println("3: Deposist");
            System.out.println("4: Exit");
            System.out.println();

            Scanner choice = new Scanner(System.in);
            System.out.print("Choose what you would like to do: ");

            int pick; // users picks which action to take

            try {
                pick = choice.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid Input");
                System.out.println();
                choice.nextLine(); // catch and discarfd invalid input
                continue;           //  retries the input
            }

            if (pick == 4) {    // if 4 loop is broken and returns to main method 
                System.out.println();
                break;
            }

            switch (pick) { // determines which action user wants to take
                case 1: //views account info
                    System.out.println();
                    System.out.println("Customer: " + acct.getCustomerName());
                    System.out.printf("Account Balance: $%.2f\n", acct.getBalance());
                    acct.monthlyInterest();
                    System.out.println("Date/Time Created: " + acct.getDateCreated());
                    System.out.println();
                    break;
                case 2: //withdraws money from account
                    System.out.println();
                    Scanner withdraw = new Scanner(System.in);
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmmount = withdraw.nextDouble();
                    acct.withdraw(withdrawAmmount);
                    System.out.println();
                    break;
                case 3: // desposits money into the account
                    System.out.println();
                    Scanner desposit = new Scanner(System.in);
                    System.out.print("Enter the amount to desposit: ");
                    double despositAmount = desposit.nextDouble();
                    acct.deposit(despositAmount);
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid. Please enter a valid input.");
                    System.out.println();
            }
        } //end of the loop
    } // end of the menu method
}
