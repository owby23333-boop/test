package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.j.n;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements e, e.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final f<?> f13601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final e.a f13602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile int f13603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile b f13604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile Object f13605w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile n.a<?> f13606x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile c f13607y;

    w(f<?> fVar, e.a aVar) {
        this.f13601s = fVar;
        this.f13602t = aVar;
    }

    private void b(n.a<?> aVar) {
        this.f13606x.f13681c.a(this.f13601s.j(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        if (this.f13605w != null) {
            Object obj = this.f13605w;
            this.f13605w = null;
            try {
                if (!a(obj)) {
                    return true;
                }
            } catch (IOException unused) {
                Log.isLoggable("SourceGenerator", 3);
            }
        }
        if (this.f13604v != null && this.f13604v.a()) {
            return true;
        }
        this.f13604v = null;
        this.f13606x = null;
        boolean z2 = false;
        while (!z2 && b()) {
            List<n.a<?>> listG = this.f13601s.g();
            int i2 = this.f13603u;
            this.f13603u = i2 + 1;
            this.f13606x = listG.get(i2);
            if (this.f13606x != null && (this.f13601s.e().a(this.f13606x.f13681c.getDataSource()) || this.f13601s.c(this.f13606x.f13681c.a()))) {
                b(this.f13606x);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        n.a<?> aVar = this.f13606x;
        if (aVar != null) {
            aVar.f13681c.cancel();
        }
    }

    /* JADX INFO: compiled from: SourceGenerator.java */
    class a implements d.a<Object> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ n.a f13608s;

        a(n.a aVar) {
            this.f13608s = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(@Nullable Object obj) {
            if (w.this.a(this.f13608s)) {
                w.this.a(this.f13608s, obj);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(@NonNull Exception exc) {
            if (w.this.a(this.f13608s)) {
                w.this.a(this.f13608s, exc);
            }
        }
    }

    private boolean b() {
        return this.f13603u < this.f13601s.g().size();
    }

    boolean a(n.a<?> aVar) {
        n.a<?> aVar2 = this.f13606x;
        return aVar2 != null && aVar2 == aVar;
    }

    private boolean a(Object obj) throws Throwable {
        long jA = com.bumptech.glide.util.g.a();
        boolean z2 = false;
        try {
            com.bumptech.glide.load.data.e<T> eVarA = this.f13601s.a(obj);
            Object objA = eVarA.a();
            com.bumptech.glide.load.a<X> aVarB = this.f13601s.b(objA);
            d dVar = new d(aVarB, objA, this.f13601s.i());
            c cVar = new c(this.f13606x.a, this.f13601s.l());
            com.bumptech.glide.load.engine.y.a aVarD = this.f13601s.d();
            aVarD.a(cVar, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                String str = "Finished encoding source to cache, key: " + cVar + ", data: " + obj + ", encoder: " + aVarB + ", duration: " + com.bumptech.glide.util.g.a(jA);
            }
            if (aVarD.a(cVar) != null) {
                this.f13607y = cVar;
                this.f13604v = new b(Collections.singletonList(this.f13606x.a), this.f13601s, this);
                this.f13606x.f13681c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                String str2 = "Attempt to write: " + this.f13607y + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...";
            }
            try {
                this.f13602t.a(this.f13606x.a, eVarA.a(), this.f13606x.f13681c, this.f13606x.f13681c.getDataSource(), this.f13606x.a);
                return false;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                if (!z2) {
                    this.f13606x.f13681c.b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    void a(n.a<?> aVar, Object obj) {
        h hVarE = this.f13601s.e();
        if (obj != null && hVarE.a(aVar.f13681c.getDataSource())) {
            this.f13605w = obj;
            this.f13602t.c();
        } else {
            e.a aVar2 = this.f13602t;
            com.bumptech.glide.load.c cVar = aVar.a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f13681c;
            aVar2.a(cVar, obj, dVar, dVar.getDataSource(), this.f13607y);
        }
    }

    void a(n.a<?> aVar, @NonNull Exception exc) {
        e.a aVar2 = this.f13602t;
        c cVar = this.f13607y;
        com.bumptech.glide.load.data.d<?> dVar = aVar.f13681c;
        aVar2.a(cVar, exc, dVar, dVar.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f13602t.a(cVar, obj, dVar, this.f13606x.f13681c.getDataSource(), cVar);
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f13602t.a(cVar, exc, dVar, this.f13606x.f13681c.getDataSource());
    }
}
