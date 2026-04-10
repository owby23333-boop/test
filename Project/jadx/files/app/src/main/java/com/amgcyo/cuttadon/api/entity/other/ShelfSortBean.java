package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ShelfSortBean implements Serializable {
    private String title;
    private String title_key;

    public ShelfSortBean(String str, String str2) {
        this.title = str;
        this.title_key = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitle_key() {
        return this.title_key;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitle_key(String str) {
        this.title_key = str;
    }

    public ShelfSortBean(String str) {
        this.title = str;
    }

    public ShelfSortBean() {
    }
}
