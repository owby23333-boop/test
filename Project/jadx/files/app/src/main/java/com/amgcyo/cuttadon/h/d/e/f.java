package com.amgcyo.cuttadon.h.d.e;

import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.bytedance.msdk.api.v2.GMDislikeCallback;

/* JADX INFO: compiled from: AdBannerManager.java */
/* JADX INFO: loaded from: classes.dex */
class f implements GMDislikeCallback {
    final /* synthetic */ AdFrameLayout a;
    final /* synthetic */ e b;

    f(e eVar, AdFrameLayout adFrameLayout) {
        this.b = eVar;
        this.a = adFrameLayout;
    }

    @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
    public void onCancel() {
        this.b.a("dislike 点击了取消");
    }

    @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
    public void onRefuse() {
    }

    @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
    public void onSelected(int i2, String str) {
        this.b.a("点击：" + str);
        this.b.a(this.a);
    }

    @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
    public void onShow() {
    }
}
