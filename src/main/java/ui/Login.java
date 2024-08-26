package main.java.ui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel northPanel,southPanel;
    private JButton loginButton, registerButton, exitButton;
    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Login Panel Components
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login(){
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        frame = new JFrame("Welcome to Bank of XXX");
        cardLayout = new CardLayout();

        northPanel = new JPanel(cardLayout);
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("Card ID:", SwingConstants.RIGHT));
        northPanel.add(usernameField);
        northPanel.add(new JLabel("Please Enter your Pin Number: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // add button to append text into the text area
        southPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        southPanel.add(insertButton);

        insertButton.addActionListener(event ->
                textArea.append("User name: " + usernameField.getText() +
                        "Password: " + new String(passwordField.getPassword()) + "\n"));

        add(southPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(northPanel,southPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
        pack();

    }

    public boolean accountverify(String username, String password){
        // account verification
        //Connection connection;
        return true;
    }
}
