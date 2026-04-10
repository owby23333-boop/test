package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class VideoOption {
    private final boolean a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f17708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f17709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f17710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f17713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f17714i;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {
        private boolean a = true;
        private int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17715c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f17716d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17717e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f17718f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f17719g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f17720h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f17721i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z2) {
            this.a = z2;
            return this;
        }

        public Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                i2 = 1;
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.b = i2;
            return this;
        }

        public Builder setDetailPageMuted(boolean z2) {
            this.f17719g = z2;
            return this;
        }

        public Builder setEnableDetailPage(boolean z2) {
            this.f17717e = z2;
            return this;
        }

        public Builder setEnableUserControl(boolean z2) {
            this.f17718f = z2;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f17720h = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f17721i = i2;
            return this;
        }

        public Builder setNeedCoverImage(boolean z2) {
            this.f17716d = z2;
            return this;
        }

        public Builder setNeedProgressBar(boolean z2) {
            this.f17715c = z2;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f17708c = builder.f17715c;
        this.f17709d = builder.f17716d;
        this.f17710e = builder.f17717e;
        this.f17711f = builder.f17718f;
        this.f17712g = builder.f17719g;
        this.f17713h = builder.f17720h;
        this.f17714i = builder.f17721i;
    }

    public boolean getAutoPlayMuted() {
        return this.a;
    }

    public int getAutoPlayPolicy() {
        return this.b;
    }

    public int getMaxVideoDuration() {
        return this.f17713h;
    }

    public int getMinVideoDuration() {
        return this.f17714i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f17712g));
        } catch (Exception e2) {
            GDTLogger.d("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f17712g;
    }

    public boolean isEnableDetailPage() {
        return this.f17710e;
    }

    public boolean isEnableUserControl() {
        return this.f17711f;
    }

    public boolean isNeedCoverImage() {
        return this.f17709d;
    }

    public boolean isNeedProgressBar() {
        return this.f17708c;
    }
}
