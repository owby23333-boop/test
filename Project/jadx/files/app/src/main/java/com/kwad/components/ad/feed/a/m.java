package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.smtt.sdk.TbsListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends com.kwad.components.core.widget.b<AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private static final HashMap<Long, Double> fE = new HashMap<>(8);
    private List<Integer> cI;
    private int cU;
    private z.b cY;
    private KsAdVideoPlayConfig dY;
    private KSRelativeLayout eK;
    private ImageView eL;
    private com.kwad.sdk.core.video.videoview.a eM;
    private com.kwad.components.core.video.e eN;
    private d eO;
    private boolean eP;
    private final a.InterfaceC0410a eR;
    private IAdLiveOfflineView eS;
    private com.kwad.components.core.offline.api.kwai.a eT;
    private IAdLivePlayModule eU;
    private boolean eV;
    private View eW;
    private a.b eX;
    private OfflineOnAudioConflictListener eY;
    private d.b ei;
    private long ew;
    private ai fA;
    private ae fB;
    private WebCardRegisterLiveMessageListener fC;
    private WebCardRegisterLiveShopListener fD;
    private boolean fF;
    private String fG;
    private af.b fH;
    private af.a fI;
    private boolean fJ;
    private com.kwad.components.core.widget.b fK;
    private float fL;
    private float fM;
    private boolean fN;
    private a fO;
    private ViewGroup.MarginLayoutParams fP;
    private e fQ;
    private aa fR;
    private boolean fS;
    private boolean fT;
    private b.InterfaceC0422b fU;
    private IAdLiveEndRequest fV;
    private RatioFrameLayout fw;
    private double fx;
    private LinearLayout fy;
    private TextView fz;
    private final AdLivePlayStateListener mAdLivePlayStateListener;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private Handler mHandler;
    private boolean mIsAudioEnable;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private final com.kwad.sdk.core.network.m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    public interface a {
        void c(int i2, String str);
    }

    public m(@NonNull Context context) {
        super(context);
        this.cU = -1;
        this.mIsAudioEnable = false;
        this.fJ = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.fS = false;
        this.fT = false;
        this.eY = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.a.m.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.eM != null) {
                    m.this.eM.setVideoSoundEnable(false);
                }
                if (m.this.eU != null) {
                    m.this.eU.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fU = new b.InterfaceC0422b() { // from class: com.kwad.components.ad.feed.a.m.20
            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onAdClicked() {
                if (m.this.oJ != null) {
                    m.this.oJ.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onAdShow() {
                if (m.this.oJ != null) {
                    m.this.oJ.onAdShow();
                }
                if (m.this.fJ) {
                    com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                    y.a aVar = new y.a();
                    FeedType feedTypeFromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(feedTypeFromInt.getType());
                    iVar.a(aVar);
                    iVar.p((int) Math.ceil(m.this.fx), m.this.mWidth);
                    com.kwad.components.core.r.c.qa().a(m.this.mAdTemplate, null, iVar);
                    com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 1);
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onDislikeClicked() {
                if (m.this.oJ != null) {
                    m.this.oJ.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.oJ != null) {
                    m.this.oJ.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onDownloadTipsDialogShow() {
                if (m.this.oJ != null) {
                    m.this.oJ.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.a.m.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: bH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(m.this.fV);
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
        this.mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.a.m.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String strAZ = com.kwad.sdk.core.response.a.a.aZ(m.this.mAdInfo);
                if (TextUtils.isEmpty(strAZ)) {
                    return;
                }
                com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
                if (aVar != null) {
                    m.this.fV = aVar.getAdLiveEndRequest(strAZ);
                }
                m.this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.a.m.4.1
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
                        if (m.this.fH != null) {
                            m.this.fH.a(aVar3);
                        } else {
                            m.this.fI = aVar3;
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j2) {
                super.onLivePlayProgress(j2);
                m.this.c(j2);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.h.a.nX().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.eU;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.h.a.nX().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.eU;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.eU.setAudioEnabled(false, false);
            }
        };
        this.cY = new z.b() { // from class: com.kwad.components.ad.feed.a.m.8
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar) {
                if (m.this.fF) {
                    return;
                }
                m.this.cU = aVar.status;
                if (m.this.cU != 1) {
                    m.this.g("3", 3);
                    return;
                }
                m.this.mHandler.removeCallbacksAndMessages(null);
                if (m.this.fK != null) {
                    m.this.fK.setVisibility(8);
                }
                m.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.m.a.pr().O(m.this.mAdTemplate);
                if (m.this.fO != null) {
                    m.this.fO.c(2, "");
                }
            }
        };
        this.eR = new a.InterfaceC0410a() { // from class: com.kwad.components.ad.feed.a.m.18
            @Override // com.kwad.components.core.video.a.InterfaceC0410a
            public final void a(int i2, ab.a aVar) {
                int i3;
                int i4 = 2;
                boolean z2 = false;
                if (i2 == 1) {
                    i3 = 13;
                } else if (i2 == 2) {
                    i3 = 82;
                } else if (i2 != 3) {
                    i3 = 108;
                } else {
                    i3 = 83;
                    i4 = 1;
                    z2 = true;
                }
                y.b bVar = new y.b();
                bVar.jU = aVar;
                bVar.jS = i3;
                m.this.bD();
                com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(m.this.eM)).J(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(i4).al(z2).an(true).a(bVar).ap(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.18.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        m.this.eh();
                    }
                }));
            }
        };
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.fL = motionEvent.getX();
        this.fM = motionEvent.getY();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fA = new ai();
        this.fB = new ae();
        aVar.a(this.fB);
        aVar.a(new com.kwad.components.core.webview.jshandler.j(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.g(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new s(this.mJsBridgeContext, new s.b() { // from class: com.kwad.components.ad.feed.a.m.21
            @Override // com.kwad.components.core.webview.jshandler.s.b
            public final void a(s.a aVar2) {
                if (m.this.fJ) {
                    return;
                }
                m.this.mAdWebView.setVisibility(0);
                if (m.this.fx == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    m.this.fx = aVar2.height;
                    m.this.fw.setRatio((float) r0);
                    m.fE.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar2.height / m.this.mWidth));
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new com.kwad.components.core.webview.jshandler.m(this.mJsBridgeContext));
        aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.a.m.22
            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                m mVar;
                boolean zBF;
                if (m.this.mAdInfo != null) {
                    if (com.kwad.sdk.core.response.a.a.aV(m.this.mAdInfo) || m.this.eV) {
                        m mVar2 = m.this;
                        mVar2.fP = (ViewGroup.MarginLayoutParams) mVar2.eK.getLayoutParams();
                        int iCeil = (int) Math.ceil(m.this.fx);
                        int i2 = m.this.mWidth;
                        if (videoPosition.widthRation == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = m.this.fP;
                        double d2 = videoPosition.topMarginRation;
                        double d3 = iCeil;
                        Double.isNaN(d3);
                        marginLayoutParams.topMargin = (int) (d2 * d3);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = m.this.fP;
                        double d4 = videoPosition.leftMarginRation;
                        double d5 = i2;
                        Double.isNaN(d5);
                        marginLayoutParams2.leftMargin = (int) (d4 * d5);
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = m.this.fP;
                        double d6 = videoPosition.widthRation;
                        Double.isNaN(d5);
                        marginLayoutParams3.width = (int) (d5 * d6);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = m.this.fP;
                        double d7 = m.this.fP.width;
                        double d8 = videoPosition.heightWidthRation;
                        Double.isNaN(d7);
                        marginLayoutParams4.height = (int) (d7 * d8);
                        m.this.eK.setRadius(videoPosition.borderRadius);
                        m.this.eK.setLayoutParams(m.this.fP);
                        if (!(m.this.dY instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) m.this.dY).getVideoSoundValue() == 0) {
                            mVar = m.this;
                            zBF = com.kwad.sdk.core.response.a.a.bF(mVar.mAdInfo);
                        } else {
                            mVar = m.this;
                            zBF = mVar.dY.isVideoSoundEnable();
                        }
                        mVar.mIsAudioEnable = zBF;
                        m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                        m mVar3 = m.this;
                        mVar3.cI = com.kwad.sdk.core.response.a.a.bc(mVar3.mAdInfo);
                        if (!m.this.eV) {
                            m mVar4 = m.this;
                            mVar4.a(mVar4.dY);
                        } else if (m.this.eU != null) {
                            IAdLivePlayModule iAdLivePlayModule = m.this.eU;
                            m mVar5 = m.this;
                            iAdLivePlayModule.setAudioEnabled(mVar5.g(mVar5.mIsAudioEnable), false);
                        }
                    }
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext, new k.a() { // from class: com.kwad.components.ad.feed.a.m.23
            @Override // com.kwad.components.core.webview.jshandler.k.a
            public final void bI() {
                m.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.23.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.this.rL();
                    }
                });
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.mJsBridgeContext));
        com.kwad.components.core.webview.jshandler.l lVar = new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext);
        lVar.a(new l.b() { // from class: com.kwad.components.ad.feed.a.m.24
            @Override // com.kwad.components.core.webview.jshandler.l.b
            public final void a(l.a aVar2) {
                aVar2.height = 0;
                aVar2.width = m.this.mWidth;
            }
        });
        aVar.a(lVar);
        aVar.a(new z(this.cY, com.kwad.sdk.core.response.a.b.bl(this.mAdTemplate)));
        aVar.a(new ah(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new t(this.mJsBridgeContext));
        aVar.a(this.fA);
        aVar.a(new x(getOpenNewPageListener()));
        aVar.a(new ag(new ag.a() { // from class: com.kwad.components.ad.feed.a.m.25
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void bJ() {
                m.d(m.this, true);
                m.this.bB();
            }
        }));
        this.fR = new aa();
        aVar.a(this.fR);
        if (this.eV) {
            aVar.a(new com.kwad.components.core.webview.jshandler.a(1, 1));
            this.fD = new WebCardRegisterLiveShopListener();
            this.fC = new WebCardRegisterLiveMessageListener();
            aVar.a(this.fD);
            aVar.a(this.fC);
            aVar.a(new af(getRegisterLiveListener()));
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i2) {
        if (aVar != null) {
            String strE = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
            this.eN.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(strE, this.eM);
            FeedType.fromInt(this.mAdTemplate.type);
            bD();
            com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(this)).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(2).ap(com.kwad.sdk.core.response.a.a.aV(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.17
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    m.this.aH(i2);
                }
            }));
        }
    }

    static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.c.a.a aVar) {
        return a(aVar);
    }

    static /* synthetic */ boolean a(m mVar, boolean z2) {
        mVar.eP = false;
        return false;
    }

    private static boolean a(com.kwad.sdk.core.webview.c.a.a aVar) {
        return aVar.IV ? aVar.Tw : aVar.Ty == 1;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().cr(this.mAdTemplate).b(getWebListener()));
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.mJsInterface = new com.kwad.components.core.webview.a(this.mAdWebView);
        a(this.mJsInterface);
        this.mAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.b.bl(this.mAdTemplate));
        com.kwad.components.ad.feed.monitor.a.s(com.kwad.sdk.core.response.a.b.bl(this.mAdTemplate));
        bA();
    }

    private void bA() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.12
            @Override // java.lang.Runnable
            public final void run() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.g("0", 1);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        float fBp = com.kwad.sdk.core.response.a.b.bp(this.mAdTemplate);
        this.ei = new d.b() { // from class: com.kwad.components.ad.feed.a.m.5
            @Override // com.kwad.components.ad.feed.d.b
            public final boolean b(final double d2) {
                if (!com.kwad.sdk.b.kwai.a.m(m.this.fw, (int) (com.kwad.sdk.core.config.d.uR() * 100.0f))) {
                    return false;
                }
                com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(m.this)).J(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(2).al(false).an(false).ao(157).an(5).ap(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.5.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.b.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.a.d.ck(m.this.mAdTemplate));
                        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                        iVar.i(d2);
                        iVar.bf(157);
                        m.this.c(iVar);
                    }
                }));
                return true;
            }
        };
        com.kwad.components.ad.feed.d.a(fBp, this.mContext, this.ei);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD() {
        if (this.fN) {
            return;
        }
        this.fN = true;
        com.kwad.components.ad.feed.monitor.a.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bE() {
        return this.cU == 1;
    }

    private void bF() {
        this.eS.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.a.m.11
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.fC != null) {
                    m.this.fC.l(list);
                }
            }
        });
        this.eS.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.a.m.13
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.fD != null) {
                    m.this.fD.a(adLiveShopInfo);
                }
            }
        });
    }

    private boolean bp() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eS;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.eU == null) {
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
            this.eU.setAudioEnabled(g(this.mIsAudioEnable), false);
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
        bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.10
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(view);
            }
        });
        bF();
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
            KSImageLoader.loadImage(this.eL, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.a.m.14
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

    private void c(AdTemplate adTemplate) {
        if (this.fT) {
            return;
        }
        this.mAdWebView = (KsAdWebView) findViewById(com.kwad.sdk.core.response.a.a.co(com.kwad.sdk.core.response.a.d.cb(adTemplate)) ? R.id.ksad_web_bottom_card_webView : R.id.ksad_web_default_bottom_card_webView);
        this.fT = true;
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private static float d(AdTemplate adTemplate) {
        int i2 = adTemplate.type;
        if (i2 == 1) {
            return 0.6013f;
        }
        return (i2 == 2 || i2 == 3) ? 0.283f : 0.968f;
    }

    static /* synthetic */ boolean d(m mVar, boolean z2) {
        mVar.fS = true;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        double d2;
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (fE.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.fw.setRatio(r5.floatValue());
        } else {
            if (com.kwad.sdk.core.response.a.b.bq(this.mAdTemplate) > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                ratioFrameLayout = this.fw;
                d2 = com.kwad.sdk.core.response.a.b.bq(this.mAdTemplate);
            } else if (this.fw.getRatio() == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                ratioFrameLayout = this.fw;
                d2 = d(this.mAdTemplate);
            }
            ratioFrameLayout.setRatio(d2);
        }
        this.eT = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        com.kwad.components.core.offline.api.kwai.a aVar = this.eT;
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.co(this.mAdInfo)) {
            this.eV = true;
        }
        inflateJsBridgeContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i2) {
        com.kwad.sdk.core.d.b.d("FeedWebView", "handleWebViewError " + str);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fF) {
            return;
        }
        this.fF = true;
        if (this.mAdWebView != null) {
            com.kwad.components.ad.feed.monitor.a.a(com.kwad.sdk.core.response.a.b.bl(this.mAdTemplate), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i2);
        }
        com.kwad.components.core.m.a aVarPr = com.kwad.components.core.m.a.pr();
        AdTemplate adTemplate = this.mAdTemplate;
        aVarPr.b(adTemplate, com.kwad.sdk.core.response.a.b.bl(adTemplate), str);
        a aVar = this.fO;
        if (aVar != null) {
            aVar.c(1, str);
        }
        this.fO = null;
        if (this.fK == null) {
            this.fJ = true;
            com.kwad.components.core.widget.b.c(this);
            int iAX = com.kwad.sdk.core.response.a.a.aX(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.eU;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.eU.onDestroy();
                this.eU = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.eS;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.eS = null;
            }
            this.fK = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), iAX);
            if (this.fK != null) {
                this.fK.setMargin(com.kwad.sdk.b.kwai.a.a(this.mContext, 16.0f));
                this.fw.removeAllViews();
                this.fw.setRatio(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.eK.setVisibility(8);
                this.fK.setInnerAdInteractionListener(this.fU);
                this.fw.addView(this.fK);
                this.fK.bindView(this.mAdTemplate);
                com.kwad.components.core.widget.b bVar = this.fK;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dY);
                }
            }
        }
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
        return new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.feed.a.m.7
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                m.this.bD();
                int i2 = aVar.Ty;
                if (aVar.IV) {
                    i2 = aVar.Tw ? 1 : 2;
                }
                boolean zAV = com.kwad.sdk.core.response.a.a.aV(m.this.mAdInfo);
                y.b bVar = new y.b();
                com.kwad.sdk.core.webview.c.a.c cVar = aVar.Tz;
                if (cVar != null && !TextUtils.isEmpty(cVar.To)) {
                    bVar.To = aVar.Tz.To;
                }
                com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(m.this)).J(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).al(m.a(m.this, aVar)).ap(i2).ao(aVar.jS).an(5).ar(aVar.IV).ap(zAV).q(m.this.eU == null ? 0L : m.this.eU.getPlayDuration()).a(bVar).an(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.7.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (m.this.oJ != null) {
                            m.this.oJ.onAdClicked();
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eX == null) {
            this.eX = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.a.m.9
                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    if (!m.this.eV) {
                        if (m.this.eM != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = m.this.eM;
                            m mVar = m.this;
                            aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (m.this.eU == null) {
                        m mVar2 = m.this;
                        mVar2.eU = mVar2.bq();
                    }
                    IAdLivePlayModule iAdLivePlayModule = m.this.eU;
                    m mVar3 = m.this;
                    iAdLivePlayModule.setAudioEnabled(mVar3.g(mVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.eX;
    }

    private x.a getOpenNewPageListener() {
        return new x.a() { // from class: com.kwad.components.ad.feed.a.m.6
            @Override // com.kwad.components.core.webview.jshandler.x.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0405a().ar(bVar.title).as(bVar.url).ax(true).M(m.this.mAdTemplate).ow());
            }
        };
    }

    private af.c getRegisterLiveListener() {
        return new af.c() { // from class: com.kwad.components.ad.feed.a.m.2
            @Override // com.kwad.components.core.webview.jshandler.af.c
            public final void a(af.b bVar) {
                m.this.fH = bVar;
                if (m.this.fI != null) {
                    m.this.fH.a(m.this.fI);
                    m.this.fI = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.a.m.15
            private boolean cJ = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.ax(m.this.mAdTemplate);
                m.this.fA.aM(9);
                m.this.eK.setVisibility(8);
                if (com.kwad.components.ad.feed.kwai.b.be() && m.this.eO == null && !m.this.fS) {
                    m mVar = m.this;
                    mVar.eO = new d(mVar.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar2 = m.this;
                    mVar2.addView(mVar2.eO, layoutParams);
                    m.this.eO.bu();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                m.this.c(j2);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i2, int i3) {
                com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.a.a.E(m.this.mAdInfo), i2 + " " + i3, SystemClock.elapsedRealtime() - m.this.ew);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.h.a.nX().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.a.a.E(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ew);
                com.kwad.sdk.core.report.a.h(m.this.mAdTemplate);
                m.this.fA.aM(3);
                if (m.this.eO != null && (m.this.eO.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.eO.getParent()).removeView(m.this.eO);
                    m.this.eO.bv();
                    m.this.eO = null;
                }
                if (m.this.fQ == null && com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate) && m.this.fS) {
                    m mVar = m.this;
                    mVar.fQ = new e(mVar.mContext);
                    m.this.eK.addView(m.this.fQ, new FrameLayout.LayoutParams(-1, -1));
                    m.this.fQ.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.a.m.15.1
                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.a.b.bo(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.y(158);
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.a.b.bo(m.this.mAdTemplate) || !com.kwad.sdk.core.response.a.c.bQ(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.y(TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
                        }
                    });
                    m.this.fQ.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.m.15.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.fR.aL(1);
                            m.this.eK.removeView(m.this.fQ);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!this.cJ) {
                    this.cJ = true;
                    com.kwad.components.core.m.a.pr().a(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.eM;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
            }
        };
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.feed.a.m.19
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.feed.monitor.a.c(com.kwad.sdk.core.response.a.b.bl(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                m.this.g("1", 2);
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        bVar.aoM = null;
        bVar.LI = this.fw;
        bVar.Lk = this.mAdWebView;
        bVar.mReportExtData = null;
        bVar.aoO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final int i2) {
        bD();
        com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(this)).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(1).al(true).ao(i2).an(5).an(false).ap(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.16
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                m.this.aH(i2);
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        if (view != this.eK) {
            if (view == this.fz) {
                a(this.eM, 25);
            }
        } else {
            if (!this.eM.isIdle()) {
                a(this.eM, 100);
                return;
            }
            com.kwad.sdk.utils.l.ct(this.mAdTemplate);
            this.eM.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate));
            this.eM.start();
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String url = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.eL.setVisibility(8);
        } else {
            this.eL.setImageDrawable(null);
            KSImageLoader.loadImage(this.eL, url, this.mAdTemplate);
            this.eL.setVisibility(0);
        }
        this.eM = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.eM.setTag(this.cI);
        String strE = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        this.eM.a(new b.a(this.mAdTemplate).bd(strE).be(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).uc(), null);
        this.eM.setVideoSoundEnable(g(this.mIsAudioEnable));
        this.eN = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eM, ksAdVideoPlayConfig);
        this.ew = SystemClock.elapsedRealtime();
        this.eN.setVideoPlayCallback(getVideoPlayCallback());
        this.eN.setAdClickListener(this.eR);
        this.eM.setController(this.eN);
        if (this.eK.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eK;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eK.setTag(null);
        }
        this.eK.addView(this.eM, 1);
        this.eK.setTag(this.eM);
        this.eK.setClickable(true);
        new com.kwad.sdk.widget.f(this.eK, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.b.ar(this.mContext).a(this.eY);
        }
        int i2 = this.mAdTemplate.type;
        if (i2 == 1 || i2 == 19) {
            this.fy.setVisibility(0);
            this.fz.setVisibility(0);
            this.fz.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
            new com.kwad.sdk.widget.f(this.fz, this);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void aS() {
        super.aS();
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
            if (view == this.eK || view == this.fz) {
                a(this.eM, TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bC() {
        ae aeVar;
        b.InterfaceC0422b interfaceC0422b;
        if (!this.mAdTemplate.mPvReported && (interfaceC0422b = this.oJ) != null) {
            interfaceC0422b.onAdShow();
            com.kwad.components.ad.feed.monitor.a.a(this.mAdTemplate, 2);
        }
        if (this.fJ || (aeVar = this.fB) == null) {
            return;
        }
        aeVar.rs();
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        c(adTemplate);
        adTemplate.realShowType = 2;
        super.bindView(adTemplate);
        if (this.fF) {
            com.kwad.components.core.widget.b bVar = this.fK;
            if (bVar != null) {
                bVar.bindView(this.mAdTemplate);
                com.kwad.components.core.widget.b bVar2 = this.fK;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.dY);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.a.b.br(this.mAdTemplate)) {
            g("0", 0);
            return;
        }
        if (!bE()) {
            e(this.mAdTemplate);
        }
        try {
            if (this.fG == null || !this.fG.equals(adTemplate.mOriginJString)) {
                if (bE()) {
                    this.mAdWebView.reload();
                } else {
                    aF();
                }
            }
        } catch (Throwable unused) {
            g("0", 0);
        }
        this.fG = adTemplate.mOriginJString;
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        com.kwad.components.ad.feed.monitor.a.bh();
        this.fw = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.eK = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.fy = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.fz = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.eL = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eW = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            boolean r1 = com.kwad.sdk.core.config.d.uU()
            if (r1 == 0) goto L8d
            T extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            boolean r1 = com.kwad.sdk.core.response.a.c.bQ(r1)
            if (r1 != 0) goto L16
            goto L8d
        L16:
            T extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            com.kwad.sdk.core.response.model.FeedSlideConf r1 = com.kwad.sdk.core.response.a.b.aL(r1)
            if (r1 != 0) goto L23
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L23:
            r9.a(r10)
            r2 = 2
            if (r0 == r2) goto L2c
            r2 = 3
            if (r0 != r2) goto L88
        L2c:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            if (r0 == 0) goto L88
            boolean r0 = r9.fJ
            if (r0 != 0) goto L88
            float r0 = r10.getX()
            float r2 = r9.fL
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L88
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r2 = 1
            r0.requestDisallowInterceptTouchEvent(r2)
            float r0 = r10.getX()
            float r2 = r9.fL
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r10.getY()
            float r3 = r9.fM
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r3 = r1.maxRange
            double r3 = (double) r3
            double r3 = java.lang.Math.tan(r3)
            double r5 = (double) r0
            java.lang.Double.isNaN(r5)
            double r3 = r3 * r5
            double r7 = (double) r2
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 < 0) goto L82
            int r0 = r1.minRange
            double r0 = (double) r0
            double r0 = java.lang.Math.tan(r0)
            java.lang.Double.isNaN(r5)
            double r0 = r0 * r5
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 >= 0) goto L88
        L82:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
        L88:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L8d:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.a.m.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        if (this.ei != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.a.b.bp(this.mAdTemplate), this.mContext, this.ei);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        this.mHandler.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.l.cs(this.mAdTemplate);
        d.b bVar = this.ei;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
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
        this.fH = null;
        this.fI = null;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z2);
        if (!z2) {
            IAdLiveOfflineView iAdLiveOfflineView = this.eS;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.eU) == null) {
                return;
            }
            iAdLivePlayModule.onPause();
            return;
        }
        if (bp()) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.eK) {
            viewGroup.removeView(this.eM);
            if (this.eK.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eK;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eK.setTag(null);
            }
            this.eK.addView(this.eM);
            this.eK.setTag(this.eM);
            this.eM.setVideoSoundEnable(this.mIsAudioEnable);
            this.eN.setVideoPlayCallback(getVideoPlayCallback());
            this.eN.setAdClickListener(this.eR);
            this.eN.getAdTemplate().mAdWebVideoPageShowing = false;
            this.eN.qP();
            this.eN.setAutoRelease(true);
        }
        AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.a.a.E(this.mAdInfo));
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i2) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.fO;
        if (aVar2 != null) {
            aVar2.c(this.cU == 1 ? 2 : 1, "");
        }
        this.fO = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dY = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eN) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i2) {
        if (i2 <= 0) {
            i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i2;
    }
}
