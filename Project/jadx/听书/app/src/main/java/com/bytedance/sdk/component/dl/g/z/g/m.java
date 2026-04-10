package com.bytedance.sdk.component.dl.g.z.g;

import com.bytedance.sdk.component.dl.g.js;
import com.bytedance.sdk.component.dl.g.ls;
import com.bytedance.sdk.component.dl.g.x;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls f662a;
    private final com.bytedance.sdk.component.dl.g.gc dl;
    private final a g;
    private int m;
    private final com.bytedance.sdk.component.dl.g.z z;
    private List<Proxy> gc = Collections.emptyList();
    private List<InetSocketAddress> e = Collections.emptyList();
    private final List<x> gz = new ArrayList();

    public m(com.bytedance.sdk.component.dl.g.z zVar, a aVar, com.bytedance.sdk.component.dl.g.gc gcVar, ls lsVar) throws IOException {
        this.z = zVar;
        this.g = aVar;
        this.dl = gcVar;
        this.f662a = lsVar;
        z(zVar.z(), zVar.gz());
    }

    public boolean z() {
        return dl() || !this.gz.isEmpty();
    }

    public z g() throws IOException {
        if (!z()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (dl()) {
            Proxy proxyA = a();
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                x xVar = new x(this.z, proxyA, this.e.get(i));
                if (this.g.dl(xVar)) {
                    this.gz.add(xVar);
                } else {
                    arrayList.add(xVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.gz);
            this.gz.clear();
        }
        return new z(arrayList);
    }

    public void z(x xVar, IOException iOException) {
        if (xVar.g().type() != Proxy.Type.DIRECT && this.z.e() != null) {
            this.z.e().connectFailed(this.z.z().g(), xVar.g().address(), iOException);
        }
        this.g.z(xVar);
    }

    private void z(js jsVar, Proxy proxy) throws IOException {
        List<Proxy> listZ;
        if (proxy != null) {
            this.gc = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.z.e().select(jsVar.g());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listZ = com.bytedance.sdk.component.dl.g.z.dl.z(listSelect);
                } else {
                    listZ = com.bytedance.sdk.component.dl.g.z.dl.z(Proxy.NO_PROXY);
                }
                this.gc = listZ;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.m = 0;
    }

    private boolean dl() {
        return this.m < this.gc.size();
    }

    private Proxy a() throws IOException {
        if (!dl()) {
            throw new SocketException("No route to " + this.z.z().e() + "; exhausted proxy configurations: " + this.gc);
        }
        List<Proxy> list = this.gc;
        int i = this.m;
        this.m = i + 1;
        Proxy proxy = list.get(i);
        z(proxy);
        return proxy;
    }

    private void z(Proxy proxy) throws IOException {
        String strE;
        int iGz;
        this.e = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strE = this.z.z().e();
            iGz = this.z.z().gz();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strE = z(inetSocketAddress);
            iGz = inetSocketAddress.getPort();
        }
        if (iGz <= 0 || iGz > 65535) {
            throw new SocketException("No route to " + strE + ":" + iGz + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.e.add(InetSocketAddress.createUnresolved(strE, iGz));
            return;
        }
        List<InetAddress> listZ = this.z.g().z(strE);
        if (listZ.isEmpty()) {
            return;
        }
        int size = listZ.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new InetSocketAddress(listZ.get(i), iGz));
        }
    }

    static String z(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class z {
        private int g = 0;
        private final List<x> z;

        z(List<x> list) {
            this.z = list;
        }

        public boolean z() {
            return this.g < this.z.size();
        }

        public x g() {
            if (!z()) {
                throw new NoSuchElementException();
            }
            List<x> list = this.z;
            int i = this.g;
            this.g = i + 1;
            return list.get(i);
        }

        public List<x> dl() {
            return new ArrayList(this.z);
        }
    }
}
