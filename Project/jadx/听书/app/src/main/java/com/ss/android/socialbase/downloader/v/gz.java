package com.ss.android.socialbase.downloader.v;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class gz extends Handler {
    private final WeakReference<z> z;

    public interface z {
        void z(Message message);
    }

    public gz(Looper looper, z zVar) {
        super(looper);
        this.z = new WeakReference<>(zVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        z zVar = this.z.get();
        if (zVar == null || message == null) {
            return;
        }
        zVar.z(message);
    }
}
