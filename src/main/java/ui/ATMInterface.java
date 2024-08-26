package main.java.ui;

import main.java.pojo.ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface {
    private JFrame frame;
    private JTextField pinField;
    private JTextArea screen;
    private JButton loginButton, withdrawButton, balanceButton, cancelButton;
    private ATM atm;

    public ATMInterface() {
        atm = new ATM();
    }

    public void createAndShowGUI() {
        // Create the frame
        frame = new JFrame("Welcome to Use Bank of XXX System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // PIN input
        pinField = new JTextField(4);
        JPanel pinPanel = new JPanel();
        pinPanel.add(new JLabel("Enter PIN:"));
        pinPanel.add(pinField);

        // Text Area for screen output
        screen = new JTextArea();
        screen.setEditable(false);
        panel.add(pinPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(screen), BorderLayout.CENTER);

        // Buttons
        loginButton = new JButton("Login");
        withdrawButton = new JButton("Withdraw");
        balanceButton = new JButton("Balance");
        cancelButton = new JButton("Cancel");

        // Adding action listeners to buttons
        loginButton.addActionListener(new LoginAction());
        withdrawButton.addActionListener(new WithdrawAction());
        balanceButton.addActionListener(new BalanceAction());
        cancelButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class LoginAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String pin = pinField.getText();
            if (atm.login(pin)) {
                screen.setText("Login successful. You can now access your account.");
                withdrawButton.setEnabled(true);
                balanceButton.setEnabled(true);
            } else {
                screen.setText("Invalid PIN. Please try again.");
            }
        }
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

    private class BalanceAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            screen.append("\nCurrent balance: $" + atm.getBalance());
        }
    }
}