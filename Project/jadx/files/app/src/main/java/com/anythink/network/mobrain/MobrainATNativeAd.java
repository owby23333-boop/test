package com.anythink.network.mobrain;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATNativeAd extends CustomNativeAd {
    GMNativeAd a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ViewGroup f12557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f12559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12560f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f12561g;

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATNativeAd$2, reason: invalid class name */
    final class AnonymousClass2 implements GMVideoListener {
        AnonymousClass2() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public final void onProgressUpdate(long j2, long j3) {
            if (MobrainATNativeAd.this.getVideoDuration() == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                MobrainATNativeAd mobrainATNativeAd = MobrainATNativeAd.this;
                double d2 = j3;
                Double.isNaN(d2);
                mobrainATNativeAd.setVideoDuration(d2 / 1000.0d);
            }
            MobrainATNativeAd mobrainATNativeAd2 = MobrainATNativeAd.this;
            double d3 = j2;
            Double.isNaN(d3);
            mobrainATNativeAd2.f12559e = d3 / 1000.0d;
            mobrainATNativeAd2.notifyAdVideoPlayProgress((int) mobrainATNativeAd2.f12559e);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public final void onVideoCompleted() {
            MobrainATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public final void onVideoError(AdError adError) {
            MobrainATNativeAd.this.notifyAdVideoVideoPlayFail("", adError.toString());
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public final void onVideoPause() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public final void onVideoResume() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public final void onVideoStart() {
            MobrainATNativeAd.this.notifyAdVideoStart();
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATNativeAd$3, reason: invalid class name */
    final class AnonymousClass3 implements GMAdAppDownloadListener {
        AnonymousClass3() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onDownloadFailed(long j2, long j3, String str, String str2) {
            if (((a) MobrainATNativeAd.this).mDownloadListener == null || !(((a) MobrainATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((a) MobrainATNativeAd.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onDownloadFinished(long j2, String str, String str2) {
            if (((a) MobrainATNativeAd.this).mDownloadListener == null || !(((a) MobrainATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((a) MobrainATNativeAd.this).mDownloadListener).onDownloadFinish(j2, str, str2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onDownloadPaused(long j2, long j3, String str, String str2) {
            if (((a) MobrainATNativeAd.this).mDownloadListener == null || !(((a) MobrainATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((a) MobrainATNativeAd.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onDownloadProgress(long j2, long j3, int i2, int i3) {
            MobrainATNativeAd mobrainATNativeAd = MobrainATNativeAd.this;
            String appName = "";
            if (mobrainATNativeAd.f12560f) {
                if (((a) mobrainATNativeAd).mDownloadListener == null || !(((a) MobrainATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                if (MobrainATNativeAd.this.a.getNativeAdAppInfo() != null && !TextUtils.isEmpty(MobrainATNativeAd.this.a.getNativeAdAppInfo().getAppName())) {
                    appName = MobrainATNativeAd.this.a.getNativeAdAppInfo().getAppName();
                }
                ((CustomAdapterDownloadListener) ((a) MobrainATNativeAd.this).mDownloadListener).onDownloadUpdate(j2, j3, "", appName);
                return;
            }
            mobrainATNativeAd.f12560f = true;
            if (((a) mobrainATNativeAd).mDownloadListener == null || !(((a) MobrainATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            if (MobrainATNativeAd.this.a.getNativeAdAppInfo() != null && !TextUtils.isEmpty(MobrainATNativeAd.this.a.getNativeAdAppInfo().getAppName())) {
                appName = MobrainATNativeAd.this.a.getNativeAdAppInfo().getAppName();
            }
            ((CustomAdapterDownloadListener) ((a) MobrainATNativeAd.this).mDownloadListener).onDownloadStart(j2, j3, "", appName);
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onDownloadStarted() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (((a) MobrainATNativeAd.this).mDownloadListener == null || !(((a) MobrainATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((a) MobrainATNativeAd.this).mDownloadListener).onInstalled(str, str2);
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATNativeAd$4, reason: invalid class name */
    final class AnonymousClass4 implements GMDislikeCallback {
        AnonymousClass4() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public final void onCancel() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public final void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public final void onSelected(int i2, String str) {
            MobrainATNativeAd.this.notifyAdDislikeClick();
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public final void onShow() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATNativeAd$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ GMAdDislike a;

        AnonymousClass5(GMAdDislike gMAdDislike) {
            this.a = gMAdDislike;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.setDislikeCallback(new GMDislikeCallback() { // from class: com.anythink.network.mobrain.MobrainATNativeAd.5.1
                @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
                public final void onCancel() {
                }

                @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
                public final void onRefuse() {
                }

                @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
                public final void onSelected(int i2, String str) {
                    MobrainATNativeAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
                public final void onShow() {
                }
            });
            this.a.showDislikeDialog();
        }
    }

    public MobrainATNativeAd(Context context, final GMNativeAd gMNativeAd) {
        this.b = context.getApplicationContext();
        this.a = gMNativeAd;
        this.f12558d = 9527;
        try {
            this.f12558d = this.b.getResources().getIdentifier("anythink_mobrain_mediaview_id", "id", this.b.getPackageName());
        } catch (Throwable unused) {
        }
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setCallToActionText(this.a.getActionText());
        setMainImageUrl(this.a.getImageUrl());
        setMainImageWidth(this.a.getImageWidth());
        setMainImageHeight(this.a.getImageHeight());
        setVideoWidth(this.a.getVideoWidth());
        setVideoHeight(this.a.getVideoHeight());
        setIconImageUrl(this.a.getIconUrl());
        setAdFrom(this.a.getSource());
        setImageUrlList(this.a.getImageList());
        setStarRating(Double.valueOf(this.a.getStarRating()));
        setNativeInteractionType(this.a.getInteractionType() == 2 ? 2 : this.a.getInteractionType() == 3 ? 3 : this.a.getInteractionType() == 4 ? 1 : 0);
        if (this.a.getAdImageMode() == 5 || this.a.getAdImageMode() == 15) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        GMNativeAdAppInfo nativeAdAppInfo = this.a.getNativeAdAppInfo();
        if (nativeAdAppInfo != null) {
            setAdAppInfo(new MobrainATDownloadAppInfo(nativeAdAppInfo, this.a.getPackageName()));
        }
        this.a.setVideoListener(new AnonymousClass2());
        this.a.setAppDownloadListener(new AnonymousClass3());
        gMNativeAd.setNativeAdListener(new GMNativeAdListener() { // from class: com.anythink.network.mobrain.MobrainATNativeAd.1
            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
            public final void onAdClick() {
                MobrainATNativeAd.this.notifyAdClicked();
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
            public final void onAdShow() {
                MobrainATNativeAd.this.setNetworkInfoMap(MobrainATConst.a(gMNativeAd));
                MobrainATNativeAd.this.notifyAdImpression();
            }
        });
        gMNativeAd.render();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        this.a.unregisterView();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        GMNativeAd gMNativeAd = this.a;
        if (gMNativeAd != null) {
            gMNativeAd.destroy();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.a.isExpressAd()) {
            if (this.f12561g == null) {
                this.f12561g = this.a.getExpressView();
            }
            return this.f12561g;
        }
        if (this.a.getAdImageMode() != 5 && this.a.getAdImageMode() != 15) {
            return null;
        }
        if (this.f12561g == null) {
            this.f12561g = new TTMediaView(this.b);
            this.f12561g.setId(this.f12558d);
        }
        return this.f12561g;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        this.f12557c = new TTNativeAdView(this.b);
        return this.f12557c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.f12559e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        GMNativeAd gMNativeAd = this.a;
        if (gMNativeAd != null) {
            return gMNativeAd.isExpressAd();
        }
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        GMNativeAd gMNativeAd = this.a;
        if (gMNativeAd != null) {
            gMNativeAd.onPause();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        GMNativeAd gMNativeAd = this.a;
        if (gMNativeAd != null) {
            gMNativeAd.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> creativeClickViewList;
        Context context = view.getContext();
        ViewGroup viewGroup = this.f12557c;
        boolean z2 = context instanceof Activity;
        if (z2 && this.a.isExpressAd()) {
            this.a.setDislikeCallback((Activity) context, new AnonymousClass4());
        }
        View closeView = aTNativePrepareInfo.getCloseView();
        if (this.a.hasDislike() && closeView != null && z2 && !this.a.isExpressAd()) {
            closeView.setOnClickListener(new AnonymousClass5(this.a.getDislikeDialog((Activity) context)));
        }
        ArrayList arrayList = new ArrayList();
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() <= 0) {
            arrayList.add(viewGroup);
        } else {
            arrayList.addAll(clickViewList);
        }
        ArrayList arrayList2 = new ArrayList();
        if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList2.addAll(creativeClickViewList);
        }
        View parentView = aTNativePrepareInfo.getParentView();
        View titleView = aTNativePrepareInfo.getTitleView();
        View descView = aTNativePrepareInfo.getDescView();
        View ctaView = aTNativePrepareInfo.getCtaView();
        View adLogoView = aTNativePrepareInfo.getAdLogoView();
        View iconView = aTNativePrepareInfo.getIconView();
        View adFromView = aTNativePrepareInfo.getAdFromView();
        GMViewBinder.Builder builderIconImageId = new GMViewBinder.Builder(parentView != null ? parentView.getId() : 0).titleId(titleView != null ? titleView.getId() : 0).sourceId(adFromView != null ? adFromView.getId() : 0).descriptionTextId(descView != null ? descView.getId() : 0).callToActionId(ctaView != null ? ctaView.getId() : 0).logoLayoutId(adLogoView != null ? adLogoView.getId() : 0).iconImageId(iconView != null ? iconView.getId() : 0);
        int i2 = this.f12558d;
        if (i2 != 0) {
            builderIconImageId.mediaViewIdId(i2);
        }
        try {
            if (viewGroup.getContext() instanceof Activity) {
                this.a.registerView((Activity) viewGroup.getContext(), viewGroup, arrayList, arrayList2, builderIconImageId.build());
            } else {
                this.a.registerView(viewGroup, arrayList, arrayList2, builderIconImageId.build());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setCallToActionText(this.a.getActionText());
        setMainImageUrl(this.a.getImageUrl());
        setMainImageWidth(this.a.getImageWidth());
        setMainImageHeight(this.a.getImageHeight());
        setVideoWidth(this.a.getVideoWidth());
        setVideoHeight(this.a.getVideoHeight());
        setIconImageUrl(this.a.getIconUrl());
        setAdFrom(this.a.getSource());
        setImageUrlList(this.a.getImageList());
        setStarRating(Double.valueOf(this.a.getStarRating()));
        int i2 = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i2 = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i2 = 2;
        }
        setNativeInteractionType(i2);
        if (this.a.getAdImageMode() == 5 || this.a.getAdImageMode() == 15) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        GMNativeAdAppInfo nativeAdAppInfo = this.a.getNativeAdAppInfo();
        if (nativeAdAppInfo != null) {
            setAdAppInfo(new MobrainATDownloadAppInfo(nativeAdAppInfo, this.a.getPackageName()));
        }
        this.a.setVideoListener(new AnonymousClass2());
        this.a.setAppDownloadListener(new AnonymousClass3());
    }

    private void a(Context context, ATNativePrepareInfo aTNativePrepareInfo, View view) {
        List<View> creativeClickViewList;
        boolean z2 = context instanceof Activity;
        if (z2 && this.a.isExpressAd()) {
            this.a.setDislikeCallback((Activity) context, new AnonymousClass4());
        }
        View closeView = aTNativePrepareInfo.getCloseView();
        if (this.a.hasDislike() && closeView != null && z2 && !this.a.isExpressAd()) {
            closeView.setOnClickListener(new AnonymousClass5(this.a.getDislikeDialog((Activity) context)));
        }
        ArrayList arrayList = new ArrayList();
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList != null && clickViewList.size() > 0) {
            arrayList.addAll(clickViewList);
        } else {
            arrayList.add(view);
        }
        ArrayList arrayList2 = new ArrayList();
        if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList2.addAll(creativeClickViewList);
        }
        View parentView = aTNativePrepareInfo.getParentView();
        View titleView = aTNativePrepareInfo.getTitleView();
        View descView = aTNativePrepareInfo.getDescView();
        View ctaView = aTNativePrepareInfo.getCtaView();
        View adLogoView = aTNativePrepareInfo.getAdLogoView();
        View iconView = aTNativePrepareInfo.getIconView();
        View adFromView = aTNativePrepareInfo.getAdFromView();
        GMViewBinder.Builder builderIconImageId = new GMViewBinder.Builder(parentView != null ? parentView.getId() : 0).titleId(titleView != null ? titleView.getId() : 0).sourceId(adFromView != null ? adFromView.getId() : 0).descriptionTextId(descView != null ? descView.getId() : 0).callToActionId(ctaView != null ? ctaView.getId() : 0).logoLayoutId(adLogoView != null ? adLogoView.getId() : 0).iconImageId(iconView != null ? iconView.getId() : 0);
        int i2 = this.f12558d;
        if (i2 != 0) {
            builderIconImageId.mediaViewIdId(i2);
        }
        try {
            if (view.getContext() instanceof Activity) {
                this.a.registerView((Activity) view.getContext(), (ViewGroup) view, arrayList, arrayList2, builderIconImageId.build());
            } else {
                this.a.registerView((ViewGroup) view, arrayList, arrayList2, builderIconImageId.build());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
