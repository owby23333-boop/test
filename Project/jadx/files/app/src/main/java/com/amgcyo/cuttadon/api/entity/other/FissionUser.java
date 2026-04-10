package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FissionUser implements Serializable {
    private String fissionName;
    private String fissionZfb;

    public FissionUser() {
    }

    public String getFissionName() {
        return this.fissionName;
    }

    public String getFissionZfb() {
        return this.fissionZfb;
    }

    public void setFissionName(String str) {
        this.fissionName = str;
    }

    public void setFissionZfb(String str) {
        this.fissionZfb = str;
    }

    public String toString() {
        return "FissionUser{fissionName='" + this.fissionName + "', fissionZfb='" + this.fissionZfb + "'}";
    }

    public FissionUser(String str, String str2) {
        this.fissionName = str;
        this.fissionZfb = str2;
    }
}
