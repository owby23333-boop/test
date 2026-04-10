package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX INFO: loaded from: classes2.dex */
public class TTATNativePatchAd extends TTATNativeAd {
    public TTATNativePatchAd(Context context, String str, TTNativeAd tTNativeAd, boolean z2, Bitmap bitmap, int i2) {
        super(context, str, tTNativeAd, z2, bitmap, i2);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }

    @Override // com.anythink.network.toutiao.TTATNativeAd
    public void setAdData(boolean z2, Bitmap bitmap, int i2) {
        super.setAdData(z2, bitmap, i2);
    }
}
