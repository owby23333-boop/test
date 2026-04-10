package me.jessyan.art.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: compiled from: ActivityLifecycle.java */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
public class a implements Application.ActivityLifecycleCallbacks {

    @Inject
    d a;

    @Inject
    Application b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    me.jessyan.art.d.j.a<String, Object> f21169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    dagger.a<FragmentManager.FragmentLifecycleCallbacks> f21170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Inject
    dagger.a<List<FragmentManager.FragmentLifecycleCallbacks>> f21171e;

    @Inject
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private me.jessyan.art.base.f.a a(Activity activity) {
        if (activity instanceof me.jessyan.art.base.f.h) {
            return (me.jessyan.art.base.f.a) a((me.jessyan.art.base.f.h) activity).get(me.jessyan.art.d.j.c.d("ACTIVITY_DELEGATE"));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(Activity activity) {
        boolean zUseFragment = activity instanceof me.jessyan.art.base.f.h ? ((me.jessyan.art.base.f.h) activity).useFragment() : true;
        if ((activity instanceof FragmentActivity) && zUseFragment) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f21170d.get(), true);
            if (this.f21169c.containsKey(me.jessyan.art.d.j.c.d(e.class.getName()))) {
                Iterator it = ((List) this.f21169c.get(me.jessyan.art.d.j.c.d(e.class.getName()))).iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(this.b, this.f21171e.get());
                }
                this.f21169c.remove(me.jessyan.art.d.j.c.d(e.class.getName()));
            }
            Iterator<FragmentManager.FragmentLifecycleCallbacks> it2 = this.f21171e.get().iterator();
            while (it2.hasNext()) {
                fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(it2.next(), true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("is_not_add_activity_list", false) : false)) {
            this.a.a(activity);
        }
        if (activity instanceof me.jessyan.art.base.f.h) {
            me.jessyan.art.base.f.a aVarA = a(activity);
            if (aVarA == null) {
                me.jessyan.art.d.j.a<String, Object> aVarA2 = a((me.jessyan.art.base.f.h) activity);
                me.jessyan.art.base.f.b bVar = new me.jessyan.art.base.f.b(activity);
                aVarA2.put(me.jessyan.art.d.j.c.d("ACTIVITY_DELEGATE"), bVar);
                aVarA = bVar;
            }
            aVarA.onCreate(bundle);
        }
        b(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.a.b(activity);
        me.jessyan.art.base.f.a aVarA = a(activity);
        if (aVarA != null) {
            aVarA.onDestroy();
            a((me.jessyan.art.base.f.h) activity).clear();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        me.jessyan.art.base.f.a aVarA = a(activity);
        if (aVarA != null) {
            aVarA.onPause();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.a.c(activity);
        me.jessyan.art.base.f.a aVarA = a(activity);
        if (aVarA != null) {
            aVarA.onResume();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        me.jessyan.art.base.f.a aVarA = a(activity);
        if (aVarA != null) {
            aVarA.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        me.jessyan.art.base.f.a aVarA = a(activity);
        if (aVarA != null) {
            aVarA.onStart();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.a.b() == activity) {
            this.a.c(null);
        }
        me.jessyan.art.base.f.a aVarA = a(activity);
        if (aVarA != null) {
            aVarA.onStop();
        }
    }

    @NonNull
    private me.jessyan.art.d.j.a<String, Object> a(me.jessyan.art.base.f.h hVar) {
        me.jessyan.art.d.j.a<String, Object> aVarProvideCache = hVar.provideCache();
        me.jessyan.art.f.g.a(aVarProvideCache, "%s cannot be null on Activity", me.jessyan.art.d.j.a.class.getName());
        return aVarProvideCache;
    }
}
