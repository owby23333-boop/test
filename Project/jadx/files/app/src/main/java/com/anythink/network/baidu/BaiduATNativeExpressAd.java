package com.anythink.network.baidu;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.network.baidu.impression.BDImpressionController;
import com.anythink.network.baidu.impression.BDImpressionTracker;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.StyleParams;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATNativeExpressAd extends CustomNativeAd {
    BDImpressionTracker a;
    private NativeResponse b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FeedNativeView f12362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private StyleParams f12363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f12364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f12365f;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATNativeExpressAd$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((XAdNativeResponse) BaiduATNativeExpressAd.this.b).setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.anythink.network.baidu.BaiduATNativeExpressAd.1.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public final void onDislikeClick() {
                    BaiduATNativeExpressAd.this.notifyAdDislikeClick();
                }
            });
        }
    }

    public BaiduATNativeExpressAd(Context context, NativeResponse nativeResponse, StyleParams styleParams) {
        this.f12364e = context.getApplicationContext();
        this.f12365f = new FrameLayout(this.f12364e);
        this.b = nativeResponse;
        this.f12363d = styleParams;
        this.a = new BDImpressionTracker(this.f12364e, 50);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        this.f12365f = null;
        this.f12363d = null;
        BDImpressionTracker bDImpressionTracker = this.a;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.a = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        FrameLayout frameLayout = this.f12365f;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressHeight() {
        FeedNativeView feedNativeView = this.f12362c;
        if (feedNativeView != null) {
            return feedNativeView.getAdContainerHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressWidth() {
        FeedNativeView feedNativeView = this.f12362c;
        if (feedNativeView != null) {
            return feedNativeView.getAdContainerWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(View view) {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> creativeClickViewList;
        Context context = view != null ? view.getContext() : this.f12364e;
        if (this.f12362c == null) {
            this.f12362c = new FeedNativeView(context);
            this.f12362c.setAdData((XAdNativeResponse) this.b);
            this.f12362c.changeViewLayoutParams(this.f12363d);
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1());
            this.f12365f.addView(this.f12362c);
        }
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = a(view);
        }
        ArrayList arrayList = new ArrayList();
        if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList.addAll(creativeClickViewList);
        }
        ((XAdNativeResponse) this.b).registerViewForInteraction(view, clickViewList, arrayList, new NativeResponse.AdInteractionListener() { // from class: com.anythink.network.baidu.BaiduATNativeExpressAd.2
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public final void onADExposed() {
                BDImpressionTracker bDImpressionTracker = BaiduATNativeExpressAd.this.a;
                if (bDImpressionTracker != null) {
                    bDImpressionTracker.clear();
                    BaiduATNativeExpressAd.this.a = null;
                }
                BaiduATNativeExpressAd.this.notifyAdImpression();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public final void onADExposureFailed(int i2) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public final void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public final void onAdClick() {
                BaiduATNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public final void onAdUnionClick() {
            }
        });
        try {
            if (this.a != null) {
                this.a.addView(view, new BDImpressionController() { // from class: com.anythink.network.baidu.BaiduATNativeExpressAd.3
                    @Override // com.anythink.network.baidu.impression.BDImpressionController, com.anythink.network.baidu.impression.BDImpressionInterface
                    public final void recordImpression(View view2) {
                        try {
                            if (BaiduATNativeExpressAd.this.b == null || view2 == null) {
                                return;
                            }
                            BaiduATNativeExpressAd.this.b.recordImpression(view2);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        if (this.f12362c == null) {
            this.f12362c = new FeedNativeView(context);
            this.f12362c.setAdData((XAdNativeResponse) this.b);
            this.f12362c.changeViewLayoutParams(this.f12363d);
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1());
            this.f12365f.addView(this.f12362c);
        }
    }

    private List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        if ((view instanceof ViewGroup) && view != this.f12365f) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                arrayList.addAll(a(viewGroup.getChildAt(i2)));
            }
        } else {
            arrayList.add(view);
        }
        return arrayList;
    }
}
