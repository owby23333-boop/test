package com.anythink.core.common.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Application.ActivityLifecycleCallbacks {
    int a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6786d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6785c = false;
    ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>(3);

    public f(boolean z2) {
        this.f6786d = false;
        if (z2) {
            this.f6786d = true;
            a();
        }
    }

    private static void a() {
        com.anythink.core.common.j.c.a();
        com.anythink.core.common.j.a.a(n.a().g()).a(21, new com.anythink.core.common.e.e());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f6786d) {
            return;
        }
        this.f6786d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        n.a().a(activity);
        this.a++;
        this.b.put(activity.toString(), Boolean.TRUE);
        if (this.a != 1 || this.f6786d) {
            return;
        }
        this.f6786d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.a--;
        boolean zContainsKey = this.b.containsKey(activity.toString());
        if (!this.f6785c && !zContainsKey) {
            this.f6785c = true;
            this.a++;
        }
        if (zContainsKey) {
            try {
                this.b.remove(activity.toString());
            } catch (Throwable unused) {
            }
        }
        if (this.a == 0) {
            this.f6786d = false;
        }
    }
}
