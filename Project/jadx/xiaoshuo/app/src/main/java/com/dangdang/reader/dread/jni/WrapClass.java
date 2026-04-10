package com.dangdang.reader.dread.jni;

import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes10.dex */
public abstract class WrapClass {

    public class FontFamily {
        public String charset;
        public String fontName;
        public String fontPath;

        public FontFamily() {
        }
    }

    public abstract int getBgColor();

    public abstract String getCssPath();

    public abstract String getDefaultFontName();

    public abstract String getDefaultFontPath();

    public abstract int getDefaultLineWordNum();

    public abstract String getDictPath();

    public FontFamily[] getFontFamilyArray() {
        FontFamily fontFamily = new FontFamily();
        fontFamily.charset = "DD_CHARSET_DEFAULT";
        fontFamily.fontName = TtmlNode.BOLD;
        fontFamily.fontPath = getDefaultFontPath();
        return new FontFamily[]{fontFamily};
    }

    public abstract int getForeColor();

    public abstract String getHyphenPath();

    public abstract int getLineWordNum();

    public abstract float getMarginBottom();

    public abstract float getMarginLeft();

    public abstract float getMarginTop();

    public abstract float getPageFactor();

    public abstract String getRulePath();

    public abstract int getScreenHeight();

    public abstract int getScreenWidth();

    public abstract boolean isPadScreenIsLarge();
}
