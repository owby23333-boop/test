package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final Activity mTargetActivity;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    protected abstract void onTargetActivityDestroyed();

    public QMUIActivityLifecycleCallbacks(Activity activity) {
        this.mTargetActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Activity activity2 = this.mTargetActivity;
        if (activity == activity2) {
            activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
            onTargetActivityDestroyed();
        }
    }
}
