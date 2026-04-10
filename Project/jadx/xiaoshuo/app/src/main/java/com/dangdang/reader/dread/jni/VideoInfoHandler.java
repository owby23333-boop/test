package com.dangdang.reader.dread.jni;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes10.dex */
public class VideoInfoHandler {
    private boolean mIsAutoPlay;
    private boolean mIsControl;
    private boolean mIsLoop;
    private String mPosterFilePath;
    private int mVideoCount;
    private String mVideoFilePath;
    private Rect mVideoRect;

    public String getmPosterFilePath() {
        return this.mPosterFilePath;
    }

    public int getmVideoCount() {
        return this.mVideoCount;
    }

    public String getmVideoFilePath() {
        return this.mVideoFilePath;
    }

    public Rect getmVideoRect() {
        return this.mVideoRect;
    }

    public boolean ismIsAutoPlay() {
        return this.mIsAutoPlay;
    }

    public boolean ismIsControl() {
        return this.mIsControl;
    }

    public boolean ismIsLoop() {
        return this.mIsLoop;
    }

    public void setVideoCount(int i) {
        this.mVideoCount = i;
    }

    public void setVideoInfo(double d, double d2, double d3, double d4, boolean z, boolean z2, boolean z3, String str, String str2) {
        Rect rect = new Rect();
        this.mVideoRect = rect;
        rect.left = (int) d;
        rect.top = (int) d2;
        rect.right = (int) d3;
        rect.bottom = (int) d4;
        this.mIsAutoPlay = z;
        this.mIsControl = z2;
        this.mIsLoop = z3;
    }

    public void setmIsAutoPlay(boolean z) {
        this.mIsAutoPlay = z;
    }

    public void setmIsControl(boolean z) {
        this.mIsControl = z;
    }

    public void setmIsLoop(boolean z) {
        this.mIsLoop = z;
    }

    public void setmPosterFilePath(String str) {
        this.mPosterFilePath = str;
    }

    public void setmVideoCount(int i) {
        this.mVideoCount = i;
    }

    public void setmVideoFilePath(String str) {
        this.mVideoFilePath = str;
    }

    public void setmVideoRect(Rect rect) {
        this.mVideoRect = rect;
    }
}
