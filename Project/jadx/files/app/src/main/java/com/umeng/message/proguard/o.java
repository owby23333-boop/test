package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: UPushActivityMonitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {
    private static final o a = new o();
    private WeakReference<Activity> b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private n f20491g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f20487c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20488d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20489e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20490f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f20492h = new Runnable() { // from class: com.umeng.message.proguard.o.1
        @Override // java.lang.Runnable
        public void run() {
            o oVar = o.this;
            oVar.f20489e = !(oVar.f20489e && o.this.f20488d) && o.this.f20489e;
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f20493i = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.message.proguard.o.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            n nVar = o.this.f20491g;
            if (nVar != null) {
                nVar.c(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                o.this.f20488d = true;
                o.this.f20487c.removeCallbacks(o.this.f20492h);
                o.this.f20487c.postDelayed(o.this.f20492h, 1000L);
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                o.this.b = new WeakReference(activity);
                o.this.f20488d = false;
                o.this.f20487c.removeCallbacks(o.this.f20492h);
                o.this.f20489e = true;
            } catch (Throwable unused) {
            }
            n nVar = o.this.f20491g;
            if (nVar != null) {
                nVar.b(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            n nVar = o.this.f20491g;
            if (nVar != null) {
                nVar.a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    };

    private o() {
    }

    public boolean c() {
        return this.f20489e;
    }

    public Activity d() {
        WeakReference<Activity> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public synchronized void b() {
        if (this.f20491g == null) {
            this.f20491g = new n();
        }
    }

    public static o a() {
        return a;
    }

    public synchronized void a(Application application) {
        if (application != null) {
            try {
                if (!this.f20490f) {
                    application.registerActivityLifecycleCallbacks(this.f20493i);
                    this.f20490f = true;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
