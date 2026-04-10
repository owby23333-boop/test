package com.kwad.components.ad.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.ad.e.b;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.logger.model.BusinessType;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Vibrator ef;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private b.c mC;

    @Nullable
    private KsNativeAd.AdInteractionListener mG;
    private f mH;
    private e mI;

    @Nullable
    private KsNativeAd.VideoPlayListener mJ;
    private bg mTimerHelper;
    private boolean mK = false;
    private com.kwad.components.core.internal.api.c ch = new com.kwad.components.core.internal.api.c();
    private int mL = 0;
    private int mM = 0;
    private KsNativeAd.VideoPlayListener mN = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.e.d.8
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.mJ != null) {
                d.this.mJ.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i2, int i3) {
            if (d.this.mJ != null) {
                d.this.mJ.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.mJ != null) {
                d.this.mJ.onVideoPlayStart();
            }
        }
    };
    private a mO = new a() { // from class: com.kwad.components.ad.e.d.9
        @Override // com.kwad.components.ad.e.d.a
        public final void eO() {
            if (d.this.mG != null) {
                d.this.mG.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.mG == null) {
                return false;
            }
            try {
                return d.this.mG.handleDownloadDialog(onClickListener);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return false;
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void l(View view) {
            if (d.this.mG != null) {
                d.this.mG.onAdClicked(new FrameLayout(Wrapper.unwrapContextIfNeed(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.mG != null) {
                try {
                    d.this.mG.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.mG != null) {
                try {
                    d.this.mG.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };

    public interface a {
        void eO();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void l(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.e.d.1
                @Override // com.kwad.components.core.d.b.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.mO.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.H(this.mAdInfo), this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (this.ef == null) {
            this.ef = (Vibrator) context.getSystemService("vibrator");
        }
        return this.ef;
    }

    private View a(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar == null || !aVar.hasLiveCompoReady()) {
            return null;
        }
        if (this.mI == null) {
            this.mI = new e(context);
            this.mI.setInnerAdInteractionListener(this.mO);
            this.mI.setVideoPlayListener(this.mN);
            this.mI.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable Activity activity, final View view, final ab.a aVar, int i2, boolean z2, final int i3) {
        IAdLivePlayModule iAdLivePlayModule;
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        a.C0395a c0395aAl = new a.C0395a(Wrapper.wrapContextIfNeed(context)).J(this.mAdTemplate).b(this.mApkDownloadHelper).aq(i2).al(true);
        e eVar = this.mI;
        com.kwad.components.core.d.b.a.a(c0395aAl.q((eVar == null || (iAdLivePlayModule = eVar.eU) == null) ? 0L : iAdLivePlayModule.getPlayDuration()).as(z2).a(new a.b() { // from class: com.kwad.components.ad.e.d.4
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().c(aVar).bf(i3), (JSONObject) null);
                d.this.mO.l(view);
            }
        }));
    }

    private void a(final Activity activity, @NonNull final ViewGroup viewGroup, final int i2, final View view, final boolean z2) {
        final ab.a aVar = new ab.a();
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.e.d.2
            private int[] mQ = new int[2];

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.t(viewGroup.getWidth(), viewGroup.getHeight());
                    viewGroup.getLocationOnScreen(this.mQ);
                    aVar.f(Math.abs(motionEvent.getRawX() - this.mQ[0]), Math.abs(motionEvent.getRawY() - this.mQ[1]));
                } else if (action == 1) {
                    aVar.g(Math.abs(motionEvent.getRawX() - this.mQ[0]), Math.abs(motionEvent.getRawY() - this.mQ[1]));
                    if (d.this.b(aVar)) {
                        view.setPressed(false);
                        d.this.a(activity, view2, aVar, i2, z2, TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
                    }
                }
                return false;
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.e.d.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.a(activity, view2, aVar, i2, z2, 0);
            }
        });
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            a(activity, viewGroup, 0, it.next(), false);
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    private void a(final ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.uT() && com.kwad.sdk.core.config.d.uS() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0421a() { // from class: com.kwad.components.ad.e.d.5
                @Override // com.kwad.components.core.widget.a.InterfaceC0421a
                public final void eM() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mK) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EV(), (JSONObject) null);
                        d.this.mK = false;
                        b.eI().a(d.this.mC);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0421a
                public final void k(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.mO.eO();
                        d.this.eL();
                        i iVar = new i();
                        iVar.p(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.a.a.co(d.this.mAdInfo)) {
                            y.a aVar2 = new y.a();
                            aVar2.showLiveStyle = d.this.mM;
                            aVar2.showLiveStatus = d.this.mL;
                            iVar.a(aVar2);
                        }
                        com.kwad.components.core.r.c.qa().a(d.this.mAdTemplate, null, iVar);
                    }
                    if (!d.this.mK) {
                        d.this.j(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.ch.a(d.this);
                    }
                    d.this.mK = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0421a
                public final void onViewDetached() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mK) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EV(), (JSONObject) null);
                        d.this.mK = false;
                    }
                    d.this.getTimerHelper().EV();
                    d.this.ch.b(d.this);
                    b.eI().a(d.this.mC);
                }
            });
            aVar.rK();
            return;
        }
        com.kwad.components.core.widget.c cVarB = b(viewGroup);
        if (cVarB == null) {
            cVarB = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarB);
        }
        cVarB.setViewCallback(new c.a() { // from class: com.kwad.components.ad.e.d.6
            @Override // com.kwad.components.core.widget.c.a
            public final void eN() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.mO.eO();
                }
                d.this.eL();
                i iVar = new i();
                iVar.p(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.a.a.co(d.this.mAdInfo)) {
                    y.a aVar2 = new y.a();
                    aVar2.showLiveStyle = d.this.mM;
                    aVar2.showLiveStatus = d.this.mL;
                    iVar.a(aVar2);
                }
                com.kwad.components.core.r.c.qa().a(d.this.mAdTemplate, null, iVar);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "adShowSuccess").report();
            }
        });
        cVarB.setNeedCheckingShow(true);
    }

    private View b(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.b.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.mH == null) {
            this.mH = new f(context);
            this.mH.setInnerAdInteractionListener(this.mO);
            this.mH.setVideoPlayListener(this.mN);
            this.mH.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mH;
    }

    private static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ab.a aVar) {
        return ((Math.abs(aVar.DE() - aVar.DG()) > 20) || (Math.abs(aVar.DF() - aVar.DH()) > 20)) && com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate);
    }

    private static void c(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* JADX INFO: renamed from: eK, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = com.kwad.sdk.core.response.a.a.aO(this.mAdInfo);
        if (TextUtils.isEmpty(materialFeatureAO.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(materialFeatureAO.width, materialFeatureAO.height, materialFeatureAO.coverUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL() {
        try {
            this.mL = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.mM = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final View view) {
        if (com.kwad.sdk.core.response.a.a.aa(this.mAdInfo)) {
            float fAb = com.kwad.sdk.core.response.a.a.ab(this.mAdInfo);
            this.mC = new b.c() { // from class: com.kwad.components.ad.e.d.7
                @Override // com.kwad.components.ad.e.b.c
                public final void f(final double d2) {
                    if (d.this.mAdInfo.status == 3 || d.this.mAdInfo.status == 2) {
                        return;
                    }
                    com.kwad.components.core.d.b.a.a(new a.C0395a(Wrapper.wrapContextIfNeed(view.getContext())).J(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).as(false).a(new a.b() { // from class: com.kwad.components.ad.e.d.7.1
                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().bf(157).i(d2), (JSONObject) null);
                            d.this.mO.l(view);
                        }
                    }));
                    bh.a(view.getContext(), d.this.F(view.getContext()));
                }
            };
            b.eI().a(fAb, view, this.mC);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.ch.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.ch.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getActionDescription() {
        return com.kwad.sdk.core.response.a.a.ax(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        return com.kwad.sdk.core.response.a.a.ao(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        return com.kwad.sdk.core.response.a.a.aw(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSourceLogoUrl(int i2) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        return i2 != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        return com.kwad.sdk.core.response.a.a.bL(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        return com.kwad.sdk.core.response.a.a.ap(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        return com.kwad.sdk.core.response.a.a.ar(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        return com.kwad.sdk.core.response.a.a.bt(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.a.a.br(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        return com.kwad.sdk.core.response.a.a.at(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        return com.kwad.sdk.core.response.a.a.bs(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        return com.kwad.sdk.core.response.a.a.bo(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.aK(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int iAX = com.kwad.sdk.core.response.a.a.aX(this.mAdInfo);
        if (iAX == 2 || iAX == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfoCb.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aX(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.d.uD()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        return com.kwad.sdk.core.response.a.a.bp(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.a.a.bq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getProductName() {
        return com.kwad.sdk.core.response.a.a.aq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ksad_sdk_logo);
    }

    public final bg getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bg();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoDuration() {
        return com.kwad.sdk.core.response.a.a.F(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        if (com.kwad.sdk.core.response.a.a.co(this.mAdInfo)) {
            return 1280;
        }
        return com.kwad.sdk.core.response.a.a.aO(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        return com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        View viewA = null;
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            context = Wrapper.wrapContextIfNeed(context);
            com.kwad.sdk.f.a.T(com.anythink.expressad.foundation.g.a.f.a, TTLogUtil.TAG_EVENT_SHOW);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "callShow").report();
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl ? (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig : new KSAdVideoPlayConfigImpl();
            viewA = com.kwad.sdk.core.response.a.a.co(this.mAdInfo) ? a(context, kSAdVideoPlayConfigImpl) : b(context, kSAdVideoPlayConfigImpl);
            com.kwad.sdk.f.a.U(com.anythink.expressad.foundation.g.a.f.a, TTLogUtil.TAG_EVENT_SHOW);
            return viewA;
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                runtimeException.addSuppressed(th);
            }
            com.kwad.components.core.c.a.b(runtimeException);
            return viewA;
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z2) {
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z2).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        if (com.kwad.sdk.core.response.a.a.co(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.a.a.aO(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.mO.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.mO;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mG = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mG = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.a.ax(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.a.h(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.j(adTemplate, j3);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mJ = videoPlayListener;
    }
}
