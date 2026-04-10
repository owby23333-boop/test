package com.kwad.components.ad.reward.presenter.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.a.d.b {
    private TextView vN;
    private TextView vO;

    private void ce() {
        j jVar = this.qS;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 17, jVar.mReportExtData);
    }

    private void iU() {
        TextView textView;
        String strBP = com.kwad.sdk.core.response.a.c.bP(this.qS.mAdTemplate);
        if (TextUtils.isEmpty(strBP)) {
            return;
        }
        if (this.qS.mScreenOrientation == 1) {
            this.vO.setVisibility(8);
            this.vN.setText(strBP);
            this.vN.setVisibility(0);
            textView = this.vN;
        } else {
            this.vN.setVisibility(8);
            this.vO.setText(strBP);
            this.vO.setVisibility(0);
            textView = this.vO;
        }
        textView.setOnClickListener(this);
        ce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV() {
        j jVar = this.qS;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 39, jVar.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.qS.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iW() {
        if (this.qS.pW) {
            return;
        }
        iU();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vN || view == this.vO) {
            com.kwad.components.core.d.b.a.a(new a.C0395a(view.getContext()).J(this.qS.mAdTemplate).b(this.qS.mApkDownloadHelper).al(false).ap(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.a.1
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    a.this.iV();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.vO = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.vN.setVisibility(8);
        this.vO.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str);
    }
}
