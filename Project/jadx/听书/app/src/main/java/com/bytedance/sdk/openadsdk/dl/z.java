package com.bytedance.sdk.openadsdk.dl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class z implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0217z f1435a;
    private volatile WeakReference<Activity> dl;
    private int g = 0;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.dl.z$z, reason: collision with other inner class name */
    public interface InterfaceC0217z {
        void g();

        void z();
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
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    z() {
    }

    public Boolean z() {
        return Boolean.valueOf(z);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.g++;
        z = false;
        InterfaceC0217z interfaceC0217z = this.f1435a;
        if (interfaceC0217z != null) {
            interfaceC0217z.g();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.dl = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.g - 1;
        this.g = i;
        if (i == 0) {
            z = true;
            InterfaceC0217z interfaceC0217z = this.f1435a;
            if (interfaceC0217z != null) {
                interfaceC0217z.z();
            }
        }
    }

    public void z(InterfaceC0217z interfaceC0217z) {
        this.f1435a = interfaceC0217z;
    }

    public Activity g() {
        if (this.dl == null) {
            return null;
        }
        return this.dl.get();
    }
}
