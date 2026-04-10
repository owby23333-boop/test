package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* JADX INFO: loaded from: classes3.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);

    private int value;

    EcOrderCardStyle(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (!(com.kwad.components.ad.reward.a.b.k(adInfo) || com.kwad.components.ad.reward.a.b.j(adInfo))) {
            return null;
        }
        AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfo);
        boolean zHasSpike = adProductInfoCV.hasSpike();
        boolean zHasCoupon = adProductInfoCV.hasCoupon();
        boolean zHasOriginalPrice = adProductInfoCV.hasOriginalPrice();
        if (zHasSpike && zHasCoupon) {
            return SPIKE_AND_COUPON;
        }
        if (zHasSpike) {
            return SPIKE;
        }
        if (zHasCoupon) {
            return COUPON;
        }
        if (zHasOriginalPrice) {
            return NO_SPIKE_AND_NO_COUPON;
        }
        return DEFAULT;
    }
}
