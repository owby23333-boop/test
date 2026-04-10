package com.alipay.sdk.m.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.sdk.m.p0.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.alipay.sdk.m.c.b {

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f1803b;

        public b() {
            this.f1802a = false;
            this.f1803b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f1802a) {
                throw new IllegalStateException();
            }
            this.f1802a = true;
            return this.f1803b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f1803b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        b bVar = new b();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, bVar, 1)) {
            try {
                return a.AbstractBinderC0033a.a(bVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }
}
