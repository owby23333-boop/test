package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b implements com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig bU;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0409a cz;
    private KSFrameLayout fC;
    private ImageView hM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    private c mj;
    private KSFrameLayout ni;
    private com.kwad.components.core.video.f nj;
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0352a hQ = new a.InterfaceC0352a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
        @Override // com.kwad.components.core.video.a.InterfaceC0352a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r11, com.kwad.sdk.utils.aj.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L15
                if (r11 == r0) goto L12
                r3 = 3
                if (r11 == r3) goto Ld
                r11 = 108(0x6c, float:1.51E-43)
                goto L17
            Ld:
                r11 = 83
                r2 = r1
                r3 = r2
                goto L18
            L12:
                r11 = 82
                goto L17
            L15:
                r11 = 13
            L17:
                r3 = r0
            L18:
                com.kwad.components.ad.interstitial.f.f r4 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.ad.interstitial.f.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.aq.QW()
                if (r4 == 0) goto L24
                goto L25
            L24:
                r0 = r1
            L25:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.eO()
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.f.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.aB(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.f.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.aB(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.aq(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.as(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.aA(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.aC(r0)
                com.kwad.components.ad.interstitial.f.f$4$1 r0 = new com.kwad.components.ad.interstitial.f.f$4$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.AnonymousClass4.a(int, com.kwad.sdk.utils.aj$a):void");
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ni = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.fC = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.hM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.fC.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        this.mj = cVar;
        this.bU = cVar.bU;
        AdTemplate adTemplate = this.mj.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mAdInfo = adInfoEl;
        this.ck = com.kwad.sdk.core.response.b.a.bp(adInfoEl);
        com.kwad.sdk.core.video.videoview.a aVar = this.mj.cq;
        this.cq = aVar;
        aVar.setTag(this.ck);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.cq);
        this.nj = fVar;
        fVar.setDataFlowAutoStart(this.bU.isDataFlowAutoStart());
        this.nj.setAdClickListener(this.hQ);
        this.nj.ty();
        this.mApkDownloadHelper = this.mj.mApkDownloadHelper;
        ex();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.fC.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mj.mr = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    private void ex() {
        String strEJ;
        this.mIsAudioEnable = this.bU.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
        int iBQ = com.kwad.sdk.core.config.e.BQ();
        String strK = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        if (iBQ < 0) {
            File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(strK);
            if (fileCf == null || !fileCf.exists()) {
                strK = null;
            } else {
                strEJ = fileCf.getAbsolutePath();
                strK = strEJ;
            }
        } else if (iBQ != 0) {
            com.kwad.sdk.core.videocache.f fVarBR = com.kwad.sdk.core.videocache.c.a.bR(this.mContext);
            if (com.kwad.sdk.core.config.e.EU()) {
                int iBQ2 = com.kwad.sdk.core.config.e.BQ();
                if (!fVarBR.eL(strK)) {
                    if (fVarBR.a(strK, iBQ2 * 1024, new a.C0405a(), null)) {
                        strEJ = fVarBR.eJ(strK);
                    }
                } else {
                    strEJ = fVarBR.eJ(strK);
                }
                strK = strEJ;
            } else {
                strK = fVarBR.eJ(strK);
            }
        }
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        this.cq.a(new b.a(this.mAdTemplate).dg(strK).dh(h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).El(), null);
        a.InterfaceC0409a interfaceC0409a = new a.InterfaceC0409a() { // from class: com.kwad.components.ad.interstitial.f.f.1
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0409a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                    return null;
                }
                com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, f.this.mAdTemplate);
                if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cz = interfaceC0409a;
        this.cq.setExternalPlayerListener(interfaceC0409a);
        this.cq.setVideoSoundEnable(this.mIsAudioEnable);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.components.ad.interstitial.report.d.eU().E(this.mAdTemplate);
        this.nj.setVideoPlayCallback(new f.a() { // from class: com.kwad.components.ad.interstitial.f.f.2
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                f.this.c(j);
                Iterator<a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().d(j);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.bX(f.this.mAdTemplate);
                com.kwad.components.ad.interstitial.report.d.eU().b(f.this.mAdTemplate, System.currentTimeMillis() - jCurrentTimeMillis);
                com.kwad.components.ad.interstitial.report.b.eQ().x(f.this.mAdTemplate);
                if (!f.this.mj.mn && f.this.mj.kQ != null) {
                    f.this.mj.kQ.onVideoPlayStart();
                }
                Iterator<a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                f.this.mj.mv = false;
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.interstitial.report.d.eU().b(f.this.mAdTemplate, i, String.valueOf(i2));
                if (f.this.mj.kQ != null) {
                    f.this.mj.kQ.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                if (!this.eE) {
                    this.eE = true;
                    com.kwad.components.core.p.a.se().a(f.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().aq();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(f.this.mAdTemplate);
                if (!f.this.mj.mn && f.this.mj.kQ != null) {
                    f.this.mj.kQ.onVideoPlayEnd();
                }
                Iterator<a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().ar();
                }
                f.this.mj.mv = true;
            }
        });
        this.cq.setController(this.nj);
        this.fC.setClickable(true);
        new com.kwad.sdk.widget.h(this.fC.getContext(), this.fC, this);
        this.fC.addView(this.cq);
        this.mj.mr = new c.e() { // from class: com.kwad.components.ad.interstitial.f.f.3
            @Override // com.kwad.components.ad.interstitial.f.c.e
            public final void ec() {
                if (f.this.cq != null) {
                    f.this.cq.restart();
                }
            }
        };
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
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j) {
        this.mj.ml = true;
        this.mj.c(1L, j);
    }

    private c.C0284c c(View view, boolean z) {
        return new c.C0284c(view.getContext()).l(z).a(this.ni.getTouchCoords()).L(3).M(85);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.mj.a(c(view, true));
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        this.mj.a(c(view, false));
    }
}
