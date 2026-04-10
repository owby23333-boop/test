package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SystemInfo implements Serializable {
    private String appname;
    private int gosetting;
    private String packname;
    private String platform;

    public String getAppname() {
        return this.appname;
    }

    public int getGosetting() {
        return this.gosetting;
    }

    public String getPackname() {
        return this.packname;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setAppname(String str) {
        this.appname = str;
    }

    public void setGosetting(int i2) {
        this.gosetting = i2;
    }

    public void setPackname(String str) {
        this.packname = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }
}
