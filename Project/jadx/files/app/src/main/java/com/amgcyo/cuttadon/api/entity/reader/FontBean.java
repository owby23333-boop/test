package com.amgcyo.cuttadon.api.entity.reader;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FontBean implements Serializable {
    private String font_en_name;
    private String fontmd5;
    private String fontname;
    private String id;
    private String img;
    private float size;
    private String url;

    public String getFont_en_name() {
        return this.font_en_name;
    }

    public String getFontmd5() {
        return this.fontmd5;
    }

    public String getFontname() {
        return this.fontname;
    }

    public String getId() {
        return this.id;
    }

    public String getImg() {
        return this.img;
    }

    public float getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFont_en_name(String str) {
        this.font_en_name = str;
    }

    public void setFontmd5(String str) {
        this.fontmd5 = str;
    }

    public void setFontname(String str) {
        this.fontname = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setSize(float f2) {
        this.size = f2;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
