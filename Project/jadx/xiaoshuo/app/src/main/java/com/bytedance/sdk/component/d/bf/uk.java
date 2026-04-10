package com.bytedance.sdk.component.d.bf;

import com.bytedance.sdk.component.d.bf.f;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class uk implements Closeable {
    final wl bf;
    private volatile tg bh;
    final int d;
    final lc e;
    final l ga;
    final uk m;
    final fy p;
    final String tg;
    final uk v;
    final f vn;
    final long wu;
    final long xu;
    final uk zk;

    public static class e {
        wl bf;
        int d;
        lc e;
        l ga;
        uk m;
        fy p;
        String tg;
        uk v;
        f.e vn;
        long wu;
        long xu;
        uk zk;

        public e() {
            this.d = -1;
            this.vn = new f.e();
        }

        private void tg(uk ukVar) {
            if (ukVar.p != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public e bf(uk ukVar) {
            if (ukVar != null) {
                e("cacheResponse", ukVar);
            }
            this.zk = ukVar;
            return this;
        }

        public e d(uk ukVar) {
            if (ukVar != null) {
                tg(ukVar);
            }
            this.m = ukVar;
            return this;
        }

        public e e(lc lcVar) {
            this.e = lcVar;
            return this;
        }

        public e e(wl wlVar) {
            this.bf = wlVar;
            return this;
        }

        public e bf(long j) {
            this.xu = j;
            return this;
        }

        public e e(int i) {
            this.d = i;
            return this;
        }

        public e(uk ukVar) {
            this.d = -1;
            this.e = ukVar.e;
            this.bf = ukVar.bf;
            this.d = ukVar.d;
            this.tg = ukVar.tg;
            this.ga = ukVar.ga;
            this.vn = ukVar.vn.bf();
            this.p = ukVar.p;
            this.v = ukVar.v;
            this.zk = ukVar.zk;
            this.m = ukVar.m;
            this.wu = ukVar.wu;
            this.xu = ukVar.xu;
        }

        public e e(String str) {
            this.tg = str;
            return this;
        }

        public e e(l lVar) {
            this.ga = lVar;
            return this;
        }

        public e e(String str, String str2) {
            this.vn.e(str, str2);
            return this;
        }

        public e e(f fVar) {
            this.vn = fVar.bf();
            return this;
        }

        public e e(fy fyVar) {
            this.p = fyVar;
            return this;
        }

        public e e(uk ukVar) {
            if (ukVar != null) {
                e("networkResponse", ukVar);
            }
            this.v = ukVar;
            return this;
        }

        private void e(String str, uk ukVar) {
            if (ukVar.p == null) {
                if (ukVar.v == null) {
                    if (ukVar.zk == null) {
                        if (ukVar.m == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public e e(long j) {
            this.wu = j;
            return this;
        }

        public uk e() {
            if (this.e != null) {
                if (this.bf != null) {
                    if (this.d >= 0) {
                        if (this.tg != null) {
                            return new uk(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.d);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public uk(e eVar) {
        this.e = eVar.e;
        this.bf = eVar.bf;
        this.d = eVar.d;
        this.tg = eVar.tg;
        this.ga = eVar.ga;
        this.vn = eVar.vn.e();
        this.p = eVar.p;
        this.v = eVar.v;
        this.zk = eVar.zk;
        this.m = eVar.m;
        this.wu = eVar.wu;
        this.xu = eVar.xu;
    }

    public wl bf() {
        return this.bf;
    }

    public long bh() {
        return this.wu;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fy fyVar = this.p;
        if (fyVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        fyVar.close();
    }

    public int d() {
        return this.d;
    }

    public lc e() {
        return this.e;
    }

    public String ga() {
        return this.tg;
    }

    public uk m() {
        return this.v;
    }

    public f p() {
        return this.vn;
    }

    public long t() {
        return this.xu;
    }

    public boolean tg() {
        int i = this.d;
        return i >= 200 && i < 300;
    }

    public String toString() {
        return "Response{protocol=" + this.bf + ", code=" + this.d + ", message=" + this.tg + ", url=" + this.e.e() + '}';
    }

    public fy v() {
        return this.p;
    }

    public l vn() {
        return this.ga;
    }

    public uk wu() {
        return this.m;
    }

    public tg xu() {
        tg tgVar = this.bh;
        if (tgVar != null) {
            return tgVar;
        }
        tg tgVarE = tg.e(this.vn);
        this.bh = tgVarE;
        return tgVarE;
    }

    public e zk() {
        return new e(this);
    }

    public String e(String str) {
        return e(str, null);
    }

    public String e(String str, String str2) {
        String strE = this.vn.e(str);
        return strE != null ? strE : str2;
    }
}
