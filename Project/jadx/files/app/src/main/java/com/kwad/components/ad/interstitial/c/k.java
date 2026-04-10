package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends b implements com.kwad.sdk.widget.c {
    private List<Integer> cI;

    @NonNull
    private KsAdVideoPlayConfig dY;
    private ImageView eL;
    private com.kwad.sdk.core.video.videoview.a eM;
    private c jq;
    private KSFrameLayout kc;
    private KSFrameLayout kd;
    private com.kwad.components.core.video.f ln;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;

    @Nullable
    private boolean mIsAudioEnable = false;
    private i km = new i() { // from class: com.kwad.components.ad.interstitial.c.k.1
        @Override // com.kwad.components.ad.interstitial.c.i
        public final void dA() {
            try {
                k.this.ln.qr();
            } catch (Throwable unused) {
            }
        }

        @Override // com.kwad.components.ad.interstitial.c.i
        public final void dB() {
            try {
                k.this.ln.qt();
            } catch (Throwable unused) {
            }
        }
    };
    private final a.InterfaceC0410a eR = new a.InterfaceC0410a() { // from class: com.kwad.components.ad.interstitial.c.k.4
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        @Override // com.kwad.components.core.video.a.InterfaceC0410a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r6, com.kwad.sdk.utils.ab.a r7) {
            /*
                r5 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r6 == r1) goto L17
                if (r6 == r0) goto L14
                r3 = 3
                if (r6 == r3) goto Lf
                r6 = 108(0x6c, float:1.51E-43)
            Lc:
                r2 = 2
                r3 = 0
                goto L1a
            Lf:
                r6 = 83
                r2 = 1
                r3 = 1
                goto L1a
            L14:
                r6 = 82
                goto Lc
            L17:
                r6 = 13
                goto Lc
            L1a:
                com.kwad.sdk.core.report.y$b r4 = new com.kwad.sdk.core.report.y$b
                r4.<init>()
                r4.jU = r7
                r4.jS = r6
                com.kwad.components.ad.interstitial.c.k r6 = com.kwad.components.ad.interstitial.c.k.this
                android.content.Context r6 = com.kwad.components.ad.interstitial.c.k.e(r6)
                boolean r6 = com.kwad.sdk.utils.ah.cu(r6)
                if (r6 == 0) goto L30
                goto L31
            L30:
                r0 = 1
            L31:
                r4.ajQ = r0
                com.kwad.components.core.d.b.a$a r6 = new com.kwad.components.core.d.b.a$a
                com.kwad.components.ad.interstitial.c.k r7 = com.kwad.components.ad.interstitial.c.k.this
                com.kwad.sdk.core.video.videoview.a r7 = com.kwad.components.ad.interstitial.c.k.d(r7)
                android.content.Context r7 = com.kwad.sdk.b.kwai.a.C(r7)
                r6.<init>(r7)
                com.kwad.components.ad.interstitial.c.k r7 = com.kwad.components.ad.interstitial.c.k.this
                com.kwad.sdk.core.response.model.AdTemplate r7 = com.kwad.components.ad.interstitial.c.k.c(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.J(r7)
                com.kwad.components.ad.interstitial.c.k r7 = com.kwad.components.ad.interstitial.c.k.this
                com.kwad.components.core.d.b.c r7 = com.kwad.components.ad.interstitial.c.k.g(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.b(r7)
                com.kwad.components.core.d.b.a$a r6 = r6.ap(r2)
                com.kwad.components.core.d.b.a$a r6 = r6.al(r3)
                com.kwad.components.core.d.b.a$a r6 = r6.an(r1)
                com.kwad.components.core.d.b.a$a r6 = r6.a(r4)
                com.kwad.components.ad.interstitial.c.k$4$1 r7 = new com.kwad.components.ad.interstitial.c.k$4$1
                r7.<init>()
                com.kwad.components.core.d.b.a$a r6 = r6.a(r7)
                com.kwad.components.core.d.b.a.a(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.c.k.AnonymousClass4.a(int, com.kwad.sdk.utils.ab$a):void");
        }
    };

    private c.b a(View view, boolean z2) {
        return new c.b(view.getContext()).k(z2).a(this.kc.getTouchCoords()).C(3).D(85);
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
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private void eg() {
        ImageView imageView;
        int i2;
        this.mIsAudioEnable = this.dY.isVideoSoundEnable();
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
        int iUJ = com.kwad.sdk.core.config.d.uJ();
        String strE = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        if (iUJ < 0) {
            File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(strE);
            strE = (fileAN == null || !fileAN.exists()) ? null : fileAN.getAbsolutePath();
        } else if (iUJ != 0) {
            strE = com.kwad.sdk.core.videocache.b.a.bl(this.mContext).cz(strE);
        }
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        this.eM.a(new b.a(this.mAdTemplate).bd(strE).be(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).uc(), null);
        this.eM.setVideoSoundEnable(this.mIsAudioEnable);
        this.ln.setVideoPlayCallback(new f.a() { // from class: com.kwad.components.ad.interstitial.c.k.2
            private boolean cJ = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.ax(k.this.mAdTemplate);
                if (!k.this.jq.jv && k.this.jq.hK != null) {
                    k.this.jq.hK.onVideoPlayEnd();
                }
                Iterator<a.c> it = k.this.jq.jD.iterator();
                while (it.hasNext()) {
                    it.next().bt();
                }
                k.this.jq.jF = true;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                k.this.c(j2);
                Iterator<a.c> it = k.this.jq.jD.iterator();
                while (it.hasNext()) {
                    it.next().d(j2);
                }
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i3, int i4) {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(k.this.mAdTemplate, i3, String.valueOf(i4));
                if (k.this.jq.hK != null) {
                    k.this.jq.hK.onVideoPlayError(i3, i4);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.report.a.h(k.this.mAdTemplate);
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.h(k.this.mAdTemplate);
                if (!k.this.jq.jv && k.this.jq.hK != null) {
                    k.this.jq.hK.onVideoPlayStart();
                }
                Iterator<a.c> it = k.this.jq.jD.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                k.this.jq.jF = false;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!this.cJ) {
                    this.cJ = true;
                    com.kwad.components.core.m.a.pr().a(k.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<a.c> it = k.this.jq.jD.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlaying();
                }
            }
        });
        this.eM.setController(this.ln);
        this.kd.setClickable(true);
        new com.kwad.sdk.widget.f(this.kd.getContext(), this.kd, this);
        this.kd.addView(this.eM);
        this.jq.jB = new c.d() { // from class: com.kwad.components.ad.interstitial.c.k.3
            @Override // com.kwad.components.ad.interstitial.c.c.d
            public final void dh() {
                if (k.this.eM != null) {
                    k.this.eM.restart();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        c cVar = this.jq;
        if (!cVar.jv && (adInteractionListener = cVar.hK) != null) {
            adInteractionListener.onAdClicked();
        }
        c cVar2 = this.jq;
        cVar2.jt = true;
        if (cVar2.jv) {
            return;
        }
        cVar2.cr();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.jq.a(a(view, true));
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq = (c) Bs();
        c cVar = this.jq;
        this.dY = cVar.dY;
        this.mAdTemplate = cVar.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.cI = com.kwad.sdk.core.response.a.a.bc(this.mAdInfo);
        this.eM = this.jq.eM;
        this.eM.setTag(this.cI);
        this.ln = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.eM);
        this.ln.setDataFlowAutoStart(this.dY.isDataFlowAutoStart());
        this.ln.setAdClickListener(this.eR);
        this.ln.qv();
        this.mApkDownloadHelper = this.jq.mApkDownloadHelper;
        eg();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.kd.setRadius(dimension, dimension, 0.0f, 0.0f);
        this.jq.a(this.km);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.jq.a(a(view, false));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kc = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kd = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eL = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.kd.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        c cVar = this.jq;
        cVar.jB = null;
        cVar.b(this.km);
    }
}
