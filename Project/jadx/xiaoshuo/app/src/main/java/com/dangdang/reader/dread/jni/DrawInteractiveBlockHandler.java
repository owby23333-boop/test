package com.dangdang.reader.dread.jni;

import android.graphics.Bitmap;
import com.dangdang.zframework.log.LogM;

/* JADX INFO: loaded from: classes10.dex */
public class DrawInteractiveBlockHandler {
    private int[] mColors;
    private int mHeight;
    private int mWidth;

    public Bitmap getBitmap() {
        int i;
        int i2;
        int[] iArr = this.mColors;
        if (iArr != null && (i = this.mWidth) != 0 && (i2 = this.mHeight) != 0) {
            try {
                return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                LogM.e(" SRH newbmp error " + th);
                System.gc();
                System.gc();
            }
        }
        return null;
    }

    public int getRenderHeight() {
        return this.mHeight;
    }

    public int getRenderWidth() {
        return this.mWidth;
    }

    public void setColors(int[] iArr) {
        this.mColors = iArr;
    }

    public void setRenderHeight(int i) {
        this.mHeight = i;
    }

    public void setRenderWidth(int i) {
        this.mWidth = i;
    }
}
