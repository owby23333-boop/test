package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.util.oaid.a.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f7747a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f7748b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.LenovoDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7734a.f7747a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public String a(Context context) {
        context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        String strA = "";
        if (context.bindService(intent, this.f7748b, 1)) {
            try {
                try {
                    IBinder iBinderPoll = this.f7747a.poll(1L, TimeUnit.SECONDS);
                    if (iBinderPoll == null) {
                        return "";
                    }
                    strA = new c.a.C0549a(iBinderPoll).a();
                } finally {
                    try {
                        context.unbindService(this.f7748b);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                context.unbindService(this.f7748b);
            } catch (Exception unused2) {
            }
        }
        return strA;
    }
}
