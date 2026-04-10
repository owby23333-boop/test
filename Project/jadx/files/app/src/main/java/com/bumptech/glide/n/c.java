package com.bumptech.glide.n;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.util.j;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LoadPathCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q<?, ?, ?> f13804c = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.bumptech.glide.load.k.h.g(), null)), null);
    private final ArrayMap<j, q<?, ?, ?>> a = new ArrayMap<>();
    private final AtomicReference<j> b = new AtomicReference<>();

    private j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        j andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new j();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean a(@Nullable q<?, ?, ?> qVar) {
        return f13804c.equals(qVar);
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        j jVarB = b(cls, cls2, cls3);
        synchronized (this.a) {
            qVar = (q) this.a.get(jVarB);
        }
        this.b.set(jVarB);
        return qVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable q<?, ?, ?> qVar) {
        synchronized (this.a) {
            ArrayMap<j, q<?, ?, ?>> arrayMap = this.a;
            j jVar = new j(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f13804c;
            }
            arrayMap.put(jVar, qVar);
        }
    }
}
