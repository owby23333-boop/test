package me.jessyan.art.base.f;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.jessyan.art.a.a.a;
import me.jessyan.art.a.b.o;

/* JADX INFO: compiled from: AppDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements me.jessyan.art.base.b, e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Application f21152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private me.jessyan.art.a.a.a f21153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Inject
    protected Application.ActivityLifecycleCallbacks f21154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<me.jessyan.art.d.e> f21155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List<e> f21156w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<Application.ActivityLifecycleCallbacks> f21157x = new ArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ComponentCallbacks2 f21158y;

    /* JADX INFO: compiled from: AppDelegate.java */
    private static class a implements ComponentCallbacks2 {
        a(Application application, me.jessyan.art.a.a.a aVar) {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i2) {
        }
    }

    public c(@NonNull Context context) {
        this.f21155v = new me.jessyan.art.d.i(context).a();
        for (me.jessyan.art.d.e eVar : this.f21155v) {
            eVar.b(context, this.f21156w);
            eVar.c(context, this.f21157x);
        }
    }

    @Override // me.jessyan.art.base.f.e
    public void a(@NonNull Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f21154u;
        if (activityLifecycleCallbacks != null) {
            this.f21152s.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        ComponentCallbacks2 componentCallbacks2 = this.f21158y;
        if (componentCallbacks2 != null) {
            this.f21152s.unregisterComponentCallbacks(componentCallbacks2);
        }
        List<Application.ActivityLifecycleCallbacks> list = this.f21157x;
        if (list != null && list.size() > 0) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.f21157x.iterator();
            while (it.hasNext()) {
                this.f21152s.unregisterActivityLifecycleCallbacks(it.next());
            }
        }
        List<e> list2 = this.f21156w;
        if (list2 != null && list2.size() > 0) {
            Iterator<e> it2 = this.f21156w.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.f21152s);
            }
        }
        this.f21153t = null;
        this.f21154u = null;
        this.f21157x = null;
        this.f21158y = null;
        this.f21156w = null;
        this.f21152s = null;
    }

    @Override // me.jessyan.art.base.f.e
    public void attachBaseContext(@NonNull Context context) {
        Iterator<e> it = this.f21156w.iterator();
        while (it.hasNext()) {
            it.next().attachBaseContext(context);
        }
    }

    @Override // me.jessyan.art.base.f.e
    public void b(@NonNull Application application) {
        this.f21152s = application;
        a.InterfaceC0577a interfaceC0577aF = me.jessyan.art.a.a.b.f();
        interfaceC0577aF.a(this.f21152s);
        interfaceC0577aF.a(a(this.f21152s, this.f21155v));
        this.f21153t = interfaceC0577aF.build();
        this.f21153t.a(this);
        this.f21153t.e().put(me.jessyan.art.d.j.c.d(me.jessyan.art.d.e.class.getName()), this.f21155v);
        this.f21155v = null;
        this.f21152s.registerActivityLifecycleCallbacks(this.f21154u);
        Iterator<Application.ActivityLifecycleCallbacks> it = this.f21157x.iterator();
        while (it.hasNext()) {
            this.f21152s.registerActivityLifecycleCallbacks(it.next());
        }
        this.f21158y = new a(this.f21152s, this.f21153t);
        this.f21152s.registerComponentCallbacks(this.f21158y);
        Iterator<e> it2 = this.f21156w.iterator();
        while (it2.hasNext()) {
            it2.next().b(this.f21152s);
        }
    }

    @Override // me.jessyan.art.base.b
    @NonNull
    public me.jessyan.art.a.a.a getAppComponent() {
        me.jessyan.art.a.a.a aVar = this.f21153t;
        Object[] objArr = new Object[3];
        objArr[0] = me.jessyan.art.a.a.a.class.getName();
        objArr[1] = c.class.getName();
        Application application = this.f21152s;
        objArr[2] = (application == null ? Application.class : application.getClass()).getName();
        me.jessyan.art.f.g.a(aVar, "%s == null, first call %s#onCreate(Application) in %s#onCreate()", objArr);
        return this.f21153t;
    }

    private o a(Context context, List<me.jessyan.art.d.e> list) {
        o.b bVarM = o.m();
        Iterator<me.jessyan.art.d.e> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(context, bVarM);
        }
        return bVarM.a();
    }
}
