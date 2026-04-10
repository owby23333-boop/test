package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.tencent.smtt.sdk.TbsListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private List<Integer> cI;
    private volatile boolean cJ;
    private com.kwad.sdk.widget.j cK;
    private ImageView dI;
    private TextView dJ;
    private TextView dQ;
    private KsAdVideoPlayConfig dY;
    private ImageView eB;
    private TextView eD;
    private TextView eE;
    private View eF;
    private DownloadProgressView eG;
    private KSRelativeLayout eK;
    private ImageView eL;
    private com.kwad.sdk.core.video.videoview.a eM;
    private com.kwad.components.core.video.e eN;
    private d eO;
    private boolean eP;
    private TextView eQ;
    private final a.InterfaceC0410a eR;
    private IAdLiveOfflineView eS;
    private com.kwad.components.core.offline.api.kwai.a eT;
    private IAdLivePlayModule eU;
    private boolean eV;
    private View eW;
    private a.b eX;
    private OfflineOnAudioConflictListener eY;
    private a.b eZ;
    private TextView ez;
    private final AdLivePlayStateListener mAdLivePlayStateListener;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.cJ = false;
        this.cK = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.a.c.1
            @Override // com.kwad.sdk.widget.j
            public final void aw() {
                com.kwad.sdk.utils.l.cu(c.this.mAdTemplate);
            }
        };
        this.eR = new a.InterfaceC0410a() { // from class: com.kwad.components.ad.feed.a.c.3
            @Override // com.kwad.components.core.video.a.InterfaceC0410a
            public final void a(int i2, ab.a aVar) {
                int i3;
                int i4 = 2;
                boolean z2 = false;
                if (i2 == 1) {
                    i3 = 15;
                } else if (i2 == 2) {
                    i3 = 16;
                } else if (i2 != 3) {
                    i3 = 35;
                } else {
                    i3 = 39;
                    i4 = 1;
                    z2 = true;
                }
                y.b bVar = new y.b();
                bVar.jU = aVar;
                bVar.jS = i3;
                c.this.bi();
                com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(c.this.eM)).J(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).ap(i4).al(z2).an(true).an(5).ao(i3).ap(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.3.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        c.this.eh();
                    }
                }));
            }
        };
        this.mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.a.c.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.eQ.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j2) {
                super.onLivePlayProgress(j2);
                c.this.c(j2);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.h.a.nX().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eU;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.h.a.nX().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eU;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }
        };
        this.eY = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.a.c.8
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.eM != null) {
                    c.this.eM.setVideoSoundEnable(false);
                }
                if (c.this.eU != null) {
                    c.this.eU.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.eZ = new a.b() { // from class: com.kwad.components.ad.feed.a.c.10
            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                if (com.kwad.components.ad.feed.kwai.b.be() && c.this.eO == null) {
                    c cVar = c.this;
                    cVar.eO = new d(cVar.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar2 = c.this;
                    cVar2.addView(cVar2.eO, layoutParams);
                    c.this.eO.bu();
                }
                com.kwad.sdk.core.report.a.ax(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i2, int i3) {
                com.kwad.components.ad.feed.monitor.a.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.a.a.E(c.this.mAdInfo), i2 + " " + i3, SystemClock.elapsedRealtime() - c.this.ew);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.h.a.nX().a(c.this.getCurrentVoiceItem());
                if (c.this.eO != null && (c.this.eO.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.eO.getParent()).removeView(c.this.eO);
                    c.this.eO.bv();
                    c.this.eO = null;
                }
                com.kwad.components.ad.feed.monitor.a.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.a.a.E(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ew);
                com.kwad.sdk.core.report.a.h(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.eM;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
            }
        };
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z2, final int i2) {
        if (aVar != null || this.eV) {
            String strE = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
            if (!this.eV) {
                this.eN.setAutoRelease(false);
            }
            int i3 = z2 ? 1 : 2;
            if (!this.eV) {
                AdVideoPlayerViewCache.getInstance().a(strE, this.eM);
            }
            bi();
            a.C0395a c0395aAl = new a.C0395a(com.kwad.sdk.b.kwai.a.C(this)).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(z2);
            IAdLivePlayModule iAdLivePlayModule = this.eU;
            com.kwad.components.core.d.b.a.a(c0395aAl.q(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ap(i3).ap(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.9
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    c.this.aH(i2);
                }
            }));
        }
    }

    static /* synthetic */ boolean b(c cVar, boolean z2) {
        cVar.eP = false;
        return false;
    }

    private void bl() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eE = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dQ = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eF = findViewById(R.id.ksad_h5_open_cover);
        this.eE.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.dQ.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
        this.eF.setOnClickListener(this);
        this.eE.setOnClickListener(this);
        this.dQ.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dQ, this);
    }

    private void bm() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dI = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dJ = (TextView) findViewById(R.id.ksad_app_title);
        this.eD = (TextView) findViewById(R.id.ksad_app_desc);
        com.kwad.sdk.b.kwai.a.a(this, this.dI, this.dJ, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.dI, this);
        new com.kwad.sdk.widget.f(getContext(), this.dJ, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        this.dJ.setText(com.kwad.sdk.core.response.a.a.ap(this.mAdInfo));
        this.dI.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dI, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), this.mAdTemplate, 8);
        this.eD.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        bj();
        this.eG.E(this.mAdTemplate);
        this.eG.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, this.eG.getAppDownloadListener());
        this.mApkDownloadHelper.d(this.eG.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    private void bo() {
        this.eT = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        com.kwad.components.core.offline.api.kwai.a aVar = this.eT;
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.co(this.mAdInfo)) {
            this.eV = true;
        }
    }

    private boolean bp() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eS;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.eV) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.eS.getView().getParent();
        if (viewGroup != this.eK) {
            viewGroup.removeView(this.eS.getView());
            if (this.eK.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eK;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eK.setTag(null);
            }
            this.eK.addView(this.eS.getView());
            this.eK.setTag(this.eS.getView());
            this.eU.setAudioEnabled(this.mIsAudioEnable, false);
            this.eU = this.eT.getAdLivePlayModule(this.eS, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.a.a.bM(this.mAdInfo)));
            this.eU.registerAdLivePlayStateListener(this.mAdLivePlayStateListener);
        }
        this.eU.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bq() {
        br();
        this.eS = this.eT.getView(this.mContext, 3);
        IAdLivePlayModule adLivePlayModule = this.eT.getAdLivePlayModule(this.eS, ServiceProvider.CF().appId, String.valueOf(com.kwad.sdk.core.response.a.a.bM(this.mAdInfo)));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.mAdLivePlayStateListener);
        final View view = this.eS.getView();
        if (this.eK.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eK;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eK.setTag(null);
        }
        this.eK.addView(view);
        this.eK.setTag(view);
        bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.a.c.4
            @Override // java.lang.Runnable
            public final void run() {
                c.this.c(view);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.b.ar(this.mContext).a(this.eY);
        }
        return adLivePlayModule;
    }

    private void br() {
        String url = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo).getUrl();
        this.eL.setVisibility(0);
        this.eW.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.eL.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.eL.setImageDrawable(null);
            KSImageLoader.loadImage(this.eL, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.a.c.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        int iCeil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final View view) {
        view.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.c.6
            @Override // java.lang.Runnable
            public final void run() {
                int width = c.this.eK.getWidth();
                int height = c.this.eK.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z2) {
        if (!z2) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.gR()) {
            return !com.kwad.components.core.r.b.ar(this.mContext).pZ() ? com.kwad.components.core.r.b.ar(this.mContext).aI(false) : !com.kwad.components.core.r.b.ar(this.mContext).pY();
        }
        if (!this.eP) {
            this.eP = com.kwad.components.core.r.b.ar(this.mContext).aI(true);
        }
        return this.eP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eX == null) {
            this.eX = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.a.c.2
                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    if (!c.this.eV) {
                        if (c.this.eM != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = c.this.eM;
                            c cVar = c.this;
                            aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (c.this.eU == null) {
                        c cVar2 = c.this;
                        cVar2.eU = cVar2.bq();
                    }
                    IAdLivePlayModule iAdLivePlayModule = c.this.eU;
                    c cVar3 = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar3.g(cVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.eX;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.dY = ksAdVideoPlayConfig;
        this.mIsAudioEnable = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bF(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
        this.cI = com.kwad.sdk.core.response.a.a.bc(this.mAdInfo);
        if (this.eV) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.eL;
            i2 = 8;
        } else {
            this.eL.setImageDrawable(null);
            KSImageLoader.loadImage(this.eL, url, this.mAdTemplate);
            imageView = this.eL;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.eM = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.eM.setVisibleListener(this.cK);
        this.eM.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eM, this);
        this.eM.setTag(this.cI);
        String strE = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        this.eM.a(new b.a(this.mAdTemplate).bd(strE).be(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate)).uc(), null);
        this.eM.setVideoSoundEnable(g(this.mIsAudioEnable));
        this.eN = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eM, ksAdVideoPlayConfig);
        this.eN.setAdClickListener(this.eR);
        this.ew = SystemClock.elapsedRealtime();
        this.eN.setVideoPlayCallback(this.eZ);
        this.eM.setController(this.eN);
        if (this.eK.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eK;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eK.setTag(null);
        }
        this.eK.addView(this.eM);
        this.eK.setTag(this.eM);
        this.eK.setClickable(true);
        this.eK.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eK, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.b.ar(this.mContext).a(this.eY);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void aS() {
        super.aS();
        com.kwad.components.core.video.e eVar = this.eN;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.eZ);
        }
        com.kwad.components.core.h.a.nX().a(getCurrentVoiceItem());
        if (this.eV) {
            IAdLivePlayModule iAdLivePlayModule = this.eU;
            if (iAdLivePlayModule == null) {
                this.eU = bq();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void aT() {
        super.aT();
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.h.a.nX().c(this.eX);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            a(this.eM, view == this.eG, TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.ez.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.mLogoView.U(adTemplate);
        bo();
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            bm();
        } else {
            bl();
        }
        this.ez.setOnClickListener(this);
        this.eK.setOnClickListener(this);
        this.eB.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.ez, this);
        new com.kwad.sdk.widget.f(getContext(), this.eK, this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        this.ez = (TextView) findViewById(R.id.ksad_ad_desc);
        this.eK = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.eK.setRatio(0.56f);
        this.eB = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eL = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eG = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.eQ = (TextView) findViewById(R.id.ksad_live_end_text);
        this.eW = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bn() {
        super.bn();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eG.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.b.ar(this.mContext).b(this.eY);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.eB
            if (r5 != r0) goto L8
            r4.rL()
            return
        L8:
            com.kwad.sdk.widget.KSRelativeLayout r0 = r4.eK
            if (r5 != r0) goto L2c
            com.kwad.sdk.core.video.videoview.a r0 = r4.eM
            if (r0 == 0) goto L2c
            boolean r0 = r0.isIdle()
            if (r0 == 0) goto L2c
            T extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.utils.l.ct(r5)
            T extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.contentalliance.kwai.kwai.a r5 = com.kwad.sdk.contentalliance.kwai.kwai.a.am(r5)
            com.kwad.sdk.core.video.videoview.a r0 = r4.eM
            r0.setKsPlayLogParam(r5)
            com.kwad.sdk.core.video.videoview.a r5 = r4.eM
            r5.start()
            return
        L2c:
            r0 = 35
            android.widget.TextView r1 = r4.ez
            r2 = 1
            r3 = 100
            if (r5 != r1) goto L38
            r0 = 25
            goto L6c
        L38:
            com.kwad.sdk.widget.KSRelativeLayout r1 = r4.eK
            if (r5 != r1) goto L3f
        L3c:
            r0 = 100
            goto L6c
        L3f:
            com.kwad.components.ad.widget.DownloadProgressView r1 = r4.eG
            if (r5 == r1) goto L6b
            android.widget.TextView r1 = r4.dQ
            if (r5 == r1) goto L6b
            android.view.View r1 = r4.eF
            if (r5 != r1) goto L4c
            goto L6b
        L4c:
            android.widget.ImageView r1 = r4.dI
            if (r5 != r1) goto L53
            r0 = 13
            goto L6c
        L53:
            android.widget.TextView r1 = r4.dJ
            if (r5 != r1) goto L5a
            r0 = 14
            goto L6c
        L5a:
            android.widget.TextView r1 = r4.eD
            if (r5 == r1) goto L68
            android.widget.TextView r1 = r4.eE
            if (r5 != r1) goto L63
            goto L68
        L63:
            com.kwad.sdk.core.video.videoview.a r1 = r4.eM
            if (r5 != r1) goto L6c
            goto L3c
        L68:
            r0 = 101(0x65, float:1.42E-43)
            goto L6c
        L6b:
            r0 = 1
        L6c:
            com.kwad.sdk.core.video.videoview.a r1 = r4.eM
            com.kwad.components.ad.widget.DownloadProgressView r3 = r4.eG
            if (r5 != r3) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            r4.a(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.a.c.onClick(android.view.View):void");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        com.kwad.sdk.utils.l.cs(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eU = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eS;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eS = null;
        }
        com.kwad.components.core.h.a.nX().c(this.eX);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (!z2) {
            IAdLiveOfflineView iAdLiveOfflineView = this.eS;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null) {
                return;
            }
            this.eU.onPause();
            return;
        }
        if (bp()) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar != null && this.eN != null) {
            ViewGroup viewGroup = (ViewGroup) aVar.getParent();
            if (this.eM.getParent() != this.eK) {
                viewGroup.removeView(this.eM);
                if (this.eK.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eK;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eK.setTag(null);
                }
                this.eK.addView(this.eM);
                this.eK.setTag(this.eM);
                com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
                this.eM.setVideoSoundEnable(this.mIsAudioEnable);
                this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                this.eN.setAdClickListener(this.eR);
                this.eN.getAdTemplate().mAdWebVideoPageShowing = false;
                this.eN.qP();
                this.eN.setAutoRelease(true);
            }
        }
        AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.a.a.E(this.mAdInfo));
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dY = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            this.mIsAudioEnable = kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0 ? kSAdVideoPlayConfigImpl.isVideoSoundEnable() : com.kwad.sdk.core.response.a.a.bF(this.mAdInfo);
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.eS;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.eU) == null) {
                com.kwad.sdk.core.video.videoview.a aVar = this.eM;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(g(this.mIsAudioEnable));
                }
            } else {
                iAdLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.r.b.ar(this.mContext).a(this.eY);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eN) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }
}
