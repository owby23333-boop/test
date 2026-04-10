package com.anythink.expressad.video.signal.a;

import android.content.res.Configuration;
import com.anythink.expressad.video.module.AnythinkContainerView;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AnythinkContainerView f11950k;

    public k(AnythinkContainerView anythinkContainerView) {
        this.f11950k = anythinkContainerView;
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void configurationChanged(int i2, int i3, int i4) {
        super.configurationChanged(i2, i3, i4);
        try {
            if (this.f11950k != null) {
                this.f11950k.configurationChanged(i2, i3, i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean endCardShowing() {
        try {
            if (this.f11950k != null) {
                return this.f11950k.endCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void hideAlertWebview() {
        super.hideAlertWebview();
        AnythinkContainerView anythinkContainerView = this.f11950k;
        if (anythinkContainerView != null) {
            anythinkContainerView.hideAlertWebview();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void install(com.anythink.expressad.foundation.d.c cVar) {
        super.install(cVar);
        try {
            if (this.f11950k != null) {
                this.f11950k.install(cVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        AnythinkContainerView anythinkContainerView = this.f11950k;
        if (anythinkContainerView != null) {
            anythinkContainerView.ivRewardAdsWithoutVideo(str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean miniCardLoaded() {
        try {
            if (this.f11950k != null) {
                return this.f11950k.miniCardLoaded();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardLoaded();
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean miniCardShowing() {
        try {
            if (this.f11950k != null) {
                return this.f11950k.miniCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void orientation(Configuration configuration) {
        super.orientation(configuration);
        try {
            if (this.f11950k != null) {
                this.f11950k.orientation(configuration);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.f
    public final void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        super.preLoadData(bVar);
        try {
            if (this.f11950k != null) {
                this.f11950k.preLoadData(bVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public final void readyStatus(int i2) {
        try {
            if (this.f11950k != null) {
                this.f11950k.readyStatus(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i2);
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void resizeMiniCard(int i2, int i3, int i4) {
        super.resizeMiniCard(i2, i3, i4);
        try {
            if (this.f11950k != null) {
                this.f11950k.resizeMiniCard(i2, i3, i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean showAlertWebView() {
        super.showAlertWebView();
        AnythinkContainerView anythinkContainerView = this.f11950k;
        if (anythinkContainerView != null) {
            return anythinkContainerView.showAlertWebView();
        }
        return false;
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showEndcard(int i2) {
        super.showEndcard(i2);
        try {
            if (this.f11950k != null) {
                this.f11950k.showEndcard(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showMiniCard(int i2, int i3, int i4, int i5, int i6) {
        super.showMiniCard(i2, i3, i4, i5, i6);
        try {
            if (this.f11950k != null) {
                this.f11950k.showMiniCard(i2, i3, i4, i5, i6);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showPlayableView() {
        super.showPlayableView();
        try {
            if (this.f11950k != null) {
                this.f11950k.showPlayableView();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showVideoClickView(int i2) {
        super.showVideoClickView(i2);
        AnythinkContainerView anythinkContainerView = this.f11950k;
        if (anythinkContainerView != null) {
            anythinkContainerView.showVideoClickView(i2);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void toggleCloseBtn(int i2) {
        super.toggleCloseBtn(i2);
        try {
            if (this.f11950k != null) {
                this.f11950k.toggleCloseBtn(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void webviewshow() {
        super.webviewshow();
        try {
            if (this.f11950k != null) {
                this.f11950k.webviewshow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
