package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.umeng.message.proguard.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final h[] f1205e = {h.f1193m, h.f1195o, h.f1194n, h.f1196p, h.f1198r, h.f1197q, h.f1189i, h.f1191k, h.f1190j, h.f1192l, h.f1187g, h.f1188h, h.f1185e, h.f1186f, h.f1184d};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f1206f = new a(true).a(f1205e).a(d0.TLS_1_3, d0.TLS_1_2, d0.TLS_1_1, d0.TLS_1_0).a(true).a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f1207g;
    final boolean a;
    final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String[] f1208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String[] f1209d;

    public static final class a {
        boolean a;
        String[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String[] f1210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1211d;

        public a(k kVar) {
            this.a = kVar.a;
            this.b = kVar.f1208c;
            this.f1210c = kVar.f1209d;
            this.f1211d = kVar.b;
        }

        a(boolean z2) {
            this.a = z2;
        }

        public a a(boolean z2) {
            if (!this.a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f1211d = z2;
            return this;
        }

        public a a(d0... d0VarArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[d0VarArr.length];
            for (int i2 = 0; i2 < d0VarArr.length; i2++) {
                strArr[i2] = d0VarArr[i2].a;
            }
            return b(strArr);
        }

        public a a(h... hVarArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i2 = 0; i2 < hVarArr.length; i2++) {
                strArr[i2] = hVarArr[i2].a;
            }
            return a(strArr);
        }

        public a a(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f1210c = (String[]) strArr.clone();
            return this;
        }
    }

    static {
        new a(f1206f).a(d0.TLS_1_0).a(true).a();
        f1207g = new a(false).a();
    }

    k(a aVar) {
        this.a = aVar.a;
        this.f1208c = aVar.b;
        this.f1209d = aVar.f1210c;
        this.b = aVar.f1211d;
    }

    private k b(SSLSocket sSLSocket, boolean z2) {
        String[] strArrA = this.f1208c != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(h.b, sSLSocket.getEnabledCipherSuites(), this.f1208c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrA2 = this.f1209d != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1155o, sSLSocket.getEnabledProtocols(), this.f1209d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(h.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z2 && iA != -1) {
            strArrA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(strArrA, supportedCipherSuites[iA]);
        }
        return new a(this).a(strArrA).b(strArrA2).a();
    }

    public List<h> a() {
        String[] strArr = this.f1208c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    void a(SSLSocket sSLSocket, boolean z2) {
        k kVarB = b(sSLSocket, z2);
        String[] strArr = kVarB.f1209d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = kVarB.f1208c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        String[] strArr;
        String[] strArr2;
        return this.a && ((strArr = this.f1209d) == null || bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1155o, strArr, sSLSocket.getEnabledProtocols())) && ((strArr2 = this.f1208c) == null || bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(h.b, strArr2, sSLSocket.getEnabledCipherSuites()));
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public List<d0> d() {
        String[] strArr = this.f1209d;
        if (strArr != null) {
            return d0.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z2 = this.a;
            if (z2 == kVar.a) {
                if (!z2) {
                    return true;
                }
                if (Arrays.equals(this.f1208c, kVar.f1208c) && Arrays.equals(this.f1209d, kVar.f1209d) && this.b == kVar.b) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.a) {
            return ((((Arrays.hashCode(this.f1208c) + 527) * 31) + Arrays.hashCode(this.f1209d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f1208c != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.f1209d != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.b + ad.f20406s;
    }
}
