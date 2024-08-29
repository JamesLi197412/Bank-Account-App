package main;

import main.java.config.MysqlConfig;
import main.java.ui.ATMInterface;

import javax.swing.*;


public class ATMSimulation {
    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {
            new ATMInterface();
        });


    }
}

