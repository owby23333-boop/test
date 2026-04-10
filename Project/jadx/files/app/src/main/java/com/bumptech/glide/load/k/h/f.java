package com.bumptech.glide.load.k.h;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TranscoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final List<a<?, ?>> a = new ArrayList();

    /* JADX INFO: compiled from: TranscoderRegistry.java */
    private static final class a<Z, R> {
        final Class<Z> a;
        final Class<R> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e<Z, R> f13750c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.a = cls;
            this.b = cls2;
            this.f13750c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.a.add(new a<>(cls, cls2, eVar));
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                arrayList.add(aVar.b);
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a<?, ?> aVar : this.a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f13750c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
