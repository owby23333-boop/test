package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class WanyiwanBean implements Serializable {
    private int adCount;
    private String[] location;

    public WanyiwanBean() {
    }

    public int getAdCount() {
        return this.adCount;
    }

    public String[] getLocation() {
        return this.location;
    }

    public void setAdCount(int i2) {
        this.adCount = i2;
    }

    public void setLocation(String[] strArr) {
        this.location = strArr;
    }

    public WanyiwanBean(String[] strArr, int i2) {
        this.location = strArr;
        this.adCount = i2;
    }
}
