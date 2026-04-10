package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1455a;
    private String dl;
    private boolean e;
    private boolean fo;
    private boolean g;
    private float gc;
    private Map<String, Object> gz;
    private float i;
    private boolean kb;
    private MediationSplashRequestInfo ls;
    private boolean m;
    private String pf;
    private String uy;
    private float v;
    private MediationNativeToBannerListener wp;
    private boolean z;

    private MediationAdSlot() {
        this.dl = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.wp;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.pf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.ls;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.f1455a;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f1456a;
        private boolean dl;
        private boolean e;
        private boolean g;
        private boolean gc;
        private String gz;
        private boolean kb;
        private MediationSplashRequestInfo ls;
        private String pf;
        private int uy;
        private MediationNativeToBannerListener wp;
        private boolean z;
        private Map<String, Object> m = new HashMap();
        private String fo = "";
        private float i = 80.0f;
        private float v = 80.0f;

        public Builder setSplashShakeButton(boolean z) {
            this.z = z;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.dl = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.f1456a = f;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.gc = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.m;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.gz = str;
            return this;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.kb = z;
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.wp = mediationNativeToBannerListener;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.i = f;
            this.v = f2;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.pf = str;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.ls = mediationSplashRequestInfo;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.fo = str;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.uy = i;
            return this;
        }

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.z = this.z;
            mediationAdSlot.g = this.g;
            mediationAdSlot.e = this.dl;
            mediationAdSlot.gc = this.f1456a;
            mediationAdSlot.m = this.gc;
            mediationAdSlot.gz = this.m;
            mediationAdSlot.fo = this.e;
            mediationAdSlot.uy = this.gz;
            mediationAdSlot.dl = this.fo;
            mediationAdSlot.f1455a = this.uy;
            mediationAdSlot.kb = this.kb;
            mediationAdSlot.wp = this.wp;
            mediationAdSlot.i = this.i;
            mediationAdSlot.v = this.v;
            mediationAdSlot.pf = this.pf;
            mediationAdSlot.ls = this.ls;
            return mediationAdSlot;
        }
    }
}
