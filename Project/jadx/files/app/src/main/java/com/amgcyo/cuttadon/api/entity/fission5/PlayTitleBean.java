package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class PlayTitleBean implements Serializable {
    private int resId;
    private String title;

    public PlayTitleBean() {
    }

    public int getResId() {
        return this.resId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setResId(int i2) {
        this.resId = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public PlayTitleBean(int i2, String str) {
        this.resId = i2;
        this.title = str;
    }
}
