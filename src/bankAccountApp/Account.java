package bankAccountApp;

public abstract class Account {
    // list common properties
    private String name;
    private String password;
    private String sSN;
    private double balance;
    String accountNumber;
    static int index= 10000;
    private double initDeposit;

    // Non-parameters
    public Account(){}

    // Constructor to set base properties and initialize the account
    public Account(String name, String password, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        this.password = password;

        // Generate new Account
        index ++;
        this.accountNumber = setAccountNumber();

    }



    // Generate Account Number for user by types of Account
    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }


    // Common method for ATM operation
    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public void changePassword(String newPassword){
        password = newPassword;

    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + "to" + toWhere);
    }






}
