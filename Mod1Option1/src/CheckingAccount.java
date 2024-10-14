import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Scanner;

class CheckingAccount extends BankAccount {
    // Variables
    protected int interestRate;
    protected String firstName = getFirstName();
    protected String lastName = getLastName();
    protected int accountID = getAccountID();
    protected double balance = getBalance();

    // Decimal Format
    private static final DecimalFormat df = new DecimalFormat("#.00");
    
    // Methods
    public void processWithdrawal(double amountWithdrawn) {
        withdrawal(amountWithdrawn);
        if (this.balance < 0) {
            this.balance -= 30;
            System.out.println("A $30 overdraft fee has been applied.");
            System.out.println("Your new balance is $" + df.format(this.balance));
        } else {
            System.out.println("New balance: $" + df.format(this.balance));
        }
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Intrest rate: " + interestRate + "%");
    }

    // Main
    public static void main(String[] args) {
        // Variables
        boolean mainLoop = true;
        int choice;
        
        // Create an account object
        CheckingAccount myAccount = new CheckingAccount();

        //Scanner
        Scanner input = new Scanner(System.in);

        //Get name and set account ID
        System.out.println("First Name: "); // First Name
        myAccount.firstName = input.nextLine();
        System.out.println("Last Name: "); // Last Name
        myAccount.lastName = input.nextLine();
        myAccount.accountID = (int)(Math.random() * 1000) + 1; // Gives random account number
        System.out.println("Your new account ID: " + myAccount.accountID);


        //Loop user for inputs
        while(mainLoop == true) {
            System.out.println("Navigation Menu ");
            System.out.println("1 - Withdraw");
            System.out.println("2 - Deposit");
            System.out.println("3 - View Account info");
            System.out.println("4 - Exit Program");
            System.out.println("Please enter your choice:  ");

            choice = input.nextInt(); // Get input

            switch (choice) {
                case 1: // Withdraw
                System.out.println("Amount Withdrawing: ");
                    double amountWithdrawn = input.nextDouble();
                    input.nextLine(); // Prevent overflow
                    myAccount.processWithdrawal(amountWithdrawn);
                    break;
                case 2: // Deposit
                    System.out.println("Amount Deposting: ");
                    double amountAdded = input.nextDouble();
                    input.nextLine(); // Prevent overflow
                    myAccount.deposit(amountAdded);
                    break;
                case 3: // View info
                    myAccount.displayAccount();
                    break;
                case 4: // Exit Program
                    input.close();
                    System.out.println("Exiting Program");
                    System.exit(0);
                default:
                    System.out.println("Not a valid menu option. Please try again.");
                    break;
            }
        }
    }
}