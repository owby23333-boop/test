package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.f;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public Context mContext;
    private final LinkedBlockingQueue<IBinder> ahk = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahi = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.j.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                j.this.ahk.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public j(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String oaid = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.mContext.getPackageName());
            boolean zBindService = this.mContext.bindService(intent, this.ahi, 1);
            new StringBuilder("getOAID isBind=").append(zBindService);
            if (zBindService) {
                try {
                    oaid = new f.a(this.ahk.take()).getOAID();
                    new StringBuilder("getOAID oaid:").append(oaid);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.ahi);
                    throw th;
                }
                context.unbindService(this.ahi);
            }
        } catch (Exception unused2) {
        }
        return oaid;
    }
}
