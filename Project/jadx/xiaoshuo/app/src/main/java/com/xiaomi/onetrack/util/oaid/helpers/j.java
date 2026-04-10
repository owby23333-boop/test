package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.xiaomi.onetrack.util.oaid.a.e;
import com.xiaomi.onetrack.util.p;
import com.yuewen.yg3;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class j {
    private static final String d = "OppoDeviceIDHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.xiaomi.onetrack.util.oaid.a.e f7757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f7758b = new LinkedBlockingQueue<>(1);
    ServiceConnection c = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.OppoDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7736a.f7758b.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a("OppoDeviceIDHelper", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f7736a.f7757a = null;
        }
    };
    private String e;

    private boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo == null) {
                return false;
            }
            return ((long) packageInfo.versionCode) >= 1;
        } catch (Exception e) {
            p.a(d, e.getMessage());
            return true;
        }
    }

    public String a(Context context) {
        String strA;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        strA = "";
        if (context.bindService(intent, this.c, 1)) {
            try {
                try {
                    try {
                        IBinder iBinderPoll = this.f7758b.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            return "";
                        }
                        com.xiaomi.onetrack.util.oaid.a.e eVarA = e.a.a(iBinderPoll);
                        this.f7757a = eVarA;
                        strA = eVarA != null ? a("OUID", context) : "";
                        context.unbindService(this.c);
                    } finally {
                        try {
                            context.unbindService(this.c);
                        } catch (Exception e) {
                            p.a(d, e.getMessage());
                        }
                    }
                } catch (Exception e2) {
                    p.a(d, e2.getMessage());
                }
            } catch (Exception e3) {
                p.a(d, e3.getMessage());
                context.unbindService(this.c);
            }
        }
        return strA;
    }

    private String a(String str, Context context) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (this.e == null) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(yg3.b.f20351b);
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : bArrDigest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.e = string;
        }
        return ((e.a.C0551a) this.f7757a).a(packageName, this.e, str);
    }
}
