package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Fission implements Serializable {
    private FissionData fission_data;
    private String menu_name;
    private String menu_remark;
    private String menu_url;
    private int scheme;

    public FissionData getFission_data() {
        return this.fission_data;
    }

    public String getMenu_name() {
        return this.menu_name;
    }

    public String getMenu_remark() {
        return this.menu_remark;
    }

    public String getMenu_url() {
        return this.menu_url;
    }

    public int getScheme() {
        return this.scheme;
    }

    public void setFission_data(FissionData fissionData) {
        this.fission_data = fissionData;
    }

    public void setMenu_name(String str) {
        this.menu_name = str;
    }

    public void setMenu_remark(String str) {
        this.menu_remark = str;
    }

    public void setMenu_url(String str) {
        this.menu_url = str;
    }

    public void setScheme(int i2) {
        this.scheme = i2;
    }

    public String toString() {
        return "Fission{scheme=" + this.scheme + ", menu_url='" + this.menu_url + "', menu_name='" + this.menu_name + "', menu_remark='" + this.menu_remark + "', fission_data=" + this.fission_data + '}';
    }
}
