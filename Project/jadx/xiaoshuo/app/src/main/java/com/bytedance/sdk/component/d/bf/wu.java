package com.bytedance.sdk.component.d.bf;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class wu {
    public static final wu bf;
    public static final wu d;
    public static final wu e;
    private static final v[] v;
    final boolean ga;
    final String[] p;
    final boolean tg;
    final String[] vn;

    static {
        v[] vVarArr = {v.xo, v.o, v.eb, v.ju, v.ne, v.bp, v.jk, v.fa, v.rw, v.vd, v.g, v.tx, v.x, v.f2091b, v.zk};
        v = vVarArr;
        e eVarE = new e(true).e(vVarArr);
        x xVar = x.TLS_1_0;
        wu wuVarE = eVarE.e(x.TLS_1_3, x.TLS_1_2, x.TLS_1_1, xVar).e(true).e();
        e = wuVarE;
        bf = new e(wuVarE).e(xVar).e(true).e();
        d = new e(false).e();
    }

    public wu(e eVar) {
        this.tg = eVar.e;
        this.vn = eVar.bf;
        this.p = eVar.d;
        this.ga = eVar.tg;
    }

    public List<v> bf() {
        String[] strArr = this.vn;
        if (strArr != null) {
            return v.e(strArr);
        }
        return null;
    }

    public List<x> d() {
        String[] strArr = this.p;
        if (strArr != null) {
            return x.e(strArr);
        }
        return null;
    }

    public boolean e() {
        return this.tg;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wu)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        wu wuVar = (wu) obj;
        boolean z = this.tg;
        if (z != wuVar.tg) {
            return false;
        }
        return !z || (Arrays.equals(this.vn, wuVar.vn) && Arrays.equals(this.p, wuVar.p) && this.ga == wuVar.ga);
    }

    public int hashCode() {
        if (this.tg) {
            return ((((527 + Arrays.hashCode(this.vn)) * 31) + Arrays.hashCode(this.p)) * 31) + (!this.ga ? 1 : 0);
        }
        return 17;
    }

    public boolean tg() {
        return this.ga;
    }

    public String toString() {
        if (!this.tg) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.vn != null ? bf().toString() : "[all enabled]") + ", tlsVersions=" + (this.p != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.ga + ")";
    }

    public static final class e {
        String[] bf;
        String[] d;
        boolean e;
        boolean tg;

        public e(boolean z) {
            this.e = z;
        }

        public e bf(String... strArr) {
            if (!this.e) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.d = (String[]) strArr.clone();
            return this;
        }

        public e e(v... vVarArr) {
            if (!this.e) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[vVarArr.length];
            for (int i = 0; i < vVarArr.length; i++) {
                strArr[i] = vVarArr[i].u;
            }
            return e(strArr);
        }

        public e(wu wuVar) {
            this.e = wuVar.tg;
            this.bf = wuVar.vn;
            this.d = wuVar.p;
            this.tg = wuVar.ga;
        }

        public e e(String... strArr) {
            if (this.e) {
                if (strArr.length != 0) {
                    this.bf = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public e e(x... xVarArr) {
            if (this.e) {
                String[] strArr = new String[xVarArr.length];
                for (int i = 0; i < xVarArr.length; i++) {
                    strArr[i] = xVarArr[i].vn;
                }
                return bf(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public e e(boolean z) {
            if (this.e) {
                this.tg = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public wu e() {
            return new wu(this);
        }
    }

    private wu bf(SSLSocket sSLSocket, boolean z) {
        String[] strArrE = this.vn != null ? com.bytedance.sdk.component.d.bf.e.d.e(v.e, sSLSocket.getEnabledCipherSuites(), this.vn) : sSLSocket.getEnabledCipherSuites();
        String[] strArrE2 = this.p != null ? com.bytedance.sdk.component.d.bf.e.d.e(com.bytedance.sdk.component.d.bf.e.d.v, sSLSocket.getEnabledProtocols(), this.p) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iE = com.bytedance.sdk.component.d.bf.e.d.e(v.e, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iE != -1) {
            strArrE = com.bytedance.sdk.component.d.bf.e.d.e(strArrE, supportedCipherSuites[iE]);
        }
        return new e(this).e(strArrE).bf(strArrE2).e();
    }

    public void e(SSLSocket sSLSocket, boolean z) {
        wu wuVarBf = bf(sSLSocket, z);
        String[] strArr = wuVarBf.p;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = wuVarBf.vn;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean e(SSLSocket sSLSocket) {
        if (!this.tg) {
            return false;
        }
        String[] strArr = this.p;
        if (strArr != null && !com.bytedance.sdk.component.d.bf.e.d.bf(com.bytedance.sdk.component.d.bf.e.d.v, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.vn;
        return strArr2 == null || com.bytedance.sdk.component.d.bf.e.d.bf(v.e, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
