package com.bumptech.glide.load.engine.x;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: LruArrayPool.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements com.bumptech.glide.load.engine.x.b {
    private final h<a, Object> a = new h<>();
    private final b b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f13614c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.x.a<?>> f13615d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13617f;

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class b extends d<a> {
        b() {
        }

        a a(int i2, Class<?> cls) {
            a aVarB = b();
            aVarB.a(i2, cls);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.x.d
        public a a() {
            return new a(this);
        }
    }

    public j(int i2) {
        this.f13616e = i2;
    }

    private boolean c() {
        int i2 = this.f13617f;
        return i2 == 0 || this.f13616e / i2 >= 2;
    }

    @Override // com.bumptech.glide.load.engine.x.b
    public synchronized <T> T a(int i2, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = b((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
        return (T) a(a(i2, numCeilingKey) ? this.b.a(numCeilingKey.intValue(), cls) : this.b.a(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.x.b
    public synchronized <T> T b(int i2, Class<T> cls) {
        return (T) a(this.b.a(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.x.b
    public synchronized <T> void put(T t2) {
        Class<?> cls = t2.getClass();
        com.bumptech.glide.load.engine.x.a<T> aVarA = a((Class) cls);
        int iA = aVarA.a(t2);
        int iA2 = aVarA.a() * iA;
        if (b(iA2)) {
            a aVarA2 = this.b.a(iA, cls);
            this.a.a(aVarA2, t2);
            NavigableMap<Integer, Integer> navigableMapB = b(cls);
            Integer num = (Integer) navigableMapB.get(Integer.valueOf(aVarA2.b));
            Integer numValueOf = Integer.valueOf(aVarA2.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapB.put(numValueOf, Integer.valueOf(iIntValue));
            this.f13617f += iA2;
            b();
        }
    }

    @Override // com.bumptech.glide.load.engine.x.b
    public synchronized void trimMemory(int i2) {
        try {
            if (i2 >= 40) {
                a();
            } else if (i2 >= 20 || i2 == 15) {
                a(this.f13616e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class a implements m {
        private final b a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f13618c;

        a(b bVar) {
            this.a = bVar;
        }

        void a(int i2, Class<?> cls) {
            this.b = i2;
            this.f13618c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.f13618c == aVar.f13618c;
        }

        public int hashCode() {
            int i2 = this.b * 31;
            Class<?> cls = this.f13618c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.f13618c + '}';
        }

        @Override // com.bumptech.glide.load.engine.x.m
        public void a() {
            this.a.a(this);
        }
    }

    private void c(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapB = b(cls);
        Integer num = (Integer) navigableMapB.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapB.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapB.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private boolean b(int i2) {
        return i2 <= this.f13616e / 2;
    }

    private void b() {
        a(this.f13616e);
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f13614c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f13614c.put(cls, treeMap);
        return treeMap;
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.x.a<T> aVarA = a((Class) cls);
        T t2 = (T) a(aVar);
        if (t2 != null) {
            this.f13617f -= aVarA.a(t2) * aVarA.a();
            c(aVarA.a(t2), cls);
        }
        if (t2 != null) {
            return t2;
        }
        if (Log.isLoggable(aVarA.getTag(), 2)) {
            aVarA.getTag();
            String str = "Allocated " + aVar.b + " bytes";
        }
        return aVarA.newArray(aVar.b);
    }

    @Nullable
    private <T> T a(a aVar) {
        return (T) this.a.a(aVar);
    }

    private boolean a(int i2, Integer num) {
        return num != null && (c() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.engine.x.b
    public synchronized void a() {
        a(0);
    }

    private void a(int i2) {
        while (this.f13617f > i2) {
            Object objA = this.a.a();
            com.bumptech.glide.util.k.a(objA);
            com.bumptech.glide.load.engine.x.a aVarA = a(objA);
            this.f13617f -= aVarA.a(objA) * aVarA.a();
            c(aVarA.a(objA), objA.getClass());
            if (Log.isLoggable(aVarA.getTag(), 2)) {
                aVarA.getTag();
                String str = "evicted: " + aVarA.a(objA);
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.x.a<T> a(T t2) {
        return a((Class) t2.getClass());
    }

    private <T> com.bumptech.glide.load.engine.x.a<T> a(Class<T> cls) {
        com.bumptech.glide.load.engine.x.a<T> gVar = (com.bumptech.glide.load.engine.x.a) this.f13615d.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f13615d.put(cls, gVar);
        }
        return gVar;
    }
}
