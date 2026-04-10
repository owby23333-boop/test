package com.bytedance.msdk.api.v2.ad.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.GMReceiveBidResultCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomVideoAdapter;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeCustomizeVideoConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDislikeConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDislikeDialog;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDownloadStatusControllerConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeExpressConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeIsReadyStatusConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert;
import com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMCustomTTBaseAd extends TTBaseAd {
    private GMCustomBaseAdapter a;
    private GMDislikeCallback b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IGMCustomNativeDislikeDialog f14231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GMReceiveBidResultCallback f14232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Object> f14233e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IGMCustomNativeConvert f14234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IGMCustomNativeExpressConvert f14235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IGMCustomNativeLifecycleConvert f14236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IGMCustomNativeDislikeConvert f14237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IGMCustomNativeIsReadyStatusConvert f14238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private IGMCustomNativeCustomizeVideoConvert f14239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IGMCustomNativeDownloadStatusControllerConvert f14240l;

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void bidLoseNotify(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int lossReason = GMAdConstant.BiddingLossReason.OTHER.getLossReason();
        try {
            Object obj = map.get("bidding_lose_reason");
            if (obj instanceof GMAdConstant.BiddingLossReason) {
                lossReason = ((GMAdConstant.BiddingLossReason) obj).getLossReason();
            }
        } catch (Exception unused) {
        }
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null) {
            gMCustomBaseAdapter.receiveBidResult(false, -1.0d, lossReason, null);
        }
        GMReceiveBidResultCallback gMReceiveBidResultCallback = this.f14232d;
        if (gMReceiveBidResultCallback != null) {
            gMReceiveBidResultCallback.bidResult(false, -1.0d, lossReason, null);
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void bidWinNotify(Map<String, Object> map) {
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null) {
            gMCustomBaseAdapter.receiveBidResult(true, getCpm(), -1, null);
        }
        GMReceiveBidResultCallback gMReceiveBidResultCallback = this.f14232d;
        if (gMReceiveBidResultCallback != null) {
            gMReceiveBidResultCallback.bidResult(true, getCpm(), -1, null);
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void cancelDownload() {
        IGMCustomNativeDownloadStatusControllerConvert iGMCustomNativeDownloadStatusControllerConvert = this.f14240l;
        if (iGMCustomNativeDownloadStatusControllerConvert != null) {
            iGMCustomNativeDownloadStatusControllerConvert.cancelDownload();
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void dislikeClick(String str, Map<String, Object> map) {
        super.dislikeClick(str, map);
        IGMCustomNativeDislikeDialog iGMCustomNativeDislikeDialog = this.f14231c;
        if (iGMCustomNativeDislikeDialog != null) {
            iGMCustomNativeDislikeDialog.dislikeClick(str, map);
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public View getAdView() {
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null && (gMCustomBaseAdapter instanceof GMCustomBannerAdapter)) {
            return ((GMCustomBannerAdapter) gMCustomBaseAdapter).getAdViewInner();
        }
        IGMCustomNativeExpressConvert iGMCustomNativeExpressConvert = this.f14235g;
        if (iGMCustomNativeExpressConvert != null) {
            return iGMCustomNativeExpressConvert.getExpressViewInner();
        }
        return null;
    }

    public GMDislikeCallback getDislikeCallback() {
        return this.b;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        IGMCustomNativeDislikeDialog iGMCustomNativeDislikeDialog = this.f14231c;
        return iGMCustomNativeDislikeDialog != null ? iGMCustomNativeDislikeDialog.getDislikeDialog(activity, map) : super.getDislikeDialog(activity, map);
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public int getDownloadStatus() {
        IGMCustomNativeDownloadStatusControllerConvert iGMCustomNativeDownloadStatusControllerConvert = this.f14240l;
        if (iGMCustomNativeDownloadStatusControllerConvert != null) {
            return iGMCustomNativeDownloadStatusControllerConvert.getDownloadStatus();
        }
        return -1;
    }

    public GMAdAppDownloadListener getGMAdAppDownloadListener() {
        return this.mTTAdAppDownloadListener;
    }

    public GMDrawAdListener getGMDrawAdListener() {
        return this.mGMDrawAdListener;
    }

    public GMNativeAdListener getGMNativeAdListener() {
        return this.mTTNativeAdListener;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
        IGMCustomNativeCustomizeVideoConvert iGMCustomNativeCustomizeVideoConvert = this.f14239k;
        if (iGMCustomNativeCustomizeVideoConvert != null) {
            return iGMCustomNativeCustomizeVideoConvert.getGMNativeCustomVideoReporter();
        }
        return null;
    }

    public GMVideoListener getGMVideoListener() {
        return this.mTTVideoListener;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public Map<String, Object> getMediaExtraInfo() {
        return this.f14233e;
    }

    public ITTAdatperCallback getTTAdapterCallback() {
        return this.mTTAdatperCallback;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public String getVideoUrl() {
        IGMCustomNativeCustomizeVideoConvert iGMCustomNativeCustomizeVideoConvert = this.f14239k;
        if (iGMCustomNativeCustomizeVideoConvert != null) {
            return iGMCustomNativeCustomizeVideoConvert.getVideoUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public boolean hasDestroyed() {
        return false;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public boolean hasDislike() {
        IGMCustomNativeDislikeConvert iGMCustomNativeDislikeConvert = this.f14237i;
        return iGMCustomNativeDislikeConvert != null ? iGMCustomNativeDislikeConvert.hasDislike() : super.hasDislike();
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public final GMAdConstant.AdIsReadyStatus isReadyStatus() {
        IGMCustomNativeIsReadyStatusConvert iGMCustomNativeIsReadyStatusConvert = this.f14238j;
        if (iGMCustomNativeIsReadyStatusConvert != null) {
            return iGMCustomNativeIsReadyStatusConvert.isReadyStatus();
        }
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        return gMCustomBaseAdapter != null ? gMCustomBaseAdapter.isReadyStatusInner() : super.isReadyStatus();
    }

    public final void nativeDislikeClick(String str) {
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null) {
            gMCustomBaseAdapter.nativeDislikeClick(this, str);
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void onDestroy() {
        super.onDestroy();
        IGMCustomNativeLifecycleConvert iGMCustomNativeLifecycleConvert = this.f14236h;
        if (iGMCustomNativeLifecycleConvert != null) {
            iGMCustomNativeLifecycleConvert.onDestroyInner();
            return;
        }
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null) {
            try {
                gMCustomBaseAdapter.onDestroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void onPause() {
        super.onPause();
        IGMCustomNativeLifecycleConvert iGMCustomNativeLifecycleConvert = this.f14236h;
        if (iGMCustomNativeLifecycleConvert != null) {
            iGMCustomNativeLifecycleConvert.onPauseInner();
            return;
        }
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null) {
            try {
                gMCustomBaseAdapter.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void onResume() {
        super.onResume();
        IGMCustomNativeLifecycleConvert iGMCustomNativeLifecycleConvert = this.f14236h;
        if (iGMCustomNativeLifecycleConvert != null) {
            iGMCustomNativeLifecycleConvert.onResumeInner();
            return;
        }
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter != null) {
            try {
                gMCustomBaseAdapter.onResume();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void pauseAppDownload() {
        IGMCustomNativeDownloadStatusControllerConvert iGMCustomNativeDownloadStatusControllerConvert = this.f14240l;
        if (iGMCustomNativeDownloadStatusControllerConvert != null) {
            iGMCustomNativeDownloadStatusControllerConvert.pauseAppDownload();
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
        IGMCustomNativeConvert iGMCustomNativeConvert = this.f14234f;
        if (iGMCustomNativeConvert != null) {
            iGMCustomNativeConvert.registerViewForInteractionInner(activity, viewGroup, list, list2, list3, gMViewBinder);
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
        registerViewForInteraction(null, viewGroup, list, list2, null, gMViewBinder);
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void render() {
        IGMCustomNativeExpressConvert iGMCustomNativeExpressConvert = this.f14235g;
        if (iGMCustomNativeExpressConvert != null) {
            iGMCustomNativeExpressConvert.renderInner();
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void resumeAppDownload() {
        IGMCustomNativeDownloadStatusControllerConvert iGMCustomNativeDownloadStatusControllerConvert = this.f14240l;
        if (iGMCustomNativeDownloadStatusControllerConvert != null) {
            iGMCustomNativeDownloadStatusControllerConvert.resumeAppDownload();
        }
    }

    public void setCustomNativeConvert(IGMCustomNativeConvert iGMCustomNativeConvert) {
        this.f14234f = iGMCustomNativeConvert;
    }

    public void setCustomNativeCustomizeVideoConvert(IGMCustomNativeCustomizeVideoConvert iGMCustomNativeCustomizeVideoConvert) {
        this.f14239k = iGMCustomNativeCustomizeVideoConvert;
    }

    public void setCustomNativeDownloadStatusControllerConvert(IGMCustomNativeDownloadStatusControllerConvert iGMCustomNativeDownloadStatusControllerConvert) {
        this.f14240l = iGMCustomNativeDownloadStatusControllerConvert;
    }

    public void setCustomNativeExpressConvert(IGMCustomNativeExpressConvert iGMCustomNativeExpressConvert) {
        this.f14235g = iGMCustomNativeExpressConvert;
    }

    public void setCustomNativeLifecycleConvert(IGMCustomNativeLifecycleConvert iGMCustomNativeLifecycleConvert) {
        this.f14236h = iGMCustomNativeLifecycleConvert;
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback) {
        super.setDislikeCallback(activity, gMDislikeCallback);
        this.b = gMDislikeCallback;
    }

    public void setDislikeDialogCallBack(IGMCustomNativeDislikeDialog iGMCustomNativeDislikeDialog) {
        this.f14231c = iGMCustomNativeDislikeDialog;
    }

    public void setGMCustomBaseAdapter(GMCustomBaseAdapter gMCustomBaseAdapter) {
        this.a = gMCustomBaseAdapter;
    }

    public void setGmReceiveBidResultCallback(GMReceiveBidResultCallback gMReceiveBidResultCallback) {
        this.f14232d = gMReceiveBidResultCallback;
    }

    public void setIGMCustomNativeDislikeConvert(IGMCustomNativeDislikeConvert iGMCustomNativeDislikeConvert) {
        this.f14237i = iGMCustomNativeDislikeConvert;
    }

    public void setIGMCustomNativeIsReadyStatusConvert(IGMCustomNativeIsReadyStatusConvert iGMCustomNativeIsReadyStatusConvert) {
        this.f14238j = iGMCustomNativeIsReadyStatusConvert;
    }

    public void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.f14233e.putAll(map);
        }
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter == null || !(gMCustomBaseAdapter instanceof GMCustomVideoAdapter)) {
            return;
        }
        ((GMCustomVideoAdapter) gMCustomBaseAdapter).showAdInner(activity);
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void showSplashAd(ViewGroup viewGroup) {
        GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
        if (gMCustomBaseAdapter == null || !(gMCustomBaseAdapter instanceof GMCustomSplashAdapter)) {
            return;
        }
        ((GMCustomSplashAdapter) gMCustomBaseAdapter).showAdInner(viewGroup);
    }

    @Override // com.bytedance.msdk.base.TTBaseAd
    public void unregisterView() {
        IGMCustomNativeConvert iGMCustomNativeConvert = this.f14234f;
        if (iGMCustomNativeConvert != null) {
            iGMCustomNativeConvert.unregisterViewInner();
        }
    }
}
