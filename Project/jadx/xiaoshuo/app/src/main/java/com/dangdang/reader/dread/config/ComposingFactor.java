package com.dangdang.reader.dread.config;

import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class ComposingFactor implements IFactor {
    private float firstLineIndent;
    private String font;
    private float fontSize;
    private int height;
    private float lineSpacing;
    private int lineWord;
    private float paddingBottom;
    private float paddingLeft;
    private float paddingTop;
    private float paddintRight;
    private float paragraphSpacing;
    private int width;

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    public String getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getHeight() {
        return this.height;
    }

    public float getLineSpacing() {
        return this.lineSpacing;
    }

    public int getLineWord() {
        return this.lineWord;
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public float getPaddintRight() {
        return this.paddintRight;
    }

    public float getParagraphSpacing() {
        return this.paragraphSpacing;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    public void setFont(String str) {
        this.font = str;
    }

    public void setFontSize(float f) {
        this.fontSize = f;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLineSpacing(float f) {
        this.lineSpacing = f;
    }

    public void setLineWord(int i) {
        this.lineWord = i;
    }

    public void setPaddingBottom(float f) {
        this.paddingBottom = f;
    }

    public void setPaddingLeft(float f) {
        this.paddingLeft = f;
    }

    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    public void setPaddintRight(float f) {
        this.paddintRight = f;
    }

    public void setParagraphSpacing(float f) {
        this.paragraphSpacing = f;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("area[" + getWidth() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getHeight() + "],");
        stringBuffer.append("padLTRB[" + getPaddingLeft() + "," + getPaddingTop() + "," + getPaddintRight() + "," + getPaddingBottom() + "],");
        StringBuilder sb = new StringBuilder();
        sb.append("lineSp[");
        sb.append(getLineSpacing());
        sb.append("],");
        stringBuffer.append(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("paragSp[");
        sb2.append(getParagraphSpacing());
        sb2.append("],");
        stringBuffer.append(sb2.toString());
        stringBuffer.append("fLIndent[" + getFirstLineIndent() + "],");
        stringBuffer.append("fontsize[" + getFontSize() + "],");
        stringBuffer.append("font[" + getFont() + "]");
        return stringBuffer.toString();
    }

    @Override // com.dangdang.reader.dread.config.IFactor
    public String uniqueId() {
        return String.valueOf(toString().hashCode());
    }
}
