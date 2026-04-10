package com.anythink.expressad.exoplayer.a;

import android.net.NetworkInfo;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.g;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static final class a {
        public final long a;
        public final ae b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final s.a f8456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f8457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f8458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f8459g;

        public a(long j2, ae aeVar, int i2, @Nullable s.a aVar, long j3, long j4, long j5) {
            this.a = j2;
            this.b = aeVar;
            this.f8455c = i2;
            this.f8456d = aVar;
            this.f8457e = j3;
            this.f8458f = j4;
            this.f8459g = j5;
        }
    }

    void a();

    void a(a aVar);

    void a(a aVar, int i2);

    void a(a aVar, int i2, int i3);

    void a(a aVar, int i2, long j2, long j3);

    void a(a aVar, int i2, m mVar);

    void a(a aVar, int i2, String str);

    void a(a aVar, @Nullable NetworkInfo networkInfo);

    void a(a aVar, Surface surface);

    void a(a aVar, com.anythink.expressad.exoplayer.g.a aVar2);

    void a(a aVar, g gVar);

    void a(a aVar, t.c cVar);

    void a(a aVar, com.anythink.expressad.exoplayer.i.g gVar);

    void a(a aVar, v vVar);

    void a(a aVar, IOException iOException);

    void a(a aVar, Exception exc);

    void a(a aVar, boolean z2);

    void a(a aVar, boolean z2, int i2);

    void b();

    void b(a aVar);

    void b(a aVar, int i2);

    void b(a aVar, int i2, int i3);

    void b(a aVar, t.c cVar);

    void b(a aVar, boolean z2);

    void c();

    void c(a aVar);

    void c(a aVar, int i2);

    void d();

    void d(a aVar);

    void d(a aVar, int i2);

    void e(a aVar);

    void e(a aVar, int i2);

    void f(a aVar);

    void f(a aVar, int i2);

    void g(a aVar);

    void g(a aVar, int i2);

    void h(a aVar);
}
