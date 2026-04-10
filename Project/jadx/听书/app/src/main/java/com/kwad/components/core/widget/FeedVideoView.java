package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.t.p;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper UX;
    private com.kwad.components.core.video.e Vp;
    private KSCornerImageView aiA;
    private TextView aiB;
    private ScaleAnimSeekBar aiC;
    private ImageView aiD;
    private ImageView aiE;
    private ImageView aiF;
    private ViewGroup aiG;
    private ViewGroup aiH;
    private TextView aiI;
    private ViewGroup aiJ;
    private ViewGroup aiK;
    private int aiL;
    private boolean aiM;
    private boolean aiN;
    private long aiO;
    private boolean aiP;
    private KsAdVideoPlayConfig aiQ;
    private a aiR;
    private View aiS;
    private boolean aiT;
    private Runnable aiU;
    private p aiV;
    private RatioFrameLayout aiv;
    private TextView aiw;
    private TextView aix;
    private TextView aiy;
    private View aiz;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0409a cz;
    private KsAppDownloadListener dW;
    private View.OnClickListener fN;
    private TextView hA;
    private ImageView hM;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void rb();

        void rc();
    }

    static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.aiT = true;
        return true;
    }

    public FeedVideoView(Context context) {
        super(context);
        this.aiL = 100;
        this.aiU = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(true);
                }
            }
        };
        this.aiV = new p(this.aiU);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiL = 100;
        this.aiU = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(true);
                }
            }
        };
        this.aiV = new p(this.aiU);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiL = 100;
        this.aiU = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(true);
                }
            }
        };
        this.aiV = new p(this.aiU);
    }

    public void setWindowFullScreenListener(a aVar) {
        this.aiR = aVar;
    }

    @Override // com.kwad.components.core.widget.b
    protected final void bw() {
        this.UX = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.aiv = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.hA = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.aiC = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.aiC.setMinProgress(0);
        this.aiy = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.aiz = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.aiB = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.aiA = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.aiw = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.aix = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.aiD = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.aiF = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.aiE = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.aiG = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.aiJ = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.aiH = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.aiI = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // com.kwad.components.core.widget.b
    protected int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.dF(i));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.dG(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.cl(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.ac(FeedVideoView.this.mAdInfo));
                }
            };
        }
        return this.dW;
    }

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.aiT = false;
        com.kwad.sdk.core.response.model.b bVarBu = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo);
        this.aiQ = ksAdVideoPlayConfig;
        String url = bVarBu.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
        this.ck = com.kwad.sdk.core.response.b.a.bp(this.mAdInfo);
        String strK = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        this.cq = AdVideoPlayerViewCache.getInstance().eF(strK);
        if (com.kwad.sdk.core.response.b.a.aq(this.mAdInfo)) {
            this.hA.setVisibility(8);
            View view = this.aiz;
            if (view != null) {
                view.setVisibility(0);
                this.aiy.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.aiB.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.aiA, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.aiy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.fN != null) {
                            FeedVideoView.this.fN.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.aiz;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.hA.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null) {
            this.cq = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ab(this.mAdInfo);
            this.cq.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).dg(com.kwad.sdk.core.response.b.e.en(this.mAdTemplate)).dh(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).El(), null);
            a.InterfaceC0409a interfaceC0409a = new a.InterfaceC0409a() { // from class: com.kwad.components.core.widget.FeedVideoView.6
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0409a
                public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                        return null;
                    }
                    com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, FeedVideoView.this.mAdTemplate);
                    if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cz = interfaceC0409a;
            this.cq.setExternalPlayerListener(interfaceC0409a);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.cq, ksAdVideoPlayConfig);
            this.Vp = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cq.setController(this.Vp);
            this.Vp.setAutoRelease(false);
            if (com.kwad.sdk.core.config.e.EP() == 2) {
                AdVideoPlayerViewCache.getInstance().a(strK, this.cq);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.ck = (List) this.cq.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.cq.getController();
            this.Vp = eVar2;
            eVar2.setAutoRelease(false);
            this.Vp.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cq.getParent() != null) {
            ((ViewGroup) this.cq.getParent()).removeView(this.cq);
            this.Vp.tQ();
        }
        if (this.aiv.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.aiv;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.aiv.setTag(null);
        }
        this.aiv.addView(this.cq);
        this.aiv.setTag(this.cq);
        this.aiG.setVisibility(8);
        this.aiF.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.hA.setVisibility(8);
        } else {
            this.hA.setVisibility(0);
            this.hA.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Vp, this.cq);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.aiJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.aiG.getVisibility() == 8) {
                    if (!FeedVideoView.this.cq.isCompleted()) {
                        FeedVideoView.this.aiG.setVisibility(0);
                        FeedVideoView.this.aiF.setVisibility(0);
                        if (FeedVideoView.this.Vp != null) {
                            FeedVideoView.this.Vp.aR(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiU);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.aiL == 101) {
                        FeedVideoView.this.aiG.setVisibility(0);
                        FeedVideoView.this.aiF.setVisibility(8);
                        if (FeedVideoView.this.Vp != null) {
                            FeedVideoView.this.Vp.aR(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiU);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.fN != null) {
                        FeedVideoView.this.fN.onClick(view);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiU);
                    if (FeedVideoView.this.aiP) {
                        return;
                    }
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 1000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                FeedVideoView.this.c(j);
                float duration = (j * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.aiP) {
                    FeedVideoView.this.aiC.setProgress((int) duration);
                    FeedVideoView.this.aix.setText(bu.aq(j));
                }
                FeedVideoView.this.aiw.setText(bu.aq(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.aiT) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.bX(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aiw.setText(bu.aq(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                if (!FeedVideoView.this.aiT) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.eE) {
                    return;
                }
                this.eE = true;
                com.kwad.components.core.p.a.se().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                FeedVideoView.this.aiC.setProgress(100);
                FeedVideoView.this.aix.setText(bu.aq(aVar2.getDuration()));
            }
        });
        this.Vp.setAdClickListener(new a.InterfaceC0352a() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // com.kwad.components.core.video.a.InterfaceC0352a
            public final void a(int i, aj.a aVar3) {
                int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            i2 = com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i3 = 1;
                            z = true;
                        } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                            i2 = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0333a(FeedVideoView.this.getContext()).aB(FeedVideoView.this.mAdTemplate).av(true).b(FeedVideoView.this.mApkDownloadHelper).aB(i3).aq(z).as(true).aA(i2).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.vV();
                    }
                }));
            }
        });
        this.aiC.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.aiC.bv(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.aiP = true;
                    FeedVideoView.this.aix.setText(bu.aq((int) ((aVar2.getDuration() * ((long) scaleAnimSeekBar.getProgress())) / ((long) scaleAnimSeekBar.getMaxProgress()))));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void wd() {
                FeedVideoView.this.aiC.bv(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                FeedVideoView.this.aiP = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.aiC.bv(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * ((long) scaleAnimSeekBar.getProgress())) / ((long) scaleAnimSeekBar.getMaxProgress())));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
                FeedVideoView.this.aiP = false;
            }
        });
        this.aiD.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aVar2.isPaused() || aVar2.isIdle()) {
                    FeedVideoView.this.Vp.tT();
                    FeedVideoView.this.aiD.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.aiF.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (aVar2.isPlaying()) {
                    FeedVideoView.this.Vp.tS();
                    FeedVideoView.this.aiF.setVisibility(0);
                    FeedVideoView.this.aiF.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                    FeedVideoView.this.aiD.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
            }
        });
        this.aiF.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!FeedVideoView.this.cq.isPaused() && !FeedVideoView.this.cq.isIdle()) {
                    if (FeedVideoView.this.cq.isPlaying()) {
                        FeedVideoView.this.tw();
                    }
                } else {
                    FeedVideoView.this.rN();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
            }
        });
        this.aiH.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.wb();
            }
        });
        this.aiE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.aiL == 100) {
                    FeedVideoView.this.wa();
                } else if (FeedVideoView.this.aiL == 101) {
                    FeedVideoView.this.wb();
                }
            }
        });
    }

    public final void rN() {
        this.Vp.tT();
        this.Vp.setVisibility(0);
        this.Vp.setAlpha(1.0f);
        this.aiD.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.aiF.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void tw() {
        this.Vp.tS();
        this.aiF.setVisibility(0);
        this.aiF.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.aiD.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final void rJ() {
        this.Vp.tQ();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    private boolean vZ() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.aiO;
        if (j > 888) {
            this.aiO = jElapsedRealtime;
        }
        return j > 888;
    }

    protected void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.aiE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.aiE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.aiL = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        a aVar = this.aiR;
        if (aVar != null) {
            aVar.rb();
        }
        if ((this.aiL == 100) && vZ()) {
            this.aiH.setVisibility(0);
            this.aiI.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.b.a.R(this.mAdInfo) > com.kwad.sdk.core.response.b.a.Q(this.mAdInfo);
            this.aiM = aq.dg(getContext());
            getContext();
            this.aiN = aq.QW();
            if (!z) {
                aq.di(getContext());
            } else {
                aq.dj(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.aiJ.getParent();
            this.aiK = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.aiJ);
                View view = new View(this.aiJ.getContext());
                this.aiS = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.aiJ.getWidth(), this.aiJ.getHeight()));
                viewGroup.addView(this.aiS);
            }
            aq.d(getContext(), false);
            Activity activityEj = m.ej(getContext());
            if (activityEj != null) {
                ViewGroup viewGroup2 = (ViewGroup) activityEj.getWindow().getDecorView();
                this.aiJ.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.aiv.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.aiJ, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb() {
        if ((this.aiL == 101) & vZ()) {
            this.aiH.setVisibility(8);
            if (this.aiM) {
                aq.dg(getContext());
            } else {
                aq.dh(getContext());
            }
            if (this.aiN) {
                aq.dj(getContext());
            } else {
                aq.di(getContext());
            }
            aq.d(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.aiJ.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.aiJ);
            }
            this.aiJ.setLayoutParams(new ViewGroup.LayoutParams(this.aiK.getWidth(), this.aiK.getHeight()));
            this.aiv.setRatio(0.5600000023841858d);
            View view = this.aiS;
            if (view != null) {
                this.aiK.removeView(view);
                this.aiS = null;
            }
            this.aiK.addView(this.aiJ, new FrameLayout.LayoutParams(-1, -2));
            this.aiJ.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.aiR;
        if (aVar != null) {
            aVar.rc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Vp;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.UX.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.UX.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.UX.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.UX.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.UX.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.UX.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.UX.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.UX.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.UX.dispatchNestedPreFling(f, f2);
    }

    public final boolean wc() {
        if (this.aiL != 101) {
            return false;
        }
        wb();
        return true;
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.fN = onClickListener;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void E(View view) {
        super.E(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bu() {
        super.bu();
        if (this.cq != null) {
            tw();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.aiV);
                getHandler().postDelayed(this.aiV, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        rN();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.aiV);
            getHandler().postDelayed(this.aiV, 5000L);
        }
    }
}
