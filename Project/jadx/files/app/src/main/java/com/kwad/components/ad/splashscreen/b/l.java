package com.kwad.components.ad.splashscreen.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends e implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private static long jY = 400;
    private com.kwad.components.ad.splashscreen.e.a CL;
    private com.kwad.components.ad.splashscreen.d CX;
    private boolean Co;
    private ViewGroup Db;
    private KsShakeView Dc;
    private TextView Dd;
    private com.kwad.sdk.core.f.d ee;
    private Vibrator ef;

    private void ls() {
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.CL;
            if (aVar == null) {
                this.CL = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cx.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.l.2
                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void aa(String str) {
                        if (l.this.Dd != null) {
                            l.this.Dd.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.d.b.c cVar = this.Cx.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.CL);
            }
        }
    }

    private void lw() {
        TextView textView = this.Dd;
        if (textView != null) {
            textView.setText(this.CX.kI());
        }
        KsShakeView ksShakeView = this.Dc;
        if (ksShakeView != null) {
            ksShakeView.ah(this.CX.kJ());
        }
        if (com.kwad.components.ad.splashscreen.e.c.c(this.Cx)) {
            com.kwad.components.ad.splashscreen.e.c.a(this.Dd, -1, 60, -1, -1);
        }
    }

    private void lx() {
        ViewGroup viewGroup = this.Db;
        if (viewGroup == null || this.Cx == null) {
            return;
        }
        viewGroup.setVisibility(0);
        com.kwad.sdk.core.report.a.b(this.Cx.mAdTemplate, NormalCmdFactory.TASK_CANCEL_ALL, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(final double d2) {
        boolean zNa = com.kwad.components.core.d.a.b.na();
        if (!this.Cx.BZ.rX() || zNa) {
            bh.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.3
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.ee.xP();
                }
            }, null, 500L);
        } else {
            this.Dc.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.b.l.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    l lVar = l.this;
                    com.kwad.components.ad.splashscreen.h hVar = lVar.Cx;
                    if (hVar != null) {
                        hVar.a(1, lVar.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.l.4.1
                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                                iVar.i(d2);
                            }
                        });
                    }
                    l.this.Dc.lR();
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.4.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                            l.this.ee.xP();
                        }
                    }, null, 500L);
                }
            });
            bh.a(getContext(), this.ef);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.a.b.dc(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate)) && (hVar = this.Cx) != null) {
            hVar.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar == null) {
            return;
        }
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.h hVar2 = this.Cx;
        this.CX = com.kwad.components.ad.splashscreen.d.a(hVar2.mAdTemplate, adInfoCb, hVar2.mApkDownloadHelper, 2);
        float fBy = com.kwad.sdk.core.response.a.b.by(this.Cx.mAdTemplate);
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar == null) {
            this.ee = new com.kwad.sdk.core.f.d(fBy);
            this.ee.a(this);
        } else {
            dVar.e(fBy);
        }
        lw();
        if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            ls();
        }
        lx();
        this.ee.bi(getContext());
        this.Dc.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.1
            @Override // java.lang.Runnable
            public final void run() {
                l.this.Dc.lR();
            }
        });
        com.kwad.components.ad.splashscreen.local.b.H(getContext());
        this.Co = com.kwad.sdk.core.response.a.c.bQ(this.Cx.mAdTemplate);
        new com.kwad.sdk.widget.f(this.Dc.getContext(), this.Dc, this);
        this.Cx.a(this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.Co);
        if (this.Co && (hVar = this.Cx) != null) {
            hVar.c(1, view.getContext(), TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, 1);
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
        com.kwad.sdk.core.report.a.az(this.Cx.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kL() {
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.Dc) || (hVar = this.Cx) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.a.b.dc(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return;
        }
        this.Cx.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        Context context = getContext();
        if (context != null) {
            this.ef = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        this.Db = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_shake_root));
        this.Dd = (TextView) this.Db.findViewById(R.id.ksad_shake_action);
        this.Dc = (KsShakeView) this.Db.findViewById(R.id.ksad_shake_view);
        this.Dc.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar != null) {
            hVar.b(this);
        }
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        KsShakeView ksShakeView = this.Dc;
        if (ksShakeView != null) {
            ksShakeView.ko();
        }
    }
}
