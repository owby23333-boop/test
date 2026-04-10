package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.util.oaid.a.b;
import com.xiaomi.onetrack.util.p;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class d {
    private static final String c = "HWDeviceIDHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f7745a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f7746b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.HWDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7733a.f7745a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a("HWDeviceIDHelper", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0046 -> B:32:0x006d). Please report as a decompilation issue!!! */
    public String a(Context context) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        String strA = "";
        if (context.bindService(intent, this.f7746b, 1)) {
            try {
                try {
                    try {
                        IBinder iBinderPoll = this.f7745a.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            return "";
                        }
                        strA = new b.a(iBinderPoll).a();
                        context.unbindService(this.f7746b);
                    } finally {
                        try {
                            context.unbindService(this.f7746b);
                        } catch (Exception e) {
                            p.a(c, e.getMessage());
                        }
                    }
                } catch (Exception e2) {
                    p.a(c, e2.getMessage());
                }
            } catch (Exception e3) {
                p.a(c, e3.getMessage());
                context.unbindService(this.f7746b);
            }
        }
        return strA;
    }
}
