package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkFattenBean implements Serializable {
    private List<String> categoryPics;
    private int fattenCount;
    private int fattenedCount;
    private int form;
    private String title;

    public MkFattenBean() {
    }

    public List<String> getCategoryPics() {
        return this.categoryPics;
    }

    public int getFattenCount() {
        return this.fattenCount;
    }

    public int getFattenedCount() {
        return this.fattenedCount;
    }

    public int getForm() {
        return this.form;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategoryPics(List<String> list) {
        this.categoryPics = list;
    }

    public void setFattenCount(int i2) {
        this.fattenCount = i2;
    }

    public void setFattenedCount(int i2) {
        this.fattenedCount = i2;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public MkFattenBean(int i2, String str, int i3, int i4, List<String> list) {
        this.title = str;
        this.fattenCount = i3;
        this.form = i2;
        this.fattenedCount = i4;
        this.categoryPics = list;
    }
}
