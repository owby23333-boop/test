package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.util.oaid.a.g;
import com.xiaomi.onetrack.util.p;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class m {
    private static final String d = "ZTEDeviceIDHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f7762a = "com.mdid.msa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f7763b = new LinkedBlockingQueue<>(1);
    ServiceConnection c = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.ZTEDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7738a.f7763b.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a("ZTEDeviceIDHelper", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private void a(String str, Context context) {
        Intent intent = new Intent();
        intent.setClassName(this.f7762a, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            p.a(d, e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006a -> B:33:0x0091). Please report as a decompilation issue!!! */
    public String a(Context context) {
        try {
            context.getPackageManager().getPackageInfo(this.f7762a, 0);
        } catch (Exception e) {
            p.a(d, e.getMessage());
        }
        String packageName = context.getPackageName();
        a(packageName, context);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        boolean zBindService = context.bindService(intent, this.c, 1);
        String strB = "";
        try {
            try {
            } catch (Exception e2) {
                String message = e2.getMessage();
                p.a(d, message);
                context = message;
            }
            if (zBindService) {
                try {
                    IBinder iBinderPoll = this.f7763b.poll(1L, TimeUnit.SECONDS);
                    if (iBinderPoll == null) {
                        return "";
                    }
                    strB = new g.a.C0552a(iBinderPoll).b();
                    context.unbindService(this.c);
                    context = context;
                } catch (Exception e3) {
                    p.a(d, e3.getMessage());
                    context.unbindService(this.c);
                    context = context;
                }
            }
            return strB;
        } finally {
            try {
                context.unbindService(this.c);
            } catch (Exception e4) {
                p.a(d, e4.getMessage());
            }
        }
    }
}
