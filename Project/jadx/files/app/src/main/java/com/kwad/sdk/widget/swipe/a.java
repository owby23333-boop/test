package com.kwad.sdk.widget.swipe;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    private boolean aCs;

    protected abstract boolean FC();

    protected abstract boolean FD();

    public final boolean b(View view, MotionEvent motionEvent) {
        return !this.aCs && FC();
    }

    public final boolean c(View view, MotionEvent motionEvent) {
        return !this.aCs && FD();
    }
}
