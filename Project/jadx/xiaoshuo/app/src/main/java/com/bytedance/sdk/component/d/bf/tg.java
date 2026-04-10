package com.bytedance.sdk.component.d.bf;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class tg {
    private final boolean bh;
    String d;
    private final boolean ga;
    private final boolean m;
    private final int p;
    private final boolean s;
    private final boolean t;
    private final boolean tg;
    private final boolean v;
    private final int vn;
    private final int wu;
    private final int xu;
    private final boolean zk;
    public static final tg e = new e().e().d();
    public static final tg bf = new e().bf().e(Integer.MAX_VALUE, TimeUnit.SECONDS).d();

    public static final class e {
        boolean bf;
        boolean e;
        boolean p;
        boolean v;
        boolean vn;
        int d = -1;
        int tg = -1;
        int ga = -1;

        public e bf() {
            this.vn = true;
            return this;
        }

        public tg d() {
            return new tg(this);
        }

        public e e() {
            this.e = true;
            return this;
        }

        public e e(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.tg = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }
    }

    private tg(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.tg = z;
        this.ga = z2;
        this.vn = i;
        this.p = i2;
        this.v = z3;
        this.zk = z4;
        this.m = z5;
        this.wu = i3;
        this.xu = i4;
        this.bh = z6;
        this.t = z7;
        this.s = z8;
        this.d = str;
    }

    private String wu() {
        StringBuilder sb = new StringBuilder();
        if (this.tg) {
            sb.append("no-cache, ");
        }
        if (this.ga) {
            sb.append("no-store, ");
        }
        if (this.vn != -1) {
            sb.append("max-age=");
            sb.append(this.vn);
            sb.append(", ");
        }
        if (this.p != -1) {
            sb.append("s-maxage=");
            sb.append(this.p);
            sb.append(", ");
        }
        if (this.v) {
            sb.append("private, ");
        }
        if (this.zk) {
            sb.append("public, ");
        }
        if (this.m) {
            sb.append("must-revalidate, ");
        }
        if (this.wu != -1) {
            sb.append("max-stale=");
            sb.append(this.wu);
            sb.append(", ");
        }
        if (this.xu != -1) {
            sb.append("min-fresh=");
            sb.append(this.xu);
            sb.append(", ");
        }
        if (this.bh) {
            sb.append("only-if-cached, ");
        }
        if (this.t) {
            sb.append("no-transform, ");
        }
        if (this.s) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean bf() {
        return this.ga;
    }

    public int d() {
        return this.vn;
    }

    public boolean e() {
        return this.tg;
    }

    public boolean ga() {
        return this.zk;
    }

    public boolean m() {
        return this.s;
    }

    public int p() {
        return this.wu;
    }

    public boolean tg() {
        return this.v;
    }

    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String strWu = wu();
        this.d = strWu;
        return strWu;
    }

    public int v() {
        return this.xu;
    }

    public boolean vn() {
        return this.m;
    }

    public boolean zk() {
        return this.bh;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.d.bf.tg e(com.bytedance.sdk.component.d.bf.f r22) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.tg.e(com.bytedance.sdk.component.d.bf.f):com.bytedance.sdk.component.d.bf.tg");
    }

    public tg(e eVar) {
        this.tg = eVar.e;
        this.ga = eVar.bf;
        this.vn = eVar.d;
        this.p = -1;
        this.v = false;
        this.zk = false;
        this.m = false;
        this.wu = eVar.tg;
        this.xu = eVar.ga;
        this.bh = eVar.vn;
        this.t = eVar.p;
        this.s = eVar.v;
    }
}
