package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class PushDataBean implements Serializable {
    private String appkey;
    private String bug_key;
    private String master_secret;
    private String um_key;
    private String um_master_secret;
    private String um_message_secret;

    public String getAppkey() {
        return this.appkey;
    }

    public String getBug_key() {
        return this.bug_key;
    }

    public String getMaster_secret() {
        return this.master_secret;
    }

    public String getUm_key() {
        return this.um_key;
    }

    public String getUm_master_secret() {
        return this.um_master_secret;
    }

    public String getUm_message_secret() {
        return this.um_message_secret;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setBug_key(String str) {
        this.bug_key = str;
    }

    public void setMaster_secret(String str) {
        this.master_secret = str;
    }

    public void setUm_key(String str) {
        this.um_key = str;
    }

    public void setUm_master_secret(String str) {
        this.um_master_secret = str;
    }

    public void setUm_message_secret(String str) {
        this.um_message_secret = str;
    }
}
