package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private b a;
    private final Application.ActivityLifecycleCallbacks b = new a();

    class a implements Application.ActivityLifecycleCallbacks {
        private int a = 0;

        a() {
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
            this.a++;
            if (this.a != 1 || k.this.a == null) {
                return;
            }
            k.this.a.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            this.a--;
            if (this.a != 0 || k.this.a == null) {
                return;
            }
            k.this.a.b();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public void a(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.b);
        }
    }

    public void a(Application application, b bVar) {
        if (application != null) {
            this.a = bVar;
            application.registerActivityLifecycleCallbacks(this.b);
        }
    }
}
