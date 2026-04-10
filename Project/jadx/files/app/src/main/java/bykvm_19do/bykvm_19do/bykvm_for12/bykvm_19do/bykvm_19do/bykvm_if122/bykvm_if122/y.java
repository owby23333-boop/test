package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;

/* JADX INFO: loaded from: classes.dex */
public final class y {
    final s a;
    final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final r f1306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final z f1307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Object f1308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile d f1309f;

    public static class a {
        s a;
        String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        r.a f1310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        z f1311d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f1312e;

        public a() {
            this.b = "GET";
            this.f1310c = new r.a();
        }

        a(y yVar) {
            this.a = yVar.a;
            this.b = yVar.b;
            this.f1311d = yVar.f1307d;
            this.f1312e = yVar.f1308e;
            this.f1310c = yVar.f1306c.a();
        }

        public a a(d dVar) {
            String string = dVar.toString();
            return string.isEmpty() ? a("Cache-Control") : b("Cache-Control", string);
        }

        public a a(r rVar) {
            this.f1310c = rVar.a();
            return this;
        }

        public a a(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.a = sVar;
            return this;
        }

        public a a(z zVar) {
            return a("POST", zVar);
        }

        public a a(Object obj) {
            this.f1312e = obj;
            return this;
        }

        public a a(String str) {
            this.f1310c.b(str);
            return this;
        }

        public a a(String str, z zVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (zVar != null && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (zVar != null || !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f.e(str)) {
                this.b = str;
                this.f1311d = zVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a a(String str, String str2) {
            this.f1310c.a(str, str2);
            return this;
        }

        public y a() {
            if (this.a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b() {
            return a("GET", (z) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y.a b(java.lang.String r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L64
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 3
                java.lang.String r3 = "ws:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L27
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "http:"
                r0.append(r1)
                r1 = 3
            L1b:
                java.lang.String r7 = r7.substring(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                goto L41
            L27:
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 4
                java.lang.String r3 = "wss:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L41
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "https:"
                r0.append(r1)
                r1 = 4
                goto L1b
            L41:
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s.d(r7)
                if (r0 == 0) goto L4c
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y$a r7 = r6.a(r0)
                return r7
            L4c:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "unexpected url: "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>(r7)
                throw r0
            L64:
                java.lang.NullPointerException r7 = new java.lang.NullPointerException
                java.lang.String r0 = "url == null"
                r7.<init>(r0)
                goto L6e
            L6d:
                throw r7
            L6e:
                goto L6d
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y.a.b(java.lang.String):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y$a");
        }

        public a b(String str, String str2) {
            this.f1310c.c(str, str2);
            return this;
        }
    }

    y(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f1306c = aVar.f1310c.a();
        this.f1307d = aVar.f1311d;
        Object obj = aVar.f1312e;
        this.f1308e = obj == null ? this : obj;
    }

    public z a() {
        return this.f1307d;
    }

    public String a(String str) {
        return this.f1306c.a(str);
    }

    public d b() {
        d dVar = this.f1309f;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f1306c);
        this.f1309f = dVarA;
        return dVarA;
    }

    public r c() {
        return this.f1306c;
    }

    public boolean d() {
        return this.a.h();
    }

    public String e() {
        return this.b;
    }

    public a f() {
        return new a(this);
    }

    public s g() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.f1308e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
