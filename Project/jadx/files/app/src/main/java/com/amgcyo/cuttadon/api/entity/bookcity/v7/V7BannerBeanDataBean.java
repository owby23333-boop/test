package com.amgcyo.cuttadon.api.entity.bookcity.v7;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class V7BannerBeanDataBean implements Serializable {
    private int book_id;
    private String book_list_path;
    private String url_path;

    public int getBook_id() {
        return this.book_id;
    }

    public String getBook_list_path() {
        return this.book_list_path;
    }

    public String getUrl_path() {
        return this.url_path;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setBook_list_path(String str) {
        this.book_list_path = str;
    }

    public void setUrl_path(String str) {
        this.url_path = str;
    }
}
