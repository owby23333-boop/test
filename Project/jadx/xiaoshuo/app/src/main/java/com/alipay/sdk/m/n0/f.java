package com.alipay.sdk.m.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static volatile f g = null;
    public static boolean h = false;
    public BroadcastReceiver f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1883a = new a("udid");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1884b = new a("oaid");
    public a d = new a("vaid");
    public a c = new a("aaid");
    public c e = new c();

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    dVar.f1881a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.f1882b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r10, com.alipay.sdk.m.n0.a r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r6 = r11.c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            if (r1 == 0) goto L7b
            com.alipay.sdk.m.n0.d r2 = a(r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r0 = r2.f1881a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.a(r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            long r3 = r2.c     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.a(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r3 = r2.f1882b     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.a(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.<init>()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r4 = r11.c     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.append(r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r11 = r11.d     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.append(r11)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            a(r11)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r11 = r2.f1882b     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L8f
            r9.b(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r11 != 0) goto L8f
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L76:
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L8c
        L7b:
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r11 == 0) goto L8f
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L76
        L8c:
            a(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L8f:
            if (r1 == 0) goto Lbb
            goto Lb6
        L92:
            r10 = move-exception
            r0 = r1
            goto Lbc
        L95:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto L9d
        L99:
            r10 = move-exception
            goto Lbc
        L9b:
            r10 = move-exception
            r11 = r0
        L9d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L99
            r1.append(r10)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L99
            a(r10)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lba
            r1 = r0
            r0 = r11
        Lb6:
            r1.close()
            goto Lbb
        Lba:
            r0 = r11
        Lbb:
            return r0
        Lbc:
            if (r0 == 0) goto Lc1
            r0.close()
        Lc1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.n0.f.b(android.content.Context, com.alipay.sdk.m.n0.a):java.lang.String");
    }

    public static final f a() {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    public static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            a("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.f1876b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final synchronized void b(Context context) {
        if (this.f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static void a(String str) {
        if (h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[PHI: r7
  0x0057: PHI (r7v3 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:18:0x0055, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            if (r7 == 0) goto L3a
            com.alipay.sdk.m.n0.d r8 = a(r7)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            int r1 = r8.f1882b     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r1) goto L35
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f1881a     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            if (r8 == 0) goto L36
        L35:
            r0 = 1
        L36:
            r7.close()
            return r0
        L3a:
            if (r7 == 0) goto L5a
            goto L57
        L3d:
            r8 = move-exception
            goto L5b
        L3f:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L3d
            r1.append(r8)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L3d
            a(r8)     // Catch: java.lang.Throwable -> L3d
            if (r7 == 0) goto L5a
        L57:
            r7.close()
        L5a:
            return r0
        L5b:
            if (r7 == 0) goto L60
            r7.close()
        L60:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.n0.f.a(android.content.Context):boolean");
    }

    public final boolean a(Context context, boolean z) {
        if (this.e.a() && !z) {
            return this.e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.e.a() && this.e.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.e.b();
        }
        this.e.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.e.a(zA);
        return zA;
    }
}
