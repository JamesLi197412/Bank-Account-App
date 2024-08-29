package main.java.ui;

import main.java.config.MysqlConfig;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class ATMInterface extends JFrame{
    private JFrame frame;
    private JPanel loginPanel,mainServicePanel,exitPanel,transferPanel,panels;
    private JSplitPane withdrawlPanel,balancePanel,savePanel;
    private CardLayout cardLayout;
    private JButton loginButton, exitButton,transferButton, saveButton, withdrawButton, balanceButton,returnButton;
    private JLabel userNameLabel, passWordLabel,balanceLabel;
    private JTextField userTextField;
    public JTextField withdrawTextField;
    private JPasswordField passWordField;
    private static int currentValue = 0;

    private Connection connection;
    private Statement stmt;
    private ResultSet resultSet;
    private String account_id;
    public ArrayList<Double> balanceValues = new ArrayList<Double>(10);

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int TEXTAREA_ROWS = 139;
    public static final int TEXTAREA_COLUMNS = 20;

    public static final int BUTTON_ROWS = 138;
    public static final int BUTTON_COLUMNS = 20;

    public ATMInterface(){
        cardLayout = new CardLayout();
        panels = new JPanel(cardLayout);

        loginPanel = this.login();
        mainServicePanel = this.MainServices();
        withdrawlPanel = this.withdrawal();
        balancePanel = this.balance();
        savePanel = this.save();
        transferPanel = this.transfer();
        exitPanel = this.exit();

        panels.add(loginPanel, "Login");
        panels.add(mainServicePanel, "Main Services");
        panels.add(withdrawlPanel, "Withdrawal");
        panels.add(balancePanel, "Balance");
        panels.add(savePanel, "Save");
        panels.add(transferPanel, "Transfer");
        panels.add(exitPanel, "Exit");

        frame.add(panels);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel login(){
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Generate Frame
        frame = new JFrame("Welcome to the Bank of XXX");
        frame.setSize(500 ,350);

        // Define Panel
        loginPanel = new JPanel();
        setContentPane(loginPanel);
        setLayout(null);

        // User Label
        userNameLabel = new JLabel("Please Enter Account Number: ");
        userNameLabel.setBounds(60,60,260,20);
        loginPanel.add(userNameLabel);

        // User text
        userTextField = new JTextField(12);
        userTextField.setBounds(280,60,180,20);
        loginPanel.add(userTextField);

        // Password Label
        passWordLabel = new JLabel("Pin Number：");
        passWordLabel.setBounds(60,100,260,20);
        loginPanel.add(passWordLabel);

        // Password Field
        passWordField = new JPasswordField(12);
        passWordField.setBounds(280,100,180,20);
        loginPanel.add(passWordField);

        // Login in Button
        loginButton = new JButton("Login");
        loginButton.setBounds(115,150,100,30);
        loginPanel.add(loginButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(240,150,100,30);
        loginPanel.add(exitButton);

        // Adding function to buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountid = userTextField.getText();
                String password = passWordField.getText();

                if (accountverify(accountid,password)){
                    balanceCheck(accountid);
                    cardLayout.show(panels, "Main Services");
                }else{
                    JOptionPane.showMessageDialog(null, "Account Not Found");
                    userTextField.setText("");
                    passWordField.setText("");
                }

            }
        });
        exitButton.addActionListener(new ATMInterface.exitButton());

        return loginPanel;
    }

    public boolean accountverify(String accountid, String password){
        // account verification
        MysqlConfig config = new MysqlConfig();
        String sql = "SELECT * FROM bank.accounts";
        boolean access = false;
        try{
            connection = config.loadProperties();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                if(accountid.equals(resultSet.getString("account_id")) && password.equals(resultSet.getString("pin_number"))){
                    access = true;
                    account_id = resultSet.getString("account_id").toString();

                    double money = Double.parseDouble(resultSet.getString("balance"));
                    balanceValues.add(money);

                    return true;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return access;
    }

    private class exitButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close the frame when the button is clikced
            frame.dispose(); // Close the window
        }
    }

    public JPanel MainServices() {
        mainServicePanel = new JPanel(new GridLayout(3,2,5,5));
        setTitle("Main Services");

        // Buttons
        withdrawButton = new JButton("Withdraw");
        saveButton = new JButton("Save");
        balanceButton = new JButton("Balance");
        transferButton = new JButton("Transfer");
        exitButton = new JButton("Exit");

        // Adding action listeners to buttons
        // Adding function to buttons
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Withdrawal");
            }
        });
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceCheck(account_id);
                cardLayout.show(panels, "Balance");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Save");
            }
        });

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels,"Transfer");
            }
        });

        exitButton.addActionListener(new ATMInterface.exitButton());

        mainServicePanel.add(withdrawButton);
        mainServicePanel.add(saveButton);
        mainServicePanel.add(balanceButton);
        mainServicePanel.add(transferButton);
        mainServicePanel.add(exitButton);

        return mainServicePanel;
    }

    public JSplitPane withdrawal(){
        JSplitPane hsplitPane = new JSplitPane();
        JSplitPane vsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        JLabel message = new JLabel("Amount to withdraw");
        message.setBounds(10,10,200,30);
        message.setFont(new FontUIResource("Serif", FontUIResource.PLAIN,18));
        message.setForeground(ColorUIResource.black);
        hsplitPane.setLeftComponent(message);

        withdrawTextField = new JTextField("Current Value: " + String.valueOf(currentValue));
        withdrawTextField.setBounds(215,120,170,50);
        withdrawTextField.setFont(new FontUIResource("Serif", FontUIResource.PLAIN, 12));
        vsplitPane.setTopComponent(withdrawTextField);

        // Set up buttons
        ArrayList<String> values = new ArrayList(Arrays.asList("20", "50", "100", "500"));
        JPanel buttonPanel = new JPanel(new GridLayout(3,2,10,10));
        for(String increment : values){
            JButton button = new JButton(increment);
            button.addActionListener(new IncrementAction(Integer.parseInt(increment)));
            buttonPanel.add(button);
        }
        JButton returnButton = new JButton("Back to main menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Main Services");
                currentValue = 0;
                withdrawTextField.setText("Current Value: " + String.valueOf(currentValue));
            }
        });

        JButton sureButton = new JButton("Sure");
        sureButton.addActionListener(new ActionListener() {
            String[] options = {"Yes", "No"};
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showOptionDialog(frame, "Are you sure to withdraw $" + String.valueOf(currentValue),"Final Decision",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                System.out.println(x);
                if (x == 0){ // Indicate Yes
                    cardLayout.show(panels, "Balance");
                    double balanceValue = balanceValues.get(balanceValues.size()-1);
                    balanceValue = balanceValue - currentValue;
                    balanceValues.add(balanceValue);
                }

            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(sureButton);

        vsplitPane.setBottomComponent(buttonPanel);

        hsplitPane.setRightComponent(vsplitPane);
        hsplitPane.setDividerLocation(200);

        add(hsplitPane);


        return hsplitPane;
    }


    public class IncrementAction implements ActionListener{
        private int incrementValue;

        public IncrementAction(Integer incrementValue){
            this.incrementValue = incrementValue;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            currentValue += incrementValue;
            withdrawTextField.setText("Current Value: " + currentValue);
        }
    }

    public JPanel exit(){
        exitPanel = new JPanel();
        JLabel exitmessage = new JLabel("Thank you for using Bank of XXX Service");

        exitPanel.add(exitmessage, BorderLayout.CENTER);
        return exitPanel;
    }

    public JSplitPane balance(){
        JSplitPane vsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        double balanceValue = balanceValues.get(balanceValues.size()-1);
        balanceLabel = new JLabel("Your current Balance is: " + (balanceValue),SwingConstants.CENTER);
        balanceLabel.setBounds(60,60,220,30);
        vsplitPane.setTopComponent(balanceLabel);

        // Initialise two buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1,2,10,10));
        JButton returnButton = new JButton("Return to main menu");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(returnButton, BorderLayout.EAST);
        buttonPanel.add(exitButton, BorderLayout.WEST);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Main Services");
            }
        });
        vsplitPane.setDividerLocation(200);
        exitButton.addActionListener(new ATMInterface.exitButton());
        vsplitPane.setBottomComponent(buttonPanel);

        return vsplitPane;

    }

    public JSplitPane save(){
        JSplitPane vsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JLabel saveMessage = new JLabel("Please place cash into indicated place, then press the button Deposit",SwingConstants.CENTER);
        saveMessage.setBounds(60,60,220,30);
        vsplitPane.setTopComponent(saveMessage);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2,10,10));
        JButton returnButton = new JButton("Return to main menu");
        JButton depositButton = new JButton("Deposit");

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Main Services");
            }
        });

        depositButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Balance");
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(depositButton);
        vsplitPane.setBottomComponent(buttonPanel);
        vsplitPane.setDividerLocation(200);


        return vsplitPane;
    }

    public JPanel transfer(){
        transferPanel = new JPanel();
        // User Label
        JLabel targetLabel = new JLabel("Please Enter Target Account Number: ");
        targetLabel.setBounds(60,60,260,20);
        transferPanel.add(targetLabel);

        // User text
        JTextField targetTextField = new JTextField(12);
        targetTextField.setBounds(320,60,180,20);
        transferPanel.add(targetTextField);

        // Amount Label
        JLabel amountLabel = new JLabel("Amount to Transfer：");
        amountLabel.setBounds(60,100,260,20);
        transferPanel.add(amountLabel);

        // Amount Field
        JTextField amountField = new JTextField(12);
        amountField.setBounds(320,100,180,20);
        transferPanel.add(amountField);

        // Transfer in Button
        transferButton = new JButton("Transfer");
        transferButton.setBounds(115,150,100,30);
        transferPanel.add(transferButton);

        // Exit Button
        returnButton = new JButton("Back to main menu");
        returnButton.setBounds(240,150,100,30);
        transferPanel.add(returnButton);

        // Adding function to buttons
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panels, "Main Services");
            }
        });

        return transferPanel;
    }

    public void adjustbalance(String account_id, double amount) {
        MysqlConfig config = new MysqlConfig();
        String sql = "SELECT * FROM bank.accounts";
        try{
            connection = config.loadProperties();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                if(account_id.equals(resultSet.getString("account_id"))){
                    double balance = Double.parseDouble(resultSet.getString("balance"));
                    balance = balance + amount;

                    balanceValues.add(balance);

                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void balanceCheck(String account_id) {
        MysqlConfig config = new MysqlConfig();
        String sql = "SELECT * FROM bank.accounts";
        try{
            connection = config.loadProperties();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                if(account_id.equals(resultSet.getString("account_id"))){
                    double balance = Double.parseDouble(resultSet.getString("balance"));
                    balanceValues.add(balance);

                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }




}