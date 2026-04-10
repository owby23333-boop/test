package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: ResourceRecycler.java */
/* JADX INFO: loaded from: classes2.dex */
class v {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: ResourceRecycler.java */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((s) message.obj).recycle();
            return true;
        }
    }

    v() {
    }

    synchronized void a(s<?> sVar, boolean z2) {
        if (this.a || z2) {
            this.b.obtainMessage(1, sVar).sendToTarget();
        } else {
            this.a = true;
            sVar.recycle();
            this.a = false;
        }
    }
}
