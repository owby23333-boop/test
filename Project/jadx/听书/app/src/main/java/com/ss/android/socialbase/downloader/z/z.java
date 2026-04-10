package com.ss.android.socialbase.downloader.z;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.pf.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2116a;
    private final List<InterfaceC0484z> dl;
    private volatile boolean e;
    private dl g;
    private WeakReference<Activity> gc;
    private final Application.ActivityLifecycleCallbacks gz;
    private volatile int m;
    private Application z;

    public interface dl {
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0484z {
        void dl();

        void g();
    }

    public static z z() {
        return g.z;
    }

    private static class g {
        private static final z z = new z();
    }

    private z() {
        this.dl = new ArrayList();
        this.m = -1;
        this.e = false;
        this.gz = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.z.z.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                z.this.gc = new WeakReference(activity);
                int i = z.this.f2116a;
                z.this.f2116a = activity != null ? activity.hashCode() : i;
                z.this.e = false;
                if (i == 0) {
                    z.this.gc();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = z.this.f2116a;
                z.this.e = false;
                z.this.f2116a = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    z.this.gc();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                z.this.e = true;
                if (z.this.f2116a != 0 || activity == null) {
                    return;
                }
                z.this.f2116a = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == z.this.f2116a) {
                    z.this.f2116a = 0;
                    z.this.m();
                }
                z.this.e = false;
            }
        };
    }

    public void z(Context context) {
        if (this.z == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.z == null) {
                    Application application = (Application) context;
                    this.z = application;
                    application.registerActivityLifecycleCallbacks(this.gz);
                }
            }
        }
    }

    public void z(dl dlVar) {
        this.g = dlVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean g() {
        int i = this.m;
        ?? r0 = i;
        if (i == -1) {
            ?? E = e();
            this.m = E;
            r0 = E;
        }
        return r0 == 1;
    }

    public boolean dl() {
        return g() && !this.e;
    }

    public void z(InterfaceC0484z interfaceC0484z) {
        if (interfaceC0484z == null) {
            return;
        }
        synchronized (this.dl) {
            if (!this.dl.contains(interfaceC0484z)) {
                this.dl.add(interfaceC0484z);
            }
        }
    }

    public void g(InterfaceC0484z interfaceC0484z) {
        synchronized (this.dl) {
            this.dl.remove(interfaceC0484z);
        }
    }

    private Object[] a() {
        Object[] array;
        synchronized (this.dl) {
            array = this.dl.size() > 0 ? this.dl.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        this.m = 1;
        Object[] objArrA = a();
        if (objArrA != null) {
            for (Object obj : objArrA) {
                ((InterfaceC0484z) obj).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.m = 0;
        Object[] objArrA = a();
        if (objArrA != null) {
            for (Object obj : objArrA) {
                ((InterfaceC0484z) obj).dl();
            }
        }
    }

    private boolean e() {
        try {
            Application application = this.z;
            if (application == null) {
                return false;
            }
            application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), m.a(application));
        } catch (Throwable th) {
            wp.z(th);
            return false;
        }
    }
}
