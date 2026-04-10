package com.bytedance.msdk.api;

import android.widget.FrameLayout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class AdSlot extends b {
    public static final int AUTO_HEIGHT = -2;

    @Deprecated
    public static final String CUSTOM_DATA_KEY_ADMOB = "admob";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_BAIDU = "baidu";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_GDT = "gdt";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_KLEVIN = "klevin";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_KS = "ks";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_MINTEGRAL = "mintegral";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_PANGLE = "pangle";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_SIGMOB = "sigmob";

    @Deprecated
    public static final String CUSTOM_DATA_KEY_UNITY = "unity";
    public static final int FULL_WIDTH = -1;
    public static final int POSITION_BOTTOM = 2;
    public static final int POSITION_FEED = 3;
    public static final int POSITION_FULL_SCREEN = 5;
    public static final int POSITION_MIDDLE = 4;
    public static final int POSITION_TOP = 1;
    public static final int TYPE_BANNER = 1;

    @Deprecated
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_EXPRESS_AD = 1;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_INTERACTION_FULL = 10;
    public static final int TYPE_NATIVE_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    private TTRequestExtraParams A;
    private AdmobNativeAdOptions B;
    private FrameLayout.LayoutParams C;
    private String D;
    private boolean E;

    @Deprecated
    private int F;

    @Deprecated
    private int G;
    private boolean H;
    private boolean I;
    private double J;
    private int K;
    private int L;
    private boolean M;
    private String N;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f14021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f14022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f14024n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14025o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f14026p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f14027q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f14028r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f14029s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f14030t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f14032v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f14033w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Map<String, String> f14034x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f14035y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TTVideoOption f14036z;

    public static class Builder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        private String f14039e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        private int f14040f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        private String f14041g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Deprecated
        private Map<String, String> f14042h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        private String f14043i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Deprecated
        private int f14044j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Deprecated
        private int f14045k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Deprecated
        private TTVideoOption f14046l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Deprecated
        private TTRequestExtraParams f14047m;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Deprecated
        private AdmobNativeAdOptions f14050p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @Deprecated
        private FrameLayout.LayoutParams f14051q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Deprecated
        private String f14052r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f14053s;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Deprecated
        private boolean f14056v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Deprecated
        private boolean f14057w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Deprecated
        private boolean f14058x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f14059y;

        @Deprecated
        private int a = 640;

        @Deprecated
        private int b = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        private boolean f14037c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        private int f14038d = 1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Deprecated
        private int f14048n = 2;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Deprecated
        private int f14049o = 3;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Deprecated
        private int f14054t = 1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Deprecated
        private int f14055u = 0;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f14025o = this.f14038d;
            adSlot.f14026p = this.f14037c;
            adSlot.f14023m = this.a;
            adSlot.f14024n = this.b;
            adSlot.f14030t = this.f14039e;
            adSlot.f14031u = this.f14040f;
            adSlot.f14032v = this.f14041g;
            adSlot.f14034x = this.f14042h;
            adSlot.f14033w = this.f14043i;
            adSlot.f14035y = this.f14044j;
            adSlot.f14027q = this.f14045k;
            adSlot.f14028r = this.f14048n;
            adSlot.f14036z = this.f14046l;
            adSlot.A = this.f14047m;
            adSlot.B = this.f14050p;
            adSlot.f14029s = this.f14049o;
            adSlot.C = this.f14051q;
            adSlot.D = this.f14052r;
            adSlot.E = this.f14053s;
            adSlot.F = this.f14054t;
            adSlot.G = this.f14055u;
            adSlot.H = this.f14056v;
            adSlot.I = this.f14057w;
            adSlot.M = this.f14058x;
            adSlot.N = this.f14059y;
            return adSlot;
        }

        @Deprecated
        public Builder setAdCount(int i2) {
            this.f14038d = i2;
            return this;
        }

        @Deprecated
        public Builder setAdStyleType(int i2) {
            this.f14048n = i2;
            return this;
        }

        @Deprecated
        public Builder setAdType(int i2) {
            this.f14045k = i2;
            return this;
        }

        @Deprecated
        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.f14050p = admobNativeAdOptions;
            return this;
        }

        @Deprecated
        public Builder setBannerSize(int i2) {
            this.f14049o = i2;
            return this;
        }

        @Deprecated
        public Builder setBidNotify(boolean z2) {
            this.f14056v = z2;
            return this;
        }

        @Deprecated
        public Builder setCustomData(Map<String, String> map) {
            this.f14042h = map;
            return this;
        }

        @Deprecated
        public Builder setDownloadType(int i2) {
            this.f14055u = i2;
            return this;
        }

        @Deprecated
        public Builder setForceLoadBottom(boolean z2) {
            this.f14057w = z2;
            return this;
        }

        public Builder setGdtNativeAdLogoParams(FrameLayout.LayoutParams layoutParams) {
            this.f14051q = layoutParams;
            return this;
        }

        @Deprecated
        public Builder setImageAdSize(int i2, int i3) {
            this.a = i2;
            this.b = i3;
            return this;
        }

        @Deprecated
        public Builder setMediaExtra(String str) {
            this.f14041g = str;
            return this;
        }

        @Deprecated
        public Builder setOrientation(int i2) {
            this.f14044j = i2;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i2) {
            this.f14040f = i2;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.f14039e = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f14059y = str;
            return this;
        }

        @Deprecated
        public Builder setSplashButtonType(int i2) {
            this.f14054t = i2;
            return this;
        }

        @Deprecated
        public Builder setSplashShakeButton(boolean z2) {
            this.f14058x = z2;
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z2) {
            this.f14037c = z2;
            return this;
        }

        @Deprecated
        public Builder setTTRequestExtraParams(TTRequestExtraParams tTRequestExtraParams) {
            this.f14047m = tTRequestExtraParams;
            return this;
        }

        @Deprecated
        public Builder setTTVideoOption(TTVideoOption tTVideoOption) {
            this.f14046l = tTVideoOption;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f14052r = str;
            return this;
        }

        @Deprecated
        public Builder setUserID(String str) {
            this.f14043i = str;
            return this;
        }

        public Builder setV2Request(boolean z2) {
            this.f14053s = z2;
            return this;
        }
    }

    private AdSlot() {
        this.f14028r = 2;
        this.f14029s = 3;
    }

    public int getAdCount() {
        int netWorkNum = getNetWorkNum();
        if (netWorkNum > 3) {
            netWorkNum = 3;
        }
        return netWorkNum > 0 ? netWorkNum : this.f14025o;
    }

    public int getAdStyleType() {
        return this.f14028r;
    }

    public int getAdType() {
        return this.f14027q;
    }

    public String getAdUnitId() {
        return this.f14020j;
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.B;
    }

    public int getBannerSize() {
        return this.f14029s;
    }

    @Deprecated
    public double getBidFloor() {
        return this.J;
    }

    public Map<String, String> getCustomData() {
        return this.f14034x;
    }

    @Deprecated
    public int getDownloadType() {
        return this.G;
    }

    public FrameLayout.LayoutParams getGdtNativeAdLogoParams() {
        return this.C;
    }

    public int getImgAcceptedHeight() {
        return this.f14024n;
    }

    public int getImgAcceptedWidth() {
        return this.f14023m;
    }

    @Deprecated
    public String getMediaExtra() {
        return this.f14032v;
    }

    public int getOrientation() {
        return this.f14035y;
    }

    public int getParalleType() {
        return this.K;
    }

    public int getReqParallelNum() {
        return this.L;
    }

    public TTRequestExtraParams getReuestParam() {
        if (this.A == null) {
            this.A = new TTRequestExtraParams();
        }
        return this.A;
    }

    public int getRewardAmount() {
        return this.f14031u;
    }

    public String getRewardName() {
        return this.f14030t;
    }

    public String getScenarioId() {
        return this.N;
    }

    @Deprecated
    public int getSplashButtonType() {
        return this.F;
    }

    public boolean getSplashShakeButton() {
        return this.M;
    }

    public TTVideoOption getTTVideoOption() {
        return this.f14036z;
    }

    @Deprecated
    public String getTestSlotId() {
        return this.D;
    }

    public String getUserID() {
        return this.f14033w;
    }

    @Deprecated
    public String getVersion() {
        return this.f14022l;
    }

    @Deprecated
    public long getWaterfallId() {
        return this.f14021k;
    }

    public boolean isBidNotify() {
        return this.H;
    }

    public boolean isForceLoadBottom() {
        return this.I;
    }

    public boolean isSupportDeepLink() {
        return this.f14026p;
    }

    public boolean isV2Request() {
        return this.E;
    }

    public void setAdCount(int i2) {
        this.f14025o = i2;
    }

    public void setAdType(int i2) {
        this.f14027q = i2;
    }

    public void setAdUnitId(String str) {
        this.f14020j = str;
    }

    @Deprecated
    public void setBidFloor(double d2) {
        this.J = d2;
    }

    public void setParalleType(int i2) {
        this.K = i2;
    }

    public void setReqParallelNum(int i2) {
        this.L = i2;
    }

    public void setScenarioId(String str) {
        this.N = str;
    }

    public void setSplashShakeButton(boolean z2) {
        this.M = z2;
    }

    public void setTTVideoOption(TTVideoOption tTVideoOption) {
        this.f14036z = tTVideoOption;
    }

    @Deprecated
    public void setTestSlotId(String str) {
        this.D = str;
    }

    @Deprecated
    public void setVersion(String str) {
        this.f14022l = str;
    }

    @Deprecated
    public void setWaterfallId(long j2) {
        this.f14021k = j2;
    }
}
