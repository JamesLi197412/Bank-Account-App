package main;

import main.ui.ATMGUI;

import javax.swing.*;

class ATMSimulation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ATMGUI().createAndShowGUI());
    }
}


