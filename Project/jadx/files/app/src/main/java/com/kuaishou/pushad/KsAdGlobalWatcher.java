package com.kuaishou.pushad;

import com.kwad.components.core.internal.api.a;
import com.kwad.components.core.internal.api.b;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KsAdGlobalWatcher implements b {
    private static final String TAG = "KsAdGlobalWatcher";
    private static volatile KsAdGlobalWatcher sInstance;
    private List<PushAdManager> mCurrentPushAdManager = new ArrayList();

    private KsAdGlobalWatcher() {
    }

    public static KsAdGlobalWatcher getInstance() {
        if (sInstance == null) {
            synchronized (KsAdGlobalWatcher.class) {
                if (sInstance == null) {
                    sInstance = new KsAdGlobalWatcher();
                }
            }
        }
        return sInstance;
    }

    private void innerHandleEnter(a aVar) {
        if (isPushAdEnable(aVar)) {
            PushAdManager pushAdManager = new PushAdManager(aVar.getAdTemplate(), Wrapper.wrapContextIfNeed(KsAdSDKImpl.get().getContext()));
            pushAdManager.startRequestPushAd(aVar);
            this.mCurrentPushAdManager.add(pushAdManager);
        }
    }

    private void innerHandleExit(a aVar) {
        Iterator<PushAdManager> it = this.mCurrentPushAdManager.iterator();
        while (it.hasNext()) {
            it.next().onAdExit(aVar);
        }
    }

    private boolean isPushAdEnable(a aVar) {
        if (aVar.ao()) {
            return com.kwad.sdk.core.response.a.a.cx(d.cb(aVar.getAdTemplate()));
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.b
    public void onAdEnter(a aVar) {
        innerHandleEnter(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public void onAdExit(a aVar) {
        innerHandleExit(aVar);
        unwatch(aVar);
    }

    public void removePushAdManager(PushAdManager pushAdManager) {
        if (pushAdManager != null) {
            this.mCurrentPushAdManager.remove(pushAdManager);
        }
    }

    public void unwatch(a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void watch(a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
