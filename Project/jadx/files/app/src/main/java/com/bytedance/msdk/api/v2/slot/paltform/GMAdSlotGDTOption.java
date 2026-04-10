package com.bytedance.msdk.api.v2.slot.paltform;

import android.widget.FrameLayout;
import com.bytedance.msdk.api.GDTExtraOption;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotGDTOption {
    private boolean a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f14430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout.LayoutParams f14432i;

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
        private boolean f14433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14435e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f14436f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f14437g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f14438h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private FrameLayout.LayoutParams f14439i;

        public final GMAdSlotGDTOption build() {
            return new GMAdSlotGDTOption(this);
        }

        public Builder setAutoPlayPolicy(int i2) {
            this.f14437g = i2;
            return this;
        }

        public Builder setDownAPPConfirmPolicy(int i2) {
            this.f14438h = i2;
            return this;
        }

        public Builder setGDTAutoPlayMuted(boolean z2) {
            this.b = z2;
            return this;
        }

        public Builder setGDTDetailPageMuted(boolean z2) {
            this.f14433c = z2;
            return this;
        }

        public Builder setGDTEnableDetailPage(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setGDTEnableUserControl(boolean z2) {
            this.f14434d = z2;
            return this;
        }

        public Builder setGDTMaxVideoDuration(int i2) {
            this.f14436f = i2;
            return this;
        }

        public Builder setGDTMinVideoDuration(int i2) {
            this.f14435e = i2;
            return this;
        }

        public Builder setNativeAdLogoParams(FrameLayout.LayoutParams layoutParams) {
            this.f14439i = layoutParams;
            return this;
        }
    }

    public static final class DownAPPConfirmPolicy {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_NO_CONFIRM = 1;
    }

    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private GMAdSlotGDTOption(Builder builder) {
        this.a = true;
        this.b = true;
        this.f14426c = false;
        this.f14427d = false;
        this.f14428e = 0;
        this.a = builder.a;
        this.b = builder.b;
        this.f14426c = builder.f14433c;
        this.f14427d = builder.f14434d;
        this.f14429f = builder.f14435e;
        this.f14430g = builder.f14436f;
        this.f14428e = builder.f14437g;
        this.f14431h = builder.f14438h;
        this.f14432i = builder.f14439i;
    }

    public int getDownAPPConfirmPolicy() {
        return this.f14431h;
    }

    public int getGDTAutoPlayPolicy() {
        return this.f14428e;
    }

    public GDTExtraOption getGDTExtraOption(boolean z2) {
        GDTExtraOption.Builder builder = new GDTExtraOption.Builder();
        builder.setAutoPlayPolicy(getGDTAutoPlayPolicy());
        builder.setDownAPPConfirmPolicy(getDownAPPConfirmPolicy());
        builder.setGDTAutoPlayMuted(isGDTAutoPlayMuted());
        builder.setGDTDetailPageMuted(isGDTDetailPageMuted());
        builder.setGDTEnableDetailPage(isGDTEnableDetailPage());
        builder.setGDTEnableUserControl(isGDTEnableUserControl());
        builder.setGDTMaxVideoDuration(getGDTMaxVideoDuration());
        builder.setGDTMinVideoDuration(getGDTMinVideoDuration());
        builder.setSplashPreLoad(z2);
        return builder.build();
    }

    public int getGDTMaxVideoDuration() {
        return this.f14430g;
    }

    public int getGDTMinVideoDuration() {
        return this.f14429f;
    }

    public FrameLayout.LayoutParams getNativeAdLogoParams() {
        return this.f14432i;
    }

    public boolean isGDTAutoPlayMuted() {
        return this.b;
    }

    public boolean isGDTDetailPageMuted() {
        return this.f14426c;
    }

    public boolean isGDTEnableDetailPage() {
        return this.a;
    }

    public boolean isGDTEnableUserControl() {
        return this.f14427d;
    }
}
