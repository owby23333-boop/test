package com.bytedance.msdk.api.v2.slot;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdSlotDraw extends GMAdSlotBase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f14340n;

    public static class Builder extends GMAdSlotBase.Builder {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14341k = 640;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14342l = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f14343m = 1;

        public GMAdSlotDraw build() {
            return new GMAdSlotDraw(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[PHI: r0
  0x0003: PHI (r0v2 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0001, B:6:0x0007] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.api.v2.slot.GMAdSlotDraw.Builder setAdCount(int r2) {
            /*
                r1 = this;
                r0 = 1
                if (r2 >= r0) goto L6
            L3:
                r1.f14343m = r0
                goto Lc
            L6:
                r0 = 3
                if (r2 <= r0) goto La
                goto L3
            La:
                r1.f14343m = r2
            Lc:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.v2.slot.GMAdSlotDraw.Builder.setAdCount(int):com.bytedance.msdk.api.v2.slot.GMAdSlotDraw$Builder");
        }

        public Builder setBidNotify(boolean z2) {
            this.f14336i = z2;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f14333f;
            if (map != null) {
                map.put(str, obj);
            }
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
            this.f14341k = i2;
            this.f14342l = i3;
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
        public Builder setTestSlotId(String str) {
            this.f14334g = str;
            return this;
        }
    }

    private GMAdSlotDraw(Builder builder) {
        super(builder);
        this.f14338l = builder.f14341k;
        this.f14339m = builder.f14342l;
        this.f14340n = builder.f14343m;
    }

    public int getAdCount() {
        return this.f14340n;
    }

    public int getHeight() {
        return this.f14339m;
    }

    public int getWidth() {
        return this.f14338l;
    }
}
