package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Fuli5SignInDataBean implements Serializable {
    private int amount;
    private int amount_type;
    private int day;
    private int is_gold;
    private int state;
    private int today;
    private int tomorrow;

    public int getAmount() {
        return this.amount;
    }

    public int getAmount_type() {
        return this.amount_type;
    }

    public int getDay() {
        return this.day;
    }

    public int getIs_gold() {
        return this.is_gold;
    }

    public int getState() {
        return this.state;
    }

    public int getToday() {
        return this.today;
    }

    public int getTomorrow() {
        return this.tomorrow;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public void setAmount_type(int i2) {
        this.amount_type = i2;
    }

    public void setDay(int i2) {
        this.day = i2;
    }

    public void setIs_gold(int i2) {
        this.is_gold = i2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setToday(int i2) {
        this.today = i2;
    }

    public void setTomorrow(int i2) {
        this.tomorrow = i2;
    }
}
