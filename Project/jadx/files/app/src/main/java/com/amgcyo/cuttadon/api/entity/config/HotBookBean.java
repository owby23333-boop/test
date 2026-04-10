package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class HotBookBean implements Serializable {
    private ArrayList<Integer> book_comics;
    private ArrayList<Integer> book_default;
    private ArrayList<Integer> book_female;
    private ArrayList<Integer> book_male;

    public ArrayList<Integer> getBook_comics() {
        return this.book_comics;
    }

    public ArrayList<Integer> getBook_default() {
        return this.book_default;
    }

    public ArrayList<Integer> getBook_female() {
        return this.book_female;
    }

    public ArrayList<Integer> getBook_male() {
        return this.book_male;
    }

    public void setBook_comics(ArrayList<Integer> arrayList) {
        this.book_comics = arrayList;
    }

    public void setBook_default(ArrayList<Integer> arrayList) {
        this.book_default = arrayList;
    }

    public void setBook_female(ArrayList<Integer> arrayList) {
        this.book_female = arrayList;
    }

    public void setBook_male(ArrayList<Integer> arrayList) {
        this.book_male = arrayList;
    }
}
