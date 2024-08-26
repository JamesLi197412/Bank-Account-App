package main;

import main.java.config.MysqlConfig;
import main.java.ui.ATMInterface;
import main.java.ui.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMSimulation {
    public static void main(String[] args) {
        // Refernece: https://github.com/Nishith-Savla/Banking-Application/tree/main/src/app
        //SwingUtilities.invokeLater(ATMSimulation::new);
        SwingUtilities.invokeLater(ATMInterface::new);
        //MysqlConfig mysql = new MysqlConfig();


    }
}

