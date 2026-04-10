package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class j1<SERVICE, RESULT> {
    private final CountDownLatch a = new CountDownLatch(1);
    private final Intent b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<SERVICE, RESULT> f713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f714d;

    class a implements ServiceConnection {
        private final CountDownLatch a;
        private final b<SERVICE, RESULT> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        SERVICE f715c;

        a(j1 j1Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.a = countDownLatch;
            this.b = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            t0.b("Oaid#", "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                try {
                    this.f715c = this.b.a(iBinder);
                    this.a.countDown();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        t0.b("Oaid#", "ServiceBlockBinder#onServiceConnected", th);
                        this.a.countDown();
                    } catch (Throwable th2) {
                        try {
                            this.a.countDown();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        throw th2;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            t0.b("Oaid#", "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.a.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t2);
    }

    j1(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.f714d = context;
        this.b = intent;
        this.f713c = bVar;
    }

    private void a(j1<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.f714d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    RESULT a() {
        Throwable th;
        j1<SERVICE, RESULT>.a aVar;
        RESULT resultA = null;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            try {
                aVar = new a(this, this.a, this.f713c);
                this.f714d.bindService(this.b, aVar, 1);
                this.a.await();
                try {
                    resultA = this.f713c.a(aVar.f715c);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        a(aVar);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        }
        return resultA;
    }
}
