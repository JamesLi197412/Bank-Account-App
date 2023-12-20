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
    public void showInfo(){

        System.out.println("Accont Type: Savings");
        super.showInfo();
        System.out.println("Your Savings Account Features" +
                "\nSafety Deposit Box ID:" + safetyDepositBoxID +
                "\nSafety Deposit Box Key:" + safetyDepositBoxKey);
    }

    //
    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));

    }

    @Override
    public void setRate(){
        rate = getBaseRate() -0.25;
        System.out.println("Implement rate for Savings");
    }


}
