package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class IncomeBean5 implements Serializable {
    private int balance_gold;
    private String balance_money;
    private String earnings;
    private int tid;

    public int getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public int getTid() {
        return this.tid;
    }

    public void setBalance_gold(int i2) {
        this.balance_gold = i2;
    }

    public void setBalance_money(String str) {
        this.balance_money = str;
    }

    public void setEarnings(String str) {
        this.earnings = str;
    }

    public void setTid(int i2) {
        this.tid = i2;
    }
}
