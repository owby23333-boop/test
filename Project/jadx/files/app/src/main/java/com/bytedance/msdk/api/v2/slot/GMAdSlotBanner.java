package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdmobNativeAdOptions;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotBanner extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14310m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f14311n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f14312o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f14313p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AdmobNativeAdOptions f14314q;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14315k = 640;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14316l = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f14317m = 3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f14318n = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f14319o = "";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private AdmobNativeAdOptions f14320p;

        public GMAdSlotBanner build() {
            return new GMAdSlotBanner(this);
        }

        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.f14320p = admobNativeAdOptions;
            return this;
        }

        public Builder setAllowShowCloseBtn(boolean z2) {
            this.f14318n = z2;
            return this;
        }

        public Builder setBannerSize(int i2) {
            this.f14317m = i2;
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
            this.f14315k = i2;
            this.f14316l = i3;
            return this;
        }

        public Builder setMuted(boolean z2) {
            this.a = z2;
            return this;
        }

        @Deprecated
        public Builder setRefreshTime(int i2) {
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f14337j = str;
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
            this.f14319o = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotBanner(Builder builder) {
        super(builder);
        this.f14309l = builder.f14315k;
        this.f14310m = builder.f14316l;
        this.f14311n = builder.f14317m;
        this.f14312o = builder.f14318n;
        this.f14313p = builder.f14319o;
        this.f14314q = builder.f14320p != null ? builder.f14320p : new AdmobNativeAdOptions();
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.f14314q;
    }

    public int getBannerSize() {
        return this.f14311n;
    }

    public int getHeight() {
        return this.f14310m;
    }

    public String getUserID() {
        return this.f14313p;
    }

    public int getWidth() {
        return this.f14309l;
    }

    public boolean isAllowShowCloseBtn() {
        return this.f14312o;
    }
}
