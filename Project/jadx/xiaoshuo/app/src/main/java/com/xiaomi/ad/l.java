package com.xiaomi.ad;

/* JADX INFO: loaded from: classes5.dex */
public class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f7269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f7270b;

    public l(g gVar) {
        this.f7269a = null;
        this.f7270b = gVar;
    }

    public g a() {
        return this.f7270b;
    }

    public T b() {
        return this.f7269a;
    }

    public boolean c() {
        return this.f7269a != null && this.f7270b == null;
    }

    public l(T t) {
        this.f7269a = t;
        this.f7270b = null;
    }

    public static <T> l<T> a(g gVar) {
        return new l<>(gVar);
    }

    public static <T> l<T> a(T t) {
        return new l<>(t);
    }
}
