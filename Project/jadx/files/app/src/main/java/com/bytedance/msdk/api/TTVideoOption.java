package com.bytedance.msdk.api;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TTVideoOption {
    private final boolean a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f14150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GDTExtraOption f14151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BaiduExtraOptions f14152e;

    public static final class Builder {

        @Deprecated
        private boolean a = true;

        @Deprecated
        private float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        private GDTExtraOption f14153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        private boolean f14154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        private BaiduExtraOptions f14155e;

        public final TTVideoOption build() {
            return new TTVideoOption(this);
        }

        @Deprecated
        public Builder setAdmobAppVolume(float f2) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            this.b = f2;
            return this;
        }

        @Deprecated
        public Builder setBaiduExtraOption(BaiduExtraOptions baiduExtraOptions) {
            this.f14155e = baiduExtraOptions;
            return this;
        }

        @Deprecated
        public Builder setGDTExtraOption(GDTExtraOption gDTExtraOption) {
            this.f14153c = gDTExtraOption;
            return this;
        }

        @Deprecated
        public final Builder setMuted(boolean z2) {
            this.a = z2;
            return this;
        }

        @Deprecated
        public final Builder useSurfaceView(boolean z2) {
            this.f14154d = z2;
            return this;
        }
    }

    private TTVideoOption(Builder builder) {
        this.a = builder.a;
        this.f14150c = builder.b;
        this.f14151d = builder.f14153c;
        this.b = builder.f14154d;
        this.f14152e = builder.f14155e;
    }

    public float getAdmobAppVolume() {
        return this.f14150c;
    }

    public BaiduExtraOptions getBaiduExtraOption() {
        return this.f14152e;
    }

    public GDTExtraOption getGDTExtraOption() {
        return this.f14151d;
    }

    public boolean isMuted() {
        return this.a;
    }

    public boolean useSurfaceView() {
        return this.b;
    }
}
