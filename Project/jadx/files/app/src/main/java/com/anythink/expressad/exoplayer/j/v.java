package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import com.anythink.expressad.exoplayer.j.t;
import com.anythink.expressad.exoplayer.k.af;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class v<T> implements t.c {
    public final k a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f9765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a<? extends T> f9766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile T f9767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f9768f;

    public interface a<T> {
        T a();
    }

    private v(h hVar, Uri uri, a<? extends T> aVar) {
        this(hVar, new k(uri, 3), aVar);
    }

    private static <T> T a(h hVar, a<? extends T> aVar, Uri uri) {
        v vVar = new v(hVar, uri, aVar);
        vVar.b();
        return vVar.f9767e;
    }

    private T c() {
        return this.f9767e;
    }

    private long d() {
        return this.f9768f;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        j jVar = new j(this.f9765c, this.a);
        try {
            jVar.b();
            a<? extends T> aVar = this.f9766d;
            this.f9765c.a();
            this.f9767e = aVar.a();
        } finally {
            this.f9768f = jVar.a();
            af.a((Closeable) jVar);
        }
    }

    private v(h hVar, k kVar, a<? extends T> aVar) {
        this.f9765c = hVar;
        this.a = kVar;
        this.b = 0;
        this.f9766d = aVar;
    }
}
