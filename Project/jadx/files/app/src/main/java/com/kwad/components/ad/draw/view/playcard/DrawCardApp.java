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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.r.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener cE;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private a f61do;
    private ImageView dp;
    private ImageView dq;
    private TextView dr;
    private ViewGroup ds;
    private AppScoreView dt;
    private TextView du;
    private TextView dv;
    private KsLogoView dw;
    private DrawDownloadProgressBar dx;
    private ValueAnimator dy;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    public interface a {
        void aD();

        void aE();
    }

    public DrawCardApp(Context context) {
        super(context);
        D(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_draw_card_app, this);
        this.dp = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.dq = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.dr = (TextView) findViewById(R.id.ksad_card_app_name);
        this.ds = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.dt = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.du = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.dv = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.dw = (KsLogoView) findViewById(R.id.ksad_card_logo);
        this.dx = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.dx.setTextSize(16);
        this.mHeight = com.kwad.sdk.b.kwai.a.a(context, 156.0f);
    }

    private void aM() {
        ValueAnimator valueAnimator = this.dy;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.dy.cancel();
        }
    }

    private void aV() {
        d(this.mHeight, 0);
    }

    private void d(int i2, int i3) {
        aM();
        this.dy = o.b(this, i2, i3);
        this.dy.setInterpolator(new DecelerateInterpolator(2.0f));
        this.dy.setDuration(300L);
        this.dy.start();
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.dx.f(com.kwad.sdk.core.response.a.a.ax(DrawCardApp.this.mAdInfo), DrawCardApp.this.dx.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.dx.f(com.kwad.sdk.core.response.a.a.aI(DrawCardApp.this.mAdTemplate), DrawCardApp.this.dx.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.dx.f(com.kwad.sdk.core.response.a.a.ax(DrawCardApp.this.mAdInfo), DrawCardApp.this.dx.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.dx.f(com.kwad.sdk.core.response.a.a.U(DrawCardApp.this.mAdInfo), DrawCardApp.this.dx.getMax());
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    super.onPaused(i2);
                    DrawCardApp.this.dx.f(com.kwad.sdk.core.response.a.a.xI(), i2);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    DrawCardApp.this.dx.f(i2 + "%", i2);
                }
            };
        }
        return this.cE;
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(this.mAdTemplate);
        this.f61do = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.dq, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), adTemplate, 11);
        this.dr.setText(com.kwad.sdk.core.response.a.a.ap(this.mAdInfo));
        String strAs = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
        float fAt = com.kwad.sdk.core.response.a.a.at(this.mAdInfo);
        boolean z2 = fAt >= 3.0f;
        if (z2) {
            this.dt.setScore(fAt);
            this.dt.setVisibility(0);
        }
        boolean z3 = !TextUtils.isEmpty(strAs);
        if (z3) {
            this.du.setText(strAs);
            this.du.setVisibility(0);
        }
        if (z2 || z3) {
            this.ds.setVisibility(0);
        } else {
            this.ds.setVisibility(8);
        }
        this.dw.U(this.mAdTemplate);
        this.dv.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
        this.dp.setOnClickListener(this);
        this.dx.setOnClickListener(this);
        setOnClickListener(this);
    }

    public final void aU() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.dp) {
            com.kwad.components.core.d.b.a.a(new a.C0395a(getContext()).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(view == this.dx).ap(view == this.dx ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (DrawCardApp.this.f61do != null) {
                        DrawCardApp.this.f61do.aE();
                    }
                }
            }));
            return;
        }
        aV();
        a aVar = this.f61do;
        if (aVar != null) {
            aVar.aD();
        }
    }

    public final void release() {
        aM();
        this.mApkDownloadHelper = null;
    }
}
