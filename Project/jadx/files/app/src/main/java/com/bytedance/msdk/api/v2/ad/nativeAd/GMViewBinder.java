package com.bytedance.msdk.api.v2.ad.nativeAd;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;

    @NonNull
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    public static class Builder {
        protected int a;
        protected int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f14295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected int f14296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected int f14297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f14298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected int f14299g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected int f14300h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected int f14301i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected int f14302j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected int f14303k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        protected int f14304l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        protected int f14305m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @NonNull
        protected Map<String, Integer> f14306n;

        public Builder(int i2) {
            this.f14306n = Collections.emptyMap();
            this.a = i2;
            this.f14306n = new HashMap();
        }

        @NonNull
        public Builder addExtra(String str, int i2) {
            this.f14306n.put(str, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder addExtras(Map<String, Integer> map) {
            this.f14306n = new HashMap(map);
            return this;
        }

        @NonNull
        public GMViewBinder build() {
            return new GMViewBinder(this);
        }

        @NonNull
        public Builder callToActionId(int i2) {
            this.f14296d = i2;
            return this;
        }

        @NonNull
        public Builder descriptionTextId(int i2) {
            this.f14295c = i2;
            return this;
        }

        @NonNull
        public Builder groupImage1Id(int i2) {
            this.f14302j = i2;
            return this;
        }

        @NonNull
        public Builder groupImage2Id(int i2) {
            this.f14303k = i2;
            return this;
        }

        @NonNull
        public Builder groupImage3Id(int i2) {
            this.f14304l = i2;
            return this;
        }

        @NonNull
        public Builder iconImageId(int i2) {
            this.f14297e = i2;
            return this;
        }

        @NonNull
        public Builder logoLayoutId(int i2) {
            this.f14301i = i2;
            return this;
        }

        @NonNull
        public Builder mainImageId(int i2) {
            this.f14298f = i2;
            return this;
        }

        @NonNull
        public Builder mediaViewIdId(int i2) {
            this.f14299g = i2;
            return this;
        }

        @NonNull
        public Builder shakeViewContainerId(int i2) {
            this.f14305m = i2;
            return this;
        }

        @NonNull
        public Builder sourceId(int i2) {
            this.f14300h = i2;
            return this;
        }

        @NonNull
        public Builder titleId(int i2) {
            this.b = i2;
            return this;
        }
    }

    protected GMViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.a;
        this.titleId = builder.b;
        this.decriptionTextId = builder.f14295c;
        this.callToActionId = builder.f14296d;
        this.iconImageId = builder.f14297e;
        this.mainImageId = builder.f14298f;
        this.mediaViewId = builder.f14299g;
        this.sourceId = builder.f14300h;
        this.extras = builder.f14306n;
        this.groupImage1Id = builder.f14302j;
        this.groupImage2Id = builder.f14303k;
        this.groupImage3Id = builder.f14304l;
        this.logoLayoutId = builder.f14301i;
        this.shakeViewContainerId = builder.f14305m;
    }
}
