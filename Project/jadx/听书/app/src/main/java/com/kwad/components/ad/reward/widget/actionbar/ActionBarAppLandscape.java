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
public class ActionBarAppLandscape extends LinearLayout implements d {
    private AppScoreView Ep;
    private TextProgressBar Eq;
    private View Er;
    private a Es;
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

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
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
        this.Es = aVar;
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
        float fAA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z = fAA >= 3.0f;
        if (z) {
            this.Ep.setScore(fAA);
            this.Ep.setVisibility(0);
        }
        String strAz = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean zIsEmpty = true ^ TextUtils.isEmpty(strAz);
        if (zIsEmpty) {
            this.gy.setText(strAz);
            this.gy.setVisibility(0);
        }
        if (zIsEmpty || z) {
            this.hE.setVisibility(8);
            return;
        }
        this.hE.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.Ep.setVisibility(8);
        this.gy.setVisibility(8);
        this.hE.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.Eq.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.Eq.e(com.kwad.sdk.core.response.b.a.dF(i), i);
                    ActionBarAppLandscape.this.Er.setVisibility(8);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppLandscape.this.Eq.e(com.kwad.sdk.core.response.b.a.dG(i), i);
                    ActionBarAppLandscape.this.Er.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.Eq.e(com.kwad.sdk.core.response.b.a.cl(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.Eq.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.Eq.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Er.setVisibility(0);
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
        com.kwad.components.core.e.d.a.a(new a.C0333a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(view == this.Eq).aB(view == this.Er ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.Es != null) {
                    ActionBarAppLandscape.this.Es.O(z);
                }
            }
        }));
    }
}
