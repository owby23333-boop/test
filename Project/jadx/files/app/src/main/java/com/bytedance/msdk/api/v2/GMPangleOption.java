package com.bytedance.msdk.api.v2;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMPangleOption {
    private boolean a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f14214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f14216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, String> f14218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14220k;

    public static class Builder {
        private boolean a = false;
        private int b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14221c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14222d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f14223e = {4, 3, 5};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14224f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String[] f14225g = new String[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f14226h = "";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Map<String, String> f14227i = new HashMap();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f14228j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14229k = 2;

        public GMPangleOption build() {
            return new GMPangleOption(this);
        }

        public Builder setAllowShowNotify(boolean z2) {
            this.f14221c = z2;
            return this;
        }

        public Builder setAllowShowPageWhenScreenLock(boolean z2) {
            this.f14222d = z2;
            return this;
        }

        public Builder setData(@NonNull String str) {
            this.f14226h = str;
            return this;
        }

        public Builder setData(@NonNull String str, @NonNull String str2) {
            this.f14227i.put(str, str2);
            return this;
        }

        public Builder setData(@NonNull Map<String, String> map) {
            this.f14227i.putAll(map);
            return this;
        }

        public Builder setDirectDownloadNetworkType(@NonNull int... iArr) {
            this.f14223e = iArr;
            return this;
        }

        public Builder setIsPaid(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setIsUseTextureView(boolean z2) {
            this.f14224f = z2;
            return this;
        }

        public Builder setKeywords(@NonNull String str) {
            this.f14228j = str;
            return this;
        }

        public Builder setNeedClearTaskReset(@NonNull String... strArr) {
            this.f14225g = strArr;
            return this;
        }

        public Builder setTitleBarTheme(int i2) {
            this.b = i2;
            return this;
        }
    }

    private GMPangleOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f14212c = builder.f14221c;
        this.f14213d = builder.f14222d;
        this.f14214e = builder.f14223e;
        this.f14215f = builder.f14224f;
        this.f14216g = builder.f14225g;
        this.f14217h = builder.f14226h;
        this.f14218i = builder.f14227i;
        this.f14219j = builder.f14228j;
        this.f14220k = builder.f14229k;
    }

    public String getData() {
        return this.f14217h;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.f14214e;
    }

    @NonNull
    public Map<String, String> getExtraData() {
        return this.f14218i;
    }

    public String getKeywords() {
        return this.f14219j;
    }

    public String[] getNeedClearTaskReset() {
        return this.f14216g;
    }

    public int getPluginUpdateConfig() {
        return this.f14220k;
    }

    public int getTitleBarTheme() {
        return this.b;
    }

    public boolean isAllowShowNotify() {
        return this.f14212c;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.f14213d;
    }

    public boolean isIsUseTextureView() {
        return this.f14215f;
    }

    public boolean isPaid() {
        return this.a;
    }
}
