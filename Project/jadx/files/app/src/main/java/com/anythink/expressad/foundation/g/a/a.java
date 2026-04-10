package com.anythink.expressad.foundation.g.a;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<K, V> implements e<K, V> {
    protected static final String a = "cache";
    private final Map<K, Reference<V>> b = Collections.synchronizedMap(new HashMap());

    @Override // com.anythink.expressad.foundation.g.a.e
    public boolean a(K k2, V v2) {
        this.b.put(k2, c(v2));
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final V b(K k2) {
        Reference<V> reference = this.b.get(k2);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    protected abstract Reference<V> c(V v2);

    @Override // com.anythink.expressad.foundation.g.a.e
    public void a(K k2) {
        this.b.remove(k2);
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final Collection<K> a() {
        HashSet hashSet;
        synchronized (this.b) {
            hashSet = new HashSet(this.b.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public void b() {
        this.b.clear();
    }
}
