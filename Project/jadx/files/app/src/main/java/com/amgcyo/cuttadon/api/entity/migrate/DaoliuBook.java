package com.amgcyo.cuttadon.api.entity.migrate;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class DaoliuBook implements Serializable {
    private static final long serialVersionUID = -4748385997857490145L;
    private int book_id;
    private int form;
    private String last_read_chapterName;
    private int read_begin;
    private int reading_chapter_key;
    private long reading_datetime;
    private String reading_site_id;

    public DaoliuBook(int i2, int i3, String str, int i4, int i5, String str2, long j2) {
        this.book_id = i2;
        this.form = i3;
        this.reading_site_id = str;
        this.reading_chapter_key = i4;
        this.read_begin = i5;
        this.last_read_chapterName = str2;
        this.reading_datetime = j2;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public int getForm() {
        return this.form;
    }

    public String getLast_read_chapterName() {
        return this.last_read_chapterName;
    }

    public int getRead_begin() {
        return this.read_begin;
    }

    public int getReading_chapter_key() {
        return this.reading_chapter_key;
    }

    public long getReading_datetime() {
        return this.reading_datetime;
    }

    public String getReading_site_id() {
        return this.reading_site_id;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setLast_read_chapterName(String str) {
        this.last_read_chapterName = str;
    }

    public void setRead_begin(int i2) {
        this.read_begin = i2;
    }

    public void setReading_chapter_key(int i2) {
        this.reading_chapter_key = i2;
    }

    public void setReading_datetime(long j2) {
        this.reading_datetime = j2;
    }

    public void setReading_site_id(String str) {
        this.reading_site_id = str;
    }

    @NotNull
    public String toString() {
        return "DaoliuBook{book_id=" + this.book_id + ", reading_site_id='" + this.reading_site_id + "', reading_chapter_key=" + this.reading_chapter_key + ", read_begin=" + this.read_begin + ", last_read_chapterName='" + this.last_read_chapterName + "', reading_datetime=" + this.reading_datetime + ", form=" + this.form + '}';
    }
}
