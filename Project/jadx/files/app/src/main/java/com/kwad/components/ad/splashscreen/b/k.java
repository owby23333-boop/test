package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends i implements com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.a {
    private View CR;
    private KsRotateView CS;
    private TextView CU;
    private TextView CV;
    private com.kwad.sdk.core.f.c CW;
    private com.kwad.components.ad.splashscreen.d CX;
    private Runnable CY = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.3
        @Override // java.lang.Runnable
        public final void run() {
            k.this.CW.xP();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void Z(String str) {
        TextView textView = this.CV;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
    }

    @Override // com.kwad.sdk.core.f.a
    public final void ab(final String str) {
        Runnable runnable;
        long j2;
        boolean zRX = this.Cx.BZ.rX();
        boolean zNa = com.kwad.components.core.d.a.b.na();
        if (!zRX || zNa) {
            runnable = this.CY;
            j2 = com.anythink.expressad.d.a.b.aC;
        } else {
            this.CS.lQ();
            com.kwad.components.ad.splashscreen.h hVar = this.Cx;
            if (hVar != null) {
                hVar.a(1, getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.k.2
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                        iVar.cj(str);
                    }
                });
            }
            lt();
            runnable = this.CY;
            j2 = com.anythink.expressad.exoplayer.i.a.f9492f;
        }
        bh.a(runnable, null, j2);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void initView() {
        this.CR = ((ViewStub) findViewById(R.id.ksad_rotate_layout)).inflate();
        this.CU = (TextView) findViewById(R.id.ksad_rotate_text);
        this.CV = (TextView) findViewById(R.id.ksad_rotate_action);
        this.CS = (KsRotateView) findViewById(R.id.ksad_rotate_view);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kL() {
        com.kwad.sdk.core.f.c cVar = this.CW;
        if (cVar != null) {
            cVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void ll() {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        this.CX = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, adInfoCb, hVar.mApkDownloadHelper, 1);
        TextView textView = this.CU;
        if (textView != null) {
            textView.setText(this.CX.getTitle());
        }
        TextView textView2 = this.CV;
        if (textView2 != null) {
            textView2.setText(this.CX.kI());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void lm() {
        View view = this.CR;
        if (view == null || this.Cx == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.b(this.Cx.mAdTemplate, NormalCmdFactory.TASK_RESUME_ALL, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void ln() {
        com.kwad.components.ad.splashscreen.local.b.V(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void lo() {
        AdMatrixInfo.RotateInfo rotateInfoBz = com.kwad.sdk.core.response.a.b.bz(this.Cx.mAdTemplate);
        com.kwad.sdk.core.f.c cVar = this.CW;
        if (cVar != null) {
            cVar.a(rotateInfoBz);
        } else {
            this.CW = new com.kwad.sdk.core.f.c(rotateInfoBz);
            this.CW.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void lp() {
        this.CW.bi(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void lq() {
        this.CS.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.1
            @Override // java.lang.Runnable
            public final void run() {
                k.this.CS.lq();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void lr() {
        if (com.kwad.components.ad.splashscreen.e.c.c(this.Cx)) {
            com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_rotate_action), -1, 60, -1, -1);
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void lv() {
        com.kwad.sdk.core.report.a.az(this.Cx.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("SplashRotatePresenter", "onUnbind");
        com.kwad.sdk.core.f.c cVar = this.CW;
        if (cVar != null) {
            cVar.bj(getContext());
        }
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar != null) {
            hVar.b(this);
        }
    }
}
