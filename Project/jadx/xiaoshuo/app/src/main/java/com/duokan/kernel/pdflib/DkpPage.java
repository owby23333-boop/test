package com.duokan.kernel.pdflib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

/* JADX INFO: loaded from: classes11.dex */
public class DkpPage extends DkNative {
    private final long mBookHandle;
    private final long mPageNum;
    protected int mRefCount = 0;
    protected boolean mReleased = false;

    public DkpPage(long j, long j2) {
        this.mBookHandle = j;
        this.mPageNum = j2;
    }

    public native DkpSearchResult[] findTextInPage(String str, int i);

    public native void freePageContent();

    public native DkFlowPosition[] getCharPositions();

    public native CharSequence getChars();

    public native float getHeight();

    public native DkFlowPosition getPageEndPos();

    public native DkFlowPosition getPageStartPos();

    public native DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native String getTextContentOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native float getWidth();

    public native DkFlowPosition[] hitTestTextRange(DkPos dkPos);
}
