package com.bumptech.glide.load.engine.y;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.k;
import com.bumptech.glide.util.l;
import com.bumptech.glide.util.m.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private final com.bumptech.glide.util.h<com.bumptech.glide.load.c, String> a = new com.bumptech.glide.util.h<>(1000);
    private final Pools.Pool<b> b = com.bumptech.glide.util.m.a.a(10, new a(this));

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    class a implements a.d<b> {
        a(j jVar) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.m.a.d
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    private static final class b implements a.f {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final MessageDigest f13647s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final com.bumptech.glide.util.m.c f13648t = com.bumptech.glide.util.m.c.b();

        b(MessageDigest messageDigest) {
            this.f13647s = messageDigest;
        }

        @Override // com.bumptech.glide.util.m.a.f
        @NonNull
        public com.bumptech.glide.util.m.c b() {
            return this.f13648t;
        }
    }

    private String b(com.bumptech.glide.load.c cVar) {
        b bVarAcquire = this.b.acquire();
        k.a(bVarAcquire);
        b bVar = bVarAcquire;
        try {
            cVar.updateDiskCacheKey(bVar.f13647s);
            return l.a(bVar.f13647s.digest());
        } finally {
            this.b.release(bVar);
        }
    }

    public String a(com.bumptech.glide.load.c cVar) {
        String strA;
        synchronized (this.a) {
            strA = this.a.a(cVar);
        }
        if (strA == null) {
            strA = b(cVar);
        }
        synchronized (this.a) {
            this.a.b(cVar, strA);
        }
        return strA;
    }
}
