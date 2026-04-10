package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchHotkeyV4 implements Serializable {
    private List<String> book;
    private List<String> comics;

    public List<String> getBook() {
        return this.book;
    }

    public List<String> getComics() {
        return this.comics;
    }

    public void setBook(List<String> list) {
        this.book = list;
    }

    public void setComics(List<String> list) {
        this.comics = list;
    }
}
