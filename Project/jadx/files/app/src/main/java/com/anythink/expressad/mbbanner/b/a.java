package com.anythink.expressad.mbbanner.b;

import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.y;
import com.anythink.expressad.mbbanner.a.c.b;
import com.anythink.expressad.mbbanner.a.d.c;
import com.anythink.expressad.out.TemplateBannerView;
import com.anythink.expressad.out.h;
import com.anythink.expressad.out.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static String b = "BannerController";
    i a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TemplateBannerView f10862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10865j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private h f10867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f10868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f10869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.anythink.expressad.d.c f10870o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f10871p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10872q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f10873r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f10874s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f10875t;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10866k = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.c.c f10876u = new com.anythink.expressad.mbbanner.a.c.c() { // from class: com.anythink.expressad.mbbanner.b.a.1
        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(List<com.anythink.expressad.foundation.d.c> list) {
            if (a.this.f10867l != null) {
                a.this.f10867l.a();
            }
            o.d(a.b, "onShowSuccessed:");
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void b() {
            if (a.this.f10867l != null) {
                h unused = a.this.f10867l;
                a.this.f10875t = true;
                com.anythink.expressad.mbbanner.a.d.a aVarA = com.anythink.expressad.mbbanner.a.d.a.a();
                String unused2 = a.this.f10859d;
                aVarA.a(2, a.this.f10858c);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void c() {
            if (a.this.f10867l != null) {
                h unused = a.this.f10867l;
                a.this.f10875t = false;
                com.anythink.expressad.mbbanner.a.d.a aVarA = com.anythink.expressad.mbbanner.a.d.a.a();
                String unused2 = a.this.f10859d;
                String str = a.this.f10858c;
                new com.anythink.expressad.mbbanner.a.b.d(a.this.f10864i + "x" + a.this.f10863h, a.this.f10865j * 1000);
                b unused3 = a.this.f10877v;
                aVarA.a(3, str);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void d() {
            if (a.this.f10867l != null) {
                a.this.f10867l.f();
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
            if (a.this.f10867l == null || z2) {
                return;
            }
            a.this.f10867l.b();
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(String str) {
            a.this.a(str);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (a.this.f10867l != null) {
                a.this.f10867l.a(cVar);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a() {
            if (a.this.f10867l != null) {
                h unused = a.this.f10867l;
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(boolean z2) {
            if (!z2) {
                com.anythink.expressad.mbbanner.a.d.a aVarA = com.anythink.expressad.mbbanner.a.d.a.a();
                String unused = a.this.f10859d;
                String str = a.this.f10858c;
                new com.anythink.expressad.mbbanner.a.b.d(a.this.f10864i + "x" + a.this.f10863h, a.this.f10865j * 1000);
                b unused2 = a.this.f10877v;
                aVarA.a(3, str);
                return;
            }
            com.anythink.expressad.mbbanner.a.d.a aVarA2 = com.anythink.expressad.mbbanner.a.d.a.a();
            String unused3 = a.this.f10859d;
            aVarA2.a(2, a.this.f10858c);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private b f10877v = new b() { // from class: com.anythink.expressad.mbbanner.b.a.2
        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a(d dVar) {
            a.this.f10868m = dVar;
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void b() {
            if (a.this.f10867l != null) {
                a.this.f10867l.a(com.anythink.expressad.mbbanner.a.a.f10757c);
            }
            o.d(a.b, "onResourceFail:");
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a(String str) {
            if (a.this.f10867l != null) {
                a.this.f10867l.a(str);
            }
            o.d(a.b, "onCampaignFail:".concat(String.valueOf(str)));
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a() throws Throwable {
            d unused = a.this.f10868m;
            if (a.this.f10862g != null) {
                a.j(a.this);
                a.this.h();
            }
        }
    };

    public a(TemplateBannerView templateBannerView, i iVar, String str, String str2) {
        this.f10862g = templateBannerView;
        if (iVar != null) {
            this.f10863h = iVar.a();
            this.f10864i = iVar.b();
        }
        this.a = iVar;
        this.f10858c = str2;
        this.f10859d = str;
        com.anythink.expressad.d.b.a();
        this.f10870o = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f10858c);
        if (this.f10870o == null) {
            this.f10870o = com.anythink.expressad.d.c.c(this.f10858c);
        }
        if (this.f10866k == -1) {
            int iB = this.f10870o.b();
            if (iB > 0) {
                if (iB < 10) {
                    iB = 10;
                } else if (iB > 180) {
                    iB = 180;
                }
            }
            this.f10865j = iB;
        }
        if (this.f10861f == 0) {
            this.f10860e = this.f10870o.d() == 1;
            c cVar = this.f10869n;
            if (cVar != null) {
                cVar.a(this.f10860e);
            }
        }
    }

    private static int a(int i2) {
        if (i2 <= 0) {
            return i2;
        }
        if (i2 < 10) {
            return 10;
        }
        if (i2 > 180) {
            return 180;
        }
        return i2;
    }

    private static boolean i() {
        return true;
    }

    private static void j() {
    }

    static /* synthetic */ boolean j(a aVar) {
        aVar.f10874s = true;
        return true;
    }

    private void l() {
        k();
        c cVar = this.f10869n;
        if (cVar != null) {
            cVar.b(this.f10871p);
            this.f10869n.c(this.f10872q);
        }
    }

    private void f() {
        com.anythink.expressad.d.b.a();
        this.f10870o = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f10858c);
        if (this.f10870o == null) {
            this.f10870o = com.anythink.expressad.d.c.c(this.f10858c);
        }
        if (this.f10866k == -1) {
            int iB = this.f10870o.b();
            if (iB > 0) {
                if (iB < 10) {
                    iB = 10;
                } else if (iB > 180) {
                    iB = 180;
                }
            }
            this.f10865j = iB;
        }
        if (this.f10861f == 0) {
            this.f10860e = this.f10870o.d() == 1;
            c cVar = this.f10869n;
            if (cVar != null) {
                cVar.a(this.f10860e);
            }
        }
    }

    private void g() {
        com.anythink.expressad.d.b.a();
        this.f10870o = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f10858c);
        if (this.f10870o == null) {
            this.f10870o = com.anythink.expressad.d.c.c(this.f10858c);
        }
        if (this.f10866k == -1) {
            int iB = this.f10870o.b();
            if (iB > 0) {
                if (iB < 10) {
                    iB = 10;
                } else if (iB > 180) {
                    iB = 180;
                }
            }
            this.f10865j = iB;
        }
        if (this.f10861f == 0) {
            this.f10860e = this.f10870o.d() == 1;
            c cVar = this.f10869n;
            if (cVar != null) {
                cVar.a(this.f10860e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws Throwable {
        if (this.f10873r || !this.f10874s) {
            return;
        }
        if (this.f10868m != null) {
            if (this.f10869n == null) {
                this.f10869n = new c(this.f10862g, this.f10876u, this.f10859d, this.f10858c, this.f10860e, this.f10870o);
            }
            this.f10869n.a(this.a);
            this.f10869n.b(this.f10871p);
            this.f10869n.c(this.f10872q);
            this.f10869n.a(this.f10860e, this.f10861f);
            this.f10869n.a(this.f10868m);
        } else {
            a(com.anythink.expressad.mbbanner.a.a.f10762h);
        }
        this.f10874s = false;
    }

    private void k() {
        TemplateBannerView templateBannerView = this.f10862g;
        if (templateBannerView != null) {
            if (!this.f10871p || !this.f10872q || this.f10875t || y.a(templateBannerView)) {
                com.anythink.expressad.mbbanner.a.d.a.a().a(2, this.f10858c);
            } else {
                com.anythink.expressad.mbbanner.a.d.a aVarA = com.anythink.expressad.mbbanner.a.d.a.a();
                String str = this.f10858c;
                new com.anythink.expressad.mbbanner.a.b.d(this.f10864i + "x" + this.f10863h, this.f10865j * 1000);
                aVarA.a(3, str);
            }
            if (this.f10871p) {
                return;
            }
            com.anythink.expressad.mbbanner.a.d.a.a().a(4, this.f10858c);
            com.anythink.expressad.mbbanner.a.d.a.a().a(this.f10858c);
        }
    }

    public final void b() {
        this.f10873r = true;
        if (this.f10867l != null) {
            this.f10867l = null;
        }
        if (this.f10877v != null) {
            this.f10877v = null;
        }
        if (this.f10876u != null) {
            this.f10876u = null;
        }
        if (this.f10862g != null) {
            this.f10862g = null;
        }
        com.anythink.expressad.mbbanner.a.d.a.a().a(4, this.f10858c);
        com.anythink.expressad.mbbanner.a.d.a.a().a(this.f10858c);
        com.anythink.expressad.mbbanner.a.d.a.a().b();
        c cVar = this.f10869n;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void c(boolean z2) {
        this.f10872q = z2;
        l();
    }

    public final void d() {
        com.anythink.expressad.mbbanner.a.d.a aVarA = com.anythink.expressad.mbbanner.a.d.a.a();
        String str = this.f10858c;
        new com.anythink.expressad.mbbanner.a.b.d(this.f10864i + "x" + this.f10863h, this.f10865j * 1000);
        aVarA.a(3, str);
    }

    public final void c() {
        com.anythink.expressad.mbbanner.a.d.a aVarA = com.anythink.expressad.mbbanner.a.d.a.a();
        String str = this.f10858c;
        new com.anythink.expressad.mbbanner.a.b.d(this.f10864i + "x" + this.f10863h, this.f10865j * 1000);
        aVarA.a(4, str);
    }

    public final String a() {
        d dVar = this.f10868m;
        return (dVar == null || dVar.f() == null) ? "" : this.f10868m.f();
    }

    public final void a(i iVar) {
        if (iVar != null) {
            this.f10863h = iVar.a();
            this.f10864i = iVar.b();
        }
    }

    public final void a(boolean z2) {
        this.f10860e = z2;
        this.f10861f = z2 ? 1 : 2;
    }

    public final void a(d dVar) {
        this.f10868m = dVar;
        com.anythink.expressad.mbbanner.a.d.a.a().a(this.f10858c, dVar, this.f10877v);
    }

    public final void a(h hVar) {
        this.f10867l = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        h hVar = this.f10867l;
        if (hVar != null) {
            hVar.a(str);
        }
        o.d(b, "showFailed:".concat(String.valueOf(str)));
    }

    public final void b(boolean z2) {
        this.f10871p = z2;
        l();
        h();
    }

    public final void a(int i2, int i3, int i4, int i5) {
        c cVar = this.f10869n;
        if (cVar != null) {
            cVar.a(i2, i3, i4, i5);
        }
    }
}
