package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements com.bumptech.glide.load.c {
    private final Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f13566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f13567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.c f13568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.i<?>> f13569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.f f13570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13571j;

    l(Object obj, com.bumptech.glide.load.c cVar, int i2, int i3, Map<Class<?>, com.bumptech.glide.load.i<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.util.k.a(obj);
        this.b = obj;
        com.bumptech.glide.util.k.a(cVar, "Signature must not be null");
        this.f13568g = cVar;
        this.f13564c = i2;
        this.f13565d = i3;
        com.bumptech.glide.util.k.a(map);
        this.f13569h = map;
        com.bumptech.glide.util.k.a(cls, "Resource class must not be null");
        this.f13566e = cls;
        com.bumptech.glide.util.k.a(cls2, "Transcode class must not be null");
        this.f13567f = cls2;
        com.bumptech.glide.util.k.a(fVar);
        this.f13570i = fVar;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.b.equals(lVar.b) && this.f13568g.equals(lVar.f13568g) && this.f13565d == lVar.f13565d && this.f13564c == lVar.f13564c && this.f13569h.equals(lVar.f13569h) && this.f13566e.equals(lVar.f13566e) && this.f13567f.equals(lVar.f13567f) && this.f13570i.equals(lVar.f13570i);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f13571j == 0) {
            this.f13571j = this.b.hashCode();
            this.f13571j = (this.f13571j * 31) + this.f13568g.hashCode();
            this.f13571j = (this.f13571j * 31) + this.f13564c;
            this.f13571j = (this.f13571j * 31) + this.f13565d;
            this.f13571j = (this.f13571j * 31) + this.f13569h.hashCode();
            this.f13571j = (this.f13571j * 31) + this.f13566e.hashCode();
            this.f13571j = (this.f13571j * 31) + this.f13567f.hashCode();
            this.f13571j = (this.f13571j * 31) + this.f13570i.hashCode();
        }
        return this.f13571j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.f13564c + ", height=" + this.f13565d + ", resourceClass=" + this.f13566e + ", transcodeClass=" + this.f13567f + ", signature=" + this.f13568g + ", hashCode=" + this.f13571j + ", transformations=" + this.f13569h + ", options=" + this.f13570i + '}';
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
