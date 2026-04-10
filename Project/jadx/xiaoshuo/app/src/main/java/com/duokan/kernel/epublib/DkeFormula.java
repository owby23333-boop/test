package com.duokan.kernel.epublib;

import com.duokan.kernel.DkAtomRenderOption;

/* JADX INFO: loaded from: classes11.dex */
public class DkeFormula {
    private final long mDkeHandle;

    public DkeFormula(long j) {
        this.mDkeHandle = j;
    }

    public native float getHeight();

    public native float getWidth();

    public native long render(DkAtomRenderOption dkAtomRenderOption);
}
