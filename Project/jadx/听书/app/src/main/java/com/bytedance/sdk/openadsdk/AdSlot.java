package com.bytedance.sdk.openadsdk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdSlot implements SlotType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f890a;
    private int dl;
    private boolean e;
    private boolean fo;
    private String fv;
    private int g;
    private float gc;
    private boolean gz;
    private String hh;
    private int i;
    private TTAdLoadType io;
    private String iq;
    private String js;
    private String kb;
    private int[] ls;
    private int m;
    private int p;
    private boolean pf;
    private String q;
    private int sy;
    private String tb;
    private IMediationAdSlot uf;
    private String uy;
    private int v;
    private int wp;
    private String z;
    private String zw;

    private AdSlot() {
        this.wp = 2;
        this.pf = true;
    }

    public String getAdId() {
        return this.tb;
    }

    public String getCreativeId() {
        return this.q;
    }

    public String getExt() {
        return this.iq;
    }

    public String getCodeId() {
        return this.z;
    }

    public boolean isAutoPlay() {
        return this.pf;
    }

    public int getImgAcceptedWidth() {
        return this.g;
    }

    public int getImgAcceptedHeight() {
        return this.dl;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f890a;
    }

    public float getExpressViewAcceptedHeight() {
        return this.gc;
    }

    public boolean isSupportDeepLink() {
        return this.e;
    }

    public boolean isSupportRenderConrol() {
        return this.gz;
    }

    public int getAdCount() {
        return this.m;
    }

    public void setAdCount(int i) {
        this.m = i;
    }

    public String getMediaExtra() {
        return this.uy;
    }

    public String getUserID() {
        return this.kb;
    }

    public int getOrientation() {
        return this.wp;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.v;
    }

    public void setNativeAdType(int i) {
        this.v = i;
    }

    public int[] getExternalABVid() {
        return this.ls;
    }

    public void setExternalABVid(int... iArr) {
        this.ls = iArr;
    }

    public int getAdloadSeq() {
        return this.p;
    }

    public String getPrimeRit() {
        String str = this.fv;
        return str == null ? "" : str;
    }

    public int getAdType() {
        return this.i;
    }

    public String getBidAdm() {
        return this.js;
    }

    public void setUserData(String str) {
        this.zw = str;
    }

    public String getUserData() {
        return this.zw;
    }

    public TTAdLoadType getAdLoadType() {
        return this.io;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.io = tTAdLoadType;
    }

    public String getRewardName() {
        return this.hh;
    }

    public int getRewardAmount() {
        return this.sy;
    }

    public boolean isSupportIconStyle() {
        return this.fo;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.uf;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.z + "', mImgAcceptedWidth=" + this.g + ", mImgAcceptedHeight=" + this.dl + ", mExpressViewAcceptedWidth=" + this.f890a + ", mExpressViewAcceptedHeight=" + this.gc + ", mAdCount=" + this.m + ", mSupportDeepLink=" + this.e + ", mSupportRenderControl=" + this.gz + ", mSupportIconStyle=" + this.fo + ", mMediaExtra='" + this.uy + "', mUserID='" + this.kb + "', mOrientation=" + this.wp + ", mNativeAdType=" + this.v + ", mIsAutoPlay=" + this.pf + ", mPrimeRit" + this.fv + ", mAdloadSeq" + this.p + ", mAdId" + this.tb + ", mCreativeId" + this.q + ", mExt" + this.iq + ", mUserData" + this.zw + ", mAdLoadType" + this.io + '}';
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.z);
            jSONObject.put("mIsAutoPlay", this.pf);
            jSONObject.put("mImgAcceptedWidth", this.g);
            jSONObject.put("mImgAcceptedHeight", this.dl);
            jSONObject.put("mExpressViewAcceptedWidth", this.f890a);
            jSONObject.put("mExpressViewAcceptedHeight", this.gc);
            jSONObject.put("mAdCount", this.m);
            jSONObject.put("mSupportDeepLink", this.e);
            jSONObject.put("mSupportRenderControl", this.gz);
            jSONObject.put("mSupportIconStyle", this.fo);
            jSONObject.put("mMediaExtra", this.uy);
            jSONObject.put("mUserID", this.kb);
            jSONObject.put("mOrientation", this.wp);
            jSONObject.put("mNativeAdType", this.v);
            jSONObject.put("mAdloadSeq", this.p);
            jSONObject.put("mPrimeRit", this.fv);
            jSONObject.put("mAdId", this.tb);
            jSONObject.put("mCreativeId", this.q);
            jSONObject.put("mExt", this.iq);
            jSONObject.put("mBidAdm", this.js);
            jSONObject.put("mUserData", this.zw);
            jSONObject.put("mAdLoadType", this.io);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static class Builder {
        private String fv;
        private String gz;
        private String hh;
        private float i;
        private String io;
        private String iq;
        private String js;
        private int kb;
        private int[] ls;
        private int p;
        private int sy;
        private String tb;
        private IMediationAdSlot uf;
        private float v;
        private int wp;
        private String z;
        private String zw;
        private int g = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int dl = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f891a = true;
        private boolean gc = false;
        private boolean m = false;
        private int e = 1;
        private String fo = "defaultUser";
        private int uy = 2;
        private boolean pf = true;
        private TTAdLoadType q = TTAdLoadType.UNKNOWN;

        public Builder setAdType(int i) {
            this.wp = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.iq = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.zw = str;
            return this;
        }

        public Builder setExt(String str) {
            this.io = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.pf = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.z = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.g = i;
            this.dl = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.i = f;
            this.v = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f891a = z;
            return this;
        }

        public Builder supportRenderControl() {
            this.gc = true;
            return this;
        }

        public Builder supportIconStyle() {
            this.m = true;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.e = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.gz = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.fo = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.uy = i;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.kb = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.p = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.fv = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.ls = iArr;
            return this;
        }

        public Builder setUserData(String str) {
            this.tb = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.q = tTAdLoadType;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.js = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.uf = iMediationAdSlot;
            return this;
        }

        public Builder setRewardName(String str) {
            this.hh = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.sy = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.z = this.z;
            adSlot.m = this.e;
            adSlot.e = this.f891a;
            adSlot.gz = this.gc;
            adSlot.fo = this.m;
            adSlot.g = this.g;
            adSlot.dl = this.dl;
            adSlot.f890a = this.i;
            adSlot.gc = this.v;
            adSlot.uy = this.gz;
            adSlot.kb = this.fo;
            adSlot.wp = this.uy;
            adSlot.v = this.kb;
            adSlot.pf = this.pf;
            adSlot.ls = this.ls;
            adSlot.p = this.p;
            adSlot.fv = this.fv;
            adSlot.tb = this.iq;
            adSlot.q = this.zw;
            adSlot.iq = this.io;
            adSlot.i = this.wp;
            adSlot.js = this.js;
            adSlot.zw = this.tb;
            adSlot.io = this.q;
            adSlot.hh = this.hh;
            adSlot.sy = this.sy;
            adSlot.uf = this.uf;
            return adSlot;
        }
    }
}
