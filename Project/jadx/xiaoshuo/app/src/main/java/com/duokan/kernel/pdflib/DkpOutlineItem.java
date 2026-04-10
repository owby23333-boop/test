package com.duokan.kernel.pdflib;

/* JADX INFO: loaded from: classes11.dex */
public class DkpOutlineItem {
    public final long mDestPageNum;
    public final boolean mHasChild;
    public final int mIndex;
    public final String mTitle;

    public DkpOutlineItem(int i, String str, long j, boolean z) {
        this.mIndex = i;
        this.mTitle = str;
        this.mDestPageNum = j;
        this.mHasChild = z;
    }
}
