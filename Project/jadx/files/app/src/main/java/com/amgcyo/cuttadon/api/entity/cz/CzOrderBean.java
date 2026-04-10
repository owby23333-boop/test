package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CzOrderBean implements Serializable {
    private String pay_end_time;
    private String pay_order_id;
    private int pay_type;
    private String pay_url;

    public String getPay_end_time() {
        return this.pay_end_time;
    }

    public String getPay_order_id() {
        return this.pay_order_id;
    }

    public int getPay_type() {
        return this.pay_type;
    }

    public String getPay_url() {
        return this.pay_url;
    }

    public void setPay_end_time(String str) {
        this.pay_end_time = str;
    }

    public void setPay_order_id(String str) {
        this.pay_order_id = str;
    }

    public void setPay_type(int i2) {
        this.pay_type = i2;
    }

    public void setPay_url(String str) {
        this.pay_url = str;
    }

    public String toString() {
        return "CzOrderBean{pay_url='" + this.pay_url + "', pay_type=" + this.pay_type + ", pay_end_time='" + this.pay_end_time + "', pay_order_id='" + this.pay_order_id + "'}";
    }
}
