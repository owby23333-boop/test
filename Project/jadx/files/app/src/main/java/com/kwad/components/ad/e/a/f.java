package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private ImageView dI;
    private TextView dJ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ViewGroup ns;
    private TextView nt;
    private KsAppDownloadListener nu = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.e.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.nt.setText(com.kwad.sdk.core.response.a.a.ax(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.nt.setText(com.kwad.sdk.core.response.a.a.aI(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.nt.setText(com.kwad.sdk.core.response.a.a.ax(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.nt.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
        }
    };

    private void J(int i2) {
        com.kwad.components.core.d.b.a.a(new a.C0395a(this.ns.getContext()).J(this.mAdTemplate).ap(i2).b(this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.e.a.f.3
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(f.this.mAdTemplate, 2, f.this.nf.na.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eU() {
        KSImageLoader.loadAppIcon(this.dI, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), this.mAdTemplate, 12);
        this.dJ.setText(com.kwad.sdk.core.response.a.a.ap(this.mAdInfo));
        this.nt.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.nu);
        }
        this.ns.setOnClickListener(this);
        this.ns.setVisibility(0);
    }

    private void notifyAdClick() {
        this.nf.mO.l(this.ns);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.nf.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.mApkDownloadHelper = this.nf.mApkDownloadHelper;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.f.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                try {
                    f.this.eU();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    com.kwad.components.core.c.a.b(th);
                }
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
        this.ns.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ns) {
            J(2);
            notifyAdClick();
        } else if (view == this.nt) {
            J(1);
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ns = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.dI = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dJ = (TextView) findViewById(R.id.ksad_app_name);
        this.nt = (TextView) findViewById(R.id.ksad_app_download);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.nu);
        }
    }
}
