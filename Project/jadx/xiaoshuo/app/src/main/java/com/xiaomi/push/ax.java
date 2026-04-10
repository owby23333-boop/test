package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.yuewen.yg3;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes8.dex */
class ax implements aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f156a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f159a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f160a = new Object();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7809b;
        String c;
        String d;

        private a() {
            this.f161a = null;
            this.f7809b = null;
            this.c = null;
            this.d = null;
        }
    }

    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ax.this.f159a != null) {
                return;
            }
            new Thread(new az(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public ax(Context context) {
        this.f157a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m201b() {
        ServiceConnection serviceConnection = this.f158a;
        if (serviceConnection != null) {
            try {
                this.f157a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f157a.getPackageManager().getPackageInfo(this.f157a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(yg3.b.f20351b);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public boolean mo195a() {
        return f7807a;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public String mo194a() {
        a("getOAID");
        if (this.f159a == null) {
            return null;
        }
        return this.f159a.f7809b;
    }

    private void a() {
        boolean zBindService;
        this.f158a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            zBindService = this.f157a.bindService(intent, this.f158a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f156a = zBindService ? 1 : 2;
    }

    private void a(String str) {
        if (this.f156a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f160a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m106a("oppo's " + str + " wait...");
                this.f160a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = packageInfo.getLongVersionCode();
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f7807a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
