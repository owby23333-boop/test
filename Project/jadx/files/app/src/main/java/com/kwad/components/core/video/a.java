package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.widget.KSRelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
@Deprecated
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    protected boolean Qj;
    private boolean Qk;
    protected boolean Ql;
    private int Qm;
    private int Qn;
    private KSRelativeLayout Qo;
    private RelativeLayout Qp;
    private boolean Qq;
    private boolean Qr;
    private LinearLayout Qs;
    private LinearLayout Qt;
    private ImageView Qu;
    private ViewGroup Qv;
    private TextView Qw;
    private c Qx;
    private InterfaceC0410a Qy;
    private final com.kwad.sdk.core.download.kwai.a Qz;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected Context mContext;
    private ProgressBar nE;
    private boolean nH;
    protected ImageView nk;
    protected TextView nl;
    private ImageView zJ;
    private TextView zK;

    /* JADX INFO: renamed from: com.kwad.components.core.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC0410a {
        void a(int i2, ab.a aVar);
    }

    public interface b extends c {
        void onVideoPlayError(int i2, int i3);
    }

    public interface c {
        void bt();

        void d(long j2);

        void onVideoPlayStart();

        void onVideoPlaying();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Qk = true;
        this.Ql = false;
        this.Qr = false;
        this.Qz = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.ax(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.aI(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.bu(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aC(com.kwad.sdk.core.response.a.a.ax(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.U(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.xI());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.bu(i2));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        init();
    }

    private void aH(int i2) {
        InterfaceC0410a interfaceC0410a = this.Qy;
        if (interfaceC0410a != null) {
            interfaceC0410a.a(i2, this.Qo.getTouchCoords());
        }
    }

    private void init() {
        ImageView imageView;
        int i2;
        com.kwad.sdk.i.a.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Qo = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Qp = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.nl = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        this.nk = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.nk.setOnClickListener(this);
        this.Qs = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.Qt = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.nE = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.Qu = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.Qu;
            i2 = 8;
        } else {
            this.Qu.setImageDrawable(null);
            KSImageLoader.loadImage(this.Qu, url, this.mAdTemplate);
            imageView = this.Qu;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.nl.setText(bf.H(com.kwad.sdk.core.response.a.a.F(this.mAdInfo) * 1000));
        ql();
    }

    private void qm() {
        ViewGroup viewGroup = this.Qv;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void qq() {
        this.Qp.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z2) {
        if (this.Qr) {
            return;
        }
        this.nE.setVisibility(z2 ? 0 : 8);
        this.Qq = z2;
    }

    public final void aC(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public final void aJ(boolean z2) {
        if (this.Qr) {
            return;
        }
        if (!z2) {
            this.nE.setVisibility(8);
        } else if (this.Qq) {
            this.nE.setVisibility(0);
        }
    }

    protected void eU() {
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            this.zJ = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
            this.zK = (TextView) findViewById(R.id.ksad_app_name);
            this.Qw = (TextView) findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.zJ, com.kwad.sdk.core.response.a.d.cf(this.mAdTemplate), this.mAdTemplate, 12);
            this.zK.setText(com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo));
            this.Qw.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
            this.Qv = linearLayout;
            this.zJ.setOnClickListener(this);
            this.zK.setOnClickListener(this);
            this.Qw.setOnClickListener(this);
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            this.mApkDownloadHelper.b(this.Qz);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            this.Qw = (TextView) findViewById(R.id.ksad_h5_open);
            this.Qw.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
            this.Qw.setOnClickListener(this);
            this.Qv = linearLayout2;
        }
        this.Qv.setOnClickListener(this);
        this.Qv.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void l(int i2, int i3) {
        this.Qn = i3;
        this.Qm = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nk) {
            this.Qj = true;
            this.Qk = true;
            qr();
        } else {
            if (view == this.zJ) {
                aH(1);
                return;
            }
            if (view == this.zK) {
                aH(2);
            } else if (view == this.Qw) {
                aH(3);
            } else {
                aH(4);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i2) {
        com.kwad.sdk.core.d.b.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
        if (i2 == -1) {
            qB();
            setTopBottomVisible(false);
            this.Qs.setVisibility(8);
            this.Qt.setVisibility(0);
            c cVar = this.Qx;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Qm, this.Qn);
            }
            c cVar2 = this.Qx;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Qm, this.Qn);
            }
            com.kwad.components.core.m.a.pr().b(this.mAdTemplate, this.Qm, this.Qn);
            return;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                qq();
                this.Qs.setVisibility(8);
                this.Qt.setVisibility(8);
                this.nE.setVisibility(8);
                qm();
                return;
            }
            if (i2 == 2) {
                c cVar3 = this.Qx;
                if (cVar3 != null) {
                    cVar3.onVideoPlayStart();
                }
                setTopBottomVisible(true);
                qA();
                return;
            }
            if (i2 == 4) {
                c cVar4 = this.Qx;
                if (cVar4 != null) {
                    cVar4.onVideoPlaying();
                }
                this.Qu.setVisibility(8);
                return;
            }
            if (i2 != 9) {
                return;
            }
            c cVar5 = this.Qx;
            if (cVar5 != null) {
                cVar5.bt();
            }
            qB();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.Qu, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
            this.Qu.setVisibility(0);
            eU();
        }
    }

    protected void ql() {
    }

    protected final void qn() {
        this.Qs.setVisibility(0);
    }

    protected final void qo() {
        this.Qs.setVisibility(8);
    }

    protected final void qp() {
        this.Qp.setVisibility(0);
        this.Qu.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    protected void qr() {
        if (!this.amO.isIdle()) {
            if (this.amO.isPaused() || this.amO.yC()) {
                qs();
                this.amO.restart();
                return;
            }
            return;
        }
        if (!af.isNetworkConnected(this.mContext)) {
            qn();
            return;
        }
        qo();
        if (!this.Ql && ((!this.Qk || !af.isWifiConnected(this.mContext)) && (!this.Qk || (!this.nH && !this.Qj)))) {
            qp();
        } else {
            qs();
            this.amO.start();
        }
    }

    protected final void qs() {
        this.amO.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate));
    }

    protected void qt() {
        this.amO.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void qu() {
        long currentPosition = this.amO.getCurrentPosition();
        long duration = this.amO.getDuration();
        this.nE.setSecondaryProgress(this.amO.getBufferPercentage());
        this.nE.setProgress((int) ((currentPosition * 100.0f) / duration));
        c cVar = this.Qx;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public final void qv() {
        this.Qr = true;
        this.nE.setVisibility(8);
    }

    public void release() {
        this.amO.release();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void reset() {
        qB();
        this.nE.setProgress(0);
        this.nE.setSecondaryProgress(0);
        qq();
        this.Qs.setVisibility(8);
        this.Qt.setVisibility(8);
        this.nE.setVisibility(8);
        this.Qu.setVisibility(8);
        this.Qp.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        qm();
    }

    public void setAdClickListener(InterfaceC0410a interfaceC0410a) {
        this.Qy = interfaceC0410a;
    }

    public void setCanControlPlay(boolean z2) {
        this.Ql = z2;
    }

    public void setDataAutoStart(boolean z2) {
        this.Qk = z2;
    }

    public void setDataFlowAutoStart(boolean z2) {
        this.nH = z2;
    }

    public void setVideoPlayCallback(c cVar) {
        this.Qx = cVar;
    }
}
