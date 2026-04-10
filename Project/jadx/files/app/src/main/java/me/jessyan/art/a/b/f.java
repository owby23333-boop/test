package me.jessyan.art.a.b;

import android.app.Application;
import com.google.gson.Gson;
import me.jessyan.art.a.b.b;

/* JADX INFO: compiled from: AppModule_ProvideGsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements dagger.internal.b<Gson> {
    private final javax.inject.a<Application> a;
    private final javax.inject.a<b.a> b;

    public f(javax.inject.a<Application> aVar, javax.inject.a<b.a> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public static f a(javax.inject.a<Application> aVar, javax.inject.a<b.a> aVar2) {
        return new f(aVar, aVar2);
    }

    public static Gson b(javax.inject.a<Application> aVar, javax.inject.a<b.a> aVar2) {
        return a(aVar.get(), aVar2.get());
    }

    public static Gson a(Application application, b.a aVar) {
        Gson gsonA = b.a(application, aVar);
        dagger.internal.d.a(gsonA, "Cannot return null from a non-@Nullable @Provides method");
        return gsonA;
    }

    @Override // javax.inject.a, dagger.a
    public Gson get() {
        return b(this.a, this.b);
    }
}
