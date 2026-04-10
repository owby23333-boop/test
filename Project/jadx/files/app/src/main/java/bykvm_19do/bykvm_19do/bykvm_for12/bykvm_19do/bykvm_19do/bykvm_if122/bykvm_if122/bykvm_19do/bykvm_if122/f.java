package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a;
    private final d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f972d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f974f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Proxy> f973e = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f975g = Collections.emptyList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<c0> f976h = new ArrayList();

    public static final class a {
        private final List<c0> a;
        private int b = 0;

        a(List<c0> list) {
            this.a = list;
        }

        public List<c0> a() {
            return new ArrayList(this.a);
        }

        public boolean b() {
            return this.b < this.a.size();
        }

        public c0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<c0> list = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return list.get(i2);
        }
    }

    public f(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, d dVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        this.a = aVar;
        this.b = dVar;
        this.f971c = eVar;
        this.f972d = pVar;
        a(aVar.k(), aVar.f());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(s sVar, Proxy proxy) throws IOException {
        if (proxy != null) {
            this.f973e = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.a.h().select(sVar.n());
                this.f973e = (listSelect == null || listSelect.isEmpty()) ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(Proxy.NO_PROXY) : bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(listSelect);
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.f974f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String strG;
        int iJ;
        this.f975g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strG = this.a.k().g();
            iJ = this.a.k().j();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strG = a(inetSocketAddress);
            iJ = inetSocketAddress.getPort();
        }
        if (iJ < 1 || iJ > 65535) {
            throw new SocketException("No route to " + strG + ":" + iJ + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f975g.add(InetSocketAddress.createUnresolved(strG, iJ));
            return;
        }
        this.f972d.a(this.f971c, strG);
        List<InetAddress> listA = this.a.c().a(strG);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.a.c() + " returned no addresses for " + strG);
        }
        this.f972d.a(this.f971c, strG, listA);
        int size = listA.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f975g.add(new InetSocketAddress(listA.get(i2), iJ));
        }
    }

    private boolean c() {
        return this.f974f < this.f973e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f973e;
            int i2 = this.f974f;
            this.f974f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.k().g() + "; exhausted proxy configurations: " + this.f973e);
    }

    public void a(c0 c0Var, IOException iOException) {
        if (c0Var.b().type() != Proxy.Type.DIRECT && this.a.h() != null) {
            this.a.h().connectFailed(this.a.k().n(), c0Var.b().address(), iOException);
        }
        this.b.b(c0Var);
    }

    public boolean a() {
        return c() || !this.f976h.isEmpty();
    }

    public a b() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy proxyD = d();
            int size = this.f975g.size();
            for (int i2 = 0; i2 < size; i2++) {
                c0 c0Var = new c0(this.a, proxyD, this.f975g.get(i2));
                if (this.b.c(c0Var)) {
                    this.f976h.add(c0Var);
                } else {
                    arrayList.add(c0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f976h);
            this.f976h.clear();
        }
        return new a(arrayList);
    }
}
