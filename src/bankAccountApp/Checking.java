package bankAccountApp;

public class Checking extends Account {
    // List properties specific to a Checking account
    int debitCardNumber;
    int debitCardPIN;


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
        super.showInfo();
        System.out.println("Account Type: Checking");
        System.out.println("Your Savings Account Features" +
                "\nSafety Deposit Box ID:" + debitCardNumber +
                "\nSafety Deposit Box Key:" + debitCardPIN);    }

    private void setDebitCard(){
        debitCardNumber =(int) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));
    }
    @Override
    public void setRate(){
        rate = getBaseRate() * 0.15;
        System.out.println("Implement rate for Checking");
    }
}
