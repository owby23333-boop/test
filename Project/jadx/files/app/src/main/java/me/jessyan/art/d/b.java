package me.jessyan.art.d;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* JADX INFO: compiled from: ActivityLifecycle_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements dagger.internal.b<a> {
    private final javax.inject.a<d> a;
    private final javax.inject.a<Application> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final javax.inject.a<me.jessyan.art.d.j.a<String, Object>> f21172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final javax.inject.a<FragmentManager.FragmentLifecycleCallbacks> f21173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final javax.inject.a<List<FragmentManager.FragmentLifecycleCallbacks>> f21174e;

    public b(javax.inject.a<d> aVar, javax.inject.a<Application> aVar2, javax.inject.a<me.jessyan.art.d.j.a<String, Object>> aVar3, javax.inject.a<FragmentManager.FragmentLifecycleCallbacks> aVar4, javax.inject.a<List<FragmentManager.FragmentLifecycleCallbacks>> aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.f21172c = aVar3;
        this.f21173d = aVar4;
        this.f21174e = aVar5;
    }

    public static b a(javax.inject.a<d> aVar, javax.inject.a<Application> aVar2, javax.inject.a<me.jessyan.art.d.j.a<String, Object>> aVar3, javax.inject.a<FragmentManager.FragmentLifecycleCallbacks> aVar4, javax.inject.a<List<FragmentManager.FragmentLifecycleCallbacks>> aVar5) {
        return new b(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static a b(javax.inject.a<d> aVar, javax.inject.a<Application> aVar2, javax.inject.a<me.jessyan.art.d.j.a<String, Object>> aVar3, javax.inject.a<FragmentManager.FragmentLifecycleCallbacks> aVar4, javax.inject.a<List<FragmentManager.FragmentLifecycleCallbacks>> aVar5) {
        a aVar6 = new a();
        c.a(aVar6, aVar.get());
        c.a(aVar6, aVar2.get());
        c.a(aVar6, aVar3.get());
        c.a(aVar6, (dagger.a<FragmentManager.FragmentLifecycleCallbacks>) dagger.internal.a.a(aVar4));
        c.b(aVar6, dagger.internal.a.a(aVar5));
        return aVar6;
    }

    @Override // javax.inject.a, dagger.a
    public a get() {
        return b(this.a, this.b, this.f21172c, this.f21173d, this.f21174e);
    }
}
