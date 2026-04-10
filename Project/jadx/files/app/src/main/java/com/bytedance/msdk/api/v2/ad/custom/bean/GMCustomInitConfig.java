package com.bytedance.msdk.api.v2.ad.custom.bean;

import android.text.TextUtils;
import com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter;
import com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAdapter;
import com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter;
import com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAdapter;
import com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter;
import com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class GMCustomInitConfig {
    public static final String CUSTOM_TYPE = "1";
    private final String a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f14252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f14253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f14254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f14255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f14256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f14257l;

    public GMCustomInitConfig() {
        this.f14248c = "";
        this.a = "";
        this.b = "";
        this.f14249d = "";
        this.f14250e = "";
        this.f14251f = "";
        this.f14252g = "";
        this.f14253h = "";
        this.f14254i = "";
        this.f14255j = "";
        this.f14256k = "";
        this.f14257l = "";
    }

    public GMCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f14248c = str;
        this.a = str2;
        this.b = str3;
        this.f14249d = str4;
        this.f14250e = str5;
        this.f14251f = str6;
        this.f14252g = str7;
        this.f14253h = str8;
        this.f14254i = str9;
        this.f14255j = str10;
        this.f14256k = str11;
        this.f14257l = str12;
    }

    public String getADNName() {
        return this.f14248c;
    }

    public String getAdnInitClassName() {
        return this.f14249d;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppKey() {
        return this.b;
    }

    public GMCustomAdConfig getClassName(int i2, int i3) {
        switch (i2) {
            case 1:
                return new GMCustomAdConfig(this.f14250e, GMCustomBannerAdapter.class);
            case 2:
                return new GMCustomAdConfig(this.f14251f, GMCustomInterstitialAdapter.class);
            case 3:
                return new GMCustomAdConfig(this.f14254i, GMCustomSplashAdapter.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return new GMCustomAdConfig(this.f14255j, GMCustomNativeAdapter.class);
            case 7:
                return new GMCustomAdConfig(this.f14252g, GMCustomRewardAdapter.class);
            case 8:
                return new GMCustomAdConfig(this.f14253h, GMCustomFullVideoAdapter.class);
            case 9:
                break;
            case 10:
                if (i3 == 1) {
                    return new GMCustomAdConfig(this.f14251f, GMCustomInterstitialAdapter.class);
                }
                if (i3 == 2) {
                    return new GMCustomAdConfig(this.f14253h, GMCustomFullVideoAdapter.class);
                }
                break;
        }
        return new GMCustomAdConfig(this.f14256k, GMCustomDrawAdapter.class);
    }

    public boolean isCustom() {
        return TextUtils.equals(this.f14257l, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.a + "', mAppKey='" + this.b + "', mADNName='" + this.f14248c + "', mAdnInitClassName='" + this.f14249d + "', mBannerClassName='" + this.f14250e + "', mInterstitialClassName='" + this.f14251f + "', mRewardClassName='" + this.f14252g + "', mFullVideoClassName='" + this.f14253h + "', mSplashClassName='" + this.f14254i + "', mDrawClassName='" + this.f14256k + "', mFeedClassName='" + this.f14255j + "'}";
    }
}
