package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
class b {
    private static volatile b e;
    private static boolean f;
    private BroadcastReceiver h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OpenId f2552a = new OpenId("udid");
    OpenId b = new OpenId("oaid");
    OpenId d = new OpenId("vaid");
    OpenId c = new OpenId("aaid");
    private SupportInfo g = new SupportInfo();

    private b() {
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    private static ValueData a(Cursor cursor) {
        String str;
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    valueData.f2551a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    valueData.b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return valueData;
    }

    public static final b a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    static void a(String str) {
        if (f) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        f = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 0
            r4 = 0
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r6 = "supported"
            r5[r0] = r6     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r7 == 0) goto L3d
            org.repackage.com.meizu.flyme.openidsdk.ValueData r1 = a(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            int r2 = r1.b     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r2) goto L36
            java.lang.String r2 = "0"
            java.lang.String r1 = r1.f2551a     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r1 == 0) goto L37
        L36:
            r0 = r8
        L37:
            if (r7 == 0) goto L3c
            r7.close()
        L3c:
            return r0
        L3d:
            if (r7 == 0) goto L5f
        L3f:
            r7.close()
            goto L5f
        L43:
            r8 = move-exception
            goto L60
        L45:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L43
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r8 = r1.append(r8)     // Catch: java.lang.Throwable -> L43
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L43
            a(r8)     // Catch: java.lang.Throwable -> L43
            if (r7 == 0) goto L5f
            goto L3f
        L5f:
            return r0
        L60:
            if (r7 == 0) goto L65
            r7.close()
        L65:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.a(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r10, org.repackage.com.meizu.flyme.openidsdk.OpenId r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.b(android.content.Context, org.repackage.com.meizu.flyme.openidsdk.OpenId):java.lang.String");
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.h != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        a aVar = new a();
        this.h = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.a()) {
                return openId.b;
            }
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    final boolean a(Context context, boolean z) {
        if (this.g.a() && !z) {
            return this.g.b();
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
        if (this.g.a() && this.g.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.g.b();
        }
        this.g.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.g.a(zA);
        return zA;
    }
}
