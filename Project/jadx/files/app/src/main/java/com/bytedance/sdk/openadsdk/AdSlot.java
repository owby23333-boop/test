package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.mb;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdSlot implements TTAdSlot {
    private int b;
    private String df;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14670e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14671g;
    private String gm;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f14672h;
    private float hj;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private int[] f14673io;
    private int jb;
    private int je;
    private TTAdLoadType jq;
    private boolean ko;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14674l;
    private boolean lc;
    private String lz;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f14675m;
    private String mb;
    private int nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14676o;
    private String on;
    private int ox;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f14677r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14678u;
    private boolean ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f14679x;

    public static class Builder {
        private String df;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14680e;
        private String gm;

        /* JADX INFO: renamed from: io, reason: collision with root package name */
        private int[] f14683io;
        private String jb;
        private int je;
        private String ko;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f14684l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f14685m;
        private String mb;
        private float nk;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private float f14686o;
        private String on;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f14687r;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f14689x;
        private int ox = 640;
        private int b = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
        private boolean hj = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f14682h = false;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f14688u = 1;
        private String ww = "defaultUser";
        private int lz = 2;
        private boolean lc = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TTAdLoadType f14681g = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.mb = this.mb;
            adSlot.f14678u = this.f14688u;
            adSlot.ko = this.hj;
            adSlot.ww = this.f14682h;
            adSlot.ox = this.ox;
            adSlot.b = this.b;
            float f2 = this.nk;
            if (f2 <= 0.0f) {
                adSlot.hj = this.ox;
                adSlot.f14672h = this.b;
            } else {
                adSlot.hj = f2;
                adSlot.f14672h = this.f14686o;
            }
            adSlot.lz = this.ko;
            adSlot.f14679x = this.ww;
            adSlot.jb = this.lz;
            adSlot.nk = this.f14689x;
            adSlot.lc = this.lc;
            adSlot.f14673io = this.f14683io;
            adSlot.f14674l = this.f14680e;
            adSlot.f14675m = this.f14684l;
            adSlot.f14670e = this.jb;
            adSlot.f14671g = this.df;
            adSlot.df = this.f14687r;
            adSlot.f14677r = this.on;
            adSlot.je = this.je;
            adSlot.gm = this.f14685m;
            adSlot.on = this.gm;
            adSlot.jq = this.f14681g;
            return adSlot;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                mb.b("TT_AD_SDK", "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                mb.b("TT_AD_SDK", "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f14688u = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.df = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.f14681g = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i2) {
            this.je = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.f14680e = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.mb = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.f14687r = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.nk = f2;
            this.f14686o = f3;
            return this;
        }

        public Builder setExt(String str) {
            this.on = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f14683io = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.jb = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.ox = i2;
            this.b = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z2) {
            this.lc = z2;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.ko = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.f14689x = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.lz = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f14684l = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z2) {
            this.hj = z2;
            return this;
        }

        public Builder setUserData(String str) {
            this.gm = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.ww = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.f14682h = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.f14685m = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.f14678u;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.f14671g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.jq;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.je;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.f14674l;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.gm;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.df;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.f14676o;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.f14672h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.hj;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.f14677r;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.f14673io;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.f14670e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.ox;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.lz;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.nk;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.jb;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.f14675m;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.on;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.f14679x;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.lc;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.ko;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.ww;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        this.f14678u = i2;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.jq = tTAdLoadType;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i2) {
        this.f14676o = i2;
    }

    public void setExternalABVid(int... iArr) {
        this.f14673io = iArr;
    }

    public void setGroupLoadMore(int i2) {
        this.lz = mb(this.lz, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i2) {
        this.nk = i2;
    }

    public void setUserData(String str) {
        this.on = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.mb);
            jSONObject.put("mIsAutoPlay", this.lc);
            jSONObject.put("mImgAcceptedWidth", this.ox);
            jSONObject.put("mImgAcceptedHeight", this.b);
            jSONObject.put("mExpressViewAcceptedWidth", this.hj);
            jSONObject.put("mExpressViewAcceptedHeight", this.f14672h);
            jSONObject.put("mAdCount", this.f14678u);
            jSONObject.put("mSupportDeepLink", this.ko);
            jSONObject.put("mSupportRenderControl", this.ww);
            jSONObject.put("mMediaExtra", this.lz);
            jSONObject.put("mUserID", this.f14679x);
            jSONObject.put("mOrientation", this.jb);
            jSONObject.put("mNativeAdType", this.nk);
            jSONObject.put("mAdloadSeq", this.f14674l);
            jSONObject.put("mPrimeRit", this.f14675m);
            jSONObject.put("mExtraSmartLookParam", this.f14670e);
            jSONObject.put("mAdId", this.f14671g);
            jSONObject.put("mCreativeId", this.df);
            jSONObject.put("mExt", this.f14677r);
            jSONObject.put("mBidAdm", this.gm);
            jSONObject.put("mUserData", this.on);
            jSONObject.put("mAdLoadType", this.jq);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.mb + "', mImgAcceptedWidth=" + this.ox + ", mImgAcceptedHeight=" + this.b + ", mExpressViewAcceptedWidth=" + this.hj + ", mExpressViewAcceptedHeight=" + this.f14672h + ", mAdCount=" + this.f14678u + ", mSupportDeepLink=" + this.ko + ", mSupportRenderControl=" + this.ww + ", mMediaExtra='" + this.lz + "', mUserID='" + this.f14679x + "', mOrientation=" + this.jb + ", mNativeAdType=" + this.nk + ", mIsAutoPlay=" + this.lc + ", mPrimeRit" + this.f14675m + ", mAdloadSeq" + this.f14674l + ", mAdId" + this.f14671g + ", mCreativeId" + this.df + ", mExt" + this.f14677r + ", mUserData" + this.on + ", mAdLoadType" + this.jq + '}';
    }

    private AdSlot() {
        this.jb = 2;
        this.lc = true;
    }

    private String mb(String str, int i2) {
        JSONObject jSONObject;
        if (i2 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
