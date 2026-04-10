package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.embedapplog.gc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1387a = false;
    private static volatile boolean dl = false;
    private static volatile String g = "";
    private static volatile String z = "";

    public static void z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            dl = true;
            z = str;
            com.bytedance.sdk.openadsdk.tools.g.g(7, z == null ? "" : z);
            f1387a = false;
            update(false);
        } catch (Throwable unused) {
        }
    }

    public static void z(com.bytedance.sdk.openadsdk.pf.a aVar) {
        com.bytedance.sdk.openadsdk.z.z.z.z(aVar);
        com.bytedance.sdk.openadsdk.core.live.g.z().z(aVar);
    }

    public static String g(com.bytedance.sdk.openadsdk.pf.a aVar) {
        JSONObject jSONObjectZ;
        if (aVar != null) {
            String type = aVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, "timeout")) {
                return "timeout";
            }
            gc.z zVarZ = aVar.z();
            if (zVarZ != null && !TextUtils.isEmpty(zVarZ.z) && (jSONObjectZ = z(zVarZ)) != null) {
                return jSONObjectZ.toString();
            }
        }
        return "error";
    }

    public static String dl(com.bytedance.sdk.openadsdk.pf.a aVar) {
        if (aVar == null) {
            return null;
        }
        String type = aVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, "timeout")) {
            return "timeout";
        }
        gc.z zVarZ = aVar.z();
        return (zVarZ == null || TextUtils.isEmpty(zVarZ.z)) ? "error" : zVarZ.z;
    }

    private static JSONObject z(gc.z zVar) {
        if (zVar == null) {
            return null;
        }
        String str = zVar.z;
        long j = zVar.dl;
        boolean z2 = zVar.g;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(z2));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(j));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(z(com.bytedance.sdk.openadsdk.core.zw.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    public static gc.z dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new gc.z(str, false, z(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }

    private static int z(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = "com.huawei.hms";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return 0;
        }
    }

    public static String z(boolean z2) {
        long j;
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        if (z2 && !TextUtils.isEmpty(g)) {
            return g;
        }
        try {
            String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("new_app_log_oaid", (String) null);
            if (TextUtils.isEmpty(strDl)) {
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strDl);
                g = com.bytedance.sdk.component.utils.z.dl(jSONObject.getString("value"));
                j = jSONObject.getLong("time");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(g) && (z2 || System.currentTimeMillis() - j < 86400000)) {
            g();
            return g;
        }
        if (!dl) {
            com.bytedance.sdk.openadsdk.core.m.z().g();
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarJs = com.bytedance.sdk.openadsdk.core.uy.ls().js();
            if (aVarJs != null && !TextUtils.isEmpty(aVarJs.wp())) {
                z = aVarJs.wp();
                boolean z3 = !TextUtils.isEmpty(aVarJs.wp());
                f1387a = z3;
                update(z3);
            }
            com.bytedance.sdk.openadsdk.tools.g.g(7, z == null ? "" : z);
        }
        return z == null ? "" : z;
    }

    public static int z() {
        return f1387a ? 1 : 0;
    }

    private static void g() {
        f1387a = com.bytedance.sdk.openadsdk.core.dl.a.z().g("is_use_dev_oaid", false);
    }

    private static void update(boolean z2) {
        if (TextUtils.isEmpty(z)) {
            return;
        }
        String strG = com.bytedance.sdk.component.utils.z.g(z);
        com.bytedance.sdk.openadsdk.core.dl.a.z().a("app_log_oaid", z);
        com.bytedance.sdk.openadsdk.core.dl.a.z().a("new_app_log_oaid", strG);
        com.bytedance.sdk.openadsdk.core.dl.a.z().z("is_use_dev_oaid", z2);
    }
}
