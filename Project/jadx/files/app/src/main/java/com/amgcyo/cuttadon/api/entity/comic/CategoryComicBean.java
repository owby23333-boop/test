package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CategoryComicBean implements Serializable {
    private int form;
    private String imgUrl;

    public CategoryComicBean() {
    }

    public int getForm() {
        return this.form;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public CategoryComicBean(String str, int i2) {
        this.imgUrl = str;
        this.form = i2;
    }
}
