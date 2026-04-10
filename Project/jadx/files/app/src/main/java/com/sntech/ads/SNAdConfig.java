package com.sntech.ads;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface SNAdConfig {

    /* JADX INFO: loaded from: classes3.dex */
    @Keep
    public static final class Builder {
        private String mAppId;
        private String mChannel;
        private boolean mDebug;
        private String mUserId;

        private Builder() {
        }

        @Keep
        public static Builder newBuilder() {
            return new Builder();
        }

        @Keep
        public SNAdConfig build() {
            return new DefaultConfig(this);
        }

        @Keep
        public Builder withAppId(String str) {
            this.mAppId = str;
            return this;
        }

        @Keep
        public Builder withChannel(String str) {
            this.mChannel = str;
            return this;
        }

        @Keep
        public Builder withDebug(boolean z2) {
            this.mDebug = z2;
            return this;
        }

        @Keep
        public Builder withUserId(String str) {
            this.mUserId = str;
            return this;
        }

        @Keep
        public static Builder newBuilder(SNAdConfig sNAdConfig) {
            Builder builder = new Builder();
            builder.mUserId = sNAdConfig.getUserId();
            builder.mAppId = sNAdConfig.getAppId();
            builder.mDebug = sNAdConfig.isDebug();
            builder.mChannel = sNAdConfig.getChannel();
            return builder;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class DefaultConfig implements SNAdConfig {
        private final String mAppId;
        private final String mChannel;
        private final boolean mDebug;
        private final String mUserId;

        @Override // com.sntech.ads.SNAdConfig
        @Keep
        public String getAppId() {
            return this.mAppId;
        }

        @Override // com.sntech.ads.SNAdConfig
        public String getChannel() {
            return this.mChannel;
        }

        @Override // com.sntech.ads.SNAdConfig
        @Keep
        public String getUserId() {
            return this.mUserId;
        }

        @Override // com.sntech.ads.SNAdConfig
        public boolean isDebug() {
            return this.mDebug;
        }

        private DefaultConfig(Builder builder) {
            this.mUserId = builder.mUserId;
            this.mAppId = builder.mAppId;
            this.mDebug = builder.mDebug;
            this.mChannel = builder.mChannel;
        }
    }

    @Keep
    String getAppId();

    @Keep
    String getChannel();

    @Keep
    String getUserId();

    @Keep
    boolean isDebug();
}
