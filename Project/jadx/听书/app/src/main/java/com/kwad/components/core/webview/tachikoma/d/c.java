package com.kwad.components.core.webview.tachikoma.d;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.br;

/* JADX INFO: loaded from: classes3.dex */
public class c extends a {
    private String AI;
    private FrameLayout Yp;
    private e afi;
    private p ahv;
    private az ahw;
    private com.kwad.components.core.webview.tachikoma.f.e ahx = new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.c.2
        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void ha() {
            if (c.this.ahw != null) {
                c.this.ahw.uF();
                c.this.ahw.uG();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void hi() {
            if (c.this.ahw != null) {
                c.this.ahw.uH();
                c.this.ahw.uI();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0354a c0354a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Yp = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        e eVar = this.afi;
        if (eVar != null) {
            eVar.a(this.ahx);
        }
        if (this.ahp.ahr != null) {
            this.fU.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.d.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.ahp.ahr.callTKBridge(str);
                }
            });
            this.ahp.ahr.a(this.fU);
            this.fU.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a
    protected final void a(b bVar) {
        super.a(bVar);
        this.AI = this.ahp.AI;
        this.afi = this.ahp.afi;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.Yp;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.Yp.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height == 0.0f || width == 0.0f) {
            aVar.width = (int) ((br.getScreenWidth(getContext()) / fBj) + 0.5f);
            aVar.height = (int) ((br.getScreenHeight(getContext()) / fBj) + 0.5f);
        } else {
            aVar.width = (int) ((width / fBj) + 0.5f);
            aVar.height = (int) ((height / fBj) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.ahv = pVar;
        long j = this.ahp.AO;
        if (this.ahv == null || j <= 0) {
            return;
        }
        z zVar = new z();
        zVar.qz = (int) ((j / 1000.0f) + 0.5f);
        this.ahv.a(zVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
        super.aA();
        if (this.ahp.aht) {
            if (this.ahp.Yd != null) {
                this.ahp.Yd.G(true);
            }
        } else {
            e eVar = this.afi;
            if (eVar != null) {
                eVar.dismiss();
            }
            if (this.ahp.Yd != null) {
                this.ahp.Yd.hj();
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.ahw = azVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        e eVar = this.afi;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (this.ahp.Yd != null) {
            this.ahp.Yd.G(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        if (this.ahp.ahr != null) {
            this.ahp.ahr.callbackDialogDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        if (this.ahp.Yf != null) {
            return this.ahp.Yf.templateId;
        }
        return this.AI;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.Yp;
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.afi;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.afi.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.d.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.afi.e(this);
                        c.this.vF();
                    }
                });
            } else {
                vF();
            }
            this.afi.dismiss();
            return;
        }
        vF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF() {
        if (this.ahp.ahu != null) {
            this.ahp.ahu.hc();
        }
        com.kwad.components.core.webview.tachikoma.e.c.vO().t(getTkTemplateId(), getTKReaderScene());
        if (this.ahp.ahr != null) {
            this.ahp.ahr.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        if (this.ahp.ahr != null) {
            this.ahp.ahr.callbackPageStatus(true, null);
        }
    }
}
