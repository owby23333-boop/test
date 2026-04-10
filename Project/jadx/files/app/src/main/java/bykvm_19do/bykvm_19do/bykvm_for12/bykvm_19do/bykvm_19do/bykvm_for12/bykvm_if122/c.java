package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.d;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    z f854e;

    class a implements f {
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a a;

        a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
            this.a = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, a0 a0Var) throws IOException {
            if (this.a != null) {
                HashMap map = new HashMap();
                if (a0Var != null) {
                    r rVarM = a0Var.m();
                    if (rVarM != null) {
                        for (int i2 = 0; i2 < rVarM.b(); i2++) {
                            map.put(rVarM.a(i2), rVarM.b(i2));
                        }
                    }
                    this.a.a(c.this, new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b(a0Var.n(), a0Var.k(), a0Var.o(), map, a0Var.i().l(), a0Var.t(), a0Var.r()));
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, IOException iOException) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar = this.a;
            if (aVar != null) {
                aVar.a(c.this, iOException);
            }
        }
    }

    public c(v vVar) {
        super(vVar);
        this.f854e = null;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
        IOException iOException;
        y.a aVar2 = new y.a();
        if (TextUtils.isEmpty(this.f853d)) {
            iOException = new IOException("Url is Empty");
        } else {
            try {
                aVar2.b(this.f853d);
                if (this.f854e != null) {
                    a(aVar2);
                    aVar2.a((Object) a());
                    this.a.a(aVar2.a(this.f854e).a()).a(new a(aVar));
                    return;
                }
                if (aVar == null) {
                    return;
                } else {
                    iOException = new IOException("RequestBody is null, content type is not support!!");
                }
            } catch (IllegalArgumentException unused) {
                iOException = new IOException("Url is not a valid HTTP or HTTPS URL");
            }
        }
        aVar.a(this, iOException);
    }

    public void a(String str, byte[] bArr) {
        this.f854e = z.a(u.a(str), bArr);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b b() {
        String str;
        y.a aVar = new y.a();
        if (TextUtils.isEmpty(this.f853d)) {
            str = "execute: Url is Empty";
        } else {
            try {
                aVar.b(this.f853d);
                if (this.f854e != null) {
                    a(aVar);
                    aVar.a((Object) a());
                    try {
                        a0 a0VarI = this.a.a(aVar.a(this.f854e).a()).i();
                        if (a0VarI == null) {
                            return null;
                        }
                        HashMap map = new HashMap();
                        r rVarM = a0VarI.m();
                        if (rVarM == null) {
                            return null;
                        }
                        for (int i2 = 0; i2 < rVarM.b(); i2++) {
                            map.put(rVarM.a(i2), rVarM.b(i2));
                        }
                        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b(a0VarI.n(), a0VarI.k(), a0VarI.o(), map, a0VarI.i().l(), a0VarI.t(), a0VarI.r());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                str = "RequestBody is null, content type is not support!!";
            } catch (IllegalArgumentException unused) {
                str = "execute: Url is not a valid HTTP or HTTPS URL";
            }
        }
        d.a("PostExecutor", str);
        return null;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f854e = z.a(u.a("application/json; charset=utf-8"), str);
    }
}
