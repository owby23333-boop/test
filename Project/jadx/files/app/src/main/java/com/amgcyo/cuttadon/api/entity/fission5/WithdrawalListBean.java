package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class WithdrawalListBean implements Serializable {
    private String amount;
    private String created_at;
    private String msg;
    private int state;

    public String getAmount() {
        return this.amount;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getState() {
        return this.state;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }
}
