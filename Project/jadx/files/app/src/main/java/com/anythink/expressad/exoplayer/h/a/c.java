package com.anythink.expressad.exoplayer.h.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.a.b;
import com.anythink.expressad.exoplayer.h.f;
import com.anythink.expressad.exoplayer.h.l;
import com.anythink.expressad.exoplayer.h.o;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.j.h;
import com.anythink.expressad.exoplayer.j.k;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f<s.a> {
    private static final String a = "AdsMediaSource";
    private final s b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f9175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.h.a.b f9176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f9177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final Handler f9178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final d f9179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f9180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<s, List<l>> f9181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ae.a f9182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private C0194c f9183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ae f9184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Object f9185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.h.a.a f9186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private s[][] f9187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long[][] f9188p;

    public static final class a extends IOException {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9190c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9191d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9192e;

        /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.h.a.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface InterfaceC0193a {
        }

        private a(int i2, Exception exc) {
            super(exc);
            this.f9192e = i2;
        }

        public static a a(Exception exc) {
            return new a(0, exc);
        }

        private static a b(Exception exc) {
            return new a(2, exc);
        }

        private static a a(Exception exc, int i2) {
            return new a(1, new IOException("Failed to load ad group ".concat(String.valueOf(i2)), exc));
        }

        private static a a(RuntimeException runtimeException) {
            return new a(3, runtimeException);
        }

        private RuntimeException a() {
            com.anythink.expressad.exoplayer.k.a.b(this.f9192e == 3);
            return (RuntimeException) getCause();
        }
    }

    private final class b implements l.a {
        private final Uri b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f9194d;

        public b(Uri uri, int i2, int i3) {
            this.b = uri;
            this.f9193c = i2;
            this.f9194d = i3;
        }

        @Override // com.anythink.expressad.exoplayer.h.l.a
        public final void a(s.a aVar, final IOException iOException) {
            c.this.a(aVar).a(new k(this.b), a.a(iOException));
            c.this.f9180h.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.expressad.exoplayer.h.a.b unused = c.this.f9176d;
                    int unused2 = b.this.f9193c;
                    int unused3 = b.this.f9194d;
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.h.a.c$c, reason: collision with other inner class name */
    private final class C0194c implements b.a {
        private final Handler b = new Handler();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f9195c;

        public C0194c() {
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void b() {
            if (this.f9195c || c.this.f9178f == null || c.this.f9179g == null) {
                return;
            }
            c.this.f9178f.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0194c.this.f9195c) {
                        return;
                    }
                    d unused = c.this.f9179g;
                }
            });
        }

        public final void c() {
            this.f9195c = true;
            this.b.removeCallbacksAndMessages(null);
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a(final com.anythink.expressad.exoplayer.h.a.a aVar) {
            if (this.f9195c) {
                return;
            }
            this.b.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0194c.this.f9195c) {
                        return;
                    }
                    c.a(c.this, aVar);
                }
            });
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a() {
            if (this.f9195c || c.this.f9178f == null || c.this.f9179g == null) {
                return;
            }
            c.this.f9178f.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0194c.this.f9195c) {
                        return;
                    }
                    d unused = c.this.f9179g;
                }
            });
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a(final a aVar, k kVar) {
            if (this.f9195c) {
                return;
            }
            c.this.a((s.a) null).a(kVar, aVar);
            if (c.this.f9178f == null || c.this.f9179g == null) {
                return;
            }
            c.this.f9178f.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0194c.this.f9195c) {
                        return;
                    }
                    if (aVar.f9192e != 3) {
                        d unused = c.this.f9179g;
                        return;
                    }
                    d unused2 = c.this.f9179g;
                    a aVar2 = aVar;
                    com.anythink.expressad.exoplayer.k.a.b(aVar2.f9192e == 3);
                    aVar2.getCause();
                }
            });
        }
    }

    @Deprecated
    public interface d {
        void a();

        void b();

        void c();

        void d();
    }

    public interface e {
        int[] a();

        s b(Uri uri);
    }

    private c(s sVar, h.a aVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup) {
        this(sVar, new o.c(aVar), bVar, viewGroup, (Handler) null, (d) null);
    }

    private c(s sVar, e eVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup) {
        this(sVar, eVar, bVar, viewGroup, (Handler) null, (d) null);
    }

    private void c() {
        com.anythink.expressad.exoplayer.h.a.a aVar = this.f9186n;
        if (aVar == null || this.f9184l == null) {
            return;
        }
        this.f9186n = aVar.a(this.f9188p);
        com.anythink.expressad.exoplayer.h.a.a aVar2 = this.f9186n;
        a(aVar2.f9168g == 0 ? this.f9184l : new com.anythink.expressad.exoplayer.h.a.d(this.f9184l, aVar2), this.f9185m);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    @Nullable
    protected final /* bridge */ /* synthetic */ s.a a(s.a aVar, s.a aVar2) {
        s.a aVar3 = aVar;
        return aVar3.a() ? aVar3 : aVar2;
    }

    @Deprecated
    private c(s sVar, h.a aVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup, @Nullable Handler handler, @Nullable d dVar) {
        this(sVar, new o.c(aVar), bVar, viewGroup, handler, dVar);
    }

    private void b(ae aeVar, Object obj) {
        this.f9184l = aeVar;
        this.f9185m = obj;
        c();
    }

    @Deprecated
    private c(s sVar, e eVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup, @Nullable Handler handler, @Nullable d dVar) {
        this.b = sVar;
        this.f9175c = eVar;
        this.f9176d = bVar;
        this.f9177e = viewGroup;
        this.f9178f = handler;
        this.f9179g = dVar;
        this.f9180h = new Handler(Looper.getMainLooper());
        this.f9181i = new HashMap();
        this.f9182j = new ae.a();
        this.f9187o = new s[0][];
        this.f9188p = new long[0][];
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(s.a aVar, s sVar, ae aeVar, @Nullable Object obj) {
        s.a aVar2 = aVar;
        if (aVar2.a()) {
            int i2 = aVar2.b;
            int i3 = aVar2.f9418c;
            com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
            this.f9188p[i2][i3] = aeVar.a(0, this.f9182j, false).f8470d;
            if (this.f9181i.containsKey(sVar)) {
                List<l> list = this.f9181i.get(sVar);
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).f();
                }
                this.f9181i.remove(sVar);
            }
            c();
            return;
        }
        this.f9184l = aeVar;
        this.f9185m = obj;
        c();
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(final com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        super.a(hVar, z2);
        com.anythink.expressad.exoplayer.k.a.a(z2);
        final C0194c c0194c = new C0194c();
        this.f9183k = c0194c;
        a(new s.a(0), this.b);
        this.f9180h.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.h.a.b unused = c.this.f9176d;
                ViewGroup unused2 = c.this.f9177e;
            }
        });
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        if (this.f9186n.f9168g > 0 && aVar.a()) {
            int i2 = aVar.b;
            int i3 = aVar.f9418c;
            Uri uri = this.f9186n.f9170i[i2].b[i3];
            if (this.f9187o[i2].length <= i3) {
                s sVarB = this.f9175c.b(uri);
                s[][] sVarArr = this.f9187o;
                int length = sVarArr[i2].length;
                if (i3 >= length) {
                    int i4 = i3 + 1;
                    sVarArr[i2] = (s[]) Arrays.copyOf(sVarArr[i2], i4);
                    long[][] jArr = this.f9188p;
                    jArr[i2] = Arrays.copyOf(jArr[i2], i4);
                    Arrays.fill(this.f9188p[i2], length, i4, com.anythink.expressad.exoplayer.b.b);
                }
                this.f9187o[i2][i3] = sVarB;
                this.f9181i.put(sVarB, new ArrayList());
                a(aVar, sVarB);
            }
            s sVar = this.f9187o[i2][i3];
            l lVar = new l(sVar, new s.a(0, aVar.f9419d), bVar);
            lVar.a(new b(uri, i2, i3));
            List<l> list = this.f9181i.get(sVar);
            if (list == null) {
                lVar.f();
            } else {
                list.add(lVar);
            }
            return lVar;
        }
        l lVar2 = new l(this.b, aVar, bVar);
        lVar2.f();
        return lVar2;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        l lVar = (l) rVar;
        List<l> list = this.f9181i.get(lVar.a);
        if (list != null) {
            list.remove(lVar);
        }
        lVar.g();
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.f9183k.c();
        this.f9183k = null;
        this.f9181i.clear();
        this.f9184l = null;
        this.f9185m = null;
        this.f9186n = null;
        this.f9187o = new s[0][];
        this.f9188p = new long[0][];
        this.f9180h.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.h.a.b unused = c.this.f9176d;
            }
        });
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(s.a aVar, s sVar, ae aeVar, @Nullable Object obj) {
        if (aVar.a()) {
            int i2 = aVar.b;
            int i3 = aVar.f9418c;
            com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
            this.f9188p[i2][i3] = aeVar.a(0, this.f9182j, false).f8470d;
            if (this.f9181i.containsKey(sVar)) {
                List<l> list = this.f9181i.get(sVar);
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).f();
                }
                this.f9181i.remove(sVar);
            }
            c();
            return;
        }
        this.f9184l = aeVar;
        this.f9185m = obj;
        c();
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static s.a a2(s.a aVar, s.a aVar2) {
        return aVar.a() ? aVar : aVar2;
    }

    private void a(com.anythink.expressad.exoplayer.h.a.a aVar) {
        if (this.f9186n == null) {
            this.f9187o = new s[aVar.f9168g][];
            Arrays.fill(this.f9187o, new s[0]);
            this.f9188p = new long[aVar.f9168g][];
            Arrays.fill(this.f9188p, new long[0]);
        }
        this.f9186n = aVar;
        c();
    }

    private void a(s sVar, int i2, int i3, ae aeVar) {
        com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
        this.f9188p[i2][i3] = aeVar.a(0, this.f9182j, false).f8470d;
        if (this.f9181i.containsKey(sVar)) {
            List<l> list = this.f9181i.get(sVar);
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).f();
            }
            this.f9181i.remove(sVar);
        }
        c();
    }

    static /* synthetic */ void a(c cVar, com.anythink.expressad.exoplayer.h.a.a aVar) {
        if (cVar.f9186n == null) {
            cVar.f9187o = new s[aVar.f9168g][];
            Arrays.fill(cVar.f9187o, new s[0]);
            cVar.f9188p = new long[aVar.f9168g][];
            Arrays.fill(cVar.f9188p, new long[0]);
        }
        cVar.f9186n = aVar;
        cVar.c();
    }
}
