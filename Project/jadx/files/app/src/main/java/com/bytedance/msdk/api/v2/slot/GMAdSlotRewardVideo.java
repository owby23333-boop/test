package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotRewardVideo extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f14388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Map<String, String> f14390n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f14391o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f14392p;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Map<String, String> f14395m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f14397o;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f14393k = "";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14394l = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f14396n = "";

        public GMAdSlotRewardVideo build() {
            return new GMAdSlotRewardVideo(this);
        }

        public Builder setBidNotify(boolean z2) {
            this.f14336i = z2;
            return this;
        }

        public Builder setCustomData(@NonNull Map<String, String> map) {
            this.f14395m = map;
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

        public Builder setMuted(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.f14397o = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f14394l = i2;
            return this;
        }

        public Builder setRewardName(@NonNull String str) {
            this.f14393k = str;
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
            this.f14396n = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotRewardVideo(Builder builder) {
        super(builder);
        this.f14388l = builder.f14393k;
        this.f14389m = builder.f14394l;
        this.f14390n = builder.f14395m;
        this.f14391o = builder.f14396n;
        this.f14392p = builder.f14397o;
    }

    @Nullable
    public Map<String, String> getCustomData() {
        return this.f14390n;
    }

    public int getOrientation() {
        return this.f14392p;
    }

    public int getRewardAmount() {
        return this.f14389m;
    }

    public String getRewardName() {
        return this.f14388l;
    }

    public String getUserID() {
        return this.f14391o;
    }
}
