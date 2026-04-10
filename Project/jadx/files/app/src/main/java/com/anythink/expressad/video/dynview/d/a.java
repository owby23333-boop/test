package com.anythink.expressad.video.dynview.d;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a<K, V> extends HashMap<K, V> {
    private ReferenceQueue<V> a = new ReferenceQueue<>();
    private HashMap<K, a<K, V>.C0222a<K, V>> b = new HashMap<>();

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.d.a$a, reason: collision with other inner class name */
    private class C0222a<K, V> extends SoftReference<V> {
        K a;

        public C0222a(K k2, V v2, ReferenceQueue referenceQueue) {
            super(v2, referenceQueue);
            this.a = k2;
        }
    }

    private void a() {
        while (true) {
            C0222a c0222a = (C0222a) this.a.poll();
            if (c0222a == null) {
                return;
            } else {
                this.b.remove(c0222a.a);
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        a();
        return this.b.containsKey(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        a();
        a<K, V>.C0222a<K, V> c0222a = this.b.get(obj);
        if (c0222a == null) {
            return null;
        }
        return c0222a.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v2) {
        a();
        a<K, V>.C0222a<K, V> c0222aPut = this.b.put(k2, new C0222a<>(k2, v2, this.a));
        if (c0222aPut == null) {
            return null;
        }
        return c0222aPut.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        a();
        a<K, V>.C0222a<K, V> c0222aRemove = this.b.remove(obj);
        if (c0222aRemove == null) {
            return null;
        }
        return c0222aRemove.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        a();
        return this.b.size();
    }
}
