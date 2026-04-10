package org.greenrobot.eventbus;

import android.os.Looper;

/* JADX INFO: compiled from: MainThreadSupport.java */
/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: compiled from: MainThreadSupport.java */
    public static class a implements g {
        private final Looper a;

        public a(Looper looper) {
            this.a = looper;
        }

        @Override // org.greenrobot.eventbus.g
        public boolean a() {
            return this.a == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.g
        public k a(c cVar) {
            return new e(cVar, this.a, 10);
        }
    }

    k a(c cVar);

    boolean a();
}
