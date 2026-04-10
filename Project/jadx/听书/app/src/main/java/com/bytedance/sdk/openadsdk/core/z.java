package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.iq.b;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.wj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static Pair<com.bytedance.sdk.openadsdk.core.iq.z, ArrayList<Integer>> z(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.iq.z zVar = new com.bytedance.sdk.openadsdk.core.iq.z();
            zVar.z(jSONObject.optString("request_id"));
            zVar.z(jSONObject.optInt("ret"));
            zVar.g(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            com.bytedance.sdk.openadsdk.core.un.kb.g(jSONObject.optString("client_ipv4", ""));
            boolean zOptBoolean = jSONObject.optBoolean("need_get_materials");
            if (zVar.z() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    na naVarZ = z(jSONArrayOptJSONArray.optJSONObject(i), gVar, jVar);
                    int iZ = z(naVarZ, gVar != null ? gVar.tb() : 0);
                    boolean zGk = naVarZ.gk();
                    String strLq = naVarZ.lq();
                    if (naVarZ != null && (iZ == 200 || ((zOptBoolean || zGk) && !TextUtils.isEmpty(strLq)))) {
                        naVarZ.h(strOptString);
                        naVarZ.dl(j);
                        naVarZ.m(zOptBoolean);
                        zVar.z(naVarZ);
                    } else {
                        arrayList.add(Integer.valueOf(iZ));
                    }
                }
            }
            return new Pair<>(zVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    public static na z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return z(jSONObject, null, null);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x07f5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0556  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.openadsdk.core.iq.na z(org.json.JSONObject r17, com.bytedance.sdk.openadsdk.ls.dl.dl.g r18, com.bytedance.sdk.openadsdk.core.iq.j r19) {
        /*
            Method dump skipped, instruction units count: 2356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.z.z(org.json.JSONObject, com.bytedance.sdk.openadsdk.ls.dl.dl.g, com.bytedance.sdk.openadsdk.core.iq.j):com.bytedance.sdk.openadsdk.core.iq.na");
    }

    private static com.bytedance.sdk.openadsdk.core.ugeno.m.z z(JSONObject jSONObject, na naVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.z();
        zVar.z(jSONObject.optString("id"));
        zVar.g(jSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
        zVar.dl(jSONObject.optString("url"));
        zVar.z(jSONObject.optInt("scene"));
        return zVar;
    }

    private static void z(na naVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.iq.ls lsVarVy;
        if (naVar == null || jSONObject == null) {
            return;
        }
        if ((com.bytedance.sdk.openadsdk.core.iq.eo.z(naVar) || ec.z(naVar)) && (lsVarVy = naVar.vy()) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            com.bytedance.sdk.openadsdk.core.iq.ti tiVar = new com.bytedance.sdk.openadsdk.core.iq.ti();
            if (jSONObjectOptJSONObject != null) {
                tiVar.z(jSONObjectOptJSONObject.optString("reward_live_deep_link_user_id"));
                tiVar.gc(jSONObjectOptJSONObject.optString("reward_live_deep_link_request_id"));
                tiVar.g(jSONObjectOptJSONObject.optString("reward_live_deep_link_room_id"));
                tiVar.dl(jSONObjectOptJSONObject.optString("reawrd_live_short_touch_params"));
                tiVar.a(jSONObjectOptJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                tiVar.z(jSONObjectOptJSONObject.optLong("reward_live_last_time"));
                naVar.z(tiVar);
            } else {
                Map<String, String> mapZ = wj.z(lsVarVy.g());
                if (mapZ == null || mapZ.size() <= 0) {
                    return;
                }
                tiVar.z(mapZ.get("user_id"));
                tiVar.gc(mapZ.get("request_id"));
                tiVar.g(mapZ.get("room_id"));
                tiVar.dl(mapZ.get("live_short_touch_params"));
                tiVar.a(mapZ.get("extra_pangle_scheme_params"));
                naVar.z(tiVar);
            }
            naVar.uy(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.iq.gc g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.gc gcVar = new com.bytedance.sdk.openadsdk.core.iq.gc();
        gcVar.dl(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        gcVar.a(jSONObject.optString(an.o));
        gcVar.g(jSONObject.optString("download_url"));
        gcVar.z(jSONObject.optInt("score", 4));
        gcVar.g(jSONObject.optInt("comment_num", 0));
        gcVar.dl(jSONObject.optInt("app_size", 0));
        gcVar.z(jSONObject.optString("quick_app_url", ""));
        return gcVar;
    }

    private static com.bytedance.sdk.openadsdk.core.iq.q m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.q qVar = new com.bytedance.sdk.openadsdk.core.iq.q();
        qVar.z(jSONObject.optInt("ah", 1));
        qVar.g(jSONObject.optInt("am", 1));
        return qVar;
    }

    private static b z(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        double dOptDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        bVar.z((int) ((dOptDouble == 1.0d || dOptDouble == 2.0d) ? dOptDouble : 1.0d));
        bVar.e(jSONObject.optInt("splash_style_id", 0));
        bVar.z(jSONObject.optString("splash_clicktext", ""));
        bVar.g(jSONObject.optInt("area_height", 50));
        bVar.dl(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            bVar.a(jSONObject.optInt("area_blank_height", 32));
        } else {
            bVar.a(jSONObject.optInt("area_blank_height", 82));
        }
        bVar.gc(jSONObject.optInt("half_blank_height", 56));
        bVar.g(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        bVar.dl(jSONObject.optString("top_splash_clicktext"));
        bVar.z(jSONObject.optJSONObject("text_config"));
        bVar.g(jSONObject.optJSONObject("top_text_config"));
        bVar.gz(jSONObject.optInt("sliding_distance", 5));
        bVar.z(jSONObject.optJSONObject("slide_area"), i);
        bVar.m(jSONObject.optInt("splash_load_time_optimization"));
        return bVar;
    }

    public static com.bytedance.sdk.openadsdk.core.iq.io dl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.io ioVar = new com.bytedance.sdk.openadsdk.core.iq.io();
        ioVar.dl(jSONObject.optString("ugen_dialog_md5"));
        ioVar.g(jSONObject.optString("ugen_dialog_url"));
        ioVar.z(jSONObject.optString("dialog_style"));
        return ioVar;
    }

    public static com.bytedance.sdk.openadsdk.core.iq.uf a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.uf ufVar = new com.bytedance.sdk.openadsdk.core.iq.uf();
        ufVar.a(jSONObject.optString("bg_url"));
        ufVar.dl(jSONObject.optString("title"));
        ufVar.z(jSONObject.optString("reward_image_url"));
        ufVar.g(jSONObject.optString("reward_title"));
        ufVar.gc(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return ufVar;
    }

    public static com.bytedance.sdk.openadsdk.core.iq.m gc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.m mVar = new com.bytedance.sdk.openadsdk.core.iq.m();
        mVar.a(jSONObject.optString("developer_name"));
        mVar.g(jSONObject.optString("app_version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permissions");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            mVar.g(jSONArrayOptJSONArray);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    mVar.z(jSONObjectOptJSONObject.optString("permission_name"), jSONObjectOptJSONObject.optString("permission_desc"));
                }
            }
        }
        mVar.z(jSONObject.optString("permissions_url"));
        mVar.z(jSONObject.optInt("score", 0));
        mVar.z(jSONObject.optJSONArray("creative_tags"));
        mVar.gc(jSONObject.optString("privacy_policy_url"));
        mVar.m(jSONObject.optString("desc_url"));
        mVar.e(jSONObject.optString("reg_number"));
        mVar.gz(jSONObject.optString("reg_url"));
        mVar.uy(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        mVar.fo(jSONObject.optString(an.o));
        return mVar;
    }

    private static Map<String, Object> e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int z(com.bytedance.sdk.openadsdk.core.iq.na r7, int r8) {
        /*
            java.lang.String r0 = r7.mj()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L93
            java.lang.String r0 = r7.mj()
            int r0 = r0.length()
            r1 = 1
            if (r0 > r1) goto L17
            goto L93
        L17:
            com.bytedance.sdk.openadsdk.core.iq.ls r0 = r7.vy()
            int r0 = z(r0)
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L24
            return r0
        L24:
            int r0 = z(r7)
            if (r0 == r1) goto L2b
            return r0
        L2b:
            int r2 = r7.lt()
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L54
            if (r2 == r5) goto L54
            if (r2 == r4) goto L49
            if (r2 == r3) goto L3c
            goto L61
        L3c:
            java.lang.String r2 = r7.oz()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L61
            r7 = 408(0x198, float:5.72E-43)
            return r7
        L49:
            com.bytedance.sdk.openadsdk.core.iq.gc r0 = r7.c()
            int r0 = z(r0)
            if (r0 == r1) goto L61
            return r0
        L54:
            java.lang.String r2 = r7.fp()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L61
            r7 = 405(0x195, float:5.68E-43)
            return r7
        L61:
            int r2 = r7.ou()
            if (r2 == r6) goto L88
            if (r2 == r5) goto L88
            if (r2 == r4) goto L88
            if (r2 == r3) goto L81
            r3 = 15
            if (r2 == r3) goto L81
            r3 = 16
            if (r2 == r3) goto L88
            r3 = 166(0xa6, float:2.33E-43)
            if (r2 == r3) goto L7a
            goto L92
        L7a:
            int r0 = g(r7, r8)
            if (r0 == r1) goto L92
            return r0
        L81:
            int r0 = com.bytedance.sdk.openadsdk.core.iq.tf.fo(r7)
            if (r0 == r1) goto L92
            return r0
        L88:
            java.util.List r7 = r7.jz()
            int r0 = g(r7)
            if (r0 == r1) goto L92
        L92:
            return r0
        L93:
            r7 = 401(0x191, float:5.62E-43)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.z.z(com.bytedance.sdk.openadsdk.core.iq.na, int):int");
    }

    private static int g(na naVar, int i) {
        if (i != 3 && i != 4 && i != 0) {
            if (!com.bytedance.sdk.openadsdk.core.iq.eo.z(naVar)) {
                return 416;
            }
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.iq.eo.e(naVar))) {
                return TTAdConstant.LIVE_FEED_URL_CODE;
            }
        }
        return 200;
    }

    private static int z(na naVar) {
        if (!(naVar.ou() == 166 && com.bytedance.sdk.openadsdk.core.iq.eo.z(naVar)) || gk.a()) {
            return 200;
        }
        com.bytedance.sdk.component.utils.wp.dl("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int z(com.bytedance.sdk.openadsdk.core.iq.ls lsVar) {
        if (lsVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(lsVar.g()) && !TextUtils.isEmpty(lsVar.a())) {
            return (lsVar.gc() == 1 || lsVar.gc() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(lsVar.g())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int z(com.bytedance.sdk.openadsdk.core.iq.gc gcVar) {
        if (gcVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(gcVar.g()) ? 407 : 200;
    }

    private static int g(List<com.bytedance.sdk.openadsdk.core.iq.gk> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.iq.gk gkVar : list) {
            if (gkVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(gkVar.z())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    public static void z(List<na> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<na> listSubList = list.subList(1, list.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<na> it = listSubList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().kv());
        }
        if (jSONArray.length() > 0) {
            list.get(0).eo(jSONArray.toString());
        }
    }
}
