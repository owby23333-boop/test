package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d {
    private AnythinkVideoView ag;
    private AnythinkContainerView ah;

    public b(AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i2, boolean z2) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i2, z2);
        this.ag = anythinkVideoView;
        this.ah = anythinkContainerView;
        if (anythinkVideoView == null || anythinkContainerView == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.d, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i2, Object obj) {
        if (this.W) {
            if (i2 == 8) {
                AnythinkContainerView anythinkContainerView = this.ah;
                if (anythinkContainerView == null) {
                    AnythinkVideoView anythinkVideoView = this.ag;
                    if (anythinkVideoView != null) {
                        anythinkVideoView.showAlertView();
                    }
                } else if (anythinkContainerView.showAlertWebView()) {
                    AnythinkVideoView anythinkVideoView2 = this.ag;
                    if (anythinkVideoView2 != null) {
                        anythinkVideoView2.alertWebViewShowed();
                    }
                } else {
                    AnythinkVideoView anythinkVideoView3 = this.ag;
                    if (anythinkVideoView3 != null) {
                        anythinkVideoView3.showAlertView();
                    }
                }
            } else if (i2 != 103 && i2 != 105) {
                if (i2 == 107) {
                    this.ah.showVideoClickView(-1);
                    this.ag.setCover(false);
                    this.ag.videoOperate(1);
                } else if (i2 == 112) {
                    this.ag.setCover(true);
                    this.ag.videoOperate(2);
                } else if (i2 == 115) {
                    this.ah.resizeMiniCard(this.ag.getBorderViewWidth(), this.ag.getBorderViewHeight(), this.ag.getBorderViewRadius());
                } else if (i2 != 100) {
                }
            }
        }
        super.a(i2, obj);
    }
}
