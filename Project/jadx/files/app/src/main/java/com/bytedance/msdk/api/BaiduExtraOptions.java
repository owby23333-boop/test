package com.bytedance.msdk.api;

import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BaiduExtraOptions {
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private boolean a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaiduNativeSmartOptStyleParams f14061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BaiduRequestParameters f14062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BaiduSplashParams f14063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14066h;

    public static final class Builder {

        @Deprecated
        private boolean a;

        @Deprecated
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        private BaiduNativeSmartOptStyleParams f14067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        private BaiduRequestParameters f14068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        private BaiduSplashParams f14069e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14070f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f14072h;

        public final BaiduExtraOptions build() {
            return new BaiduExtraOptions(this);
        }

        public Builder setAppSid(String str) {
            this.f14072h = str;
            return this;
        }

        public Builder setBaiduNativeSmartOptStyleParams(BaiduNativeSmartOptStyleParams baiduNativeSmartOptStyleParams) {
            this.f14067c = baiduNativeSmartOptStyleParams;
            return this;
        }

        public Builder setBaiduRequestParameters(BaiduRequestParameters baiduRequestParameters) {
            this.f14068d = baiduRequestParameters;
            return this;
        }

        public Builder setBaiduSplashParams(BaiduSplashParams baiduSplashParams) {
            this.f14069e = baiduSplashParams;
            return this;
        }

        public Builder setCacheVideoOnlyWifi(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setGDTExtraOption(int i2) {
            this.b = i2;
            return this;
        }

        public Builder setShowDialogOnSkip(boolean z2) {
            this.f14070f = z2;
            return this;
        }

        public Builder setUseRewardCountdown(boolean z2) {
            this.f14071g = z2;
            return this;
        }
    }

    private BaiduExtraOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f14061c = builder.f14067c;
        this.f14062d = builder.f14068d;
        this.f14063e = builder.f14069e;
        this.f14064f = builder.f14070f;
        this.f14065g = builder.f14071g;
        this.f14066h = builder.f14072h;
    }

    public String getAppSid() {
        return this.f14066h;
    }

    public BaiduNativeSmartOptStyleParams getBaiduNativeSmartOptStyleParams() {
        return this.f14061c;
    }

    public BaiduRequestParameters getBaiduRequestParameters() {
        return this.f14062d;
    }

    public BaiduSplashParams getBaiduSplashParams() {
        return this.f14063e;
    }

    public int getDownloadAppConfirmPolicy() {
        return this.b;
    }

    public GMAdSlotBaiduOption getGMBaiduExtra() {
        GMAdSlotBaiduOption.Builder builder = new GMAdSlotBaiduOption.Builder();
        builder.setCacheVideoOnlyWifi(isCacheVideoOnlyWifi());
        builder.setAppSid(getAppSid());
        builder.setBaiduNativeSmartOptStyleParams(getBaiduNativeSmartOptStyleParams());
        builder.setBaiduRequestParameters(getBaiduRequestParameters());
        builder.setBaiduSplashParams(getBaiduSplashParams());
        builder.setDownloadAppConfirmPolicy(getDownloadAppConfirmPolicy());
        builder.setShowDialogOnSkip(getShowDialogOnSkip());
        builder.setUseRewardCountdown(getUseRewardCountdown());
        return builder.build();
    }

    public boolean getShowDialogOnSkip() {
        return this.f14064f;
    }

    public boolean getUseRewardCountdown() {
        return this.f14065g;
    }

    public boolean isCacheVideoOnlyWifi() {
        return this.a;
    }
}
