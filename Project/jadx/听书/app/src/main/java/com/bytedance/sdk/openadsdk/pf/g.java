package com.bytedance.sdk.openadsdk.pf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.tb;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static String z;

    public static String a() {
        return "";
    }

    public static void z(Context context, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.a.z.dl dlVarLs = uy.ls();
            float longitude = 0.0f;
            float latitude = dlVarLs == null ? 0.0f : dlVarLs.getLatitude();
            if (dlVarLs != null) {
                longitude = dlVarLs.getLongitude();
            }
            jSONObject.put("latitude", latitude);
            jSONObject.put("longitude", longitude);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    public static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar, List<String> list) {
        if (aVar.z()) {
            list.add(com.kuaishou.weapon.p0.g.h);
            list.add(com.kuaishou.weapon.p0.g.g);
        }
    }

    public static void z(JSONObject jSONObject, int i) {
        if (uy.ls() != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r5.getLatitude());
                jSONObject2.put("longitude", r5.getLongitude());
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static void g(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("imei", uy.gz());
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    private static String gc() {
        if (TextUtils.isEmpty(z)) {
            String strGz = uy.gz();
            if (!TextUtils.isEmpty(strGz)) {
                z = gc.g(strGz);
            }
        }
        return z;
    }

    public static String z() {
        if (com.bytedance.sdk.openadsdk.core.uy.ls().p().a()) {
            return uy.fo();
        }
        return null;
    }

    public static void dl(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("udid", uy.gz());
            jSONObject.put(an.A, uy.wp());
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayZ = tb.z(context);
            if (jSONArrayZ != null) {
                jSONObject.put("app_list", jSONArrayZ);
            }
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    public static void g() {
        uy.ls();
    }

    public static void dl() {
        com.bytedance.sdk.openadsdk.core.gk.dl.z().g();
    }

    public static boolean z(String str) {
        return tb.z(str);
    }

    public static void z(Context context) {
        if ((zw.g().ey() & 8) != 0) {
            return;
        }
        z.z(context);
    }
}
