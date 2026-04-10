package com.bytedance.msdk.api.v2;

/* JADX INFO: loaded from: classes2.dex */
public class GMGdtOption {
    private boolean a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14207d;

    public static class Builder {
        private boolean a = false;
        private String b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14208c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14209d = false;

        public GMGdtOption build() {
            return new GMGdtOption(this);
        }

        public Builder setOpensdkVer(String str) {
            this.b = str;
            return this;
        }

        public Builder setSupportH265(boolean z2) {
            this.f14208c = z2;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z2) {
            this.f14209d = z2;
            return this;
        }

        public Builder setWxInstalled(boolean z2) {
            this.a = z2;
            return this;
        }
    }

    private GMGdtOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f14206c = builder.f14208c;
        this.f14207d = builder.f14209d;
    }

    public String getOpensdkVer() {
        return this.b;
    }

    public boolean isSupportH265() {
        return this.f14206c;
    }

    public boolean isSupportSplashZoomout() {
        return this.f14207d;
    }

    public boolean isWxInstalled() {
        return this.a;
    }
}
