package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private final boolean a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f1162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f1164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f1165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f1166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f1167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f1168m;

    public static final class a {
        boolean a;
        boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1169c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1170d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1171e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1172f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f1173g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f1174h;

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f1170d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public d a() {
            return new d(this);
        }

        public a b() {
            this.a = true;
            return this;
        }

        public a c() {
            this.f1172f = true;
            return this;
        }
    }

    static {
        new a().b().a();
        new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    }

    d(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f1158c = aVar.f1169c;
        this.f1159d = -1;
        this.f1160e = false;
        this.f1161f = false;
        this.f1162g = false;
        this.f1163h = aVar.f1170d;
        this.f1164i = aVar.f1171e;
        this.f1165j = aVar.f1172f;
        this.f1166k = aVar.f1173g;
        this.f1167l = aVar.f1174h;
    }

    private d(boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, boolean z6, int i4, int i5, boolean z7, boolean z8, boolean z9, String str) {
        this.a = z2;
        this.b = z3;
        this.f1158c = i2;
        this.f1159d = i3;
        this.f1160e = z4;
        this.f1161f = z5;
        this.f1162g = z6;
        this.f1163h = i4;
        this.f1164i = i5;
        this.f1165j = z7;
        this.f1166k = z8;
        this.f1167l = z9;
        this.f1168m = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        if (r9.equalsIgnoreCase("Pragma") == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r r24) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d");
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.f1158c != -1) {
            sb.append("max-age=");
            sb.append(this.f1158c);
            sb.append(", ");
        }
        if (this.f1159d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f1159d);
            sb.append(", ");
        }
        if (this.f1160e) {
            sb.append("private, ");
        }
        if (this.f1161f) {
            sb.append("public, ");
        }
        if (this.f1162g) {
            sb.append("must-revalidate, ");
        }
        if (this.f1163h != -1) {
            sb.append("max-stale=");
            sb.append(this.f1163h);
            sb.append(", ");
        }
        if (this.f1164i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1164i);
            sb.append(", ");
        }
        if (this.f1165j) {
            sb.append("only-if-cached, ");
        }
        if (this.f1166k) {
            sb.append("no-transform, ");
        }
        if (this.f1167l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f1167l;
    }

    public boolean b() {
        return this.f1160e;
    }

    public boolean c() {
        return this.f1161f;
    }

    public int d() {
        return this.f1158c;
    }

    public int e() {
        return this.f1163h;
    }

    public int f() {
        return this.f1164i;
    }

    public boolean g() {
        return this.f1162g;
    }

    public boolean h() {
        return this.a;
    }

    public boolean i() {
        return this.b;
    }

    public boolean j() {
        return this.f1165j;
    }

    public String toString() {
        String str = this.f1168m;
        if (str != null) {
            return str;
        }
        String strK = k();
        this.f1168m = strK;
        return strK;
    }
}
