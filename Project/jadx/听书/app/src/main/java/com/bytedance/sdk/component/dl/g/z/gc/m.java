package com.bytedance.sdk.component.dl.g.z.gc;

import com.bytedance.sdk.component.dl.g.fv;
import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.zw;
import com.bytedance.sdk.component.dl.z.fv;
import com.bytedance.sdk.component.dl.z.js;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements com.bytedance.sdk.component.dl.g.z.dl.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.sdk.component.dl.z.m f683a;
    private static final com.bytedance.sdk.component.dl.z.m dl;
    private static final com.bytedance.sdk.component.dl.z.m e;
    private static final com.bytedance.sdk.component.dl.z.m fo;
    private static final com.bytedance.sdk.component.dl.z.m g;
    private static final com.bytedance.sdk.component.dl.z.m gc;
    private static final com.bytedance.sdk.component.dl.z.m gz;
    private static final List<com.bytedance.sdk.component.dl.z.m> kb;
    private static final com.bytedance.sdk.component.dl.z.m m;
    private static final List<com.bytedance.sdk.component.dl.z.m> uy;
    private final tb.z i;
    private fo pf;
    private final e v;
    private final zw wp;
    final com.bytedance.sdk.component.dl.g.z.g.e z;

    static {
        com.bytedance.sdk.component.dl.z.m mVarZ = com.bytedance.sdk.component.dl.z.m.z("connection");
        g = mVarZ;
        com.bytedance.sdk.component.dl.z.m mVarZ2 = com.bytedance.sdk.component.dl.z.m.z("host");
        dl = mVarZ2;
        com.bytedance.sdk.component.dl.z.m mVarZ3 = com.bytedance.sdk.component.dl.z.m.z("keep-alive");
        f683a = mVarZ3;
        com.bytedance.sdk.component.dl.z.m mVarZ4 = com.bytedance.sdk.component.dl.z.m.z("proxy-connection");
        gc = mVarZ4;
        com.bytedance.sdk.component.dl.z.m mVarZ5 = com.bytedance.sdk.component.dl.z.m.z("transfer-encoding");
        m = mVarZ5;
        com.bytedance.sdk.component.dl.z.m mVarZ6 = com.bytedance.sdk.component.dl.z.m.z("te");
        e = mVarZ6;
        com.bytedance.sdk.component.dl.z.m mVarZ7 = com.bytedance.sdk.component.dl.z.m.z("encoding");
        gz = mVarZ7;
        com.bytedance.sdk.component.dl.z.m mVarZ8 = com.bytedance.sdk.component.dl.z.m.z("upgrade");
        fo = mVarZ8;
        uy = com.bytedance.sdk.component.dl.g.z.dl.z(mVarZ, mVarZ2, mVarZ3, mVarZ4, mVarZ6, mVarZ5, mVarZ7, mVarZ8, dl.dl, dl.f665a, dl.gc, dl.m);
        kb = com.bytedance.sdk.component.dl.g.z.dl.z(mVarZ, mVarZ2, mVarZ3, mVarZ4, mVarZ6, mVarZ5, mVarZ7, mVarZ8);
    }

    public m(zw zwVar, tb.z zVar, com.bytedance.sdk.component.dl.g.z.g.e eVar, e eVar2) {
        this.wp = zwVar;
        this.i = zVar;
        this.z = eVar;
        this.v = eVar2;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public fv z(sy syVar, long j) {
        return this.pf.gz();
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void z(sy syVar) throws IOException {
        if (this.pf != null) {
            return;
        }
        fo foVarZ = this.v.z(g(syVar), syVar.a() != null);
        this.pf = foVarZ;
        foVarZ.gc().z(this.i.dl(), TimeUnit.MILLISECONDS);
        this.pf.m().z(this.i.a(), TimeUnit.MILLISECONDS);
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void z() throws IOException {
        this.v.g();
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void g() throws IOException {
        this.pf.gz().close();
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public h.z z(boolean z2) throws IOException {
        h.z zVarZ = z(this.pf.a());
        if (z2 && com.bytedance.sdk.component.dl.g.z.z.z.z(zVarZ) == 100) {
            return null;
        }
        return zVarZ;
    }

    public static List<dl> g(sy syVar) {
        com.bytedance.sdk.component.dl.g.fv fvVarDl = syVar.dl();
        ArrayList arrayList = new ArrayList(fvVarDl.z() + 4);
        arrayList.add(new dl(dl.dl, syVar.g()));
        arrayList.add(new dl(dl.f665a, com.bytedance.sdk.component.dl.g.z.dl.fo.z(syVar.z())));
        String strZ = syVar.z(HttpHeaders.HOST);
        if (strZ != null) {
            arrayList.add(new dl(dl.m, strZ));
        }
        arrayList.add(new dl(dl.gc, syVar.z().dl()));
        int iZ = fvVarDl.z();
        for (int i = 0; i < iZ; i++) {
            com.bytedance.sdk.component.dl.z.m mVarZ = com.bytedance.sdk.component.dl.z.m.z(fvVarDl.z(i).toLowerCase(Locale.US));
            if (!uy.contains(mVarZ)) {
                arrayList.add(new dl(mVarZ, fvVarDl.g(i)));
            }
        }
        return arrayList;
    }

    public static h.z z(List<dl> list) throws IOException {
        fv.z zVar = new fv.z();
        int size = list.size();
        com.bytedance.sdk.component.dl.g.z.dl.kb kbVarZ = null;
        for (int i = 0; i < size; i++) {
            dl dlVar = list.get(i);
            if (dlVar == null) {
                if (kbVarZ != null && kbVarZ.g == 100) {
                    zVar = new fv.z();
                    kbVarZ = null;
                }
            } else {
                com.bytedance.sdk.component.dl.z.m mVar = dlVar.e;
                String strZ = dlVar.gz.z();
                if (mVar.equals(dl.g)) {
                    kbVarZ = com.bytedance.sdk.component.dl.g.z.dl.kb.z("HTTP/1.1 ".concat(String.valueOf(strZ)));
                } else if (!kb.contains(mVar)) {
                    com.bytedance.sdk.component.dl.g.z.z.z.z(zVar, mVar.z(), strZ);
                }
            }
        }
        if (kbVarZ == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new h.z().z(io.HTTP_2).z(kbVarZ.g).z(kbVarZ.dl).z(zVar.z());
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public gk z(h hVar) throws IOException {
        return new com.bytedance.sdk.component.dl.g.z.dl.gz(hVar.z(HttpHeaders.CONTENT_TYPE), com.bytedance.sdk.component.dl.g.z.dl.gc.z(hVar), com.bytedance.sdk.component.dl.z.wp.z(new z(this.pf.e())));
    }

    @Override // com.bytedance.sdk.component.dl.g.z.dl.dl
    public void dl() {
        fo foVar = this.pf;
        if (foVar != null) {
            foVar.g(g.CANCEL);
        }
    }

    class z extends com.bytedance.sdk.component.dl.z.gz {
        long g;
        boolean z;

        z(js jsVar) {
            super(jsVar);
            this.z = false;
            this.g = 0L;
        }

        @Override // com.bytedance.sdk.component.dl.z.gz, com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            try {
                long jZ = g().z(dlVar, j);
                if (jZ > 0) {
                    this.g += jZ;
                }
                return jZ;
            } catch (IOException e) {
                z(e);
                throw e;
            }
        }

        @Override // com.bytedance.sdk.component.dl.z.gz, com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            z(null);
        }

        private void z(IOException iOException) {
            if (this.z) {
                return;
            }
            this.z = true;
            m.this.z.z(false, (com.bytedance.sdk.component.dl.g.z.dl.dl) m.this, this.g, iOException);
        }
    }
}
