package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class VideoAddBook implements Serializable {
    private MkBook book;

    public VideoAddBook(MkBook mkBook) {
        this.book = mkBook;
    }

    public MkBook getBook() {
        return this.book;
    }

    public void setBook(MkBook mkBook) {
        this.book = mkBook;
    }

    public VideoAddBook() {
    }
}
