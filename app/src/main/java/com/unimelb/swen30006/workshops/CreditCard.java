package com.unimelb.swen30006.workshops;

import java.util.random.RandomGenerator;

public class CreditCard {
    long cardNum;
    int cvc;
    Boolean valid;

    public CreditCard() {
        cardNum = (long) (Math.random() * 10000000000000000L); // Random 16 digit number
        cvc = (int) (Math.random() * 100); // Random 3 digit number
        valid = true;
    }

    public void close(){
        valid = false;
    }
}
