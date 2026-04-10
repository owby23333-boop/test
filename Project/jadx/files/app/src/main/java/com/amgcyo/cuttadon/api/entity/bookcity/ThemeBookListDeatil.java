package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThemeBookListDeatil implements Serializable {
    private String author;
    private int book_count;
    private List<MkBook> books;
    private int list_id;
    private String remark;
    private int sex;
    private String title;

    public String getAuthor() {
        return this.author;
    }

    public int getBook_count() {
        return this.book_count;
    }

    public List<MkBook> getBooks() {
        return this.books;
    }

    public int getList_id() {
        return this.list_id;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getSex() {
        return this.sex;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setBook_count(int i2) {
        this.book_count = i2;
    }

    public void setBooks(List<MkBook> list) {
        this.books = list;
    }

    public void setList_id(int i2) {
        this.list_id = i2;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSex(int i2) {
        this.sex = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
