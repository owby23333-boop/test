package com.dangdang.reader.dread.jni;

import android.graphics.Bitmap;
import com.dangdang.zframework.log.LogM;

/* JADX INFO: loaded from: classes10.dex */
public class StringRenderHandler {
    private int[] mColors;
    private int mHeight;
    private int mWidth;

    public Bitmap getBitmap() {
        int i;
        int i2;
        Bitmap bitmapCreateScaledBitmap;
        int[] iArr = this.mColors;
        Bitmap bitmapCreateBitmap = null;
        if (iArr == null || (i = this.mWidth) == 0 || (i2 = this.mHeight) == 0) {
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
            float f = this.mWidth;
            int i3 = this.mHeight;
            float f2 = i3;
            if (i3 <= 4096 || (bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (f / (f2 / 4096.0f)), (int) 4096.0f, false)) == bitmapCreateBitmap) {
                return bitmapCreateBitmap;
            }
            bitmapCreateBitmap.recycle();
            return bitmapCreateScaledBitmap;
        } catch (Throwable th) {
            LogM.e(" SRH newbmp error " + th);
            System.gc();
            System.gc();
            return bitmapCreateBitmap;
        }
    }

    public void printLog(String str) {
    }

    public void setColors(int[] iArr) {
        this.mColors = iArr;
        if (iArr != null) {
            printLog(" setColors " + iArr.length);
        }
    }

    public void setRenderHeight(int i) {
        this.mHeight = i;
        printLog(" setRenderHeight " + i);
    }

    public void setRenderWidth(int i) {
        this.mWidth = i;
        printLog(" setRenderWidth " + i);
    }
}
