package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class HistoryBook implements Serializable {
    private int book_id;
    private String created_at;

    public int getBook_id() {
        return this.book_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }
}
