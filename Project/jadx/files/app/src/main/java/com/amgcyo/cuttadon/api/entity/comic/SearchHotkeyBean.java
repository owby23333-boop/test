package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SearchHotkeyBean implements Serializable {
    private String keyWord;
    private int type;

    public SearchHotkeyBean() {
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public int getType() {
        return this.type;
    }

    public void setKeyWord(String str) {
        this.keyWord = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public SearchHotkeyBean(int i2, String str) {
        this.type = i2;
        this.keyWord = str;
    }
}
