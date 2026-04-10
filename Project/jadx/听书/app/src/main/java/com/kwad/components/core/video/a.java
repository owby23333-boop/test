package com.kwad.components.core.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.widget.KSRelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    protected ImageView Dh;
    protected TextView Di;
    private c ZA;
    private InterfaceC0352a ZB;
    protected com.kwad.components.core.video.a.a ZC;
    protected View ZD;
    protected final com.kwad.sdk.core.download.a.a ZE;
    protected boolean Zl;
    private boolean Zm;
    protected boolean Zn;
    private int Zo;
    private int Zp;
    private boolean Zq;
    private KSRelativeLayout Zr;
    private RelativeLayout Zs;
    private boolean Zt;
    private boolean Zu;
    private LinearLayout Zv;
    private LinearLayout Zw;
    private ImageView Zx;
    public ViewGroup Zy;
    protected TextView Zz;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    protected TextView pA;
    private ProgressBar pU;
    private boolean pX;
    protected ImageView pz;

    /* JADX INFO: renamed from: com.kwad.components.core.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC0352a {
        void a(int i, aj.a aVar);
    }

    public interface b extends c {
        void onVideoPlayError(int i, int i2);
    }

    public interface c {
        void aq();

        void ar();

        void d(long j);

        void onVideoPlayStart();
    }

    protected void tq() {
    }

    public void setCanControlPlay(boolean z) {
        this.Zn = z;
    }

    public a(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Zm = true;
        this.Zn = false;
        this.Zu = false;
        this.ZE = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aL(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.IQ());
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.dF(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.dF(i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.cl(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        init();
    }

    private void init() {
        this.ZD = com.kwad.sdk.o.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Zr = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Zs = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.pA = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.pz = imageView;
        imageView.setOnClickListener(this);
        this.Zv = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.Zw = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.pU = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.Zx = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.Zx.setImageDrawable(null);
            KSImageLoader.loadImage(this.Zx, url, this.mAdTemplate);
            this.Zx.setVisibility(0);
        } else {
            this.Zx.setVisibility(8);
        }
        this.pA.setText(bu.aq(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
        this.ZC = com.kwad.components.core.video.a.d.a(this.mAdTemplate, this.aKI.getMediaPlayerType(), false);
        tq();
    }

    public void setHideEnd(boolean z) {
        this.Zq = z;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void o(int i, int i2) {
        this.Zp = i2;
        this.Zo = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.d.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            tE();
            setTopBottomVisible(false);
            this.Zv.setVisibility(8);
            this.Zw.setVisibility(0);
            c cVar = this.ZA;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Zo, this.Zp);
            }
            c cVar2 = this.ZA;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Zo, this.Zp);
            }
            com.kwad.components.core.p.a.se().g(this.mAdTemplate, this.Zo, this.Zp);
            com.kwad.components.core.video.a.a aVar2 = this.ZC;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.Zo, this.Zp);
                return;
            }
            return;
        }
        if (i == 9) {
            tE();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            if (!this.Zq) {
                KSImageLoader.loadImage(this.Zx, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
                this.Zx.setVisibility(0);
                fA();
            }
            c cVar3 = this.ZA;
            if (cVar3 != null) {
                cVar3.ar();
            }
            com.kwad.components.core.video.a.a aVar3 = this.ZC;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
                return;
            }
            return;
        }
        if (i == 1) {
            tu();
            this.Zv.setVisibility(8);
            this.Zw.setVisibility(8);
            this.pU.setVisibility(8);
            fB();
            return;
        }
        if (i == 2) {
            c cVar4 = this.ZA;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.ZC;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            tD();
            return;
        }
        if (i == 4) {
            c cVar5 = this.ZA;
            if (cVar5 != null) {
                cVar5.aq();
            }
            this.Zx.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.ZC;
            if (aVar5 != null) {
                aVar5.qm();
                this.ZC.onMediaPlaying();
                return;
            }
            return;
        }
        if (i == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.ZC;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
                return;
            }
            return;
        }
        if (i != 6) {
            if (i == 7 && (aVar = this.ZC) != null) {
                aVar.onVideoPlayBufferingPaused();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar7 = this.ZC;
        if (aVar7 != null) {
            aVar7.onVideoPlayBufferingPlaying();
        }
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private void fB() {
        ViewGroup viewGroup = this.Zy;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void aL(String str) {
        TextView textView = (TextView) findViewById(R.id.ksad_app_download);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    protected void fA() {
        try {
            if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                this.Dh = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
                this.Di = (TextView) findViewById(R.id.ksad_app_name);
                this.Zz = (TextView) findViewById(R.id.ksad_app_download);
                KSImageLoader.loadAppIcon(this.Dh, com.kwad.sdk.core.response.b.e.eq(this.mAdTemplate), this.mAdTemplate, 12);
                this.Di.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
                this.Zz.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.Zy = linearLayout;
                this.Dh.setOnClickListener(this);
                this.Di.setOnClickListener(this);
                this.Zz.setOnClickListener(this);
                com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
                this.mApkDownloadHelper = cVar;
                cVar.b(this.ZE);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
                TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
                this.Zz = textView;
                textView.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.Zz.setOnClickListener(this);
                this.Zy = linearLayout2;
            }
            this.Zy.setOnClickListener(this);
            this.Zy.setVisibility(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    protected final void tr() {
        this.Zv.setVisibility(0);
    }

    protected final void ts() {
        this.Zv.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void reset() {
        tE();
        this.pU.setProgress(0);
        this.pU.setSecondaryProgress(0);
        tu();
        this.Zv.setVisibility(8);
        this.Zw.setVisibility(8);
        this.pU.setVisibility(8);
        this.Zx.setVisibility(8);
        this.Zs.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        fB();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.pz) {
            this.Zl = true;
            this.Zm = true;
            ac();
        } else {
            if (view == this.Dh) {
                ba(1);
                return;
            }
            if (view == this.Di) {
                ba(2);
            } else if (view == this.Zz) {
                ba(3);
            } else {
                ba(4);
            }
        }
    }

    protected final void tt() {
        this.Zs.setVisibility(0);
        this.Zx.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void tu() {
        this.Zs.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z) {
        if (this.Zu) {
            return;
        }
        this.pU.setVisibility(z ? 0 : 8);
        this.Zt = z;
    }

    public final void aR(boolean z) {
        if (this.Zu) {
            return;
        }
        if (z) {
            if (this.Zt) {
                this.pU.setVisibility(0);
                return;
            }
            return;
        }
        this.pU.setVisibility(8);
    }

    protected void ac() {
        if (this.aKI.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.ZC;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ao.isNetworkConnected(this.mContext)) {
                tr();
                return;
            }
            ts();
            if (this.Zn) {
                tv();
                this.aKI.start();
                return;
            }
            if (this.Zm && ao.isWifiConnected(this.mContext)) {
                tv();
                this.aKI.start();
                return;
            } else if (this.Zm && (this.pX || this.Zl)) {
                tv();
                this.aKI.start();
                return;
            } else {
                tt();
                return;
            }
        }
        if (this.aKI.isPaused() || this.aKI.Ke()) {
            tv();
            this.aKI.restart();
        }
    }

    protected final void tv() {
        this.aKI.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
    }

    protected void tw() {
        this.aKI.pause();
    }

    public void release() {
        this.aKI.release();
        com.kwad.components.core.video.a.a aVar = this.ZC;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void tx() {
        long currentPosition = this.aKI.getCurrentPosition();
        long duration = this.aKI.getDuration();
        this.pU.setSecondaryProgress(this.aKI.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.pU.setProgress((int) ((currentPosition * 100.0f) / duration));
        c cVar = this.ZA;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public void setVideoPlayCallback(c cVar) {
        this.ZA = cVar;
    }

    public void setAdClickListener(InterfaceC0352a interfaceC0352a) {
        this.ZB = interfaceC0352a;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.pX = z;
    }

    public void setDataAutoStart(boolean z) {
        this.Zm = z;
    }

    public final void ty() {
        this.Zu = true;
        this.pU.setVisibility(8);
    }

    private void ba(int i) {
        try {
            InterfaceC0352a interfaceC0352a = this.ZB;
            if (interfaceC0352a != null) {
                interfaceC0352a.a(i, this.Zr.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
