package com.bytedance.sdk.openadsdk.core.kb.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static final String TAG = "pl_LibEventLogger";

    public static JSONObject getLibAdExtraData(JSONObject jSONObject) {
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
            wp.z(e);
            return null;
        }
    }

    public static boolean isOpenSdkEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(uy.EXTRA_DOWN_INFO_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static class z extends com.bytedance.sdk.component.uy.fo {
        private Function<SparseArray<Object>, Object> mBridge;
        private boolean mCheckTag;
        private com.bytedance.sdk.openadsdk.core.kb.dl.g.z mEventExtra;
        private TTDownloadEventModel mEventModel;
        private na mMeta;

        public static z build(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            return new z(tTDownloadEventModel, z);
        }

        private boolean equalExt(JSONObject jSONObject, JSONObject jSONObject2) {
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

        private z(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            JSONObject extJson;
            JSONObject materialMeta;
            na naVar;
            super("LogTask");
            this.mEventModel = tTDownloadEventModel;
            this.mCheckTag = z;
            this.mBridge = com.bytedance.sdk.openadsdk.core.uy.ls().oq();
            TTDownloadEventModel tTDownloadEventModel2 = this.mEventModel;
            if (tTDownloadEventModel2 == null || tTDownloadEventModel2.getExtJson() == null || (extJson = this.mEventModel.getExtJson()) == null) {
                return;
            }
            String strOptString = extJson.optString("ad_extra_data");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject(uy.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVarZ = com.bytedance.sdk.openadsdk.core.kb.dl.g.z.z(jSONObjectOptJSONObject);
                this.mEventExtra = zVarZ;
                if (zVarZ == null) {
                    return;
                }
                zVarZ.z(tTDownloadEventModel.getTag());
                this.mEventExtra.g(this.mEventModel.getLabel());
                this.mMeta = this.mEventExtra.z;
                if (gk.dl < 4400 || (materialMeta = tTDownloadEventModel.getMaterialMeta()) == null || (naVar = this.mMeta) == null || equalExt(materialMeta, naVar.en())) {
                    return;
                }
                this.mMeta.iq(materialMeta.toString());
                this.mMeta.q(String.valueOf(materialMeta.optLong("creative_id")));
                JSONObject jSONObjectKv = this.mMeta.kv();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectKv);
                com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVarZ2 = com.bytedance.sdk.openadsdk.core.kb.dl.g.z.z(jSONObjectOptJSONObject);
                if (zVarZ2 == null) {
                    return;
                }
                this.mEventExtra = zVarZ2;
                zVarZ2.g(tTDownloadEventModel.getLabel());
                this.mEventModel = TTDownloadEventModel.builder().setTag(tTDownloadEventModel.getTag()).setLabel(tTDownloadEventModel.getLabel()).setMaterialMeta(jSONObjectKv).setExtJson(extJson);
                this.mMeta = this.mEventExtra.z;
            } catch (Exception unused) {
            }
        }

        private Context getContext() {
            return zw.getContext();
        }

        private boolean checkTag(String str) {
            return this.mCheckTag || m.checkTag(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTDownloadEventModel tTDownloadEventModel = this.mEventModel;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                wp.z(m.TAG, "label: " + this.mEventModel.getLabel() + " tag: " + tag);
                com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVar = this.mEventExtra;
                if (zVar != null && !TextUtils.isEmpty(zVar.g)) {
                    tag = this.mEventExtra.g;
                }
                if (this.mBridge != null) {
                    Object objApply = this.mBridge.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(Boolean.class).z(0, new lq().z("tagIntercept", tag).z("label", this.mEventModel.getLabel()).z("meta", this.mMeta.kv().toString())).g());
                    if (objApply != null && ((Boolean) objApply).booleanValue()) {
                        return;
                    }
                }
                if (this.mEventExtra != null && this.mMeta != null && !TextUtils.isEmpty(this.mEventModel.getTag()) && !TextUtils.isEmpty(this.mEventModel.getLabel())) {
                    JSONObject libAdExtraData = m.getLibAdExtraData(this.mEventModel.getExtJson());
                    String str = this.mEventExtra.g;
                    if (!checkTag(this.mEventModel.getTag()) || "click".equals(this.mEventModel.getLabel())) {
                        return;
                    }
                    libAdExtraData.remove(uy.EXTRA_DOWN_INFO_KEY);
                    libAdExtraData.putOpt("obm_convert", tb.dl(this.mMeta));
                    com.bytedance.sdk.openadsdk.core.i.a.g(this.mMeta, str, this.mEventModel.getLabel(), libAdExtraData);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
