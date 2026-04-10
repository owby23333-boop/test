package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.e;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final LinkedBlockingQueue<IBinder> ahh = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahi = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                g.this.ahh.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String id = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (this.mContext.bindService(intent, this.ahi, 1)) {
                try {
                    try {
                        id = new e.a(this.ahh.take()).getID();
                        new StringBuilder("getOAID oaid:").append(id);
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
        return id;
    }
}
