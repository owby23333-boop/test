package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CzRecordBean implements Serializable {
    private int amount;
    private String created_at;
    private String pay_at;
    private int product_id;
    private String product_name;
    private int pt;
    private int status;
    private String status_msg;

    public int getAmount() {
        return this.amount;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getPay_at() {
        return this.pay_at;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public int getPt() {
        return this.pt;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatus_msg() {
        return this.status_msg;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setPay_at(String str) {
        this.pay_at = str;
    }

    public void setProduct_id(int i2) {
        this.product_id = i2;
    }

    public void setProduct_name(String str) {
        this.product_name = str;
    }

    public void setPt(int i2) {
        this.pt = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatus_msg(String str) {
        this.status_msg = str;
    }
}
