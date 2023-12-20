package bankAccountApp;

import java.util.List;

public class BankAccoutApp {
    public static void main(String[] args) {

        String file = "";

        Checking checkacc1 = new Checking("name","123456789",100);

        Savings savacc1 = new Savings("Rich Lowe","1223123124134", 100);

        // Read a CSV File then create new accounts based on that data
        List<String[]> newAccountList =  utilities.CSV.read(file);
        for (String[] accountHolder:newAccountList){
            System.out.println("New Account");
            System.out.println(accountHolder[0]);
            System.out.println(accountHolder[1]);
        }

    }
}
