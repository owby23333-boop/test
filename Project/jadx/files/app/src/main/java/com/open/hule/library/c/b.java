package com.open.hule.library.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.analytics.pro.cb;
import java.io.File;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* JADX INFO: compiled from: Md5Util.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static boolean a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strB = b(file);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        return str.equalsIgnoreCase(strB);
    }

    public static String b(File file) {
        return a(a(file));
    }

    public static void c(Context context, String str) {
        try {
            context.startActivity(a(context, str));
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(context, "启动失败，请检查是否安装或点击桌面图标启动！", 1).show();
        }
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.substring(str.lastIndexOf("/") + 1);
    }

    private static String a(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return "";
        }
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(bArr[i3] >> 4) & 15];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & cb.f19604m];
        }
        return new String(cArr);
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r3 = 262144(0x40000, float:3.67342E-40)
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
        L18:
            int r1 = r2.read(r3)     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            if (r1 > 0) goto L18
            java.security.MessageDigest r3 = r2.getMessageDigest()     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            byte[] r3 = r3.digest()     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            r2.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r0 = move-exception
            r0.printStackTrace()
        L2e:
            return r3
        L2f:
            r3 = move-exception
            goto L39
        L31:
            r3 = move-exception
            goto L39
        L33:
            r3 = move-exception
            goto L49
        L35:
            r3 = move-exception
            goto L38
        L37:
            r3 = move-exception
        L38:
            r2 = r0
        L39:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L46
            r2.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r3 = move-exception
            r3.printStackTrace()
        L46:
            return r0
        L47:
            r3 = move-exception
            r0 = r2
        L49:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r0 = move-exception
            r0.printStackTrace()
        L53:
            goto L55
        L54:
            throw r3
        L55:
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.open.hule.library.c.b.a(java.io.File):byte[]");
    }

    public static String a(double d2) {
        if (d2 < PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            return "0kb";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return d2 + "b";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "Kb";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "M";
        }
        double d6 = d5 / 1024.0d;
        if (d6 < 1.0d) {
            return new BigDecimal(Double.toString(d5)).setScale(2, 4).toPlainString() + "G";
        }
        return new BigDecimal(d6).setScale(2, 4).toPlainString() + "TB";
    }

    private static Intent a(Context context, String str) {
        String str2;
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(270532608);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 1);
        int i2 = 0;
        while (true) {
            if (i2 >= listQueryIntentActivities.size()) {
                str2 = null;
                break;
            }
            ResolveInfo resolveInfo = listQueryIntentActivities.get(i2);
            if (resolveInfo.activityInfo.packageName.equals(str)) {
                str2 = resolveInfo.activityInfo.name;
                break;
            }
            i2++;
        }
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        intent.setComponent(new ComponentName(str, str2));
        return intent;
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            int length = bArrDigest.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = bArrDigest[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static void a(String str, Context context) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            Uri uri = Uri.parse(str);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
