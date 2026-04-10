package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CoolpadDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class ab implements z {
    private static final String a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19434c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f19435d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CountDownLatch f19437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f19438g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19436e = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ServiceConnection f19439h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.f19435d = a.AbstractBinderC0544a.a(iBinder);
                ab.this.f19436e = ab.f19435d.b(ab.this.f19438g.getPackageName());
                String str = "onServiceConnected: oaid = " + ab.this.f19436e;
            } catch (RemoteException | NullPointerException e2) {
                String str2 = "onServiceConnected failed e=" + e2.getMessage();
            }
            ab.this.f19437f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a unused = ab.f19435d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, f19434c));
            context.bindService(intent, this.f19439h, 1);
        } catch (Throwable th) {
            String str = "bindService failed. e=" + th.getMessage();
            this.f19437f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f19439h);
        } catch (Throwable th) {
            String str = "unbindService failed. e=" + th.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f19438g = context.getApplicationContext();
        this.f19437f = new CountDownLatch(1);
        try {
            b(context);
            this.f19437f.await(500L, TimeUnit.MILLISECONDS);
            return this.f19436e;
        } catch (InterruptedException e2) {
            String str = "getOAID interrupted. e=" + e2.getMessage();
            return null;
        } finally {
            c(context);
        }
    }
}
