package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

/* JADX INFO: loaded from: classes12.dex */
public class DktPage extends DkNative {
    protected long mByteLength;
    protected long mByteOffset;
    protected final long mDktHandle;
    protected int mRefCount = 0;
    protected DktParserOption mDktParserOption = null;

    public DktPage(long j) {
        this.mByteOffset = -1L;
        this.mByteLength = -1L;
        this.mDktHandle = j;
        if (j != 0) {
            this.mByteOffset = getOffsetInByte();
            this.mByteLength = getSizeInByte();
        }
    }

    public native long checkRenderStatus();

    public native long[] getCharPositions();

    public native CharSequence getChars();

    public long getDktHandle() {
        return this.mDktHandle;
    }

    public native long getOffsetInByte();

    public native long getOffsetInChar();

    public native long getPageHeight();

    public native long[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native long getSizeInByte();

    public native long getSizeInChar();

    public native String getTextContent();

    public native String getTextContentOfRange(long j, long j2);

    public native DkBox[] getTextRects(long j, long j2);

    public native long[] hitTestTextRange(DkPos dkPos);

    public native long[] hitTestTextRangeByMode(DkPos dkPos, int i);

    public boolean isAfterLastPage() {
        return false;
    }

    public boolean isBeforeFirstPage() {
        return false;
    }

    public native long render(DkFlowRenderOption dkFlowRenderOption);
}
