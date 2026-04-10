package com.kwad.components.offline.api.core.api;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public interface ILifeCycleListener {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onBackToBackground();

    void onBackToForeground();
}
