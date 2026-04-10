package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotInterstitialFull extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f14360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f14362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f14363q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, String> f14364r;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14365k = 640;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14366l = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f14367m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f14368n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f14369o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f14370p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Map<String, String> f14371q;

        public GMAdSlotInterstitialFull build() {
            return new GMAdSlotInterstitialFull(this);
        }

        public Builder setBidNotify(boolean z2) {
            this.f14336i = z2;
            return this;
        }

        public Builder setCustomData(@NonNull Map<String, String> map) {
            this.f14371q = map;
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
            this.f14365k = i2;
            this.f14366l = i3;
            return this;
        }

        public Builder setMuted(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.f14368n = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f14370p = i2;
            return this;
        }

        public Builder setRewardName(@NonNull String str) {
            this.f14369o = str;
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
            this.f14367m = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotInterstitialFull(Builder builder) {
        super(builder);
        this.f14358l = builder.f14365k;
        this.f14359m = builder.f14366l;
        this.f14360n = builder.f14367m;
        this.f14361o = builder.f14368n;
        this.f14362p = builder.f14369o;
        this.f14363q = builder.f14370p;
        this.f14364r = builder.f14371q;
    }

    @Nullable
    public Map<String, String> getCustomData() {
        return this.f14364r;
    }

    public GMAdSlotFullVideo getGMAdSlotFullVideo() {
        GMAdSlotFullVideo gMAdSlotFullVideoBuild = new GMAdSlotFullVideo.Builder().setUserID(this.f14360n).setOrientation(this.f14361o).setMuted(isMuted()).setVolume(getVolume()).setUseSurfaceView(isUseSurfaceView()).setGMAdSlotGDTOption(this.f14322d).setGMAdSlotBaiduOption(this.f14323e).setTestSlotId(getTestSlotId()).setDownloadType(getDownloadType()).setBidNotify(isBidNotify()).setRewardName(getRewardName()).setRewardAmount(getRewardAmount()).setCustomData(getCustomData()).build();
        if (gMAdSlotFullVideoBuild.getParams() != null && getParams() != null) {
            gMAdSlotFullVideoBuild.getParams().putAll(getParams());
        }
        return gMAdSlotFullVideoBuild;
    }

    public GMAdSlotInterstitial getGMAdSlotInterstitial() {
        GMAdSlotInterstitial gMAdSlotInterstitialBuild = new GMAdSlotInterstitial.Builder().setImageAdSize(getWidth(), getHeight()).setMuted(isMuted()).setVolume(getVolume()).setUseSurfaceView(isUseSurfaceView()).setGMAdSlotGDTOption(this.f14322d).setGMAdSlotBaiduOption(this.f14323e).setTestSlotId(getTestSlotId()).setDownloadType(getDownloadType()).setBidNotify(isBidNotify()).build();
        if (gMAdSlotInterstitialBuild.getParams() != null && getParams() != null) {
            gMAdSlotInterstitialBuild.getParams().putAll(getParams());
        }
        return gMAdSlotInterstitialBuild;
    }

    public int getHeight() {
        return this.f14359m;
    }

    public int getOrientation() {
        return this.f14361o;
    }

    public int getRewardAmount() {
        return this.f14363q;
    }

    public String getRewardName() {
        return this.f14362p;
    }

    public String getUserID() {
        return this.f14360n;
    }

    public int getWidth() {
        return this.f14358l;
    }
}
