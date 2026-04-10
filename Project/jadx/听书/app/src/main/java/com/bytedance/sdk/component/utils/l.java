package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class l extends Handler {
    protected WeakReference<z> z;

    public interface z {
        void z(Message message);
    }

    public l(Looper looper, z zVar) {
        super(looper);
        if (zVar != null) {
            this.z = new WeakReference<>(zVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        z zVar;
        WeakReference<z> weakReference = this.z;
        if (weakReference == null || (zVar = weakReference.get()) == null || message == null) {
            return;
        }
        zVar.z(message);
    }
}
