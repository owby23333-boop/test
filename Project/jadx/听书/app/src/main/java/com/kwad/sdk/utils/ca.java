package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ca extends Handler {
    private WeakReference<a> bbJ;

    public interface a {
        void a(Message message);
    }

    public ca(a aVar) {
        this.bbJ = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
            WeakReference<a> weakReference = this.bbJ;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            } else {
                aVar.a(message);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        super.handleMessage(message);
    }
}
