package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationConfig implements IMediationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f1467a;
    private MediationConfigUserInfoForSegment dl;
    private boolean e;
    private boolean fo;
    private boolean g;
    private boolean gc;
    private String gz;
    private String kb;
    private JSONObject m;
    private boolean uy;
    private String z;

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.f1467a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.kb;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Object> f1468a;
        private MediationConfigUserInfoForSegment dl;
        private boolean e;
        private boolean fo;
        private boolean g;
        private boolean gc;
        private String gz;
        private String kb;
        private JSONObject m;
        private boolean uy;
        private String z;

        public Builder setPublisherDid(String str) {
            this.z = str;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.dl = mediationConfigUserInfoForSegment;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.f1468a = map;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.gc = z;
            return this;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.m = jSONObject;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.gz = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.fo = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.uy = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.kb = str;
            return this;
        }

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.z = this.z;
            mediationConfig.g = this.g;
            mediationConfig.dl = this.dl;
            mediationConfig.f1467a = this.f1468a;
            mediationConfig.gc = this.gc;
            mediationConfig.m = this.m;
            mediationConfig.e = this.e;
            mediationConfig.gz = this.gz;
            mediationConfig.fo = this.fo;
            mediationConfig.uy = this.uy;
            mediationConfig.kb = this.kb;
            return mediationConfig;
        }
    }
}
