package bankAccountApp;

public class Checking extends Account {
    // List properties specific to a Checking account
    private int debitCardNumber;
    private int debitCardPIN;


    // Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        System.out.println("NEW CHECKING ACCOUNT");
        System.out.println("Account Number:" + this.accountNumber);
        System.out.println("Name:" + name);
    }
    // List any method specific to the checking account
    public void showInfo(){
        System.out.println("Account Type: Checking");
    }
}
