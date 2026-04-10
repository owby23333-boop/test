package com.anythink.expressad.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.a.c;
import com.anythink.expressad.exoplayer.h.n;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.h;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends com.anythink.expressad.exoplayer.h.c implements n.c {
    public static final int a = 3;
    public static final int b = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9398c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9399d = 1048576;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Uri f9400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h.a f9401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.e.h f9402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f9405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final Object f9406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f9407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9408m;

    @Deprecated
    public interface a {
        void a();
    }

    private static final class b extends k {
        private final a a;

        public b(a aVar) {
            this.a = (a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        }

        @Override // com.anythink.expressad.exoplayer.h.k, com.anythink.expressad.exoplayer.h.t
        public final void a(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z2) {
        }
    }

    public static final class c implements c.e {
        private final h.a a;

        @Nullable
        private com.anythink.expressad.exoplayer.e.h b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f9409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Object f9410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9411e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9412f = 1048576;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f9413g;

        public c(h.a aVar) {
            this.a = aVar;
        }

        private c a(com.anythink.expressad.exoplayer.e.h hVar) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9413g);
            this.b = hVar;
            return this;
        }

        @Override // com.anythink.expressad.exoplayer.h.a.c.e
        public final int[] a() {
            return new int[]{3};
        }

        private c b(int i2) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9413g);
            this.f9412f = i2;
            return this;
        }

        private c a(String str) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9413g);
            this.f9409c = str;
            return this;
        }

        private c a(Object obj) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9413g);
            this.f9410d = obj;
            return this;
        }

        private c a(int i2) {
            com.anythink.expressad.exoplayer.k.a.b(!this.f9413g);
            this.f9411e = i2;
            return this;
        }

        @Override // com.anythink.expressad.exoplayer.h.a.c.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o b(Uri uri) {
            this.f9413g = true;
            if (this.b == null) {
                this.b = new com.anythink.expressad.exoplayer.e.c();
            }
            return new o(uri, this.a, this.b, this.f9411e, this.f9409c, this.f9412f, this.f9410d, (byte) 0);
        }

        @Deprecated
        private o a(Uri uri, @Nullable Handler handler, @Nullable t tVar) {
            o oVarB = b(uri);
            if (handler != null && tVar != null) {
                oVarB.a(handler, tVar);
            }
            return oVarB;
        }
    }

    /* synthetic */ o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, int i2, String str, int i3, Object obj, byte b2) {
        this(uri, aVar, hVar, i2, str, i3, obj);
    }

    private void b(long j2, boolean z2) {
        this.f9407l = j2;
        this.f9408m = z2;
        a(new ab(this.f9407l, this.f9408m, false, this.f9406k), (Object) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        b(this.f9407l, false);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void b() {
    }

    @Deprecated
    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        com.anythink.expressad.exoplayer.k.a.a(aVar.a == 0);
        return new n(this.f9400e, this.f9401f.a(), this.f9402g.a(), this.f9403h, a(aVar), this, bVar, this.f9404i, this.f9405j);
    }

    @Deprecated
    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, handler, aVar2, str, (byte) 0);
    }

    @Deprecated
    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, Handler handler, a aVar2, String str, byte b2) {
        this(uri, aVar, hVar, -1, str, 1048576, (Object) null);
        if (aVar2 == null || handler == null) {
            return;
        }
        a(handler, new b(aVar2));
    }

    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, int i2, @Nullable String str, int i3, @Nullable Object obj) {
        this.f9400e = uri;
        this.f9401f = aVar;
        this.f9402g = hVar;
        this.f9403h = i2;
        this.f9404i = str;
        this.f9405j = i3;
        this.f9407l = com.anythink.expressad.exoplayer.b.b;
        this.f9406k = obj;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        ((n) rVar).f();
    }

    @Override // com.anythink.expressad.exoplayer.h.n.c
    public final void a(long j2, boolean z2) {
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            j2 = this.f9407l;
        }
        if (this.f9407l == j2 && this.f9408m == z2) {
            return;
        }
        b(j2, z2);
    }
}
