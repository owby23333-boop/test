package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.h1;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;

/* JADX INFO: loaded from: classes.dex */
final class v0 implements a1 {
    private static final o0<Boolean> a = new a();

    static final class a extends o0<Boolean> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(u0.a((Context) objArr[0], "com.huawei.hwid"));
        }
    }

    static final class b implements j1.b<h1, Pair<String, Boolean>> {
        b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public Pair<String, Boolean> a(h1 h1Var) {
            if (h1Var == null) {
                return null;
            }
            return new Pair<>(h1Var.a(), Boolean.valueOf(h1Var.c()));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h1 a(IBinder iBinder) {
            return h1.a.a(iBinder);
        }
    }

    static class c extends a1.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f758c = 0;

        c() {
        }
    }

    v0() {
    }

    static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return a.b(context).booleanValue();
    }

    private static int e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Nullable
    private static Pair<String, Boolean> f(Context context) {
        return (Pair) new j1(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new b()).a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return d(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public bykvm_19do.bykvm_19do.bykvm_19do.v0.c b(android.content.Context r5) {
        /*
            r4 = this;
            bykvm_19do.bykvm_19do.bykvm_19do.v0$c r0 = new bykvm_19do.bykvm_19do.bykvm_19do.v0$c
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L39
            android.content.ContentResolver r1 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "pps_oaid"
            java.lang.String r1 = android.provider.Settings.Global.getString(r1, r2)     // Catch: java.lang.Throwable -> L35
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = "pps_track_limit"
            java.lang.String r2 = android.provider.Settings.Global.getString(r2, r3)     // Catch: java.lang.Throwable -> L35
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L35
            if (r3 != 0) goto L39
            r0.a = r1     // Catch: java.lang.Throwable -> L35
            boolean r1 = java.lang.Boolean.parseBoolean(r2)     // Catch: java.lang.Throwable -> L35
            r0.b = r1     // Catch: java.lang.Throwable -> L35
            r1 = 202003021704(0x2f08517f88, double:9.980275338E-313)
            r0.f758c = r1     // Catch: java.lang.Throwable -> L35
            goto L56
        L35:
            r1 = move-exception
            r1.printStackTrace()
        L39:
            android.util.Pair r1 = f(r5)
            if (r1 == 0) goto L56
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            r0.a = r2
            java.lang.Object r1 = r1.second
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.b = r1
            int r5 = e(r5)
            long r1 = (long) r5
            r0.f758c = r1
        L56:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.v0.b(android.content.Context):bykvm_19do.bykvm_19do.bykvm_19do.v0$c");
    }
}
