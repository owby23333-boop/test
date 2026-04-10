package com.amgcyo.cuttadon.api.entity.other;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DownloadBean implements Serializable {
    private MkBook book;
    private ArrayList<MkCatalog> catalogList;
    private int count;
    private int from;
    private int id;
    private String name;
    private int thread_time;

    public DownloadBean() {
    }

    public MkBook getBook() {
        return this.book;
    }

    public ArrayList<MkCatalog> getCatalogList() {
        return this.catalogList;
    }

    public int getCount() {
        return this.count;
    }

    public int getFrom() {
        return this.from;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getThread_time() {
        return this.thread_time;
    }

    public void setBook(MkBook mkBook) {
        this.book = mkBook;
    }

    public void setCatalogList(ArrayList<MkCatalog> arrayList) {
        this.catalogList = arrayList;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public void setFrom(int i2) {
        this.from = i2;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThread_time(int i2) {
        this.thread_time = i2;
    }

    @NonNull
    public String toString() {
        return "DownloadBean{id=" + this.id + ", name='" + this.name + "', thread_time=" + this.thread_time + ", count=" + this.count + ", from=" + this.from + ", book=" + this.book + ", catalogList=" + this.catalogList + '}';
    }

    public DownloadBean(int i2, int i3) {
        this.thread_time = i2;
        this.count = i3;
    }
}
