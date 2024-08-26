package main.java.pojo;

public abstract class Account {
    // list common properties
    private String name;
    private String password;
    private String cardID;
    private double balance;

    // Non-parameters
    public Account(){}

    // Constructor to set base properties and initialize the account
    public Account(String name, String password, String cardID, double initDeposit){
        this.name = name;
        this.cardID = cardID;
        this.balance = initDeposit;
        this.password = password;

    }

    // Getters & Setters.
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCardID() {
        return cardID;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
