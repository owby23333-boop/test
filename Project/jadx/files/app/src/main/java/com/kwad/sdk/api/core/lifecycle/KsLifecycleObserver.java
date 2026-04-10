package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.LifecycleObserver;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class KsLifecycleObserver {
    LifecycleObserver mBase;

    public LifecycleObserver getBase() {
        return this.mBase;
    }

    public void setBase(LifecycleObserver lifecycleObserver) {
        this.mBase = lifecycleObserver;
    }
}
