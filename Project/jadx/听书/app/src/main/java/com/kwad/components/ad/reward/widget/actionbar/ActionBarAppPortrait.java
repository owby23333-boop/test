package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: classes3.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    private AppScoreView Ep;
    private TextProgressBar Eq;
    private View Er;
    private a Eu;
    private KsAppDownloadListener dW;
    private TextView ee;
    private ImageView gw;
    private TextView gy;
    private TextView hE;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    public interface a {
        void O(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_title);
        this.hE = (TextView) findViewById(R.id.ksad_app_desc);
        this.Ep = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gy = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.Eq = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Eq.setTextColor(-1);
        this.Er = findViewById(R.id.ksad_download_bar_cover);
    }

    public final void a(AdTemplate adTemplate, c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = e.el(adTemplate);
        this.mAdInfo = adInfoEl;
        this.Eu = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(adInfoEl), adTemplate, 12);
        this.ee.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        lq();
        this.Eq.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), 0);
        c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new h(this, this);
        new h(this.Er, this);
    }

    private void lq() {
        String strAz = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean z = !TextUtils.isEmpty(strAz);
        float fAA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z2 = fAA >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.ee.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.Ep.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            this.gy.setText(strAz);
            this.gy.setVisibility(0);
            this.Ep.setVisibility(0);
            this.Ep.setScore(fAA);
            this.hE.setVisibility(8);
            return;
        }
        if (z) {
            this.gy.setText(strAz);
            this.gy.setVisibility(0);
            this.Ep.setVisibility(8);
            this.hE.setVisibility(8);
            return;
        }
        if (z2) {
            this.gy.setVisibility(8);
            this.Ep.setScore(fAA);
            this.Ep.setVisibility(0);
            this.hE.setVisibility(8);
            return;
        }
        this.hE.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.gy.setVisibility(8);
        this.Ep.setVisibility(8);
        this.hE.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.dF(i), i);
                    ActionBarAppPortrait.this.Er.setVisibility(8);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.dG(i), i);
                    ActionBarAppPortrait.this.Er.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.cl(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }
            };
        }
        return this.dW;
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, false);
        }
    }

    private void d(View view, final boolean z) {
        int i = view == this.Er ? 1 : 2;
        com.kwad.components.core.e.d.a.a(new a.C0333a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).az(1).aA(i).aq(view == this.Eq).aB(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.Eu != null) {
                    ActionBarAppPortrait.this.Eu.O(z);
                }
            }
        }));
    }
}
