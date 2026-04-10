package com.duokan.kernel;

import android.graphics.Color;

/* JADX INFO: loaded from: classes11.dex */
public class DkArgbColor {
    public int mAlpha;
    public int mBlue;
    public int mGreen;
    public int mRed;

    public DkArgbColor() {
        this.mAlpha = 0;
        this.mRed = 0;
        this.mGreen = 0;
        this.mBlue = 0;
    }

    public DkArgbColor(int i) {
        this.mAlpha = 0;
        this.mRed = 0;
        this.mGreen = 0;
        this.mBlue = 0;
        this.mAlpha = Color.alpha(i);
        this.mRed = Color.red(i);
        this.mGreen = Color.green(i);
        this.mBlue = Color.blue(i);
    }
}
