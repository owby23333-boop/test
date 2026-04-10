package com.amgcyo.cuttadon.api.entity.comic;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchResultListV4 implements Serializable {
    private List<String> author;
    private List<MkBook> book;

    public List<String> getAuthor() {
        return this.author;
    }

    public List<MkBook> getBook() {
        return this.book;
    }

    public void setAuthor(List<String> list) {
        this.author = list;
    }

    public void setBook(List<MkBook> list) {
        this.book = list;
    }
}
