package com.kwad.sdk.core.b;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onBackToBackground();

    void onBackToForeground();
}
