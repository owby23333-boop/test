package com.kwad.components.core.t;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements Runnable {
    private WeakReference<Runnable> weakReference;

    public p(Runnable runnable) {
        this.weakReference = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.weakReference.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
