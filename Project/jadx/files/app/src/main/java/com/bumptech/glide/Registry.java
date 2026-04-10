package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Registry {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.n.d f13281h = new com.bumptech.glide.n.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.n.c f13282i = new com.bumptech.glide.n.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f13283j = com.bumptech.glide.util.m.a.b();
    private final p a = new p(this.f13283j);
    private final com.bumptech.glide.n.a b = new com.bumptech.glide.n.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.n.e f13276c = new com.bumptech.glide.n.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.n.f f13277d = new com.bumptech.glide.n.f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f13278e = new com.bumptech.glide.load.data.f();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.k.h.f f13279f = new com.bumptech.glide.load.k.h.f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.n.b f13280g = new com.bumptech.glide.n.b();

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m2, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        a(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.g<Data, TResource, Transcode>> c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f13276c.b(cls, cls2)) {
            for (Class cls5 : this.f13279f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.g(cls, cls4, cls5, this.f13276c.a(cls, cls4), this.f13279f.a(cls4, cls5), this.f13283j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.b(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        a("legacy_append", cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.f13281h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f13276c.b(it.next(), cls2)) {
                    if (!this.f13279f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f13281h.a(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        this.f13276c.a(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public final Registry a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.f13276c.a(arrayList);
        return this;
    }

    @NonNull
    public <TResource> Registry a(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        this.f13277d.a(cls, hVar);
        return this;
    }

    @NonNull
    public Registry a(@NonNull e.a<?> aVar) {
        this.f13278e.a(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.k.h.e<TResource, Transcode> eVar) {
        this.f13279f.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public Registry a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f13280g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public <Model, Data> Registry a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <X> com.bumptech.glide.load.a<X> c(@NonNull X x2) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> aVarA = this.b.a(x2.getClass());
        if (aVarA != null) {
            return aVarA;
        }
        throw new NoSourceEncoderAvailableException(x2.getClass());
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVarA = this.f13282i.a(cls, cls2, cls3);
        if (this.f13282i.a(qVarA)) {
            return null;
        }
        if (qVarA == null) {
            List<com.bumptech.glide.load.engine.g<Data, TResource, Transcode>> listC = c(cls, cls2, cls3);
            qVarA = listC.isEmpty() ? null : new q<>(cls, cls2, cls3, listC, this.f13283j);
            this.f13282i.a(cls, cls2, cls3, qVarA);
        }
        return qVarA;
    }

    public boolean b(@NonNull s<?> sVar) {
        return this.f13277d.a(sVar.a()) != null;
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.e<X> b(@NonNull X x2) {
        return this.f13278e.a(x2);
    }

    @NonNull
    public <X> com.bumptech.glide.load.h<X> a(@NonNull s<X> sVar) throws NoResultEncoderAvailableException {
        com.bumptech.glide.load.h<X> hVarA = this.f13277d.a(sVar.a());
        if (hVarA != null) {
            return hVarA;
        }
        throw new NoResultEncoderAvailableException(sVar.a());
    }

    @NonNull
    public <Model> List<n<Model, ?>> a(@NonNull Model model) {
        return this.a.a(model);
    }

    @NonNull
    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> listA = this.f13280g.a();
        if (listA.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listA;
    }
}
