package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkDataBean implements Serializable {
    private String ad_token;
    private int attributes;

    public String getAd_token() {
        return this.ad_token;
    }

    public int getAttributes() {
        return this.attributes;
    }

    public void setAd_token(String str) {
        this.ad_token = str;
    }

    public void setAttributes(int i2) {
        this.attributes = i2;
    }
}
