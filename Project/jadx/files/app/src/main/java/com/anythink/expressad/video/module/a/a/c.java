package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.signal.factory.IJSFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {
    private IJSFactory ag;

    public c(IJSFactory iJSFactory, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i2, boolean z2) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i2, z2);
        this.ag = iJSFactory;
        if (iJSFactory == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.d, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i2, Object obj) {
        if (this.W) {
            if (i2 != 8) {
                if (i2 != 103) {
                    if (i2 == 105) {
                        this.ag.getJSNotifyProxy().a(3, obj.toString());
                        i2 = -1;
                    } else if (i2 == 107) {
                        this.ag.getJSContainerModule().showVideoClickView(-1);
                        this.ag.getJSVideoModule().setCover(false);
                        this.ag.getJSVideoModule().videoOperate(1);
                    } else if (i2 == 112) {
                        this.ag.getJSVideoModule().setCover(true);
                        this.ag.getJSVideoModule().videoOperate(2);
                    } else if (i2 == 115) {
                        com.anythink.expressad.video.signal.j jSVideoModule = this.ag.getJSVideoModule();
                        this.ag.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                    } else if (i2 != 100) {
                    }
                }
            } else if (this.ag.getJSContainerModule().showAlertWebView()) {
                this.ag.getJSVideoModule().alertWebViewShowed();
            } else {
                this.ag.getJSVideoModule().showAlertView();
            }
        }
        super.a(i2, obj);
    }
}
