package com.anythink.expressad.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.h;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class ad extends com.anythink.expressad.exoplayer.h.c {
    public static final int a = 3;
    private final com.anythink.expressad.exoplayer.j.k b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.a f9228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.m f9229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f9230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f9232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.ae f9233h;

    @Deprecated
    public interface a {
        void a();
    }

    private static final class b extends k {
        private final a a;
        private final int b;

        public b(a aVar, int i2) {
            this.a = (a) com.anythink.expressad.exoplayer.k.a.a(aVar);
            this.b = i2;
        }

        @Override // com.anythink.expressad.exoplayer.h.k, com.anythink.expressad.exoplayer.h.t
        public final void a(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z2) {
        }
    }

    /* synthetic */ ad(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j2, int i2, boolean z2, Object obj, byte b2) {
        this(uri, aVar, mVar, j2, i2, z2, obj);
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        a(this.f9233h, (Object) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void b() {
    }

    public static final class c {
        private final h.a a;
        private int b = 3;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9235d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Object f9236e;

        private c(h.a aVar) {
            this.a = (h.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        }

        private c a(Object obj) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9235d);
            this.f9236e = obj;
            return this;
        }

        private c a(int i2) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9235d);
            this.b = i2;
            return this;
        }

        private c a(boolean z2) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9235d);
            this.f9234c = z2;
            return this;
        }

        private ad a(Uri uri, com.anythink.expressad.exoplayer.m mVar, long j2) {
            this.f9235d = true;
            return new ad(uri, this.a, mVar, j2, this.b, this.f9234c, this.f9236e, (byte) 0);
        }

        @Deprecated
        private ad a(Uri uri, com.anythink.expressad.exoplayer.m mVar, long j2, @Nullable Handler handler, @Nullable t tVar) {
            this.f9235d = true;
            ad adVar = new ad(uri, this.a, mVar, j2, this.b, this.f9234c, this.f9236e, (byte) 0);
            if (handler != null && tVar != null) {
                adVar.a(handler, tVar);
            }
            return adVar;
        }
    }

    @Deprecated
    private ad(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j2) {
        this(uri, aVar, mVar, j2, (byte) 0);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        com.anythink.expressad.exoplayer.k.a.a(aVar.a == 0);
        return new ac(this.b, this.f9228c, this.f9229d, this.f9230e, this.f9231f, a(aVar), this.f9232g);
    }

    @Deprecated
    private ad(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j2, byte b2) {
        this(uri, aVar, mVar, j2, 3, false, null);
    }

    @Deprecated
    private ad(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j2, int i2, Handler handler, a aVar2, int i3, boolean z2) {
        this(uri, aVar, mVar, j2, i2, z2, null);
        if (handler == null || aVar2 == null) {
            return;
        }
        a(handler, new b(aVar2, i3));
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        ((ac) rVar).f();
    }

    private ad(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j2, int i2, boolean z2, @Nullable Object obj) {
        this.f9228c = aVar;
        this.f9229d = mVar;
        this.f9230e = j2;
        this.f9231f = i2;
        this.f9232g = z2;
        this.b = new com.anythink.expressad.exoplayer.j.k(uri);
        this.f9233h = new ab(j2, true, false, obj);
    }
}
