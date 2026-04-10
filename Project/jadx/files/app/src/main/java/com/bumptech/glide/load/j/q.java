package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.j.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiModelLoader.java */
/* JADX INFO: loaded from: classes2.dex */
class q<Model, Data> implements n<Model, Data> {
    private final List<n<Model, Data>> a;
    private final Pools.Pool<List<Throwable>> b;

    q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.a = list;
        this.b = pool;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        n.a<Data> aVarA;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.c cVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.a.get(i4);
            if (nVar.a(model) && (aVarA = nVar.a(model, i2, i3, fVar)) != null) {
                cVar = aVarA.a;
                arrayList.add(aVarA.f13681c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }

    /* JADX INFO: compiled from: MultiModelLoader.java */
    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f13682s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f13683t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f13684u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private Priority f13685v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private d.a<? super Data> f13686w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Nullable
        private List<Throwable> f13687x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f13688y;

        a(@NonNull List<com.bumptech.glide.load.data.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f13683t = pool;
            com.bumptech.glide.util.k.a(list);
            this.f13682s = list;
            this.f13684u = 0;
        }

        private void c() {
            if (this.f13688y) {
                return;
            }
            if (this.f13684u < this.f13682s.size() - 1) {
                this.f13684u++;
                a(this.f13685v, this.f13686w);
            } else {
                com.bumptech.glide.util.k.a(this.f13687x);
                this.f13686w.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f13687x)));
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f13685v = priority;
            this.f13686w = aVar;
            this.f13687x = this.f13683t.acquire();
            this.f13682s.get(this.f13684u).a(priority, this);
            if (this.f13688y) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f13687x;
            if (list != null) {
                this.f13683t.release(list);
            }
            this.f13687x = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f13682s.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f13688y = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f13682s.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return this.f13682s.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f13682s.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.f13686w.a(data);
            } else {
                c();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(@NonNull Exception exc) {
            List<Throwable> list = this.f13687x;
            com.bumptech.glide.util.k.a(list);
            list.add(exc);
            c();
        }
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Model model) {
        Iterator<n<Model, Data>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }
}
