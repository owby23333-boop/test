package com.anythink.network.gdt;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATNativePatchAd extends GDTATNativeAd {
    protected GDTATNativePatchAd(Context context, NativeUnifiedADData nativeUnifiedADData, int i2, int i3, int i4) {
        super(context, nativeUnifiedADData, i2, i3, i4);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }
}
