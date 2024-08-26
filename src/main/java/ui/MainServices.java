package main.java.ui;

import main.java.pojo.ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainServices extends JFrame {
    private JFrame frame;
    private JTextArea screen;
    private JButton transferButton, saveButton, withdrawButton, balanceButton, exitButton;
    private ATM atm;

    public MainServices(ATM atm) {
        setTitle("Main Services");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Buttons
        withdrawButton = new JButton("Withdraw");
        saveButton = new JButton("Save");
        balanceButton = new JButton("Balance");
        transferButton = new JButton("Transfer");
        exitButton = new JButton("Exist");

        // Adding action listeners to buttons
        withdrawButton.addActionListener(new MainServices.WithdrawAction());
        balanceButton.addActionListener(new MainServices.BalanceAction());
        saveButton.addActionListener(new MainServices.SaveAction());
        //transferButton.addActionListener(new MainServices());
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(withdrawButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(saveButton);

        setVisible(true);

    }


    private class WithdrawAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
            try {
                double amount = Double.parseDouble(amountStr);
                if (atm.withdraw(amount)) {
                    screen.append("\nWithdrawal successful. New balance: $" + atm.getBalance());
                } else {
                    screen.append("\nInsufficient funds.");
                }
            } catch (NumberFormatException ex) {
                screen.append("\nInvalid amount entered.");
            }
        }
    }

    private class SaveAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
            double amount = Double.parseDouble(amountStr);

        }
    }

    private class BalanceAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            screen.append("\nCurrent balance: $" + atm.getBalance());
        }
    }

}
