package com.mibi.sdk.task;

import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.task.AutoQuerier;

/* JADX INFO: loaded from: classes16.dex */
public abstract class DefaultAutoQueryCallback implements AutoQuerier.AutoQuerierCallback {
    private static final String TAG = "DefaultAutoQuerier";

    @Override // com.mibi.sdk.task.AutoQuerier.AutoQuerierCallback
    public void onComplete() {
        MibiLog.i(TAG, "onComplete");
    }

    @Override // com.mibi.sdk.task.AutoQuerier.AutoQuerierCallback
    public void onProgressUpdate(long j) {
        MibiLog.i(TAG, "onProgressUpdate");
    }

    @Override // com.mibi.sdk.task.AutoQuerier.AutoQuerierCallback
    public void onStart() {
        MibiLog.i(TAG, "onStart");
    }
}
