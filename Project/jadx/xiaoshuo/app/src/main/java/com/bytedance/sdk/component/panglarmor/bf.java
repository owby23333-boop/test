package com.bytedance.sdk.component.panglarmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.bytedance.pangle.annotations.ForbidWrapParam;

/* JADX INFO: loaded from: classes.dex */
public class bf implements Application.ActivityLifecycleCallbacks {
    private static volatile bf e;
    private final d bf;

    private bf(Application application) {
        this.bf = d.e(application);
    }

    public static bf e(Application application) {
        if (e == null) {
            synchronized (bf.class) {
                if (e == null) {
                    e = new bf(application);
                    application.registerActivityLifecycleCallbacks(e);
                }
            }
        }
        return e;
    }

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
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        e.e(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        e.e(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam Activity activity) {
        d dVar = this.bf;
        if (dVar != null) {
            dVar.e(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam Activity activity) {
        d dVar = this.bf;
        if (dVar != null) {
            dVar.bf(activity);
        }
    }

    public String e(String str, long j) {
        d dVar = this.bf;
        if (dVar != null) {
            return dVar.e(str, j);
        }
        return null;
    }
}
