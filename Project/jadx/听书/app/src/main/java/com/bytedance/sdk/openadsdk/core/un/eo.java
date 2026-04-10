package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.me;
import com.bytedance.sdk.openadsdk.core.iq.nh;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.umeng.analytics.pro.an;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f1373a = null;
    public static volatile int dl = 0;
    public static volatile long e = 0;
    public static volatile int g = 0;
    public static volatile long gc = 0;
    public static volatile int gz = -1;
    private static long kb = -1;
    public static volatile long m;
    private static volatile boolean wp;
    public static volatile int z;
    private static final AtomicBoolean i = new AtomicBoolean(false);
    private static volatile String v = "";
    private static volatile String pf = null;
    private static volatile String ls = null;
    private static volatile String p = null;
    public static String fo = null;
    public static String uy = null;

    public static String g(int i2) {
        switch (i2) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static int gc(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
        }
        return 4;
    }

    public static String z(int i2) {
        switch (i2) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static boolean z(Context context, String str) {
        Intent intentG;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!g(context)) {
                    Intent intentG2 = g(context, str);
                    if (intentG2 == null) {
                        return false;
                    }
                    intentG2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(intentG2);
                    return true;
                }
                if (!dl(context, str) || (intentG = g(context, str)) == null) {
                    return false;
                }
                intentG.putExtra("START_ONLY_FOR_ANDROID", true);
                com.bytedance.sdk.component.utils.g.z(context, intentG, null);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static JSONObject z(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static Intent g(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean dl(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (g(context)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.zw.g().rw()) {
            return z(str);
        }
        return false;
    }

    public static boolean z(String str) {
        boolean zExists = z("data", str).exists();
        return !zExists ? z("media", str).exists() : zExists;
    }

    private static File z(String str, String str2) {
        String str3 = System.getenv("EXTERNAL_STORAGE");
        if (str3 == null) {
            str3 = "/sdcard";
        }
        return new File(str3, "Android/" + str + "/" + str2);
    }

    public static boolean z(Context context, Intent intent, boolean z2) {
        if (intent == null || context == null || !g(context)) {
            return false;
        }
        return g(context, intent, z2);
    }

    public static boolean z(Context context, Intent intent) {
        if (intent == null || context == null || !g(context)) {
            return false;
        }
        return g(context, intent, false);
    }

    public static boolean g(Context context, Intent intent, boolean z2) {
        Boolean boolZ;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String strZ = hh.z(data);
        if (z2 && (boolZ = hh.z(strZ, 86400000L)) != null) {
            return boolZ.booleanValue();
        }
        boolean zG = g(context, intent);
        hh.z(strZ, Boolean.valueOf(zG));
        return zG;
    }

    public static List<String> z() {
        ArrayList arrayList = new ArrayList();
        if (com.bytedance.sdk.openadsdk.core.zw.g().k() && com.bytedance.sdk.openadsdk.core.uy.ls().p().g()) {
            for (ResolveInfo resolveInfo : uy.z(new Intent("android.intent.action.MAIN"), 131072)) {
                if (resolveInfo.activityInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean g() {
        try {
            PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.zw.getContext().getPackageManager().getPackageInfo(com.bytedance.sdk.openadsdk.core.zw.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean g(Context context, Intent intent) {
        try {
            List<ResolveInfo> listZ = uy.z(intent, 65536);
            if (listZ != null) {
                if (listZ.size() > 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void dl() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.eo.1
                @Override // java.lang.Runnable
                public void run() {
                    eo.mc();
                }
            });
        } else {
            mc();
        }
    }

    public static int z(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        int iV = com.bytedance.sdk.openadsdk.core.zw.g().v();
        int iIntValue = 0;
        if (iV != -1) {
            return (iV == 0 || iV != 1) ? 0 : 1;
        }
        try {
            nh nhVarE = vm.e(naVar);
            me meVarM = vm.m(naVar);
            if (nhVarE != null) {
                String strM = nhVarE.m();
                if (!TextUtils.isEmpty(strM)) {
                    iIntValue = Integer.valueOf(strM).intValue();
                }
            } else if (meVarM != null) {
                String strWp = meVarM.wp();
                if (!TextUtils.isEmpty(strWp)) {
                    iIntValue = Integer.valueOf(strWp).intValue();
                }
            }
            return iIntValue;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("tl", e2.getMessage());
            return iIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mc() {
        List<String> listHy;
        com.bytedance.sdk.openadsdk.core.gk.uy uyVarG = com.bytedance.sdk.openadsdk.core.zw.g();
        if (com.bytedance.sdk.openadsdk.core.uy.ls().ec()) {
            com.bytedance.sdk.openadsdk.core.uy.ls().e(false);
            return;
        }
        if (uyVarG.hn() || (listHy = uyVarG.hy()) == null) {
            return;
        }
        int iWo = uyVarG.wo();
        for (int i2 = 0; i2 < iWo && i2 < listHy.size(); i2++) {
            Uri uri = Uri.parse(listHy.get(i2));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            z(com.bytedance.sdk.openadsdk.core.zw.getContext(), intent, true);
        }
    }

    public static boolean a() {
        return (com.bytedance.sdk.openadsdk.core.uy.ls() == null || com.bytedance.sdk.openadsdk.core.uy.ls().z()) ? false : true;
    }

    public static int g(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 5;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "interaction":
                return 3;
            case "draw_ad":
                return 6;
            default:
                return 1;
        }
    }

    public static String g(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return null;
        }
        try {
            return g(gz(naVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject dl(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
            return null;
        }
    }

    public static boolean dl(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        return naVar != null && gz(naVar) == 9;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar != null) {
            boolean z2 = gz(naVar) == 5;
            if (vm.g(naVar) == 7 && z2) {
                return true;
            }
        }
        return false;
    }

    public static boolean gc(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return false;
        }
        int iGz = gz(naVar);
        return iGz == 5 || iGz == 1 || iGz == 2;
    }

    public static boolean m(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return false;
        }
        int iGz = gz(naVar);
        return iGz == 3 || iGz == 4;
    }

    public static boolean e(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn;
        if (naVar == null || (jSONObjectEn = naVar.en()) == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(jSONObjectEn.optString("compliance_data")).optJSONObject(an.aw).optInt("pricing_type");
            return iOptInt == 3 || iOptInt == 6;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("ToolUtils", "error:" + e2.getMessage());
            return false;
        }
    }

    public static int gz(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        if (jSONObjectEn != null) {
            return jSONObjectEn.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int fo(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        if (jSONObjectEn != null) {
            return jSONObjectEn.optInt("rit", 0);
        }
        return 0;
    }

    public static String uy(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        return jSONObjectEn != null ? jSONObjectEn.optString("origin_req_id", "") : "";
    }

    public static String kb(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        return jSONObjectEn != null ? jSONObjectEn.optString("customer_id", "") : "";
    }

    public static long a(String str) {
        return z(dl(str));
    }

    private static long z(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static int gc(String str) {
        return g(dl(str));
    }

    private static int g(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static double m(String str) {
        return dl(dl(str));
    }

    public static double wp(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        return dl(naVar.en());
    }

    private static double dl(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static long gc() {
        return kb;
    }

    public static String i(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        return jSONObjectEn != null ? jSONObjectEn.optString("req_id", "") : "";
    }

    public static String z(com.bytedance.sdk.openadsdk.core.iq.na naVar, String str) {
        JSONObject jSONObjectEn = naVar.en();
        return jSONObjectEn != null ? jSONObjectEn.optString("rit", str) : str;
    }

    public static int v(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        if (jSONObjectEn != null) {
            return jSONObjectEn.optInt("pricing", 0);
        }
        return 0;
    }

    public static int pf(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        if (jSONObjectEn != null) {
            return jSONObjectEn.optInt("price", 0);
        }
        return 0;
    }

    public static String ls(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = naVar.c();
        String strG = gcVarC != null ? gcVarC.g() : null;
        return TextUtils.isEmpty(strG) ? naVar.ls() : strG;
    }

    public static String p(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar.c() != null && !TextUtils.isEmpty(naVar.c().dl())) {
            return naVar.c().dl();
        }
        if (TextUtils.isEmpty(naVar.hy())) {
            return !TextUtils.isEmpty(naVar.li()) ? naVar.li() : "";
        }
        return naVar.hy();
    }

    public static String fv(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (TextUtils.isEmpty(naVar.li())) {
            return !TextUtils.isEmpty(naVar.he()) ? naVar.he() : "";
        }
        return naVar.li();
    }

    public static String m() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i2 = iLastIndexOf + 1;
            strConcat = strConcat.substring(0, i2).concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i2));
        }
        int length = strConcat.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = strConcat.charAt(i3);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String e() {
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        return un();
    }

    private static String un() {
        String string;
        long j;
        try {
            String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("sdk_local_web_ua", "");
            if (TextUtils.isEmpty(strDl)) {
                string = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strDl);
                string = jSONObject.getString("value");
                j = jSONObject.getLong("time");
                v = string;
            }
            if (TextUtils.isEmpty(string)) {
                eo();
            } else if (System.currentTimeMillis() - j > 259200000 && i.compareAndSet(false, true)) {
                if (com.bytedance.sdk.openadsdk.core.a.z.gz()) {
                    new com.bytedance.sdk.openadsdk.core.a.g("device_get_webua").z(5).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.eo.2
                        @Override // java.lang.Runnable
                        public void run() {
                            eo.ti();
                        }
                    });
                } else {
                    ti();
                }
            }
        } catch (Throwable unused) {
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ti() {
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("tt-webua") { // from class: com.bytedance.sdk.openadsdk.core.un.eo.3
            @Override // java.lang.Runnable
            public void run() {
                eo.eo();
            }
        });
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.un.eo$4, reason: invalid class name */
    static class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = eo.v = eo.ls(new SSWebView(com.bytedance.sdk.openadsdk.core.zw.getContext()).getUserAgentString());
                com.bytedance.sdk.openadsdk.core.dl.a.z().a("sdk_local_web_ua", eo.v);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eo() {
        try {
            v = ls(WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.zw.getContext()));
            com.bytedance.sdk.openadsdk.core.dl.a.z().a("sdk_local_web_ua", v);
            i.set(false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ls(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String gz() {
        return UUID.randomUUID().toString();
    }

    public static String z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        String strDecryptWithCBC;
        try {
            JSONObject jSONObject = new JSONObject(gVar.q());
            int iOptInt = jSONObject.optInt("cypher");
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                strDecryptWithCBC = com.bytedance.sdk.component.utils.z.dl(strOptString);
            } else if (iOptInt == 4) {
                com.bytedance.sdk.component.a.z zVarG = io.g();
                strDecryptWithCBC = zVarG == null ? "" : zVarG.decryptWithCBC(strOptString);
                if (strDecryptWithCBC == null) {
                    strDecryptWithCBC = "";
                }
            } else {
                strDecryptWithCBC = null;
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strDecryptWithCBC).optJSONArray("creatives");
            StringBuilder sb = new StringBuilder();
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    String strOptString2 = ((JSONObject) jSONArrayOptJSONArray.get(i2)).optString("material_key");
                    if (i2 != 0) {
                        sb.append("," + strOptString2);
                    } else {
                        sb.append(strOptString2);
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @HungeonFlag
    public static String fo() {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        if (com.bytedance.sdk.openadsdk.core.zw.getContext() != null) {
            try {
                p = com.bytedance.sdk.openadsdk.core.zw.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.dl("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return p;
    }

    public static String uy() {
        if (TextUtils.isEmpty(pf) && com.bytedance.sdk.openadsdk.core.zw.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.zw.getContext().getPackageManager().getPackageInfo(fo(), 0);
                pf = String.valueOf(packageInfo.versionCode);
                ls = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.dl("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return pf;
    }

    public static String kb() {
        if (TextUtils.isEmpty(ls) && com.bytedance.sdk.openadsdk.core.zw.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.zw.getContext().getPackageManager().getPackageInfo(fo(), 0);
                pf = String.valueOf(packageInfo.versionCode);
                ls = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.dl("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return ls;
    }

    public static String wp() {
        if (!TextUtils.isEmpty(f1373a) && !f1373a.equals("0")) {
            return f1373a;
        }
        String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("total_memory", "0");
        f1373a = strDl;
        return strDl;
    }

    public static String a(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.wp.z(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static int i() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.un.eo$5, reason: invalid class name */
    static class AnonymousClass5 implements FilenameFilter {
        private Pattern z = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass5() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.z.matcher(str).matches();
        }
    }

    public static int v() {
        if (z > 0) {
            return z;
        }
        int iG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("cpu_cnt", 0);
        z = iG;
        return iG;
    }

    public static int pf() {
        if (g > 0) {
            return g;
        }
        int iG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("cpu_max_freq", 0);
        g = iG;
        return iG;
    }

    public static int ls() {
        if (dl > 0) {
            return dl;
        }
        int iG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("cpu_min_freq", 0);
        dl = iG;
        return iG;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[Catch: Exception -> 0x005c, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:20:0x0054, B:22:0x0059), top: B:34:0x0054 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int dl(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            int r7 = r7 + (-1)
            if (r7 < 0) goto L6a
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L45
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L45
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L45
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L3a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L3a
            if (r2 <= r0) goto L31
            r0 = r2
        L31:
            r1.close()     // Catch: java.lang.Exception -> L37
            r3.close()     // Catch: java.lang.Exception -> L37
        L37:
            r2 = r1
            r1 = r3
            goto L3
        L3a:
            r2 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L49
        L3f:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L49
        L45:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L49:
            java.lang.String r4 = "ToolUtils"
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L5e
            com.bytedance.sdk.component.utils.wp.a(r4, r2)     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.lang.Exception -> L5c
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.lang.Exception -> L5c
        L5c:
            r2 = r3
            goto L3
        L5e:
            r7 = move-exception
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.lang.Exception -> L69
        L64:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.lang.Exception -> L69
        L69:
            throw r7
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.eo.dl(int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[Catch: Exception -> 0x005f, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:22:0x0057, B:24:0x005c), top: B:36:0x0057 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            int r7 = r7 + (-1)
            if (r7 < 0) goto L6d
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L48
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L48
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L48
            java.lang.String r5 = "/cpufreq/cpuinfo_min_freq"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L48
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L48
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L42
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L3d
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L3d
            if (r2 >= r0) goto L31
            goto L33
        L31:
            if (r0 != 0) goto L34
        L33:
            r0 = r2
        L34:
            r1.close()     // Catch: java.lang.Exception -> L3a
            r3.close()     // Catch: java.lang.Exception -> L3a
        L3a:
            r2 = r1
            r1 = r3
            goto L3
        L3d:
            r2 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L4c
        L42:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L4c
        L48:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L4c:
            java.lang.String r4 = "ToolUtils"
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L61
            com.bytedance.sdk.component.utils.wp.a(r4, r2)     // Catch: java.lang.Throwable -> L61
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.lang.Exception -> L5f
        L5a:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.lang.Exception -> L5f
        L5f:
            r2 = r3
            goto L3
        L61:
            r7 = move-exception
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.lang.Exception -> L6c
        L67:
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.lang.Exception -> L6c
        L6c:
            throw r7
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.eo.a(int):int");
    }

    public static long p() {
        if (gc > 0) {
            return gc;
        }
        long jG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("internal_storage", 0L);
        gc = jG;
        return jG;
    }

    public static long fv() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long js() {
        if (m > 0) {
            return m;
        }
        long jG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("free_storage", 0L);
        m = jG;
        return jG;
    }

    public static long tb() {
        if (e > 0) {
            return e;
        }
        long jG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("sdcard_storage", 0L);
        e = jG;
        return jG;
    }

    public static long q() {
        try {
            if (!oq()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.bytedance.sdk.openadsdk.api.plugin.g.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), null).getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean oq() {
        try {
            return "mounted".equals(com.bytedance.sdk.openadsdk.hh.dl.z());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int iq() {
        if (gz >= 0) {
            return gz;
        }
        int iG = com.bytedance.sdk.openadsdk.core.dl.a.z().g("is_root", -1);
        gz = iG;
        return iG;
    }

    public static boolean zw() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Map<String, Object> z(long j, com.bytedance.sdk.openadsdk.core.iq.na naVar, com.bykv.vk.openvk.component.video.api.z zVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (naVar != null) {
            if (!TextUtils.isEmpty(naVar.mj())) {
                map.put("creative_id", naVar.mj());
            }
            com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = tf.v(naVar);
            if (dlVarV != null) {
                map.put("video_resolution", dlVarV.fo());
                map.put("video_size", Long.valueOf(dlVarV.gc()));
            }
        }
        z(map, zVar);
        return map;
    }

    public static Map<String, Object> z(boolean z2, com.bytedance.sdk.openadsdk.core.iq.na naVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", naVar.mj());
        map.put("load_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = tf.v(naVar);
        if (dlVarV != null) {
            map.put("video_size", Long.valueOf(dlVarV.gc()));
            map.put("video_resolution", dlVarV.fo());
            map.put("video_preload_size", Long.valueOf(dlVarV.ls()));
        }
        if (!z2) {
            map.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> g(boolean z2, com.bytedance.sdk.openadsdk.core.iq.na naVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", naVar.mj());
        map.put("load_time", Long.valueOf(j));
        if (!z2) {
            map.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> z(com.bytedance.sdk.openadsdk.core.iq.na naVar, long j, com.bykv.vk.openvk.component.video.api.z zVar) {
        HashMap map = new HashMap();
        map.put("creative_id", naVar.mj());
        map.put("buffers_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = tf.v(naVar);
        if (dlVarV != null) {
            map.put("video_size", Long.valueOf(dlVarV.gc()));
            map.put("video_resolution", dlVarV.fo());
        }
        z(map, zVar);
        return map;
    }

    private static void z(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.z zVar) {
        if (map.containsKey("video_resolution") || zVar == null) {
            return;
        }
        try {
            map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(zVar.kb()), Integer.valueOf(zVar.wp())));
        } catch (Throwable unused) {
        }
    }

    public static JSONObject js(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.en();
    }

    public static boolean e(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String z(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("ToolUtils", e2.toString());
            return "";
        }
    }

    public static boolean tb(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null || com.bytedance.sdk.openadsdk.core.iq.js.a(naVar)) {
            return false;
        }
        int iFv = naVar.fv();
        return iFv == 5 || iFv == 4;
    }

    public static boolean z(boolean z2, com.bytedance.sdk.openadsdk.core.iq.na naVar, String str) {
        if (z2 || naVar == null) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.core.iq.ls lsVarVy = naVar.vy();
            if (!(naVar.fs() || (lsVarVy != null && lsVarVy.dl() == 2 && !lsVarVy.z() && com.bytedance.sdk.openadsdk.core.g.z().get("dpl_reject_by_dialog", false)))) {
                return false;
            }
            String strFp = naVar.fp();
            if (TextUtils.isEmpty(strFp) && lsVarVy != null && lsVarVy.gc() == 1 && !TextUtils.isEmpty(lsVarVy.a())) {
                strFp = lsVarVy.a();
            }
            if (!TextUtils.isEmpty(strFp)) {
                com.bytedance.sdk.openadsdk.core.eo.z(strFp, naVar, str);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean q(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return true;
        }
        int iE = com.bytedance.sdk.openadsdk.core.zw.g().e(fo(naVar));
        if (iE == 1) {
            return com.bytedance.sdk.component.utils.v.a(com.bytedance.sdk.openadsdk.core.zw.getContext());
        }
        if (iE == 2) {
            return com.bytedance.sdk.component.utils.v.gc(com.bytedance.sdk.openadsdk.core.zw.getContext()) || com.bytedance.sdk.component.utils.v.a(com.bytedance.sdk.openadsdk.core.zw.getContext()) || com.bytedance.sdk.component.utils.v.m(com.bytedance.sdk.openadsdk.core.zw.getContext());
        }
        if (iE != 3) {
            return iE != 5 || com.bytedance.sdk.component.utils.v.a(com.bytedance.sdk.openadsdk.core.zw.getContext()) || com.bytedance.sdk.component.utils.v.m(com.bytedance.sdk.openadsdk.core.zw.getContext());
        }
        return false;
    }

    private static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            fo = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            fo = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        fo = null;
        return str;
    }

    private static String fv(String str) {
        if (TextUtils.isEmpty(str)) {
            uy = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            uy = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        uy = null;
        return str;
    }

    public static String gz(String str) {
        return z(str, false, 0);
    }

    public static String fo(String str) {
        return z(str, false, 1);
    }

    public static String z(String str, boolean z2) {
        return z(str, z2, 0);
    }

    private static String z(String str, boolean z2, int i2) {
        String strUy = i2 == 0 ? com.bytedance.sdk.openadsdk.core.zw.g().uy() : p(com.bytedance.sdk.openadsdk.core.zw.g().pf());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.bytedance.sdk.openadsdk.tools.g.z() && com.bytedance.sdk.openadsdk.core.uy.ls().b() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strUy = com.bytedance.sdk.openadsdk.core.uy.ls().lw();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.bytedance.sdk.openadsdk.core.uy.ls().me() != null && fo().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strUy = com.bytedance.sdk.openadsdk.core.uy.ls().lw();
        } else {
            str2 = str;
        }
        String strZ = String.format("https://%s%s", strUy, str2);
        if (ti.z()) {
            if (!z2) {
                strZ = ti.g(strZ);
            }
            String strZ2 = ti.z("testIp.txt");
            if (strZ2 != null) {
                strZ = ti.z(strZ, strZ2);
            }
        }
        return z2 ? js(strZ) : strZ;
    }

    private static String js(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", uy()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String io() {
        String str = String.format("https://%s", fv(com.bytedance.sdk.openadsdk.core.zw.g().js()));
        return ti.g(Uri.parse(str).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static String uf() {
        return ti.g(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static String uy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static boolean z(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && z(j) == z(j2);
    }

    public static long z(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static boolean iq(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        return naVar != null && TextUtils.equals(naVar.mk(), naVar.mj()) && naVar.lt() == 3 && !TextUtils.isEmpty(zw(naVar));
    }

    public static String zw(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return "";
        }
        String strRy = naVar.ry();
        return (!TextUtils.isEmpty(strRy) || naVar.bw() == null) ? strRy : naVar.bw().i();
    }

    public static boolean g(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        }
        if (context == null) {
            com.bytedance.sdk.component.utils.wp.dl("params context is null");
            return false;
        }
        boolean z2 = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
        com.bytedance.sdk.component.utils.wp.z("ToolUtils", "can query all package = " + (!z2));
        return !z2;
    }

    public static String g(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (gVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(gVar.a());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String sy() {
        return fo() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static long dl(Context context) {
        int i2;
        try {
            i2 = context.getApplicationInfo().targetSdkVersion;
            try {
                com.bytedance.sdk.component.utils.wp.z("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i2));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i2 = -1;
        }
        return i2;
    }

    public static long a(Context context) {
        int i2;
        try {
            i2 = context.getApplicationInfo().minSdkVersion;
            try {
                com.bytedance.sdk.component.utils.wp.z("ToolUtils", "minSdkVersion = ", Integer.valueOf(i2));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i2 = -1;
        }
        return i2;
    }

    public static Bundle z(int i2, Bundle bundle) {
        int i3 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i4 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z2 = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z3 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_CODE, i4);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_MSG, string2);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, string);
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, i3);
        bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_PROPOSE, f);
        bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_IS_SERVER_VERIFY, z3);
        if (i2 == 0) {
            bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD, z2);
        }
        return bundle2;
    }

    public static String z(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 < iArr.length - 1) {
                sb.append(iArr[i2] + ",");
            } else {
                sb.append(iArr[i2]);
            }
        }
        return sb.toString();
    }

    public static int[] kb(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                iArr[i2] = Integer.parseInt(strArrSplit[i2]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static void z(Intent intent, com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.zw.g().xt()) {
            intent.putExtra("multi_process_materialmeta", naVar.kv().toString());
            return;
        }
        String str = naVar.hashCode() + naVar.aq();
        intent.putExtra("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.p.z(com.bytedance.sdk.openadsdk.core.zw.getContext())) {
            com.bytedance.sdk.openadsdk.core.io.z(str, naVar, com.bytedance.sdk.openadsdk.core.iq.na.class);
        } else {
            x.z("sp_meta").put(str, com.bytedance.sdk.component.utils.z.g(naVar.kv().toString()));
        }
    }

    public static int z(Class cls) {
        if (TTWebPageActivity.class.equals(cls)) {
            return 0;
        }
        if (TTNativePageActivity.class.equals(cls)) {
            return 2;
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            return 3;
        }
        return TTVideoScrollWebPageActivity.class.equals(cls) ? 4 : 0;
    }

    public static Class m(int i2) {
        if (i2 == 2) {
            return TTNativePageActivity.class;
        }
        if (i2 == 3) {
            return TTVideoWebPageActivity.class;
        }
        if (i2 == 4) {
            return TTVideoScrollWebPageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    public static void z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null || map == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.zw.g().xt()) {
            map.put("multi_process_materialmeta", naVar.kv().toString());
            return;
        }
        String str = naVar.hashCode() + naVar.aq();
        map.put("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.p.z(com.bytedance.sdk.openadsdk.core.zw.getContext())) {
            com.bytedance.sdk.openadsdk.core.io.z(str, naVar, com.bytedance.sdk.openadsdk.core.iq.na.class);
        } else {
            x.z("sp_meta").put(str, com.bytedance.sdk.component.utils.z.g(naVar.kv().toString()));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.iq.na z(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra)) {
                com.bytedance.sdk.openadsdk.core.iq.na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(stringExtra));
                if (naVarZ != null) {
                    return naVarZ;
                }
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.dl("ToolUtils", "getMaterialMeta from intent failed", e2);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        com.bytedance.sdk.openadsdk.core.iq.na naVar = (com.bytedance.sdk.openadsdk.core.iq.na) com.bytedance.sdk.openadsdk.core.io.g(stringExtra2, com.bytedance.sdk.openadsdk.core.iq.na.class);
        if (naVar != null) {
            return naVar;
        }
        com.bytedance.sdk.component.a.g.dl dlVarZ = x.z("sp_meta");
        String strDl = com.bytedance.sdk.component.utils.z.dl(dlVarZ.get(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(strDl)) {
                com.bytedance.sdk.component.utils.wp.a("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(strDl));
        } catch (Exception e3) {
            com.bytedance.sdk.component.utils.wp.z(e3);
            com.bytedance.sdk.component.utils.wp.dl("ToolUtils", "getMaterialMeta from keva failed", e3);
            return null;
        } finally {
            dlVarZ.remove(stringExtra2);
        }
    }

    public static void hh() {
        if (wp) {
            return;
        }
        wp = true;
        com.bytedance.sdk.component.kb.e.z zVarZ = com.bytedance.sdk.component.kb.e.z.z();
        zVarZ.z("open_sass_live", new com.bytedance.sdk.openadsdk.core.fo.z.g.kb());
        zVarZ.z("open_miniapp", new com.bytedance.sdk.openadsdk.core.fo.z.g.wp());
        zVarZ.z("open_landing_page", new com.bytedance.sdk.openadsdk.core.fo.z.g.uy());
        zVarZ.z("download", new com.bytedance.sdk.openadsdk.core.fo.z.g.e());
        zVarZ.z("open_scheme", new com.bytedance.sdk.openadsdk.core.fo.z.g.i());
        zVarZ.z("open_policy", new com.bytedance.sdk.openadsdk.core.fo.z.g.v());
        zVarZ.z("end_card", new com.bytedance.sdk.openadsdk.core.fo.z.g.fo());
        zVarZ.z("common_popup", new com.bytedance.sdk.openadsdk.core.fo.z.g.z());
        zVarZ.z("desc_popup", new com.bytedance.sdk.openadsdk.core.fo.z.g.g());
        zVarZ.z("permission_popup", new com.bytedance.sdk.openadsdk.core.fo.z.g.dl());
        zVarZ.z("privacy_popup", new com.bytedance.sdk.openadsdk.core.fo.z.g.a());
        zVarZ.z("registration_pop", new com.bytedance.sdk.openadsdk.core.fo.z.g.gc());
        zVarZ.z("dislike_popup", new com.bytedance.sdk.openadsdk.core.fo.z.g.m());
        zVarZ.z("download_popup", new com.bytedance.sdk.openadsdk.core.fo.z.g.gz());
        zVarZ.z("reward_again", new com.bytedance.sdk.openadsdk.core.fo.z.g.fv());
        zVarZ.z("reward_continue", new com.bytedance.sdk.openadsdk.core.fo.z.g.fv());
        zVarZ.z("close_reward", new com.bytedance.sdk.openadsdk.core.fo.z.g.p());
        zVarZ.z("report_event", new com.bytedance.sdk.openadsdk.core.fo.z.g.pf());
        zVarZ.z("report_stats", new com.bytedance.sdk.openadsdk.core.fo.z.g.ls());
    }

    public static String g(com.bytedance.sdk.openadsdk.core.iq.na naVar, String str) {
        ja jaVarFx;
        if (naVar == null || (jaVarFx = naVar.fx()) == null || jaVarFx.g() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.bytedance.sdk.openadsdk.core.g.z.g.a.dl().z()) {
            return sb.append(2).toString();
        }
        sb.append(jaVarFx.m());
        return sb.toString();
    }

    public static boolean z(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (!(str.startsWith("https:") || str.startsWith("http:"))) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.iq.lq.z.isEmpty()) {
            l();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.iq.lq.z;
        if (set.isEmpty()) {
            return true;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void l() {
        String strRy = com.bytedance.sdk.openadsdk.core.zw.g().ry();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(strRy);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!TextUtils.isEmpty(strGroup)) {
                    com.bytedance.sdk.openadsdk.core.iq.lq.z.add(strGroup);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strRy) || !com.bytedance.sdk.openadsdk.core.iq.lq.z.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.iq.lq.z.add("empty");
    }

    public static void g(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(268435456);
        } else if (com.bytedance.sdk.openadsdk.core.zw.g().js(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(268435456);
        }
    }

    public static String gc(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean wp(String str) {
        long jI = i(str);
        return jI != 0 && System.currentTimeMillis() - (jI * 1000) > 0;
    }

    public static long i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("/([^/]+)/video/tos/cn").matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                return 0L;
            }
            try {
                long j = Long.parseLong(strGroup, 16);
                return str.contains("v3-be-pack") ? j + 10800 : j;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static String io(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        com.bytedance.sdk.openadsdk.core.iq.m mVarBw;
        if (naVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = naVar.c();
        String strA = gcVarC != null ? gcVarC.a() : null;
        if (TextUtils.isEmpty(strA) && (mVarBw = naVar.bw()) != null) {
            strA = mVarBw.i();
        }
        return TextUtils.isEmpty(strA) ? naVar.ry() : strA;
    }
}
