package com.bytedance.msdk.dl.gz;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.gz.x;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Map<String, List<com.bytedance.msdk.core.uy.gc>> z = new ConcurrentHashMap();
    public static Map<String, String> g = new ConcurrentHashMap();

    public static PluginValueSet z(String str, g.z zVar, int i) {
        long jCurrentTimeMillis;
        String strG;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return com.bytedance.sdk.openadsdk.mediation.g.g.z.z(zVar.z());
        }
        if (com.bytedance.msdk.core.kb.z.z().z(str)) {
            return com.bytedance.sdk.openadsdk.mediation.g.g.z.z(zVar.z());
        }
        String strZ = z(str);
        if (TextUtils.isEmpty(strZ)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            strG = g(str);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            i2 = !TextUtils.isEmpty(strG) ? 2 : 3;
        } else {
            jCurrentTimeMillis = 0;
            strG = strZ;
            i2 = 1;
        }
        com.bytedance.msdk.gc.m.z(i, i2, jCurrentTimeMillis, str, strG);
        if (TextUtils.isEmpty(strG)) {
            return com.bytedance.sdk.openadsdk.mediation.g.g.z.z(zVar.z());
        }
        zVar.a(strG);
        return com.bytedance.sdk.openadsdk.mediation.g.g.z.z(zVar.z(), str, i2 == 2);
    }

    public static void z(final JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        double dDoubleValue;
        if (jSONObject == null) {
            return;
        }
        z.clear();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(next)) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("price");
                        long jOptLong = jSONObject2.optLong("csj_code_id");
                        try {
                            dDoubleValue = Double.valueOf(strOptString).doubleValue();
                        } catch (Throwable unused) {
                            dDoubleValue = 0.0d;
                        }
                        copyOnWriteArrayList.add(new com.bytedance.msdk.core.uy.gc(String.valueOf(jOptLong), dDoubleValue, 0, 0));
                    }
                    z.put(next, copyOnWriteArrayList);
                }
            }
        } catch (Throwable unused2) {
        }
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.dl.gz.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.e.z.dl().z("mediation_csj_map", jSONObject.toString());
            }
        });
    }

    public static void z() {
        if (g.size() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : g.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.dl.gz.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.e.z.dl().z("mediation_adn_map", jSONObject.toString());
            }
        });
    }

    public static boolean z(String str, String str2) {
        List<com.bytedance.msdk.core.uy.gc> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = z.get(str)) == null || list.size() == 0) {
            return true;
        }
        x.z(list);
        return str2.equals(list.get(0).z());
    }

    private static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z.size() == 0) {
            g();
        }
        for (String str2 : z.keySet()) {
            List<com.bytedance.msdk.core.uy.gc> list = z.get(str2);
            if (list != null) {
                Iterator<com.bytedance.msdk.core.uy.gc> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().z())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    private static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (g.size() == 0) {
            dl();
        }
        return g.get(str);
    }

    private static void g() {
        String strG = com.bytedance.msdk.e.z.dl().g("mediation_csj_map");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strG);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            String strOptString = jSONObjectOptJSONObject.optString("csj_code_id");
                            if (TextUtils.isEmpty(strOptString)) {
                                strOptString = jSONObjectOptJSONObject.optString("csj_rit_id");
                            }
                            double dOptDouble = jSONObjectOptJSONObject.optDouble("price");
                            if (dOptDouble <= 0.0d) {
                                dOptDouble = jSONObjectOptJSONObject.optDouble(MediationConstant.KEY_ECPM);
                            }
                            copyOnWriteArrayList.add(new com.bytedance.msdk.core.uy.gc(strOptString, dOptDouble, jSONObjectOptJSONObject.optInt("load_sort"), jSONObjectOptJSONObject.optInt("show_sort")));
                        }
                        z.put(next, copyOnWriteArrayList);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dl() {
        String strG = com.bytedance.msdk.e.z.dl().g("mediation_adn_map");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strG);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                        g.put(next, string);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
