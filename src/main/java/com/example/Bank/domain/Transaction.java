package com.example.Bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private int senderAcc;
    private int getterAcc;
    private double amount;
    private Timestamp time;

    public Transaction() {
    }

    public Transaction(int senderAcc, int getterAcc, double amount) {
        this.senderAcc = senderAcc;
        this.getterAcc = getterAcc;
        this.amount = amount;
        long time = new Date().getTime();
        this.time = new Timestamp(time);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderAcc() {
        return senderAcc;
    }

    public void setSenderAcc(int senderAcc) {
        this.senderAcc = senderAcc;
    }

    public int getGetterAcc() {
        return getterAcc;
    }

    public void setGetterAcc(int getterAcc) {
        this.getterAcc = getterAcc;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (senderAcc != that.senderAcc) return false;
        if (getterAcc != that.getterAcc) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        return time != null ? time.equals(that.time) : that.time == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + senderAcc;
        result = 31 * result + getterAcc;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}