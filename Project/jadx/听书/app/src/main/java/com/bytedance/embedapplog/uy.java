package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
final class uy<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f306a;
    private final g<SERVICE, RESULT> dl;
    private final Intent g;
    private final CountDownLatch z = new CountDownLatch(1);

    interface g<T, RESULT> {
        T z(IBinder iBinder);

        RESULT z(T t);
    }

    uy(Context context, Intent intent, g<SERVICE, RESULT> gVar) {
        this.f306a = context;
        this.g = intent;
        this.dl = gVar;
    }

    RESULT z() {
        uy<SERVICE, RESULT>.z zVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            cb.dl("Don't do this in ui thread.", null);
            return null;
        }
        try {
            zVar = new z(this.z, this.dl);
            this.f306a.bindService(this.g, zVar, 1);
            this.z.await();
        } catch (Throwable th) {
            th = th;
            zVar = null;
        }
        try {
            return this.dl.z(zVar.z);
        } catch (Throwable th2) {
            th = th2;
            try {
                cb.z(th);
                return null;
            } finally {
                z(zVar);
            }
        }
    }

    private void z(uy<SERVICE, RESULT>.z zVar) {
        if (zVar != null) {
            try {
                this.f306a.unbindService(zVar);
            } catch (Throwable th) {
                cb.z(th);
            }
        }
    }

    class z implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g<SERVICE, RESULT> f307a;
        private final CountDownLatch dl;
        SERVICE z;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        z(CountDownLatch countDownLatch, g<SERVICE, RESULT> gVar) {
            this.dl = countDownLatch;
            this.f307a = gVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            cb.z("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.z = this.f307a.z(iBinder);
            } catch (Throwable th) {
                try {
                    cb.dl("ServiceBlockBinder#onServiceConnected", th);
                    try {
                        this.dl.countDown();
                    } catch (Exception e) {
                        cb.z(e);
                    }
                } finally {
                    try {
                        this.dl.countDown();
                    } catch (Exception e2) {
                        cb.z(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            cb.z("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.dl.countDown();
            } catch (Exception e) {
                cb.z(e);
            }
        }
    }
}
