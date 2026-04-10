package com.duokan.kernel;

/* JADX INFO: loaded from: classes11.dex */
public class DkFlowPosition {
    public long mAtomIndex;
    public long mChapterIndex;
    public long mParaIndex;

    public DkFlowPosition() {
        this.mChapterIndex = 0L;
        this.mParaIndex = 0L;
        this.mAtomIndex = 0L;
    }

    public void copy(DkFlowPosition dkFlowPosition) {
        this.mChapterIndex = dkFlowPosition.mChapterIndex;
        this.mParaIndex = dkFlowPosition.mParaIndex;
        this.mAtomIndex = dkFlowPosition.mAtomIndex;
    }

    public boolean equals(Object obj) {
        DkFlowPosition dkFlowPosition = (DkFlowPosition) obj;
        return this.mChapterIndex == dkFlowPosition.mChapterIndex && this.mParaIndex == dkFlowPosition.mParaIndex && this.mAtomIndex == dkFlowPosition.mAtomIndex;
    }

    public String toString() {
        return "DkFlowPosition{mChapterIndex=" + this.mChapterIndex + ", mParaIndex=" + this.mParaIndex + ", mAtomIndex=" + this.mAtomIndex + '}';
    }

    public DkFlowPosition(DkFlowPosition dkFlowPosition) {
        this.mChapterIndex = -1L;
        this.mParaIndex = -1L;
        this.mAtomIndex = -1L;
        this.mChapterIndex = dkFlowPosition.mChapterIndex;
        this.mParaIndex = dkFlowPosition.mParaIndex;
        this.mAtomIndex = dkFlowPosition.mAtomIndex;
    }

    public DkFlowPosition(long j, long j2, long j3) {
        this.mChapterIndex = j;
        this.mParaIndex = j2;
        this.mAtomIndex = j3;
    }
}
