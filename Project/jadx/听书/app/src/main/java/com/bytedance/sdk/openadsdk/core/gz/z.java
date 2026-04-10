package com.bytedance.sdk.openadsdk.core.gz;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static String dl;
    private static volatile String g;
    private static volatile String z;

    public static String dl() {
        return "7.1.0.5";
    }

    public static String g() {
        return "1371";
    }

    public static String z() {
        return "open_news";
    }

    public static String a() {
        return eo.kb();
    }

    public static String gc() {
        return uy.ls().iq();
    }

    public static String m() {
        return v.e(zw.getContext());
    }

    public static String e() {
        return tb.dl();
    }

    public static String z(Context context) {
        try {
        } catch (Throwable th) {
            wp.g("getApplicationName:", th);
        }
        if (z != null) {
            return z;
        }
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && bundle.keySet() != null) {
            for (String str : bundle.keySet()) {
                if (str != null && str.toLowerCase().contains("channel")) {
                    Object obj = bundle.get(str);
                    jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                }
            }
        }
        z = jSONObject.toString();
        return z;
    }

    public static String g(Context context) {
        if (g != null) {
            return g;
        }
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            g = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return g;
    }

    public static int dl(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            wp.z(e);
            return 0;
        }
    }

    @HungeonFlag
    public static String gz() {
        if (!TextUtils.isEmpty(dl)) {
            return dl;
        }
        String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("app_sha1", 2592000000L);
        dl = strDl;
        if (!TextUtils.isEmpty(strDl)) {
            return dl;
        }
        String strZ = com.bytedance.sdk.component.utils.dl.z(zw.getContext());
        dl = strZ;
        if (z(strZ)) {
            dl = dl.toUpperCase(Locale.getDefault());
            com.bytedance.sdk.openadsdk.core.dl.a.z().a("app_sha1", dl);
            return dl;
        }
        return "";
    }

    private static boolean z(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(":")) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
