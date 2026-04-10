package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {
    final boolean a;
    final i b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f1050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f1053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ExecutorService f1054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<Integer, l> f1055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final m f1056j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f1058l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final Socket f1062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j f1063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final j f1064r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final /* synthetic */ boolean f1048u = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final ExecutorService f1047t = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<Integer, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> f1049c = new LinkedHashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f1057k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    n f1059m = new n();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final n f1060n = new n();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f1061o = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final Set<Integer> f1065s = new LinkedHashSet();

    class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f1066c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            super(str, objArr);
            this.b = i2;
            this.f1066c = bVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.b(this.b, this.f1066c);
            } catch (IOException unused) {
            }
        }
    }

    class b extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f1068c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i2, long j2) {
            super(str, objArr);
            this.b = i2;
            this.f1068c = j2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.f1063q.a(this.b, this.f1068c);
            } catch (IOException unused) {
            }
        }
    }

    class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f1072e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, boolean z2, int i2, int i3, l lVar) {
            super(str, objArr);
            this.b = z2;
            this.f1070c = i2;
            this.f1071d = i3;
            this.f1072e = lVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.a(this.b, this.f1070c, this.f1071d, this.f1072e);
            } catch (IOException unused) {
            }
        }
    }

    class d extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f1074c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.b = i2;
            this.f1074c = list;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            if (g.this.f1056j.a(this.b, this.f1074c)) {
                try {
                    g.this.f1063q.a(this.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                    synchronized (g.this) {
                        g.this.f1065s.remove(Integer.valueOf(this.b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class e extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f1076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f1077d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i2, List list, boolean z2) {
            super(str, objArr);
            this.b = i2;
            this.f1076c = list;
            this.f1077d = z2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            boolean zA = g.this.f1056j.a(this.b, this.f1076c, this.f1077d);
            if (zA) {
                try {
                    g.this.f1063q.a(this.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zA || this.f1077d) {
                synchronized (g.this) {
                    g.this.f1065s.remove(Integer.valueOf(this.b));
                }
            }
        }
    }

    class f extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f1081e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i3, boolean z2) {
            super(str, objArr);
            this.b = i2;
            this.f1079c = cVar;
            this.f1080d = i3;
            this.f1081e = z2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                boolean zA = g.this.f1056j.a(this.b, this.f1079c, this.f1080d, this.f1081e);
                if (zA) {
                    g.this.f1063q.a(this.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                }
                if (zA || this.f1081e) {
                    synchronized (g.this) {
                        g.this.f1065s.remove(Integer.valueOf(this.b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$g, reason: collision with other inner class name */
    class C0029g extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f1083c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0029g(String str, Object[] objArr, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            super(str, objArr);
            this.b = i2;
            this.f1083c = bVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            g.this.f1056j.a(this.b, this.f1083c);
            synchronized (g.this) {
                g.this.f1065s.remove(Integer.valueOf(this.b));
            }
        }
    }

    public static class h {
        Socket a;
        String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f1085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f1086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        i f1087e = i.a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        m f1088f = m.a;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f1089g;

        public h(boolean z2) {
            this.f1089g = z2;
        }

        public h a(i iVar) {
            this.f1087e = iVar;
            return this;
        }

        public h a(Socket socket, String str, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
            this.a = socket;
            this.b = str;
            this.f1085c = eVar;
            this.f1086d = dVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public static abstract class i {
        public static final i a = new a();

        static final class a extends i {
            a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
            public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException {
                iVar.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException;
    }

    class j extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b implements h.b {
        final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h b;

        class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) {
                super(str, objArr);
                this.b = iVar;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                try {
                    g.this.b.a(this.b);
                } catch (IOException e2) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(4, "Http2Connection.Listener failure for " + g.this.f1050d, e2);
                    try {
                        this.b.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                g gVar = g.this;
                gVar.b.a(gVar);
            }
        }

        class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            final /* synthetic */ n b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, n nVar) {
                super(str, objArr);
                this.b = nVar;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                try {
                    g.this.f1063q.a(this.b);
                } catch (IOException unused) {
                }
            }
        }

        j(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h hVar) {
            super("OkHttp %s", g.this.f1050d);
            this.b = hVar;
        }

        private void a(n nVar) {
            g.f1047t.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f1050d}, nVar));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, int i3, int i4, boolean z2) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, int i3, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
            g.this.a(i3, list);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, long j2) {
            g gVar = g.this;
            if (i2 == 0) {
                synchronized (gVar) {
                    g.this.f1058l += j2;
                    g.this.notifyAll();
                }
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVarA = gVar.a(i2);
            if (iVarA != null) {
                synchronized (iVarA) {
                    iVarA.a(j2);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            if (g.this.b(i2)) {
                g.this.a(i2, bVar);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVarD = g.this.d(i2);
            if (iVarD != null) {
                iVarD.c(bVar);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
            fVar.e();
            synchronized (g.this) {
                iVarArr = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) g.this.f1049c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[g.this.f1049c.size()]);
                g.this.f1053g = true;
            }
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                if (iVar.c() > i2 && iVar.f()) {
                    iVar.c(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
                    g.this.d(iVar.c());
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z2, int i2, int i3) {
            if (!z2) {
                g.this.b(true, i2, i3, null);
                return;
            }
            l lVarC = g.this.c(i2);
            if (lVarC != null) {
                lVarC.b();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z2, int i2, int i3, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
            if (g.this.b(i2)) {
                g.this.a(i2, list, z2);
                return;
            }
            synchronized (g.this) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVarA = g.this.a(i2);
                if (iVarA != null) {
                    iVarA.a(list);
                    if (z2) {
                        iVarA.i();
                        return;
                    }
                    return;
                }
                if (!g.this.f1053g && i2 > g.this.f1051e && i2 % 2 != g.this.f1052f % 2) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i(i2, g.this, false, z2, list);
                    g.this.f1051e = i2;
                    g.this.f1049c.put(Integer.valueOf(i2), iVar);
                    g.f1047t.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f1050d, Integer.valueOf(i2)}, iVar));
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z2, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i3) throws IOException {
            if (g.this.b(i2)) {
                g.this.a(i2, eVar, i3, z2);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVarA = g.this.a(i2);
            if (iVarA == null) {
                g.this.c(i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                eVar.skip(i3);
            } else {
                iVarA.a(eVar, i3);
                if (z2) {
                    iVarA.i();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z2, n nVar) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
            long j2;
            int i2;
            synchronized (g.this) {
                int iC = g.this.f1060n.c();
                if (z2) {
                    g.this.f1060n.a();
                }
                g.this.f1060n.a(nVar);
                a(nVar);
                int iC2 = g.this.f1060n.c();
                iVarArr = null;
                if (iC2 == -1 || iC2 == iC) {
                    j2 = 0;
                } else {
                    j2 = iC2 - iC;
                    if (!g.this.f1061o) {
                        g.this.f(j2);
                        g.this.f1061o = true;
                    }
                    if (!g.this.f1049c.isEmpty()) {
                        iVarArr = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) g.this.f1049c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[g.this.f1049c.size()]);
                    }
                }
                g.f1047t.execute(new b("OkHttp %s settings", g.this.f1050d));
            }
            if (iVarArr == null || j2 == 0) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j2);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        protected void b() throws Throwable {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.INTERNAL_ERROR;
            try {
                try {
                    this.b.a(this);
                    while (this.b.a(false, (h.b) this)) {
                    }
                    bVar2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.NO_ERROR;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar3;
                    try {
                        g.this.a(bVar, bVar3);
                    } catch (IOException unused2) {
                    }
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
                    throw th;
                }
                try {
                    bVar3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL;
                } catch (IOException unused3) {
                    bVar2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR;
                    bVar3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR;
                }
                try {
                    g.this.a(bVar2, bVar3);
                } catch (IOException unused4) {
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
            } catch (Throwable th2) {
                bVar = bVar2;
                th = th2;
                g.this.a(bVar, bVar3);
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
                throw th;
            }
        }
    }

    g(h hVar) {
        this.f1056j = hVar.f1088f;
        boolean z2 = hVar.f1089g;
        this.a = z2;
        this.b = hVar.f1087e;
        this.f1052f = z2 ? 1 : 2;
        if (hVar.f1089g) {
            this.f1052f += 2;
        }
        if (hVar.f1089g) {
            this.f1059m.a(7, 16777216);
        }
        this.f1050d = hVar.b;
        this.f1054h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp %s Push Observer", this.f1050d), true));
        this.f1060n.a(7, 65535);
        this.f1060n.a(5, 16384);
        this.f1058l = this.f1060n.c();
        this.f1062p = hVar.a;
        this.f1063q = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j(hVar.f1086d, this.a);
        this.f1064r = new j(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h(hVar.f1085c, this.a));
    }

    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i b(int i2, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z2) throws IOException {
        int i3;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar;
        boolean z3;
        boolean z4 = !z2;
        synchronized (this.f1063q) {
            synchronized (this) {
                if (this.f1053g) {
                    throw new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a();
                }
                i3 = this.f1052f;
                this.f1052f += 2;
                iVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i(i3, this, z4, false, list);
                z3 = !z2 || this.f1058l == 0 || iVar.b == 0;
                if (iVar.g()) {
                    this.f1049c.put(Integer.valueOf(i3), iVar);
                }
            }
            if (i2 == 0) {
                this.f1063q.a(z4, i3, i2, list);
            } else {
                if (this.a) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.f1063q.a(i2, i3, list);
            }
        }
        if (z3) {
            this.f1063q.flush();
        }
        return iVar;
    }

    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a(int i2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar;
        synchronized (this) {
            iVar = this.f1049c.get(Integer.valueOf(i2));
        }
        return iVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a(List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z2) throws IOException {
        return b(0, list, z2);
    }

    void a(int i2, long j2) {
        f1047t.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f1050d, Integer.valueOf(i2)}, i2, j2));
    }

    void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i3, boolean z2) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.o() == j2) {
            this.f1054h.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f1050d, Integer.valueOf(i2)}, i2, cVar, i3, z2));
            return;
        }
        throw new IOException(cVar.o() + " != " + i3);
    }

    void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        this.f1054h.execute(new C0029g("OkHttp %s Push Reset[%s]", new Object[]{this.f1050d, Integer.valueOf(i2)}, i2, bVar));
    }

    void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        synchronized (this) {
            if (this.f1065s.contains(Integer.valueOf(i2))) {
                c(i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
            } else {
                this.f1065s.add(Integer.valueOf(i2));
                this.f1054h.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f1050d, Integer.valueOf(i2)}, i2, list));
            }
        }
    }

    void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z2) {
        this.f1054h.execute(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f1050d, Integer.valueOf(i2)}, i2, list, z2));
    }

    public void a(int i2, boolean z2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
        int iMin;
        long j3;
        if (j2 == 0) {
            this.f1063q.a(z2, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (this.f1058l <= 0) {
                    try {
                        if (!this.f1049c.containsKey(Integer.valueOf(i2))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j2, this.f1058l), this.f1063q.j());
                j3 = iMin;
                this.f1058l -= j3;
            }
            j2 -= j3;
            this.f1063q.a(z2 && j2 == 0, i2, cVar, iMin);
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        synchronized (this.f1063q) {
            synchronized (this) {
                if (!this.f1053g) {
                    this.f1053g = true;
                    this.f1063q.a(this.f1051e, bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a);
                }
            }
        }
    }

    void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
        if (!f1048u && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        l[] lVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f1049c.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) this.f1049c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[this.f1049c.size()]);
                this.f1049c.clear();
            }
            if (this.f1055i != null) {
                l[] lVarArr2 = (l[]) this.f1055i.values().toArray(new l[this.f1055i.size()]);
                this.f1055i = null;
                lVarArr = lVarArr2;
            }
        }
        if (iVarArr != null) {
            IOException iOException = e;
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (iOException != null) {
                        iOException = e3;
                    }
                }
            }
            e = iOException;
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.a();
            }
        }
        try {
            this.f1063q.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.f1062p.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z2) throws IOException {
        if (z2) {
            this.f1063q.i();
            this.f1063q.b(this.f1059m);
            if (this.f1059m.c() != 65535) {
                this.f1063q.a(0, r6 - 65535);
            }
        }
        Thread thread = new Thread(this.f1064r);
        thread.setName("gm_t_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    void a(boolean z2, int i2, int i3, l lVar) throws IOException {
        synchronized (this.f1063q) {
            if (lVar != null) {
                lVar.c();
                this.f1063q.a(z2, i2, i3);
            } else {
                this.f1063q.a(z2, i2, i3);
            }
        }
    }

    void b(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        this.f1063q.a(i2, bVar);
    }

    void b(boolean z2, int i2, int i3, l lVar) {
        f1047t.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f1050d, Integer.valueOf(i2), Integer.valueOf(i3)}, z2, i2, i3, lVar));
    }

    boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    l c(int i2) {
        l lVarRemove;
        synchronized (this) {
            Map<Integer, l> map = this.f1055i;
            lVarRemove = map != null ? map.remove(Integer.valueOf(i2)) : null;
        }
        return lVarRemove;
    }

    void c(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        f1047t.execute(new a("OkHttp %s stream %d", new Object[]{this.f1050d, Integer.valueOf(i2)}, i2, bVar));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.NO_ERROR, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
    }

    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i d(int i2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVarRemove;
        synchronized (this) {
            iVarRemove = this.f1049c.remove(Integer.valueOf(i2));
            notifyAll();
        }
        return iVarRemove;
    }

    void f(long j2) {
        this.f1058l += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public void flush() throws IOException {
        this.f1063q.flush();
    }

    public boolean i() {
        boolean z2;
        synchronized (this) {
            z2 = this.f1053g;
        }
        return z2;
    }

    public int j() {
        int iB;
        synchronized (this) {
            iB = this.f1060n.b(Integer.MAX_VALUE);
        }
        return iB;
    }

    public void k() throws IOException {
        a(true);
    }
}
