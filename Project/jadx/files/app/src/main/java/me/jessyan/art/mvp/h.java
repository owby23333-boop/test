package me.jessyan.art.mvp;

import android.app.Application;
import io.rx_cache2.internal.RxCache;
import me.jessyan.art.d.j.a;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: RepositoryManager_MembersInjector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements dagger.b<f> {
    public static void a(f fVar, dagger.a<Retrofit> aVar) {
        fVar.a = aVar;
    }

    public static void b(f fVar, dagger.a<RxCache> aVar) {
        fVar.b = aVar;
    }

    public static void a(f fVar, Application application) {
        fVar.f21209c = application;
    }

    public static void a(f fVar, a.InterfaceC0579a interfaceC0579a) {
        fVar.f21210d = interfaceC0579a;
    }
}
