package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotFullVideo extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f14344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f14346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, String> f14348p;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f14349k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14350l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f14351m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f14352n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Map<String, String> f14353o;

        public GMAdSlotFullVideo build() {
            return new GMAdSlotFullVideo(this);
        }

        public Builder setBidNotify(boolean z2) {
            this.f14336i = z2;
            return this;
        }

        public Builder setCustomData(@NonNull Map<String, String> map) {
            this.f14353o = map;
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
            this.f14350l = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f14352n = i2;
            return this;
        }

        public Builder setRewardName(@NonNull String str) {
            this.f14351m = str;
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
            this.f14349k = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotFullVideo(Builder builder) {
        super(builder);
        this.f14344l = builder.f14349k;
        this.f14345m = builder.f14350l;
        this.f14346n = builder.f14351m;
        this.f14347o = builder.f14352n;
        this.f14348p = builder.f14353o;
    }

    @Nullable
    public Map<String, String> getCustomData() {
        return this.f14348p;
    }

    public int getOrientation() {
        return this.f14345m;
    }

    public int getRewardAmount() {
        return this.f14347o;
    }

    public String getRewardName() {
        return this.f14346n;
    }

    public String getUserID() {
        return this.f14344l;
    }
}
