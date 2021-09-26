package com.cbb.transportcbb;

public class Review {

    String rate;
    String email;
    String other;

    public Review(String rate, String email, String other) {
        this.rate = rate;
        this.email = email;
        this.other = other;
    }

    public String getRate() {
        return rate;
    }

    public String getEmail() {
        return email;
    }

    public String getOther() {
        return other;
    }
}
