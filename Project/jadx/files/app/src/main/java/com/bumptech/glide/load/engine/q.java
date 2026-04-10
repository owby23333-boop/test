package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes2.dex */
public class q<Data, ResourceType, Transcode> {
    private final Pools.Pool<List<Throwable>> a;
    private final List<? extends g<Data, ResourceType, Transcode>> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13579c;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = pool;
        com.bumptech.glide.util.k.a(list);
        this.b = list;
        this.f13579c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.f fVar, int i2, int i3, g.a<ResourceType> aVar) throws GlideException {
        List<Throwable> listAcquire = this.a.acquire();
        com.bumptech.glide.util.k.a(listAcquire);
        List<Throwable> list = listAcquire;
        try {
            return a(eVar, fVar, i2, i3, aVar, list);
        } finally {
            this.a.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }

    private s<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.f fVar, int i2, int i3, g.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.b.size();
        s<Transcode> sVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                sVarA = this.b.get(i4).a(eVar, i2, i3, fVar, aVar);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (sVarA != null) {
                break;
            }
        }
        if (sVarA != null) {
            return sVarA;
        }
        throw new GlideException(this.f13579c, new ArrayList(list));
    }
}
