package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bg<T extends bg<?, ?>, F extends bd> implements aw<T, F> {
    private static final Map<Class<? extends cd>, ce> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f2189a;
    protected F b;

    protected abstract F a(short s);

    protected abstract Object a(bv bvVar, bq bqVar) throws bc;

    protected abstract Object a(bv bvVar, short s) throws bc;

    protected abstract void a(bv bvVar) throws bc;

    protected abstract void b(F f, Object obj) throws ClassCastException;

    protected abstract void b(bv bvVar) throws bc;

    protected abstract bq c(F f);

    protected abstract ca d();

    protected bg() {
        this.b = null;
        this.f2189a = null;
    }

    static {
        HashMap map = new HashMap();
        c = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
    }

    protected bg(F f, Object obj) {
        a(f, obj);
    }

    protected bg(bg<T, F> bgVar) {
        if (!bgVar.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.b = bgVar.b;
        this.f2189a = a(bgVar.f2189a);
    }

    private static Object a(Object obj) {
        if (obj instanceof aw) {
            return ((aw) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return ax.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object b() {
        return this.f2189a;
    }

    public Object a(F f) {
        if (f != this.b) {
            throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
        }
        return b();
    }

    public Object a(int i) {
        return a(a((short) i));
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public boolean b(int i) {
        return b(a((short) i));
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        c.get(bvVar.D()).b().b(bvVar, this);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.f2189a = obj;
    }

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        c.get(bvVar.D()).b().a(bvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).f2202a);
            sb.append(":");
            if (objB instanceof ByteBuffer) {
                ax.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public final void clear() {
        this.b = null;
        this.f2189a = null;
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class a extends cf<bg> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, bg bgVar) throws bc {
            bgVar.b = null;
            bgVar.f2189a = null;
            bvVar.j();
            bq bqVarL = bvVar.l();
            bgVar.f2189a = bgVar.a(bvVar, bqVarL);
            if (bgVar.f2189a != null) {
                bgVar.b = (F) bgVar.a(bqVarL.c);
            }
            bvVar.m();
            bvVar.l();
            bvVar.k();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, bg bgVar) throws bc {
            if (bgVar.a() == null || bgVar.b() == null) {
                throw new bw("Cannot write a TUnion with no set value!");
            }
            bvVar.a(bgVar.d());
            bvVar.a(bgVar.c(bgVar.b));
            bgVar.a(bvVar);
            bvVar.c();
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class c extends cg<bg> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, bg bgVar) throws bc {
            bgVar.b = null;
            bgVar.f2189a = null;
            short sV = bvVar.v();
            bgVar.f2189a = bgVar.a(bvVar, sV);
            if (bgVar.f2189a != null) {
                bgVar.b = (F) bgVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, bg bgVar) throws bc {
            if (bgVar.a() == null || bgVar.b() == null) {
                throw new bw("Cannot write a TUnion with no set value!");
            }
            bvVar.a(bgVar.b.a());
            bgVar.b(bvVar);
        }
    }
}
