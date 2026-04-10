package com.bytedance.sdk.openadsdk.core.un;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Application.ActivityLifecycleCallbacks {
    public static long dl;
    public static long g;
    public static boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile InterfaceC0206z f1386a;
    private volatile Application.ActivityLifecycleCallbacks gc;
    private volatile WeakReference<Activity> i;
    private volatile g m;
    private volatile WeakReference<Activity> pf;
    private Handler v;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final HashSet<Integer> gz = new HashSet<>();
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.z>> fo = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<g> uy = new CopyOnWriteArrayList<>();
    private final ArrayList<String> kb = new ArrayList<>();
    private SparseArray<Set<Runnable>> wp = new SparseArray<>();

    public interface g {
        void g();

        void z();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.un.z$z, reason: collision with other inner class name */
    public interface InterfaceC0206z {
        void z();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public WeakReference<Activity> z() {
        return this.i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.gc != null) {
            this.gc.onActivityCreated(activity, bundle);
        }
    }

    private Handler gc() {
        if (this.v == null) {
            if (com.bytedance.sdk.openadsdk.core.zw.g().jt()) {
                this.v = com.bytedance.sdk.component.utils.gz.dl();
            } else {
                this.v = com.bytedance.sdk.component.utils.gz.g();
            }
        }
        return this.v;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        gc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.z.1
            @Override // java.lang.Runnable
            public void run() {
                z.this.g(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Activity activity) {
        if (this.e.get()) {
            g(true);
        }
        if (!this.kb.contains(activity.toString())) {
            this.kb.add(activity.toString());
            this.e.set(false);
            com.bytedance.sdk.openadsdk.z.g.g.gc();
        }
        if (this.pf != null && this.pf.get() != null && this.pf.get() == activity) {
            gz();
        }
        if (this.gc != null) {
            this.gc.onActivityStarted(activity);
        }
        oq.gc(activity);
    }

    private void g(boolean z2) {
        try {
            if (z2) {
                if (this.m != null) {
                    this.m.z();
                }
                for (g gVar : this.uy) {
                    if (gVar != null) {
                        gVar.z();
                    }
                }
                return;
            }
            if (this.m != null) {
                this.m.g();
            }
            for (g gVar2 : this.uy) {
                if (gVar2 != null) {
                    gVar2.g();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        gc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.z.2
            @Override // java.lang.Runnable
            public void run() {
                z.this.dl(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(Activity activity) {
        if (activity != null) {
            this.gz.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.f1386a != null) {
            this.f1386a.z();
        }
        if (this.gc != null) {
            this.gc.onActivityResumed(activity);
        }
        com.bytedance.sdk.component.fo.dl.z.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), Integer.parseInt("1371"));
        if (!z) {
            g = System.currentTimeMillis();
            z = true;
        }
        com.bytedance.sdk.openadsdk.core.h.z();
        this.i = new WeakReference<>(activity);
        if (com.bytedance.sdk.openadsdk.core.uy.ls().gk()) {
            return;
        }
        if (activity != null && activity.getComponentName() != null) {
            com.bytedance.sdk.openadsdk.core.un.g.z().z(activity.getComponentName().getClassName());
        }
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        pf.z().z(activity.getIntent());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        gc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.z.3
            @Override // java.lang.Runnable
            public void run() {
                z.this.a(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (this.gc != null) {
            this.gc.onActivityPaused(activity);
        }
        if (com.bytedance.sdk.openadsdk.core.uy.ls().gk() || activity == null || activity.getComponentName() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.g.z().dl(activity.getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        gc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.z.4
            @Override // java.lang.Runnable
            public void run() {
                z.this.gc(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(Activity activity) {
        if (this.kb.contains(activity.toString())) {
            this.kb.remove(activity.toString());
            if (this.kb.size() == 0) {
                this.e.set(true);
                com.bytedance.sdk.openadsdk.z.g.g.a();
                g(false);
            }
        }
        this.pf = new WeakReference<>(activity);
        if (this.gc != null) {
            this.gc.onActivityStopped(activity);
        }
        e();
        ((com.bytedance.sdk.component.a.fo) com.bytedance.sdk.openadsdk.ats.dl.z("kv_store_factory")).store();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(final Activity activity) {
        gc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.z.5
            @Override // java.lang.Runnable
            public void run() {
                z.this.m(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Activity activity) {
        if (activity != null) {
            this.gz.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.gc != null) {
            this.gc.onActivityDestroyed(activity);
        }
        if (this.fo != null && this.fo.size() > 0) {
            for (WeakReference<com.bytedance.sdk.component.adexpress.z> weakReference : this.fo) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        weakReference.get().z(activity);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
            }
        }
        if (this.i != null && this.i.get() == activity) {
            this.i = null;
        }
        if (activity != null) {
            int iHashCode = activity.hashCode();
            synchronized (this.wp) {
                Set<Runnable> set = this.wp.get(iHashCode);
                if (set != null) {
                    for (Runnable runnable : set) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.wp.remove(iHashCode);
                }
            }
        }
    }

    public boolean g() {
        return m();
    }

    public boolean z(boolean z2) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.i;
        return (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) ? z2 : window.getDecorView().hasWindowFocus();
    }

    private boolean m() {
        Function<SparseArray<Object>, Object> functionGb = com.bytedance.sdk.openadsdk.core.uy.ls().gb();
        if (functionGb != null) {
            try {
                Object objApply = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(Boolean.class).g());
                if (objApply != null) {
                    return ((Boolean) objApply).booleanValue();
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return this.e.get();
    }

    public boolean z(Activity activity) {
        return activity != null && this.gz.contains(Integer.valueOf(activity.hashCode()));
    }

    private void e() {
        if (!com.bytedance.sdk.openadsdk.core.uy.ls().gk() && g()) {
            com.bytedance.sdk.component.uy.e.dl(new com.bytedance.sdk.component.uy.fo("reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.core.un.z.6
                @Override // java.lang.Runnable
                public void run() {
                    z.z = false;
                    z.dl = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.q.v.z().z(z.g / 1000, z.dl / 1000, !com.bytedance.sdk.openadsdk.core.q.g.get() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.q.g.set(false);
                }
            });
        }
    }

    private void gz() {
        if (com.bytedance.sdk.openadsdk.core.uy.ls().gk()) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.e.g(new com.bytedance.sdk.component.uy.fo("upload_dpl") { // from class: com.bytedance.sdk.openadsdk.core.un.z.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
                long j = dlVarZ.get("save_jump_success_time", 0L);
                if (j <= 0) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                if (jCurrentTimeMillis >= 86400000 || jCurrentTimeMillis <= 0) {
                    return;
                }
                String str = dlVarZ.get("save_jump_success_ad_tag", "");
                String str2 = dlVarZ.get("save_dpl_success_materialmeta", "");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                dlVarZ.remove("save_dpl_success_materialmeta");
                com.bytedance.sdk.openadsdk.core.i.a.z(jCurrentTimeMillis, str, str2);
            }
        });
    }

    public void z(InterfaceC0206z interfaceC0206z) {
        this.f1386a = interfaceC0206z;
    }

    public void z(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.gc = activityLifecycleCallbacks;
    }

    public void z(com.bytedance.sdk.component.adexpress.z zVar) {
        this.fo.add(new WeakReference<>(zVar));
    }

    public boolean g(com.bytedance.sdk.component.adexpress.z zVar) {
        return this.fo.remove(new WeakReference(zVar));
    }

    public void z(g gVar) {
        if (this.uy.contains(gVar)) {
            return;
        }
        this.uy.add(gVar);
    }

    public void g(g gVar) {
        this.m = gVar;
    }

    public void dl() {
        if (this.f1386a != null) {
            this.f1386a = null;
        }
    }

    public boolean z(Activity activity, Runnable runnable) {
        boolean zAdd;
        if (activity == null) {
            return false;
        }
        int iHashCode = activity.hashCode();
        synchronized (this.wp) {
            Set<Runnable> hashSet = this.wp.get(iHashCode);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.wp.put(iHashCode, hashSet);
            }
            zAdd = hashSet.add(runnable);
        }
        return zAdd;
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.un.g.z().g();
    }
}
