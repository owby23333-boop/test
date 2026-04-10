package com.kwad.components.core.webview.a.b;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.a.x;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.g;
import com.kwad.sdk.utils.bc;

/* JADX INFO: loaded from: classes3.dex */
public class c extends a {
    private FrameLayout PC;
    private String Vk;
    private p Vo;
    private ae Vp;
    private com.kwad.components.core.webview.a.d.d Vq = new com.kwad.components.core.webview.a.d.d() { // from class: com.kwad.components.core.webview.a.b.c.2
        @Override // com.kwad.components.core.webview.a.d.d
        public final void gs() {
            if (c.this.Vp != null) {
                c.this.Vp.rr();
                c.this.Vp.rs();
            }
        }

        @Override // com.kwad.components.core.webview.a.d.d
        public final void gy() {
            if (c.this.Vp != null) {
                c.this.Vp.rt();
                c.this.Vp.ru();
            }
        }
    };
    private d mTkDialogFragment;

    /* JADX INFO: Access modifiers changed from: private */
    public void rB() {
        d.a aVar = this.Vi.Vn;
        if (aVar != null) {
            aVar.gr();
        }
        com.kwad.components.core.webview.a.c.a.rE().aJ(getTkTemplateId());
        g gVar = this.Vi.Vl;
        if (gVar != null) {
            gVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a
    protected final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.Vi;
        this.Vk = bVar2.Vk;
        this.mTkDialogFragment = bVar2.mTkDialogFragment;
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.a(this.Vq);
        }
        if (this.Vi.Vl != null) {
            this.mTKLoadController.setTKBridgeHandler(new com.kwad.sdk.core.webview.b.g() { // from class: com.kwad.components.core.webview.a.b.c.1
                @Override // com.kwad.sdk.core.webview.b.g
                public final void callTKBridge(String str) {
                    c.this.Vi.Vl.callTKBridge(str);
                }
            });
            this.Vi.Vl.a(this.mTKLoadController);
            this.mTKLoadController.addCustomEnv("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public FrameLayout getTKContainer() {
        return this.PC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public String getTkTemplateId() {
        b bVar = this.Vi;
        StyleTemplate styleTemplate = bVar.mStyleTemplate;
        return styleTemplate != null ? styleTemplate.templateId : i.b(this.Vk, bVar.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public void onCloseTKDialogClick() {
        super.onCloseTKDialogClick();
        b bVar = this.Vi;
        if (bVar.Vm) {
            com.kwad.components.core.webview.a.d.c cVar = bVar.Ps;
            if (cVar != null) {
                cVar.J(true);
                return;
            }
            return;
        }
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.webview.a.d.c cVar2 = this.Vi.Ps;
        if (cVar2 != null) {
            cVar2.gz();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.PC = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        aVar.width = (int) ((bc.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((bc.getScreenHeight(getContext()) / fAG) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterLifecycleLisener(ae aeVar) {
        this.Vp = aeVar;
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
        this.Vo = pVar;
        long j2 = this.Vi.mPlayedDuration;
        if (this.Vo == null || j2 <= 0) {
            return;
        }
        x xVar = new x();
        xVar.nW = (int) ((j2 / 1000.0f) + 0.5f);
        this.Vo.a(xVar);
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public void onSkipClick(s sVar) {
        super.onSkipClick(sVar);
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.webview.a.d.c cVar = this.Vi.Ps;
        if (cVar != null) {
            cVar.J(true);
        }
    }

    public void onTkLoadFailed() {
        d dVar = this.mTkDialogFragment;
        if (dVar == null) {
            rB();
            return;
        }
        if (dVar.isShowing()) {
            this.mTkDialogFragment.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.a.b.c.3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    c.this.mTkDialogFragment.e(this);
                    c.this.rB();
                }
            });
        } else {
            rB();
        }
        this.mTkDialogFragment.dismiss();
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onTkLoadSuccess() {
        g gVar = this.Vi.Vl;
        if (gVar != null) {
            gVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        g gVar = this.Vi.Vl;
        if (gVar != null) {
            gVar.callbackDialogDismiss();
        }
    }
}
