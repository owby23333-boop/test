package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class bk extends Handler {
    private WeakReference<a> aAu;

    public interface a {
        void a(Message message);
    }

    public bk(a aVar) {
        this.aAu = new WeakReference<>(aVar);
    }

    public bk(a aVar, Looper looper) {
        super(looper);
        this.aAu = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
            if (this.aAu == null || (aVar = this.aAu.get()) == null) {
                return;
            } else {
                aVar.a(message);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        super.handleMessage(message);
    }
}
