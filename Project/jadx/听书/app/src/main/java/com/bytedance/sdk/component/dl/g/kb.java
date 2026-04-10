package com.bytedance.sdk.component.dl.g;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class kb {
    public static final kb dl;
    public static final kb g;
    private static final gz[] gz;
    public static final kb z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f637a;
    final String[] e;
    final boolean gc;
    final String[] m;

    static {
        gz[] gzVarArr = {gz.kb, gz.i, gz.wp, gz.v, gz.ls, gz.pf, gz.e, gz.fo, gz.gz, gz.uy, gz.gc, gz.m, gz.dl, gz.f628a, gz.g};
        gz = gzVarArr;
        kb kbVarZ = new z(true).z(gzVarArr).z(lq.TLS_1_3, lq.TLS_1_2, lq.TLS_1_1, lq.TLS_1_0).z(true).z();
        z = kbVarZ;
        g = new z(kbVarZ).z(lq.TLS_1_0).z(true).z();
        dl = new z(false).z();
    }

    kb(z zVar) {
        this.f637a = zVar.z;
        this.m = zVar.g;
        this.e = zVar.dl;
        this.gc = zVar.f638a;
    }

    public boolean z() {
        return this.f637a;
    }

    public List<gz> g() {
        String[] strArr = this.m;
        if (strArr != null) {
            return gz.z(strArr);
        }
        return null;
    }

    public List<lq> dl() {
        String[] strArr = this.e;
        if (strArr != null) {
            return lq.z(strArr);
        }
        return null;
    }

    public boolean a() {
        return this.gc;
    }

    void z(SSLSocket sSLSocket, boolean z2) {
        kb kbVarG = g(sSLSocket, z2);
        String[] strArr = kbVarG.e;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = kbVarG.m;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private kb g(SSLSocket sSLSocket, boolean z2) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.m != null) {
            enabledCipherSuites = com.bytedance.sdk.component.dl.g.z.dl.z(gz.z, sSLSocket.getEnabledCipherSuites(), this.m);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.e != null) {
            enabledProtocols = com.bytedance.sdk.component.dl.g.z.dl.z(com.bytedance.sdk.component.dl.g.z.dl.gz, sSLSocket.getEnabledProtocols(), this.e);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iZ = com.bytedance.sdk.component.dl.g.z.dl.z(gz.z, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z2 && iZ != -1) {
            enabledCipherSuites = com.bytedance.sdk.component.dl.g.z.dl.z(enabledCipherSuites, supportedCipherSuites[iZ]);
        }
        return new z(this).z(enabledCipherSuites).g(enabledProtocols).z();
    }

    public boolean z(SSLSocket sSLSocket) {
        if (!this.f637a) {
            return false;
        }
        if (this.e == null || com.bytedance.sdk.component.dl.g.z.dl.g(com.bytedance.sdk.component.dl.g.z.dl.gz, this.e, sSLSocket.getEnabledProtocols())) {
            return this.m == null || com.bytedance.sdk.component.dl.g.z.dl.g(gz.z, this.m, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kb)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        kb kbVar = (kb) obj;
        boolean z2 = this.f637a;
        if (z2 != kbVar.f637a) {
            return false;
        }
        return !z2 || (Arrays.equals(this.m, kbVar.m) && Arrays.equals(this.e, kbVar.e) && this.gc == kbVar.gc);
    }

    public int hashCode() {
        if (this.f637a) {
            return ((((Arrays.hashCode(this.m) + 527) * 31) + Arrays.hashCode(this.e)) * 31) + (!this.gc ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f637a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.m != null ? g().toString() : "[all enabled]") + ", tlsVersions=" + (this.e != null ? dl().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.gc + ")";
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f638a;
        String[] dl;
        String[] g;
        boolean z;

        z(boolean z) {
            this.z = z;
        }

        public z(kb kbVar) {
            this.z = kbVar.f637a;
            this.g = kbVar.m;
            this.dl = kbVar.e;
            this.f638a = kbVar.gc;
        }

        public z z(gz... gzVarArr) {
            if (!this.z) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[gzVarArr.length];
            for (int i = 0; i < gzVarArr.length; i++) {
                strArr[i] = gzVarArr[i].p;
            }
            return z(strArr);
        }

        public z z(String... strArr) {
            if (!this.z) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.g = (String[]) strArr.clone();
            return this;
        }

        public z z(lq... lqVarArr) {
            if (!this.z) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[lqVarArr.length];
            for (int i = 0; i < lqVarArr.length; i++) {
                strArr[i] = lqVarArr[i].m;
            }
            return g(strArr);
        }

        public z g(String... strArr) {
            if (!this.z) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.dl = (String[]) strArr.clone();
            return this;
        }

        public z z(boolean z) {
            if (!this.z) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f638a = z;
            return this;
        }

        public kb z() {
            return new kb(this);
        }
    }
}
