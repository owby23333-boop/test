package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.kernel.DkNative;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes12.dex */
public class DktBook extends DkNative {
    private final long mDktHandle;
    private final LinkedList<DktPage> mDktPageList = new LinkedList<>();
    private final DkTxtLib mTxtLib;

    public DktBook(DkTxtLib dkTxtLib, long j) {
        this.mTxtLib = dkTxtLib;
        this.mDktHandle = j;
    }

    private native long createPage(DktParserOption dktParserOption, long j, int i);

    private native void destroyPage(long j);

    public DktPage acquirePage(long j, DktParserOption dktParserOption, int i) {
        DktPage dktPage = null;
        DktPage dktPageAcquirePage = i == 2 ? acquirePage(j, dktParserOption) : null;
        if (dktPageAcquirePage != null) {
            return dktPageAcquirePage;
        }
        synchronized (this.mDktPageList) {
            try {
                if (j == Long.MIN_VALUE) {
                    dktPage = new DktDummyPage(Long.MIN_VALUE, 0L);
                } else if (j == Long.MAX_VALUE) {
                    dktPage = new DktDummyPage(Long.MAX_VALUE, 0L);
                } else {
                    long jCreatePage = createPage(dktParserOption, j, i);
                    if (jCreatePage != 0) {
                        dktPage = new DktPage(jCreatePage);
                    }
                }
                if (dktPage != null) {
                    dktPage.mDktParserOption = dktParserOption;
                }
            } finally {
            }
        }
        synchronized (this) {
            if (dktPage != null) {
                try {
                    dktPageAcquirePage = acquirePage(dktPage.mByteOffset, dktParserOption);
                } finally {
                }
            }
            if (dktPageAcquirePage != null) {
                long j2 = dktPage.mDktHandle;
                if (j2 != 0) {
                    destroyPage(j2);
                }
            } else if (dktPage != null) {
                dktPage.mRefCount++;
                this.mDktPageList.addFirst(dktPage);
            }
            dktPage = dktPageAcquirePage;
        }
        return dktPage;
    }

    public native long calcNextPageOffset(DktParserOption dktParserOption, long j);

    public void close() {
        long j = this.mDktHandle;
        if (j != 0) {
            this.mTxtLib.closeDocument(j);
        }
    }

    public native long[] findTextInBook(long j, String str, int i);

    public native String getChapterTitle(long j);

    public native DkFindTextSnippet getFindTextSnippet(long j, String str, int i);

    public native long getLength();

    public native int getLogicalPageCount();

    public native long getLogicalPageIndexByOffsetInByte(long j);

    public native long getLogicalPageOffsetInBytes(long j);

    public native String getTextContentOfRange(long j, long j2);

    public native long[] getToc();

    public native long prepareParseContent(int i);

    public synchronized void releasePage(long j, DktParserOption dktParserOption) {
        for (DktPage dktPage : this.mDktPageList) {
            if (dktPage.mByteOffset == j && dktPage.mDktParserOption.equals(dktParserOption)) {
                int i = dktPage.mRefCount - 1;
                dktPage.mRefCount = i;
                if (i == 0) {
                    long j2 = dktPage.mDktHandle;
                    if (j2 != 0) {
                        destroyPage(j2);
                    }
                    this.mDktPageList.remove(dktPage);
                }
                return;
            }
        }
    }

    public native void setFirstLineIndent(double d);

    public native void setFontFamily(String str, int i);

    public native void setFontSize(double d);

    public native void setLineGap(double d);

    public native void setParaSpacing(double d);

    public native void setTabStop(double d);

    public native void setTextColor(DkArgbColor dkArgbColor);

    public native void setToc(long[] jArr);

    public synchronized void releasePage(DktPage dktPage) {
        int i = dktPage.mRefCount - 1;
        dktPage.mRefCount = i;
        if (i == 0) {
            long j = dktPage.mDktHandle;
            if (j != 0) {
                destroyPage(j);
            }
            this.mDktPageList.remove(dktPage);
        }
    }

    public synchronized DktPage acquirePage(long j, DktParserOption dktParserOption) {
        for (DktPage dktPage : this.mDktPageList) {
            if (dktPage.mByteOffset == j && dktPage.mDktParserOption.equals(dktParserOption)) {
                dktPage.mRefCount++;
                return dktPage;
            }
        }
        return null;
    }
}
