package com.mibi.sdk.mvp.lifecycle;

import android.os.Bundle;

/* JADX INFO: loaded from: classes14.dex */
public interface ILifeCycleListener {
    void handleResult(int i, int i2, Bundle bundle);

    void onCreate();

    void onDestroy();

    void onPause();

    void onResume();
}
