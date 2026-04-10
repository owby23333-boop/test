package com.bytedance.sdk.component.dl.g;

import android.os.Bundle;
import com.bytedance.sdk.component.dl.g.fv;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.ls;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class zw implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Proxy f692a;
    final v dl;
    final List<tb> e;
    final ls.z fo;
    final e fv;
    final List<io> gc;
    public Set<String> gk;
    final List<tb> gz;
    final int h;
    final int hh;
    final com.bytedance.sdk.component.dl.g.z.z.m i;
    final boolean io;
    final pf iq;
    final g js;
    final i kb;
    final int l;
    final com.bytedance.sdk.component.dl.g.z.fo.dl ls;
    final List<kb> m;
    final HostnameVerifier p;
    final SSLSocketFactory pf;
    final uy q;
    final int sy;
    final g tb;
    final boolean uf;
    final ProxySelector uy;
    final SocketFactory v;
    final dl wp;
    final boolean zw;
    static final List<io> z = com.bytedance.sdk.component.dl.g.z.dl.z(io.HTTP_2, io.HTTP_1_1);
    static final List<kb> g = com.bytedance.sdk.component.dl.g.z.dl.z(kb.z, kb.dl);

    static {
        com.bytedance.sdk.component.dl.g.z.z.z = new com.bytedance.sdk.component.dl.g.z.z() { // from class: com.bytedance.sdk.component.dl.g.zw.1
            @Override // com.bytedance.sdk.component.dl.g.z.z
            public void z(fv.z zVar, String str) {
                zVar.z(str);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public void z(fv.z zVar, String str, String str2) {
                zVar.g(str, str2);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public boolean z(uy uyVar, com.bytedance.sdk.component.dl.g.z.g.dl dlVar) {
                return uyVar.g(dlVar);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public com.bytedance.sdk.component.dl.g.z.g.dl z(uy uyVar, com.bytedance.sdk.component.dl.g.z zVar, com.bytedance.sdk.component.dl.g.z.g.e eVar, x xVar) {
                return uyVar.z(zVar, eVar, xVar);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public boolean z(com.bytedance.sdk.component.dl.g.z zVar, com.bytedance.sdk.component.dl.g.z zVar2) {
                return zVar.z(zVar2);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public Socket z(uy uyVar, com.bytedance.sdk.component.dl.g.z zVar, com.bytedance.sdk.component.dl.g.z.g.e eVar) {
                return uyVar.z(zVar, eVar);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public void g(uy uyVar, com.bytedance.sdk.component.dl.g.z.g.dl dlVar) {
                uyVar.z(dlVar);
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public com.bytedance.sdk.component.dl.g.z.g.a z(uy uyVar) {
                return uyVar.z;
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public int z(h.z zVar) {
                return zVar.dl;
            }

            @Override // com.bytedance.sdk.component.dl.g.z.z
            public void z(kb kbVar, SSLSocket sSLSocket, boolean z2) {
                kbVar.z(sSLSocket, z2);
            }
        };
    }

    public zw() {
        this(new z());
    }

    zw(z zVar) {
        boolean z2;
        this.dl = zVar.z;
        this.f692a = zVar.g;
        this.gc = zVar.dl;
        List<kb> list = zVar.f693a;
        this.m = list;
        this.e = com.bytedance.sdk.component.dl.g.z.dl.z(zVar.gc);
        this.gz = com.bytedance.sdk.component.dl.g.z.dl.z(zVar.m);
        this.fo = zVar.e;
        this.uy = zVar.gz;
        this.kb = zVar.fo;
        this.wp = zVar.uy;
        this.i = zVar.kb;
        this.v = zVar.wp;
        this.gk = zVar.h;
        Iterator<kb> it = list.iterator();
        loop0: while (true) {
            z2 = false;
            while (it.hasNext()) {
                z2 = (z2 || it.next().z()) ? true : z2;
            }
        }
        if (zVar.i != null || !z2) {
            this.pf = zVar.i;
            this.ls = zVar.v;
        } else {
            X509TrustManager x509TrustManagerUf = uf();
            this.pf = z(x509TrustManagerUf);
            this.ls = com.bytedance.sdk.component.dl.g.z.fo.dl.z(x509TrustManagerUf);
        }
        this.p = zVar.pf;
        this.fv = zVar.ls.z(this.ls);
        this.js = zVar.p;
        this.tb = zVar.fv;
        uy uyVar = zVar.js;
        this.q = uyVar;
        if (uyVar != null) {
            uyVar.z(zVar.l);
        }
        this.iq = zVar.tb;
        this.zw = zVar.q;
        this.io = zVar.iq;
        this.uf = zVar.zw;
        this.sy = zVar.io;
        this.hh = zVar.uf;
        this.l = zVar.sy;
        this.h = zVar.hh;
        if (this.e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.e);
        }
        if (this.gz.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.gz);
        }
    }

    private X509TrustManager uf() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory z(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("No System TLS", (Exception) e);
        }
    }

    public int z() {
        return this.sy;
    }

    public int g() {
        return this.hh;
    }

    public int dl() {
        return this.l;
    }

    public Proxy a() {
        return this.f692a;
    }

    public ProxySelector gc() {
        return this.uy;
    }

    public i m() {
        return this.kb;
    }

    com.bytedance.sdk.component.dl.g.z.z.m e() {
        dl dlVar = this.wp;
        return dlVar != null ? dlVar.z : this.i;
    }

    public pf gz() {
        return this.iq;
    }

    public SocketFactory fo() {
        return this.v;
    }

    public SSLSocketFactory uy() {
        return this.pf;
    }

    public HostnameVerifier kb() {
        return this.p;
    }

    public e wp() {
        return this.fv;
    }

    public g i() {
        return this.tb;
    }

    public g v() {
        return this.js;
    }

    public uy pf() {
        return this.q;
    }

    public boolean ls() {
        return this.zw;
    }

    public boolean p() {
        return this.io;
    }

    public boolean fv() {
        return this.uf;
    }

    public v js() {
        return this.dl;
    }

    public List<io> tb() {
        return this.gc;
    }

    public List<kb> q() {
        return this.m;
    }

    public List<tb> iq() {
        return this.e;
    }

    public List<tb> zw() {
        return this.gz;
    }

    public ls.z io() {
        return this.fo;
    }

    public gc z(sy syVar) {
        return uf.z(this, syVar, false);
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<kb> f693a;
        public List<io> dl;
        ls.z e;
        i fo;
        g fv;
        Proxy g;
        public final List<tb> gc;
        public TimeUnit gk;
        ProxySelector gz;
        public Set<String> h;
        int hh;
        SSLSocketFactory i;
        public int io;
        boolean iq;
        uy js;
        com.bytedance.sdk.component.dl.g.z.z.m kb;
        public Bundle l;
        public TimeUnit lq;
        e ls;
        final List<tb> m;
        g p;
        HostnameVerifier pf;
        boolean q;
        public int sy;
        pf tb;
        public int uf;
        dl uy;
        com.bytedance.sdk.component.dl.g.z.fo.dl v;
        SocketFactory wp;
        public TimeUnit x;
        v z;
        boolean zw;

        public z() {
            this("");
        }

        public z(String str) {
            this.gc = new ArrayList();
            this.m = new ArrayList();
            this.gk = TimeUnit.MILLISECONDS;
            this.x = TimeUnit.MILLISECONDS;
            this.lq = TimeUnit.MILLISECONDS;
            this.z = new v(str);
            this.dl = zw.z;
            this.f693a = zw.g;
            this.e = ls.z(ls.z);
            this.gz = ProxySelector.getDefault();
            this.fo = i.z;
            this.wp = SocketFactory.getDefault();
            this.pf = com.bytedance.sdk.component.dl.g.z.fo.gc.z;
            this.ls = e.z;
            this.p = g.z;
            this.fv = g.z;
            this.js = new uy();
            this.tb = pf.z;
            this.q = true;
            this.iq = true;
            this.zw = true;
            this.io = 10000;
            this.uf = 10000;
            this.sy = 10000;
            this.hh = 0;
        }

        public z z(tb tbVar) {
            if (tbVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.gc.add(tbVar);
            return this;
        }

        public z z(ls lsVar) {
            if (lsVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.e = ls.z(lsVar);
            return this;
        }

        public zw z() {
            return new zw(this);
        }
    }
}
