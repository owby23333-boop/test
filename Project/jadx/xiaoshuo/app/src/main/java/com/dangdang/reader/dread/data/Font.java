package com.dangdang.reader.dread.data;

/* JADX INFO: loaded from: classes10.dex */
public class Font {
    private String charset;
    private String fontName;
    private String fontPath;
    private boolean isDefault;
    private boolean isPreset;

    public String getCharset() {
        if (this.charset == null) {
            this.charset = "";
        }
        return this.charset;
    }

    public String getFontName() {
        if (this.fontName == null) {
            this.fontName = "";
        }
        return this.fontName;
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public boolean isPreset() {
        return this.isPreset;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }

    public void setFontName(String str) {
        this.fontName = str;
    }

    public void setFontPath(String str) {
        this.fontPath = str;
    }

    public void setPreset(boolean z) {
        this.isPreset = z;
    }
}
