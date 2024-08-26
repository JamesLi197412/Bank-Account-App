package main.java.ui;// Screen.java
// Represents the screen of the ATM
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Screen extends JFrame
{
    public JFrame frame;
    public static JTextField Inputfield1, Inputfield2, Inputfield3, Inputfield4, Inputfield5, Inputfield6;
    public JLabel messageJLabel,messageJLabel2,messageJLabel3,messageJLabel4,messageJLabel5,messageJLabel8,messageJLabel9,messageJLabel10;
    public JButton loginbutton,button1,button2,button3,button4,button5,exitbutton,Exit;
    public int accnum = 0;
    public int PIN = 0;
    public JLabel messageJLabel7,messageJLabel6;


    //create the login GUI
    public void createlogin() {
        frame = new JFrame("Welcome to the Bank of XXX");
        messageJLabel4 = new JLabel("Insert your credit/debit card then                             ");
        messageJLabel = new JLabel("  Enter your PIN number:    ");



        Inputfield1 = new JTextField( 10 );

        messageJLabel2 = new JLabel(" 														                  ");
        Inputfield2 = new JTextField( 10 );
        loginbutton = new JButton("Login");
        exitbutton = new JButton("exit");
        messageJLabel3 = new JLabel("");

        frame.setLayout( new FlowLayout() ); // set layout
        frame.add(messageJLabel4);
        frame.add( messageJLabel ); // add first prompt

        frame.add( Inputfield2 );
        frame.add( messageJLabel2 );
        frame.add(loginbutton);
        // add message label
        frame.add(messageJLabel3);
        Inputfield2.setEditable(false);
        frame.repaint();
        setVisible(true);


    }
    //create the main menu GUI
    public void createmenu(){
        frame.getContentPane().removeAll();
        messageJLabel = new JLabel("Welcome");
        messageJLabel2 = new JLabel("1 - Balance");
        messageJLabel3 = new JLabel("2 - Withdrawal");
        messageJLabel4 = new JLabel("3 - Deposit");
        messageJLabel5 = new JLabel("4 - Exit");
        frame.setLayout( new FlowLayout() ); // set layout
        frame.add(messageJLabel);
        frame.add( messageJLabel2 ); // add first prompt
        frame.add( messageJLabel3 ); // add second prompt
        frame.add( messageJLabel4 ); // add message label
        frame.add( messageJLabel5 );
        frame.repaint();
    }

    //create the Balance GUI
    public void creatBalanceGUI(){
        frame.getContentPane().removeAll();
        messageJLabel = new JLabel("Balance Information:        ");
        messageJLabel2 = new JLabel("Avaliable Balance:");
        messageJLabel3 = new JLabel("Total Balance:");
        Exit = new JButton("Back");
        frame.setLayout( new FlowLayout() );
        frame.add(messageJLabel);
        frame.add(messageJLabel2);
        frame.add(messageJLabel3);
        frame.add(Exit);
        frame.repaint();
    }

    //Create the withdrawal GUI
    public void createWithdrawGUI(){
        frame.getContentPane().removeAll();
        frame.revalidate();
        messageJLabel = new JLabel("Withdraw Menu:                       ");
        messageJLabel2 = new JLabel("1 - $20 ");
        messageJLabel3 = new JLabel("2 - $40 ");
        messageJLabel4 = new JLabel("3 - $60 ");
        messageJLabel5 = new JLabel("4 - $100 ");
        messageJLabel6 = new JLabel("5 - $200 ");
        messageJLabel7 = new JLabel("            Choose an amount to withdraw");
        Exit = new JButton("Cancel");
        frame.setLayout( new FlowLayout() );
        frame.add(messageJLabel);
        frame.add(messageJLabel2);
        frame.add(messageJLabel3);
        frame.add(messageJLabel4);
        frame.add(messageJLabel5);
        frame.add(messageJLabel6);
        frame.add(Exit);
        frame.add(messageJLabel7);
        frame.repaint();

    }

    //Create the Deposit GUI
    public void CreateDepositGUI(){
        frame.getContentPane().removeAll();
        messageJLabel2 = new JLabel("Please follow instructions to place money into right place");
        messageJLabel3 = new JLabel("");
        Inputfield2 = new JTextField(10);
        Inputfield2.setEditable(false);
        button1 = new JButton("Deposit");
        Exit = new JButton("Cancel");

        frame.add(messageJLabel3);
        frame.add(Inputfield2);
        frame.add(Exit);
        frame.repaint();
    }


    public void setGUI(){
        repaint();
    }

    //Create the admin page GUI
    public void createAdminpage(){
        messageJLabel = new JLabel("View Users:");
        messageJLabel2 = new JLabel("Account number:");
        messageJLabel3 = new JLabel("Avaliable Balance:");
        messageJLabel4 = new JLabel("Total Balance:");
        messageJLabel5 = new JLabel("________________________________________________");
        button1 = new JButton("Next");
        button4 = new JButton("Previous");
        Exit = new JButton("Back");
        Inputfield1 = new JTextField(10);
        Inputfield2 = new JTextField(10);
        Inputfield3 = new JTextField(10);
        Inputfield4 = new JTextField(10);
        frame.setLayout( new FlowLayout() );
        messageJLabel6 = new JLabel("Add Account: ");
        messageJLabel7 = new JLabel("User name: ");
        frame.add(messageJLabel);
        messageJLabel8 = new JLabel("          Account number: ");
        frame.add(messageJLabel2);
        messageJLabel10 = new JLabel("                                       PIN: ");

        messageJLabel9 = new JLabel("              Balance number: ");
        button2 = new JButton("Add");
        button3 = new JButton("Delete");


        frame.add(messageJLabel3);
        frame.add(messageJLabel4);
        frame.add(button4);
        frame.add(button1);
        frame.add(button3);
        frame.add(messageJLabel5);
        frame.add(messageJLabel6);
        frame.add(messageJLabel7);
        frame.add(Inputfield1);
        frame.add(messageJLabel8);
        frame.add(Inputfield2);
        frame.add(messageJLabel10);
        frame.add(Inputfield4);
        frame.add(messageJLabel9);
        frame.add(Inputfield3);

        frame.add(button2);

        frame.add(Exit);
        frame.repaint();
    }


} // end class Screen


