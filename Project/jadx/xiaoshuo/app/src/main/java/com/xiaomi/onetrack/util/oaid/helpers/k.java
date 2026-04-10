package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.util.oaid.a.f;
import com.xiaomi.onetrack.util.p;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class k {
    private static final String c = "SamsungDeviceIDHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f7759a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f7760b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.SamsungDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7737a.f7759a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a("SamsungDeviceIDHelper", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0046 -> B:32:0x006d). Please report as a decompilation issue!!! */
    public String a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        String strA = "";
        if (context.bindService(intent, this.f7760b, 1)) {
            try {
                try {
                    try {
                        IBinder iBinderPoll = this.f7759a.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            return "";
                        }
                        strA = new f.a(iBinderPoll).a();
                        context.unbindService(this.f7760b);
                    } finally {
                        try {
                            context.unbindService(this.f7760b);
                        } catch (Exception e) {
                            p.a(c, e.getMessage());
                        }
                    }
                } catch (Exception e2) {
                    p.a(c, e2.getMessage());
                }
            } catch (Exception e3) {
                p.a(c, e3.getMessage());
                context.unbindService(this.f7760b);
            }
        }
        return strA;
    }
}
