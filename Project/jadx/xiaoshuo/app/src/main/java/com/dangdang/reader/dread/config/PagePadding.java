package com.dangdang.reader.dread.config;

/* JADX INFO: loaded from: classes10.dex */
public class PagePadding {
    private float paddingBottom;
    private float paddingLeft;
    private float paddingRight;
    private float paddingTop;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PagePadding)) {
            return false;
        }
        PagePadding pagePadding = (PagePadding) obj;
        return this.paddingTop == pagePadding.getPaddingTop() && this.paddingRight == pagePadding.getPaddingRight() && this.paddingBottom == pagePadding.getPaddingBottom() && this.paddingLeft == pagePadding.getPaddingLeft();
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public float getPaddingRight() {
        return this.paddingRight;
    }

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public void setPaddingBottom(float f) {
        this.paddingBottom = f;
    }

    public void setPaddingLeft(float f) {
        this.paddingLeft = f;
    }

    public void setPaddingRight(float f) {
        this.paddingRight = f;
    }

    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }
}
