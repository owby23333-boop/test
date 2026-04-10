package com.bytedance.msdk.dl.m.g;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.gz;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f452a;
    private String dl;
    private boolean e;
    private int fo;
    private com.bytedance.msdk.dl.g.g.z g;
    private int gc;
    private long gz = -1;
    private int m;
    private uy z;

    private g() {
    }

    public static g z(uy uyVar, com.bytedance.msdk.dl.g.g.z zVar) {
        g gVar = new g();
        gVar.z = uyVar;
        gVar.g = zVar;
        return gVar;
    }

    public int dl() {
        return this.fo;
    }

    public void z(int i) {
        this.fo = i;
    }

    public long a() {
        return this.gz;
    }

    public void z(long j) {
        this.gz = j;
    }

    public boolean gc() {
        return this.e;
    }

    public void z(boolean z) {
        this.e = z;
    }

    public int m() {
        return this.m;
    }

    public void g(int i) {
        this.m = i;
    }

    public int e() {
        return this.gc;
    }

    public void dl(int i) {
        this.gc = i;
    }

    public uy gz() {
        return this.z;
    }

    public void z(final List<dl> list, final uy uyVar) {
        m.z(new Runnable() { // from class: com.bytedance.msdk.dl.m.g.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.g != null) {
                    g.this.g.z(list, uyVar);
                }
            }
        });
    }

    public void z(final com.bytedance.msdk.api.z zVar, final uy uyVar) {
        m.z(new Runnable() { // from class: com.bytedance.msdk.dl.m.g.g.2
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.g != null) {
                    g.this.g.z(zVar, uyVar);
                }
            }
        });
    }

    public void fo() {
        m.z(new Runnable() { // from class: com.bytedance.msdk.dl.m.g.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.g != null) {
                    g.this.g.z();
                }
            }
        });
    }

    public boolean uy() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.oq();
        }
        return false;
    }

    public boolean kb() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return TextUtils.equals(uyVar.pf(), MediationConstant.ADN_PANGLE);
        }
        return false;
    }

    public String wp() {
        uy uyVar = this.z;
        return uyVar != null ? uyVar.fv() : "";
    }

    public String i() {
        uy uyVar = this.z;
        return uyVar != null ? uyVar.pf() : "";
    }

    public int v() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.uy();
        }
        return 0;
    }

    public int pf() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.m();
        }
        return 0;
    }

    public String ls() {
        uy uyVar = this.z;
        return uyVar != null ? uyVar.sy() : "";
    }

    public void z(String str) {
        this.dl = str;
    }

    public String p() {
        return this.dl;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String fv() {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.m.g.g.fv():java.lang.String");
    }

    public int js() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.js();
        }
        return 0;
    }

    public int tb() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.io();
        }
        return 0;
    }

    public int q() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.uf();
        }
        return 0;
    }

    public String iq() {
        uy uyVar = this.z;
        return uyVar != null ? uyVar.pf() : "";
    }

    @Override // com.bytedance.msdk.dl.m.g.z
    public boolean z() {
        uy uyVar = this.z;
        return uyVar != null && uyVar.js() == 1;
    }

    public boolean zw() {
        uy uyVar = this.z;
        return uyVar != null && uyVar.js() == 2;
    }

    public boolean io() {
        uy uyVar = this.z;
        return uyVar != null && uyVar.js() == 3;
    }

    public String uf() {
        return (zw() && x() != null) ? x().uy() : "";
    }

    public void g(String str) {
        this.f452a = str;
    }

    @Override // com.bytedance.msdk.dl.m.g.z
    public String g() {
        return this.f452a;
    }

    public int sy() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.i();
        }
        return 0;
    }

    public int hh() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.z();
        }
        return 0;
    }

    public double l() {
        uy uyVar;
        if (zw() || z() || io() || (uyVar = this.z) == null) {
            return 0.0d;
        }
        return uyVar.zw();
    }

    public double h() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.q();
        }
        return 0.0d;
    }

    public double gk() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.iq();
        }
        return 0.0d;
    }

    public gz x() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.l();
        }
        return null;
    }

    public String lq() {
        uy uyVar = this.z;
        return uyVar != null ? uyVar.v() : "";
    }

    public int mc() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.fo();
        }
        return 0;
    }

    public String un() {
        uy uyVar = this.z;
        return uyVar != null ? uyVar.eo() : "";
    }

    public Object ti() {
        if (zw() && x() != null) {
            return x().g();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int eo() {
        /*
            r7 = this;
            com.bytedance.msdk.core.uy.uy r0 = r7.z
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r0.m()
            com.bytedance.msdk.core.uy.uy r2 = r7.z
            int r2 = r2.i()
            r3 = 20002(0x4e22, float:2.8029E-41)
            r4 = 20004(0x4e24, float:2.8032E-41)
            r5 = 20001(0x4e21, float:2.8027E-41)
            r6 = 20003(0x4e23, float:2.803E-41)
            switch(r2) {
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L40;
                case 4: goto L1b;
                case 5: goto L31;
                case 6: goto L1b;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L45
        L1c:
            r2 = 1
            if (r0 != r2) goto L20
            return r4
        L20:
            r2 = 2
            if (r0 != r2) goto L45
            return r6
        L24:
            return r3
        L25:
            return r6
        L26:
            r1 = 6
            r2 = 20006(0x4e26, float:2.8034E-41)
            if (r0 != r1) goto L2c
            return r2
        L2c:
            r1 = 7
            if (r0 != r1) goto L30
            return r6
        L30:
            return r2
        L31:
            r1 = 4
            r2 = 20005(0x4e25, float:2.8033E-41)
            if (r0 != r1) goto L37
            return r2
        L37:
            r1 = 5
            if (r0 != r1) goto L3b
            return r3
        L3b:
            r1 = 3
            if (r0 != r1) goto L3f
            return r5
        L3f:
            return r2
        L40:
            r0 = 20007(0x4e27, float:2.8036E-41)
            return r0
        L43:
            return r4
        L44:
            return r5
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.m.g.g.eo():int");
    }
}
