package com.kwad.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l<T> {
    protected boolean aYS = false;
    protected boolean enable;

    protected abstract T cD(Context context);

    public l(boolean z) {
        this.enable = z;
    }

    public final void ca(boolean z) {
        this.enable = z;
    }

    public final T cC(Context context) {
        if (!this.enable || this.aYS) {
            return null;
        }
        try {
            return cD(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
