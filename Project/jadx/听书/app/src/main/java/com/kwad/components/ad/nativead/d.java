package com.kwad.components.ad.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.nativead.b;
import com.kwad.components.ad.nativead.monitor.NativeAdMonitor;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    private Vibrator gZ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private volatile bv mTimerHelper;
    private b.c oG;
    private b.e oH;
    private boolean oM;
    private KsNativeAd.AdInteractionListener oN;
    private f oO;
    private e oP;
    private KsNativeAd.VideoPlayListener oQ;
    private com.kwad.components.ad.nativead.d.a oU;
    private boolean oR = false;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private int oS = 0;
    private int oT = 0;
    private KsNativeAd.VideoPlayListener oV = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.nativead.d.10
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.oQ != null) {
                d.this.oQ.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.oQ != null) {
                d.this.oQ.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (d.this.oQ != null) {
                d.this.oQ.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.oQ != null) {
                try {
                    d.this.oQ.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.oQ != null) {
                try {
                    d.this.oQ.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.oQ != null) {
                try {
                    d.this.oQ.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }
    };
    private a oW = new a() { // from class: com.kwad.components.ad.nativead.d.2
        @Override // com.kwad.components.ad.nativead.d.a
        public final void m(View view) {
            if (d.this.oN != null) {
                d.this.oN.onAdClicked(new FrameLayout(m.el(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void fr() {
            if (d.this.oN != null) {
                d.this.oN.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.oN == null) {
                return false;
            }
            try {
                return d.this.oN.handleDownloadDialog(onClickListener);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return false;
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.oN != null) {
                try {
                    d.this.oN.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.oN != null) {
                try {
                    d.this.oN.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }
    };

    public interface a {
        void fr();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void m(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    static /* synthetic */ boolean b(d dVar, aj.a aVar) {
        return c(aVar);
    }

    public d(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mAdInfo = adInfoEl;
        if (com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.nativead.d.1
                @Override // com.kwad.components.core.e.d.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.oW.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.O(this.mAdInfo), this.mAdTemplate);
    }

    public final synchronized bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bv();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        return BitmapFactory.decodeResource(ServiceProvider.getContext().getResources(), R.drawable.ksad_sdk_logo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.b.a.au(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdSource() {
        return com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdSourceLogoUrl(int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        if (i == 1) {
            return adInfo.adBaseInfo.adGrayMarkIcon;
        }
        return adInfo.adBaseInfo.adMarkIcon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    /* JADX INFO: renamed from: fo, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAV = com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
        if (TextUtils.isEmpty(materialFeatureAV.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(materialFeatureAV.width, materialFeatureAV.height, materialFeatureAV.coverUrl);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        if (com.kwad.sdk.core.response.b.a.cR(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).videoWidth;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        return com.kwad.sdk.core.response.b.a.cR(this.mAdInfo) ? LogType.UNEXP_ANR : com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        int iBe = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
        if (iBe == 2 || iBe == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfoEl.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.b.a.co(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.b.a.av(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.b.a.bC(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.b.a.bD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getIntroductionInfo() {
        return com.kwad.sdk.core.response.b.a.bF(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getIntroductionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bG(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.b.a.bH(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.b.a.bI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.b.a.ay(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.b.a.bJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.b.a.aE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.b.a.ax(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final KsLiveInfo getLiveInfo() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBx)) {
            return com.kwad.sdk.core.response.b.e.eC(this.mAdTemplate);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.Ft()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.adlog.c.bX(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.adlog.c.bY(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(ViewGroup viewGroup, List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        NativeAdMonitor.a(viewGroup, 1);
        this.oN = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        NativeAdMonitor.a(viewGroup, 1);
        this.oN = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    private void a(Activity activity, ViewGroup viewGroup, List<View> list) {
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            a(activity, viewGroup, 0, it.next(), false);
        }
    }

    private void a(Activity activity, ViewGroup viewGroup, Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    private void a(final Activity activity, final ViewGroup viewGroup, int i, final View view, final boolean z) {
        final aj.a aVar = new aj.a();
        if (view == null) {
            return;
        }
        final int[] iArrS = S(i);
        if (view instanceof f) {
            ((f) view).g(iArrS[1], iArrS[2]);
        } else {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.nativead.d.3
                private int[] oY = new int[2];

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.B(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.oY);
                        aVar.e(Math.abs(motionEvent.getRawX() - this.oY[0]), Math.abs(motionEvent.getRawY() - this.oY[1]));
                    } else if (action == 1) {
                        aVar.f(Math.abs(motionEvent.getRawX() - this.oY[0]), Math.abs(motionEvent.getRawY() - this.oY[1]));
                        if (com.kwad.sdk.utils.b.g(aVar)) {
                            if (iArrS[2] != 1 && d.this.b(aVar)) {
                                view.setPressed(false);
                                d.this.a(activity, view2, aVar, iArrS[0], z, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT);
                            }
                            return true;
                        }
                        if (iArrS[1] != 1 && com.kwad.sdk.core.config.e.ER()) {
                            if (d.b(d.this, aVar)) {
                                d.this.a(activity, view2, aVar, iArrS[0], z, 0);
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.nativead.d.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int[] iArr = iArrS;
                    if (iArr[1] != 0) {
                        return;
                    }
                    d.this.a(activity, view2, aVar, iArr[0], z, 0);
                }
            });
        }
    }

    private static int[] S(int i) {
        int i2;
        int i3 = 0;
        if (i == 3 || i == 4) {
            i2 = 1;
        } else if (i == 5 || i == 6) {
            i2 = 0;
            i3 = 1;
        } else {
            i2 = 0;
        }
        return new int[]{i % 2 == 0 ? 2 : 1, i3, i2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(aj.a aVar) {
        return com.kwad.sdk.utils.b.a(aVar, com.kwad.sdk.core.response.b.a.U(this.mAdInfo));
    }

    private static boolean c(aj.a aVar) {
        return (Math.abs(aVar.QO() - aVar.QQ()) < 20) && (Math.abs(aVar.QP() - aVar.QR()) < 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, final View view, final aj.a aVar, int i, boolean z, final int i2) {
        long playDuration;
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
        e eVar = this.oP;
        if (eVar != null && eVar.hR != null) {
            playDuration = this.oP.hR.getPlayDuration();
        } else {
            f fVar = this.oO;
            playDuration = (fVar == null || fVar.pr == null) ? 0L : this.oO.pr.getPlayDuration();
        }
        com.kwad.components.core.e.d.a.a(new a.C0333a(contextWrapContextIfNeed).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aE(i).aq(true).A(playDuration).ax(z).a(new a.b() { // from class: com.kwad.components.ad.nativead.d.5
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(aVar).dd(i2), (JSONObject) null);
                d.this.oW.m(view);
            }
        }));
    }

    private void a(final ViewGroup viewGroup) {
        if (!this.oM) {
            this.oM = true;
            com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        }
        if (!com.kwad.sdk.core.config.e.FK() && com.kwad.sdk.core.config.e.FJ() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            NativeAdMonitor.a(viewGroup, 2);
            aVar.setViewCallback(new a.InterfaceC0364a() { // from class: com.kwad.components.ad.nativead.d.6
                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void onWindowFocusChanged(boolean z) {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void aa() {
                    com.kwad.components.ad.i.b.fR().a(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void ab() {
                    try {
                        long jSn = d.this.getTimerHelper().Sn();
                        if (d.this.mAdTemplate.mPvReported && d.this.oR) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, jSn, (JSONObject) null);
                            d.this.oR = false;
                        }
                        if (com.kwad.sdk.core.response.b.a.cS(d.this.mAdInfo)) {
                            com.kwad.sdk.core.adlog.c.m(d.this.mAdTemplate, ((int) jSn) / 1000);
                        }
                        d.this.bz.i(d.this);
                        b.fm().a(d.this.oH);
                        b.fm().a(d.this.oG);
                        com.kwad.components.ad.i.b.fR().b(d.this);
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void c(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.oW.fr();
                        d.this.fp();
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.w(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.b.a.cR(d.this.mAdInfo)) {
                            a.C0392a c0392a = new a.C0392a();
                            c0392a.showLiveStyle = d.this.oT;
                            c0392a.showLiveStatus = d.this.oS;
                            bVar.b(c0392a);
                        }
                        com.kwad.components.core.t.b.sY().a(d.this.mAdTemplate, null, bVar);
                        if (d.this.enableRotate()) {
                            com.kwad.sdk.core.adlog.c.b(d.this.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, (JSONObject) null);
                        }
                        NativeAdMonitor.a(viewGroup, 4);
                    }
                    if (!d.this.oR) {
                        d.this.k(view);
                        d.this.l(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.bz.h(d.this);
                    }
                    b.fm().N(viewGroup.getContext());
                    d.this.oR = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void ay() {
                    try {
                        if (d.this.mAdTemplate.mPvReported && d.this.oR) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, d.this.getTimerHelper().Sn(), (JSONObject) null);
                            d.this.oR = false;
                            b.fm().a(d.this.oH);
                            b.fm().a(d.this.oG);
                            b.fm().D(viewGroup.getContext());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
            aVar.vU();
            return;
        }
        com.kwad.components.core.widget.c cVarB = b(viewGroup);
        if (cVarB == null) {
            cVarB = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarB);
        }
        cVarB.setViewCallback(new c.a() { // from class: com.kwad.components.ad.nativead.d.7
            @Override // com.kwad.components.core.widget.c.a
            public final void fs() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.oW.fr();
                }
                d.this.fp();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.w(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.b.a.cR(d.this.mAdInfo)) {
                    a.C0392a c0392a = new a.C0392a();
                    c0392a.showLiveStyle = d.this.oT;
                    c0392a.showLiveStatus = d.this.oS;
                    bVar.b(c0392a);
                }
                com.kwad.components.core.t.b.sY().a(d.this.mAdTemplate, null, bVar);
                com.kwad.sdk.commercial.d.c.bL(d.this.mAdTemplate);
            }
        });
        cVarB.setNeedCheckingShow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp() {
        try {
            this.oS = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.oT = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final View view) {
        if (com.kwad.sdk.core.response.b.a.ai(this.mAdInfo) || com.kwad.sdk.core.response.b.b.cZ(this.mAdTemplate)) {
            float fDa = com.kwad.sdk.core.response.b.b.da(this.mAdTemplate);
            if (fDa <= 0.0f) {
                fDa = com.kwad.sdk.core.response.b.a.aj(this.mAdInfo);
            }
            this.oH = new b.e() { // from class: com.kwad.components.ad.nativead.d.8
                @Override // com.kwad.components.ad.nativead.b.e
                public final void f(final double d) {
                    if (d.this.fq() && b.bY()) {
                        com.kwad.components.core.e.d.a.a(new a.C0333a(m.wrapContextIfNeed(view.getContext())).aB(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).ax(false).a(new a.b() { // from class: com.kwad.components.ad.nativead.d.8.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dd(157).l(d), (JSONObject) null);
                                d.this.oW.m(view);
                            }
                        }));
                        bw.a(view.getContext(), d.this.F(view.getContext()));
                    }
                }
            };
            b.fm().a(fDa, view, this.oH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final View view) {
        AdMatrixInfo.RotateInfo rotateInfoDm = com.kwad.sdk.core.response.b.b.dm(this.mAdTemplate);
        if (rotateInfoDm == null || !rotateInfoDm.enable) {
            return;
        }
        this.oG = new b.c() { // from class: com.kwad.components.ad.nativead.d.9
            @Override // com.kwad.components.ad.nativead.b.c
            public final void B(final String str) {
                if (bz.o(view, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) && d.this.fq() && b.bY()) {
                    com.kwad.components.core.e.d.a.a(new a.C0333a(m.wrapContextIfNeed(view.getContext())).aB(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).ax(false).a(new a.b() { // from class: com.kwad.components.ad.nativead.d.9.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dd(161).dv(str), (JSONObject) null);
                            d.this.oW.m(view);
                        }
                    }));
                    bw.a(view.getContext(), d.this.F(view.getContext()));
                }
            }
        };
        b.fm().a(rotateInfoDm, view.getContext(), this.oG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (this.gZ == null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
        return this.gZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fq() {
        return (this.mAdInfo.status == 2 || this.mAdInfo.status == 3) ? false : true;
    }

    private static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    private static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.oQ = videoPlayListener;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void startVideo() {
        f fVar = this.oO;
        if (fVar != null) {
            fVar.setPlayState(1);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void pauseVideo() {
        f fVar = this.oO;
        if (fVar != null) {
            fVar.setPlayState(2);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void stopVideo() {
        f fVar = this.oO;
        if (fVar != null) {
            fVar.setPlayState(3);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final boolean enableRotate() {
        AdMatrixInfo.RotateInfo rotateInfoDm = com.kwad.sdk.core.response.b.b.dm(this.mAdTemplate);
        return rotateInfoDm != null && rotateInfoDm.enable;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final View getRotateView(Context context) {
        if (this.oU == null) {
            com.kwad.components.ad.nativead.d.a aVar = new com.kwad.components.ad.nativead.d.a(context);
            this.oU = aVar;
            aVar.fM();
            NativeAdMonitor.fx();
            NativeAdMonitor.fw();
        }
        return this.oU;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context == null || !l.Cf().Bn()) {
            return null;
        }
        return getVideoView2(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl;
        if (context == null || !l.Cf().Bn()) {
            return null;
        }
        try {
            Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            } else {
                kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            }
            if (com.kwad.sdk.core.response.b.a.cR(this.mAdInfo)) {
                return a(contextWrapContextIfNeed, kSAdVideoPlayConfigImpl);
            }
            return b(contextWrapContextIfNeed, kSAdVideoPlayConfigImpl);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (l.Cf().Bk()) {
                runtimeException.addSuppressed(th);
                com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
                return null;
            }
            throw th;
        }
    }

    private View a(Context context, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
        if (aVar == null || !aVar.qu()) {
            return null;
        }
        if (this.oP == null) {
            e eVar = new e(context);
            this.oP = eVar;
            eVar.setInnerAdInteractionListener(this.oW);
            this.oP.setVideoPlayListener(this.oV);
            this.oP.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.oP;
    }

    private View b(Context context, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.c.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.oO == null) {
            f fVar = new f(context);
            this.oO = fVar;
            fVar.setInnerAdInteractionListener(this.oW);
            this.oO.setVideoPlayListener(this.oV);
            this.oO.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.oO;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.oW.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.oW;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }
}
