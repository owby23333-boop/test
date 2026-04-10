package com.amgcyo.cuttadon.api.entity.migrate;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DaoliuData implements Serializable {
    private String channel;
    private String json_book;
    private String json_history;
    private String json_user;
    private String package_name;

    public String getChannel() {
        return this.channel;
    }

    public String getJson_book() {
        return this.json_book;
    }

    public String getJson_history() {
        return this.json_history;
    }

    public String getJson_user() {
        return this.json_user;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setJson_book(String str) {
        this.json_book = str;
    }

    public void setJson_history(String str) {
        this.json_history = str;
    }

    public void setJson_user(String str) {
        this.json_user = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }
}
