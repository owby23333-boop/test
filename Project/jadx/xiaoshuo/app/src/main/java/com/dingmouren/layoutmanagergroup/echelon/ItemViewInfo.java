package com.dingmouren.layoutmanagergroup.echelon;

/* JADX INFO: loaded from: classes10.dex */
public class ItemViewInfo {
    private boolean mIsBottom;
    private float mLayoutPercent;
    private float mPositionOffset;
    private float mScaleXY;
    private int mTop;

    public ItemViewInfo(int i, float f, float f2, float f3) {
        this.mTop = i;
        this.mScaleXY = f;
        this.mPositionOffset = f2;
        this.mLayoutPercent = f3;
    }

    public float getLayoutPercent() {
        return this.mLayoutPercent;
    }

    public float getPositionOffset() {
        return this.mPositionOffset;
    }

    public float getScaleXY() {
        return this.mScaleXY;
    }

    public int getTop() {
        return this.mTop;
    }

    public ItemViewInfo setIsBottom() {
        this.mIsBottom = true;
        return this;
    }

    public void setLayoutPercent(float f) {
        this.mLayoutPercent = f;
    }

    public void setPositionOffset(float f) {
        this.mPositionOffset = f;
    }

    public void setScaleXY(float f) {
        this.mScaleXY = f;
    }

    public void setTop(int i) {
        this.mTop = i;
    }
}
