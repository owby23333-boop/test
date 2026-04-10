package com.kuaishou.pushad;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.pushad.PushAdView;
import com.kwad.components.core.g.a;
import com.kwad.components.core.g.c;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.x;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PushAdManager implements PushAdView.PushAdListener, Runnable {
    private static final String TAG = "PushAdManager";
    private static volatile boolean processingPush;
    private boolean hadPostPushAd = false;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private AdTemplate mPushAd;

    @Nullable
    private PushAdView mPushAdView;
    private long showPushAdDelayTime;

    public PushAdManager(@NonNull AdTemplate adTemplate, Context context) {
        this.mAdTemplate = adTemplate;
        this.mContext = context;
        this.showPushAdDelayTime = a.cy(d.cb(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPushTK() {
        Context contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(KsAdSDKImpl.get().getContext());
        if (contextWrapContextIfNeed == null) {
            processingPush = false;
            return;
        }
        this.mPushAdView = new PushAdView(contextWrapContextIfNeed);
        this.mPushAdView.bindView(this.mPushAd);
        this.mPushAdView.setListener(this);
    }

    public void onAdExit(com.kwad.components.core.internal.api.a aVar) {
        b.d(TAG, "onAdExit: " + aVar);
        if (!aVar.ao() || this.hadPostPushAd) {
            return;
        }
        this.hadPostPushAd = true;
        bh.runOnUiThreadDelay(this, this.showPushAdDelayTime);
    }

    @Override // com.kuaishou.pushad.PushAdView.PushAdListener
    public void onPushAdViewClose() {
        b.d(TAG, "onAdClose: ");
        PushAdViewHelper.removePushAd(null);
        PushAdView pushAdView = this.mPushAdView;
        if (pushAdView != null) {
            pushAdView.destroy();
        }
        KsAdGlobalWatcher.getInstance().removePushAdManager(this);
        this.mContext = null;
    }

    @Override // com.kuaishou.pushad.PushAdView.PushAdListener
    public void onPushAdViewShow() {
        x.ag(System.currentTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        PushAdView pushAdView;
        processingPush = false;
        com.kwad.sdk.core.b.b.we();
        final Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || (pushAdView = this.mPushAdView) == null || !pushAdView.isTKLoadSuccess()) {
            return;
        }
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kuaishou.pushad.PushAdManager.2
            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity.equals(currentActivity)) {
                    PushAdManager.this.mPushAdView.destroy();
                }
            }
        });
        PushAdViewHelper.appendPushAd(currentActivity, this.mPushAdView);
        this.mPushAdView.onShow();
    }

    public void startRequestPushAd(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate;
        SceneImpl sceneImpl;
        b.w(TAG, "startRequestPushAd processingPush: " + processingPush);
        if (processingPush || (adTemplate = aVar.getAdTemplate()) == null || (sceneImpl = adTemplate.mAdScene) == null) {
            return;
        }
        processingPush = true;
        com.kwad.components.core.g.a.c(sceneImpl, new a.InterfaceC0399a() { // from class: com.kuaishou.pushad.PushAdManager.1
            @Override // com.kwad.components.core.g.a.InterfaceC0399a
            public void onError(int i2, String str) {
                b.d(PushAdManager.TAG, "onError: " + str);
                boolean unused = PushAdManager.processingPush = false;
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0399a
            public void onInnerAdLoad(@Nullable List<c> list) {
                b.d(PushAdManager.TAG, "onInnerAdLoad: " + list);
                if (list == null || list.size() <= 0) {
                    boolean unused = PushAdManager.processingPush = false;
                    return;
                }
                PushAdManager.this.mPushAd = list.get(0).getAdTemplate();
                if (com.kwad.sdk.core.response.a.a.cw(d.cb(PushAdManager.this.mPushAd))) {
                    b.d(PushAdManager.TAG, "loadPushTK");
                    PushAdManager.this.loadPushTK();
                } else {
                    boolean unused2 = PushAdManager.processingPush = false;
                    b.d(PushAdManager.TAG, "pushAdInfo templateId invalid");
                }
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0399a
            public void onRequestResult(int i2) {
            }
        });
    }
}
