package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* JADX INFO: loaded from: classes3.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    private AppScoreView Bc;
    private TextProgressBar Bd;
    private View Be;
    private a Bh;
    private KsAppDownloadListener cE;
    private ImageView dI;
    private TextView dJ;
    private TextView dL;
    private TextView eD;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    public interface a {
        void R(boolean z2);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView();
    }

    private void b(View view, final boolean z2) {
        com.kwad.components.core.d.b.a.a(new a.C0395a(view.getContext()).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(view == this.Bd).ap(view == this.Be ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.Bh != null) {
                    ActionBarAppPortrait.this.Bh.R(z2);
                }
            }
        }));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.Bd.f(com.kwad.sdk.core.response.a.a.ax(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Be.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.Bd.f(com.kwad.sdk.core.response.a.a.aI(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.Be.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.Bd.f(com.kwad.sdk.core.response.a.a.ax(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Be.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.Bd.f(com.kwad.sdk.core.response.a.a.U(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Be.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    ActionBarAppPortrait.this.Bd.f(com.kwad.sdk.core.response.a.a.bv(i2), i2);
                    ActionBarAppPortrait.this.Be.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.Bd.f(com.kwad.sdk.core.response.a.a.bu(i2), i2);
                    ActionBarAppPortrait.this.Be.setVisibility(8);
                }
            };
        }
        return this.cE;
    }

    private void initView() {
        com.kwad.sdk.i.a.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.dI = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dJ = (TextView) findViewById(R.id.ksad_app_title);
        this.eD = (TextView) findViewById(R.id.ksad_app_desc);
        this.Bc = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dL = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Bd = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.Bd.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
        this.Bd.setTextColor(-1);
        this.Be = findViewById(R.id.ksad_download_bar_cover);
    }

    private void kv() {
        String strAs = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
        boolean z2 = !TextUtils.isEmpty(strAs);
        float fAt = com.kwad.sdk.core.response.a.a.at(this.mAdInfo);
        boolean z3 = fAt >= 3.0f;
        if (z2 && z3) {
            ((LinearLayout.LayoutParams) this.dJ.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.Bc.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
            this.dL.setText(strAs);
            this.dL.setVisibility(0);
            this.Bc.setVisibility(0);
            this.Bc.setScore(fAt);
            this.eD.setVisibility(8);
            return;
        }
        if (z2) {
            this.dL.setText(strAs);
            this.dL.setVisibility(0);
            this.Bc.setVisibility(8);
            this.eD.setVisibility(8);
            return;
        }
        if (z3) {
            this.dL.setVisibility(8);
            this.Bc.setScore(fAt);
            this.Bc.setVisibility(0);
            this.eD.setVisibility(8);
            return;
        }
        this.eD.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
        this.dL.setVisibility(8);
        this.Bc.setVisibility(8);
        this.eD.setVisibility(0);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.d.b.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.Bh = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.dI, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), adTemplate, 12);
        this.dJ.setText(com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo));
        kv();
        this.Bd.f(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo), 0);
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.Be, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
