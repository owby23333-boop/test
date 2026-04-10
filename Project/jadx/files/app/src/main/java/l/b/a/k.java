package l.b.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: WindowHelper.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
final class k implements Application.ActivityLifecycleCallbacks {
    private Activity a;
    private final h b;

    private k(h hVar) {
        this.b = hVar;
    }

    static k a(h hVar, Application application) {
        k kVar = new k(hVar);
        application.registerActivityLifecycleCallbacks(kVar);
        return kVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.a = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.a == activity) {
            this.a = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.b.b()) {
            this.b.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.a = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.a = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    Activity a() {
        return this.a;
    }
}
