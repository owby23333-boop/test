package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private m jE = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.k(j2);
        }
    };
    private TextView ka;
    private String kb;
    private long kc;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ka = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    private void dm() {
        this.kc = com.kwad.sdk.core.response.b.d.dX(this.mAdTemplate);
        String strDY = com.kwad.sdk.core.response.b.d.dY(this.mAdTemplate);
        this.kb = strDY;
        if (TextUtils.isEmpty(strDY)) {
            return;
        }
        this.mApkDownloadHelper = this.tm.mApkDownloadHelper;
        this.tm.rE.a(this.jE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (TextUtils.isEmpty(this.kb)) {
            return;
        }
        this.tm.rE.b(this.jE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.ka = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        if (j >= this.kc) {
            dn();
        }
    }

    private void dn() {
        if (this.ka.getVisibility() == 0) {
            return;
        }
        this.ka.setText(com.kwad.sdk.core.response.b.d.dY(this.mAdTemplate));
        this.ka.setVisibility(0);
        this.ka.setOnClickListener(this);
        m607do();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private void m607do() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 18, this.tm.mReportExtData);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ka) {
            com.kwad.components.core.e.d.a.a(new a.C0333a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aA(40).az(1).aq(false).al(this.tm.gI()).aB(1).a(new a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(40), this.tm.mReportExtData);
        this.tm.rD.cW();
    }
}
