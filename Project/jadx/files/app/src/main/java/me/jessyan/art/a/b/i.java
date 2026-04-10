package me.jessyan.art.a.b;

import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: ClientModule_ProvideClientBuilderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements dagger.internal.b<OkHttpClient.Builder> {
    private static final i a = new i();

    public static i a() {
        return a;
    }

    public static OkHttpClient.Builder b() {
        return c();
    }

    public static OkHttpClient.Builder c() {
        OkHttpClient.Builder builderA = g.a();
        dagger.internal.d.a(builderA, "Cannot return null from a non-@Nullable @Provides method");
        return builderA;
    }

    @Override // javax.inject.a, dagger.a
    public OkHttpClient.Builder get() {
        return b();
    }
}
