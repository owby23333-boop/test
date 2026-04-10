package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotInterstitial extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14355m;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14356k = 640;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14357l = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;

        public GMAdSlotInterstitial build() {
            return new GMAdSlotInterstitial(this);
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
            this.f14356k = i2;
            this.f14357l = i3;
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

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f14334g = str;
            return this;
        }

        public Builder setUseSurfaceView(boolean z2) {
            this.f14330c = z2;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotInterstitial(Builder builder) {
        super(builder);
        this.f14354l = builder.f14356k;
        this.f14355m = builder.f14357l;
    }

    public int getHeight() {
        return this.f14355m;
    }

    public int getWidth() {
        return this.f14354l;
    }
}
