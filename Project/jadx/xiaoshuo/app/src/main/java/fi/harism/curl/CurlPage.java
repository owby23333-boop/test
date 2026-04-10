package fi.harism.curl;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes8.dex */
public class CurlPage {
    public static final int SIDE_ALL = 4;
    public static final int SIDE_BACK = 2;
    public static final int SIDE_BACK2 = 3;
    public static final int SIDE_FRONT = 1;
    private Bitmap mBitmapBack;
    private Bitmap mBitmapBack2;
    private Bitmap mBitmapFront;
    private boolean mBitmapsChanged = false;
    private float mScaleR = 1.0f;
    private float mScaleG = 1.0f;
    private float mScaleB = 1.0f;

    public CurlPage() {
        reset();
    }

    public Bitmap getBitmap(int i) {
        if (i == 1) {
            return this.mBitmapFront;
        }
        if (i == 2) {
            return this.mBitmapBack;
        }
        if (i != 3) {
            return null;
        }
        return this.mBitmapBack2;
    }

    public boolean getBitmapsChanged() {
        return this.mBitmapsChanged;
    }

    public float getColorScaleB() {
        return this.mScaleB;
    }

    public float getColorScaleG() {
        return this.mScaleG;
    }

    public float getColorScaleR() {
        return this.mScaleR;
    }

    public void recycle() {
        this.mBitmapBack = null;
        this.mBitmapBack2 = null;
        this.mBitmapFront = null;
        this.mBitmapsChanged = false;
    }

    public void reset() {
        recycle();
        this.mBitmapsChanged = false;
    }

    public void setBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return;
        }
        if (i == 1) {
            this.mBitmapFront = bitmap;
        } else if (i == 2) {
            this.mBitmapBack = bitmap;
        } else if (i == 3) {
            this.mBitmapBack2 = bitmap;
        } else if (i == 4) {
            this.mBitmapBack2 = bitmap;
            this.mBitmapBack = bitmap;
            this.mBitmapFront = bitmap;
        }
        this.mBitmapsChanged = true;
    }

    public void setColorScale(float f, float f2, float f3) {
        this.mScaleR = Math.max(0.0f, Math.min(f, 1.0f));
        this.mScaleG = Math.max(0.0f, Math.min(f2, 1.0f));
        this.mScaleB = Math.max(0.0f, Math.min(f3, 1.0f));
    }
}
