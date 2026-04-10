package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public abstract class NativeObject {

    @Keep
    protected long mPtr;

    public abstract void destroy();

    public long getNativePtr() {
        return this.mPtr;
    }
}
