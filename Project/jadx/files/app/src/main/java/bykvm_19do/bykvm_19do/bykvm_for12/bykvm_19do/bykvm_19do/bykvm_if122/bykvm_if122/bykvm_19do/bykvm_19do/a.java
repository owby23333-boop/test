package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.c;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.message.utils.HttpRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements t {
    final d a;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a$a, reason: collision with other inner class name */
    class C0027a implements s {
        boolean a;
        final /* synthetic */ e b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f918d;

        C0027a(a aVar, e eVar, b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
            this.b = eVar;
            this.f917c = bVar;
            this.f918d = dVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                long jA = this.b.a(cVar, j2);
                if (jA != -1) {
                    cVar.a(this.f918d.a(), cVar.o() - jA, jA);
                    this.f918d.h();
                    return jA;
                }
                if (!this.a) {
                    this.a = true;
                    this.f918d.close();
                }
                return -1L;
            } catch (IOException e2) {
                if (!this.a) {
                    this.a = true;
                    this.f917c.a();
                }
                throw e2;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t b() {
            return this.b.b();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.a && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.a = true;
                this.f917c.a();
            }
            this.b.close();
        }
    }

    public a(d dVar) {
        this.a = dVar;
    }

    private static a0 a(a0 a0Var) {
        return (a0Var == null || a0Var.i() == null) ? a0Var : a0Var.p().a((b0) null).a();
    }

    private a0 a(b bVar, a0 a0Var) throws IOException {
        r rVarB;
        if (bVar == null || (rVarB = bVar.b()) == null) {
            return a0Var;
        }
        return a0Var.p().a(new h(a0Var.b("Content-Type"), a0Var.i().i(), l.a(new C0027a(this, a0Var.i().k(), bVar, l.a(rVarB))))).a();
    }

    private static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar2) {
        r.a aVar = new r.a();
        int iB = rVar.b();
        for (int i2 = 0; i2 < iB; i2++) {
            String strA = rVar.a(i2);
            String strB = rVar.b(i2);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (!a(strA) || rVar2.a(strA) == null)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(aVar, strA, strB);
            }
        }
        int iB2 = rVar2.b();
        for (int i3 = 0; i3 < iB2; i3++) {
            String strA2 = rVar2.a(i3);
            if (!"Content-Length".equalsIgnoreCase(strA2) && a(strA2)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(aVar, strA2, rVar2.b(i3));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || com.anythink.expressad.foundation.g.f.g.c.f10570c.equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpRequest.HEADER_PROXY_AUTHORIZATION.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || DownloadUtils.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0.a aVarA;
        d dVar = this.a;
        a0 a0VarB = dVar != null ? dVar.b(aVar.b()) : null;
        c cVarA = new c.a(System.currentTimeMillis(), aVar.b(), a0VarB).a();
        y yVar = cVarA.a;
        a0 a0Var = cVarA.b;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(cVarA);
        }
        if (a0VarB != null && a0Var == null) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a0VarB.i());
        }
        if (yVar == null && a0Var == null) {
            aVarA = new a0.a().a(aVar.b()).a(w.HTTP_1_1).a(TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_FAILED).a("Unsatisfiable Request (only-if-cached)").a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1143c).b(-1L).a(System.currentTimeMillis());
        } else {
            if (yVar != null) {
                try {
                    a0 a0VarA = aVar.a(yVar);
                    if (a0VarA == null && a0VarB != null) {
                    }
                    if (a0Var != null) {
                        if (a0VarA.k() == 304) {
                            a0 a0VarA2 = a0Var.p().a(a(a0Var.m(), a0VarA.m())).b(a0VarA.t()).a(a0VarA.r()).a(a(a0Var)).b(a(a0VarA)).a();
                            a0VarA.i().close();
                            this.a.a();
                            this.a.a(a0Var, a0VarA2);
                            return a0VarA2;
                        }
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a0Var.i());
                    }
                    a0 a0VarA3 = a0VarA.p().a(a(a0Var)).b(a(a0VarA)).a();
                    if (this.a == null) {
                        return a0VarA3;
                    }
                    if (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.b(a0VarA3) && c.a(a0VarA3, yVar)) {
                        return a(this.a.a(a0VarA3), a0VarA3);
                    }
                    if (!f.a(yVar.e())) {
                        return a0VarA3;
                    }
                    try {
                        this.a.a(yVar);
                        return a0VarA3;
                    } catch (IOException unused) {
                        return a0VarA3;
                    }
                } finally {
                    if (a0VarB != null) {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a0VarB.i());
                    }
                }
            }
            aVarA = a0Var.p().a(a(a0Var));
        }
        return aVarA.a();
    }
}
