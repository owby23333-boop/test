package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.t.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes3.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener dW;
    private a gc;
    private ImageView gd;
    private ImageView ge;
    private TextView gf;
    private ViewGroup gg;
    private AppScoreView gh;
    private TextView gi;
    private TextView gj;
    private KsLogoView gk;
    private DrawDownloadProgressBar gl;
    private ValueAnimator gm;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    public interface a {
        void ba();

        void bb();
    }

    public DrawCardApp(Context context) {
        super(context);
        B(context);
    }

    public DrawCardApp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardApp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_draw_card_app, this);
        this.gd = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.ge = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.gf = (TextView) findViewById(R.id.ksad_card_app_name);
        this.gg = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.gh = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.gi = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.gj = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.gk = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.gl = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.c.a.a.a(context, 156.0f);
    }

    public final void a(AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.el(adTemplate);
        this.gc = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.ge, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), adTemplate, 11);
        this.gf.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        String strAz = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        float fAA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z = fAA >= 3.0f;
        if (z) {
            this.gh.setScore(fAA);
            this.gh.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(strAz);
        if (z2) {
            this.gi.setText(strAz);
            this.gi.setVisibility(0);
        }
        if (z || z2) {
            this.gg.setVisibility(0);
        } else {
            this.gg.setVisibility(8);
        }
        this.gk.aP(this.mAdTemplate);
        this.gj.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.gd.setOnClickListener(this);
        this.gl.setOnClickListener(this);
        setOnClickListener(this);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.gl.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.gl.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    DrawCardApp.this.gl.e(i + "%", i);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    DrawCardApp.this.gl.e(com.kwad.sdk.core.response.b.a.IQ(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.gl.e(com.kwad.sdk.core.response.b.a.cl(DrawCardApp.this.mAdTemplate), DrawCardApp.this.gl.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.gl.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.gl.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.gl.e(com.kwad.sdk.core.response.b.a.ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.gl.getMax());
                }
            };
        }
        return this.dW;
    }

    public final void release() {
        bl();
        this.mApkDownloadHelper = null;
    }

    public final void bT() {
        d(0, this.mHeight);
    }

    private void bU() {
        d(this.mHeight, 0);
    }

    private void d(int i, int i2) {
        bl();
        ValueAnimator valueAnimatorB = o.b(this, i, i2);
        this.gm = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gm.setDuration(300L);
        this.gm.start();
    }

    private void bl() {
        ValueAnimator valueAnimator = this.gm;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.gm.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gd) {
            bU();
            a aVar = this.gc;
            if (aVar != null) {
                aVar.ba();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(view == this.gl).aB(view == this.gl ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardApp.this.gc != null) {
                    DrawCardApp.this.gc.bb();
                }
            }
        }));
    }
}
