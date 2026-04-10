package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Base64Bean implements Serializable {
    private String content;
    private String fileName;
    private int ver;

    public Base64Bean() {
        this.ver = 1;
    }

    public String getContent() {
        return this.content;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getVer() {
        return this.ver;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setVer(int i2) {
        this.ver = i2;
    }

    public Base64Bean(int i2, String str) {
        this.ver = 1;
        this.ver = i2;
        this.content = str;
    }

    public Base64Bean(String str) {
        this.ver = 1;
        this.content = str;
    }
}
