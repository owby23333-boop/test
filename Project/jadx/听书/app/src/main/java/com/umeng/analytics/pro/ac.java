package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CoolpadDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
public class ac implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2163a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";
    private static final String c = "com.coolpad.deviceidsupport.DeviceIdService";
    private static a d;
    private CountDownLatch f;
    private Context g;
    private String e = "";
    private final ServiceConnection h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ac.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ac.d = a.AbstractBinderC0487a.a(iBinder);
                ac.this.e = ac.d.b(ac.this.g.getPackageName());
                Log.d(ac.f2163a, "onServiceConnected: oaid = " + ac.this.e);
            } catch (RemoteException | NullPointerException e) {
                Log.e(ac.f2163a, "onServiceConnected failed e=" + e.getMessage());
            }
            ac.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ac.f2163a, "onServiceDisconnected");
            a unused = ac.d = null;
        }
    };

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(f2163a, "getOAID time-out");
            }
            return this.e;
        } catch (InterruptedException e) {
            Log.e(f2163a, "getOAID interrupted. e=" + e.getMessage());
            return null;
        } finally {
            c(context);
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, c));
            if (context.bindService(intent, this.h, 1)) {
                return;
            }
            Log.e(f2163a, "bindService return false");
        } catch (Throwable th) {
            Log.e(f2163a, "bindService failed. e=" + th.getMessage());
            this.f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(f2163a, "call unbindService.");
            context.unbindService(this.h);
        } catch (Throwable th) {
            Log.e(f2163a, "unbindService failed. e=" + th.getMessage());
        }
    }
}
