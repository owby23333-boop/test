package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotSplash extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f14400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f14401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f14402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    private int f14403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f14404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f14405s;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f14408m;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f14412q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f14413r;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14406k = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14407l = 1920;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f14409n = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f14410o = 3000;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Deprecated
        private int f14411p = 1;

        public GMAdSlotSplash build() {
            return new GMAdSlotSplash(this);
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

        public Builder setForceLoadBottom(boolean z2) {
            this.f14412q = z2;
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
            this.f14406k = i2;
            this.f14407l = i3;
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
        public Builder setSplashButtonType(int i2) {
            this.f14411p = i2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z2) {
            this.f14409n = z2;
            return this;
        }

        public Builder setSplashShakeButton(boolean z2) {
            this.f14413r = z2;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f14334g = str;
            return this;
        }

        public Builder setTimeOut(int i2) {
            this.f14410o = i2;
            return this;
        }

        public Builder setUseSurfaceView(boolean z2) {
            this.f14330c = z2;
            return this;
        }

        public Builder setUserID(String str) {
            this.f14408m = str;
            return this;
        }

        public Builder setVolume(float f2) {
            this.b = f2;
            return this;
        }
    }

    private GMAdSlotSplash(Builder builder) {
        super(builder);
        this.f14398l = builder.f14406k;
        this.f14399m = builder.f14407l;
        this.f14400n = builder.f14408m;
        this.f14401o = builder.f14409n;
        this.f14402p = builder.f14410o;
        this.f14403q = builder.f14411p;
        this.f14404r = builder.f14412q;
        this.f14405s = builder.f14413r;
    }

    public int getHeight() {
        return this.f14399m;
    }

    @Deprecated
    public int getSplashButtonType() {
        return this.f14403q;
    }

    public boolean getSplashShakeButton() {
        return this.f14405s;
    }

    public int getTimeOut() {
        return this.f14402p;
    }

    public String getUserID() {
        return this.f14400n;
    }

    public int getWidth() {
        return this.f14398l;
    }

    public boolean isForceLoadBottom() {
        return this.f14404r;
    }

    public boolean isSplashPreLoad() {
        return this.f14401o;
    }
}
