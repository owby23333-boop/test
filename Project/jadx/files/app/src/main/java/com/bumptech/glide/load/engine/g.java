package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes2.dex */
public class g<DataType, ResourceType, Transcode> {
    private final Class<DataType> a;
    private final List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.k.h.e<ResourceType, Transcode> f13531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f13532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13533e;

    /* JADX INFO: compiled from: DecodePath.java */
    interface a<ResourceType> {
        @NonNull
        s<ResourceType> a(@NonNull s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> list, com.bumptech.glide.load.k.h.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = list;
        this.f13531c = eVar;
        this.f13532d = pool;
        this.f13533e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar, a<ResourceType> aVar) throws GlideException {
        return this.f13531c.a(aVar.a(a(eVar, i2, i3, fVar)), fVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.f13531c + '}';
    }

    @NonNull
    private s<ResourceType> a(com.bumptech.glide.load.data.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws GlideException {
        List<Throwable> listAcquire = this.f13532d.acquire();
        com.bumptech.glide.util.k.a(listAcquire);
        List<Throwable> list = listAcquire;
        try {
            return a(eVar, i2, i3, fVar, list);
        } finally {
            this.f13532d.release(list);
        }
    }

    @NonNull
    private s<ResourceType> a(com.bumptech.glide.load.data.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar, List<Throwable> list) throws GlideException {
        int size = this.b.size();
        s<ResourceType> sVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.bumptech.glide.load.g<DataType, ResourceType> gVar = this.b.get(i4);
            try {
                if (gVar.a(eVar.a(), fVar)) {
                    sVarA = gVar.a(eVar.a(), i2, i3, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    String str = "Failed to decode data for " + gVar;
                }
                list.add(e2);
            }
            if (sVarA != null) {
                break;
            }
        }
        if (sVarA != null) {
            return sVarA;
        }
        throw new GlideException(this.f13533e, new ArrayList(list));
    }
}
