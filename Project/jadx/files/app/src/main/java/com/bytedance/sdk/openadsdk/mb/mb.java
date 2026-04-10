package com.bytedance.sdk.openadsdk.mb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
class mb implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean mb = false;
    private InterfaceC0310mb b;
    private int ox = 0;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.mb.mb$mb, reason: collision with other inner class name */
    public interface InterfaceC0310mb {
        void mb();

        void ox();
    }

    mb() {
    }

    public Boolean mb() {
        return Boolean.valueOf(mb);
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
        this.ox++;
        mb = false;
        InterfaceC0310mb interfaceC0310mb = this.b;
        if (interfaceC0310mb != null) {
            interfaceC0310mb.ox();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.ox--;
        if (this.ox == 0) {
            mb = true;
            InterfaceC0310mb interfaceC0310mb = this.b;
            if (interfaceC0310mb != null) {
                interfaceC0310mb.mb();
            }
        }
    }

    public void mb(InterfaceC0310mb interfaceC0310mb) {
        this.b = interfaceC0310mb;
    }
}
