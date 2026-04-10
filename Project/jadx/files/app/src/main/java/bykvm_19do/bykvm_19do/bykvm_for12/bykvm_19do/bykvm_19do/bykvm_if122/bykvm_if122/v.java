package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class v implements Cloneable, e.a, e0 {
    static final List<w> A = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(w.HTTP_2, w.HTTP_1_1);
    static final List<k> B = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k.f1206f, k.f1207g);
    final n a;
    final Proxy b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<w> f1249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<k> f1250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<t> f1251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<t> f1252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final p.c f1253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final ProxySelector f1254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final m f1255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final c f1256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d f1257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final SocketFactory f1258l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final SSLSocketFactory f1259m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c f1260n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final HostnameVerifier f1261o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final g f1262p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1263q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1264r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final j f1265s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final o f1266t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final boolean f1267u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final boolean f1268v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final boolean f1269w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final int f1270x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final int f1271y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final int f1272z;

    static final class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public int a(a0.a aVar) {
            return aVar.f906c;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c a(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c0 c0Var) {
            return jVar.a(aVar, gVar, c0Var);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d a(j jVar) {
            return jVar.f1203e;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public Socket a(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar) {
            return jVar.a(aVar, gVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z2) {
            kVar.a(sSLSocket, z2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(r.a aVar, String str) {
            aVar.a(str);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(r.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public boolean a(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
            return jVar.a(cVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void b(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
            jVar.b(cVar);
        }
    }

    public static final class b {
        int A;
        Proxy b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        c f1280j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d f1281k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        SSLSocketFactory f1283m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c f1284n;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1287q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1288r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        j f1289s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        o f1290t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f1291u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f1292v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f1293w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f1294x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f1295y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f1296z;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<t> f1275e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<t> f1276f = new ArrayList();
        n a = new n();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<w> f1273c = v.A;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<k> f1274d = v.B;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        p.c f1277g = p.a(p.a);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ProxySelector f1278h = ProxySelector.getDefault();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        m f1279i = m.a;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        SocketFactory f1282l = SocketFactory.getDefault();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        HostnameVerifier f1285o = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        g f1286p = g.f1180c;

        public b() {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b bVar = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.a;
            this.f1287q = bVar;
            this.f1288r = bVar;
            this.f1289s = new j();
            this.f1290t = o.a;
            this.f1291u = true;
            this.f1292v = true;
            this.f1293w = true;
            this.f1294x = 10000;
            this.f1295y = 10000;
            this.f1296z = 10000;
            this.A = 0;
        }

        public b a(long j2, TimeUnit timeUnit) {
            this.f1294x = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j2, timeUnit);
            return this;
        }

        public b a(t tVar) {
            if (tVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f1275e.add(tVar);
            return this;
        }

        public v a() {
            return new v(this);
        }

        public b b(long j2, TimeUnit timeUnit) {
            this.f1295y = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j2, timeUnit);
            return this;
        }

        public b c(long j2, TimeUnit timeUnit) {
            this.f1296z = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j2, timeUnit);
            return this;
        }
    }

    static {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a = new a();
    }

    public v() {
        this(new b());
    }

    v(b bVar) {
        boolean z2;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVarA;
        this.a = bVar.a;
        this.b = bVar.b;
        this.f1249c = bVar.f1273c;
        this.f1250d = bVar.f1274d;
        this.f1251e = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bVar.f1275e);
        this.f1252f = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bVar.f1276f);
        this.f1253g = bVar.f1277g;
        this.f1254h = bVar.f1278h;
        this.f1255i = bVar.f1279i;
        this.f1256j = bVar.f1280j;
        this.f1257k = bVar.f1281k;
        this.f1258l = bVar.f1282l;
        Iterator<k> it = this.f1250d.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z2 = z2 || it.next().b();
            }
        }
        if (bVar.f1283m == null && z2) {
            X509TrustManager x509TrustManagerZ = z();
            this.f1259m = a(x509TrustManagerZ);
            cVarA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c.a(x509TrustManagerZ);
        } else {
            this.f1259m = bVar.f1283m;
            cVarA = bVar.f1284n;
        }
        this.f1260n = cVarA;
        this.f1261o = bVar.f1285o;
        this.f1262p = bVar.f1286p.a(this.f1260n);
        this.f1263q = bVar.f1287q;
        this.f1264r = bVar.f1288r;
        this.f1265s = bVar.f1289s;
        this.f1266t = bVar.f1290t;
        this.f1267u = bVar.f1291u;
        this.f1268v = bVar.f1292v;
        this.f1269w = bVar.f1293w;
        this.f1270x = bVar.f1294x;
        this.f1271y = bVar.f1295y;
        this.f1272z = bVar.f1296z;
        int i2 = bVar.A;
        if (this.f1251e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f1251e);
        }
        if (this.f1252f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f1252f);
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("No System TLS", (Exception) e2);
        }
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("No System TLS", (Exception) e2);
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b a() {
        return this.f1264r;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }

    public g b() {
        return this.f1262p;
    }

    public int c() {
        return this.f1270x;
    }

    public j d() {
        return this.f1265s;
    }

    public List<k> e() {
        return this.f1250d;
    }

    public m f() {
        return this.f1255i;
    }

    public n g() {
        return this.a;
    }

    public o h() {
        return this.f1266t;
    }

    public p.c j() {
        return this.f1253g;
    }

    public boolean k() {
        return this.f1268v;
    }

    public boolean l() {
        return this.f1267u;
    }

    public HostnameVerifier m() {
        return this.f1261o;
    }

    public List<t> n() {
        return this.f1251e;
    }

    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d o() {
        c cVar = this.f1256j;
        return cVar != null ? cVar.a : this.f1257k;
    }

    public List<t> p() {
        return this.f1252f;
    }

    public List<w> q() {
        return this.f1249c;
    }

    public Proxy r() {
        return this.b;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b s() {
        return this.f1263q;
    }

    public ProxySelector t() {
        return this.f1254h;
    }

    public int u() {
        return this.f1271y;
    }

    public boolean v() {
        return this.f1269w;
    }

    public SocketFactory w() {
        return this.f1258l;
    }

    public SSLSocketFactory x() {
        return this.f1259m;
    }

    public int y() {
        return this.f1272z;
    }
}
