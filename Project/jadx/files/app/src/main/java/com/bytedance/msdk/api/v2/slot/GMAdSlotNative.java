package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdmobNativeAdOptions;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotNative extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f14374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f14376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AdmobNativeAdOptions f14377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f14378r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f14379s;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14380k = 640;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14381l = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f14382m = 80;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f14383n = 80;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f14384o = 1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f14385p = 2;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f14386q = "";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private AdmobNativeAdOptions f14387r;

        public GMAdSlotNative build() {
            return new GMAdSlotNative(this);
        }

        public Builder setAdCount(int i2) {
            this.f14384o = i2;
            return this;
        }

        public Builder setAdStyleType(int i2) {
            this.f14385p = i2;
            return this;
        }

        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.f14387r = admobNativeAdOptions;
            return this;
        }

        public Builder setBidNotify(boolean z2) {
            this.f14336i = z2;
            return this;
        }

        @Deprecated
        public Builder setDownloadType(int i2) {
            this.f14335h = i2;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f14333f;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setGMAdSlotBaiduOption(@NonNull GMAdSlotBaiduOption gMAdSlotBaiduOption) {
            this.f14332e = gMAdSlotBaiduOption;
            return this;
        }

        public Builder setGMAdSlotGDTOption(@NonNull GMAdSlotGDTOption gMAdSlotGDTOption) {
            this.f14331d = gMAdSlotGDTOption;
            return this;
        }

        public Builder setImageAdSize(int i2, int i3) {
            this.f14380k = i2;
            this.f14381l = i3;
            return this;
        }

        public Builder setMuted(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f14337j = str;
            return this;
        }

        public Builder setShakeViewSize(int i2, int i3) {
            this.f14382m = i2;
            this.f14383n = i3;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f14334g = str;
            return this;
        }

        public Builder setUseSurfaceView(boolean z2) {
            this.f14330c = z2;
            return this;
        }

        public Builder setUserID(String str) {
            this.f14386q = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotNative(Builder builder) {
        super(builder);
        this.f14372l = builder.f14380k;
        this.f14373m = builder.f14381l;
        this.f14378r = builder.f14382m;
        this.f14379s = builder.f14383n;
        this.f14374n = builder.f14384o;
        this.f14376p = builder.f14386q;
        this.f14375o = builder.f14385p;
        this.f14377q = builder.f14387r != null ? builder.f14387r : new AdmobNativeAdOptions();
    }

    public int getAdCount() {
        int i2 = this.f14374n;
        if (i2 <= 0) {
            return 1;
        }
        if (i2 <= 3) {
            return i2;
        }
        return 3;
    }

    public int getAdStyleType() {
        return this.f14375o;
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.f14377q;
    }

    public int getHeight() {
        return this.f14373m;
    }

    public int getRequestCount() {
        int netWorkNum = getNetWorkNum();
        if (netWorkNum > 3) {
            netWorkNum = 3;
        }
        if (netWorkNum > 0) {
            return netWorkNum;
        }
        int i2 = this.f14374n;
        if (i2 <= 0) {
            return 1;
        }
        if (i2 > 3) {
            return 3;
        }
        return i2;
    }

    public int getShakeViewHeight() {
        return this.f14379s;
    }

    public int getShakeViewWidth() {
        return this.f14378r;
    }

    public String getUserID() {
        return this.f14376p;
    }

    public int getWidth() {
        return this.f14372l;
    }
}
