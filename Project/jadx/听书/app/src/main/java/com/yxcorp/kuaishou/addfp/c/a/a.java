package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
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

    public static String a(int i, String str) {
        String strA;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] strArrSplit = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        String str4 = strArrSplit[2];
        if (i == 0) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str2, str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str3, str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str4, str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            strA = "";
        }
        return strA == null ? "" : strA;
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
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[Catch: all -> 0x00e2, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0002, B:6:0x0019, B:8:0x0023, B:10:0x002f, B:23:0x0070, B:25:0x0076, B:28:0x007d, B:30:0x0087, B:34:0x0097, B:36:0x009d, B:37:0x00b3, B:45:0x00d5, B:47:0x00db, B:32:0x008d, B:15:0x0048, B:17:0x0052, B:19:0x005e, B:21:0x006c), top: B:55:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #1 {all -> 0x00b3, blocks: (B:41:0x00bd, B:43:0x00c5), top: B:57:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db A[Catch: all -> 0x00e2, TRY_LEAVE, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0002, B:6:0x0019, B:8:0x0023, B:10:0x002f, B:23:0x0070, B:25:0x0076, B:28:0x007d, B:30:0x0087, B:34:0x0097, B:36:0x009d, B:37:0x00b3, B:45:0x00d5, B:47:0x00db, B:32:0x008d, B:15:0x0048, B:17:0x0052, B:19:0x005e, B:21:0x006c), top: B:55:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }
}
