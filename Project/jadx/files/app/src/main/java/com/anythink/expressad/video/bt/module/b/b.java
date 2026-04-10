package com.anythink.expressad.video.bt.module.b;

import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements g {
    private static final String a = "RewardVideoListener";

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void a() {
        o.a(a, "onLoadSuccess:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void b() {
        o.a(a, "onVideoLoadSuccess:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void c() {
        o.a(a, "onAdShow");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void d() {
        o.a(a, "onVideoAdClicked:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void e() {
        o.a(a, "onEndcardShow: ");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void f() {
        o.a(a, "onVideoComplete: ");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void a(String str) {
        o.a(a, "onVideoLoadFail:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void b(String str) {
        o.a(a, "onShowFail:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void a(boolean z2, String str, float f2) {
        o.a(a, "onAdClose:" + z2 + ",RewardName:" + str + ",rewardAmout:" + f2);
    }
}
