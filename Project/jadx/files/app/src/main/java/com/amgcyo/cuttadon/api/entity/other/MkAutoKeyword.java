package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkAutoKeyword implements Serializable {
    private String author;
    private int book_id;
    private int form;
    private int is_recommend;
    private String name;
    private int type;

    public String getAuthor() {
        return this.author;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public int getForm() {
        return this.form;
    }

    public int getIs_recommend() {
        return this.is_recommend;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setIs_recommend(int i2) {
        this.is_recommend = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
