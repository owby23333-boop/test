package com.duokan.kernel.epublib;

import com.duokan.kernel.DkNative;

/* JADX INFO: loaded from: classes11.dex */
public class DKETocPointWrapper extends DkNative {
    private long mDKETocPoint;

    public DKETocPointWrapper(long j) {
        this.mDKETocPoint = j;
    }

    public native long GetChildByIndex(int i);

    public native long GetChildCount();

    public native int GetDepth();

    public native String GetDest();

    public native boolean GetDestPosition(DKFlowPosition dKFlowPosition);

    public native String GetTitle();

    public native boolean IsContentValid();

    public DKETocPointWrapper getChildByIndexEx(int i) {
        return new DKETocPointWrapper(GetChildByIndex(i));
    }

    public native String getDestPortionId();
}
