package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.api.bf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class AdSlot implements TTAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTAdLoadType f2100a;
    private int bf;
    private int bh;
    private String cv;
    private int d;
    private int dt;
    private String e;
    private int[] f;
    private float ga;
    private String k;
    private boolean l;
    private String lc;
    private String m;
    private boolean p;
    private String pe;
    private int s;
    private int t;
    private float tg;
    private boolean v;
    private int vn;
    private int w;
    private String wl;
    private String wu;
    private String xu;
    private String y;
    private String za;
    private int zk;

    public static class Builder {
        private float bh;
        private String dt;
        private String e;
        private String f;
        private String k;
        private int l;
        private String lc;
        private int m;
        private String p;
        private int pe;
        private float t;
        private int[] w;
        private String wl;
        private String wu;
        private int xu;
        private String y;
        private String za;
        private int bf = 640;
        private int d = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean tg = true;
        private boolean ga = false;
        private int vn = 1;
        private String v = "defaultUser";
        private int zk = 2;
        private boolean s = true;
        private TTAdLoadType cv = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.e = this.e;
            adSlot.vn = this.vn;
            adSlot.p = this.tg;
            adSlot.v = this.ga;
            adSlot.bf = this.bf;
            adSlot.d = this.d;
            float f = this.bh;
            if (f <= 0.0f) {
                adSlot.tg = this.bf;
                adSlot.ga = this.d;
            } else {
                adSlot.tg = f;
                adSlot.ga = this.t;
            }
            adSlot.wu = this.p;
            adSlot.xu = this.v;
            adSlot.bh = this.zk;
            adSlot.s = this.m;
            adSlot.l = this.s;
            adSlot.f = this.w;
            adSlot.dt = this.l;
            adSlot.pe = this.f;
            adSlot.k = this.wu;
            adSlot.cv = this.wl;
            adSlot.wl = this.za;
            adSlot.za = this.lc;
            adSlot.t = this.xu;
            adSlot.y = this.k;
            adSlot.lc = this.dt;
            adSlot.f2100a = this.cv;
            adSlot.zk = this.pe;
            adSlot.m = this.y;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                bf.bf(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
                i = 1;
            }
            if (i > 20) {
                bf.bf(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i = 20;
            }
            this.vn = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.wl = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.cv = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.xu = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.l = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.e = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.za = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.bh = f;
            this.t = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.lc = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.w = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.wu = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.bf = i;
            this.d = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.s = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.p = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.m = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.zk = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.pe = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.y = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.tg = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.dt = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.v = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.ga = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.k = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.vn;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.cv;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.f2100a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.dt;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.wl;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.ga;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.tg;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.za;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.wu;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.bh;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.pe;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getRewardAmount() {
        return this.zk;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.lc;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.xu;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i) {
        this.vn = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.f2100a = tTAdLoadType;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i) {
        this.w = i;
    }

    public void setExternalABVid(int... iArr) {
        this.f = iArr;
    }

    public void setGroupLoadMore(int i) {
        this.wu = e(this.wu, i);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i) {
        this.s = i;
    }

    public void setUserData(String str) {
        this.lc = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.e);
            jSONObject.put("mIsAutoPlay", this.l);
            jSONObject.put("mImgAcceptedWidth", this.bf);
            jSONObject.put("mImgAcceptedHeight", this.d);
            jSONObject.put("mExpressViewAcceptedWidth", this.tg);
            jSONObject.put("mExpressViewAcceptedHeight", this.ga);
            jSONObject.put("mAdCount", this.vn);
            jSONObject.put("mSupportDeepLink", this.p);
            jSONObject.put("mSupportRenderControl", this.v);
            jSONObject.put("mMediaExtra", this.wu);
            jSONObject.put("mUserID", this.xu);
            jSONObject.put("mOrientation", this.bh);
            jSONObject.put("mNativeAdType", this.s);
            jSONObject.put("mAdloadSeq", this.dt);
            jSONObject.put("mPrimeRit", this.pe);
            jSONObject.put("mExtraSmartLookParam", this.k);
            jSONObject.put("mAdId", this.cv);
            jSONObject.put("mCreativeId", this.wl);
            jSONObject.put("mExt", this.za);
            jSONObject.put("mBidAdm", this.y);
            jSONObject.put("mUserData", this.lc);
            jSONObject.put("mAdLoadType", this.f2100a);
            jSONObject.put("mRewardName", this.m);
            jSONObject.put("mRewardAmount", this.zk);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.e + "', mImgAcceptedWidth=" + this.bf + ", mImgAcceptedHeight=" + this.d + ", mExpressViewAcceptedWidth=" + this.tg + ", mExpressViewAcceptedHeight=" + this.ga + ", mAdCount=" + this.vn + ", mSupportDeepLink=" + this.p + ", mSupportRenderControl=" + this.v + ", mMediaExtra='" + this.wu + "', mUserID='" + this.xu + "', mOrientation=" + this.bh + ", mNativeAdType=" + this.s + ", mIsAutoPlay=" + this.l + ", mPrimeRit" + this.pe + ", mAdloadSeq" + this.dt + ", mAdId" + this.cv + ", mCreativeId" + this.wl + ", mExt" + this.za + ", mUserData" + this.lc + ", mAdLoadType" + this.f2100a + ", mRewardName" + this.m + ", mRewardAmount" + this.zk + '}';
    }

    private AdSlot() {
        this.bh = 2;
        this.l = true;
    }

    private String e(String str, int i) {
        JSONObject jSONObject;
        if (i < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }
}
