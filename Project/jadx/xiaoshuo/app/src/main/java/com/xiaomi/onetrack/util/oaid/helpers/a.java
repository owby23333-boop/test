package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.util.oaid.a.a;
import com.xiaomi.onetrack.util.p;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final String c = "ASUSDeviceIDHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f7739a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f7740b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.ASUSDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7732a.f7739a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a("ASUSDeviceIDHelper", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0050 -> B:28:0x0077). Please report as a decompilation issue!!! */
    public String a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        String strA = "";
        try {
        } catch (Exception e) {
            p.a(c, e.getMessage());
        }
        if (context.bindService(intent, this.f7740b, 1)) {
            try {
                try {
                    IBinder iBinderPoll = this.f7739a.poll(1L, TimeUnit.SECONDS);
                    if (iBinderPoll == null) {
                        return "";
                    }
                    strA = new a.C0548a(iBinderPoll).a();
                    context.unbindService(this.f7740b);
                } finally {
                    try {
                        context.unbindService(this.f7740b);
                    } catch (Exception e2) {
                        p.a(c, e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                p.a(c, e3.getMessage());
                context.unbindService(this.f7740b);
            }
        }
        return strA;
    }
}
