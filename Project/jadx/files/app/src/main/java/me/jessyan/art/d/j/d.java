package me.jessyan.art.d.j;

import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes3.dex */
public class d<K, V> implements a<K, V> {
    private int b;
    private final LinkedHashMap<K, V> a = new LinkedHashMap<>(100, 0.75f, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21180c = 0;

    public d(int i2) {
        this.b = i2;
    }

    protected int a(V v2) {
        return 1;
    }

    protected synchronized void a(int i2) {
        while (this.f21180c > i2) {
            Map.Entry<K, V> next = this.a.entrySet().iterator().next();
            V value = next.getValue();
            this.f21180c -= a(value);
            K key = next.getKey();
            this.a.remove(key);
            a(key, value);
        }
    }

    protected void a(K k2, V v2) {
    }

    @Override // me.jessyan.art.d.j.a
    public void clear() {
        a(0);
    }

    @Override // me.jessyan.art.d.j.a
    public synchronized boolean containsKey(K k2) {
        return this.a.containsKey(k2);
    }

    @Override // me.jessyan.art.d.j.a
    @Nullable
    public synchronized V get(K k2) {
        return this.a.get(k2);
    }

    @Override // me.jessyan.art.d.j.a
    @Nullable
    public synchronized V put(K k2, V v2) {
        if (a(v2) >= this.b) {
            a(k2, v2);
            return null;
        }
        V vPut = this.a.put(k2, v2);
        if (v2 != null) {
            this.f21180c += a(v2);
        }
        if (vPut != null) {
            this.f21180c -= a(vPut);
        }
        a();
        return vPut;
    }

    @Override // me.jessyan.art.d.j.a
    @Nullable
    public synchronized V remove(K k2) {
        V vRemove;
        vRemove = this.a.remove(k2);
        if (vRemove != null) {
            this.f21180c -= a(vRemove);
        }
        return vRemove;
    }

    private void a() {
        a(this.b);
    }
}
