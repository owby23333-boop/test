package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.b;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahk = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahi = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.ahk.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String strWW = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.mContext.bindService(intent, this.ahi, 1)) {
                try {
                    b.a aVar = new b.a(this.ahk.take());
                    strWW = aVar.wW();
                    boolean zWX = aVar.wX();
                    StringBuilder sb = new StringBuilder("getOAID oaid:");
                    sb.append(strWW);
                    sb.append("--boos:");
                    sb.append(zWX);
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
        return strWW;
    }
}
