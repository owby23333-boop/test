package com.alipay.sdk.m.f0;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import androidx.webkit.ProxyConfig;
import com.xiaomi.onetrack.api.at;
import com.xiaomi.passport.sim.SIMInfo;
import com.yuewen.eq2;
import com.yuewen.xm1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import miuix.android.content.MiuiIntent;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f1810b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1811a;

    public static b a(f fVar) {
        b bVar = f1810b;
        bVar.f1811a = fVar;
        return bVar;
    }

    public String b() {
        long blockSize;
        try {
            StatFs statFs = new StatFs("/sdcard");
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable unused) {
            blockSize = 0;
        }
        return "" + blockSize;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        r0 = r6.substring(r6.indexOf(":") + 1, r6.length()).trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c() {
        /*
            r9 = this;
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L53
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L53
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L51
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L51
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L55
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L55
            r1 = 1
            r5 = r1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L47
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L47
            java.lang.String r7 = "Serial"
            int r7 = r6.indexOf(r7)     // Catch: java.lang.Throwable -> L45
            r8 = -1
            if (r7 <= r8) goto L42
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L45
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = r6.substring(r5, r1)     // Catch: java.lang.Throwable -> L45
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L45
            goto L47
        L42:
            int r5 = r5 + 1
            goto L1b
        L45:
            r1 = r4
            goto L55
        L47:
            r4.close()     // Catch: java.lang.Throwable -> L4a
        L4a:
            r3.close()     // Catch: java.lang.Throwable -> L4d
        L4d:
            r2.close()     // Catch: java.lang.Throwable -> L62
            goto L62
        L51:
            r3 = r1
            goto L55
        L53:
            r2 = r1
            r3 = r2
        L55:
            if (r1 == 0) goto L5a
            r1.close()     // Catch: java.lang.Throwable -> L5a
        L5a:
            if (r3 == 0) goto L5f
            r3.close()     // Catch: java.lang.Throwable -> L5f
        L5f:
            if (r2 == 0) goto L62
            goto L4d
        L62:
            if (r0 != 0) goto L66
            java.lang.String r0 = ""
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.f0.b.c():java.lang.String");
    }

    public String d() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    public String e() {
        String strT = t();
        return !com.alipay.sdk.m.d0.a.a(strT) ? strT : u();
    }

    public String f() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    String[] strArrSplit = bufferedReader.readLine().split(":\\s+", 2);
                    if (strArrSplit != null && strArrSplit.length > 1) {
                        String str = strArrSplit[1];
                        try {
                            fileReader2.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                        return str;
                    }
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                }
            } catch (Throwable unused6) {
                bufferedReader = null;
            }
        } catch (Throwable unused7) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
            return "";
        } catch (Throwable unused8) {
            return "";
        }
    }

    public String g() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                try {
                    j = bufferedReader.readLine() != null ? Integer.parseInt(r3.split("\\s+")[1]) : 0L;
                    try {
                        fileReader2.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (bufferedReader != null) {
                    }
                    return "" + j;
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused6) {
        }
        return "" + j;
    }

    public String h() {
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            blockCount = 0;
        }
        return "" + blockCount;
    }

    public String i() {
        long blockSize;
        try {
            StatFs statFs = new StatFs("/sdcard");
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Throwable unused) {
            blockSize = 0;
        }
        return "" + blockSize;
    }

    public String j() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public String k() {
        String string;
        try {
            string = Locale.getDefault().toString();
        } catch (Throwable unused) {
            string = "";
        }
        return string == null ? "" : string;
    }

    public String l() {
        String displayName;
        try {
            displayName = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            displayName = "";
        }
        return displayName == null ? "" : displayName;
    }

    public String m() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            return "" + (jCurrentTimeMillis - (jCurrentTimeMillis % 1000));
        } catch (Throwable unused) {
            return "";
        }
    }

    public String n() {
        try {
            return SystemClock.elapsedRealtime() + "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public String o() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00:");
            for (int i = 0; i < 7; i++) {
                sb.append(new File(strArr[i]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        try {
            Class.forName(new String[]{"dalvik.system.Taint"}[0]);
            sb.append("1");
        } catch (Throwable unused) {
            sb.append("0");
        }
        return sb.toString();
    }

    public String q() {
        LineNumberReader lineNumberReader;
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00:");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String line = lineNumberReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        sb.append('0');
                        if (lineNumberReader != null) {
                        }
                    }
                }
                sb.append(c);
            } catch (Throwable unused2) {
                lineNumberReader = null;
            }
            try {
                lineNumberReader.close();
            } catch (Throwable unused3) {
            }
        }
        return sb.toString();
    }

    public String r() {
        String str;
        String lowerCase;
        StringBuilder sb = new StringBuilder();
        sb.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str2 : linkedHashMap.keySet()) {
            try {
                String str3 = (String) Build.class.getField(str2).get(null);
                str = (String) linkedHashMap.get(str2);
                lowerCase = str3 != null ? str3.toLowerCase() : null;
            } catch (Throwable unused) {
            }
            char c = (lowerCase == null || !lowerCase.contains(str)) ? '0' : '1';
            sb.append(c);
        }
        return sb.toString();
    }

    public String s() {
        StringBuilder sb = new StringBuilder();
        sb.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            String str2 = (String) linkedHashMap.get(str);
            String strB = com.alipay.sdk.m.d0.a.b(str, "");
            sb.append((strB == null || !strB.contains(str2)) ? '0' : '1');
        }
        return sb.toString();
    }

    public final String t() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            if (!com.alipay.sdk.m.d0.a.a(line)) {
                String strTrim = line.trim();
                try {
                    bufferedReader.close();
                } catch (Throwable unused3) {
                }
                try {
                    fileReader.close();
                } catch (Throwable unused4) {
                }
                return strTrim;
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused7) {
                }
            }
            if (fileReader == null) {
                return "";
            }
        }
        try {
            fileReader.close();
            return "";
        } catch (Throwable unused8) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r1 = r2[1].trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String u() {
        /*
            r7 = this;
            java.lang.String r0 = "/proc/cpuinfo"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L44
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L44
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41
            r4 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L41
        L11:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3a
            boolean r4 = com.alipay.sdk.m.d0.a.a(r2)     // Catch: java.lang.Throwable -> L42
            if (r4 != 0) goto L11
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L11
            int r4 = r2.length     // Catch: java.lang.Throwable -> L42
            r5 = 1
            if (r4 <= r5) goto L11
            r4 = 0
            r4 = r2[r4]     // Catch: java.lang.Throwable -> L42
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L42
            if (r4 == 0) goto L11
            r2 = r2[r5]     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Throwable -> L42
        L3a:
            r3.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            r0.close()     // Catch: java.lang.Throwable -> L4d
            goto L4d
        L41:
            r0 = r2
        L42:
            r2 = r3
            goto L45
        L44:
            r0 = r2
        L45:
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Throwable -> L4a
        L4a:
            if (r0 == 0) goto L4d
            goto L3d
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.f0.b.u():java.lang.String");
    }

    public static String n(Context context) {
        String str;
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                str = MiuiIntent.WIFI_NAME;
            } else {
                if (activeNetworkInfo.getType() != 0) {
                    return null;
                }
                int subtype = activeNetworkInfo.getSubtype();
                str = (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            availableBlocks = 0;
        }
        return "" + availableBlocks;
    }

    public String b(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i == 1 ? "1" : "0";
    }

    public String c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", "" + i);
            jSONObject.put(NotificationCompat.CATEGORY_CALL, "" + streamVolume);
            jSONObject.put("system", "" + streamVolume2);
            jSONObject.put("ring", "" + streamVolume3);
            jSONObject.put(xm1.C, "" + streamVolume4);
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, "" + streamVolume5);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public synchronized String d(Context context) {
        String strA = d.a("NetworkOperatorName");
        if (strA != null) {
            return strA;
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(at.d);
                if (telephonyManager != null) {
                    strA = telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        if (strA == null || eq2.g.equals(strA)) {
            strA = "";
        }
        d.a("NetworkOperatorName", strA);
        return strA;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String e(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L4d
            java.lang.String r0 = "sensor"
            java.lang.Object r4 = r4.getSystemService(r0)     // Catch: java.lang.Throwable -> L4d
            android.hardware.SensorManager r4 = (android.hardware.SensorManager) r4     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L4d
            r0 = -1
            java.util.List r4 = r4.getSensorList(r0)     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L4d
            int r0 = r4.size()     // Catch: java.lang.Throwable -> L4d
            if (r0 <= 0) goto L4d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L4d
        L22:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L44
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L4d
            android.hardware.Sensor r1 = (android.hardware.Sensor) r1     // Catch: java.lang.Throwable -> L4d
            java.lang.String r2 = r1.getName()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            int r2 = r1.getVersion()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = r1.getVendor()     // Catch: java.lang.Throwable -> L4d
            r0.append(r1)     // Catch: java.lang.Throwable -> L4d
            goto L22
        L44:
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = com.alipay.sdk.m.d0.a.e(r4)     // Catch: java.lang.Throwable -> L4d
            goto L4e
        L4d:
            r4 = 0
        L4e:
            if (r4 != 0) goto L52
            java.lang.String r4 = ""
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.f0.b.e(android.content.Context):java.lang.String");
    }

    public String f(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public String g(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + ProxyConfig.MATCH_ALL_SCHEMES + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public String h(Context context) {
        try {
            return "" + context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String i(Context context) {
        try {
            return "" + context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    public synchronized String j(Context context) {
        String strA = d.a("SimSerial");
        if (strA != null) {
            return strA;
        }
        if (this.f1811a.isBackgroundRunning()) {
            return "";
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        d.a("SimSerial", strA);
        return strA;
    }

    public synchronized String k(Context context) {
        String androidId = this.f1811a.getAndroidId();
        if (androidId != null) {
            return androidId;
        }
        String strA = d.a("ANDROIDID");
        if (strA != null) {
            return strA;
        }
        if (this.f1811a.isBackgroundRunning()) {
            return "";
        }
        try {
            strA = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
        }
        if (strA == null) {
            strA = "";
        }
        d.a("ANDROIDID", strA);
        return strA;
    }

    public String l(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(at.d);
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public String m(Context context) {
        try {
            String strN = n(context);
            String strO = o(context);
            if (com.alipay.sdk.m.d0.a.b(strN) && com.alipay.sdk.m.d0.a.b(strO)) {
                return strN + ":" + o(context);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public String o(Context context) {
        String strA = d.a("ip");
        if (strA != null) {
            return strA;
        }
        if (this.f1811a.isBackgroundRunning()) {
            return "";
        }
        if (strA == null) {
            strA = "";
        }
        d.a("ip", strA);
        return strA;
    }

    public String p(Context context) {
        long jLastModified;
        try {
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            long jMax = 0;
            for (int i = 0; i < 5; i++) {
                try {
                    jLastModified = new File(strArr[i]).lastModified();
                } catch (Throwable unused) {
                    jLastModified = -1;
                }
                jMax = Math.max(jLastModified, jMax);
            }
            return "1:" + jMax;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public String q(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(null, intentFilter, 2) : context.registerReceiver(null, intentFilter);
            int intExtra = intentRegisterReceiver.getIntExtra(com.xiaomi.onetrack.b.a.d, -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("status", -1);
            boolean z = intExtra2 == 2 || intExtra2 == 5;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(":");
            sb.append(intExtra);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public synchronized String a(Context context) {
        String subscriberId = this.f1811a.getSubscriberId();
        if (subscriberId != null) {
            return subscriberId;
        }
        String strA = d.a(SIMInfo.SIM_INFO_TYPE_IMSI);
        if (strA != null) {
            return strA;
        }
        if (this.f1811a.isBackgroundRunning()) {
            return "";
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (strA == null) {
            strA = "";
        }
        d.a(SIMInfo.SIM_INFO_TYPE_IMSI, strA);
        return strA;
    }

    public static boolean a(Context context, String str) {
        return !b(context, str);
    }
}
