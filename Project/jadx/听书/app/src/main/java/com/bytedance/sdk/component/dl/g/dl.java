package com.bytedance.sdk.component.dl.g;

import com.bytedance.sdk.component.dl.g.z.z.a;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class dl implements Closeable, Flushable {
    final com.bytedance.sdk.component.dl.g.z.z.a g;
    final com.bytedance.sdk.component.dl.g.z.z.m z;

    void update(h hVar, h hVar2) {
        a.z zVarZ;
        g gVar = new g(hVar2);
        try {
            zVarZ = ((z) hVar.gz()).z.z();
            if (zVarZ != null) {
                try {
                    gVar.z(zVarZ);
                    zVarZ.g();
                } catch (IOException unused) {
                    z(zVarZ);
                }
            }
        } catch (IOException unused2) {
            zVarZ = null;
        }
    }

    private void z(a.z zVar) {
        if (zVar != null) {
            try {
                zVar.dl();
            } catch (IOException unused) {
            }
        }
    }

    public void delete() throws IOException {
        this.g.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.g.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.g.close();
    }

    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fv f625a;
        private final String dl;
        private final int e;
        private final fv fo;
        private final String gc;
        private final String gz;
        private final long kb;
        private final io m;
        private final p uy;
        private final long wp;
        private static final String z = com.bytedance.sdk.component.dl.g.z.e.gc.g().dl() + "-Sent-Millis";
        private static final String g = com.bytedance.sdk.component.dl.g.z.e.gc.g().dl() + "-Received-Millis";

        g(h hVar) {
            this.dl = hVar.z().z().toString();
            this.f625a = com.bytedance.sdk.component.dl.g.z.dl.gc.g(hVar);
            this.gc = hVar.z().g();
            this.m = hVar.g();
            this.e = hVar.dl();
            this.gz = hVar.gc();
            this.fo = hVar.e();
            this.uy = hVar.m();
            this.kb = hVar.i();
            this.wp = hVar.v();
        }

        public void z(a.z zVar) throws IOException {
            com.bytedance.sdk.component.dl.z.a aVarZ = com.bytedance.sdk.component.dl.z.wp.z(zVar.z(0));
            aVarZ.g(this.dl).fo(10);
            aVarZ.g(this.gc).fo(10);
            aVarZ.wp(this.f625a.z()).fo(10);
            int iZ = this.f625a.z();
            for (int i = 0; i < iZ; i++) {
                aVarZ.g(this.f625a.z(i)).g(": ").g(this.f625a.g(i)).fo(10);
            }
            aVarZ.g(new com.bytedance.sdk.component.dl.g.z.dl.kb(this.m, this.e, this.gz).toString()).fo(10);
            aVarZ.wp(this.fo.z() + 2).fo(10);
            int iZ2 = this.fo.z();
            for (int i2 = 0; i2 < iZ2; i2++) {
                aVarZ.g(this.fo.z(i2)).g(": ").g(this.fo.g(i2)).fo(10);
            }
            aVarZ.g(z).g(": ").wp(this.kb).fo(10);
            aVarZ.g(g).g(": ").wp(this.wp).fo(10);
            if (z()) {
                aVarZ.fo(10);
                aVarZ.g(this.uy.g().z()).fo(10);
                z(aVarZ, this.uy.dl());
                z(aVarZ, this.uy.a());
                aVarZ.g(this.uy.z().z()).fo(10);
            }
            aVarZ.close();
        }

        private boolean z() {
            return this.dl.startsWith("https://");
        }

        private void z(com.bytedance.sdk.component.dl.z.a aVar, List<Certificate> list) throws IOException {
            try {
                aVar.wp(list.size()).fo(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    aVar.g(com.bytedance.sdk.component.dl.z.m.z(list.get(i).getEncoded()).g()).fo(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    private static class z extends gk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f626a;
        private final String dl;
        private final com.bytedance.sdk.component.dl.z.gc g;
        final a.dl z;

        @Override // com.bytedance.sdk.component.dl.g.gk
        public q z() {
            String str = this.dl;
            if (str != null) {
                return q.z(str);
            }
            return null;
        }

        @Override // com.bytedance.sdk.component.dl.g.gk
        public long g() {
            try {
                String str = this.f626a;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.gk
        public com.bytedance.sdk.component.dl.z.gc dl() {
            return this.g;
        }
    }
}
