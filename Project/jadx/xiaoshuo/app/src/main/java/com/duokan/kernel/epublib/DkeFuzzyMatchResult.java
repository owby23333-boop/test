package com.duokan.kernel.epublib;

import com.duokan.kernel.DkFlowPosition;

/* JADX INFO: loaded from: classes11.dex */
public class DkeFuzzyMatchResult {
    public DkFlowPosition mStartPos = null;
    public DkFlowPosition mEndPos = null;
    public long mStartOffset = 0;
    public long mEndOffset = 0;

    public boolean isEmpty() {
        DkFlowPosition dkFlowPosition;
        DkFlowPosition dkFlowPosition2 = this.mStartPos;
        return dkFlowPosition2 == null || (dkFlowPosition = this.mEndPos) == null || dkFlowPosition2.equals(dkFlowPosition) || this.mStartOffset == this.mEndOffset;
    }
}
