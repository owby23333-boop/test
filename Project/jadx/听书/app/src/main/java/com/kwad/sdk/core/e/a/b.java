package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.kwad.sdk.core.e.a.c;
import com.kwad.sdk.core.e.b.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "onServiceConnected ： " + iBinder);
                b.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e);
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    private c.C0402c Ii() {
        Context context;
        ServiceConnection serviceConnection;
        c cVar = new c();
        cVar.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (c.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    try {
                        cVar.aFR = new c.C0402c();
                        b.a aVar = new b.a(this.mLinkedBlockingQueue.take());
                        aVar.a(cVar.aFS);
                        aVar.b(cVar.aFT);
                        cVar.mCountDownLatch.await(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    }
                    context.unbindService(serviceConnection);
                } catch (Throwable th) {
                    this.mContext.unbindService(this.serviceConnection);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "getOAID honor service not found" + th2);
        }
        return cVar.aFR;
    }

    public final String getOAID() {
        String string;
        try {
            string = Settings.Global.getString(this.mContext.getContentResolver(), "oaid");
        } catch (Throwable th) {
            th = th;
            string = "";
        }
        try {
            if (TextUtils.isEmpty(string)) {
                string = Settings.Secure.getString(this.mContext.getContentResolver(), "oaid");
            }
            com.kwad.sdk.core.d.c.i("HONORDeviceIDHelper", "getOAID secure: " + string);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        if (string != null && !string.isEmpty()) {
            return string;
        }
        c.C0402c c0402cIi = Ii();
        return c0402cIi != null ? c0402cIi.aoB : "";
    }
}
