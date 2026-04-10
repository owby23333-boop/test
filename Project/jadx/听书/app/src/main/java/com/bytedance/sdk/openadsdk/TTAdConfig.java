package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class TTAdConfig extends CSJConfig {
    private TTAdConfig(CSJConfig.z zVar) {
        super(zVar);
    }

    public static class Builder {
        private CSJConfig.z z = new CSJConfig.z();

        public Builder appId(String str) {
            this.z.z(str);
            return this;
        }

        public Builder appName(String str) {
            this.z.g(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.z.z(z);
            return this;
        }

        public Builder keywords(String str) {
            this.z.dl(str);
            return this;
        }

        public Builder data(String str) {
            this.z.a(str);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.z.z(i);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.z.g(z);
            return this;
        }

        public Builder debug(boolean z) {
            this.z.dl(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.z.z(iArr);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.z.a(z);
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.z.z(tTCustomController);
            return this;
        }

        public Builder themeStatus(int i) {
            this.z.g(i);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.z.dl(i);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.z.a(i);
            return this;
        }

        public Builder addExtra(String str, Object obj) {
            this.z.z(str, obj);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.z.gc(z);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.z.z(iMediationConfig);
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this.z);
        }
    }
}
