package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;

/* JADX INFO: loaded from: classes12.dex */
class DktDummyPage extends DktPage {
    public DktDummyPage(long j, long j2) {
        super(0L);
        this.mByteOffset = j;
        this.mByteLength = j2;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long checkRenderStatus() {
        return 0L;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long[] getCharPositions() {
        return new long[0];
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public CharSequence getChars() {
        return "";
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long getDktHandle() {
        return super.getDktHandle();
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long getOffsetInByte() {
        return this.mByteOffset;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long getOffsetInChar() {
        return 0L;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long getPageHeight() {
        return -1L;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long[] getSelectionRange(DkPos dkPos, DkPos dkPos2) {
        return new long[0];
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long getSizeInByte() {
        return 0L;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long getSizeInChar() {
        return 0L;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public String getTextContent() {
        return "";
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public String getTextContentOfRange(long j, long j2) {
        return "";
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public DkBox[] getTextRects(long j, long j2) {
        return new DkBox[0];
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long[] hitTestTextRange(DkPos dkPos) {
        return new long[0];
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long[] hitTestTextRangeByMode(DkPos dkPos, int i) {
        return new long[0];
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public boolean isAfterLastPage() {
        return this.mByteOffset == Long.MAX_VALUE;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public boolean isBeforeFirstPage() {
        return this.mByteOffset == Long.MIN_VALUE;
    }

    @Override // com.duokan.kernel.txtlib.DktPage
    public long render(DkFlowRenderOption dkFlowRenderOption) {
        return 0L;
    }
}
