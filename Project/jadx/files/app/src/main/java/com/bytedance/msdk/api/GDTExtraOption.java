package com.bytedance.msdk.api;

import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class GDTExtraOption {
    private boolean a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f14085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f14087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f14088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f14089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14091m;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class BrowserType {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_INNER = 1;
        public static final int TYPE_SYS = 2;
    }

    public static final class Builder {
        private boolean a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f14095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f14096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f14097h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f14098i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f14099j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14100k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14101l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f14102m;

        public final GDTExtraOption build() {
            return new GDTExtraOption(this);
        }

        public Builder setAutoPlayPolicy(int i2) {
            this.f14096g = i2;
            return this;
        }

        public Builder setBrowserType(int i2) {
            this.f14097h = i2;
            return this;
        }

        public Builder setDownAPPConfirmPolicy(int i2) {
            this.f14098i = i2;
            return this;
        }

        public Builder setFeedExpressType(int i2) {
            this.f14101l = i2;
            return this;
        }

        public Builder setGDTAutoPlayMuted(boolean z2) {
            this.b = z2;
            return this;
        }

        public Builder setGDTDetailPageMuted(boolean z2) {
            this.f14092c = z2;
            return this;
        }

        public Builder setGDTEnableDetailPage(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setGDTEnableUserControl(boolean z2) {
            this.f14093d = z2;
            return this;
        }

        public Builder setGDTMaxVideoDuration(int i2) {
            this.f14095f = i2;
            return this;
        }

        public Builder setGDTMinVideoDuration(int i2) {
            this.f14094e = i2;
            return this;
        }

        public Builder setHeight(int i2) {
            this.f14100k = i2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z2) {
            this.f14102m = z2;
            return this;
        }

        public Builder setWidth(int i2) {
            this.f14099j = i2;
            return this;
        }
    }

    public static final class DownAPPConfirmPolicy {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_NO_CONFIRM = 1;
    }

    public static final class FeedExpressType {
        public static final int FEED_EXPRESS_TYPE_1 = 1;
        public static final int FEED_EXPRESS_TYPE_2 = 2;
    }

    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private GDTExtraOption(Builder builder) {
        this.a = true;
        this.b = true;
        this.f14081c = false;
        this.f14082d = false;
        this.f14083e = 0;
        this.f14090l = 1;
        this.a = builder.a;
        this.b = builder.b;
        this.f14081c = builder.f14092c;
        this.f14082d = builder.f14093d;
        this.f14084f = builder.f14094e;
        this.f14085g = builder.f14095f;
        this.f14083e = builder.f14096g;
        this.f14086h = builder.f14097h;
        this.f14087i = builder.f14098i;
        this.f14088j = builder.f14099j;
        this.f14089k = builder.f14100k;
        this.f14090l = builder.f14101l;
        this.f14091m = builder.f14102m;
    }

    public int getBrowserType() {
        return this.f14086h;
    }

    public int getDownAPPConfirmPolicy() {
        return this.f14087i;
    }

    public int getFeedExpressType() {
        return this.f14090l;
    }

    public int getGDTAutoPlayPolicy() {
        return this.f14083e;
    }

    public int getGDTMaxVideoDuration() {
        return this.f14085g;
    }

    public int getGDTMinVideoDuration() {
        return this.f14084f;
    }

    public GMAdSlotGDTOption.Builder getGMGDTExtraOption() {
        GMAdSlotGDTOption.Builder builder = new GMAdSlotGDTOption.Builder();
        builder.setAutoPlayPolicy(getGDTAutoPlayPolicy());
        builder.setDownAPPConfirmPolicy(getDownAPPConfirmPolicy());
        builder.setGDTAutoPlayMuted(isGDTAutoPlayMuted());
        builder.setGDTDetailPageMuted(isGDTDetailPageMuted());
        builder.setGDTEnableDetailPage(isGDTEnableDetailPage());
        builder.setGDTEnableUserControl(isGDTEnableUserControl());
        builder.setGDTMaxVideoDuration(getGDTMaxVideoDuration());
        builder.setGDTMinVideoDuration(getGDTMinVideoDuration());
        return builder;
    }

    public int getHeight() {
        return this.f14089k;
    }

    public int getWidth() {
        return this.f14088j;
    }

    public boolean isGDTAutoPlayMuted() {
        return this.b;
    }

    public boolean isGDTDetailPageMuted() {
        return this.f14081c;
    }

    public boolean isGDTEnableDetailPage() {
        return this.a;
    }

    public boolean isGDTEnableUserControl() {
        return this.f14082d;
    }

    public boolean isSplashPreLoad() {
        return this.f14091m;
    }
}
