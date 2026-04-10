package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Application.ActivityLifecycleCallbacks {
    private static volatile g z;
    private final dl g;

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
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private g(Application application) {
        this.g = dl.z(application);
    }

    public static g z(Application application) {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g(application);
                    application.registerActivityLifecycleCallbacks(z);
                }
            }
        }
        return z;
    }

    public void g(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public String z(String str, long j, int i, boolean z2) {
        dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.z(str, j, i, z2);
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        z.z(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        z.z(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.g(activity);
        }
    }
}
