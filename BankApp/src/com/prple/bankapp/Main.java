package com.prple.bankapp;

import javax.swing.*;

public class Main {

    public static void main(String [] args) {

        BankingApp BankApp = new BankingApp();
        BankApp.pack();
        BankApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BankApp.setVisible(true);

    }
}
