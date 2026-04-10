package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;

/* JADX INFO: loaded from: classes2.dex */
public class de extends dm {
    private FullScreenVideoAd.FullScreenVideoAdListener a;

    public de(Context context, String str, boolean z2) {
        super(context, str, z2, IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
    }

    @Override // com.baidu.mobads.sdk.internal.dm
    public void a(ScreenVideoAdListener screenVideoAdListener) {
        super.a(screenVideoAdListener);
        if (screenVideoAdListener instanceof FullScreenVideoAd.FullScreenVideoAdListener) {
            this.a = (FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.dm, com.baidu.mobads.sdk.internal.bf
    protected void f(String str) {
        FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener = this.a;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }
}
