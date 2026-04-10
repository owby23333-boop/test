package com.kwad.components.ad.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bg;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    private FrameLayout cV;
    private boolean cW;
    private az cX;
    private o cY;
    private boolean cp;
    private Context mContext;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    public a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_full_tk_card_view);
        this.cV = frameLayout;
        a((ViewGroup) frameLayout.getParent());
    }

    private void a(ViewGroup viewGroup) {
        if (e.FK() || e.FJ() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0364a() { // from class: com.kwad.components.ad.c.d.a.1
            @Override // com.kwad.components.core.widget.a.InterfaceC0364a
            public final void aa() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0364a
            public final void ab() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0364a
            public final void onWindowFocusChanged(boolean z) {
                if (a.this.cX != null) {
                    if (z) {
                        a.this.cX.uJ();
                        n nVar = new n();
                        if (a.this.cW) {
                            a aVar2 = a.this;
                            nVar.ahg = !aVar2.f(aVar2.cD.mAdTemplate.mIsAudioEnable);
                        } else {
                            nVar.ahg = false;
                        }
                        a.this.cY.c(nVar);
                        return;
                    }
                    a aVar3 = a.this;
                    aVar3.f(aVar3.cD.mAdTemplate.mIsAudioEnable);
                    a.this.cX.uK();
                }
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0364a
            public final void c(View view) {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0364a
            public final void ay() {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
            }
        });
        aVar.vU();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cr(this.cD.mAdTemplate).bannerTKInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cV;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        super.onUnbind();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        this.cV.setVisibility(8);
        this.cD.bO = true;
        this.cD.bI.Z();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        if (this.cD.bO) {
            return;
        }
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uJ();
            this.cX.uF();
            this.cX.uG();
        }
        this.cV.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cD.bH.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cD.bH.getHeight());
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.cX = azVar;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, (com.kwad.components.core.e.d.c) null, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.c.d.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.cD.bH.post(new bg() { // from class: com.kwad.components.ad.c.d.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.cD.X();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.cX.uI();
        this.cD.bH.removeAllViews();
        onDestroy();
        this.cD.Y();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.cY = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.c.d.a.3
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            public final boolean isMuted() {
                boolean z;
                try {
                    if (e.FL() || !com.kwad.components.core.t.a.aC(a.this.cD.mContext).sW()) {
                        if ((a.this.cD.bJ instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) a.this.cD.bJ).getVideoSoundValue() != 0) {
                            z = !a.this.cD.bJ.isVideoSoundEnable();
                        } else {
                            z = !com.kwad.sdk.core.response.b.a.bX(com.kwad.sdk.core.response.b.e.el(a.this.cD.mAdTemplate));
                        }
                    }
                    if (a.this.cD.mAdTemplate != null) {
                        a.this.cD.mAdTemplate.mIsAudioEnable = z ? false : true;
                    }
                    a.this.cW = z;
                    return z;
                } catch (Throwable unused) {
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
            return false;
        }
        if (!e.FL()) {
            if (com.kwad.components.core.t.a.aC(this.mContext).sX()) {
                return !com.kwad.components.core.t.a.aC(this.mContext).sW();
            }
            return com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }
}
