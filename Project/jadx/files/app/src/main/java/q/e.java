package q;

import android.content.Context;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "android.permission.CHANGE_WIFI_STATE"
            r2 = 1
            r3 = 0
            r4 = 26
            if (r0 >= r4) goto L25
            java.lang.String r0 = "android.permission.ACCESS_WIFI_STATE"
            int r0 = r7.checkCallingOrSelfPermission(r0)
            if (r0 != 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L23
            int r7 = r7.checkCallingOrSelfPermission(r1)
            if (r7 != 0) goto L1f
            r7 = 1
            goto L20
        L1f:
            r7 = 0
        L20:
            if (r7 == 0) goto L23
            goto L24
        L23:
            r2 = 0
        L24:
            return r2
        L25:
            r4 = 28
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            if (r0 >= r4) goto L51
            int r0 = r7.checkCallingOrSelfPermission(r6)
            if (r0 != 0) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 != 0) goto L50
            int r0 = r7.checkCallingOrSelfPermission(r5)
            if (r0 != 0) goto L40
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L50
            int r7 = r7.checkCallingOrSelfPermission(r1)
            if (r7 != 0) goto L4b
            r7 = 1
            goto L4c
        L4b:
            r7 = 0
        L4c:
            if (r7 == 0) goto L4f
            goto L50
        L4f:
            r2 = 0
        L50:
            return r2
        L51:
            r4 = 29
            if (r0 < r4) goto L7b
            android.content.Context r0 = r7.getApplicationContext()
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.targetSdkVersion
            if (r0 >= r4) goto L62
            goto L7b
        L62:
            int r0 = r7.checkCallingOrSelfPermission(r6)
            if (r0 != 0) goto L6a
            r0 = 1
            goto L6b
        L6a:
            r0 = 0
        L6b:
            if (r0 == 0) goto L79
            int r7 = r7.checkCallingOrSelfPermission(r1)
            if (r7 != 0) goto L75
            r7 = 1
            goto L76
        L75:
            r7 = 0
        L76:
            if (r7 == 0) goto L79
            goto L7a
        L79:
            r2 = 0
        L7a:
            return r2
        L7b:
            int r0 = r7.checkCallingOrSelfPermission(r6)
            if (r0 != 0) goto L83
            r0 = 1
            goto L84
        L83:
            r0 = 0
        L84:
            if (r0 != 0) goto L91
            int r0 = r7.checkCallingOrSelfPermission(r5)
            if (r0 != 0) goto L8e
            r0 = 1
            goto L8f
        L8e:
            r0 = 0
        L8f:
            if (r0 == 0) goto L9d
        L91:
            int r7 = r7.checkCallingOrSelfPermission(r1)
            if (r7 != 0) goto L99
            r7 = 1
            goto L9a
        L99:
            r7 = 0
        L9a:
            if (r7 == 0) goto L9d
            goto L9e
        L9d:
            r2 = 0
        L9e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.a(android.content.Context):boolean");
    }
}
