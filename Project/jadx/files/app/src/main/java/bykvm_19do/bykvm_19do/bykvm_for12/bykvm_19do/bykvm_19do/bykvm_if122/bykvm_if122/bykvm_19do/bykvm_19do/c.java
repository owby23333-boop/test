package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.umeng.message.utils.HttpRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final y a;
    public final a0 b;

    public static class a {
        final long a;
        final y b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final a0 f919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f922f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f923g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Date f924h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f925i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f926j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f927k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f928l;

        public a(long j2, y yVar, a0 a0Var) {
            this.f928l = -1;
            this.a = j2;
            this.b = yVar;
            this.f919c = a0Var;
            if (a0Var != null) {
                this.f925i = a0Var.t();
                this.f926j = a0Var.r();
                r rVarM = a0Var.m();
                int iB = rVarM.b();
                for (int i2 = 0; i2 < iB; i2++) {
                    String strA = rVarM.a(i2);
                    String strB = rVarM.b(i2);
                    if (HttpRequest.HEADER_DATE.equalsIgnoreCase(strA)) {
                        this.f920d = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(strB);
                        this.f921e = strB;
                    } else if (HttpRequest.HEADER_EXPIRES.equalsIgnoreCase(strA)) {
                        this.f924h = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f922f = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(strB);
                        this.f923g = strB;
                    } else if (HttpRequest.HEADER_ETAG.equalsIgnoreCase(strA)) {
                        this.f927k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.f928l = e.a(strB, -1);
                    }
                }
            }
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a(HttpRequest.HEADER_IF_NONE_MATCH) == null) ? false : true;
        }

        private long b() {
            Date date = this.f920d;
            long jMax = date != null ? Math.max(0L, this.f926j - date.getTime()) : 0L;
            int i2 = this.f928l;
            if (i2 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i2));
            }
            long j2 = this.f926j;
            return jMax + (j2 - this.f925i) + (this.a - j2);
        }

        private long c() {
            if (this.f919c.j().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f924h != null) {
                Date date = this.f920d;
                long time = this.f924h.getTime() - (date != null ? date.getTime() : this.f926j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f922f == null || this.f919c.s().g().k() != null) {
                return 0L;
            }
            Date date2 = this.f920d;
            long time2 = (date2 != null ? date2.getTime() : this.f925i) - this.f922f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private c d() {
            if (this.f919c == null) {
                return new c(this.b, null);
            }
            if ((!this.b.d() || this.f919c.l() != null) && c.a(this.f919c, this.b)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d dVarB = this.b.b();
                if (dVarB.h() || a(this.b)) {
                    return new c(this.b, null);
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d dVarJ = this.f919c.j();
                if (dVarJ.a()) {
                    return new c(null, this.f919c);
                }
                long jB = b();
                long jC = c();
                if (dVarB.d() != -1) {
                    jC = Math.min(jC, TimeUnit.SECONDS.toMillis(dVarB.d()));
                }
                long millis = 0;
                long millis2 = dVarB.f() != -1 ? TimeUnit.SECONDS.toMillis(dVarB.f()) : 0L;
                if (!dVarJ.g() && dVarB.e() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(dVarB.e());
                }
                if (!dVarJ.h()) {
                    long j2 = millis2 + jB;
                    if (j2 < millis + jC) {
                        a0.a aVarP = this.f919c.p();
                        if (j2 >= jC) {
                            aVarP.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jB > 86400000 && e()) {
                            aVarP.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, aVarP.a());
                    }
                }
                String str = this.f927k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = HttpRequest.HEADER_IF_NONE_MATCH;
                } else if (this.f922f != null) {
                    str = this.f923g;
                } else {
                    if (this.f920d == null) {
                        return new c(this.b, null);
                    }
                    str = this.f921e;
                }
                r.a aVarA = this.b.c().a();
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(aVarA, str2, str);
                return new c(this.b.f().a(aVarA.a()).a(), this.f919c);
            }
            return new c(this.b, null);
        }

        private boolean e() {
            return this.f919c.j().d() == -1 && this.f924h == null;
        }

        public c a() {
            c cVarD = d();
            return (cVarD.a == null || !this.b.b().j()) ? cVarD : new c(null, null);
        }
    }

    c(y yVar, a0 a0Var) {
        this.a = yVar;
        this.b = a0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0 r2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y r3) {
        /*
            int r0 = r2.k()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L57
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L57
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L57
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L57
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L57
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L57
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L30
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L57
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L57
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L57
            switch(r0) {
                case 300: goto L57;
                case 301: goto L57;
                case 302: goto L30;
                default: goto L2f;
            }
        L2f:
            goto L6d
        L30:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r2.b(r0)
            if (r0 != 0) goto L57
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r2.j()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L57
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r2.j()
            boolean r0 = r0.c()
            if (r0 != 0) goto L57
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r2.j()
            boolean r0 = r0.b()
            if (r0 == 0) goto L6d
        L57:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r2 = r2.j()
            boolean r2 = r2.i()
            if (r2 != 0) goto L6d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r2 = r3.b()
            boolean r2 = r2.i()
            if (r2 != 0) goto L6d
            r2 = 1
            goto L6e
        L6d:
            r2 = 0
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y):boolean");
    }
}
