package com.anythink.basead.d.a;

import android.text.TextUtils;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.out.TemplateBannerView;
import com.anythink.expressad.out.h;
import com.anythink.expressad.out.o;
import com.anythink.expressad.splash.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f5971c;
    private final String b = b.class.getSimpleName();
    ConcurrentHashMap<String, g> a = new ConcurrentHashMap<>(2);

    /* JADX INFO: renamed from: com.anythink.basead.d.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.g a;
        final /* synthetic */ j b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f5972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f5973d;

        AnonymousClass1(com.anythink.core.common.e.g gVar, j jVar, d dVar, a aVar) {
            this.a = gVar;
            this.b = jVar;
            this.f5972c = dVar;
            this.f5973d = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = new c(n.a().g(), "", TextUtils.isEmpty(this.a.S()) ? this.b.f7302c : this.a.S());
            cVar.b(this.b.f7312m.p() == 0);
            int iN = ((int) this.b.f7312m.n()) / 1000;
            if (iN <= 2) {
                cVar.a(2);
            } else if (iN >= 10) {
                cVar.a(10);
            } else {
                cVar.a(iN);
            }
            cVar.a(this.b.f7312m.x() == 0);
            cVar.f();
            ArrayList<com.anythink.expressad.foundation.d.c> arrayList = this.f5972c.J;
            if (arrayList != null && arrayList.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar2 : arrayList) {
                    if (cVar2 != null) {
                        String strC = cVar2.c();
                        if (!TextUtils.isEmpty(strC)) {
                            boolean z2 = this.b.f7312m.x() == 0;
                            boolean z3 = com.anythink.expressad.shake.a.a().b() && this.b.f7312m.M() == 1;
                            strC = b.b(b.c(strC, z2), z3, this.b.f7312m.N(), this.b.f7312m.O());
                            if (!z3 && !z2) {
                                strC = b.b(strC, true);
                            } else if (z3) {
                                strC = b.b(strC, false);
                            }
                        }
                        cVar2.a(strC);
                    }
                }
            }
            cVar.a(new com.anythink.expressad.out.d() { // from class: com.anythink.basead.d.a.b.1.1
                @Override // com.anythink.expressad.out.d
                public final void a() {
                    c cVar3 = (c) b.this.a.remove(AnonymousClass1.this.b.b + AnonymousClass1.this.b.a);
                    if (cVar3 != null) {
                        a aVar = AnonymousClass1.this.f5973d;
                        if (aVar != null) {
                            aVar.a(cVar3);
                            return;
                        }
                        return;
                    }
                    if (AnonymousClass1.this.f5973d != null) {
                        AnonymousClass1.this.f5973d.a(f.a(f.f5908l, "Resource download fail."));
                    }
                }

                @Override // com.anythink.expressad.out.d
                public final void b() {
                }

                @Override // com.anythink.expressad.out.d
                public final void a(String str) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    b.a(b.this, str, anonymousClass1.b, anonymousClass1.f5973d);
                }
            });
            b.this.a.put(this.b.b + this.b.a, cVar);
            cVar.a(this.f5972c);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.d.a.b$2, reason: invalid class name */
    final class AnonymousClass2 implements h {
        final /* synthetic */ j a;
        final /* synthetic */ a b;

        AnonymousClass2(j jVar, a aVar) {
            this.a = jVar;
            this.b = aVar;
        }

        @Override // com.anythink.expressad.out.h
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
        }

        @Override // com.anythink.expressad.out.h
        public final void a(String str) {
            b.a(b.this, str, this.a, this.b);
        }

        @Override // com.anythink.expressad.out.h
        public final void b() {
        }

        @Override // com.anythink.expressad.out.h
        public final void c() {
        }

        @Override // com.anythink.expressad.out.h
        public final void d() {
        }

        @Override // com.anythink.expressad.out.h
        public final void e() {
        }

        @Override // com.anythink.expressad.out.h
        public final void f() {
        }

        @Override // com.anythink.expressad.out.h
        public final void a() {
            TemplateBannerView templateBannerView = (TemplateBannerView) b.this.a.remove(this.a.b + this.a.a);
            if (templateBannerView != null) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(templateBannerView);
                    return;
                }
                return;
            }
            if (this.b != null) {
                this.b.a(f.a(f.f5908l, "Resource download fail."));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.d.a.b$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.g a;
        final /* synthetic */ j b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f5977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f5978d;

        AnonymousClass4(com.anythink.core.common.e.g gVar, j jVar, a aVar, d dVar) {
            this.a = gVar;
            this.b = jVar;
            this.f5977c = aVar;
            this.f5978d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.advanced.d.c cVar = new com.anythink.expressad.advanced.d.c("", TextUtils.isEmpty(this.a.S()) ? this.b.f7302c : this.a.S(), n.a().g());
            cVar.a(new o() { // from class: com.anythink.basead.d.a.b.4.1
                @Override // com.anythink.expressad.out.o
                public final void a(com.anythink.expressad.foundation.d.c cVar2) {
                }

                @Override // com.anythink.expressad.out.o
                public final void a(String str) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    b.a(b.this, str, anonymousClass4.b, anonymousClass4.f5977c);
                }

                @Override // com.anythink.expressad.out.o
                public final void b() {
                }

                @Override // com.anythink.expressad.out.o
                public final void c() {
                }

                @Override // com.anythink.expressad.out.o
                public final void d() {
                }

                @Override // com.anythink.expressad.out.o
                public final void e() {
                }

                @Override // com.anythink.expressad.out.o
                public final void f() {
                }

                @Override // com.anythink.expressad.out.o
                public final void a() {
                    com.anythink.expressad.advanced.d.c cVar2 = (com.anythink.expressad.advanced.d.c) b.this.a.remove(AnonymousClass4.this.b.b + AnonymousClass4.this.b.a);
                    if (cVar2 != null) {
                        a aVar = AnonymousClass4.this.f5977c;
                        if (aVar != null) {
                            aVar.a(cVar2);
                            return;
                        }
                        return;
                    }
                    if (AnonymousClass4.this.f5977c != null) {
                        AnonymousClass4.this.f5977c.a(f.a(f.f5909m, f.H));
                    }
                }
            });
            b.this.a.put(this.b.b + this.b.a, cVar);
            cVar.a(this.f5978d);
        }
    }

    protected interface a {
        void a(e eVar);

        void a(g gVar);
    }

    private b() {
    }

    private void b(com.anythink.core.common.e.g gVar, j jVar, d dVar, a aVar) {
        n.a().a(new AnonymousClass1(gVar, jVar, dVar, aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.anythink.core.common.e.g r10, com.anythink.core.common.e.j r11, com.anythink.expressad.foundation.d.d r12, com.anythink.basead.d.a.b.a r13) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.a.b.c(com.anythink.core.common.e.g, com.anythink.core.common.e.j, com.anythink.expressad.foundation.d.d, com.anythink.basead.d.a.b$a):void");
    }

    private void d(com.anythink.core.common.e.g gVar, final j jVar, d dVar, final a aVar) {
        com.anythink.expressad.reward.b.a aVar2 = new com.anythink.expressad.reward.b.a();
        String strS = TextUtils.isEmpty(gVar.S()) ? jVar.f7302c : gVar.S();
        int i2 = jVar.f7309j;
        if (i2 == 1) {
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), strS, false);
            aVar2.a(false);
        } else if (i2 == 3) {
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), strS, true);
            aVar2.a(true);
        }
        aVar2.a(jVar.f7312m.y() == 0 ? 1 : 2);
        aVar2.a("", strS);
        com.anythink.expressad.videocommon.e.d dVarA = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), strS, false);
        if (jVar.f7312m.z() >= 0) {
            dVarA.a(jVar.f7312m.z());
        }
        if (jVar.f7309j == 1) {
            dVarA.l();
        }
        ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVar.J;
        if (arrayList != null && arrayList.size() > 0) {
            for (com.anythink.expressad.foundation.d.c cVar : arrayList) {
                if (cVar != null) {
                    boolean z2 = com.anythink.expressad.shake.a.a().b() && jVar.f7312m.M() == 1;
                    boolean z3 = jVar.f7312m.x() == 0;
                    String strI = cVar.I();
                    if (!TextUtils.isEmpty(strI)) {
                        cVar.k(b(c(strI, z3), z2, jVar.f7312m.N(), jVar.f7312m.O()));
                    }
                    String strP = cVar.P();
                    if (!TextUtils.isEmpty(strP)) {
                        cVar.n(b(c(strP, z3), z2, jVar.f7312m.N(), jVar.f7312m.O()));
                    }
                    c.C0205c c0205cM = cVar.M();
                    boolean z4 = jVar.f7312m.u() == 1;
                    if (c0205cM != null) {
                        String strE = c0205cM.e();
                        if (!TextUtils.isEmpty(strE)) {
                            c0205cM.a(c(strE, z4));
                        }
                    }
                }
            }
        }
        aVar2.a(new com.anythink.expressad.videocommon.d.a() { // from class: com.anythink.basead.d.a.b.3
            @Override // com.anythink.expressad.videocommon.d.a
            public final void a() {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void a(com.anythink.expressad.foundation.d.c cVar2) {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void a(String str) {
                b.a(b.this, str, jVar, aVar);
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void a(boolean z5, String str, float f2) {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void b() {
                com.anythink.expressad.reward.b.a aVar3 = (com.anythink.expressad.reward.b.a) b.this.a.remove(jVar.b + jVar.a);
                if (aVar3 == null || !aVar3.isReady()) {
                    if (aVar != null) {
                        aVar.a(f.a(f.f5908l, "Resource download fail."));
                        return;
                    }
                    return;
                }
                a aVar4 = aVar;
                if (aVar4 != null) {
                    aVar4.a(aVar3);
                }
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void b(String str) {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void c() {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void d() {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void e() {
            }

            @Override // com.anythink.expressad.videocommon.d.a
            public final void f() {
            }
        });
        this.a.put(jVar.b + jVar.a, aVar2);
        aVar2.a(dVar);
    }

    private void e(com.anythink.core.common.e.g gVar, j jVar, d dVar, a aVar) {
        n.a().a(new AnonymousClass4(gVar, jVar, aVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, boolean z2, int i2, long j2) {
        String strReplace;
        String strReplaceAll;
        if (z2) {
            if (str.contains("shake_show")) {
                strReplace = str.replace("shake_show=0", "shake_show=1");
            } else {
                strReplace = str + "&shake_show=1";
            }
        } else if (str.contains("shake_show")) {
            strReplace = str.replace("shake_show=1", "shake_show=0");
        } else {
            strReplace = str + "&shake_show=0";
        }
        if (strReplace.contains("shake_time")) {
            strReplaceAll = strReplace.replaceAll("(shake_time=[^&]*)", "shake_time=" + (j2 / 1000));
        } else {
            strReplaceAll = strReplace + "&shake_time=" + (j2 / 1000);
        }
        if (strReplaceAll.contains("shake_strength")) {
            return strReplaceAll.replaceAll("(shake_strength=[^&]*)", "shake_strength=".concat(String.valueOf(i2)));
        }
        return strReplaceAll + "&shake_strength=" + i2;
    }

    public static b a() {
        if (f5971c == null) {
            synchronized (b.class) {
                if (f5971c == null) {
                    f5971c = new b();
                }
            }
        }
        return f5971c;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.core.common.e.g r11, com.anythink.core.common.e.j r12, com.anythink.expressad.foundation.d.d r13, com.anythink.basead.d.a.b.a r14) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.a.b.a(com.anythink.core.common.e.g, com.anythink.core.common.e.j, com.anythink.expressad.foundation.d.d, com.anythink.basead.d.a.b$a):void");
    }

    static /* synthetic */ String b(String str, boolean z2) {
        if (z2) {
            if (str.contains("hdbtn")) {
                return str.replace("hdbtn=1", "hdbtn=0");
            }
            return str + "&hdbtn=0";
        }
        if (str.contains("hdbtn")) {
            return str.replace("hdbtn=0", "hdbtn=1");
        }
        return str + "&hdbtn=1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, boolean z2) {
        if (z2) {
            if (str.contains(com.anythink.expressad.video.dynview.a.a.Q)) {
                return str.replace("alecfc=0", "alecfc=1");
            }
            return str + "&alecfc=1";
        }
        if (str.contains(com.anythink.expressad.video.dynview.a.a.Q)) {
            return str.replace("alecfc=1", "alecfc=0");
        }
        return str + "&alecfc=0";
    }

    private void a(String str, j jVar, a aVar) {
        this.a.remove(jVar.b + jVar.a);
        if (aVar != null) {
            aVar.a(f.a(f.f5908l, str));
        }
    }

    private static String d(String str, boolean z2) {
        if (z2) {
            if (str.contains("hdbtn")) {
                return str.replace("hdbtn=1", "hdbtn=0");
            }
            return str + "&hdbtn=0";
        }
        if (str.contains("hdbtn")) {
            return str.replace("hdbtn=0", "hdbtn=1");
        }
        return str + "&hdbtn=1";
    }

    public static void a(com.anythink.core.common.e.g gVar, com.anythink.expressad.foundation.d.c cVar) {
        gVar.w(cVar.ba());
        gVar.n(cVar.bd());
        gVar.l(cVar.bb());
        gVar.m(cVar.bc());
        gVar.v(cVar.ad());
        gVar.u(cVar.af());
        ac acVarX = gVar.X();
        if (acVarX == null) {
            acVarX = new ac();
            gVar.a(acVarX);
        }
        com.anythink.expressad.foundation.d.n nVarL = cVar.L();
        if (nVarL != null) {
            acVarX.b(nVarL.a());
            acVarX.c(nVarL.b());
            acVarX.d(nVarL.c());
        }
        a((i) gVar, cVar);
    }

    public static void a(com.anythink.core.common.e.g gVar, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<com.anythink.expressad.foundation.d.c> it = list.iterator();
        while (it.hasNext()) {
            it.next().t(gVar.v());
        }
    }

    public static void a(j jVar, List<com.anythink.expressad.foundation.d.c> list) {
        int i2 = jVar.f7309j;
        if (i2 == 1 || i2 == 3) {
            list.get(0).a(jVar.f7312m.z());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.basead.a.c a(com.anythink.basead.a.c r6, com.anythink.expressad.foundation.d.c r7) {
        /*
            com.anythink.core.common.e.i r0 = r6.b()
            com.anythink.core.common.e.k r0 = r0.k()
            com.anythink.core.common.e.i r1 = r6.b()
            java.lang.String r1 = r1.p()
            java.lang.String r2 = r7.aZ()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L22
            com.anythink.core.common.e.i r0 = r6.b()
            a(r0, r7)
            return r6
        L22:
            com.anythink.core.common.e.g r1 = new com.anythink.core.common.e.g
            r1.<init>()
            a(r1, r7)
            java.lang.String r2 = r7.aZ()
            r1.j(r2)
            int r2 = r7.Q()
            r3 = 2
            if (r2 == 0) goto L64
            r4 = 1
            if (r2 == r4) goto L60
            if (r2 == r3) goto L60
            r4 = 4
            r5 = 3
            if (r2 == r5) goto L5c
            if (r2 == r4) goto L58
            r4 = 5
            if (r2 == r4) goto L64
            r4 = 8
            if (r2 == r4) goto L58
            r4 = 9
            if (r2 == r4) goto L64
            r3 = 12
            if (r2 == r3) goto L53
            goto L67
        L53:
            r2 = 6
            r1.e(r2)
            goto L67
        L58:
            r1.e(r5)
            goto L67
        L5c:
            r1.e(r4)
            goto L67
        L60:
            r1.e(r4)
            goto L67
        L64:
            r1.e(r3)
        L67:
            com.anythink.expressad.foundation.d.a r7 = r7.aG()
            if (r7 == 0) goto L90
            java.lang.String r2 = r7.b()
            r1.N(r2)
            java.lang.String r2 = r7.f()
            r1.y(r2)
            java.lang.String r2 = r7.e()
            r1.z(r2)
            java.lang.String r2 = r7.c()
            r1.A(r2)
            java.lang.String r7 = r7.a()
            r1.B(r7)
        L90:
            com.anythink.core.common.e.j r6 = r6.c()
            com.anythink.basead.a.c r7 = new com.anythink.basead.a.c
            com.anythink.core.common.b.n r2 = com.anythink.core.common.b.n.a()
            android.content.Context r2 = r2.g()
            r7.<init>(r2, r6, r1)
            r1.a(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.a.b.a(com.anythink.basead.a.c, com.anythink.expressad.foundation.d.c):com.anythink.basead.a.c");
    }

    public static void a(i iVar, com.anythink.expressad.foundation.d.c cVar) {
        String[] strArrL;
        com.anythink.core.common.e.g gVar = iVar instanceof com.anythink.core.common.e.g ? (com.anythink.core.common.e.g) iVar : null;
        if (iVar == null || cVar == null) {
            return;
        }
        iVar.v(cVar.ad());
        iVar.d(cVar.aO());
        iVar.c(cVar.aN());
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.ah() + "&opdptype={opdptype}&apk_ptype={apk_ptype}");
        com.anythink.expressad.foundation.d.n nVarL = cVar.L();
        if (nVarL != null && (strArrL = nVarL.l()) != null) {
            for (String str : strArrL) {
                arrayList.add(str);
            }
        }
        ac acVarX = gVar.X();
        if (acVarX == null) {
            acVarX = new ac();
            gVar.a(acVarX);
        }
        acVarX.a((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    static /* synthetic */ void a(b bVar, String str, j jVar, a aVar) {
        bVar.a.remove(jVar.b + jVar.a);
        if (aVar != null) {
            aVar.a(f.a(f.f5908l, str));
        }
    }
}
