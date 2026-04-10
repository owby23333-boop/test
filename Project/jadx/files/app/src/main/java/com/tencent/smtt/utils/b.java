package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.smtt.sdk.c;
import com.umeng.analytics.pro.cb;
import com.umeng.message.proguard.ad;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static String a = "";
    public static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f19192c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f19193d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f19194e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f19195f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f19196g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f19197h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f19198i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f19199j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f19200k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f19201l = false;

    /* JADX WARN: Can't wrap try/catch for region: R(8:4|59|5|(2:53|6)|(7:49|7|(1:9)(1:11)|10|(1:14)|65|15)|55|16|33) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = "os.arch"
            boolean r1 = com.tencent.smtt.utils.b.f19199j
            if (r1 != 0) goto L79
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = "getprop ro.product.cpu.abi"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L47
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L47
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L47
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "x86"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L42
            if (r4 == 0) goto L32
            java.lang.String r4 = "i686"
        L2d:
            java.lang.String r0 = b(r4)     // Catch: java.lang.Throwable -> L42
            goto L37
        L32:
            java.lang.String r4 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L42
            goto L2d
        L37:
            if (r0 == 0) goto L3b
            com.tencent.smtt.utils.b.f19192c = r0
        L3b:
            r2.close()     // Catch: java.io.IOException -> L3e
        L3e:
            r3.close()     // Catch: java.io.IOException -> L63
            goto L63
        L42:
            r4 = move-exception
            goto L4a
        L44:
            r4 = move-exception
            r2 = r1
            goto L4a
        L47:
            r4 = move-exception
            r2 = r1
            r3 = r2
        L4a:
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = b(r0)     // Catch: java.lang.Throwable -> L67
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L59
            com.tencent.smtt.utils.b.f19192c = r1
        L59:
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L5f
            goto L60
        L5f:
        L60:
            if (r3 == 0) goto L63
            goto L3e
        L63:
            r0 = 1
            com.tencent.smtt.utils.b.f19199j = r0
            goto L79
        L67:
            r0 = move-exception
            if (r1 == 0) goto L6c
            com.tencent.smtt.utils.b.f19192c = r1
        L6c:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L72
            goto L73
        L72:
        L73:
            if (r3 == 0) goto L78
            r3.close()     // Catch: java.io.IOException -> L78
        L78:
            throw r0
        L79:
            java.lang.String r0 = com.tencent.smtt.utils.b.f19192c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a():java.lang.String");
    }

    public static String a(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(Context context, File file) {
        Signature signature;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
            if (packageArchiveInfo == null) {
                signature = null;
            } else if (packageArchiveInfo.signatures == null || packageArchiveInfo.signatures.length <= 0) {
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
                signature = null;
            } else {
                signature = packageArchiveInfo.signatures[0];
            }
            if (signature != null) {
                return signature.toCharsString();
            }
            return null;
        } catch (Exception unused) {
            TbsLog.i("AppUtil", "getSign " + file + "failed");
            return null;
        }
    }

    public static String a(Context context, String str) {
        try {
            String strValueOf = String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str));
            try {
                return String.valueOf(Integer.toHexString(Integer.parseInt(strValueOf)));
            } catch (Exception unused) {
                return strValueOf;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String a(Context context, boolean z2, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        Exception e2;
        byte[] bArr;
        if (file == null || !file.exists()) {
            return "";
        }
        if (z2) {
            try {
                try {
                    bArr = new byte[2];
                    randomAccessFile = new RandomAccessFile(file, "r");
                } catch (Exception e3) {
                    randomAccessFile = null;
                    e2 = e3;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
                try {
                    try {
                        randomAccessFile.read(bArr);
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile.close();
                        throw th;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    randomAccessFile.close();
                }
                if (!new String(bArr).equalsIgnoreCase("PK")) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return "";
                }
                randomAccessFile.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        }
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                String strA = a(file);
                if (strA != null) {
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return strA;
                }
            }
        } catch (Throwable unused) {
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        String strA2 = a(context, file);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + strA2);
        if (strA2 != null) {
            return strA2;
        }
        String strA3 = a(file);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + strA3);
        return strA3;
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String strA = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                String name = jarEntryNextElement.getName();
                if (name != null) {
                    Certificate[] certificateArrA = a(jarFile, jarEntryNextElement, bArr);
                    String strA2 = certificateArrA != null ? a(certificateArrA[0].getEncoded()) : null;
                    if (strA2 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!strA2.equals(strA)) {
                        return null;
                    }
                }
            }
            return strA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = bArr[i2];
            int i3 = (b2 >> 4) & 15;
            int i4 = i2 * 2;
            cArr[i4] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i5 = b2 & cb.f19604m;
            cArr[i4 + 1] = (char) (i5 >= 10 ? (i5 + 97) - 10 : i5 + 48);
        }
        return new String(cArr);
    }

    public static boolean a(String str) {
        Matcher matcher;
        try {
            matcher = Pattern.compile("i686|mips|x86_64|x86").matcher(str);
        } catch (Exception unused) {
            matcher = null;
        }
        return matcher == null || !matcher.find();
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Exception {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        while (inputStream.read(bArr, 0, bArr.length) != -1) {
        }
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    public static int b(Context context) {
        if (TbsPrivacyAccess.AndroidVersion.isDisabled()) {
            return 0;
        }
        return Build.VERSION.SDK_INT;
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public static void b(Context context, String str) {
        try {
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            tbsDownloadConfig.commit();
        } catch (Exception unused) {
        }
    }

    public static boolean b() {
        Matcher matcher;
        try {
            matcher = Pattern.compile("i686|mips|x86_64|x86").matcher(f19192c);
        } catch (Exception unused) {
            matcher = null;
        }
        return matcher == null || !matcher.find();
    }

    public static String c(Context context) {
        if (TbsPrivacyAccess.DeviceModel.isDisabled()) {
            return "";
        }
        if (!f19201l) {
            String strC = s.c(context);
            try {
                f19195f = new String(strC.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused) {
                f19195f = strC;
            }
            f19201l = true;
        }
        return f19195f;
    }

    public static boolean c() {
        Class<?> cls;
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (objInvoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
                return false;
            }
            Object objInvoke2 = declaredMethod2.invoke(objInvoke, new Object[0]);
            if (objInvoke2 instanceof Boolean) {
                return ((Boolean) objInvoke2).booleanValue();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String f(Context context) {
        try {
            return TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean g(final Context context) {
        boolean z2 = false;
        try {
            z2 = context.getSharedPreferences("sai", 0).getBoolean("gi", false);
            TbsLog.i("AppUtil", "getImeiEnable is " + z2);
            com.tencent.smtt.sdk.c.a().a(context, (Integer) 1001, new c.a() { // from class: com.tencent.smtt.utils.b.1
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("gi", true);
                    editorEdit.commit();
                    TbsLog.e("TBSEmergency", "Execute command [1001](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }

    public static String h(Context context) {
        if (!f19197h) {
            try {
                a = "";
                if (TextUtils.isEmpty(a)) {
                    a = k.a(context);
                }
            } catch (Exception e2) {
                TbsLog.i(e2);
            }
            f19197h = true;
        }
        return a;
    }

    public static String i(Context context) {
        String str;
        if (!QbSdk.isEnableSensitiveApi()) {
            str = "getImsi isEnableSensitiveApi = false";
        } else {
            if (QbSdk.isEnableCanGetSubscriberId()) {
                if (!f19198i) {
                    try {
                        if (context.getApplicationInfo().packageName.contains(TbsConfig.APP_QQ)) {
                            return "";
                        }
                        b = "";
                    } catch (Exception e2) {
                        TbsLog.i(e2);
                    }
                    f19198i = true;
                }
                return b;
            }
            str = "getImsi isEnableCanGetSubscriberId is false";
        }
        TbsLog.i("AppUtil", str);
        return "";
    }

    public static String j(Context context) {
        return "02:00:00:00:00:00";
    }

    public static String k(Context context) {
        String str;
        if (!QbSdk.isEnableSensitiveApi()) {
            str = "getAndroidID isEnableSensitiveApi = false";
        } else if (!QbSdk.isEnableGetAndroidID()) {
            str = "getAndroidID isEnableGetAndroidID is false";
        } else {
            if (m(context)) {
                if (!f19200k) {
                    try {
                        f19194e = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    f19200k = true;
                }
                TbsLog.i("AppUtil", "getAndroidID mAndroidID is " + f19194e);
                return f19194e;
            }
            str = "getAndroidID isAndroidIDEnable is false";
        }
        TbsLog.i("AppUtil", str);
        return "";
    }

    public static boolean l(Context context) {
        return context != null && context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f16729i) == 0;
    }

    private static boolean m(final Context context) {
        boolean z2 = false;
        try {
            z2 = context.getSharedPreferences("sai", 0).getBoolean("gpai", false);
            TbsLog.i("AppUtil", "isAndroidIDEnable is " + z2);
            com.tencent.smtt.sdk.c cVarA = com.tencent.smtt.sdk.c.a();
            cVarA.a(context, (Integer) 1012, new c.a() { // from class: com.tencent.smtt.utils.b.2
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("gpai", false);
                    editorEdit.commit();
                    TbsLog.e("TBSEmergency", "Execute command [1012](+extra+)");
                }
            });
            cVarA.a(context, (Integer) 1011, new c.a() { // from class: com.tencent.smtt.utils.b.3
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("gpai", true);
                    editorEdit.commit();
                    TbsLog.e("TBSEmergency", "Execute command [1011](+extra+)");
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }
}
