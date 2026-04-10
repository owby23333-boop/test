package com.bytedance.adsdk.ugeno.tg;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class v extends Handler {
    private final WeakReference<e> e;

    public interface e {
        void e(Message message);
    }

    public v(Looper looper, e eVar) {
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
