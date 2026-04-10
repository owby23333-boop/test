package com.amgcyo.cuttadon.h.b;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CsjWeakHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends Handler {
    private final WeakReference<a> a;

    /* JADX INFO: compiled from: CsjWeakHandler.java */
    public interface a {
        void handleMsg(Message message);
    }

    public e(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.handleMsg(message);
    }
}
