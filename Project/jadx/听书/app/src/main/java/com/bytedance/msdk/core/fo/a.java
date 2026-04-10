package com.bytedance.msdk.core.fo;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final Map<String, com.bytedance.msdk.core.uy.g> z = new ConcurrentHashMap();

    public static void z(int i, String str, int i2, double d) {
        com.bytedance.msdk.core.uy.g gVarZ;
        com.bytedance.msdk.core.uy.a aVarGc;
        if (com.bytedance.msdk.core.g.g().y() && (gVarZ = com.bytedance.msdk.core.g.g().z(str, i2, 101)) != null) {
            if (gVarZ.e() == 1 && i == 1) {
                gc.a().z(i2, d);
                return;
            }
            if (gVarZ.e() != 2 || (aVarGc = com.bytedance.msdk.core.g.g().gc(str)) == null) {
                return;
            }
            if (i == 2 && aVarGc.dl() == 2) {
                g.a().z(str, 2, d);
            } else {
                if (i != 1 || aVarGc.dl() == 2) {
                    return;
                }
                g.a().z(str, aVarGc.dl(), d);
            }
        }
    }

    public static void z(com.bytedance.msdk.core.uy.g gVar, double d, String str, int i) {
        if (!com.bytedance.msdk.core.g.g().y() || gVar == null) {
            return;
        }
        if (gVar.e() == 2) {
            z(2, str, i, d);
        } else if (gVar.e() == 3 || gVar.e() == 4) {
            g.a().z(gVar.un(), "_last_load_cpm_", gVar.lq(), d);
        }
    }

    public static void z(String str, String str2, int i, JSONObject jSONObject) {
        com.bytedance.msdk.core.uy.g gVarZ;
        if (com.bytedance.msdk.core.g.g().y() && (gVarZ = com.bytedance.msdk.e.z.dl.z().z(str, i, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (gVarZ.e() == 1) {
                    gc.a().z(String.valueOf(i), jSONObject, gVarZ.m());
                    return;
                } else {
                    if (gVarZ.e() == 2) {
                        g.a().z(String.valueOf(i), jSONObject, gVarZ.m());
                        return;
                    }
                    return;
                }
            }
            if (gVarZ.e() != 2 || "sdk_init".equals(str2) || "sdk_init_end".equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
                return;
            }
            g.a().dl(String.valueOf(i), jSONObject, gVarZ.m());
        }
    }

    public static com.bytedance.msdk.core.uy.g z(com.bytedance.msdk.core.uy.g gVar, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (gVar != null && com.bytedance.msdk.core.g.g().y()) {
            if (i == 101) {
                return z.get(gVar.un());
            }
            if (i == 100 && (gVar.e() == 2 || gVar.e() == 3 || gVar.e() == 4)) {
                List<uy> listZ = dl.z(gVar, gVar.un());
                Object obj = gVar.m().get("rule_in_use");
                int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                gVar.m().put("cost_time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                if (listZ == null || iIntValue == 0) {
                    return gVar;
                }
                com.bytedance.msdk.core.uy.g gVarClone = gVar.clone();
                if (gVarClone.wp()) {
                    gVarClone.g(listZ);
                } else {
                    gVarClone.z(listZ);
                }
                Object obj2 = gVarClone.m().get("max_ecpm");
                Object obj3 = gVarClone.m().get("min_ecpm");
                if (obj2 != null) {
                    gVarClone.a(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    gVarClone.gc(((Double) obj3).doubleValue());
                }
                z.put(gVar.un(), gVarClone);
                gVarClone.m().put("cost_time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return gVarClone;
            }
        }
        return null;
    }

    public static int z(String str, int i, Map<String, Object> map) {
        com.bytedance.msdk.core.uy.a aVarGc;
        int iZ;
        if (!TextUtils.isEmpty(str) && i == 1 && (aVarGc = com.bytedance.msdk.core.g.g().gc(str)) != null) {
            int iDl = aVarGc.dl();
            String strA = aVarGc.a();
            if (iDl > 0 && !TextUtils.isEmpty(strA)) {
                double dZ = g.a().z(3, str, iDl);
                List<com.bytedance.msdk.core.uy.dl> listM = com.bytedance.msdk.core.g.g().m(String.valueOf(i));
                if (listM == null || listM.size() <= 0) {
                    iZ = 0;
                    if (iZ < 10000 && iZ <= 180000) {
                        return iZ;
                    }
                } else {
                    for (com.bytedance.msdk.core.uy.dl dlVar : listM) {
                        if (dZ > dlVar.m() && dZ <= dlVar.gc()) {
                            iZ = aVarGc.z(String.valueOf(dlVar.dl()));
                            map.put("refresh_time", Integer.valueOf(iZ));
                            break;
                        }
                    }
                    iZ = 0;
                    if (iZ < 10000) {
                    }
                }
            }
        }
        return 0;
    }

    public static void z(int i, String str, JSONObject jSONObject) {
        com.bytedance.msdk.core.uy.a aVarGc;
        if (com.bytedance.msdk.core.g.g().y() && i == 2 && (aVarGc = com.bytedance.msdk.core.g.g().gc(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", aVarGc.a());
            } catch (JSONException e) {
                wp.z(e);
            }
        }
    }

    public static void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.core.uy.g gVar) {
        Object obj;
        if (!com.bytedance.msdk.core.g.g().y() || list == null || gVar == null) {
            return;
        }
        for (com.bytedance.msdk.g.dl dlVar : list) {
            if (dlVar != null) {
                if (gVar.e() == 1) {
                    dlVar.h().put(MediationConstant.KEY_GM_USB, gc.dl(gVar.ti()));
                } else if (gVar.e() == 2 && (obj = gVar.m().get("user_label_value")) != null) {
                    dlVar.h().put(MediationConstant.KEY_GM_USB, ((com.bytedance.msdk.core.uy.dl) obj).z());
                }
            }
        }
    }

    public static void z(boolean z2, com.bytedance.msdk.gc.a aVar, JSONObject jSONObject, Map<String, Object> map) {
        if (aVar == null || !com.bytedance.msdk.core.g.g().y()) {
            return;
        }
        gc.a().z(z2, aVar, jSONObject, map);
    }

    public static void z(int i, List<uy> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (uy uyVar : list) {
            if (uyVar != null && uyVar.js() == 0) {
                jSONArray.put(uyVar.fv());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
