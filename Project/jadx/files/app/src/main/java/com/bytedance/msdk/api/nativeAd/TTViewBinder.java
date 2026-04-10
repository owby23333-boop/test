package com.bytedance.msdk.api.nativeAd;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TTViewBinder extends GMViewBinder {

    public static class Builder extends GMViewBinder.Builder {
        public Builder(int i2) {
            super(i2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder addExtra(String str, int i2) {
            this.f14306n.put(str, Integer.valueOf(i2));
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.f14306n = new HashMap(map);
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public /* bridge */ /* synthetic */ GMViewBinder.Builder addExtras(Map map) {
            return addExtras((Map<String, Integer>) map);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public TTViewBinder build() {
            return new TTViewBinder(this);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder callToActionId(int i2) {
            this.f14296d = i2;
            return this;
        }

        @Deprecated
        public final Builder decriptionTextId(int i2) {
            this.f14295c = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder descriptionTextId(int i2) {
            this.f14295c = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder groupImage1Id(int i2) {
            this.f14302j = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder groupImage2Id(int i2) {
            this.f14303k = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder groupImage3Id(int i2) {
            this.f14304l = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder iconImageId(int i2) {
            this.f14297e = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder logoLayoutId(int i2) {
            this.f14301i = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder mainImageId(int i2) {
            this.f14298f = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder mediaViewIdId(int i2) {
            this.f14299g = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public final Builder sourceId(int i2) {
            this.f14300h = i2;
            return this;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder.Builder
        @NonNull
        public Builder titleId(int i2) {
            this.b = i2;
            return this;
        }
    }

    private TTViewBinder(@NonNull Builder builder) {
        super(builder);
    }
}
