package com.dangdang.reader.dread.data;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes10.dex */
public class GallaryData {
    private int count;
    private String[] files;
    private Rect galleryRect;
    private boolean hasImgDesc = false;
    private Rect imageRect;
    private int imgBgColor;
    private String[] imgTexts;
    private Rect pointsRect;

    public int getCount() {
        return this.count;
    }

    public String[] getFiles() {
        return this.files;
    }

    public Rect getGalleryRect() {
        return this.galleryRect;
    }

    public Rect getImageRect() {
        return this.imageRect;
    }

    public int getImgBgColor() {
        return this.imgBgColor;
    }

    public String[] getImgTexts() {
        return this.imgTexts;
    }

    public Rect getPointsRect() {
        return this.pointsRect;
    }

    public boolean isHasImgDesc() {
        return this.hasImgDesc;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setFiles(String[] strArr) {
        this.files = strArr;
    }

    public void setGalleryRect(Rect rect) {
        this.galleryRect = rect;
    }

    public void setHasImgDesc(boolean z) {
        this.hasImgDesc = z;
    }

    public void setImageRect(Rect rect) {
        this.imageRect = rect;
    }

    public void setImgBgColor(int i) {
        this.imgBgColor = i;
    }

    public void setImgTexts(String[] strArr) {
        this.imgTexts = strArr;
    }

    public void setPointsRect(Rect rect) {
        this.pointsRect = rect;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.imageRect);
        StringBuilder sb = new StringBuilder();
        sb.append(", images:");
        String[] strArr = this.files;
        sb.append(strArr == null ? 0 : strArr.length);
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }
}
