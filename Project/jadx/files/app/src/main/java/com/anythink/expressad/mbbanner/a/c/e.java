package com.anythink.expressad.mbbanner.a.c;

import com.anythink.expressad.foundation.h.o;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class e implements c {
    private static final String a = "e";
    private c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.d.c f10806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10807d = false;

    public e(c cVar, com.anythink.expressad.d.c cVar2) {
        this.f10806c = cVar2;
        this.b = cVar;
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    com.anythink.expressad.d.c cVar = this.f10806c;
                    boolean z2 = false;
                    if (!list.get(0).A() && cVar != null && cVar.a() != 1.0d) {
                        if (new Random().nextDouble() > cVar.a()) {
                            z2 = true;
                        }
                    }
                    this.f10807d = z2;
                    String str = a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f10807d);
                    o.d(str, sb.toString());
                }
            } catch (Exception e2) {
                o.b(a, "Exception", e2);
            }
        }
        c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(list);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void b() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void c() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void d() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(String str) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        c cVar2 = this.b;
        if (cVar2 == null || this.f10807d) {
            return;
        }
        cVar2.a(cVar);
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
        c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(cVar, this.f10807d);
        }
    }

    private static boolean a(com.anythink.expressad.d.c cVar, boolean z2) {
        if (z2 || cVar == null || cVar.a() == 1.0d) {
            return false;
        }
        return new Random().nextDouble() > cVar.a();
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(boolean z2) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(z2);
        }
    }
}
