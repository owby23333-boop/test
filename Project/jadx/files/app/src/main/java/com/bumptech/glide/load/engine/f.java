package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes2.dex */
final class f<Transcode> {
    private final List<n.a<?>> a = new ArrayList();
    private final List<com.bumptech.glide.load.c> b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.e f13515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f13516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?> f13519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DecodeJob.e f13520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.f f13521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.i<?>> f13522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class<Transcode> f13523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f13525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.c f13526n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Priority f13527o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private h f13528p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f13529q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f13530r;

    f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i2, int i3, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.f fVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, DecodeJob.e eVar2) {
        this.f13515c = eVar;
        this.f13516d = obj;
        this.f13526n = cVar;
        this.f13517e = i2;
        this.f13518f = i3;
        this.f13528p = hVar;
        this.f13519g = cls;
        this.f13520h = eVar2;
        this.f13523k = cls2;
        this.f13527o = priority;
        this.f13521i = fVar;
        this.f13522j = map;
        this.f13529q = z2;
        this.f13530r = z3;
    }

    com.bumptech.glide.load.engine.x.b b() {
        return this.f13515c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    com.bumptech.glide.load.engine.y.a d() {
        return this.f13520h.a();
    }

    h e() {
        return this.f13528p;
    }

    int f() {
        return this.f13518f;
    }

    List<n.a<?>> g() {
        if (!this.f13524l) {
            this.f13524l = true;
            this.a.clear();
            List listA = this.f13515c.g().a(this.f13516d);
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVarA = ((com.bumptech.glide.load.j.n) listA.get(i2)).a(this.f13516d, this.f13517e, this.f13518f, this.f13521i);
                if (aVarA != null) {
                    this.a.add(aVarA);
                }
            }
        }
        return this.a;
    }

    Class<?> h() {
        return this.f13516d.getClass();
    }

    com.bumptech.glide.load.f i() {
        return this.f13521i;
    }

    Priority j() {
        return this.f13527o;
    }

    List<Class<?>> k() {
        return this.f13515c.g().b(this.f13516d.getClass(), this.f13519g, this.f13523k);
    }

    com.bumptech.glide.load.c l() {
        return this.f13526n;
    }

    Class<?> m() {
        return this.f13523k;
    }

    int n() {
        return this.f13517e;
    }

    boolean o() {
        return this.f13530r;
    }

    <Z> com.bumptech.glide.load.i<Z> b(Class<Z> cls) {
        com.bumptech.glide.load.i<Z> iVar = (com.bumptech.glide.load.i) this.f13522j.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.i<?>>> it = this.f13522j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.i<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    iVar = (com.bumptech.glide.load.i) next.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (!this.f13522j.isEmpty() || !this.f13529q) {
            return com.bumptech.glide.load.k.c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    List<com.bumptech.glide.load.c> c() {
        if (!this.f13525m) {
            this.f13525m = true;
            this.b.clear();
            List<n.a<?>> listG = g();
            int size = listG.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = listG.get(i2);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i3 = 0; i3 < aVar.b.size(); i3++) {
                    if (!this.b.contains(aVar.b.get(i3))) {
                        this.b.add(aVar.b.get(i3));
                    }
                }
            }
        }
        return this.b;
    }

    boolean b(s<?> sVar) {
        return this.f13515c.g().b(sVar);
    }

    <X> com.bumptech.glide.load.a<X> b(X x2) throws Registry.NoSourceEncoderAvailableException {
        return this.f13515c.g().c(x2);
    }

    void a() {
        this.f13515c = null;
        this.f13516d = null;
        this.f13526n = null;
        this.f13519g = null;
        this.f13523k = null;
        this.f13521i = null;
        this.f13527o = null;
        this.f13522j = null;
        this.f13528p = null;
        this.a.clear();
        this.f13524l = false;
        this.b.clear();
        this.f13525m = false;
    }

    <T> com.bumptech.glide.load.data.e<T> a(T t2) {
        return this.f13515c.g().b(t2);
    }

    <Data> q<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f13515c.g().a(cls, this.f13519g, this.f13523k);
    }

    <Z> com.bumptech.glide.load.h<Z> a(s<Z> sVar) {
        return this.f13515c.g().a((s) sVar);
    }

    List<com.bumptech.glide.load.j.n<File, ?>> a(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f13515c.g().a(file);
    }

    boolean a(com.bumptech.glide.load.c cVar) {
        List<n.a<?>> listG = g();
        int size = listG.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listG.get(i2).a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }
}
