package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Reflection;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTAdnUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final Map<String, ITTAdapterConfiguration> a = new HashMap();

    public static boolean a(Map<String, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!f(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Map<String, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!g(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static String c(String str) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (h(str)) {
            GMCustomAdapterConfiguration gMCustomAdapterConfigurationA = a(str);
            return gMCustomAdapterConfigurationA == null ? "" : gMCustomAdapterConfigurationA.getAdapterSdkVersion();
        }
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            iTTAdapterConfiguration = a.get(strB);
        } catch (Throwable unused) {
        }
        if (iTTAdapterConfiguration != null) {
            return iTTAdapterConfiguration.getAdapterVersion();
        }
        ITTAdapterConfiguration iTTAdapterConfiguration2 = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(strB, ITTAdapterConfiguration.class);
        if (iTTAdapterConfiguration2 != null) {
            a.put(strB, iTTAdapterConfiguration2);
            return iTTAdapterConfiguration2.getAdapterVersion();
        }
        return null;
    }

    private static String d(String str) {
        return "pangle".equals(str) ? "com.bytedance.sdk.openadsdk.TTAdSdk" : "unity".equals(str) ? "com.unity3d.ads.UnityAds" : "baidu".equals(str) ? "com.baidu.mobads.sdk.api.AdSettings" : "admob".equals(str) ? "com.google.android.gms.ads.MobileAds" : "gdt".equals(str) ? "com.qq.e.comm.managers.status.SDKStatus" : "ks".equals(str) ? "com.kwad.sdk.api.KsAdSDK" : "sigmob".equals(str) ? "com.sigmob.windad.WindAds" : "mintegral".equals(str) ? "com.mbridge.msdk.out.MBConfiguration" : "klevin".equals(str) ? "com.tencent.klevin.KlevinManager" : "";
    }

    public static String e(String str) {
        if ("pangle".equals(str)) {
            return h();
        }
        if ("unity".equals(str)) {
            return j();
        }
        if ("baidu".equals(str)) {
            return c();
        }
        if ("admob".equals(str)) {
            return a();
        }
        if ("gdt".equals(str)) {
            return d();
        }
        if ("ks".equals(str)) {
            return f();
        }
        if ("sigmob".equals(str)) {
            return i();
        }
        if ("mintegral".equals(str)) {
            return g();
        }
        if ("klevin".equals(str)) {
            return e();
        }
        return null;
    }

    public static boolean f(String str) {
        if (h(str)) {
            if (a(str) == null) {
                return false;
            }
            return !TextUtils.isEmpty(r4.getAdapterSdkVersion());
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strB = b(str);
        return !TextUtils.isEmpty(strB) && Reflection.classFound(strB) && GMMediationAdSdk.isAdapterVersionFit(str, c(str));
    }

    public static boolean g(String str) {
        if (h(str)) {
            if (a(str) == null) {
                return false;
            }
            return !TextUtils.isEmpty(r4.getNetworkSdkVersion());
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strD = d(str);
        return !TextUtils.isEmpty(strD) && Reflection.classFound(strD) && GMMediationAdSdk.isAdnVersionFit(str, e(str));
    }

    public static boolean h(String str) {
        try {
            Method declaredMethod = Class.forName("com.bytedance.msdk.api.v2.GMMediationAdSdk").getDeclaredMethod("isCustom", String.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, str);
            declaredMethod.setAccessible(false);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return false;
    }

    private static String i() {
        try {
            return (String) Class.forName("com.sigmob.windad.WindAds").getMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String j() {
        try {
            return (String) Class.forName("com.unity3d.ads.UnityAds").getMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, Map<String, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> map) {
        List<String> listA;
        if (map == null || map.size() == 0) {
            return false;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if ((Build.VERSION.SDK_INT < 24 && i2 < 24) || (listA = a(context)) == null) {
            return true;
        }
        for (String str : map.keySet()) {
            if (!h(str) && !"unity".equals(str) && !listA.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static int b() {
        return f.a.size();
    }

    private static String b(String str) {
        return "pangle".equals(str) ? "com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration" : "unity".equals(str) ? "com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration" : "baidu".equals(str) ? "com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration" : "admob".equals(str) ? "com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration" : "gdt".equals(str) ? "com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration" : "ks".equals(str) ? "com.bytedance.msdk.adapter.ks.KsAdapterConfiguration" : "sigmob".equals(str) ? "com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration" : "mintegral".equals(str) ? "com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration" : "klevin".equals(str) ? "com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration" : "";
    }

    private static String d() {
        try {
            return (String) Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String f() {
        try {
            return (String) Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String g() {
        try {
            return (String) Class.forName("com.mbridge.msdk.out.MBConfiguration").getDeclaredField("SDK_VERSION").get(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String c() {
        try {
            return (String) Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String h() {
        try {
            Object objInvoke = Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk").getMethod("getAdManager", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke != null) {
                return (String) objInvoke.getClass().getMethod("getSDKVersion", new Class[0]).invoke(objInvoke, new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static GMCustomAdapterConfiguration a(String str) {
        try {
            Method declaredMethod = Class.forName("com.bytedance.msdk.api.v2.GMMediationAdSdk").getDeclaredMethod("getCustomAdapterConfiguration", String.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, str);
            declaredMethod.setAccessible(false);
            if (objInvoke instanceof GMCustomAdapterConfiguration) {
                return (GMCustomAdapterConfiguration) objInvoke;
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return null;
    }

    private static String e() {
        try {
            return (String) Class.forName("com.tencent.klevin.KlevinManager").getMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        List<String> listA;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("unity".equals(str)) {
            return true;
        }
        return (Build.VERSION.SDK_INT >= 24 || context.getApplicationInfo().targetSdkVersion >= 24) && (listA = a(context)) != null && listA.contains(str);
    }

    private static List<String> a(Context context) {
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ProviderInfo> it = listQueryContentProviders.iterator();
        while (it.hasNext()) {
            switch (it.next().name) {
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add("pangle");
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add("gdt");
                    break;
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add("baidu");
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                    arrayList.add("sigmob");
                    break;
                case "com.google.android.gms.ads.MobileAdsInitProvider":
                    arrayList.add("admob");
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add("ks");
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add("mintegral");
                    break;
                case "com.unity":
                    arrayList.add("unity");
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add("klevin");
                    break;
            }
        }
        return arrayList;
    }

    private static String a() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.MobileAds").getMethod("getVersionString", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
