package com.bytedance.msdk.core.dl;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.kuaishou.weapon.p0.bi;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static boolean g(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9;
    }

    private static boolean z(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static void z(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.g.g().na() != null) {
            com.bytedance.msdk.gz.z.dl.z().insert(str, str2, str3, "show");
        }
    }

    public static void g(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.g.g().na() != null) {
            com.bytedance.msdk.gz.z.dl.z().insert(str, str2, str3, "send");
        }
    }

    public static void dl(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.g.g().na() != null) {
            com.bytedance.msdk.gz.z.dl.z().insert(str, str2, str3, "fill");
        }
    }

    public static void z(String str, int i) {
        if (com.bytedance.msdk.core.g.g().na() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (i * 3600000));
        com.bytedance.msdk.z.gc.dl.g("TMe", "---预缓存优化删除存储的过期数据 primeRit = " + str + " startTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
        com.bytedance.msdk.gz.z.dl.z().z(str, jCurrentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.msdk.core.uy.g z(com.bytedance.msdk.api.z.g r29, com.bytedance.msdk.core.uy.g r30) {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.dl.dl.z(com.bytedance.msdk.api.z.g, com.bytedance.msdk.core.uy.g):com.bytedance.msdk.core.uy.g");
    }

    private static int z(com.bytedance.msdk.core.uy.g gVar, g gVar2, int i) {
        if (!com.bytedance.msdk.core.g.g().oq()) {
            return 0;
        }
        if (gVar2 == null || gVar2.gc() == null) {
            return 1;
        }
        if (!gVar2.z(i)) {
            return 2;
        }
        if (gVar2.g() == 0) {
            return 3;
        }
        if (gVar2.z() == 0) {
            return 4;
        }
        if (!gVar2.e()) {
            return 5;
        }
        if (gVar == null || !gVar2.z(gVar.un())) {
            return 6;
        }
        if (gVar.bv() == 0) {
            return 7;
        }
        if (z(gVar, gVar2)) {
            return z(gVar) ? 9 : 200;
        }
        return 8;
    }

    private static boolean z(com.bytedance.msdk.core.uy.g gVar, g gVar2) {
        if (gVar == null || gVar.t() == null || gVar2 == null) {
            return false;
        }
        for (uy uyVar : gVar.t()) {
            double dZ = gVar2.z(uyVar.p(), gVar.un());
            double dG = gVar2.g(uyVar.p(), gVar.un());
            if (dZ != 0.0d || dG != 0.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean z(com.bytedance.msdk.core.uy.g gVar) {
        if (gVar == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<com.bytedance.msdk.gz.z.g> listQuery = com.bytedance.msdk.gz.z.dl.z().query("", gVar.un(), jCurrentTimeMillis - (((long) gVar.bv()) * bi.s), jCurrentTimeMillis);
        return listQuery == null || listQuery.isEmpty();
    }

    private static void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.uy.g gVar2, g gVar3, int i, Set<String> set, Map<String, z> map) {
        if (gVar.uy() != null) {
            com.bytedance.msdk.z.gc.dl.g("TMe", "预缓存优化存在埋点数据 无需重新存储");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            if (z(i)) {
                gVar.z(jSONObject);
                return;
            }
            jSONObject.put("perform", z(i, gVar3, map));
            if (g(i)) {
                gVar.z(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", z(gVar3));
            jSONObject.put("condition", gVar3.g());
            if (gVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", gVar2.bv());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            gVar.z(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray z(g gVar) {
        JSONArray jSONArray = new JSONArray();
        if (gVar != null && gVar.z != null) {
            Iterator<Integer> it = gVar.z.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        return jSONArray;
    }

    private static JSONObject z(int i, g gVar, Map<String, z> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rule_id", gVar.dl());
        jSONObject.put("rule_timestamp", gVar.a());
        if (g(i)) {
            return jSONObject;
        }
        jSONObject.put("condition", gVar.z());
        jSONObject.put("rule_inuse", (i == 10 || i == 11) ? 1 : 0);
        if (map != null) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, z> entry : map.entrySet()) {
                    z value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(entry.getKey(), decimalFormat.format(value.g()));
                        jSONObject4.put(entry.getKey(), decimalFormat.format(value.dl()));
                    }
                }
                jSONObject2.put("ssr", jSONObject3);
                jSONObject2.put("srr", jSONObject4);
                jSONObject.put("res", jSONObject2);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
