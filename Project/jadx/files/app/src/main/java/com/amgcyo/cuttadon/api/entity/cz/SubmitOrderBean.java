package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SubmitOrderBean implements Serializable {
    private String channel;
    private int product;
    private String type;

    public String getChannel() {
        return this.channel;
    }

    public int getProduct() {
        return this.product;
    }

    public String getType() {
        return this.type;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setProduct(int i2) {
        this.product = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "SubmitOrderBean{channel='" + this.channel + "', type='" + this.type + "', product=" + this.product + '}';
    }
}
