package com.anythink.core.api;

/* JADX INFO: loaded from: classes2.dex */
public class ATCustomAdapterConfig {
    private long adCacheTime;
    private boolean realTimeBidSwitch;

    public static class Builder {
        private boolean realTimeBidSwitch = false;
        private long adCacheTime = 1800000;

        public Builder adCacheTime(long j2) {
            this.adCacheTime = j2;
            return this;
        }

        public ATCustomAdapterConfig build() {
            ATCustomAdapterConfig aTCustomAdapterConfig = new ATCustomAdapterConfig();
            aTCustomAdapterConfig.realTimeBidSwitch = this.realTimeBidSwitch;
            aTCustomAdapterConfig.adCacheTime = this.adCacheTime;
            return aTCustomAdapterConfig;
        }

        public Builder realTimeBidSwitch(boolean z2) {
            this.realTimeBidSwitch = z2;
            return this;
        }
    }

    public long getAdCacheTime() {
        return this.adCacheTime;
    }

    public boolean isRealTimeBidSwitch() {
        return this.realTimeBidSwitch;
    }

    private ATCustomAdapterConfig() {
    }
}
