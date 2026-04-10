package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Can't wrap try/catch for region: R(30:0|2|132|3|(1:5)(1:6)|7|140|8|9|(4:137|11|(2:13|146)(1:147)|14)|145|15|142|16|(4:130|17|18|(1:20)(1:148))|21|139|22|(1:24)|150|(5:25|(1:27)(1:149)|102|103|104)|28|(1:30)|124|31|35|102|103|104|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b8, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0148 A[PHI: r1 r2 r3 r4 r7 r12
  0x0148: PHI (r1v8 java.lang.String) = (r1v6 java.lang.String), (r1v9 java.lang.String), (r1v27 java.lang.String) binds: [B:85:0x0123, B:101:0x0146, B:35:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x0148: PHI (r2v5 java.lang.String) = (r2v3 java.lang.String), (r2v6 java.lang.String), (r2v13 java.lang.String) binds: [B:85:0x0123, B:101:0x0146, B:35:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x0148: PHI (r3v3 int) = (r3v1 int), (r3v4 int), (r3v5 int) binds: [B:85:0x0123, B:101:0x0146, B:35:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x0148: PHI (r4v9 java.io.DataOutputStream) = (r4v7 java.io.DataOutputStream), (r4v10 java.io.DataOutputStream), (r4v12 java.io.DataOutputStream) binds: [B:85:0x0123, B:101:0x0146, B:35:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x0148: PHI (r7v6 java.io.BufferedReader) = (r7v4 java.io.BufferedReader), (r7v7 java.io.BufferedReader), (r7v13 java.io.BufferedReader) binds: [B:85:0x0123, B:101:0x0146, B:35:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x0148: PHI (r12v18 ??) = (r12v16 ??), (r12v19 ??), (r12v22 ??) binds: [B:85:0x0123, B:101:0x0146, B:35:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0161 A[Catch: IOException -> 0x015d, TryCatch #20 {IOException -> 0x015d, blocks: (B:110:0x0159, B:114:0x0161, B:116:0x0166), top: B:134:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0166 A[Catch: IOException -> 0x015d, TRY_LEAVE, TryCatch #20 {IOException -> 0x015d, blocks: (B:110:0x0159, B:114:0x0161, B:116:0x0166), top: B:134:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0117 A[Catch: IOException -> 0x0113, TryCatch #5 {IOException -> 0x0113, blocks: (B:76:0x010f, B:80:0x0117, B:82:0x011c), top: B:128:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011c A[Catch: IOException -> 0x0113, TRY_LEAVE, TryCatch #5 {IOException -> 0x0113, blocks: (B:76:0x010f, B:80:0x0117, B:82:0x011c), top: B:128:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013a A[Catch: IOException -> 0x0136, TryCatch #3 {IOException -> 0x0136, blocks: (B:92:0x0132, B:96:0x013a, B:98:0x013f), top: B:126:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013f A[Catch: IOException -> 0x0136, TRY_LEAVE, TryCatch #3 {IOException -> 0x0136, blocks: (B:92:0x0132, B:96:0x013a, B:98:0x013f), top: B:126:0x0132 }] */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r12v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v22, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yxcorp.kuaishou.addfp.android.b.e a(java.lang.String r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(java.lang.String, boolean):com.yxcorp.kuaishou.addfp.android.b.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a():java.lang.String");
    }

    public static String a(int i2, String str) {
        String strA;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] strArrSplit = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(strArrSplit[0]);
        sb.append(strArrSplit[1]);
        sb.append(strArrSplit[2]);
        if (i2 == 0) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, strArrSplit[0], str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i2 == 1) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, strArrSplit[1], str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i2 == 2) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, strArrSplit[2], str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            strA = "";
        }
        return strA == null ? "" : strA;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[Catch: all -> 0x00c8, TryCatch #1 {all -> 0x00c8, blocks: (B:3:0x0004, B:6:0x0016, B:8:0x0020, B:19:0x0055, B:21:0x005b, B:24:0x0062, B:26:0x006c, B:30:0x007c, B:32:0x0082, B:33:0x0099, B:41:0x00bb, B:43:0x00c1, B:28:0x0072, B:13:0x0039, B:15:0x0043, B:17:0x0051), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ab A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #2 {all -> 0x0099, blocks: (B:37:0x00a3, B:39:0x00ab), top: B:55:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #1 {all -> 0x00c8, blocks: (B:3:0x0004, B:6:0x0016, B:8:0x0020, B:19:0x0055, B:21:0x005b, B:24:0x0062, B:26:0x006c, B:30:0x007c, B:32:0x0082, B:33:0x0099, B:41:0x00bb, B:43:0x00c1, B:28:0x0072, B:13:0x0039, B:15:0x0043, B:17:0x0051), top: B:53:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
