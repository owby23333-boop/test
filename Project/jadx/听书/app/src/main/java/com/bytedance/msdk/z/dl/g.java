package com.bytedance.msdk.z.dl;

import android.text.TextUtils;
import com.bytedance.msdk.api.a.uy;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static boolean z(String str) {
        String strDl = dl();
        return (TextUtils.isEmpty(strDl) || TextUtils.isEmpty(str) || strDl.compareTo(str) < 0) ? false : true;
    }

    public static String z(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("name"))) {
                            jSONObjectOptJSONObject.put("value", str3);
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put("value", str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return str;
    }

    public static double z(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        try {
            if (obj instanceof String) {
                return Double.valueOf((String) obj).doubleValue();
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static long z(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get("creative_id") != null) {
                return ((Long) map.get("creative_id")).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            wp.z(th);
            return 0L;
        }
    }

    public static long g(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get(MediationConstant.EXTRA_ADID) != null) {
                return ((Long) map.get(MediationConstant.EXTRA_ADID)).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            wp.z(th);
            return 0L;
        }
    }

    public static String dl(Map<String, Object> map) {
        if (map == null || map.get("request_id") == null) {
            return null;
        }
        return (String) map.get("request_id");
    }

    public static void g(String str) {
        uy.g(str);
    }

    public static String z() {
        return uy.e();
    }

    private static Map<String, String> g() {
        return uy.gz();
    }

    private static JSONArray g(com.bytedance.sdk.openadsdk.mediation.g.g.z zVar) {
        if (zVar == null || TextUtils.isEmpty(zVar.iq())) {
            return null;
        }
        try {
            return new JSONArray(zVar.iq());
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    public static JSONArray z(com.bytedance.sdk.openadsdk.mediation.g.g.z zVar) {
        JSONArray jSONArrayDl = dl(z());
        try {
            Map<String, String> mapG = g();
            if (mapG != null && mapG.size() > 0) {
                for (String str : mapG.keySet()) {
                    String str2 = mapG.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str);
                        jSONObject.putOpt("value", str2);
                        jSONArrayDl.put(jSONObject);
                    }
                }
            }
            JSONArray jSONArrayG = g(zVar);
            if (jSONArrayG != null) {
                for (int i = 0; i < jSONArrayG.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayG.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && !TextUtils.equals("personal_ads_type", jSONObjectOptJSONObject.optString("name"))) {
                        jSONArrayDl.put(jSONObjectOptJSONObject);
                    }
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONArrayDl;
    }

    private static void z(g.z zVar, String str, String str2, boolean z, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar2) {
        JSONObject jSONObject;
        JSONArray jSONArrayZ = z(zVar2);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_sdk_version");
            jSONObject2.putOpt("value", com.bytedance.msdk.g.g.g());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("name", "mediation_req_type");
            jSONObject3.putOpt("value", "1");
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                jSONObject.putOpt("name", "waterfall_abtest");
                jSONObject.putOpt("value", str);
            }
            jSONArrayZ.put(jSONObject3);
            jSONArrayZ.put(jSONObject2);
            if (jSONObject != null) {
                jSONArrayZ.put(jSONObject);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "m_req_id");
                jSONObject4.putOpt("value", str2);
                jSONArrayZ.put(jSONObject4);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        if (!z) {
            z(zVar);
        }
        com.bytedance.sdk.gromore.init.z.z(uy.m());
        if (zVar != null) {
            zVar.fo(jSONArrayZ.toString());
        }
    }

    static JSONArray dl(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception e) {
            wp.z(e);
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static void z(g.z zVar) {
        if (zVar != null && uy.fo()) {
            try {
                String strDl = uy.dl("tt_pangle_preview_ad_id");
                String strDl2 = uy.dl("tt_pangle_preview_creative_id");
                String strDl3 = uy.dl("tt_pangle_preview_ext");
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "pangle preview adId:" + strDl + " creativeId:" + strDl2 + " ext" + strDl3);
                if (!TextUtils.isEmpty(strDl) && !TextUtils.isEmpty(strDl2)) {
                    zVar.z(strDl).g(strDl2);
                }
                if (TextUtils.isEmpty(strDl3)) {
                    return;
                }
                zVar.dl(strDl3);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    public static g.z z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2, boolean z) {
        return z(gVar, gVar2.wp(), gVar2.ls(), gVar2.p(), gVar2.uf(), z);
    }

    public static g.z z(com.bytedance.msdk.api.z.g gVar, String str, String str2, String str3, String str4, boolean z) {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVarQ;
        g.z zVarDl = new g.z().a(str).dl(1);
        if (gVar != null) {
            zVarDl.m(gVar.g()).e(gVar.zw()).g(gVar.l());
            zVarQ = gVar.q();
            if (zVarQ != null) {
                zVarDl.m(zVarQ.v()).z(zVarQ.gc()).a(zVarQ.sy()).z(zVarQ.z()).g(zVarQ.g()).a(zVarQ.pf()).z(zVarQ.zw()).gc(zVarQ.i()).dl(zVarQ.dl());
                String strJs = zVarQ.js();
                if (!TextUtils.isEmpty(strJs)) {
                    zVarDl.e(strJs);
                }
                if (zVarQ.fv() != 0) {
                    zVarDl.m(zVarQ.fv());
                }
            }
            int[] iArrZ = z(gVar, zVarQ);
            if (iArrZ != null && iArrZ.length > 0) {
                zVarDl.z(iArrZ);
            }
            if (5 == gVar.iq() || 9 == gVar.iq()) {
                zVarDl.dl(gVar.hh());
            }
        } else {
            zVarQ = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            zVarDl.gz(str4);
        }
        z(zVarDl, str2, str3, z, zVarQ);
        return zVarDl;
    }

    private static int[] z(com.bytedance.msdk.api.z.g gVar, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar) {
        if (zVar != null && zVar.p() != null && zVar.p().length > 0) {
            return zVar.p();
        }
        try {
            Map<String, Object> mapOq = gVar.oq();
            if (mapOq != null) {
                return (int[]) mapOq.get(MediationConstant.PANGLE_VID);
            }
            return null;
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    private static String dl() {
        try {
            return com.bytedance.sdk.gromore.init.z.dl();
        } catch (Throwable unused) {
            return "0.0";
        }
    }

    public static boolean z(com.bytedance.msdk.api.z.g gVar) {
        if (gVar != null && gVar.oq() != null) {
            Object obj = gVar.oq().get(MediationConstant.BANNER_AUTO_HEIGHT);
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
