package bankAccountApp;

public abstract class Account implements iRate{
    // list common properties for saving and checking accounts
    private String name;
    private String sSN;
    private double balance;
    String accountNumber;
    static int index= 10000;
    double rate;
    private double initDeposit;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        System.out.println("New Account Created");


        // Generate new Account
        index ++;
        this.accountNumber = setAccountNumber();
        //System.out.println("Account Number " + this.accountNumber);

        System.out.println(getBaseRate());

        setRate();
    }

    // Common Methods
    public abstract void setRate();

    // Generate Account Number for user by types of Account
    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void showInfo(){
        System.out.println("Print everything here");
    }

    // List common methods
    public void deposit(double amount){
        balance = balance + amount;
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + "to" + "toWhere");
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your current Balance: " + balance);
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interests: ");
    }

}
