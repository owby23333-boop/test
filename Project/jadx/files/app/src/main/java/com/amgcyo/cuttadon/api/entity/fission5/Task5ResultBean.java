package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Task5ResultBean implements Serializable {
    private int amount;
    private int amount_type;
    private int balance_gold;
    private String balance_money;
    private String earnings;
    private String task_desc;
    private int task_state;

    public Task5ResultBean() {
    }

    public int getAmount() {
        return this.amount;
    }

    public int getAmount_type() {
        return this.amount_type;
    }

    public int getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public String getTask_desc() {
        return this.task_desc;
    }

    public int getTask_state() {
        return this.task_state;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public void setAmount_type(int i2) {
        this.amount_type = i2;
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

    public void setTask_desc(String str) {
        this.task_desc = str;
    }

    public void setTask_state(int i2) {
        this.task_state = i2;
    }

    public Task5ResultBean(int i2, String str, String str2) {
        this.balance_gold = i2;
        this.balance_money = str;
        this.earnings = str2;
    }
}
