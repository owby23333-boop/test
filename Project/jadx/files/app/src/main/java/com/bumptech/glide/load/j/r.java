package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.j.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MultiModelLoaderFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f13689e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f13690f = new a();
    private final List<b<?, ?>> a;
    private final c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f13691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f13692d;

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.j.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.j.n
        public boolean a(@NonNull Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class b<Model, Data> {
        private final Class<Model> a;
        final Class<Data> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f13693c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.a = cls;
            this.b = cls2;
            this.f13693c = oVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f13689e);
    }

    synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> listB;
        listB = b(cls, cls2);
        a(cls, cls2, oVar);
        return listB;
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.a = new ArrayList();
        this.f13691c = new HashSet();
        this.f13692d = pool;
        this.b = cVar;
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z2) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.a;
        list.add(z2 ? list.size() : 0, bVar);
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.a(cls, cls2)) {
                it.remove();
                arrayList.add(b(next));
            }
        }
        return arrayList;
    }

    @NonNull
    synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.f13691c.contains(bVar) && bVar.a(cls)) {
                    this.f13691c.add(bVar);
                    arrayList.add(a(bVar));
                    this.f13691c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f13691c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            for (b<?, ?> bVar : this.a) {
                if (this.f13691c.contains(bVar)) {
                    z2 = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f13691c.add(bVar);
                    arrayList.add(a(bVar));
                    this.f13691c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.f13692d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (z2) {
                return a();
            }
            throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f13691c.clear();
            throw th;
        }
    }

    @NonNull
    private <Model, Data> o<Model, Data> b(@NonNull b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f13693c;
    }

    @NonNull
    private <Model, Data> n<Model, Data> a(@NonNull b<?, ?> bVar) {
        Object objA = bVar.f13693c.a(this);
        com.bumptech.glide.util.k.a(objA);
        return (n) objA;
    }

    @NonNull
    private static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f13690f;
    }
}
