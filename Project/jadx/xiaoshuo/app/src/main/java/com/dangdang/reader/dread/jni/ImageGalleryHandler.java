package com.dangdang.reader.dread.jni;

import android.graphics.Rect;
import com.dangdang.reader.dread.data.GallaryData;
import com.dangdang.zframework.log.LogM;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ImageGalleryHandler {
    private int mCount;
    private Rect mGalleryRect;
    private boolean mHasImgDesc = false;
    private Rect mImageRect;
    private int mImgBgColor;
    private List<String> mImgPaths;
    private List<String> mImgTexts;
    private Rect mPointsRect;

    public void addGalleryImageItem(String str, String str2) {
        printLog(" addGallaryImageFile " + str);
        if (this.mImgPaths == null) {
            this.mImgPaths = new ArrayList();
        }
        this.mImgPaths.add(str);
        if (this.mImgTexts == null) {
            this.mImgTexts = new ArrayList();
        }
        this.mImgTexts.add(str2);
    }

    public int getCount() {
        return this.mCount;
    }

    public Rect getGalleryRect() {
        return this.mGalleryRect;
    }

    public GallaryData[] getGallerys() {
        List<String> list = this.mImgPaths;
        if (list == null || list.size() == 0) {
            return null;
        }
        GallaryData gallaryData = new GallaryData();
        gallaryData.setCount(this.mCount);
        List<String> list2 = this.mImgPaths;
        gallaryData.setFiles((String[]) list2.toArray(new String[list2.size()]));
        List<String> list3 = this.mImgTexts;
        gallaryData.setImgTexts((String[]) list3.toArray(new String[list3.size()]));
        gallaryData.setHasImgDesc(this.mHasImgDesc);
        gallaryData.setImageRect(this.mImageRect);
        gallaryData.setPointsRect(this.mPointsRect);
        gallaryData.setGalleryRect(this.mGalleryRect);
        gallaryData.setImgBgColor(this.mImgBgColor);
        return new GallaryData[]{gallaryData};
    }

    public Rect getImageRect() {
        return this.mImageRect;
    }

    public List<String> getImgPaths() {
        return this.mImgPaths;
    }

    public Rect getPointsRect() {
        return this.mPointsRect;
    }

    public boolean isHasImgDesc() {
        return this.mHasImgDesc;
    }

    public void printLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }

    public void setGalleryHasText(boolean z) {
        printLog(" setGallaryHasText " + z);
        this.mHasImgDesc = z;
    }

    public void setGalleryImageCount(int i) {
        printLog(" setGallaryImageCount " + i);
        this.mCount = i;
    }

    public void setGalleryImageRect(double d, double d2, double d3, double d4) {
        printLog(" setGallaryImageRect " + d + "," + d2 + "," + d3 + "," + d4);
        Rect rect = new Rect();
        this.mImageRect = rect;
        rect.left = (int) d;
        rect.top = (int) d2;
        rect.right = (int) d3;
        rect.bottom = (int) d4;
    }

    public void setGalleryImgBgColor(int i) {
        this.mImgBgColor = i;
    }

    public void setGalleryRect(double d, double d2, double d3, double d4) {
        printLog(" setGalleryRect " + d + "," + d2 + "," + d3 + "," + d4);
        Rect rect = new Rect();
        this.mGalleryRect = rect;
        rect.left = (int) d;
        rect.top = (int) d2;
        rect.right = (int) d3;
        rect.bottom = (int) d4;
    }

    public void setGalleryScrollRect(double d, double d2, double d3, double d4) {
        printLog(" setGallaryScrollRect " + d + "," + d2 + "," + d3 + "," + d4);
        Rect rect = new Rect();
        this.mPointsRect = rect;
        rect.left = (int) d;
        rect.top = (int) d2;
        rect.right = (int) d3;
        rect.bottom = (int) d4;
    }
}
