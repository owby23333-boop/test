package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public abstract class KsGenericLifecycleObserver extends KsLifecycleObserver {
    @Keep
    public abstract void onStateChanged(KsLifecycle.KsLifeEvent ksLifeEvent);
}
