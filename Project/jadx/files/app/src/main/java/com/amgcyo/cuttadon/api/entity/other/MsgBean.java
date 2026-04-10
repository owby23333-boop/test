package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MsgBean implements Serializable {
    private int bookId;
    private String qq;
    private String type;
    private String url;
    private String wechat;

    public MsgBean(String str) {
        this.type = str;
    }

    public int getBookId() {
        return this.bookId;
    }

    public String getQq() {
        return this.qq;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWechat() {
        return this.wechat;
    }

    public void setBookId(int i2) {
        this.bookId = i2;
    }

    public void setQq(String str) {
        this.qq = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWechat(String str) {
        this.wechat = str;
    }

    public MsgBean(String str, String str2) {
        this.type = str;
        this.url = str2;
    }

    public MsgBean(String str, int i2) {
        this.type = str;
        this.bookId = i2;
    }

    public MsgBean(String str, String str2, String str3) {
        this.type = str;
        this.qq = str2;
        this.wechat = str3;
    }
}
