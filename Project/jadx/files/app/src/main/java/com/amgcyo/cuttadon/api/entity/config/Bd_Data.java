package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Bd_Data implements Serializable {
    private String tt_id;
    private String tt_key;
    private String tt_secret;

    public Bd_Data() {
    }

    public String getTt_id() {
        return this.tt_id;
    }

    public String getTt_key() {
        return this.tt_key;
    }

    public String getTt_secret() {
        return this.tt_secret;
    }

    public void setTt_id(String str) {
        this.tt_id = str;
    }

    public void setTt_key(String str) {
        this.tt_key = str;
    }

    public void setTt_secret(String str) {
        this.tt_secret = str;
    }

    public String toString() {
        return "Bd_Data{tt_id='" + this.tt_id + "', tt_key='" + this.tt_key + "', tt_secret='" + this.tt_secret + "'}";
    }

    public Bd_Data(String str, String str2, String str3) {
        this.tt_id = str;
        this.tt_key = str2;
        this.tt_secret = str3;
    }
}
