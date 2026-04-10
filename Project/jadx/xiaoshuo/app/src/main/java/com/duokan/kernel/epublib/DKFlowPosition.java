package com.duokan.kernel.epublib;

import com.duokan.kernel.DkFlowPosition;

/* JADX INFO: loaded from: classes11.dex */
public class DKFlowPosition {
    public long atomIndex;
    public long chapterIndex;
    public long paraIndex;

    public DKFlowPosition(DkFlowPosition dkFlowPosition) {
        this.chapterIndex = dkFlowPosition.mChapterIndex;
        this.paraIndex = dkFlowPosition.mParaIndex;
        this.atomIndex = dkFlowPosition.mAtomIndex;
    }

    public DKFlowPosition() {
        this.chapterIndex = 0L;
        this.paraIndex = 0L;
        this.atomIndex = 0L;
    }

    public DKFlowPosition(long j, long j2, long j3) {
        this.chapterIndex = j;
        this.paraIndex = j2;
        this.atomIndex = j3;
    }
}
