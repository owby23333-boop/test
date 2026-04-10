package com.bytedance.sdk.openadsdk.core.un;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static com.bytedance.sdk.openadsdk.ls.dl.dl.g z(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            g.z zVar = new g.z();
            zVar.z(jSONObject.optString("mAdId", ""));
            zVar.g(jSONObject.optString("mCreativeId", ""));
            zVar.dl(jSONObject.optString("mExt", ""));
            zVar.a(jSONObject.optString("mCodeId", ""));
            zVar.fo(jSONObject.optString("mUserData"));
            zVar.z(jSONObject.optBoolean("mIsAutoPlay", true));
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
            zVar.g(jSONObject.optInt("mImgAcceptedHeight", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            zVar.z(iOptInt);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            zVar.g(Double.valueOf(dOptDouble).floatValue());
            zVar.z(Double.valueOf(dOptDouble2).floatValue());
            zVar.g(jSONObject.optBoolean("mSupportDeepLink", true));
            zVar.dl(jSONObject.optInt("mAdCount", 1));
            zVar.gc(jSONObject.optString("mMediaExtra", ""));
            zVar.m(jSONObject.optString("mUserID", ""));
            zVar.a(jSONObject.optInt("mOrientation", 2));
            zVar.gc(jSONObject.optInt("mNativeAdType"));
            zVar.z(eo.kb(jSONObject.optString("mExternalABVid", "")));
            zVar.m(jSONObject.optInt("mAdLoadSeq", 0));
            zVar.e(jSONObject.optString("mPrimeRit", ""));
            zVar.gz(jSONObject.optString("mBidAdm"));
            zVar.gz(jSONObject.optInt("mRewardAmount", 0));
            zVar.uy(jSONObject.optString("mRewardName", ""));
            return zVar.z();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", gVar.z());
            jSONObject.put("mCreativeId", gVar.g());
            jSONObject.put("mExt", gVar.dl());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", gVar.iq());
            jSONObject.put("mIsAutoPlay", gVar.gc());
            jSONObject.put("mImgAcceptedWidth", gVar.m());
            jSONObject.put("mImgAcceptedHeight", gVar.e());
            jSONObject.put("mExpressViewAcceptedWidth", gVar.gz());
            jSONObject.put("mExpressViewAcceptedHeight", gVar.fo());
            jSONObject.put("mSupportDeepLink", gVar.uy());
            jSONObject.put("mSupportRenderControl", gVar.kb());
            if (com.bytedance.sdk.openadsdk.core.gk.dl >= 5900) {
                jSONObject.put("mSupportIconStyle", gVar.sy());
            }
            jSONObject.put("mAdCount", gVar.wp());
            jSONObject.put("mMediaExtra", gVar.i());
            jSONObject.put("mUserID", gVar.v());
            jSONObject.put("mOrientation", gVar.pf());
            jSONObject.put("mNativeAdType", gVar.ls());
            jSONObject.put("mExternalABVid", eo.z(gVar.p()));
            jSONObject.put("mAdLoadSeq", gVar.fv());
            jSONObject.put("mPrimeRit", gVar.js());
            jSONObject.put("mBidAdm", gVar.q());
            jSONObject.put("mRewardAmount", gVar.uf());
            jSONObject.put("mRewardName", gVar.io());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        return z(gVar, gVar.a());
    }

    public static com.bytedance.sdk.openadsdk.ls.dl.dl.g z(int i, String str, float f, float f2) {
        return z().a(str).e(i).g(f2).z(f).z();
    }

    public static com.bytedance.sdk.openadsdk.ls.dl.dl.g z(int i) {
        return z().e(i).z();
    }

    public static com.bytedance.sdk.openadsdk.ls.dl.dl.g z(int i, PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar = new com.bytedance.sdk.openadsdk.ls.dl.dl.g(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
        g.z zVar = new g.z(gVar);
        float fGz = gVar.gz();
        float fFo = gVar.fo();
        if (fGz <= 0.0f) {
            fGz = oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), gVar.m());
            fFo = oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), gVar.e());
        }
        if (fGz > 0.0f || fFo > 0.0f) {
            int iA = (int) (((double) oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), oq.gc(com.bytedance.sdk.openadsdk.core.zw.getContext()))) * 1.3d);
            int iA2 = (int) (((double) oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext()))) * 1.3d);
            int iMax = Math.max(iA, iA2);
            int iMin = Math.min(iA, iA2);
            if (fGz > fFo) {
                if (iA2 > 0) {
                    float f = iMax;
                    if (fGz > f) {
                        fFo = iMin;
                        fGz = f;
                    }
                }
            } else if (iA > 0) {
                float f2 = iMax;
                if (fFo > f2) {
                    fGz = iMin;
                    fFo = f2;
                }
            }
        }
        zVar.z(fGz).g(fFo);
        return new com.bytedance.sdk.openadsdk.core.iq.dl(g(zVar.z()).e(i).z());
    }

    public static final g.z g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        return new g.z(gVar);
    }

    private static final g.z z() {
        return new g.z().dl(1).g(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).z(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).g(true).m("defaultUser").a(2).z(true);
    }

    public static boolean z(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) com.bytedance.sdk.openadsdk.core.zw.g().z(str, Boolean.valueOf(z))).booleanValue();
    }

    public static long z(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) com.bytedance.sdk.openadsdk.core.zw.g().z(str, Long.valueOf(j))).longValue();
    }

    public static int z(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) com.bytedance.sdk.openadsdk.core.zw.g().z(str, Integer.valueOf(i))).intValue();
    }
}
