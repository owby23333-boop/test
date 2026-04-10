package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bf;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bf<T extends bf<?, ?>, F extends bc> implements av<T, F> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f19537c = new HashMap();
    protected Object a;
    protected F b;

    /* JADX INFO: compiled from: TUnion.java */
    private static class a extends ce<bf> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.a = null;
            buVar.j();
            bp bpVarL = buVar.l();
            bfVar.a = bfVar.a(buVar, bpVarL);
            if (bfVar.a != null) {
                bfVar.b = (F) bfVar.a(bpVarL.f19582c);
            }
            buVar.m();
            buVar.l();
            buVar.k();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.d());
            buVar.a(bfVar.c(bfVar.b));
            bfVar.a(buVar);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class c extends cf<bf> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.a = null;
            short sV = buVar.v();
            bfVar.a = bfVar.a(buVar, sV);
            if (bfVar.a != null) {
                bfVar.b = (F) bfVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.b.a());
            bfVar.b(buVar);
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f19537c.put(ce.class, new b());
        f19537c.put(cf.class, new d());
    }

    protected bf() {
        this.b = null;
        this.a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof av ? ((av) obj).deepCopy() : obj instanceof ByteBuffer ? aw.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s2);

    protected abstract Object a(bu buVar, bp bpVar) throws bb;

    protected abstract Object a(bu buVar, short s2) throws bb;

    protected abstract void a(bu buVar) throws bb;

    public Object b() {
        return this.a;
    }

    protected abstract void b(F f2, Object obj) throws ClassCastException;

    protected abstract void b(bu buVar) throws bb;

    protected abstract bp c(F f2);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.av
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    protected abstract bz d();

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f19537c.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(bf.class.getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).a);
            sb.append(":");
            if (objB instanceof ByteBuffer) {
                aw.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f19537c.get(buVar.D()).b().a(buVar, this);
    }

    public boolean b(F f2) {
        return this.b == f2;
    }

    public boolean b(int i2) {
        return b(a((short) i2));
    }

    protected bf(F f2, Object obj) {
        a(f2, obj);
    }

    protected bf(bf<T, F> bfVar) {
        if (bfVar.getClass().equals(bf.class)) {
            this.b = bfVar.b;
            this.a = a(bfVar.a);
            return;
        }
        throw new ClassCastException();
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

    public Object a(F f2) {
        if (f2 == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.b);
    }

    public Object a(int i2) {
        return a(a((short) i2));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.b = f2;
        this.a = obj;
    }

    public void a(int i2, Object obj) {
        a(a((short) i2), obj);
    }
}
