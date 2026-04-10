package com.bytedance.sdk.openadsdk.core.kb.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static JSONObject z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("ad_extra_data");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            return new JSONObject(strOptString);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static class z extends com.bytedance.sdk.component.uy.fo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1211a;
        private na dl;
        private com.bytedance.sdk.openadsdk.core.kb.dl.g.z g;
        private Function<SparseArray<Object>, Object> gc;
        private gz z;

        public static z z(gz gzVar, boolean z) {
            return new z(gzVar, z);
        }

        private boolean z(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long jOptLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
                long jOptLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
                String strOptString = jSONObject.optString("req_id");
                String strOptString2 = jSONObject2.optString("req_id");
                long jOptLong3 = jSONObject.optLong("creative_id");
                long jOptLong4 = jSONObject2.optLong("creative_id");
                String strOptString3 = jSONObject.optString("origin_req_id");
                String strOptString4 = jSONObject2.optString("origin_req_id");
                if (jOptLong != 0 && jOptLong == jOptLong2 && jOptLong3 != 0 && jOptLong3 == jOptLong4) {
                    if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                        return TextUtils.equals(strOptString3, strOptString4);
                    }
                    return TextUtils.equals(strOptString, strOptString2);
                }
            }
            return false;
        }

        private z(gz gzVar, boolean z) {
            JSONObject jSONObjectA;
            JSONObject jSONObjectGc;
            na naVar;
            super("LogTask");
            this.z = gzVar;
            this.f1211a = z;
            this.gc = com.bytedance.sdk.openadsdk.core.uy.ls().oq();
            gz gzVar2 = this.z;
            if (gzVar2 == null || gzVar2.a() == null || (jSONObjectA = this.z.a()) == null) {
                return;
            }
            String strOptString = jSONObjectA.optString("ad_extra_data");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVarZ = com.bytedance.sdk.openadsdk.core.kb.dl.g.z.z(jSONObjectOptJSONObject);
                this.g = zVarZ;
                if (zVarZ == null) {
                    return;
                }
                zVarZ.z(gzVar.g());
                this.g.g(this.z.dl());
                this.dl = this.g.z;
                if (gk.dl < 4400 || (jSONObjectGc = gzVar.gc()) == null || (naVar = this.dl) == null || z(jSONObjectGc, naVar.en())) {
                    return;
                }
                this.dl.iq(jSONObjectGc.toString());
                this.dl.q(String.valueOf(jSONObjectGc.optLong("creative_id")));
                JSONObject jSONObjectKv = this.dl.kv();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectKv);
                com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVarZ2 = com.bytedance.sdk.openadsdk.core.kb.dl.g.z.z(jSONObjectOptJSONObject);
                if (zVarZ2 == null) {
                    return;
                }
                this.g = zVarZ2;
                zVarZ2.g(gzVar.dl());
                this.z = gz.z().z(gzVar.g()).g(gzVar.dl()).z(jSONObjectKv).g(jSONObjectA);
                this.dl = this.g.z;
            } catch (Exception unused) {
            }
        }

        private Context getContext() {
            return zw.getContext();
        }

        private boolean z(String str) {
            return this.f1211a || fo.dl(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                gz gzVar = this.z;
                if (gzVar == null) {
                    return;
                }
                String strG = gzVar.g();
                com.bytedance.sdk.component.utils.wp.z("pl_LibEventLogger", "label: " + this.z.dl() + " tag: " + strG);
                com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVar = this.g;
                if (zVar != null && !TextUtils.isEmpty(zVar.g)) {
                    strG = this.g.g;
                }
                if (this.gc != null) {
                    Object objApply = this.gc.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(Boolean.class).z(0, new lq().z("tagIntercept", strG).z("label", this.z.dl()).z("meta", this.dl.kv().toString())).g());
                    if (objApply != null && ((Boolean) objApply).booleanValue()) {
                        return;
                    }
                }
                if (this.g != null && this.dl != null && !TextUtils.isEmpty(this.z.g()) && !TextUtils.isEmpty(this.z.dl())) {
                    JSONObject jSONObjectZ = fo.z(this.z.a());
                    String str = this.g.g;
                    if (!z(this.z.g()) || "click".equals(this.z.dl())) {
                        return;
                    }
                    jSONObjectZ.remove(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY);
                    jSONObjectZ.putOpt("obm_convert", tb.dl(this.dl));
                    com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, str, this.z.dl(), jSONObjectZ);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
