package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView GI;
    private com.kwad.components.ad.splashscreen.d GN;
    private View Hd;
    private KsRotateView He;
    private TextView Hf;
    private com.kwad.sdk.core.g.c gY;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.Hd = viewStub.inflate();
        } else {
            this.Hd = findViewById(R.id.ksad_rotate_root);
        }
        this.Hf = (TextView) findViewById(R.id.ksad_rotate_text);
        this.GI = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.He = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mn() {
        AdTemplate adTemplate = this.Gf.mAdTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.GN = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfoEl, this.Gf.mApkDownloadHelper, 1);
        TextView textView = this.Hf;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dE(adInfoEl));
        }
        TextView textView2 = this.GI;
        if (textView2 != null) {
            textView2.setText("或点击" + this.GN.lA());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mo() {
        if (this.Hd == null || this.Gf == null) {
            return;
        }
        this.Hd.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mp() {
        AdMatrixInfo.RotateInfo rotateInfoDk = com.kwad.sdk.core.response.b.b.dk(this.Gf.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(rotateInfoDk);
            this.gY = cVar2;
            cVar2.a(this);
            return;
        }
        cVar.b(rotateInfoDk);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mq() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bG(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bH(mv());
        }
    }

    private Context mv() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.Hd) == null) ? context : view.getContext();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fM() {
        KsRotateView ksRotateView = this.He;
        if (ksRotateView == null) {
            return;
        }
        ksRotateView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.m.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                m.this.He.fM();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i, String str) {
        TextView textView = this.GI;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
            } else {
                textView.setText("或点击" + str);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        View rootView = getRootView();
        if (rootView == null) {
            return;
        }
        rootView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.m.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (m.this.Gf != null) {
                    m.this.Gf.FH = SystemClock.elapsedRealtime() - m.this.mStartTime;
                }
            }
        });
        if (this.Gf != null) {
            this.Gf.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotatePresenter", "onUnbind");
        if (this.Gf != null) {
            this.Gf.b(this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void r(final String str) {
        boolean zWl = this.Gf.Fs.wl();
        boolean zOW = com.kwad.components.core.e.c.b.oW();
        if (!zWl || zOW) {
            return;
        }
        this.He.nw();
        if (this.Gf != null) {
            this.Gf.a(1, mv(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.dv(str);
                }
            });
        }
        mt();
        mr();
    }

    @Override // com.kwad.sdk.core.g.a
    public final void ce() {
        com.kwad.sdk.core.adlog.c.ca(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bH(mv());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Gf.c(1, mv(), 162, 1);
    }
}
