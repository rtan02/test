
import java.util.Date;

/**
 *
 * @author Russell Tan
 */
public class Account {

    private String _customerName;                       // Customer's name 
    private int _id;                                    // Id of the Customer
    private double _balance;                            // Bank Balnace 
    private double _annualInterestRate;                 // Interest rate of the bank account
    private final Date _dateCreated = new Date();       // Date the account is created

    //Constructor with two arguments
    public Account(String customerName, int id) {
        _customerName = customerName;
        _id = id;
    }

    // getter/setter for Customer Name
    public String getCustomerName() {
        return _customerName;
    }

    public void setCustomerName(String name) {
        _customerName = name;
    }

    // getter/setter for Id
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    // getter/setter for Balance 
    public double getBalance() {
        return _balance;
    }

    public void setBalance(double balance) {
        _balance = balance;
    }

    // getter/setter for Annual Interest Rate
    public double getAnnualInterestRate() {
        return _annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        _annualInterestRate = annualInterestRate;
    }

    // getter for Date Created
    public Date getDateCreated() {
        return _dateCreated;
    }

    // deposits money into the bank account 
    public void deposit(double deposit) {
        _balance += deposit;
    }

    // withdraws money from the bank account 
    public void withdraw(double withdraw) {
        _balance -= withdraw;
    }

    // calculates interest earned that month
    public void monthlyInterest() {
        double interest = _balance * ((_annualInterestRate / 12) / 100);
        System.out.printf("Monthly interest earned $%.2f\n", interest);
    }
}
