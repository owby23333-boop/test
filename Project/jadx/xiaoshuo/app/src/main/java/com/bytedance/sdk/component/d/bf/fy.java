package com.bytedance.sdk.component.d.bf;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class fy implements Closeable {
    public static fy e(pe peVar, byte[] bArr) {
        return e(peVar, bArr.length, new com.bytedance.sdk.component.d.e.d().d(bArr));
    }

    private Charset p() {
        pe peVarE = e();
        return peVarE != null ? peVarE.e(com.bytedance.sdk.component.d.bf.e.d.ga) : com.bytedance.sdk.component.d.bf.e.d.ga;
    }

    public abstract long bf();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.d.bf.e.d.e(d());
    }

    public abstract com.bytedance.sdk.component.d.e.ga d();

    public abstract pe e();

    public final byte[] ga() throws IOException {
        long jBf = bf();
        if (jBf > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jBf);
        }
        com.bytedance.sdk.component.d.e.ga gaVarD = d();
        try {
            byte[] bArrL = gaVarD.l();
            com.bytedance.sdk.component.d.bf.e.d.e(gaVarD);
            if (jBf == -1 || jBf == bArrL.length) {
                return bArrL;
            }
            throw new IOException("Content-Length (" + jBf + ") and stream length (" + bArrL.length + ") disagree");
        } catch (Throwable th) {
            com.bytedance.sdk.component.d.bf.e.d.e(gaVarD);
            throw th;
        }
    }

    public final InputStream tg() {
        return d().vn();
    }

    public final String vn() throws IOException {
        com.bytedance.sdk.component.d.e.ga gaVarD = d();
        try {
            String strE = gaVarD.e(com.bytedance.sdk.component.d.bf.e.d.e(gaVarD, p()));
            com.bytedance.sdk.component.d.bf.e.d.e(gaVarD);
            return strE;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.d.bf.e.d.e(gaVarD);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.d.bf.e.d.e(gaVarD);
            throw th;
        }
    }

    public static fy e(final pe peVar, final long j, final com.bytedance.sdk.component.d.e.ga gaVar) {
        if (gaVar != null) {
            return new fy() { // from class: com.bytedance.sdk.component.d.bf.fy.1
                @Override // com.bytedance.sdk.component.d.bf.fy
                public long bf() {
                    return j;
                }

                @Override // com.bytedance.sdk.component.d.bf.fy
                public com.bytedance.sdk.component.d.e.ga d() {
                    return gaVar;
                }

                @Override // com.bytedance.sdk.component.d.bf.fy
                public pe e() {
                    return peVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
