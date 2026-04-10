package me.jessyan.art.http.log;

import me.jessyan.art.http.log.RequestInterceptor;

/* JADX INFO: compiled from: RequestInterceptor_MembersInjector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements dagger.b<RequestInterceptor> {
    public static void a(RequestInterceptor requestInterceptor, me.jessyan.art.c.b bVar) {
        requestInterceptor.a = bVar;
    }

    public static void a(RequestInterceptor requestInterceptor, b bVar) {
        requestInterceptor.b = bVar;
    }

    public static void a(RequestInterceptor requestInterceptor, RequestInterceptor.Level level) {
        requestInterceptor.f21184c = level;
    }
}
