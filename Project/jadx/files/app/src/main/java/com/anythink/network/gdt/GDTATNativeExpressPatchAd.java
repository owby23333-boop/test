package com.anythink.network.gdt;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATNativeExpressPatchAd extends GDTATNativeExpressAd {
    protected GDTATNativeExpressPatchAd(Context context, String str, int i2, int i3, int i4, int i5, int i6, String str2) {
        super(context, str, i2, i3, i4, i5, i6, str2);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }
}
