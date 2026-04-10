package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_try19;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAd;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements GMDrawAd, GMVideoListener {
    private TTBaseAd a;
    private AdSlot b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GMDrawAdListener f1665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f1666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GMVideoListener f1667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1668f = false;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_try19.a$a, reason: collision with other inner class name */
    class C0050a extends GMDrawCustomVideoReporter {
        final /* synthetic */ GMNativeCustomVideoReporter a;

        C0050a(a aVar, GMNativeCustomVideoReporter gMNativeCustomVideoReporter) {
            this.a = gMNativeCustomVideoReporter;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoAutoStart() {
            this.a.reportVideoAutoStart();
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoBreak(long j2) {
            this.a.reportVideoBreak(j2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoContinue(long j2) {
            this.a.reportVideoContinue(j2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoError(long j2, int i2, int i3) {
            this.a.reportVideoError(j2, i2, i3);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoFinish() {
            this.a.reportVideoFinish();
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoPause(long j2) {
            this.a.reportVideoPause(j2);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoStart() {
            this.a.reportVideoStart();
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
        public void reportVideoStartError(int i2, int i3) {
            this.a.reportVideoStartError(i2, i3);
        }
    }

    class b implements GMDrawExpressAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdClick() {
            if (a.this.f1665c != null) {
                a.this.f1665c.onAdClick();
            }
            h.a(a.this.a, a.this.b, 0, u.a(a.this.a) ? u.b(Thread.currentThread().getStackTrace()) : null, a.this.a.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdShow() {
            a.this.f1668f = true;
            if (a.this.f1665c != null) {
                a.this.f1665c.onAdShow();
            }
            if (a.this.b != null && a.this.a != null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(a.this.b.getAdUnitId(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + a.this.a.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(a.this.a.getAdNetworkPlatformId()));
                m mVarB = m.b();
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.b.getAdUnitId());
                sb.append("");
                mVarB.a(sb.toString());
                m.b().j(a.this.b.getAdUnitId() + "");
                k.b().a(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
                l.b().e(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
            }
            a.this.f1666d.a(a.this);
            String strB = u.a(a.this.a) ? u.b(Thread.currentThread().getStackTrace()) : null;
            boolean zIsShowListenRepeatOnce = a.this.a.isShowListenRepeatOnce();
            if (!zIsShowListenRepeatOnce) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(a.this.a.getAdType(), a.this.a.getCpm());
            }
            h.b(a.this.a, a.this.b, 0, strB, zIsShowListenRepeatOnce);
            g.b(a.this.b != null ? a.this.b.getAdUnitId() : "", a.this.a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener
        public void onRenderFail(View view, String str, int i2) {
            if (a.this.f1665c instanceof GMDrawExpressAdListener) {
                ((GMDrawExpressAdListener) a.this.f1665c).onRenderFail(view, str, i2);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener
        public void onRenderSuccess(float f2, float f3) {
            if (a.this.f1665c instanceof GMDrawExpressAdListener) {
                ((GMDrawExpressAdListener) a.this.f1665c).onRenderSuccess(f2, f3);
            }
        }
    }

    class c implements GMDrawAdListener {
        c() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdClick() {
            if (a.this.f1665c != null) {
                a.this.f1665c.onAdClick();
            }
            h.a(a.this.a, a.this.b, 0, u.a(a.this.a) ? u.b(Thread.currentThread().getStackTrace()) : null, a.this.a.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdShow() {
            a.this.f1668f = true;
            if (a.this.f1665c != null) {
                a.this.f1665c.onAdShow();
            }
            if (a.this.b != null && a.this.a != null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(a.this.b.getAdUnitId(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + a.this.a.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(a.this.a.getAdNetworkPlatformId()));
                m mVarB = m.b();
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.b.getAdUnitId());
                sb.append("");
                mVarB.a(sb.toString());
                m.b().j(a.this.b.getAdUnitId() + "");
                k.b().a(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
                l.b().e(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
            }
            a.this.f1666d.a(a.this);
            String strB = u.a(a.this.a) ? u.b(Thread.currentThread().getStackTrace()) : null;
            boolean zIsShowListenRepeatOnce = a.this.a.isShowListenRepeatOnce();
            if (!zIsShowListenRepeatOnce) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(a.this.a.getAdType(), a.this.a.getCpm());
            }
            h.b(a.this.a, a.this.b, 0, strB, zIsShowListenRepeatOnce);
            g.b(a.this.b != null ? a.this.b.getAdUnitId() : "", a.this.a);
        }
    }

    public interface d {
        void a();

        void a(GMDrawAd gMDrawAd);
    }

    public a(TTBaseAd tTBaseAd, AdSlot adSlot, d dVar) {
        this.a = tTBaseAd;
        this.b = adSlot;
        this.f1666d = dVar;
    }

    private void a() {
        TTBaseAd tTBaseAd;
        GMDrawAdListener cVar;
        if (this.a.isExpressAd()) {
            tTBaseAd = this.a;
            cVar = new b();
        } else {
            tTBaseAd = this.a;
            cVar = new c();
        }
        tTBaseAd.setGMDrawAdListener(cVar);
    }

    public void a(TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t()) {
            h.a(tTBaseAd, this.b, u.a(Thread.currentThread().getStackTrace()), 2);
        }
    }

    public void a(boolean z2) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setHasShown(z2);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public boolean canAdReuse() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.canAdReuse();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void destroy() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            try {
                tTBaseAd.onDestroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void dislikeClick(String str, Map<String, Object> map) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            h.a(tTBaseAd, this.b, str);
            this.a.dislikeClick(str, map);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getActionText() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getActionText();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getAdImageMode() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageMode();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    @Deprecated
    public View getAdLogoView() {
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getAdNetworkPlatformId() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getAdNetworkPlatformName() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetWorkName();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getAdNetworkRitId() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkSlotId();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    @Nullable
    public GMAdEcpmInfo getBestEcpm() {
        if (this.a != null && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p()) {
            return p.a(this.a, false);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getDescription() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdDescription();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public GMAdDislike getDislikeDialog(Activity activity) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getDislikeDialog(activity, null);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public View getExpressView() {
        h.b(this.b, p.a(this.a));
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || !tTBaseAd.isExpressAd()) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.a);
            h.a(arrayList, this.b);
            return null;
        }
        d dVar = this.f1666d;
        if (dVar != null) {
            dVar.a();
        }
        TTBaseAd tTBaseAd2 = this.a;
        h.a(tTBaseAd2, this.b, tTBaseAd2.isShowRepeatOnce());
        return this.a.getAdView();
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public Map<String, Object> getExtraMsg() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getExtraMsg();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    @Nullable
    public GMDrawCustomVideoReporter getGMDrawCustomVideoReporter() {
        TTBaseAd tTBaseAd = this.a;
        GMNativeCustomVideoReporter gMNativeCustomVideoReporter = tTBaseAd != null ? tTBaseAd.getGMNativeCustomVideoReporter() : null;
        if (gMNativeCustomVideoReporter == null) {
            return null;
        }
        return new C0050a(this, gMNativeCustomVideoReporter);
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getIconUrl() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getIconUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getImageHeight() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public List<String> getImageList() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImages();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getImageUrl() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getImageWidth() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getInteractionType() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getInteractionType();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public Map<String, Object> getMediaExtraInfo() {
        TTBaseAd tTBaseAd = this.a;
        return tTBaseAd != null ? tTBaseAd.getMediaExtraInfo() : new HashMap();
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public GMNativeAdAppInfo getNativeAdAppInfo() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || !tTBaseAd.hasAppInfo()) {
            return null;
        }
        GMNativeAdAppInfo gMNativeAdAppInfo = new GMNativeAdAppInfo();
        gMNativeAdAppInfo.setAppName(this.a.getAppName());
        gMNativeAdAppInfo.setAuthorName(this.a.getAuthorName());
        gMNativeAdAppInfo.setPackageSizeBytes(this.a.getPackageSizeBytes());
        gMNativeAdAppInfo.setPermissionsUrl(this.a.getPermissionsUrl());
        gMNativeAdAppInfo.setPrivacyAgreement(this.a.getPrivacyAgreement());
        gMNativeAdAppInfo.setVersionName(this.a.getVersionName());
        gMNativeAdAppInfo.setPermissionsMap(this.a.getPermissionsMap());
        gMNativeAdAppInfo.setAppInfoExtra(this.a.getAppInfoExtra());
        return gMNativeAdAppInfo;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getPackageName() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getPackageName();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getPreEcpm() {
        if (this.a == null || !this.f1668f) {
            return null;
        }
        return (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().r() || !(this.a.isServerBiddingAd() || this.a.isClientBiddingAd() || this.a.isMultiBiddingAd())) ? this.a.getNetWorkPlatFormCpm() : GMNetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getSdkNumType() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    @Nullable
    public GMAdEcpmInfo getShowEcpm() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || !this.f1668f) {
            return null;
        }
        return p.a(tTBaseAd, true);
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getSource() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getSource();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public double getStarRating() {
        TTBaseAd tTBaseAd = this.a;
        return tTBaseAd != null ? tTBaseAd.getStarRating() : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public TTBaseAd getTTBaseAd() {
        return this.a;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getTitle() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdTitle();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getVideoHeight() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public String getVideoUrl() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getVideoUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public int getVideoWidth() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public boolean hasDislike() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.hasDislike();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public boolean isExpressAd() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.isExpressAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public boolean isHasShown() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.isHasShown();
        }
        return true;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public boolean isReady() {
        AdSlot adSlot;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        h.a(arrayList, (List<TTBaseAd>) null, (List<TTBaseAd>) null, this.b, p.a(this.a));
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || (adSlot = this.b) == null) {
            return false;
        }
        return tTBaseAd.isReady(adSlot.getAdUnitId());
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public boolean isServerBidding() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.isServerBiddingAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void onPause() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onProgressUpdate(long j2, long j3) {
        GMVideoListener gMVideoListener = this.f1667e;
        if (gMVideoListener != null) {
            gMVideoListener.onProgressUpdate(j2, j3);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoCompleted() {
        GMVideoListener gMVideoListener = this.f1667e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoCompleted();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoError(AdError adError) {
        h.a(this.a, this.b, (AdError) null, 2, 0, u.a(this.a) ? u.b(Thread.currentThread().getStackTrace()) : null);
        GMVideoListener gMVideoListener = this.f1667e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoError(adError);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoPause() {
        GMVideoListener gMVideoListener = this.f1667e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoPause();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoResume() {
        GMVideoListener gMVideoListener = this.f1667e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoResume();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoStart() {
        GMVideoListener gMVideoListener = this.f1667e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoStart();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
        h.b(this.b, p.a(this.a));
        if (this.a == null) {
            h.a((List<TTBaseAd>) null, this.b);
            return;
        }
        a();
        this.a.registerViewForInteraction(activity, viewGroup, list, list2, null, gMViewBinder);
        d dVar = this.f1666d;
        if (dVar != null) {
            dVar.a();
        }
        a(this.a);
        TTBaseAd tTBaseAd = this.a;
        h.a(tTBaseAd, this.b, tTBaseAd.isShowRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void render() {
        if (this.a != null) {
            a();
            this.a.render();
            a(this.a);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void resume() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setDislikeCallback(activity, gMDislikeCallback);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void setDrawAdListener(GMDrawAdListener gMDrawAdListener) {
        this.f1665c = gMDrawAdListener;
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void setUseCustomVideo(boolean z2) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setUseCustomVideo(z2);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void setVideoListener(GMVideoListener gMVideoListener) {
        this.f1667e = gMVideoListener;
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTVideoListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAd
    public void unregisterView() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.unregisterView();
        }
    }
}
