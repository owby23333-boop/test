package com.bumptech.glide.util.m;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final g<Object> a = new C0281a();

    /* JADX INFO: renamed from: com.bumptech.glide.util.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    class C0281a implements g<Object> {
        C0281a() {
        }

        @Override // com.bumptech.glide.util.m.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.util.m.a.d
        @NonNull
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.m.a.g
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface d<T> {
        T create();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    private static final class e<T> implements Pools.Pool<T> {
        private final d<T> a;
        private final g<T> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Pools.Pool<T> f13902c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f13902c = pool;
            this.a = dVar;
            this.b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.f13902c.acquire();
            if (tAcquire == null) {
                tAcquire = this.a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    String str = "Created new " + tAcquire.getClass();
                }
            }
            if (tAcquire instanceof f) {
                ((f) tAcquire).b().a(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t2) {
            if (t2 instanceof f) {
                ((f) t2).b().a(true);
            }
            this.b.a(t2);
            return this.f13902c.release(t2);
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface f {
        @NonNull
        com.bumptech.glide.util.m.c b();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface g<T> {
        void a(@NonNull T t2);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i2), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> b() {
        return a(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i2) {
        return a(new Pools.SynchronizedPool(i2), new b(), new c());
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return a(pool, dVar, a());
    }

    @NonNull
    private static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> a() {
        return (g<T>) a;
    }
}
