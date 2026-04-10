package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cu {
    public static String a = "appkey";
    public static String b = "secretkey";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f16674c = "pver";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f16675d = "sdkver";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f16676e = "ksid";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f16677f = "timestamp";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f16678g = "sign";

    public static String a(Context context) {
        Map mapD = d(context);
        if (mapD == null || mapD.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : mapD.entrySet()) {
            str = str + DispatchConstants.SIGN_SPLIT_SYMBOL + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + DispatchConstants.SIGN_SPLIT_SYMBOL + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bs.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put(com.anythink.expressad.d.a.b.N, bg.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(de.f16686g, bp.f16591e));
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bp.f16593g);
        } catch (Exception unused) {
        }
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(a));
            sb.append(map.get(b));
            sb.append(map.get(f16677f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.0.7");
            jSONObject.put("device_id", cl.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bs.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put(com.anythink.expressad.d.a.b.N, bg.q(context));
            try {
                String strB = h.a(context, "re_po_rt").b(de.f16688i, bp.f16591e);
                if (TextUtils.isEmpty(strB)) {
                    strB = bp.f16591e;
                }
                jSONObject.put("pver", strB);
            } catch (Exception unused) {
                jSONObject.put("pver", bp.f16591e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bp.f16593g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.0.7");
            jSONObject.put("device_id", cl.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap map = new HashMap();
            map.put(a, str);
            map.put(b, str2);
            map.put(f16677f, String.valueOf(System.currentTimeMillis() / 1000));
            map.put(f16678g, b(map));
            return map;
        } catch (Exception unused) {
            return null;
        }
    }
}
