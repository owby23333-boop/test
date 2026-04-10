package com.bytedance.msdk.core.wp;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final String z = "g";

    public static boolean z(Context context, String str) {
        return g(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean g(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = com.bytedance.msdk.core.wp.g.z
            java.lang.String r1 = "checkPermissinKITKATNew，permission："
            java.lang.String r2 = java.lang.String.valueOf(r7)
            java.lang.String r1 = r1.concat(r2)
            com.bytedance.msdk.z.gc.dl.a(r0, r1)
            r1 = 1
            int r2 = r7.hashCode()     // Catch: java.lang.Exception -> La4
            r3 = -1888586689(0xffffffff8f6e743f, float:-1.1756694E-29)
            r4 = 0
            r5 = 2
            if (r2 == r3) goto L3a
            r3 = -63024214(0xfffffffffc3e53aa, float:-3.9529332E36)
            if (r2 == r3) goto L30
            r3 = -5573545(0xffffffffffaaf457, float:NaN)
            if (r2 == r3) goto L26
            goto L44
        L26:
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            boolean r2 = r7.equals(r2)     // Catch: java.lang.Exception -> La4
            if (r2 == 0) goto L44
            r2 = r5
            goto L45
        L30:
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r2 = r7.equals(r2)     // Catch: java.lang.Exception -> La4
            if (r2 == 0) goto L44
            r2 = r4
            goto L45
        L3a:
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r2 = r7.equals(r2)     // Catch: java.lang.Exception -> La4
            if (r2 == 0) goto L44
            r2 = r1
            goto L45
        L44:
            r2 = -1
        L45:
            if (r2 == 0) goto L5e
            if (r2 == r1) goto L5b
            if (r2 == r5) goto L58
            java.lang.String r2 = "android.permission."
            java.lang.String r3 = "android:"
            java.lang.String r7 = r7.replaceFirst(r2, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r7 = r7.toLowerCase()     // Catch: java.lang.Exception -> La4
            goto L60
        L58:
            java.lang.String r7 = "android:read_phone_state"
            goto L60
        L5b:
            java.lang.String r7 = "android:fine_location"
            goto L60
        L5e:
            java.lang.String r7 = "android:coarse_location"
        L60:
            java.lang.String r2 = "appops"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Exception -> La4
            android.app.AppOpsManager r2 = (android.app.AppOpsManager) r2     // Catch: java.lang.Exception -> La4
            int r3 = android.os.Binder.getCallingUid()     // Catch: java.lang.Exception -> La4
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> La4
            int r6 = r2.checkOp(r7, r3, r6)     // Catch: java.lang.Exception -> La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La4
            java.lang.String r3 = "checkPermissinKITKATNew，locationOp,permission："
            r2.<init>(r3)     // Catch: java.lang.Exception -> La4
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Exception -> La4
            java.lang.String r3 = ","
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> La4
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch: java.lang.Exception -> La4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La4
            com.bytedance.msdk.z.gc.dl.a(r0, r2)     // Catch: java.lang.Exception -> La4
            if (r6 == 0) goto Lb4
            java.lang.String r6 = "checkPermissinKITKATNew，false,permission："
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> La1
            java.lang.String r6 = r6.concat(r7)     // Catch: java.lang.Exception -> La1
            com.bytedance.msdk.z.gc.dl.a(r0, r6)     // Catch: java.lang.Exception -> La1
            r1 = r4
            goto Lb4
        La1:
            r6 = move-exception
            r1 = r4
            goto La5
        La4:
            r6 = move-exception
        La5:
            java.lang.String r7 = com.bytedance.msdk.core.wp.g.z
            java.lang.String r0 = "权限检查出错时默认返回有权限，异常代码："
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r0.concat(r6)
            com.bytedance.msdk.z.gc.dl.a(r7, r6)
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.wp.g.g(android.content.Context, java.lang.String):boolean");
    }

    private static boolean dl(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
