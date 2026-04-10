package com.bytedance.sdk.openadsdk.core.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdSlot;
import com.bytedance.sdk.openadsdk.core.hb;
import com.yuewen.w51;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2103a = "mRewardAmount";
    public static String bf = "mCreativeId";
    public static String bh = "mAdCount";
    public static String cv = "mDownloadType";
    public static String d = "mExt";
    public static String dt = "mAdLoadSeq";
    public static String e = "mAdId";
    public static String f = "mDurationSlotType";
    public static String ga = "mUserData";
    public static String k = "mExternalABVid";
    public static String l = "mNativeAdType";
    public static String lc = "mRewardName";
    public static String m = "mExpressViewAcceptedHeight";
    public static String p = "mImgAcceptedWidth";
    public static String pe = "mPrimeRit";
    public static String s = "mUserID";
    public static String t = "mMediaExtra";
    public static String tg = "mCodeId";
    public static String v = "mImgAcceptedHeight";
    public static String vn = "mIsAutoPlay";
    public static String w = "mOrientation";
    public static String wl = "mSplashButtonType";
    public static String wu = "mSupportDeepLink";
    public static String xu = "mSupportRenderControl";
    public static String y = "mBidAdm";
    public static String za = "mExtraSmartLookParam";
    public static String zk = "mExpressViewAcceptedWidth";

    public static TTAdSlot e(String str) {
        TTAdSlot tTAdSlotBf = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.core.ga gaVar = new com.bytedance.sdk.openadsdk.core.ga();
            gaVar.bf(jSONObject.optString(e, ""));
            gaVar.d(jSONObject.optString(bf, ""));
            gaVar.tg(jSONObject.optString(d, ""));
            gaVar.ga(jSONObject.optString(tg, ""));
            gaVar.zk(jSONObject.optString(ga));
            gaVar.e(jSONObject.optBoolean(vn, true));
            gaVar.e(jSONObject.optInt(p, 640), jSONObject.optInt(v, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            gaVar.e(Double.valueOf(jSONObject.optDouble(zk, w51.l)).floatValue(), Double.valueOf(jSONObject.optDouble(m, w51.l)).floatValue());
            gaVar.bf(jSONObject.optBoolean(wu, true));
            gaVar.bf(jSONObject.optInt(bh, 1));
            gaVar.vn(jSONObject.optString(t, ""));
            gaVar.p(jSONObject.optString(s, ""));
            gaVar.d(jSONObject.optInt(w, 2));
            gaVar.tg(jSONObject.optInt(l));
            gaVar.e(a.wu(jSONObject.optString(k, "")));
            gaVar.ga(jSONObject.optInt(dt, 0));
            gaVar.v(jSONObject.optString(pe, ""));
            gaVar.m(jSONObject.optString(y));
            gaVar.e(jSONObject.optString(za, null));
            gaVar.vn(jSONObject.optInt(f2103a, 0));
            gaVar.wu(jSONObject.optString(lc, ""));
            tTAdSlotBf = gaVar.bf();
            tTAdSlotBf.setDurationSlotType(jSONObject.optInt(f, 0));
            return tTAdSlotBf;
        } catch (Exception unused) {
            return tTAdSlotBf;
        }
    }

    public static JSONObject e(TTAdSlot tTAdSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e, tTAdSlot.getAdId());
            jSONObject.put(bf, tTAdSlot.getCreativeId());
            jSONObject.put(d, tTAdSlot.getExt());
            jSONObject.put(tg, tTAdSlot.getCodeId());
            jSONObject.put(ga, tTAdSlot.getUserData());
            jSONObject.put(vn, tTAdSlot.isAutoPlay());
            jSONObject.put(p, tTAdSlot.getImgAcceptedWidth());
            jSONObject.put(v, tTAdSlot.getImgAcceptedHeight());
            jSONObject.put(zk, tTAdSlot.getExpressViewAcceptedWidth());
            jSONObject.put(m, tTAdSlot.getExpressViewAcceptedHeight());
            jSONObject.put(wu, tTAdSlot.isSupportDeepLink());
            jSONObject.put(xu, tTAdSlot.isSupportRenderConrol());
            jSONObject.put(bh, tTAdSlot.getAdCount());
            jSONObject.put(t, tTAdSlot.getMediaExtra());
            jSONObject.put(s, tTAdSlot.getUserID());
            jSONObject.put(w, tTAdSlot.getOrientation());
            jSONObject.put(l, tTAdSlot.getNativeAdType());
            jSONObject.put(f, tTAdSlot.getDurationSlotType());
            jSONObject.put(k, a.e(tTAdSlot.getExternalABVid()));
            jSONObject.put(dt, tTAdSlot.getAdloadSeq());
            jSONObject.put(pe, tTAdSlot.getPrimeRit());
            jSONObject.put(y, tTAdSlot.getBidAdm());
            jSONObject.put(za, tTAdSlot.getExtraSmartLookParam());
            if (hb.e >= 5204) {
                jSONObject.put(f2103a, tTAdSlot.getRewardAmount());
                jSONObject.put(lc, tTAdSlot.getRewardName());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
