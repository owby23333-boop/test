package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.anythink.china.a.a.i;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.j.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                j.this.a.put(iBinder);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6336c;

    public j(Context context) {
        this.f6336c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.f6336c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (!this.f6336c.bindService(intent, this.b, 1)) {
            aVar.a();
            return;
        }
        try {
            aVar.a(new i.a(this.a.take()).a(), false);
        } catch (Throwable th2) {
            th2.printStackTrace();
            th2.getMessage();
            aVar.a();
        }
    }
}
