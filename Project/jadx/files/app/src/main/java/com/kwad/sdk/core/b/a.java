package com.kwad.sdk.core.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class a implements Application.ActivityLifecycleCallbacks {
    private final List<WeakReference<Activity>> aft;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mEnable;
    private boolean mIsInBackground;
    private final List<c> mListeners;

    /* JADX INFO: renamed from: com.kwad.sdk.core.b.a$a, reason: collision with other inner class name */
    static final class C0432a {
        static final a afu = new a(0);
    }

    private a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.aft = new ArrayList();
        this.mEnable = false;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private void e(Activity activity) {
        Iterator<WeakReference<Activity>> it = this.aft.iterator();
        while (it.hasNext()) {
            if (it.next().get() == activity) {
                return;
            }
        }
        this.aft.add(new WeakReference<>(activity));
    }

    private void f(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.aft.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    public static a wc() {
        return C0432a.afu;
    }

    private boolean wd() {
        return b.wf() || !this.mEnable;
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(@NonNull Context context) {
        try {
            this.mApplication = (Application) context;
            this.mApplication.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (wd()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (wd()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (wd()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (wd()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (wd()) {
            return;
        }
        try {
            e(activity);
            if (this.aft.size() == 1) {
                this.mIsInBackground = false;
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBackToForeground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (wd()) {
            return;
        }
        try {
            f(activity);
            if (this.aft.size() == 0) {
                this.mIsInBackground = true;
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBackToBackground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
