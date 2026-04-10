package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
public class aj implements aa {
    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return b.a.a(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2172a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() throws InterruptedException {
            if (this.f2172a) {
                throw new IllegalStateException();
            }
            this.f2172a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        private a() {
            this.f2172a = false;
            this.b = new LinkedBlockingQueue<>();
        }
    }
}
