package com.ss.android.downloadlib.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class bh extends Handler {
    WeakReference<e> e;

    public interface e {
        void e(Message message);
    }

    public bh(Looper looper, e eVar) {
        super(looper);
        this.e = new WeakReference<>(eVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar = this.e.get();
        if (eVar == null || message == null) {
            return;
        }
        eVar.e(message);
    }
}
