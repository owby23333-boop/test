package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j<T> {
    protected boolean It;
    protected boolean ayh = false;

    public j(boolean z2) {
        this.It = z2;
    }

    public final void aM(boolean z2) {
        this.It = z2;
    }

    @Nullable
    public final T bQ(Context context) {
        if (!this.It || this.ayh) {
            return null;
        }
        try {
            return bR(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    @Nullable
    protected abstract T bR(Context context);
}
