package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private ViewGroup ny;
    private TextView nz;

    /* JADX INFO: Access modifiers changed from: private */
    public void eU() {
        this.nz.setText(com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.nf.mAdTemplate)));
        this.ny.setOnClickListener(this);
        this.ny.setVisibility(0);
    }

    private void eW() {
        com.kwad.components.core.d.b.a.a(new a.C0395a(this.ny.getContext()).J(this.nf.mAdTemplate).ap(2).a(new a.b() { // from class: com.kwad.components.ad.e.a.h.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(h.this.nf.mAdTemplate, 2, h.this.nf.na.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.nf.mO.l(this.ny);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.h.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                h.this.eU();
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
        this.ny.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        eW();
        notifyAdClick();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ny = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.nz = (TextView) findViewById(R.id.ksad_h5_open);
    }
}
