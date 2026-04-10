package com.duokan.kernel.epublib;

import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkNative;

/* JADX INFO: loaded from: classes11.dex */
public class DkeSection extends DkNative {
    private final long mDkeHandle;

    public DkeSection(String str) {
        this.mDkeHandle = createDkeHandleFromHtmlFile(str);
    }

    private static native long createDkeHandleFromHtmlBytes(byte[] bArr, String str);

    private static native long createDkeHandleFromHtmlFile(String str);

    private static native void destroyDkeHandle(long j);

    public native void clearParsedPages();

    public void finalize() throws Throwable {
        destroyDkeHandle(this.mDkeHandle);
        super.finalize();
    }

    public native DkFlowPosition getAnchorPosition(String str);

    public long getHandle() {
        return this.mDkeHandle;
    }

    public native long getPage(long j);

    public native long getPageCount();

    public native long getPageNum(DkFlowPosition dkFlowPosition);

    public native void parseSection(boolean z);

    public native void resetAllTextColor();

    public native void setFirstLineIndent(double d);

    public native void setFontSize(double d);

    public native void setLineGap(double d);

    public native void setPageBox(DkBox dkBox);

    public native void setParaSpacing(double d);

    public native void setTabStop(double d);

    public native void setTextColor(DkArgbColor dkArgbColor);

    public DkeSection(byte[] bArr, String str) {
        this.mDkeHandle = createDkeHandleFromHtmlBytes(bArr, str);
    }

    public DkeSection(long j) {
        this.mDkeHandle = j;
    }
}
