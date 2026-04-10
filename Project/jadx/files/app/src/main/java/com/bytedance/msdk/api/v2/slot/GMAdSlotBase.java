package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMAdSlotBase {
    private boolean a;
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected GMAdSlotGDTOption f14322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected GMAdSlotBaiduOption f14323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Map<String, Object> f14324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14329k;

    public static abstract class Builder {
        protected boolean a;
        protected float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected boolean f14330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected GMAdSlotGDTOption f14331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected GMAdSlotBaiduOption f14332e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected String f14334g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected boolean f14336i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected String f14337j;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected Map<String, Object> f14333f = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected int f14335h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r1
  0x000f: PHI (r1v2 float) = (r1v0 float), (r1v1 float) binds: [B:3:0x000d, B:6:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected GMAdSlotBase(com.bytedance.msdk.api.v2.slot.GMAdSlotBase.Builder r4) {
        /*
            r3 = this;
            r3.<init>()
            boolean r0 = r4.a
            r3.a = r0
            float r0 = r4.b
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L12
        Lf:
            r4.b = r1
            goto L18
        L12:
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L18
            goto Lf
        L18:
            float r0 = r4.b
            r3.b = r0
            boolean r0 = r4.f14330c
            r3.f14321c = r0
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r0 = r4.f14331d
            if (r0 == 0) goto L25
            goto L2e
        L25:
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption$Builder r0 = new com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption$Builder
            r0.<init>()
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r0 = r0.build()
        L2e:
            r3.f14322d = r0
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r0 = r4.f14332e
            if (r0 == 0) goto L35
            goto L3e
        L35:
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption$Builder r0 = new com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption$Builder
            r0.<init>()
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r0 = r0.build()
        L3e:
            r3.f14323e = r0
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.f14333f
            r3.f14324f = r0
            java.lang.String r0 = r4.f14334g
            r3.f14325g = r0
            int r0 = r4.f14335h
            r3.f14326h = r0
            boolean r0 = r4.f14336i
            r3.f14327i = r0
            java.lang.String r4 = r4.f14337j
            r3.f14328j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.v2.slot.GMAdSlotBase.<init>(com.bytedance.msdk.api.v2.slot.GMAdSlotBase$Builder):void");
    }

    public TTVideoOption createTTVideoOption(boolean z2) {
        TTVideoOption.Builder builder = new TTVideoOption.Builder();
        builder.setMuted(isMuted());
        builder.setAdmobAppVolume(getVolume());
        builder.useSurfaceView(isUseSurfaceView());
        GMAdSlotGDTOption gMAdSlotGDTOption = getGMAdSlotGDTOption();
        if (gMAdSlotGDTOption != null) {
            builder.setGDTExtraOption(gMAdSlotGDTOption.getGDTExtraOption(z2));
        }
        GMAdSlotBaiduOption gMAdSlotBaiduOption = getGMAdSlotBaiduOption();
        if (gMAdSlotGDTOption != null) {
            builder.setBaiduExtraOption(gMAdSlotBaiduOption.getBaiduExtra());
        }
        return builder.build();
    }

    @Deprecated
    public int getDownloadType() {
        return this.f14326h;
    }

    public GMAdSlotBaiduOption getGMAdSlotBaiduOption() {
        return this.f14323e;
    }

    public GMAdSlotGDTOption getGMAdSlotGDTOption() {
        return this.f14322d;
    }

    @Deprecated
    public int getNetWorkNum() {
        return this.f14329k;
    }

    @Nullable
    public Map<String, Object> getParams() {
        return this.f14324f;
    }

    public String getScenarioId() {
        return this.f14328j;
    }

    public TTRequestExtraParams getTTRequestExtraParams() {
        TTRequestExtraParams tTRequestExtraParams = new TTRequestExtraParams();
        if (getParams() != null && getParams().size() > 0) {
            tTRequestExtraParams.getExtraObject().putAll(getParams());
        }
        return tTRequestExtraParams;
    }

    public String getTestSlotId() {
        return this.f14325g;
    }

    public float getVolume() {
        return this.b;
    }

    public boolean isBidNotify() {
        return this.f14327i;
    }

    public boolean isMuted() {
        return this.a;
    }

    public boolean isUseSurfaceView() {
        return this.f14321c;
    }

    @Deprecated
    public void setNetWorkNum(String str) {
        this.f14329k = t.a(str);
    }
}
