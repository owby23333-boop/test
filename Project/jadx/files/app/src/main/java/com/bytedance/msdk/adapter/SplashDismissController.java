package com.bytedance.msdk.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class SplashDismissController {
    private WeakReference<Activity> a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CallBack f13918d;
    private boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13917c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13919e = false;

    public interface CallBack {
        void onResume();
    }

    public SplashDismissController(Activity activity) {
        this.a = new WeakReference<>(activity);
        a();
    }

    private void a() {
        Activity activity = this.a.get();
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.adapter.SplashDismissController.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    SplashDismissController.this.f13918d = null;
                    if (SplashDismissController.this.a == null || SplashDismissController.this.a.get() != activity2) {
                        return;
                    }
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    if (SplashDismissController.this.a == null || SplashDismissController.this.a.get() != activity2) {
                        return;
                    }
                    SplashDismissController.this.f13917c = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    if (SplashDismissController.this.a == null || SplashDismissController.this.a.get() != activity2 || SplashDismissController.this.f13918d == null) {
                        return;
                    }
                    SplashDismissController.this.f13918d.onResume();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                }
            });
        }
    }

    public boolean isCallDismiss() {
        return this.f13919e;
    }

    public boolean jumpToAdPage() {
        return this.b && this.f13917c;
    }

    public void setCallBack(CallBack callBack) {
        this.f13918d = callBack;
    }

    public void setCallDismiss(boolean z2) {
        this.f13919e = z2;
    }

    public void setClick(boolean z2) {
        this.b = z2;
    }
}
