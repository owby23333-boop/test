package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class w {
    private static volatile String a;
    private static volatile String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f1797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f1798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f1799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile String f1800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile String f1801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile String f1802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile String f1803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f1804j = new AtomicInteger(0);

    private static String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (d0.t()) {
            str = "MIUI-";
        } else {
            if (!d0.q()) {
                String strF = d0.f();
                if (d0.d(strF)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strF)) {
                    sb.append(strF);
                    str = "-";
                }
                sb.append(Build.VERSION.INCREMENTAL);
                return sb.toString();
            }
            str = "FLYME-";
        }
        sb.append(str);
        sb.append(Build.VERSION.INCREMENTAL);
        return sb.toString();
    }

    public static String a(Context context) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseAndroidId()) {
            return null;
        }
        if (TextUtils.isEmpty(b)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(b)) {
                    n(context);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r2.length() >= 13) goto L31;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r6, boolean r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "openudid"
            android.content.Context r6 = c(r6)
            r1 = 0
            if (r6 != 0) goto Lb
            goto L8b
        Lb:
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch: java.lang.Exception -> L16
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)     // Catch: java.lang.Exception -> L16
            goto L17
        L16:
            r2 = r1
        L17:
            r3 = 13
            if (r2 == 0) goto L29
            java.lang.String r4 = "9774d56d682e549c"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L8a
            if (r4 != 0) goto L29
            int r4 = r2.length()     // Catch: java.lang.Exception -> L8a
            if (r4 >= r3) goto L8a
        L29:
            java.lang.String r4 = "tt_device_info"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0 r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0.a(r4, r6)     // Catch: java.lang.Exception -> L8a
            java.lang.String r1 = r6.a(r0, r1)     // Catch: java.lang.Exception -> L8a
            boolean r4 = a(r1)     // Catch: java.lang.Exception -> L8a
            if (r4 != 0) goto L8b
            java.security.SecureRandom r1 = new java.security.SecureRandom     // Catch: java.lang.Exception -> L8a
            r1.<init>()     // Catch: java.lang.Exception -> L8a
            java.math.BigInteger r4 = new java.math.BigInteger     // Catch: java.lang.Exception -> L8a
            r5 = 64
            r4.<init>(r5, r1)     // Catch: java.lang.Exception -> L8a
            r1 = 16
            java.lang.String r1 = r4.toString(r1)     // Catch: java.lang.Exception -> L8a
            r4 = 0
            char r4 = r1.charAt(r4)     // Catch: java.lang.Exception -> L8a
            r5 = 45
            if (r4 != r5) goto L5a
            r4 = 1
            java.lang.String r1 = r1.substring(r4)     // Catch: java.lang.Exception -> L8a
        L5a:
            int r4 = r1.length()     // Catch: java.lang.Exception -> L8a
            int r3 = r3 - r4
            if (r3 <= 0) goto L77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8a
            r4.<init>()     // Catch: java.lang.Exception -> L8a
        L66:
            if (r3 <= 0) goto L70
            r5 = 70
            r4.append(r5)     // Catch: java.lang.Exception -> L8a
            int r3 = r3 + (-1)
            goto L66
        L70:
            r4.append(r1)     // Catch: java.lang.Exception -> L8a
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L8a
        L77:
            if (r7 == 0) goto L86
            java.lang.String r7 = "openudid.dat"
            java.lang.String r7 = a(r7, r1)     // Catch: java.lang.Exception -> L8a
            boolean r3 = a(r7)     // Catch: java.lang.Exception -> L8a
            if (r3 == 0) goto L86
            r1 = r7
        L86:
            r6.b(r0, r1)     // Catch: java.lang.Exception -> L8a
            goto L8b
        L8a:
            r1 = r2
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w.a(android.content.Context, boolean):java.lang.String");
    }

    private static String a(WifiManager wifiManager, Context context) {
        String str = "02:00:00:00:00:00";
        if (wifiManager != null && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseLocation() && k(context)) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (scanResults != null && connectionInfo != null && connectionInfo.getBSSID() != null) {
                    for (int i2 = 0; i2 < scanResults.size(); i2++) {
                        ScanResult scanResult = scanResults.get(i2);
                        if (connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                            str = scanResult.BSSID;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Le
            goto Lbf
        Le:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = "/Android/data/com.snssdk.api/cache"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            r2.<init>(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            if (r0 != 0) goto L4d
            boolean r0 = r2.mkdirs()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            if (r0 == 0) goto Lbf
        L4d:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            r0.<init>(r6)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            java.lang.String r2 = "rwd"
            r6.<init>(r0, r2)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb4
            java.nio.channels.FileChannel r2 = r6.getChannel()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.nio.channels.FileLock r1 = r2.lock()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r0 = r0.isFile()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r2 = "UTF-8"
            if (r0 == 0) goto L8b
            r0 = 129(0x81, float:1.81E-43)
            byte[] r3 = new byte[r0]     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r4 = 0
            int r5 = r6.read(r3, r4, r0)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r5 <= 0) goto L8b
            if (r5 >= r0) goto L8b
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r0.<init>(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r3 = a(r0)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r3 == 0) goto L8b
            if (r1 == 0) goto L86
            r1.release()     // Catch: java.lang.Exception -> L86
        L86:
            r6.close()     // Catch: java.lang.Exception -> L89
        L89:
            r7 = r0
            goto Lbf
        L8b:
            byte[] r0 = r7.getBytes(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r2 = 0
            r6.setLength(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r6.write(r0)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 == 0) goto L9c
            r1.release()     // Catch: java.lang.Exception -> L9c
        L9c:
            r6.close()     // Catch: java.lang.Exception -> Lbf
            goto Lbf
        La0:
            r7 = move-exception
            goto La7
        La2:
            goto Lb5
        La4:
            r6 = move-exception
            r7 = r6
            r6 = r1
        La7:
            if (r1 == 0) goto Lae
            r1.release()     // Catch: java.lang.Exception -> Lad
            goto Lae
        Lad:
        Lae:
            if (r6 == 0) goto Lb3
            r6.close()     // Catch: java.lang.Exception -> Lb3
        Lb3:
            throw r7
        Lb4:
            r6 = r1
        Lb5:
            if (r1 == 0) goto Lbc
            r1.release()     // Catch: java.lang.Exception -> Lbb
            goto Lbc
        Lbb:
        Lbc:
            if (r6 == 0) goto Lbf
            goto L9c
        Lbf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void a(Context context, String str) {
        synchronized (w.class) {
            if (!TextUtils.isEmpty(str) && !str.equals(a)) {
                e0.a("tt_device_info", context).b("did", str);
                a = str;
            }
        }
    }

    private static boolean a(String str) {
        int length;
        if (str == null || (length = str.length()) < 13 || length > 128) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f1801g)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1801g)) {
                    b();
                }
            }
        }
        return f1801g;
    }

    private static void b() {
        synchronized (w.class) {
            f1801g = String.valueOf(Build.TIME);
        }
    }

    private static Context c(Context context) {
        return context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context;
    }

    private static void c() {
        synchronized (w.class) {
            a();
        }
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(a)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(a)) {
                    p(context);
                }
            }
        }
        return a;
    }

    public static String e(Context context) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(f1797c)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1797c)) {
                    s(context);
                }
            }
        }
        return f1797c;
    }

    public static String f(Context context) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(f1800f)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1800f)) {
                    s(context);
                }
            }
        }
        return f1800f;
    }

    public static String g(Context context) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseLocation()) {
            return null;
        }
        if (TextUtils.isEmpty(f1798d)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1798d)) {
                    r(context);
                }
            }
        }
        return f1798d;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(f1802h)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1802h)) {
                    q(context);
                }
            }
        }
        return f1802h;
    }

    public static String i(Context context) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseLocation()) {
            return null;
        }
        if (TextUtils.isEmpty(f1799e)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1799e)) {
                    r(context);
                }
            }
        }
        return f1799e;
    }

    public static String j(Context context) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(f1803i)) {
            synchronized (w.class) {
                if (TextUtils.isEmpty(f1803i)) {
                    o(context);
                }
            }
        }
        return f1803i;
    }

    private static boolean k(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(context, com.kuaishou.weapon.p0.g.f16727g) == 0 || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(context, com.kuaishou.weapon.p0.g.f16728h) == 0;
    }

    private static boolean l(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static void m(Context context) {
        synchronized (w.class) {
            Context contextC = c(context);
            if (contextC != null) {
                s(contextC);
                r(context);
                o(context);
                n(context);
                p(context);
                c();
                b();
                q(context);
            }
        }
    }

    private static void n(Context context) {
        synchronized (w.class) {
            if (context != null) {
                if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseAndroidId()) {
                    b = a(context, true);
                }
            }
        }
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    private static void o(Context context) {
        synchronized (w.class) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState() && l(context)) {
                try {
                    f1803i = Build.VERSION.SDK_INT >= 28 ? Build.getSerial() : Build.SERIAL;
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void p(Context context) {
        synchronized (w.class) {
            if (context != null) {
                a = q.c();
                if (TextUtils.isEmpty(a)) {
                    a = e0.a("tt_device_info", context).a("did", (String) null);
                } else {
                    a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), a);
                }
            }
        }
    }

    private static void q(Context context) {
        synchronized (w.class) {
            if (context != null) {
                f1802h = e0.a("tt_device_info", context).a("uuid", (String) null);
            }
        }
    }

    private static void r(Context context) {
        WifiInfo connectionInfo;
        synchronized (w.class) {
            if (context != null) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI);
                    if (wifiManager != null) {
                        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseLocation() && k(context) && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                            f1798d = connectionInfo.getSSID();
                        }
                        f1799e = a(wifiManager, context);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static void s(Context context) {
        synchronized (w.class) {
            if (f1804j.intValue() <= 5 && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState() && l(context)) {
                try {
                    f1804j.incrementAndGet();
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f1797c = telephonyManager.getDeviceId();
                        f1800f = telephonyManager.getSubscriberId();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void t(Context context) {
        Context contextC;
        synchronized (w.class) {
            if (TextUtils.isEmpty(f1797c) && (contextC = c(context)) != null) {
                try {
                    s(contextC);
                } catch (Exception unused) {
                }
            }
        }
    }
}
