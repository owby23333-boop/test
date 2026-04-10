package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IdsBean implements Serializable {
    private List<Integer> book_id;
    private int form;

    public List<Integer> getBook_id() {
        return this.book_id;
    }

    public int getForm() {
        return this.form;
    }

    public void setBook_id(List<Integer> list) {
        this.book_id = list;
    }

    public void setForm(int i2) {
        this.form = i2;
    }
}
