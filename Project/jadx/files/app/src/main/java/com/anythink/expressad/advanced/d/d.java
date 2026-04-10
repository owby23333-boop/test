package com.anythink.expressad.advanced.d;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.out.o;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.anythink.expressad.advanced.b.b {
    private static final String a = "NativeAdvancedShowListenerImpl";
    private o b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f8213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f8215e;

    public d(c cVar, o oVar, double d2, com.anythink.expressad.foundation.d.c cVar2) {
        this.f8215e = cVar;
        this.b = oVar;
        this.f8213c = cVar2;
        this.f8214d = a(d2, cVar2);
    }

    private void g() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void a() {
        c cVar = this.f8215e;
        if (cVar != null) {
            cVar.f8191d = true;
        }
        StringBuffer stringBuffer = new StringBuffer("load_to=0&allow_skip=");
        stringBuffer.append(this.f8215e.d());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        o oVar = this.b;
        if (oVar == null || this.f8214d) {
            return;
        }
        oVar.b();
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void b() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void c() {
        o oVar = this.b;
        if (oVar != null) {
            oVar.f();
            c cVar = this.f8215e;
            if (cVar != null) {
                cVar.f8191d = false;
            }
        }
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void d() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void e() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void f() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        o oVar = this.b;
        if (oVar == null || this.f8214d) {
            return;
        }
        oVar.a(cVar);
    }

    private static boolean a(double d2, com.anythink.expressad.foundation.d.c cVar) {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a aVarC = com.anythink.expressad.d.b.c();
            long jL = aVarC.l() * 1000;
            long jX = aVarC.x() * 1000;
            com.anythink.expressad.foundation.h.o.d(a, "cbp : " + d2 + " plct : " + jX + " plctb : " + jL);
            if (cVar != null) {
                if (cVar.a(jX, jL)) {
                    cVar.e(1);
                    return true;
                }
                cVar.e(0);
            }
            if (cVar == null || cVar.A() || d2 == 1.0d) {
                return false;
            }
            double dNextDouble = new Random().nextDouble();
            StringBuilder sb = new StringBuilder("hit : ");
            sb.append(dNextDouble);
            sb.append(" ");
            sb.append(dNextDouble > d2);
            com.anythink.expressad.foundation.h.o.d(a, sb.toString());
            return dNextDouble > d2;
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.b(a, "CBPERROR", e2);
            return false;
        }
    }
}
