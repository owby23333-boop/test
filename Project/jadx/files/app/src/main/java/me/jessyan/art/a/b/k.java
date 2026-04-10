package me.jessyan.art.a.b;

import retrofit2.Retrofit;

/* JADX INFO: compiled from: ClientModule_ProvideRetrofitBuilderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements dagger.internal.b<Retrofit.Builder> {
    private static final k a = new k();

    public static k a() {
        return a;
    }

    public static Retrofit.Builder b() {
        return c();
    }

    public static Retrofit.Builder c() {
        Retrofit.Builder builderB = g.b();
        dagger.internal.d.a(builderB, "Cannot return null from a non-@Nullable @Provides method");
        return builderB;
    }

    @Override // javax.inject.a, dagger.a
    public Retrofit.Builder get() {
        return b();
    }
}
