package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.c;
import com.bumptech.glide.request.k.k;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final j<?, ?> f13307k = new b();
    private final com.bumptech.glide.load.engine.x.b a;
    private final Registry b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.request.k.g f13308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.a f13309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<com.bumptech.glide.request.g<Object>> f13310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f13311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.i f13312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f13313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f13314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.request.h f13315j;

    public e(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.x.b bVar, @NonNull Registry registry, @NonNull com.bumptech.glide.request.k.g gVar, @NonNull c.a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<com.bumptech.glide.request.g<Object>> list, @NonNull com.bumptech.glide.load.engine.i iVar, @NonNull f fVar, int i2) {
        super(context.getApplicationContext());
        this.a = bVar;
        this.b = registry;
        this.f13308c = gVar;
        this.f13309d = aVar;
        this.f13310e = list;
        this.f13311f = map;
        this.f13312g = iVar;
        this.f13313h = fVar;
        this.f13314i = i2;
    }

    @NonNull
    public <T> j<?, T> a(@NonNull Class<T> cls) {
        j<?, T> jVar = (j) this.f13311f.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f13311f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        return jVar == null ? (j<?, T>) f13307k : jVar;
    }

    public List<com.bumptech.glide.request.g<Object>> b() {
        return this.f13310e;
    }

    public synchronized com.bumptech.glide.request.h c() {
        if (this.f13315j == null) {
            this.f13315j = this.f13309d.build().lock();
        }
        return this.f13315j;
    }

    @NonNull
    public com.bumptech.glide.load.engine.i d() {
        return this.f13312g;
    }

    public f e() {
        return this.f13313h;
    }

    public int f() {
        return this.f13314i;
    }

    @NonNull
    public Registry g() {
        return this.b;
    }

    @NonNull
    public <X> k<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f13308c.a(imageView, cls);
    }

    @NonNull
    public com.bumptech.glide.load.engine.x.b a() {
        return this.a;
    }
}
