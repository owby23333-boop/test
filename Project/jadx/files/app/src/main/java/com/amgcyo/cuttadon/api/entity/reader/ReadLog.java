package com.amgcyo.cuttadon.api.entity.reader;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ReadLog implements Serializable {
    private int amount;
    private int amount_total;
    private int min;
    private int next_amount;
    private int next_id;
    private int next_min;

    public int getAmount() {
        return this.amount;
    }

    public int getAmount_total() {
        return this.amount_total;
    }

    public int getMin() {
        return this.min;
    }

    public int getNext_amount() {
        return this.next_amount;
    }

    public int getNext_id() {
        return this.next_id;
    }

    public int getNext_min() {
        return this.next_min;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public void setAmount_total(int i2) {
        this.amount_total = i2;
    }

    public void setMin(int i2) {
        this.min = i2;
    }

    public void setNext_amount(int i2) {
        this.next_amount = i2;
    }

    public void setNext_id(int i2) {
        this.next_id = i2;
    }

    public void setNext_min(int i2) {
        this.next_min = i2;
    }
}
