package com.unimelb.swen30006.workshops;

public class Account {
    private State state;
    private int stateTimer = 0;
    private CreditCard card;
    private double funds;

    public static final int ACTIVE = 6;
    public static final int INACTIVE = 12;
    public static final int BILL_DUE = 1;           // assumption

    private double limit;

    public void tickMonth() {
        stateTimer++;
        if (stateTimer > ACTIVE && state == State.ACTIVE) {
            state = State.INACTIVE;
        }
        else if (stateTimer > INACTIVE && state == State.INACTIVE) {
            state = State.CLOSED;
        }
        else if (stateTimer > BILL_DUE && funds < 0 && state == State.ACTIVE) {
            state = State.DEFAULT;
        }
    }

    public void onboard(double limit) {
        state = State.PENDING;
        card = new CreditCard();
        this.limit = limit;
    }

    public void activate() {
        state = State.ACTIVE;
    }


    public void useCard(Bill bill) {
        if (state == State.ACTIVE) {
            stateTimer = 0;
            funds -= bill.getAmount();
        }
        if (funds < limit) {
            state = State.SUSPENDED;
        }
    }

    public void reportStolen() {
        state = State.PENDING;
        card.close();
        card = new CreditCard();
    }


    public void payBill(Bill bill) {
        funds += amount;
        if (state == State.SUSPENDED && funds >= 0) {
            state = State.ACTIVE;
        }
    }


}
