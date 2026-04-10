package com.kwad.components.ad.c.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.c.e;
import com.kwad.components.ad.c.f;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.d;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c<com.kwad.components.ad.c.c> implements View.OnClickListener, d {
    private KsAdVideoPlayConfig bU;
    private a.b cA;
    private OfflineOnAudioConflictListener cB;
    private f ce;
    private List<Integer> ck;
    private FrameLayout cl;
    private ImageView cm;
    private LinearLayout cn;
    private ImageView co;
    private boolean cp;
    private com.kwad.sdk.core.video.videoview.a cq;
    private e cr;
    private LinearLayout cs;
    private TextView ct;
    private TextView cu;
    private TextView cv;
    private ImageView cw;
    private KsLogoView cx;
    public InterfaceC0268a cy;
    private a.InterfaceC0409a cz;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;

    /* JADX INFO: renamed from: com.kwad.components.ad.c.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0268a {
        void a(int i, int i2, AdTemplate adTemplate);

        void as();

        void d(AdTemplate adTemplate);

        void e(AdTemplate adTemplate);
    }

    @Override // com.kwad.components.core.m.c
    public final boolean ai() {
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cp = false;
        return false;
    }

    public a(Context context, AdTemplate adTemplate, InterfaceC0268a interfaceC0268a) {
        super(context);
        this.mIsAudioEnable = true;
        this.cA = new a.b() { // from class: com.kwad.components.ad.c.b.a.1
            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                a.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.bX(a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.video.videoview.a aVar = a.this.cq;
                a aVar2 = a.this;
                aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(((com.kwad.components.ad.c.c) a.this.Rv).mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                if (a.this.cy != null) {
                    a.this.cy.as();
                }
            }
        };
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.c.b.a.2
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.b(a.this, false);
                if (a.this.cq != null) {
                    a.this.cq.setVideoSoundEnable(false);
                }
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        this.cy = interfaceC0268a;
        this.mContext = getContext();
        qs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ad.c.c al() {
        f fVar = new f(this.nY, com.kwad.sdk.core.response.b.a.cG(this.mAdInfo));
        this.ce = fVar;
        fVar.wi();
        com.kwad.components.ad.c.c cVar = new com.kwad.components.ad.c.c();
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mAdScene = this.mAdScene;
        cVar.mApkDownloadHelper = this.mApkDownloadHelper;
        return cVar;
    }

    @Override // com.kwad.components.core.m.c
    public final Presenter onCreatePresenter() {
        getContext();
        return an();
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.m.c
    public final void ak() {
        FrameLayout frameLayout = (FrameLayout) this.nY.findViewById(R.id.ksad_banner_item_content);
        this.cl = frameLayout;
        frameLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.nY.findViewById(R.id.ksad_banner_item_info);
        this.cs = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.nY.findViewById(R.id.ksad_banner_item_des);
        this.ct = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.ct.setOnClickListener(this);
        TextView textView2 = (TextView) this.nY.findViewById(R.id.ksad_banner_item_title);
        this.cu = textView2;
        textView2.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        this.cu.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.nY.findViewById(R.id.ksad_banner_button_base);
        this.cn = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView3 = (TextView) this.nY.findViewById(R.id.ksad_banner_item_button);
        this.cv = textView3;
        textView3.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.cv.setOnClickListener(this);
        ImageView imageView = (ImageView) this.nY.findViewById(R.id.ksad_banner_item_close);
        this.cw = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.nY.findViewById(R.id.ksad_banner_item_image);
        this.cm = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.nY.findViewById(R.id.ksad_banner_item_image_bg);
        this.co = imageView3;
        imageView3.setOnClickListener(this);
        this.cx = (KsLogoView) this.nY.findViewById(R.id.ksad_banner_logo);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(this.mAdInfo)) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl)) {
            int i = (int) ((this.mContext.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 17;
            this.cm.setLayoutParams(layoutParams);
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setCornerRound(8).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
                    return true;
                }
            });
        } else if (!com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            this.cm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl(), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.4
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.cm.setOnClickListener(this);
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAU = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo);
            if (!TextUtils.isEmpty(materialFeatureAU.materialUrl)) {
                int i2 = materialFeatureAU.width;
                int i3 = materialFeatureAU.height;
                if (i2 > 0 && i2 < i3) {
                    this.co.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    KSImageLoader.loadImage(this.co, com.kwad.sdk.core.response.b.a.O(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.5
                        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                            return true;
                        }
                    });
                    int i4 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((i4 / 16) * 9, i4);
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = (int) ((displayMetrics.density * 14.0f) + 0.5f);
                    this.cm.setLayoutParams(layoutParams2);
                }
            }
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
        }
        this.cx.aP(this.mAdTemplate);
        this.cl.setVisibility(4);
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

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strEJ;
        if (ksAdVideoPlayConfig == null) {
            ksAdVideoPlayConfig = new KSAdVideoPlayConfigImpl();
        }
        this.bU = ksAdVideoPlayConfig;
        this.mIsAudioEnable = !ap();
        this.ck = com.kwad.sdk.core.response.b.a.bp(this.mAdInfo);
        this.cq = new com.kwad.sdk.core.video.videoview.a(getContext());
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAV = com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.O(this.mAdInfo))) {
            int i = materialFeatureAV.width;
            int i2 = materialFeatureAV.height;
            if (i > 0 && i < i2) {
                int i3 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i3 / 16) * 9, i3);
                layoutParams.gravity = 5;
                layoutParams.rightMargin = 14;
                this.cq.setLayoutParams(layoutParams);
            }
        }
        this.cq.setOnClickListener(this);
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
            if (com.kwad.sdk.core.config.e.ES()) {
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
        this.cq.a(new b.a(this.mAdTemplate).dg(strK).dh(h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El(), null);
        a.InterfaceC0409a interfaceC0409a = new a.InterfaceC0409a() { // from class: com.kwad.components.ad.c.b.a.6
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0409a
            public final com.kwad.sdk.core.video.a.c a(b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                    return null;
                }
                g gVar = new g(bVar, a.this.mAdTemplate);
                if (g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cz = interfaceC0409a;
        this.cq.setExternalPlayerListener(interfaceC0409a);
        this.cq.setVideoSoundEnable(this.mIsAudioEnable);
        this.bU.setVideoAutoPlayType(com.kwad.sdk.core.response.b.a.ds(this.mAdInfo));
        e eVar = new e(this.mContext, this.mAdTemplate, this.cq, this.bU);
        this.cr = eVar;
        eVar.setHideEnd(true);
        this.cr.setVideoPlayCallback(this.cA);
        this.cq.setController(this.cr);
        this.cl.addView(this.cq);
        this.nY.findViewById(R.id.ksad_banner_logo).bringToFront();
        this.cl.setClickable(true);
        this.cr.ac();
        new com.kwad.sdk.widget.h(getContext(), this.cl, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
        }
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return R.layout.ksad_banner_item_land;
        }
        return R.layout.ksad_banner_item;
    }

    private static Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.c.c.b());
        return presenter;
    }

    public final void ao() {
        this.cl.setVisibility(0);
        this.cy.d(this.mAdTemplate);
    }

    private boolean ap() {
        boolean z;
        boolean z2 = true;
        if (com.kwad.sdk.core.config.e.FL() || !com.kwad.components.core.t.a.aC(this.mContext).sW()) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bU;
            if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
                z = !this.bU.isVideoSoundEnable();
            } else {
                if (com.kwad.sdk.core.response.b.a.bX(this.mAdInfo)) {
                    z2 = false;
                }
                z = z2;
            }
        } else {
            z = z2;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mIsAudioEnable = !z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.FL()) {
            if (com.kwad.components.core.t.a.aC(this.mContext).sX()) {
                return !com.kwad.components.core.t.a.aC(this.mContext).sW();
            }
            return com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.cl || view == this.cm || view == this.cq || view == this.co) {
            this.cy.a(100, 3, this.mAdTemplate);
            return;
        }
        if (view == this.cs || view == this.cn) {
            this.cy.a(53, 2, this.mAdTemplate);
            return;
        }
        if (view == this.ct) {
            this.cy.a(32, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cu) {
            this.cy.a(31, 2, this.mAdTemplate);
        } else if (view == this.cv) {
            this.cy.a(29, 1, this.mAdTemplate);
        } else if (view == this.cw) {
            this.cy.e(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            onClick(view);
        }
    }
}
