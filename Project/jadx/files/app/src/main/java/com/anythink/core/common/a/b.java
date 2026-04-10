package com.anythink.core.common.a;

import com.anythink.core.common.b.n;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b b;
    final String a = b.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.core.common.c.f f6748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.core.common.c.e f6749d;

    private b() {
        if (n.a().g() != null) {
            this.f6748c = com.anythink.core.common.c.f.a(com.anythink.core.common.c.c.a(n.a().g()));
            this.f6749d = com.anythink.core.common.c.e.a(com.anythink.core.common.c.c.a(n.a().g()));
        }
    }

    public final void c(final com.anythink.core.common.e.g gVar) {
        if (gVar.W() != 1) {
            StringBuilder sb = new StringBuilder("adxOffer.getDspInstallIdUploadSwitch() = ");
            sb.append(gVar.W());
            sb.append(",not need to record install");
        } else if (gVar.D() == 1 || gVar.D() == 4) {
            n.a();
            n.b(new Runnable() { // from class: com.anythink.core.common.a.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    new StringBuilder("insertDspOfferInstallRecord dspOfferId:").append(gVar.U());
                    e eVar = new e();
                    eVar.a = gVar.T();
                    eVar.b = gVar.U();
                    eVar.f6750c = gVar.B();
                    b.this.f6749d.a(eVar);
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder("adxOffer.getClickType = ");
            sb2.append(gVar.D());
            sb2.append(",not need to record install");
        }
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public final void b(final com.anythink.core.common.e.g gVar) {
        new StringBuilder("updateDspOfferShowRecord dspOfferId:").append(gVar.U());
        n.a();
        n.b(new Runnable() { // from class: com.anythink.core.common.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = new f();
                fVar.a = gVar.T();
                fVar.b = gVar.U();
                fVar.f6751c = gVar.V();
                fVar.f6752d = 1;
                b.this.f6748c.b(fVar);
            }
        });
    }

    public final void b() {
        n.a();
        n.b(new Runnable() { // from class: com.anythink.core.common.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.f6748c.c();
            }
        });
    }

    public final List<d> b(int i2) {
        return this.f6749d.a(i2);
    }

    public final void a(final com.anythink.core.common.e.g gVar) {
        new StringBuilder("insertDspOfferShowRecord dspOfferId:").append(gVar.U());
        n.a();
        n.b(new Runnable() { // from class: com.anythink.core.common.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = new f();
                fVar.a = gVar.T();
                fVar.b = gVar.U();
                fVar.f6751c = gVar.V();
                fVar.f6752d = 0;
                b.this.f6748c.a(fVar);
            }
        });
    }

    public final List<d> a(int i2) {
        return this.f6748c.a(i2);
    }
}
