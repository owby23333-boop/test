package com.kwad.sdk.api.core.lifecycle;

import androidx.lifecycle.LifecycleObserver;

/* JADX INFO: loaded from: classes4.dex */
public class KsLifecycleObserver {
    LifecycleObserver mBase;

    public void setBase(LifecycleObserver lifecycleObserver) {
        this.mBase = lifecycleObserver;
    }

    public LifecycleObserver getBase() {
        return this.mBase;
    }
}
