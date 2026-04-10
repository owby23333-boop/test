package com.bytedance.sdk.component.dl.g;

import com.bytedance.sdk.component.dl.g.fv;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f629a;
    final int dl;
    final gk e;
    final h fo;
    final io g;
    final p gc;
    final h gz;
    private volatile a i;
    final long kb;
    final fv m;
    final h uy;
    final long wp;
    final sy z;

    h(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f629a = zVar.f630a;
        this.gc = zVar.gc;
        this.m = zVar.m.z();
        this.e = zVar.e;
        this.gz = zVar.gz;
        this.fo = zVar.fo;
        this.uy = zVar.uy;
        this.kb = zVar.kb;
        this.wp = zVar.wp;
    }

    public sy z() {
        return this.z;
    }

    public io g() {
        return this.g;
    }

    public int dl() {
        return this.dl;
    }

    public boolean a() {
        int i = this.dl;
        return i >= 200 && i < 300;
    }

    public String gc() {
        return this.f629a;
    }

    public p m() {
        return this.gc;
    }

    public String z(String str) {
        return z(str, null);
    }

    public String z(String str, String str2) {
        String strZ = this.m.z(str);
        return strZ != null ? strZ : str2;
    }

    public fv e() {
        return this.m;
    }

    public gk gz() {
        return this.e;
    }

    public z fo() {
        return new z(this);
    }

    public h uy() {
        return this.gz;
    }

    public h kb() {
        return this.uy;
    }

    public a wp() {
        a aVar = this.i;
        if (aVar != null) {
            return aVar;
        }
        a aVarZ = a.z(this.m);
        this.i = aVarZ;
        return aVarZ;
    }

    public long i() {
        return this.kb;
    }

    public long v() {
        return this.wp;
    }

    public l pf() {
        sy syVar = this.z;
        if (syVar == null) {
            return null;
        }
        return syVar.m;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        gk gkVar = this.e;
        if (gkVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        gkVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.g + ", code=" + this.dl + ", message=" + this.f629a + ", url=" + this.z.z() + '}';
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f630a;
        int dl;
        gk e;
        h fo;
        io g;
        p gc;
        h gz;
        long kb;
        fv.z m;
        h uy;
        long wp;
        sy z;

        public z() {
            this.dl = -1;
            this.m = new fv.z();
        }

        z(h hVar) {
            this.dl = -1;
            this.z = hVar.z;
            this.g = hVar.g;
            this.dl = hVar.dl;
            this.f630a = hVar.f629a;
            this.gc = hVar.gc;
            this.m = hVar.m.g();
            this.e = hVar.e;
            this.gz = hVar.gz;
            this.fo = hVar.fo;
            this.uy = hVar.uy;
            this.kb = hVar.kb;
            this.wp = hVar.wp;
        }

        public z z(sy syVar) {
            this.z = syVar;
            return this;
        }

        public z z(io ioVar) {
            this.g = ioVar;
            return this;
        }

        public z z(int i) {
            this.dl = i;
            return this;
        }

        public z z(String str) {
            this.f630a = str;
            return this;
        }

        public z z(p pVar) {
            this.gc = pVar;
            return this;
        }

        public z z(String str, String str2) {
            this.m.z(str, str2);
            return this;
        }

        public z z(fv fvVar) {
            this.m = fvVar.g();
            return this;
        }

        public z z(gk gkVar) {
            this.e = gkVar;
            return this;
        }

        public z z(h hVar) {
            if (hVar != null) {
                z("networkResponse", hVar);
            }
            this.gz = hVar;
            return this;
        }

        public z g(h hVar) {
            if (hVar != null) {
                z("cacheResponse", hVar);
            }
            this.fo = hVar;
            return this;
        }

        private void z(String str, h hVar) {
            if (hVar.e != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (hVar.gz != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (hVar.fo != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (hVar.uy != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public z dl(h hVar) {
            if (hVar != null) {
                a(hVar);
            }
            this.uy = hVar;
            return this;
        }

        private void a(h hVar) {
            if (hVar.e != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public z z(long j) {
            this.kb = j;
            return this;
        }

        public z g(long j) {
            this.wp = j;
            return this;
        }

        public h z() {
            if (this.z == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.g == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.dl < 0) {
                throw new IllegalStateException("code < 0: " + this.dl);
            }
            if (this.f630a == null) {
                throw new IllegalStateException("message == null");
            }
            return new h(this);
        }
    }
}
