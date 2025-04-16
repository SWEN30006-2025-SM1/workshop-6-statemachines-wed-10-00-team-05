package com.unimelb.swen30006.workshops;

public class Bill {
    private String billID;
    private double amount;
    private double fees;

    public Bill(String billID, double amount) {
        this.billID = billID;
        this.amount = amount;
    }

    public void payBill() {
        System.out.println("Paid: " + billID + "\n");
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
