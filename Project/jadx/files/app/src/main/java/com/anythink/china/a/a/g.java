package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.china.a.a.h;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    h a;
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.a = h.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            g.this.a = null;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6335c;

    public g(Context context) {
        this.f6335c = context;
    }

    public final String a(com.anythink.china.a.a aVar) {
        String strA = "";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return "";
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (this.f6335c.bindService(intent, this.b, 1)) {
            try {
                SystemClock.sleep(com.anythink.expressad.video.module.a.a.m.ag);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.a != null) {
                strA = a("OUID");
                aVar.a(strA, false);
            }
        }
        if (TextUtils.isEmpty(strA)) {
            aVar.a();
        }
        return strA;
    }

    private String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f6335c.getPackageName();
        String string = null;
        try {
            signatureArr = this.f6335c.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Exception e2) {
            e2.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    string = sb.toString();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return ((h.a.C0146a) this.a).a(packageName, string, str);
    }
}
