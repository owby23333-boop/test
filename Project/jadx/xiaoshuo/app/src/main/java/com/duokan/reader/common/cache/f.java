package com.duokan.reader.common.cache;

import com.duokan.reader.common.cache.ListCache;
import com.duokan.reader.common.cache.h;
import com.yuewen.cb0;
import com.yuewen.t41;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class f<TItem> implements ListCache.j<TItem, a<TItem>, b<TItem>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f4005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4006b;
    public final b<TItem> c;
    public final int d;

    public interface a<TItem> extends t41<TItem> {
        h.a b();
    }

    public interface b<TItem> extends Comparator<TItem> {
        h.e[] a();
    }

    public static class c<TItem> extends ListCache.n<TItem> implements b<TItem> {
        public c(boolean z) {
            super(z);
        }

        @Override // com.duokan.reader.common.cache.f.b
        public h.e[] a() {
            return new h.e[]{new h.e(h.c.d, this.f3992a)};
        }
    }

    public f(String str, b<TItem> bVar, int i) {
        this(str, bVar, i, cb0.Q());
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void a() {
        this.f4005a.c(this.f4006b);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public ListCache.m b(String str) {
        return this.f4005a.F(this.f4006b, str);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public String c() {
        return this.f4005a.E(this.f4006b);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void e(ArrayList<ListCache.k> arrayList) {
        this.f4005a.p(this.f4006b, arrayList);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public int f() {
        return this.d;
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void g(Collection<String> collection) {
        this.f4005a.l(this.f4006b, collection);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public String getName() {
        return this.f4006b;
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void h(ArrayList<ListCache.m> arrayList) {
        this.f4005a.N(this.f4006b, arrayList);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public int i() {
        return this.f4005a.I(this.f4006b);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void j(int i) {
        this.f4005a.P(this.f4006b, i);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public Collection<String> m(int i) {
        b<TItem> bVar = this.c;
        return this.f4005a.x(this.f4006b, bVar != null ? bVar.a() : null, i);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void n(String str) {
        this.f4005a.M(this.f4006b, str);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public Collection<String> o(Collection<String> collection) {
        return this.f4005a.z(this.f4006b, collection);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    public void q(ArrayList<ListCache.m> arrayList) {
        this.f4005a.t(this.f4006b, arrayList);
    }

    public final h.a r(a<TItem> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public final h.e[] s(b<TItem> bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public b<TItem> k() {
        return this.c;
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Collection<ListCache.m> l(a<TItem> aVar, b<TItem> bVar, ListCache.f fVar) {
        return this.f4005a.y(this.f4006b, r(aVar), s(bVar), fVar);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Collection<String> d(a<TItem> aVar, b<TItem> bVar, ListCache.f fVar) {
        return this.f4005a.G(this.f4006b, r(aVar), s(bVar), fVar);
    }

    @Override // com.duokan.reader.common.cache.ListCache.j
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Collection<ListCache.m> p(a<TItem> aVar, b<TItem> bVar, ListCache.f fVar) {
        return this.f4005a.H(this.f4006b, r(aVar), s(bVar), fVar);
    }

    public f(String str, b<TItem> bVar, int i, h hVar) {
        this.f4006b = str;
        this.c = bVar;
        this.d = i;
        this.f4005a = hVar;
    }
}
