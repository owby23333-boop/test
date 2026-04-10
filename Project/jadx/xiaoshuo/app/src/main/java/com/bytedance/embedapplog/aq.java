package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class aq<SERVICE, RESULT> {
    private final Intent bf;
    private final bf<SERVICE, RESULT> d;
    private final CountDownLatch e = new CountDownLatch(1);
    private final Context tg;

    public interface bf<T, RESULT> {
        T bf(IBinder iBinder);

        RESULT e(T t);
    }

    public class e implements ServiceConnection {
        private final CountDownLatch d;

        @Nullable
        SERVICE e;
        private final bf<SERVICE, RESULT> tg;

        public e(CountDownLatch countDownLatch, bf<SERVICE, RESULT> bfVar) {
            this.d = countDownLatch;
            this.tg = bfVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            tx.e("ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                try {
                    this.e = this.tg.bf(iBinder);
                    this.d.countDown();
                } catch (Throwable th) {
                    try {
                        tx.d("ServiceBlockBinder#onServiceConnected", th);
                        this.d.countDown();
                    } catch (Throwable th2) {
                        try {
                            this.d.countDown();
                        } catch (Exception e) {
                            tx.e(e);
                        }
                        throw th2;
                    }
                }
            } catch (Exception e2) {
                tx.e(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            tx.e("ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.d.countDown();
            } catch (Exception e) {
                tx.e(e);
            }
        }
    }

    public aq(Context context, Intent intent, bf<SERVICE, RESULT> bfVar) {
        this.tg = context;
        this.bf = intent;
        this.d = bfVar;
    }

    public RESULT e() {
        aq<SERVICE, RESULT>.e eVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            tx.d("Don't do this in ui thread.", null);
            return null;
        }
        try {
            eVar = new e(this.e, this.d);
            this.tg.bindService(this.bf, eVar, 1);
            this.e.await();
        } catch (Throwable th) {
            th = th;
            eVar = null;
        }
        try {
            return this.d.e(eVar.e);
        } catch (Throwable th2) {
            th = th2;
            try {
                tx.e(th);
                return null;
            } finally {
                e(eVar);
            }
        }
    }

    private void e(aq<SERVICE, RESULT>.e eVar) {
        if (eVar != null) {
            try {
                this.tg.unbindService(eVar);
            } catch (Throwable th) {
                tx.e(th);
            }
        }
    }
}
