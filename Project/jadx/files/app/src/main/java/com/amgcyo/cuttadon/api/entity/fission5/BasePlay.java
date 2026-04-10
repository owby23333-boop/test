package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BasePlay implements Serializable {
    private int aid;
    private String amount;
    private int amount_type;
    private int read_time;

    public int getAid() {
        return this.aid;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getAmount_type() {
        return this.amount_type;
    }

    public int getRead_time() {
        return this.read_time;
    }

    public void setAid(int i2) {
        this.aid = i2;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setAmount_type(int i2) {
        this.amount_type = i2;
    }

    public void setRead_time(int i2) {
        this.read_time = i2;
    }
}
