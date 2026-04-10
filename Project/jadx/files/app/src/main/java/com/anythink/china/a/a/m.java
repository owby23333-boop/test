package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.anythink.china.a.a.l;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    l a;
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.m.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.this.a = new l.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6338c;

    public m(Context context) {
        this.f6338c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f6338c.bindService(intent, this.b, 1) || this.a == null) {
                aVar.a();
            } else {
                aVar.a(this.a.a(), false);
            }
        } catch (Throwable th) {
            th.getMessage();
            aVar.a();
        }
    }
}
