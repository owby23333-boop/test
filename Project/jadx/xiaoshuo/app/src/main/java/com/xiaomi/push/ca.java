package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import miuix.android.content.SystemIntent;

/* JADX INFO: loaded from: classes8.dex */
public class ca {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(bl.m233a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }

    public static String a(Context context) {
        String strA = cd.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = bo.a(20);
        cd.a(context).m265a("sp_client_report_status", "sp_client_report_key", strA2);
        return strA2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m261a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE, 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m261a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ca.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m262a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m116a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() <= maxFileLength) {
                    return true;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            return false;
        }
        x.m819a(file);
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static File[] m263a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new cc());
    }
}
