package com.dangdang.reader.dread.config;

import com.dangdang.reader.dread.jni.BaseJniWarp;

/* JADX INFO: loaded from: classes10.dex */
public class PdfComposingFactor extends ComposingFactor {
    private int bottom;
    private int left;
    private int right;
    private int top;

    public int getBottom() {
        return this.bottom;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

    public int getTop() {
        return this.top;
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public void setMapRect(BaseJniWarp.ERect eRect) {
        if (eRect == null) {
            return;
        }
        setLeft((int) eRect.left);
        setTop((int) eRect.top);
        setRight((int) eRect.right);
        setBottom((int) eRect.bottom);
    }

    public void setRight(int i) {
        this.right = i;
    }

    public void setTop(int i) {
        this.top = i;
    }

    @Override // com.dangdang.reader.dread.config.ComposingFactor
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("_");
        sb.append("PageRect=[" + this.left + "," + this.top + "," + this.right + "," + this.bottom + "]");
        return sb.toString();
    }
}
