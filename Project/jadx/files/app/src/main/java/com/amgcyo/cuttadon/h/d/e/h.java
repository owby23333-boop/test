package com.amgcyo.cuttadon.h.d.e;

import android.widget.FrameLayout;
import com.bytedance.msdk.api.v2.GMDislikeCallback;

/* JADX INFO: compiled from: AdFeedManager.java */
/* JADX INFO: loaded from: classes.dex */
class h implements GMDislikeCallback {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ g b;

    h(g gVar, FrameLayout frameLayout) {
        this.b = gVar;
        this.a = frameLayout;
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
        this.b.a("点击 " + str);
        this.b.a(this.a);
    }

    @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
    public void onShow() {
    }
}
