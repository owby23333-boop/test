package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.am;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private static String a = null;
    private static long b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f1775c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f1776d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f1777e = -1;

    public static String a() {
        int i2;
        String str;
        if (b == -1) {
            a = a(true);
            str = "--==-- 获取ip，真实获取";
        } else {
            if (SystemClock.elapsedRealtime() - b <= 1800000) {
                if (TextUtils.isEmpty(a) && (i2 = f1775c) < 9) {
                    f1775c = i2 + 1;
                    a = a(true);
                    str = "--==-- 获取ip，30min内，ip是空，重试第" + f1775c + "次，真实获取";
                }
                return a;
            }
            a = a(true);
            f1775c = 0;
            str = "--==-- 获取ip，大于30min了，真实获取";
        }
        Logger.d("TTMediationSDK", str);
        return a;
    }

    private static String a(int i2) {
        return i2 != 120 ? i2 != 240 ? i2 != 320 ? i2 != 480 ? i2 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "ldpi";
    }

    @SuppressLint({"NewApi"})
    private static String a(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(boolean z2) {
        Iterator it;
        b = SystemClock.elapsedRealtime();
        try {
            it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        } catch (Exception unused) {
        }
        while (it.hasNext()) {
            for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                if (!inetAddress.isLoopbackAddress()) {
                    boolean z3 = inetAddress instanceof Inet4Address;
                    String upperCase = inetAddress.getHostAddress().toUpperCase();
                    if (!z2) {
                        if (!z3) {
                            int iIndexOf = upperCase.indexOf(37);
                            return iIndexOf >= 0 ? upperCase.substring(0, iIndexOf) : upperCase;
                        }
                        return "";
                    }
                    if (z3) {
                        return upperCase;
                    }
                }
            }
        }
        return "";
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x001b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0012 A[LOOP:2: B:9:0x000f->B:10:0x0012, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x001f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x001f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[PHI: r3
  PHI (r3v4 android.content.Context) = (r3v2 android.content.Context), (r3v5 android.content.Context) binds: [B:9:0x000f, B:6:0x000a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x000f -> B:11:0x0015). Please report as a decompilation issue!!! */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r6) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.n.a(android.content.Context):org.json.JSONObject");
    }

    public static String b() {
        if (Build.VERSION.SDK_INT < 21) {
            return Locale.getDefault().getLanguage();
        }
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    private static String b(String str) {
        String[] strArrSplit = str.split(",");
        return (strArrSplit == null || strArrSplit.length <= 0 || TextUtils.isEmpty(strArrSplit[0])) ? "127.0.0.1" : strArrSplit[0].trim();
    }

    public static JSONObject b(Context context) {
        while (true) {
            for (char c2 = 'I'; c2 != 'H'; c2 = 'H') {
                if (c2 == 'J') {
                    while (true) {
                        char c3 = '7';
                        switch (16) {
                            case 53:
                                while (true) {
                                    switch (c3) {
                                        case 29:
                                            break;
                                        case 30:
                                            break;
                                        case 31:
                                            break;
                                        default:
                                            c3 = 30;
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("imei", w.e(context));
            jSONObject.put("imei_md5", y.a(w.e(context)));
            Logger.d("IdUtils.getImei(context)", "IdUtils.getImei(context)=" + w.e(context));
            jSONObject.put("gaid", h.c().a());
            jSONObject.put("oaid", a0.a());
            jSONObject.put("applog_did", w.d(context));
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("ua", j());
            jSONObject.put("ip", a());
            jSONObject.put("package_name", m0.a());
            jSONObject.put("publisher_did", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().t());
            jSONObject.put("android_id", w.a(context));
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static int c(Context context) {
        if (e(context)) {
            return 3;
        }
        return d(context) ? 2 : 1;
    }

    public static String c() {
        if (f1777e == -1 || (SystemClock.elapsedRealtime() - f1777e > 1800000 && TextUtils.isEmpty(f1776d))) {
            f1776d = d();
            Logger.d("TTMediationSDK", "--==-- 获取mac，真实获取");
        }
        return f1776d;
    }

    private static String d() {
        f1777e = SystemClock.elapsedRealtime();
        String strA = a("wlan0");
        if (TextUtils.isEmpty(strA)) {
            strA = a("eth0");
        }
        return TextUtils.isEmpty(strA) ? "DU:MM:YA:DD:RE:SS" : strA;
    }

    public static boolean d(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static String e() {
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

    public static boolean e(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 4;
    }

    private static int f() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static long g() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long j2 = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]);
            bufferedReader.close();
            return j2 * 1024;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static long h() {
        if (!k()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        Context contextD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        try {
            jSONObject.put("device_id", w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject.put("user_unique_id", w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()) != null ? w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()) : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", "3.9.0.2");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("resolution", UIUtils.getScreenHeight(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()) + "x" + UIUtils.getScreenWidth(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("timezone", f());
            jSONObject.put("access", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.e.c(contextD));
            jSONObject.put("openudid", w.a(contextD));
            jSONObject.put("aid", "5685");
            jSONObject.put(am.f19459s, i.b());
            jSONObject.put("app_version", i.a());
            jSONObject.put(Constants.KEY_PACKAGE, m0.a());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", e());
            jSONObject.put(am.H, Build.MANUFACTURER);
            ArrayList<String> arrayListA = j.a(contextD, "MD5");
            if (arrayListA != null && !arrayListA.isEmpty()) {
                jSONObject.put("sig_hash", Build.MANUFACTURER);
            }
            jSONObject.put("display_density", a(UIUtils.getDensityDpi(contextD)));
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", UIUtils.getDensityDpi(contextD));
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", w.j(contextD));
            jSONObject.put("version_code", m0.d());
            jSONObject.put("udid", w.e(contextD));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("imei", w.e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject2.put("imei_md5", y.a(w.e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d())));
            jSONObject2.put("gaid", h.c().a());
            jSONObject2.put("applog_did", w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject2.put("publisher_did", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().t());
            jSONObject2.put("android_id", w.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject2.put("oaid", a0.a());
            jSONObject.put("custom", jSONObject2);
            String strA = a();
            if (TextUtils.isEmpty(strA)) {
                strA = "127.0.0.1";
            } else if (strA.contains(",")) {
                strA = b(strA);
            }
            jSONObject.put("ip", strA);
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a("getUploadEventV3Header", "exception: " + e2.toString());
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x000e. Please report as an issue. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static java.lang.String j() {
        /*
        L0:
            r0 = 31
            switch(r0) {
                case 29: goto L6;
                case 30: goto L6;
                case 31: goto L6;
                default: goto L5;
            }
        L5:
            goto L0
        L6:
            r1 = 40
            switch(r1) {
                case 38: goto L0;
                case 39: goto Lc;
                case 40: goto L11;
                default: goto Lb;
            }
        Lb:
            goto L6
        Lc:
            r1 = 95
            switch(r1) {
                case 52: goto L6;
                case 53: goto L6;
                case 54: goto L0;
                default: goto L11;
            }
        L11:
            java.lang.String r1 = "http.agent"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch: java.lang.Exception -> L18
            goto L1b
        L18:
            java.lang.String r1 = "unKnow"
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            if (r1 != 0) goto L26
            java.lang.String r0 = ""
            goto La2
        L26:
            java.lang.String r3 = ";"
            int r4 = r1.lastIndexOf(r3)
            r5 = -1
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L74
            int r5 = r1.length()
            if (r5 <= r4) goto L74
            int r4 = r4 + r6
            java.lang.String r5 = r1.substring(r7, r4)
            java.lang.String r1 = r1.substring(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = " "
            r4.append(r8)
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r8.getLanguage()
            r4.append(r8)
            java.lang.String r8 = "-"
            r4.append(r8)
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r8.getCountry()
            r4.append(r8)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r3 = r5.concat(r3)
            java.lang.String r1 = r3.concat(r1)
        L74:
            int r3 = r1.length()
            r4 = 0
        L79:
            if (r4 >= r3) goto L9e
            char r5 = r1.charAt(r4)
            if (r5 <= r0) goto L8a
            r8 = 127(0x7f, float:1.78E-43)
            if (r5 < r8) goto L86
            goto L8a
        L86:
            r2.append(r5)
            goto L9b
        L8a:
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8[r7] = r5
            java.lang.String r5 = "\\u%04x"
            java.lang.String r5 = java.lang.String.format(r5, r8)
            r2.append(r5)
        L9b:
            int r4 = r4 + 1
            goto L79
        L9e:
            java.lang.String r0 = r2.toString()
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.n.j():java.lang.String");
    }

    public static boolean k() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
