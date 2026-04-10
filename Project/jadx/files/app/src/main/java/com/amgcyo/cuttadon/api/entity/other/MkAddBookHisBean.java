package com.amgcyo.cuttadon.api.entity.other;

import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkAddBookHisBean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private String author;
    private int book_id;
    private String created_at;
    private int form;
    private int itemType;
    private String msg;
    private String name;

    public MkAddBookHisBean(int i2) {
        this.itemType = i2;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public int getForm() {
        return this.form;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getName() {
        return this.name;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
