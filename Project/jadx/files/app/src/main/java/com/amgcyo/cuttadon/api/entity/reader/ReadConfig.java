package com.amgcyo.cuttadon.api.entity.reader;

import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReadConfig implements Serializable {
    private int bookId;
    private String book_name;
    private int currentChapterId;
    private boolean from_unlock_activity;
    private boolean isOtherBook;
    private List<MkCatalog> mChapterList;
    private int notchHeight;
    private int read_begin;
    private String siteId;

    public ReadConfig() {
    }

    public int getBookId() {
        return this.bookId;
    }

    public String getBook_name() {
        return this.book_name;
    }

    public List<MkCatalog> getChapterList() {
        return this.mChapterList;
    }

    public int getCurrentChapterId() {
        return this.currentChapterId;
    }

    public int getNotchHeight() {
        return this.notchHeight;
    }

    public int getRead_begin() {
        return this.read_begin;
    }

    public String getSiteId() {
        return this.siteId;
    }

    public boolean isFrom_unlock_activity() {
        return this.from_unlock_activity;
    }

    public boolean isOtherBook() {
        return this.isOtherBook;
    }

    public void setBookId(int i2) {
        this.bookId = i2;
    }

    public void setBook_name(String str) {
        this.book_name = str;
    }

    public void setChapterList(List<MkCatalog> list) {
        this.mChapterList = list;
    }

    public void setCurrentChapterId(int i2) {
        this.currentChapterId = i2;
    }

    public void setFrom_unlock_activity(boolean z2) {
        this.from_unlock_activity = z2;
    }

    public void setNotchHeight(int i2) {
        this.notchHeight = i2;
    }

    public void setOtherBook(boolean z2) {
        this.isOtherBook = z2;
    }

    public void setRead_begin(int i2) {
        this.read_begin = i2;
    }

    public void setSiteId(String str) {
        this.siteId = str;
    }

    public ReadConfig(String str, int i2, int i3, int i4, String str2, boolean z2, int i5) {
        this.book_name = str;
        this.bookId = i2;
        this.currentChapterId = i3;
        this.read_begin = i4;
        this.siteId = str2;
        this.isOtherBook = z2;
        this.notchHeight = i5;
    }
}
