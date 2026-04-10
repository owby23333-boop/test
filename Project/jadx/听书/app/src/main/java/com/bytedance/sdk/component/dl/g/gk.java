package com.bytedance.sdk.component.dl.g;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gk implements Closeable {
    public abstract com.bytedance.sdk.component.dl.z.gc dl();

    public abstract long g();

    public abstract q z();

    public final InputStream a() {
        return dl().m();
    }

    public final byte[] gc() throws IOException {
        long jG = g();
        if (jG > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jG)));
        }
        com.bytedance.sdk.component.dl.z.gc gcVarDl = dl();
        try {
            byte[] bArrP = gcVarDl.p();
            com.bytedance.sdk.component.dl.g.z.dl.z(gcVarDl);
            if (jG == -1 || jG == bArrP.length) {
                return bArrP;
            }
            throw new IOException("Content-Length (" + jG + ") and stream length (" + bArrP.length + ") disagree");
        } catch (Throwable th) {
            com.bytedance.sdk.component.dl.g.z.dl.z(gcVarDl);
            throw th;
        }
    }

    public final String m() throws IOException {
        com.bytedance.sdk.component.dl.z.gc gcVarDl = dl();
        try {
            String strZ = gcVarDl.z(com.bytedance.sdk.component.dl.g.z.dl.z(gcVarDl, e()));
            com.bytedance.sdk.component.dl.g.z.dl.z(gcVarDl);
            return strZ;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.dl.g.z.dl.z(gcVarDl);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.dl.g.z.dl.z(gcVarDl);
            throw th;
        }
    }

    private Charset e() {
        q qVarZ = z();
        return qVarZ != null ? qVarZ.z(com.bytedance.sdk.component.dl.g.z.dl.gc) : com.bytedance.sdk.component.dl.g.z.dl.gc;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.dl.g.z.dl.z(dl());
    }

    public static gk z(q qVar, byte[] bArr) {
        return z(qVar, bArr.length, new com.bytedance.sdk.component.dl.z.dl().dl(bArr));
    }

    public static gk z(final q qVar, final long j, final com.bytedance.sdk.component.dl.z.gc gcVar) {
        if (gcVar == null) {
            throw new NullPointerException("source == null");
        }
        return new gk() { // from class: com.bytedance.sdk.component.dl.g.gk.1
            @Override // com.bytedance.sdk.component.dl.g.gk
            public q z() {
                return qVar;
            }

            @Override // com.bytedance.sdk.component.dl.g.gk
            public long g() {
                return j;
            }

            @Override // com.bytedance.sdk.component.dl.g.gk
            public com.bytedance.sdk.component.dl.z.gc dl() {
                return gcVar;
            }
        };
    }
}
