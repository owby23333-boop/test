package com.ss.android.downloadlib.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class je extends Handler {
    WeakReference<mb> mb;

    public interface mb {
        void mb(Message message);
    }

    public je(Looper looper, mb mbVar) {
        super(looper);
        this.mb = new WeakReference<>(mbVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        mb mbVar = this.mb.get();
        if (mbVar == null || message == null) {
            return;
        }
        mbVar.mb(message);
    }
}
