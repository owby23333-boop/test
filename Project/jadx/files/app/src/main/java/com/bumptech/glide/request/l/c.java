package com.bumptech.glide.request.l;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.l.d;

/* JADX INFO: compiled from: NoTransition.java */
/* JADX INFO: loaded from: classes2.dex */
public class c<R> implements d<R> {
    static final c<?> a = new c<>();
    private static final e<?> b = new a();

    /* JADX INFO: compiled from: NoTransition.java */
    public static class a<R> implements e<R> {
        @Override // com.bumptech.glide.request.l.e
        public d<R> a(DataSource dataSource, boolean z2) {
            return c.a;
        }
    }

    public static <R> d<R> a() {
        return a;
    }

    public static <R> e<R> b() {
        return (e<R>) b;
    }

    @Override // com.bumptech.glide.request.l.d
    public boolean a(Object obj, d.a aVar) {
        return false;
    }
}
