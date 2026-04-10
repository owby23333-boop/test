package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.d;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahk = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahi = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                f.this.ahk.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.mContext = context;
    }

    private String wV() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getOAID() {
        Context context;
        String serID = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean zBindService = this.mContext.bindService(intent, this.ahi, 1);
            new StringBuilder("getOAID isBin=").append(zBindService);
            if (zBindService) {
                try {
                    try {
                        serID = new d.a(this.ahk.take()).getSerID(this.mContext.getPackageName(), wV(), "OUID");
                        new StringBuilder("getOAID oaid").append(serID);
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
        return serID;
    }
}
