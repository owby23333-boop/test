package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.d {
    private boolean FV;
    private com.kwad.components.ad.splashscreen.d GN;
    private TextView Hi;
    private KsShakeView Hl;
    private ViewGroup Hr;
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.o.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                o.this.Gf.FH = SystemClock.elapsedRealtime() - o.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.Hr = (ViewGroup) viewStub.inflate();
        } else {
            this.Hr = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.Hi = (TextView) this.Hr.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.Hr.findViewById(R.id.ksad_shake_view);
        this.Hl = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mn() {
        this.GN = com.kwad.components.ad.splashscreen.d.a(this.Gf.mAdTemplate, com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate), this.Gf.mApkDownloadHelper, 2);
        this.FV = com.kwad.sdk.core.response.b.d.ea(this.Gf.mAdTemplate);
        new com.kwad.sdk.widget.h(this.Hl.getContext(), this.Hl, this);
        this.Gf.a(this);
        TextView textView = this.Hi;
        if (textView != null) {
            textView.setText(this.GN.lA());
        }
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.aq(this.GN.lB());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mo() {
        if (this.Hr == null || this.Gf == null) {
            return;
        }
        this.Hr.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mp() {
        float fDj = com.kwad.sdk.core.response.b.b.dj(this.Gf.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(fDj);
            this.gX = dVar2;
            dVar2.a(this);
            return;
        }
        dVar.g(fDj);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mq() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bG(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fM() {
        this.Hl.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.o.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                o.this.Hl.nx();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i, String str) {
        TextView textView = this.Hi;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
            } else {
                textView.setText("或点击" + str);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onUnbind");
        if (this.Gf != null) {
            this.Gf.b(this);
        }
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.ny();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean zOW = com.kwad.components.core.e.c.b.oW();
        if (!this.Gf.Fs.wl() || zOW) {
            return;
        }
        this.Hl.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (o.this.Gf != null) {
                    o.this.Gf.a(1, o.this.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.l(d);
                        }
                    });
                }
                o.this.Hl.nx();
            }
        });
        bw.a(getContext(), this.gZ);
        mr();
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cd() {
        com.kwad.sdk.core.adlog.c.ca(this.Gf.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.Hl) || this.Gf == null || this.Gf.mAdTemplate == null || !com.kwad.sdk.core.response.b.b.ea(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            return;
        }
        this.Gf.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.b.b.ea(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate)) && this.Gf != null) {
            this.Gf.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.FV);
        if (this.FV && this.Gf != null) {
            this.Gf.c(1, view.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }
}
