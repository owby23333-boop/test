package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* JADX INFO: loaded from: classes8.dex */
class an implements aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f134a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile String f138a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private volatile boolean f139b = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f7795b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f137a = new Object();

    public class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new Thread(new ap(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public an(Context context) {
        this.f135a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f136a;
        if (serviceConnection != null) {
            try {
                this.f135a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo195a() {
        return f7794a;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo194a() {
        a("getOAID");
        return this.f138a;
    }

    private void a() {
        boolean zBindService;
        this.f136a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            zBindService = this.f135a.bindService(intent, this.f136a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f134a = zBindService ? 1 : 2;
    }

    public static class b {
        public static String a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f1793a);
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public static boolean m196a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f1793a);
                iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    private void a(String str) {
        if (this.f134a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f137a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m106a("huawei's " + str + " wait...");
                this.f137a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            f7794a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }
}
