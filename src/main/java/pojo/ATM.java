package main.pojo;

public class ATM {
    private double balance = 1000.00; // Sample initial balance
    private String correctPin = "1234"; // Sample PIN

    public boolean login(String pin) {
        return correctPin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public String setnewPassword(String newPassword){
        // Check if the new password is null or not
        return newPassword;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}