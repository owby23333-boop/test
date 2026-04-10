package com.bytedance.msdk.gz;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public static com.bytedance.msdk.api.dl z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.g.dl dlVar, boolean z) {
        if (dlVar == null || gVar == null) {
            return null;
        }
        com.bytedance.msdk.api.dl dlVar2 = new com.bytedance.msdk.api.dl();
        dlVar2.z(dlVar.r());
        dlVar2.gz(dlVar.zx());
        dlVar2.fo(dlVar.b());
        dlVar2.uy(dlVar.yz());
        dlVar2.wp(dlVar.gb());
        if (z) {
            if (!z() && (dlVar.hn() || dlVar.k() || dlVar.wx())) {
                dlVar2.kb("-3");
            } else {
                dlVar2.kb(dlVar.n());
            }
        } else if (!g() && dlVar.hn()) {
            dlVar2.kb("-3");
        } else {
            dlVar2.kb(dlVar.ly());
        }
        dlVar2.v(dlVar.mn());
        dlVar2.g(dlVar.yt());
        dlVar2.i(dlVar.bv());
        dlVar2.z(g(gVar));
        dlVar2.g(z(dlVar));
        dlVar2.e(gVar != null ? gVar.io() : null);
        dlVar2.m(z(gVar));
        dlVar2.dl(new StringBuilder().append(gVar.gb()).toString());
        com.bytedance.msdk.api.a.m mVarIq = com.bytedance.msdk.core.z.kb().iq();
        dlVar2.a(mVarIq != null ? mVarIq.dl() : null);
        dlVar2.gc(mVarIq != null ? mVarIq.a() : null);
        Map<String, Object> mapOq = gVar != null ? gVar.oq() : null;
        if (mapOq != null && !mapOq.isEmpty()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : mapOq.entrySet()) {
                Object value = entry.getValue();
                map.put(entry.getKey(), value == null ? null : value.toString());
            }
            dlVar2.z(map);
        }
        return dlVar2;
    }

    private static String z(com.bytedance.msdk.api.z.g gVar) {
        com.bytedance.msdk.core.uy.g gVarZ;
        if (gVar == null || com.bytedance.msdk.e.z.z.z().uy() != 1 || (gVarZ = com.bytedance.msdk.e.z.dl.z().z(gVar.zw(), gVar.iq(), 102)) == null || gVarZ.z() == 1) {
            return null;
        }
        String strBv = gVar.bv();
        if (TextUtils.isEmpty(strBv)) {
            return null;
        }
        try {
            return new JSONObject(strBv).optString("experiment_detail_id");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    private static String g(com.bytedance.msdk.api.z.g gVar) {
        if (gVar == null) {
            return null;
        }
        switch (gVar.iq()) {
        }
        return null;
    }

    private static String z(com.bytedance.msdk.g.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        switch (dlVar.j()) {
            case 1:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 2:
            case 7:
                return MediationConstant.RIT_TYPE_FULL_VIDEO;
            case 3:
                return MediationConstant.RIT_TYPE_BANNER;
            case 4:
                return MediationConstant.RIT_TYPE_FEED;
            case 5:
                return MediationConstant.RIT_TYPE_DRAW;
            case 6:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            default:
                int iHy = dlVar.hy();
                if (iHy == 1) {
                    return MediationConstant.RIT_TYPE_BANNER;
                }
                if (iHy == 5) {
                    return MediationConstant.RIT_TYPE_FEED;
                }
                if (iHy != 7) {
                    return null;
                }
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
        }
    }

    private static boolean z() {
        return com.bytedance.msdk.core.g.g().zw();
    }

    private static boolean g() {
        return com.bytedance.msdk.core.g.g().uf();
    }

    public static boolean z(List<com.bytedance.msdk.g.dl> list, List<com.bytedance.msdk.g.dl> list2, List<com.bytedance.msdk.g.dl> list3, com.bytedance.msdk.api.z.g gVar, boolean z, String str, int i, List<com.bytedance.msdk.core.uy.uy> list4) {
        int iG = com.bytedance.msdk.dl.a.g.g(str);
        com.bytedance.msdk.gc.m.z(list, list2, list3, gVar, iG);
        if (z || iG != 0) {
            return false;
        }
        if (list.size() > 0) {
            for (com.bytedance.msdk.g.dl dlVar : list) {
                if (dlVar != null) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(str, dlVar.yz()) + "isReady-》广告类型：" + com.bytedance.msdk.g.z.z(dlVar.r()) + ",是否已准备好？isReady()：" + dlVar.un(str));
                    if (dlVar.un(str) && !dlVar.jq()) {
                        return true;
                    }
                }
            }
        }
        if (list3 != null && list3.size() > 0) {
            for (com.bytedance.msdk.g.dl dlVar2 : list3) {
                if (dlVar2 != null) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(str, dlVar2.yz()) + "isReady-》广告类型：" + com.bytedance.msdk.g.z.z(dlVar2.r()) + ",是否已准备好？isReady()：" + dlVar2.un(str));
                    if (dlVar2.un(str) && !dlVar2.jq()) {
                        return true;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.bytedance.msdk.g.dl dlVar3 : list2) {
                if (dlVar3 != null) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(str, dlVar3.yz()) + "isReady--->biding-->广告类型：" + com.bytedance.msdk.g.z.z(dlVar3.r()) + ",是否已准备好？isReady()：" + dlVar3.un(str));
                    if (dlVar3.un(str) && !dlVar3.jq()) {
                        return true;
                    }
                }
            }
        }
        if (list4 != null && list4.size() > 0) {
            for (com.bytedance.msdk.core.uy.uy uyVar : list4) {
                String strFv = uyVar.fv();
                if (uyVar.tb() && com.bytedance.msdk.core.gc.z.z.z().a(str, strFv, i) && com.bytedance.msdk.core.gc.z.z.z().z(strFv, gVar, false) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean z(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("show_adn_load_error_detail");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static com.bytedance.msdk.api.z z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.z zVar, List<com.bytedance.msdk.api.g> list) {
        if (zVar == null || gVar == null || list == null || list.size() == 0 || !z(gVar.oq())) {
            return zVar;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.bytedance.msdk.api.g gVar2 : list) {
            if (gVar2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MediationConstant.EXTRA_ADN_NAME, TextUtils.isEmpty(gVar2.dl()) ? gVar2.a() : gVar2.dl());
                    jSONObject.put("mediation_rit", gVar2.g());
                    jSONObject.put("ad_type", gVar2.z());
                    jSONObject.put("error_code", gVar2.gc());
                    jSONObject.put("error_msg", gVar2.m());
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        zVar.g = jSONArray.toString();
        return zVar;
    }
}
