package com.bytedance.sdk.component.dl.g.z.z;

import com.bytedance.sdk.component.dl.g.fv;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.sy;
import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    public final h g;
    public final sy z;

    dl(sy syVar, h hVar) {
        this.z = syVar;
        this.g = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.wp().a() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean z(com.bytedance.sdk.component.dl.g.h r3, com.bytedance.sdk.component.dl.g.sy r4) {
        /*
            int r0 = r3.dl()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.z(r0)
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.dl.g.a r0 = r3.wp()
            int r0 = r0.dl()
            r1 = -1
            if (r0 != r1) goto L59
            com.bytedance.sdk.component.dl.g.a r0 = r3.wp()
            boolean r0 = r0.gc()
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.dl.g.a r0 = r3.wp()
            boolean r0 = r0.a()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.bytedance.sdk.component.dl.g.a r3 = r3.wp()
            boolean r3 = r3.g()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.component.dl.g.a r3 = r4.e()
            boolean r3 = r3.g()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.z.dl.z(com.bytedance.sdk.component.dl.g.h, com.bytedance.sdk.component.dl.g.sy):boolean");
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Date f690a;
        final h dl;
        private String e;
        private long fo;
        final sy g;
        private String gc;
        private Date gz;
        private String kb;
        private Date m;
        private long uy;
        private int wp;
        final long z;

        public z(long j, sy syVar, h hVar) {
            this.wp = -1;
            this.z = j;
            this.g = syVar;
            this.dl = hVar;
            if (hVar != null) {
                this.fo = hVar.i();
                this.uy = hVar.v();
                fv fvVarE = hVar.e();
                int iZ = fvVarE.z();
                for (int i = 0; i < iZ; i++) {
                    String strZ = fvVarE.z(i);
                    String strG = fvVarE.g(i);
                    if (HttpHeaders.DATE.equalsIgnoreCase(strZ)) {
                        this.f690a = com.bytedance.sdk.component.dl.g.z.dl.a.z(strG);
                        this.gc = strG;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(strZ)) {
                        this.gz = com.bytedance.sdk.component.dl.g.z.dl.a.z(strG);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(strZ)) {
                        this.m = com.bytedance.sdk.component.dl.g.z.dl.a.z(strG);
                        this.e = strG;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(strZ)) {
                        this.kb = strG;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(strZ)) {
                        this.wp = com.bytedance.sdk.component.dl.g.z.dl.gc.g(strG, -1);
                    }
                }
            }
        }

        public dl z() {
            dl dlVarG = g();
            return (dlVarG.z == null || !this.g.e().fo()) ? dlVarG : new dl(null, null);
        }

        private dl g() {
            String str;
            if (this.dl == null) {
                return new dl(this.g, null);
            }
            if (this.g.gz() && this.dl.m() == null) {
                return new dl(this.g, null);
            }
            if (!dl.z(this.dl, this.g)) {
                return new dl(this.g, null);
            }
            com.bytedance.sdk.component.dl.g.a aVarE = this.g.e();
            if (aVarE.z() || z(this.g)) {
                return new dl(this.g, null);
            }
            com.bytedance.sdk.component.dl.g.a aVarWp = this.dl.wp();
            if (aVarWp.uy()) {
                return new dl(null, this.dl);
            }
            long jA = a();
            long jDl = dl();
            if (aVarE.dl() != -1) {
                jDl = Math.min(jDl, TimeUnit.SECONDS.toMillis(aVarE.dl()));
            }
            long millis = 0;
            long millis2 = aVarE.gz() != -1 ? TimeUnit.SECONDS.toMillis(aVarE.gz()) : 0L;
            if (!aVarWp.m() && aVarE.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(aVarE.e());
            }
            if (!aVarWp.z()) {
                long j = millis2 + jA;
                if (j < millis + jDl) {
                    h.z zVarFo = this.dl.fo();
                    if (j >= jDl) {
                        zVarFo.z(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && gc()) {
                        zVarFo.z(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new dl(null, zVarFo.z());
                }
            }
            String str2 = this.kb;
            if (str2 != null) {
                str = HttpHeaders.IF_NONE_MATCH;
            } else {
                if (this.m != null) {
                    str2 = this.e;
                } else if (this.f690a != null) {
                    str2 = this.gc;
                } else {
                    return new dl(this.g, null);
                }
                str = HttpHeaders.IF_MODIFIED_SINCE;
            }
            fv.z zVarG = this.g.dl().g();
            com.bytedance.sdk.component.dl.g.z.z.z.z(zVarG, str, str2);
            return new dl(this.g.m().z(zVarG.z()).z(), this.dl);
        }

        private long dl() {
            if (this.dl.wp().dl() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.dl());
            }
            if (this.gz != null) {
                Date date = this.f690a;
                long time = this.gz.getTime() - (date != null ? date.getTime() : this.uy);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.m != null && this.dl.z().z().query() == null) {
                Date date2 = this.f690a;
                long time2 = (date2 != null ? date2.getTime() : this.fo) - this.m.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long a() {
            Date date = this.f690a;
            long jMax = date != null ? Math.max(0L, this.uy - date.getTime()) : 0L;
            if (this.wp != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.wp));
            }
            long j = this.uy;
            return jMax + (j - this.fo) + (this.z - j);
        }

        private boolean gc() {
            return this.dl.wp().dl() == -1 && this.gz == null;
        }

        private static boolean z(sy syVar) {
            return (syVar.z(HttpHeaders.IF_MODIFIED_SINCE) == null && syVar.z(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
