package com.bytedance.msdk.api.v2.slot.paltform;

import com.bytedance.msdk.api.BaiduExtraOptions;
import com.bytedance.msdk.api.BaiduNativeSmartOptStyleParams;
import com.bytedance.msdk.api.BaiduRequestParameters;
import com.bytedance.msdk.api.BaiduSplashParams;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotBaiduOption {
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private boolean a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaiduNativeSmartOptStyleParams f14414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BaiduRequestParameters f14415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BaiduSplashParams f14416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14419h;

    public static final class Builder {
        private boolean a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private BaiduNativeSmartOptStyleParams f14420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private BaiduRequestParameters f14421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private BaiduSplashParams f14422e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14423f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14424g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f14425h;

        public final GMAdSlotBaiduOption build() {
            return new GMAdSlotBaiduOption(this);
        }

        public Builder setAppSid(String str) {
            this.f14425h = str;
            return this;
        }

        public Builder setBaiduNativeSmartOptStyleParams(BaiduNativeSmartOptStyleParams baiduNativeSmartOptStyleParams) {
            this.f14420c = baiduNativeSmartOptStyleParams;
            return this;
        }

        public Builder setBaiduRequestParameters(BaiduRequestParameters baiduRequestParameters) {
            this.f14421d = baiduRequestParameters;
            return this;
        }

        public Builder setBaiduSplashParams(BaiduSplashParams baiduSplashParams) {
            this.f14422e = baiduSplashParams;
            return this;
        }

        public Builder setCacheVideoOnlyWifi(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setDownloadAppConfirmPolicy(int i2) {
            this.b = i2;
            return this;
        }

        public Builder setShowDialogOnSkip(boolean z2) {
            this.f14423f = z2;
            return this;
        }

        public Builder setUseRewardCountdown(boolean z2) {
            this.f14424g = z2;
            return this;
        }
    }

    private GMAdSlotBaiduOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f14414c = builder.f14420c;
        this.f14415d = builder.f14421d;
        this.f14416e = builder.f14422e;
        this.f14417f = builder.f14423f;
        this.f14418g = builder.f14424g;
        this.f14419h = builder.f14425h;
    }

    public String getAppSid() {
        return this.f14419h;
    }

    public BaiduExtraOptions getBaiduExtra() {
        BaiduExtraOptions.Builder builder = new BaiduExtraOptions.Builder();
        builder.setCacheVideoOnlyWifi(isCacheVideoOnlyWifi());
        builder.setAppSid(getAppSid());
        builder.setBaiduNativeSmartOptStyleParams(getBaiduNativeSmartOptStyleParams());
        builder.setBaiduRequestParameters(getBaiduRequestParameters());
        builder.setBaiduSplashParams(getBaiduSplashParams());
        builder.setGDTExtraOption(getDownloadAppConfirmPolicy());
        builder.setShowDialogOnSkip(getShowDialogOnSkip());
        builder.setUseRewardCountdown(getUseRewardCountdown());
        return builder.build();
    }

    public BaiduNativeSmartOptStyleParams getBaiduNativeSmartOptStyleParams() {
        return this.f14414c;
    }

    public BaiduRequestParameters getBaiduRequestParameters() {
        return this.f14415d;
    }

    public BaiduSplashParams getBaiduSplashParams() {
        return this.f14416e;
    }

    public int getDownloadAppConfirmPolicy() {
        return this.b;
    }

    public boolean getShowDialogOnSkip() {
        return this.f14417f;
    }

    public boolean getUseRewardCountdown() {
        return this.f14418g;
    }

    public boolean isCacheVideoOnlyWifi() {
        return this.a;
    }
}
