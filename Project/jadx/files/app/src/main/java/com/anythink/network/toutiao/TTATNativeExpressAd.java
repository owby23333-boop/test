package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class TTATNativeExpressAd extends CustomNativeAd {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f12679h = "TTATNativeExpressAd";
    TTNativeExpressAd a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    double f12681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f12682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12683f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f12684g;

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$3, reason: invalid class name */
    final class AnonymousClass3 implements TTAdDislike.DislikeInteractionCallback {
        AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @Deprecated
        public final void onRefuse() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i2, String str, boolean z2) {
            TTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }

        @Deprecated
        public final void onSelected(int i2, String str) {
            TTATNativeExpressAd.this.notifyAdDislikeClick();
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$4, reason: invalid class name */
    final class AnonymousClass4 implements TTNativeExpressAd.ExpressAdInteractionListener {
        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(View view, int i2) {
            TTATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(View view, int i2) {
            String unused = TTATNativeExpressAd.f12679h;
            TTATInitManager.getInstance().a(TTATNativeExpressAd.this.getShowId(), new WeakReference(TTATNativeExpressAd.this.a));
            TTATNativeExpressAd.this.notifyAdImpression();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(View view, String str, int i2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view, float f2, float f3) {
        }
    }

    public TTATNativeExpressAd(Context context, String str, TTNativeExpressAd tTNativeExpressAd, boolean z2, boolean z3) {
        this.b = context.getApplicationContext();
        this.f12680c = str;
        this.a = tTNativeExpressAd;
        setNetworkInfoMap(this.a.getMediaExtraInfo());
        setAdData(z2);
        TTNativeExpressAd tTNativeExpressAd2 = this.a;
        if (tTNativeExpressAd2 != null) {
            tTNativeExpressAd2.setExpressInteractionListener(new AnonymousClass4());
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        this.f12684g = null;
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.a.destroy();
            this.a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.f12684g == null && this.a != null) {
                this.f12684g = this.a.getExpressAdView();
            }
            return this.f12684g;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.f12681d;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null || !(view.getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) view.getContext();
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass3());
        }
    }

    public void setAdData(boolean z2) {
        this.a.setCanInterruptVideoPlay(z2);
        int i2 = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i2 = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i2 = 2;
        }
        setNativeInteractionType(i2);
        this.a.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onProgressUpdate(long j2, long j3) {
                if (TTATNativeExpressAd.this.getVideoDuration() == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    TTATNativeExpressAd tTATNativeExpressAd = TTATNativeExpressAd.this;
                    double d2 = j3;
                    Double.isNaN(d2);
                    tTATNativeExpressAd.setVideoDuration(d2 / 1000.0d);
                }
                TTATNativeExpressAd tTATNativeExpressAd2 = TTATNativeExpressAd.this;
                double d3 = j2;
                Double.isNaN(d3);
                tTATNativeExpressAd2.f12681d = d3 / 1000.0d;
                tTATNativeExpressAd2.notifyAdVideoPlayProgress((int) tTATNativeExpressAd2.f12681d);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdComplete() {
                TTATNativeExpressAd.this.notifyAdVideoEnd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdContinuePlay() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdPaused() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdStartPlay() {
                TTATNativeExpressAd.this.notifyAdVideoStart();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoError(int i3, int i4) {
                String unused = TTATNativeExpressAd.f12679h;
                String.format("onVideoError, errorCode: %d, errorMsg: %s", Integer.valueOf(i3), String.valueOf(i4));
                TTATNativeExpressAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i3), String.valueOf(i4));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoLoad() {
            }
        });
        this.a.setDownloadListener(new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadActive(long j2, long j3, String str, String str2) {
                TTATNativeExpressAd tTATNativeExpressAd = TTATNativeExpressAd.this;
                if (tTATNativeExpressAd.f12683f) {
                    if (((a) tTATNativeExpressAd).mDownloadListener == null || !(((a) TTATNativeExpressAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) ((a) TTATNativeExpressAd.this).mDownloadListener).onDownloadUpdate(j2, j3, str, str2);
                    return;
                }
                tTATNativeExpressAd.f12683f = true;
                if (((a) tTATNativeExpressAd).mDownloadListener == null || !(((a) TTATNativeExpressAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((a) TTATNativeExpressAd.this).mDownloadListener).onDownloadStart(j2, j3, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (((a) TTATNativeExpressAd.this).mDownloadListener == null || !(((a) TTATNativeExpressAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((a) TTATNativeExpressAd.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFinished(long j2, String str, String str2) {
                if (((a) TTATNativeExpressAd.this).mDownloadListener == null || !(((a) TTATNativeExpressAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((a) TTATNativeExpressAd.this).mDownloadListener).onDownloadFinish(j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (((a) TTATNativeExpressAd.this).mDownloadListener == null || !(((a) TTATNativeExpressAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((a) TTATNativeExpressAd.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onInstalled(String str, String str2) {
                if (((a) TTATNativeExpressAd.this).mDownloadListener == null || !(((a) TTATNativeExpressAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((a) TTATNativeExpressAd.this).mDownloadListener).onInstalled(str, str2);
            }
        });
        int imageMode = this.a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }

    private void b() {
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new AnonymousClass4());
    }

    private void a(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass3());
    }
}
