import java.text.DecimalFormat;

public class BankAccount {
    // Variables
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Decimal Format
    private static final DecimalFormat df = new DecimalFormat("#.00");

    // Setters
    protected void setFirstName(String firstName) {this.firstName = firstName;}
    protected void setLastName(String lastName) {this.lastName = lastName;}
    protected void setAccountID(int accountID) {this.accountID = accountID;}
    
    // Getters
    protected String getFirstName() {return firstName;}
    protected String getLastName() {return lastName;}
    protected int getAccountID() {return accountID;}
    protected double getBalance() {return balance;}
    
    // Methods
    public void constructor() { // Sets balance to 0
        this.balance = 0;
    }

    public void deposit(double amountAdded) { // Adds an amount to existing balance
        this.balance += amountAdded;
        System.out.println("New balance: $" + df.format(balance));
    }

    public void withdrawal(double amountRemoved) { // Removes an amount from the existing balance
        this.balance -= amountRemoved;
    }

    public void accountSummary() {
        System.out.println("Account ID: " + accountID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Balance: $" + df.format(balance));
    }

}
