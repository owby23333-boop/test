package me.jessyan.art.d;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* JADX INFO: compiled from: ActivityLifecycle_MembersInjector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements dagger.b<a> {
    public static void a(a aVar, d dVar) {
        aVar.a = dVar;
    }

    public static void b(a aVar, dagger.a<List<FragmentManager.FragmentLifecycleCallbacks>> aVar2) {
        aVar.f21171e = aVar2;
    }

    public static void a(a aVar, Application application) {
        aVar.b = application;
    }

    public static void a(a aVar, me.jessyan.art.d.j.a<String, Object> aVar2) {
        aVar.f21169c = aVar2;
    }

    public static void a(a aVar, dagger.a<FragmentManager.FragmentLifecycleCallbacks> aVar2) {
        aVar.f21170d = aVar2;
    }
}
