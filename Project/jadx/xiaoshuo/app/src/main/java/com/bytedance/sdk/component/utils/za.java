package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class za extends Handler {
    protected WeakReference<e> e;

    public interface e {
        void e(Message message);
    }

    public za(e eVar) {
        if (eVar != null) {
            this.e = new WeakReference<>(eVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar;
        WeakReference<e> weakReference = this.e;
        if (weakReference == null || (eVar = weakReference.get()) == null || message == null) {
            return;
        }
        eVar.e(message);
    }

    public za(Looper looper, e eVar) {
        super(looper);
        if (eVar != null) {
            this.e = new WeakReference<>(eVar);
        }
    }
}
