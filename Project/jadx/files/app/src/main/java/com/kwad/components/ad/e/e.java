package com.kwad.components.ad.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.e.d;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.g.c {
    private com.kwad.components.core.widget.kwai.b bY;
    private List<Integer> cI;
    private int cU;
    private z.b cY;
    private KSRelativeLayout eK;
    private boolean eP;
    private IAdLiveOfflineView eS;
    private com.kwad.components.core.offline.api.kwai.a eT;
    public IAdLivePlayModule eU;
    private a.b eX;
    private OfflineOnAudioConflictListener eY;
    private ai fA;
    private ae fB;
    private WebCardRegisterLiveMessageListener fC;
    private WebCardRegisterLiveShopListener fD;
    private af.b fH;
    private af.a fI;
    private IAdLiveEndRequest fV;
    private AdInfo mAdInfo;
    private final AdLivePlayStateListener mAdLivePlayStateListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;
    private KsNativeAd.VideoPlayListener mJ;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private int mL;
    private int mM;
    private final m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private d.a mO;
    private ImageView mY;
    private RelativeLayout mZ;
    private AdBasePvFrameLayout na;
    private KSAdVideoPlayConfigImpl nb;

    public e(@NonNull Context context) {
        super(context);
        this.mL = 0;
        this.mM = 0;
        this.cY = new z.b() { // from class: com.kwad.components.ad.e.e.10
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar) {
                KsAdWebView ksAdWebView;
                int i2;
                e.this.cU = aVar.status;
                if (e.this.cU != 1) {
                    ksAdWebView = e.this.mAdWebView;
                    i2 = 8;
                } else {
                    ksAdWebView = e.this.mAdWebView;
                    i2 = 0;
                }
                ksAdWebView.setVisibility(i2);
            }
        };
        this.mNetworking = new m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.e.e.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: bH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.fV);
            }

            @NonNull
            private static AdLiveEndCommonResultData t(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return t(str);
            }
        };
        this.mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.e.e.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayComplete();
                }
                String strAZ = com.kwad.sdk.core.response.a.a.aZ(e.this.mAdInfo);
                if (TextUtils.isEmpty(strAZ)) {
                    return;
                }
                com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
                if (aVar != null) {
                    e.this.fV = aVar.getAdLiveEndRequest(strAZ);
                }
                e.this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.e.e.2.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                        super.onError(aVar2, i2, str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        af.a aVar3 = new af.a();
                        aVar3.status = 9;
                        aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (e.this.fH != null) {
                            e.this.fH.a(aVar3);
                        } else {
                            e.this.fI = aVar3;
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayPause();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j2) {
                super.onLivePlayProgress(j2);
                e.this.c(j2);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.h.a.nX().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eU.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayResume();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.h.a.nX().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eU.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.h.a.nX().a(e.this.getCurrentVoiceItem());
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayReady();
                }
                IAdLivePlayModule iAdLivePlayModule = e.this.eU;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }
        };
        this.eY = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.e.e.3
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                IAdLivePlayModule iAdLivePlayModule = e.this.eU;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        initView();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fA = new ai();
        this.fB = new ae();
        aVar.a(this.fB);
        aVar.a(new j(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new g(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new com.kwad.components.core.webview.jshandler.m(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.mJsBridgeContext));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new z(this.cY, com.kwad.sdk.core.response.a.b.bl(this.mAdTemplate)));
        aVar.a(new ah(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new t(this.mJsBridgeContext));
        aVar.a(this.fA);
        aVar.a(new x(getOpenNewPageListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a(this.mL, this.mM));
        this.fD = new WebCardRegisterLiveShopListener();
        this.fC = new WebCardRegisterLiveMessageListener();
        aVar.a(this.fD);
        aVar.a(this.fC);
        aVar.a(new af(getRegisterLiveListener()));
    }

    private void aF() {
        if (com.kwad.sdk.core.response.a.b.bs(this.mAdTemplate)) {
            eQ();
        }
    }

    private boolean bE() {
        return this.cU == 1;
    }

    private void bF() {
        this.eS.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.e.e.6
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.fC != null) {
                    e.this.fC.l(list);
                }
            }
        });
        this.eS.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.e.e.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.fD != null) {
                    e.this.fD.a(adLiveShopInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bq() {
        br();
        this.eS = this.eT.getView(this.mContext, 3);
        IAdLivePlayModule adLivePlayModule = this.eT.getAdLivePlayModule(this.eS, ServiceProvider.CF().appId, String.valueOf(com.kwad.sdk.core.response.a.a.bM(this.mAdInfo)));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.mAdLivePlayStateListener);
        final View view = this.eS.getView();
        this.mZ.removeAllViews();
        this.mZ.addView(view);
        bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.this.c(view);
            }
        });
        bF();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.b.ar(this.mContext).a(this.eY);
        }
        return adLivePlayModule;
    }

    private void br() {
        ImageView imageView;
        int i2;
        String url = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.mY;
            i2 = 8;
        } else {
            this.mY.setImageDrawable(null);
            KSImageLoader.loadImage(this.mY, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.e.e.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            imageView = this.mY;
            i2 = 0;
        }
        imageView.setVisibility(i2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int width = this.eK.getWidth();
        int height = this.eK.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private void eL() {
        try {
            this.mL = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.mM = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void eP() {
        this.mAdWebView.setVisibility(8);
        inflateJsBridgeContext();
        if (bE()) {
            this.mAdWebView.reload();
        } else {
            aF();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void eQ() {
        clearJsInterfaceRegister();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().cr(this.mAdTemplate));
        this.mJsInterface = new com.kwad.components.core.webview.a(this.mAdWebView);
        a(this.mJsInterface);
        this.mAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.b.bm(this.mAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z2) {
        if (!z2) {
            return false;
        }
        if (this.eX != null) {
            com.kwad.components.core.h.a.nX();
            if (!com.kwad.components.core.h.a.b(this.eX)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.d.gR()) {
            return !com.kwad.components.core.r.b.ar(this.mContext).pZ() ? com.kwad.components.core.r.b.ar(this.mContext).aI(false) : !com.kwad.components.core.r.b.ar(this.mContext).pY();
        }
        if (!this.eP) {
            this.eP = com.kwad.components.core.r.b.ar(this.mContext).aI(true);
        }
        return this.eP;
    }

    @NonNull
    private com.kwad.sdk.core.webview.c.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.e.e.11
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                int i2 = aVar.Ty;
                if (aVar.IV) {
                    i2 = aVar.Tw ? 1 : 2;
                }
                boolean zAV = com.kwad.sdk.core.response.a.a.aV(e.this.mAdInfo);
                y.b bVar = new y.b();
                com.kwad.sdk.core.webview.c.a.c cVar = aVar.Tz;
                if (cVar != null && !TextUtils.isEmpty(cVar.To)) {
                    bVar.To = aVar.Tz.To;
                }
                a.C0395a c0395aAp = new a.C0395a(com.kwad.sdk.b.kwai.a.C(e.this)).J(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).al(false).ap(i2).ar(aVar.IV).ap(zAV);
                IAdLivePlayModule iAdLivePlayModule = e.this.eU;
                com.kwad.components.core.d.b.a.a(c0395aAp.q(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).a(bVar).an(true).a(new a.b() { // from class: com.kwad.components.ad.e.e.11.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (e.this.mO != null) {
                            e.this.mO.l(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eX == null) {
            this.eX = new a.b(new a.c() { // from class: com.kwad.components.ad.e.e.4
                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    e eVar = e.this;
                    if (eVar.eU == null) {
                        eVar.eU = eVar.bq();
                    }
                    e eVar2 = e.this;
                    eVar2.eU.setAudioEnabled(eVar2.g(eVar2.mIsAudioEnable), false);
                }
            });
        }
        return this.eX;
    }

    private x.a getOpenNewPageListener() {
        return new x.a() { // from class: com.kwad.components.ad.e.e.9
            @Override // com.kwad.components.core.webview.jshandler.x.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0405a().ar(bVar.title).as(bVar.url).M(e.this.mAdTemplate).ow());
            }
        };
    }

    private af.c getRegisterLiveListener() {
        return new af.c() { // from class: com.kwad.components.ad.e.e.8
            @Override // com.kwad.components.core.webview.jshandler.af.c
            public final void a(af.b bVar) {
                e.this.fH = bVar;
                if (e.this.fI != null) {
                    e.this.fH.a(e.this.fI);
                    e.this.fI = null;
                }
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        bVar.aoM = null;
        bVar.LI = this.na;
        bVar.Lk = this.mAdWebView;
        bVar.mReportExtData = null;
        bVar.aoO = false;
    }

    private void initView() {
        com.kwad.sdk.i.a.inflate(getContext(), R.layout.ksad_native_live_layout, this);
        this.na = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.mY = (ImageView) this.na.findViewById(R.id.ksad_live_bg_img);
        this.eK = (KSRelativeLayout) this.na.findViewById(R.id.ksad_live_container);
        this.mZ = (RelativeLayout) this.na.findViewById(R.id.ksad_live_video_container);
        this.mAdWebView = (KsAdWebView) this.na.findViewById(R.id.ksad_web_card_webView);
        this.mAdWebView.setBackgroundColor(0);
        this.eT = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
    }

    public final void a(Context context, AdTemplate adTemplate, @Nullable com.kwad.components.core.d.b.c cVar, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mContext = context;
        this.nb = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = cVar;
        this.cI = com.kwad.sdk.core.response.a.a.bc(this.mAdInfo);
        this.bY = new com.kwad.components.core.widget.kwai.b(getParent() == null ? this : (View) getParent(), 30);
        this.mIsAudioEnable = this.nb.getVideoSoundValue() != 0 ? this.nb.isVideoSoundEnable() : com.kwad.sdk.core.response.a.a.bF(this.mAdInfo);
        eL();
        eP();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        com.kwad.components.core.h.a.nX().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule == null) {
            this.eU = bq();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.h.a.nX().c(this.eX);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.bY.rU();
        this.bY.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void onViewDetached() {
        super.onViewDetached();
        this.bY.rU();
        this.bY.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eU = null;
        }
        com.kwad.components.core.h.a.nX().c(this.eX);
        this.fI = null;
        this.fH = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.eS;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eS = null;
        }
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mO = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mJ = videoPlayListener;
    }
}
