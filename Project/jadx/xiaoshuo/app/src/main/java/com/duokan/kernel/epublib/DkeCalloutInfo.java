package com.duokan.kernel.epublib;

import com.duokan.kernel.DkPos;

/* JADX INFO: loaded from: classes11.dex */
public class DkeCalloutInfo {
    public final float mImageScale;
    public final int mMaxHeight;
    public final DkPos mPosition;
    public final DkPos mTarget;
    public final int mWidth;

    public DkeCalloutInfo(DkPos dkPos, DkPos dkPos2, float f, int i, int i2) {
        this.mPosition = dkPos;
        this.mTarget = dkPos2;
        this.mImageScale = f;
        this.mWidth = i;
        this.mMaxHeight = i2;
    }
}
