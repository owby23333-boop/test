package com.bytedance.sdk.openadsdk.pf;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.uy.kb;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.gk;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.z.g.e;
import com.bytedance.z.g.gc;
import com.bytedance.z.g.m;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z(Context context) {
        g(context);
    }

    private static void g(final Context context) {
        e.z(new m() { // from class: com.bytedance.sdk.openadsdk.pf.z.1
            @Override // com.bytedance.z.g.m
            public boolean z(final Throwable th, final Thread thread) {
                try {
                    kb.g.e(com.bytedance.sdk.openadsdk.core.x.z.z);
                    if (!z.g(th, null)) {
                        return false;
                    }
                    com.bytedance.sdk.component.uy.e.g(new fo("tt_crash_handle") { // from class: com.bytedance.sdk.openadsdk.pf.z.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gk.z().z(thread, th);
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // com.bytedance.z.g.m
            public boolean z() {
                try {
                    return z.g(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        gc gcVar = new gc() { // from class: com.bytedance.sdk.openadsdk.pf.z.2
            @Override // com.bytedance.z.g.gc
            public String a() {
                return null;
            }

            @Override // com.bytedance.z.g.gc
            public Map<String, Integer> gc() {
                return null;
            }

            @Override // com.bytedance.z.g.gc
            public List<String> m() {
                return null;
            }

            @Override // com.bytedance.z.g.gc
            public Map<String, Object> z() {
                HashMap map = new HashMap();
                String strP = uy.p();
                if (TextUtils.isEmpty(strP)) {
                    strP = tb.dl();
                }
                if (!TextUtils.isEmpty(strP)) {
                    map.put("device_id", strP);
                }
                map.put("ac", com.bytedance.sdk.component.fo.a.m.dl(context));
                map.put("aid", com.bytedance.sdk.openadsdk.core.m.z().m());
                map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, com.bytedance.sdk.openadsdk.core.m.z().e());
                String strKb = eo.kb();
                if (!TextUtils.isEmpty(strKb)) {
                    map.put("app_version", strKb);
                }
                String strUy = eo.uy();
                if (!TextUtils.isEmpty(strUy)) {
                    map.put("version_code", strUy);
                    try {
                        map.put("update_version_code", Integer.valueOf(strUy));
                    } catch (Exception e) {
                        map.put("update_version_code", 0);
                        e.getMessage();
                    }
                }
                map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "7.1.0.5");
                map.put("sdk_api_version", com.bytedance.sdk.openadsdk.core.gk.f1105a);
                map.put("device_platform", "android");
                map.put(an.x, "Android");
                String strG = uy.g();
                map.put(an.ai, strG);
                map.put("device_mode", strG);
                map.put("rom", sy.z());
                map.put("cpu_abi", Build.CPU_ABI);
                map.put(an.F, Build.BRAND);
                map.put("channel", com.bytedance.sdk.openadsdk.core.gk.gc());
                map.put("language", Locale.getDefault().getLanguage());
                map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String strSubstring = Build.VERSION.RELEASE;
                    if (strSubstring != null && strSubstring.length() > 10) {
                        strSubstring = strSubstring.substring(0, 10);
                    }
                    map.put(an.y, strSubstring);
                } catch (Exception unused) {
                }
                map.put("openudid", uy.z());
                map.put("dpi", String.valueOf(oq.gz(context)));
                map.put(an.z, oq.a(context) + "*" + oq.gc(context));
                return map;
            }

            @Override // com.bytedance.z.g.gc
            public String g() {
                String strDl = tb.dl();
                return TextUtils.isEmpty(strDl) ? "0" : strDl;
            }

            @Override // com.bytedance.z.g.gc
            public String dl() {
                return com.bytedance.sdk.openadsdk.core.m.z().a();
            }

            @Override // com.bytedance.z.g.gc
            public Map<String, Object> e() {
                HashMap map = new HashMap();
                String strQ = com.bytedance.sdk.openadsdk.core.uy.ls().q();
                if (TextUtils.isEmpty(strQ)) {
                    strQ = String.valueOf(com.bytedance.sdk.openadsdk.core.m.z().m());
                }
                map.put("host_appid", strQ);
                map.put("sdk_version", "7.1.0.5");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
                map.put("channel", com.bytedance.sdk.openadsdk.core.gk.gc());
                map.put("sdk_api_version", com.bytedance.sdk.openadsdk.core.gk.f1105a);
                return map;
            }
        };
        boolean z3 = (zw.g().ey() & 2) == 0;
        if (z2 && (zw.g().ey() & 1) == 0) {
            z = true;
        }
        e.z(applicationContext, gcVar, z3, z);
        gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pf.z.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.core.a.z.dl()) {
                    return;
                }
                boolean zP = zw.g().p();
                boolean z4 = z.z();
                if (zP && z4) {
                    e.z(new com.bytedance.z.z.g() { // from class: com.bytedance.sdk.openadsdk.pf.z.3.1
                    });
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        if (com.bytedance.sdk.openadsdk.core.uy.ls().gk()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        String string = Arrays.toString(stackTrace);
        if (!(string.contains(BuildConfig.LIBRARY_PACKAGE_NAME) || string.contains("com.bytedance.sdk.component") || string.contains("com.bykv.vk") || string.contains("com.byted.csj.ext_impl") || string.contains("com.bytedance.adsdk") || string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm"))) {
            return false;
        }
        Map<String, String> mapG = com.bytedance.sdk.openadsdk.core.a.z().g();
        if (mapG != null) {
            if (string.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
                mapG.put("express", "true");
            }
            if (string.contains(com.bytedance.sdk.openadsdk.core.live.z.class.getPackage().getName()) || string.contains("com.bytedance.sdk.openadsdk.live") || string.contains("com.bykv.vk.openvk.live")) {
                mapG.put("live_sdk", "true");
            }
            if (string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm")) {
                mapG.put("mediation", "true");
            } else {
                mapG.put("mediation", "false");
            }
            e.z(com.bytedance.sdk.openadsdk.core.a.z().g());
        }
        return true;
    }

    public static boolean z() {
        int iIntValue;
        try {
            String strRv = zw.g().rv();
            if (!TextUtils.isEmpty(strRv) && strRv.contains(";")) {
                String[] strArrSplit = strRv.split(";");
                if (strArrSplit.length != 2) {
                    return true;
                }
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                Long lValueOf = -1L;
                try {
                    lValueOf = Long.valueOf(Long.valueOf(str).longValue() * 60 * 1000);
                    iIntValue = Integer.valueOf(str2).intValue();
                } catch (Exception e) {
                    wp.g("apm", "error", e.getMessage());
                    iIntValue = -1;
                }
                if (lValueOf.longValue() >= 0 && iIntValue >= 0 && iIntValue <= 60) {
                    if (lValueOf.longValue() == 0 || iIntValue == 0 || lValueOf.longValue() / ((long) iIntValue) < 5000) {
                        return false;
                    }
                    String strG = g();
                    StringBuilder sb = new StringBuilder();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(strG)) {
                        sb.append(jCurrentTimeMillis);
                        z(sb.toString());
                        return true;
                    }
                    String[] strArrSplit2 = strG.split(";");
                    int length = strArrSplit2.length;
                    if (length >= iIntValue && length != 0) {
                        boolean z = jCurrentTimeMillis - Long.valueOf(strArrSplit2[0]).longValue() > lValueOf.longValue();
                        int i = length - iIntValue;
                        for (int i2 = i; i2 < length; i2++) {
                            String str3 = strArrSplit2[i2];
                            if (i2 != i && !TextUtils.isEmpty(str3)) {
                                sb.append(str3).append(";");
                            }
                        }
                        sb.append(jCurrentTimeMillis);
                        z(sb.toString());
                        Object[] objArr = new Object[1];
                        Boolean.valueOf(z);
                        return z;
                    }
                    for (String str4 : strArrSplit2) {
                        sb.append(str4).append(";");
                    }
                    sb.append(jCurrentTimeMillis);
                    z(sb.toString());
                    return true;
                }
            }
            return true;
        } catch (Exception e2) {
            wp.z(e2);
            return true;
        }
    }

    public static String g() {
        return com.bytedance.sdk.openadsdk.core.dl.a.z().dl("sp_apm_record", "");
    }

    public static void z(String str) {
        com.bytedance.sdk.openadsdk.core.dl.a.z().g("sp_apm_record", str);
    }
}
