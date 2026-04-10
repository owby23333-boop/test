package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession;

/* JADX INFO: loaded from: classes17.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4076b;
    public final WebSession.CacheStrategy c;
    public final WebSession.CacheStrategy d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4077a = c.class.getName();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4078b = false;
        public WebSession.CacheStrategy c;
        public WebSession.CacheStrategy d;

        public a() {
            WebSession.CacheStrategy cacheStrategy = WebSession.CacheStrategy.DISABLE_CACHE;
            this.c = cacheStrategy;
            this.d = cacheStrategy;
        }

        public c a() {
            return new c(this.f4077a, this.f4078b, this.c, this.d);
        }

        public a b(WebSession.CacheStrategy cacheStrategy) {
            this.c = cacheStrategy;
            return this;
        }

        public a c(WebSession.CacheStrategy cacheStrategy) {
            this.d = cacheStrategy;
            return this;
        }

        public a d(boolean z) {
            this.f4078b = z;
            return this;
        }

        public a e(String str) {
            this.f4077a = str;
            return this;
        }
    }

    public c(String str, boolean z, WebSession.CacheStrategy cacheStrategy, WebSession.CacheStrategy cacheStrategy2) {
        this.f4075a = str;
        this.f4076b = z;
        this.c = cacheStrategy;
        this.d = cacheStrategy2;
    }
}
