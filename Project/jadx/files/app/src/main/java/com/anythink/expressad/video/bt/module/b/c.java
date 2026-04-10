package com.anythink.expressad.video.bt.module.b;

import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class c implements h {
    private static final String a = "ShowRewardListener";

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a() {
        o.a(a, "onAdShow");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void b() {
        o.a(a, "onVideoComplete: ");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void c() {
        o.a(a, "onEndcardShow: ");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(boolean z2, com.anythink.expressad.videocommon.c.c cVar) {
        o.a(a, "onAdClose:isCompleteView:" + z2 + ",reward:" + cVar);
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(String str) {
        o.a(a, "onShowFail:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(com.anythink.expressad.foundation.d.c cVar) {
        o.a(a, "onVideoAdClicked:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(boolean z2, int i2) {
        o.a(a, "onAdCloseWithIVReward: " + z2 + "  " + i2);
    }
}
