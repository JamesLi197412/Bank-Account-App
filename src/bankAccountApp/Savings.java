package bankAccountApp;

public class Savings extends Account {
    // List properties specific to the Saving account
    int safetyDepositBoxID;
    int safetyDepositBoxKey;

    // Constructor to initialize settings for the saving properties
    public Savings(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        System.out.println("Account Number " + accountNumber);
        System.out.println("Saving Account");
    }

    // Common methods for the saving account


}
