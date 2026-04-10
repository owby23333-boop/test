package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f1459a;
        protected int dl;
        protected int e;
        protected int fo;
        protected int g;
        protected int gc;
        protected int gz;
        protected int i;
        protected int kb;
        protected int m;
        protected int uy;
        protected Map<String, Integer> v;
        protected int wp;
        protected int z;

        public Builder(int i) {
            this.v = Collections.emptyMap();
            this.z = i;
            this.v = new HashMap();
        }

        public Builder titleId(int i) {
            this.g = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.fo = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.uy = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.kb = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.wp = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.m = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.gz = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.e = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.dl = i;
            return this;
        }

        public Builder callToActionId(int i) {
            this.f1459a = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.gc = i;
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.v = new HashMap(map);
            return this;
        }

        public Builder addExtra(String str, int i) {
            this.v.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.i = i;
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }
    }

    protected MediationViewBinder(Builder builder) {
        this.layoutId = builder.z;
        this.titleId = builder.g;
        this.decriptionTextId = builder.dl;
        this.callToActionId = builder.f1459a;
        this.iconImageId = builder.gc;
        this.mainImageId = builder.m;
        this.mediaViewId = builder.e;
        this.sourceId = builder.gz;
        this.extras = builder.v;
        this.groupImage1Id = builder.uy;
        this.groupImage2Id = builder.kb;
        this.groupImage3Id = builder.wp;
        this.logoLayoutId = builder.fo;
        this.shakeViewContainerId = builder.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }
}
