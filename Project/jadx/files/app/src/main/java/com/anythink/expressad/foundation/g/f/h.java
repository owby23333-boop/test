package com.anythink.expressad.foundation.g.f;

import android.os.Process;
import com.anythink.expressad.foundation.h.o;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static final String a = "h";
    private com.anythink.expressad.foundation.g.f.e.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f10576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f10577d;

    public h(SSLSocketFactory sSLSocketFactory, c cVar) {
        this.b = new com.anythink.expressad.foundation.g.f.e.b(sSLSocketFactory, null);
        this.f10576c = new com.anythink.expressad.foundation.g.f.f.a(this.b, cVar);
        this.f10577d = cVar;
    }

    private void b(i iVar) {
        try {
            this.f10577d.c(iVar);
            if (iVar.f()) {
                iVar.c();
                this.f10577d.b(iVar);
                this.f10577d.a(iVar);
            } else {
                this.f10577d.d(iVar);
                this.f10577d.a((i<?>) iVar, iVar.a(this.f10576c.a(iVar)));
            }
        } catch (com.anythink.expressad.foundation.g.f.a.a e2) {
            this.f10577d.a((i<?>) iVar, i.a(e2));
        } catch (Exception e3) {
            o.d(a, "Unhandled exception " + e3.getMessage());
            this.f10577d.a((i<?>) iVar, new com.anythink.expressad.foundation.g.f.a.a(4, null));
        }
    }

    public final void a(i iVar) {
        Process.setThreadPriority(10);
        try {
            this.f10577d.c(iVar);
            if (iVar.f()) {
                iVar.c();
                this.f10577d.b(iVar);
                this.f10577d.a(iVar);
            } else {
                this.f10577d.d(iVar);
                this.f10577d.a((i<?>) iVar, iVar.a(this.f10576c.a(iVar)));
            }
        } catch (com.anythink.expressad.foundation.g.f.a.a e2) {
            this.f10577d.a((i<?>) iVar, i.a(e2));
        } catch (Exception e3) {
            o.d(a, "Unhandled exception " + e3.getMessage());
            this.f10577d.a((i<?>) iVar, new com.anythink.expressad.foundation.g.f.a.a(4, null));
        }
    }
}
