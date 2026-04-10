package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class Slippage implements Serializable {
    public static final int READ_MODEL_SX_1 = 1;
    public static final int READ_MODEL_ZY_0 = 0;
    private int book_id;
    private int catalog_id;
    private String chapterName;
    private String platform;
    private int readModel;
    private int style;

    public Slippage(int i2, int i3, int i4, String str, String str2, int i5) {
        this.book_id = i2;
        this.catalog_id = i3;
        this.chapterName = str;
        this.readModel = i4;
        this.platform = str2;
        this.style = i5;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public int getCatalog_id() {
        return this.catalog_id;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getReadModel() {
        return this.readModel;
    }

    public int getStyle() {
        return this.style;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setCatalog_id(int i2) {
        this.catalog_id = i2;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setReadModel(int i2) {
        this.readModel = i2;
    }

    public void setStyle(int i2) {
        this.style = i2;
    }

    @NotNull
    public String toString() {
        return "Slippage{book_id=" + this.book_id + ", catalog_id=" + this.catalog_id + ", chapterName='" + this.chapterName + "', readModel=" + this.readModel + ", style=" + this.style + ", platform='" + this.platform + "'}";
    }

    public Slippage(int i2, int i3, String str, int i4) {
        this.book_id = i2;
        this.catalog_id = i3;
        this.chapterName = str;
        this.readModel = i4;
    }

    public Slippage() {
    }
}
