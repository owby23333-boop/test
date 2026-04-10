package com.bytedance.sdk.component.dl.g.z.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.dl.g.fv;
import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.z.dl.fo;
import com.bytedance.sdk.component.dl.g.z.dl.gz;
import com.bytedance.sdk.component.dl.g.z.dl.kb;
import com.bytedance.sdk.component.dl.g.z.g.e;
import com.bytedance.sdk.component.dl.g.zw;
import com.bytedance.sdk.component.dl.z.fv;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.tb;
import com.bytedance.sdk.component.dl.z.wp;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements com.bytedance.sdk.component.dl.g.z.dl.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.bytedance.sdk.component.dl.z.a f650a;
    final com.bytedance.sdk.component.dl.z.gc dl;
    final e g;
    int gc = 0;
    private long m = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    final zw z;

    public z(zw zwVar, e eVar, com.bytedance.sdk.component.dl.z.gc gcVar, com.bytedance.sdk.component.dl.z.a aVar) {
        this.z = zwVar;
        this.g = eVar;
        this.dl = gcVar;
        this.f650a = aVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public fv z(sy syVar, long j) {
        if ("chunked".equalsIgnoreCase(syVar.z(HttpHeaders.TRANSFER_ENCODING))) {
            return gc();
        }
        if (j != -1) {
            return z(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void dl() {
        com.bytedance.sdk.component.dl.g.z.g.dl dlVarG = this.g.g();
        if (dlVarG != null) {
            dlVarG.g();
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void z(sy syVar) throws IOException {
        z(syVar.dl(), fo.z(syVar, this.g.g().z().g().type()));
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public gk z(h hVar) throws IOException {
        String strZ = hVar.z(HttpHeaders.CONTENT_TYPE);
        if (!com.bytedance.sdk.component.dl.g.z.dl.gc.dl(hVar)) {
            return new gz(strZ, 0L, wp.z(g(0L)));
        }
        if ("chunked".equalsIgnoreCase(hVar.z(HttpHeaders.TRANSFER_ENCODING))) {
            return new gz(strZ, -1L, wp.z(z(hVar.z().z())));
        }
        long jZ = com.bytedance.sdk.component.dl.g.z.dl.gc.z(hVar);
        if (jZ != -1) {
            return new gz(strZ, jZ, wp.z(g(jZ)));
        }
        return new gz(strZ, -1L, wp.z(m()));
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void z() throws IOException {
        this.f650a.flush();
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void g() throws IOException {
        this.f650a.flush();
    }

    public void z(com.bytedance.sdk.component.dl.g.fv fvVar, String str) throws IOException {
        if (this.gc != 0) {
            throw new IllegalStateException("state: " + this.gc);
        }
        this.f650a.g(str).g("\r\n");
        int iZ = fvVar.z();
        for (int i = 0; i < iZ; i++) {
            this.f650a.g(fvVar.z(i)).g(": ").g(fvVar.g(i)).g("\r\n");
        }
        this.f650a.g("\r\n");
        this.gc = 1;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public h.z z(boolean z) throws IOException {
        int i = this.gc;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.gc);
        }
        try {
            kb kbVarZ = kb.z(e());
            h.z zVarZ = new h.z().z(kbVarZ.z).z(kbVarZ.g).z(kbVarZ.dl).z(a());
            if (z && kbVarZ.g == 100) {
                return null;
            }
            this.gc = 4;
            return zVarZ;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.g);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String e() throws IOException {
        String strGc = this.dl.gc(this.m);
        this.m -= (long) strGc.length();
        return strGc;
    }

    public com.bytedance.sdk.component.dl.g.fv a() throws IOException {
        fv.z zVar = new fv.z();
        while (true) {
            String strE = e();
            if (strE.length() != 0) {
                com.bytedance.sdk.component.dl.g.z.z.z.z(zVar, strE);
            } else {
                return zVar.z();
            }
        }
    }

    public com.bytedance.sdk.component.dl.z.fv gc() {
        if (this.gc != 1) {
            throw new IllegalStateException("state: " + this.gc);
        }
        this.gc = 2;
        return new g();
    }

    public com.bytedance.sdk.component.dl.z.fv z(long j) {
        if (this.gc != 1) {
            throw new IllegalStateException("state: " + this.gc);
        }
        this.gc = 2;
        return new a(j);
    }

    public js g(long j) throws IOException {
        if (this.gc != 4) {
            throw new IllegalStateException("state: " + this.gc);
        }
        this.gc = 5;
        return new gc(j);
    }

    public js z(com.bytedance.sdk.component.dl.g.js jsVar) throws IOException {
        if (this.gc != 4) {
            throw new IllegalStateException("state: " + this.gc);
        }
        this.gc = 5;
        return new dl(jsVar);
    }

    public js m() throws IOException {
        if (this.gc != 4) {
            throw new IllegalStateException("state: " + this.gc);
        }
        e eVar = this.g;
        if (eVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.gc = 5;
        eVar.a();
        return new m();
    }

    void z(com.bytedance.sdk.component.dl.z.fo foVar) {
        tb tbVarZ = foVar.z();
        foVar.z(tb.dl);
        tbVarZ.m();
        tbVarZ.gc();
    }

    private final class a implements com.bytedance.sdk.component.dl.z.fv {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f651a;
        private boolean dl;
        private final com.bytedance.sdk.component.dl.z.fo g;

        a(long j) {
            this.g = new com.bytedance.sdk.component.dl.z.fo(z.this.f650a.z());
            this.f651a = j;
        }

        @Override // com.bytedance.sdk.component.dl.z.fv
        public tb z() {
            return this.g;
        }

        @Override // com.bytedance.sdk.component.dl.z.fv
        public void a_(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (this.dl) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.component.dl.g.z.dl.z(dlVar.g(), 0L, j);
            if (j > this.f651a) {
                throw new ProtocolException("expected " + this.f651a + " bytes but received " + j);
            }
            z.this.f650a.a_(dlVar, j);
            this.f651a -= j;
        }

        @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
        public void flush() throws IOException {
            if (this.dl) {
                return;
            }
            z.this.f650a.flush();
        }

        @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.dl) {
                return;
            }
            this.dl = true;
            if (this.f651a > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            z.this.z(this.g);
            z.this.gc = 3;
        }
    }

    private final class g implements com.bytedance.sdk.component.dl.z.fv {
        private boolean dl;
        private final com.bytedance.sdk.component.dl.z.fo g;

        g() {
            this.g = new com.bytedance.sdk.component.dl.z.fo(z.this.f650a.z());
        }

        @Override // com.bytedance.sdk.component.dl.z.fv
        public tb z() {
            return this.g;
        }

        @Override // com.bytedance.sdk.component.dl.z.fv
        public void a_(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (this.dl) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            z.this.f650a.kb(j);
            z.this.f650a.g("\r\n");
            z.this.f650a.a_(dlVar, j);
            z.this.f650a.g("\r\n");
        }

        @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.dl) {
                return;
            }
            z.this.f650a.flush();
        }

        @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.dl) {
                return;
            }
            this.dl = true;
            z.this.f650a.g("0\r\n\r\n");
            z.this.z(this.g);
            z.this.gc = 3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.dl.g.z.a.z$z, reason: collision with other inner class name */
    private abstract class AbstractC0127z implements js {
        protected long dl;
        protected boolean g;
        protected final com.bytedance.sdk.component.dl.z.fo z;

        private AbstractC0127z() {
            this.z = new com.bytedance.sdk.component.dl.z.fo(z.this.dl.z());
            this.dl = 0L;
        }

        @Override // com.bytedance.sdk.component.dl.z.js
        public tb z() {
            return this.z;
        }

        @Override // com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            try {
                long jZ = z.this.dl.z(dlVar, j);
                if (jZ > 0) {
                    this.dl += jZ;
                }
                return jZ;
            } catch (IOException e) {
                z(false, e);
                throw e;
            }
        }

        protected final void z(boolean z, IOException iOException) throws IOException {
            if (z.this.gc == 6) {
                return;
            }
            if (z.this.gc != 5) {
                throw new IllegalStateException("state: " + z.this.gc);
            }
            z.this.z(this.z);
            z.this.gc = 6;
            if (z.this.g != null) {
                z.this.g.z(!z, z.this, this.dl, iOException);
            }
        }
    }

    private class gc extends AbstractC0127z {
        private long m;

        gc(long j) throws IOException {
            super();
            this.m = j;
            if (j == 0) {
                z(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.a.z.AbstractC0127z, com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.g) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.m;
            if (j2 == 0) {
                return -1L;
            }
            long jZ = super.z(dlVar, Math.min(j2, j));
            if (jZ == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                z(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.m - jZ;
            this.m = j3;
            if (j3 == 0) {
                z(true, (IOException) null);
            }
            return jZ;
        }

        @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.g) {
                return;
            }
            if (this.m != 0 && !com.bytedance.sdk.component.dl.g.z.dl.z(this, 100, TimeUnit.MILLISECONDS)) {
                z(false, (IOException) null);
            }
            this.g = true;
        }
    }

    private class dl extends AbstractC0127z {
        private long e;
        private boolean gz;
        private final com.bytedance.sdk.component.dl.g.js m;

        dl(com.bytedance.sdk.component.dl.g.js jsVar) {
            super();
            this.e = -1L;
            this.gz = true;
            this.m = jsVar;
        }

        @Override // com.bytedance.sdk.component.dl.g.z.a.z.AbstractC0127z, com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.g) {
                throw new IllegalStateException("closed");
            }
            if (!this.gz) {
                return -1L;
            }
            long j2 = this.e;
            if (j2 == 0 || j2 == -1) {
                g();
                if (!this.gz) {
                    return -1L;
                }
            }
            long jZ = super.z(dlVar, Math.min(j, this.e));
            if (jZ == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                z(false, (IOException) protocolException);
                throw protocolException;
            }
            this.e -= jZ;
            return jZ;
        }

        private void g() throws IOException {
            if (this.e != -1) {
                z.this.dl.ls();
            }
            try {
                this.e = z.this.dl.i();
                String strTrim = z.this.dl.ls().trim();
                if (this.e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + strTrim + "\"");
                }
                if (this.e == 0) {
                    this.gz = false;
                    com.bytedance.sdk.component.dl.g.z.dl.gc.z(z.this.z.m(), this.m, z.this.a());
                    z(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.g) {
                return;
            }
            if (this.gz && !com.bytedance.sdk.component.dl.g.z.dl.z(this, 100, TimeUnit.MILLISECONDS)) {
                z(false, (IOException) null);
            }
            this.g = true;
        }
    }

    private class m extends AbstractC0127z {
        private boolean m;

        m() {
            super();
        }

        @Override // com.bytedance.sdk.component.dl.g.z.a.z.AbstractC0127z, com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.g) {
                throw new IllegalStateException("closed");
            }
            if (this.m) {
                return -1L;
            }
            long jZ = super.z(dlVar, j);
            if (jZ != -1) {
                return jZ;
            }
            this.m = true;
            z(true, (IOException) null);
            return -1L;
        }

        @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.g) {
                return;
            }
            if (!this.m) {
                z(false, (IOException) null);
            }
            this.g = true;
        }
    }
}
