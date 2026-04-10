package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.c;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahk = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahi = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.ahk.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public c(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String oaid = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.ahi, 1)) {
                try {
                    try {
                        oaid = new c.a(this.ahk.take()).getOaid();
                        new StringBuilder("getOAID oaid:").append(oaid);
                        context = this.mContext;
                    } catch (Throwable th) {
                        this.mContext.unbindService(this.ahi);
                        throw th;
                    }
                } catch (Exception unused) {
                    context = this.mContext;
                }
                context.unbindService(this.ahi);
            }
        } catch (Exception unused2) {
        }
        return oaid;
    }
}
