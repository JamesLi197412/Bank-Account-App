package main.java.pojo;

import java.util.Date;

public class Transaction {
    private final double amount;
    private final Date timestamp;
    private final Account account;
    private String notes;

    public Transaction(double amount, Date timestamp, Account account, String notes) {
        this.amount = amount;
        this.timestamp = new Date();
        this.notes = "";
        this.account = account;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
