package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Closeable {
    final y a;
    final w b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final q f897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final r f898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final b0 f899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final a0 f900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final a0 f901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final a0 f902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final long f903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final long f904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile d f905m;

    public static class a {
        y a;
        w b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        q f908e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        r.a f909f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        b0 f910g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        a0 f911h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        a0 f912i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        a0 f913j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f914k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f915l;

        public a() {
            this.f906c = -1;
            this.f909f = new r.a();
        }

        a(a0 a0Var) {
            this.f906c = -1;
            this.a = a0Var.a;
            this.b = a0Var.b;
            this.f906c = a0Var.f895c;
            this.f907d = a0Var.f896d;
            this.f908e = a0Var.f897e;
            this.f909f = a0Var.f898f.a();
            this.f910g = a0Var.f899g;
            this.f911h = a0Var.f900h;
            this.f912i = a0Var.f901i;
            this.f913j = a0Var.f902j;
            this.f914k = a0Var.f903k;
            this.f915l = a0Var.f904l;
        }

        private void a(String str, a0 a0Var) {
            if (a0Var.f899g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (a0Var.f900h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (a0Var.f901i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (a0Var.f902j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        private void d(a0 a0Var) {
            if (a0Var.f899g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i2) {
            this.f906c = i2;
            return this;
        }

        public a a(long j2) {
            this.f915l = j2;
            return this;
        }

        public a a(a0 a0Var) {
            if (a0Var != null) {
                a("cacheResponse", a0Var);
            }
            this.f912i = a0Var;
            return this;
        }

        public a a(b0 b0Var) {
            this.f910g = b0Var;
            return this;
        }

        public a a(q qVar) {
            this.f908e = qVar;
            return this;
        }

        public a a(r rVar) {
            this.f909f = rVar.a();
            return this;
        }

        public a a(w wVar) {
            this.b = wVar;
            return this;
        }

        public a a(y yVar) {
            this.a = yVar;
            return this;
        }

        public a a(String str) {
            this.f907d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f909f.a(str, str2);
            return this;
        }

        public a0 a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f906c >= 0) {
                if (this.f907d != null) {
                    return new a0(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f906c);
        }

        public a b(long j2) {
            this.f914k = j2;
            return this;
        }

        public a b(a0 a0Var) {
            if (a0Var != null) {
                a("networkResponse", a0Var);
            }
            this.f911h = a0Var;
            return this;
        }

        public a c(a0 a0Var) {
            if (a0Var != null) {
                d(a0Var);
            }
            this.f913j = a0Var;
            return this;
        }
    }

    a0(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f895c = aVar.f906c;
        this.f896d = aVar.f907d;
        this.f897e = aVar.f908e;
        this.f898f = aVar.f909f.a();
        this.f899g = aVar.f910g;
        this.f900h = aVar.f911h;
        this.f901i = aVar.f912i;
        this.f902j = aVar.f913j;
        this.f903k = aVar.f914k;
        this.f904l = aVar.f915l;
    }

    public String a(String str, String str2) {
        String strA = this.f898f.a(str);
        return strA != null ? strA : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0 b0Var = this.f899g;
        if (b0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b0Var.close();
    }

    public b0 i() {
        return this.f899g;
    }

    public d j() {
        d dVar = this.f905m;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f898f);
        this.f905m = dVarA;
        return dVarA;
    }

    public int k() {
        return this.f895c;
    }

    public q l() {
        return this.f897e;
    }

    public r m() {
        return this.f898f;
    }

    public boolean n() {
        int i2 = this.f895c;
        return i2 >= 200 && i2 < 300;
    }

    public String o() {
        return this.f896d;
    }

    public a p() {
        return new a(this);
    }

    public a0 q() {
        return this.f902j;
    }

    public long r() {
        return this.f904l;
    }

    public y s() {
        return this.a;
    }

    public long t() {
        return this.f903k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.f895c + ", message=" + this.f896d + ", url=" + this.a.g() + '}';
    }
}
