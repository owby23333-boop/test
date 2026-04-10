package com.bytedance.sdk.openadsdk.bf;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes10.dex */
class e implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean e = false;
    private int bf = 0;
    private InterfaceC0113e d;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.bf.e$e, reason: collision with other inner class name */
    public interface InterfaceC0113e {
        void bf();

        void e();
    }

    public Boolean e() {
        return Boolean.valueOf(e);
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
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.bf++;
        e = false;
        InterfaceC0113e interfaceC0113e = this.d;
        if (interfaceC0113e != null) {
            interfaceC0113e.bf();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.bf - 1;
        this.bf = i;
        if (i == 0) {
            e = true;
            InterfaceC0113e interfaceC0113e = this.d;
            if (interfaceC0113e != null) {
                interfaceC0113e.e();
            }
        }
    }

    public void e(InterfaceC0113e interfaceC0113e) {
        this.d = interfaceC0113e;
    }
}
