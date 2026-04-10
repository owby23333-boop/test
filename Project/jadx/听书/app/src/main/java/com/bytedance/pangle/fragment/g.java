package com.bytedance.pangle.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
class g implements Application.ActivityLifecycleCallbacks {
    Fragment z;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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

    public g(Fragment fragment) {
        this.z = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        if (this.z.getActivity() == activity && activity.getClassLoader() != this.z.getClass().getClassLoader()) {
            try {
                Object obj = bundle.get("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (obj != null) {
                    ((Bundle) obj).remove("android:support:fragments");
                }
                bundle.remove("android:support:fragments");
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "clear fragment, Activity:".concat(String.valueOf(activity)));
            } catch (Exception unused) {
            }
        }
    }
}
