package com.anythink.network.baidu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.ExpressResponse;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATNativeExpressFeedAd extends CustomNativeAd {
    private final Context a;
    private final ExpressResponse b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f12366c;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$1, reason: invalid class name */
    final class AnonymousClass1 implements ExpressResponse.ExpressInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdClick() {
            BaiduATNativeExpressFeedAd.this.notifyAdClicked();
            BaiduATInitManager.printLog("onAdClick() >>> ");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdExposed() {
            BaiduATNativeExpressFeedAd.this.notifyAdImpression();
            BaiduATInitManager.printLog("onAdExposed() >>> ");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderFail(View view, String str, int i2) {
            BaiduATInitManager.printLog("onAdRenderFail() >>> s = " + str + " i = " + i2);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderSuccess(View view, float f2, float f3) {
            BaiduATInitManager.printLog("onAdRenderSuccess() >>> v = " + f2 + " v1 = " + f3);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdUnionClick() {
            BaiduATInitManager.printLog("onAdUnionClick() >>> ");
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$2, reason: invalid class name */
    final class AnonymousClass2 implements ExpressResponse.ExpressDislikeListener {
        final /* synthetic */ ExpressResponse a;

        AnonymousClass2(ExpressResponse expressResponse) {
            this.a = expressResponse;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeItemClick(String str) {
            BaiduATInitManager.printLog("onDislikeItemClick() >>> called reason = ".concat(String.valueOf(str)));
            BaiduATInitManager.printLog("onDislikeItemClick() >>> Dislike AD title: " + this.a.getAdData().getTitle());
            BaiduATNativeExpressFeedAd.this.notifyAdDislikeClick();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowClose() {
            BaiduATInitManager.printLog("onDislikeWindowClose() >>> called");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowShow() {
            BaiduATInitManager.printLog("onDislikeWindowShow() >>> called");
        }
    }

    public BaiduATNativeExpressFeedAd(Context context, ExpressResponse expressResponse) {
        this.a = context;
        this.b = expressResponse;
        this.f12366c = new FrameLayout(context);
        int adActionType = expressResponse.getAdActionType();
        int i2 = 3;
        if (adActionType == 1) {
            i2 = 2;
        } else if (adActionType == 2) {
            i2 = 1;
        } else if (adActionType != 3) {
            i2 = 0;
        }
        setNativeInteractionType(i2);
    }

    private void a(ExpressResponse expressResponse) {
        expressResponse.setInteractionListener(new AnonymousClass1());
        expressResponse.setAdDislikeListener(new AnonymousClass2(expressResponse));
        expressResponse.render();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        FrameLayout frameLayout = this.f12366c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f12366c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        FrameLayout frameLayout = this.f12366c;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        ExpressResponse expressResponse = this.b;
        if (expressResponse == null) {
            return;
        }
        expressResponse.setInteractionListener(new AnonymousClass1());
        expressResponse.setAdDislikeListener(new AnonymousClass2(expressResponse));
        expressResponse.render();
        View expressAdView = this.b.getExpressAdView();
        if (this.f12366c == null) {
            this.f12366c = new FrameLayout(this.a);
        }
        if (this.f12366c.getChildCount() > 0) {
            this.f12366c.removeAllViews();
        }
        if (expressAdView != null) {
            ViewParent parent = expressAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(expressAdView);
            }
            this.f12366c.addView(expressAdView);
        }
    }
}
