package me.jessyan.art.d;

/* JADX INFO: compiled from: FragmentLifecycle_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements dagger.internal.b<g> {
    private static final h a = new h();

    public static h a() {
        return a;
    }

    public static g b() {
        return new g();
    }

    @Override // javax.inject.a, dagger.a
    public g get() {
        return b();
    }
}
