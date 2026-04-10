package com.bytedance.sdk.component.dl.g;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f623a;
    String dl;
    private final int e;
    private final boolean fo;
    private final boolean gc;
    private final boolean gz;
    private final boolean i;
    private final int kb;
    private final int m;
    private final boolean pf;
    private final boolean uy;
    private final boolean v;
    private final int wp;
    public static final a z = new z().z().dl();
    public static final a g = new z().g().z(Integer.MAX_VALUE, TimeUnit.SECONDS).dl();

    private a(boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, int i4, boolean z7, boolean z8, boolean z9, String str) {
        this.f623a = z2;
        this.gc = z3;
        this.m = i;
        this.e = i2;
        this.gz = z4;
        this.fo = z5;
        this.uy = z6;
        this.kb = i3;
        this.wp = i4;
        this.i = z7;
        this.v = z8;
        this.pf = z9;
        this.dl = str;
    }

    a(z zVar) {
        this.f623a = zVar.z;
        this.gc = zVar.g;
        this.m = zVar.dl;
        this.e = -1;
        this.gz = false;
        this.fo = false;
        this.uy = false;
        this.kb = zVar.f624a;
        this.wp = zVar.gc;
        this.i = zVar.m;
        this.v = zVar.e;
        this.pf = zVar.gz;
    }

    public boolean z() {
        return this.f623a;
    }

    public boolean g() {
        return this.gc;
    }

    public int dl() {
        return this.m;
    }

    public boolean a() {
        return this.gz;
    }

    public boolean gc() {
        return this.fo;
    }

    public boolean m() {
        return this.uy;
    }

    public int e() {
        return this.kb;
    }

    public int gz() {
        return this.wp;
    }

    public boolean fo() {
        return this.i;
    }

    public boolean uy() {
        return this.pf;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.dl.g.a z(com.bytedance.sdk.component.dl.g.fv r22) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.a.z(com.bytedance.sdk.component.dl.g.fv):com.bytedance.sdk.component.dl.g.a");
    }

    public String toString() {
        String str = this.dl;
        if (str != null) {
            return str;
        }
        String strKb = kb();
        this.dl = strKb;
        return strKb;
    }

    private String kb() {
        StringBuilder sb = new StringBuilder();
        if (this.f623a) {
            sb.append("no-cache, ");
        }
        if (this.gc) {
            sb.append("no-store, ");
        }
        if (this.m != -1) {
            sb.append("max-age=").append(this.m).append(", ");
        }
        if (this.e != -1) {
            sb.append("s-maxage=").append(this.e).append(", ");
        }
        if (this.gz) {
            sb.append("private, ");
        }
        if (this.fo) {
            sb.append("public, ");
        }
        if (this.uy) {
            sb.append("must-revalidate, ");
        }
        if (this.kb != -1) {
            sb.append("max-stale=").append(this.kb).append(", ");
        }
        if (this.wp != -1) {
            sb.append("min-fresh=").append(this.wp).append(", ");
        }
        if (this.i) {
            sb.append("only-if-cached, ");
        }
        if (this.v) {
            sb.append("no-transform, ");
        }
        if (this.pf) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class z {
        boolean e;
        boolean g;
        boolean gz;
        boolean m;
        boolean z;
        int dl = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f624a = -1;
        int gc = -1;

        public z z() {
            this.z = true;
            return this;
        }

        public z z(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.f624a = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public z g() {
            this.m = true;
            return this;
        }

        public a dl() {
            return new a(this);
        }
    }
}
