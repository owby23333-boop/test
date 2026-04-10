package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.c.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    public static final String O = "ofm_tid_key";
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int U = 6;
    public static final int V = 7;
    public static final int W = 8;
    public static final int X = 10;
    public static final int Y = 0;
    public static final int Z = 1;
    public static final int aa = 2;
    public static final int ab = 3;
    public static final int ac = 4;
    public static final int ad = 5;
    public static final int ae = 8;
    public static final String af = "0";
    public static final String ag = "1";
    public static final String ah = "2";
    public static final String ai = "3";
    public static final String aj = "4";
    private String a;
    protected String ak;
    protected String al;
    protected String am;
    protected String an;
    public String ao;
    public int ap;
    public int aq;
    protected String ar;
    protected int as;
    protected int at;
    protected int au;
    protected int av = -1;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7154c;

    private int a() {
        return this.au;
    }

    private int b() {
        return this.as;
    }

    private String c() {
        return this.ao;
    }

    private int d() {
        return this.ap;
    }

    private int e() {
        return this.aq;
    }

    public JSONObject A(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("pl_id", this.ak);
            jSONObject.put("req_id", this.al);
            if (!TextUtils.isEmpty(this.am)) {
                jSONObject.put("format", Integer.parseInt(this.am));
            }
            jSONObject.put("ps_id", com.anythink.core.common.b.n.a().r());
            String strG = com.anythink.core.common.b.n.a().g(this.ak);
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("sessionid", strG);
            }
            if (this.av != -1) {
                jSONObject.put("traffic_group_id", this.av);
            }
            if (this.au == 1) {
                jSONObject.put("ofm_tid", this.at);
                jSONObject.put("ofm_system", this.as);
                jSONObject.put(com.anythink.core.common.g.c.M, this.au);
            }
            jSONObject.put("asid", this.an);
            jSONObject.put(d.a.U, this.a);
            jSONObject.put(com.anythink.core.common.g.c.am, this.b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void B(int i2) {
        this.f7154c = i2;
    }

    public final void C(int i2) {
        this.au = i2;
    }

    public final void D(int i2) {
        this.at = i2;
    }

    public final void E(int i2) {
        this.av = i2;
    }

    public final int O() {
        return this.f7154c;
    }

    public final String P() {
        return this.a;
    }

    public final String Q() {
        return this.b;
    }

    public final void R() {
        this.as = 1;
    }

    public final int S() {
        return this.at;
    }

    public final String T() {
        return this.ar;
    }

    public final int U() {
        return this.av;
    }

    public final String V() {
        return this.an;
    }

    public final String W() {
        return this.ak;
    }

    public final String X() {
        return this.al;
    }

    public final String Y() {
        return this.am;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String Z() {
        /*
            r6 = this;
            java.lang.String r0 = r6.am
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case 48: goto L36;
                case 49: goto L2c;
                case 50: goto L22;
                case 51: goto L18;
                case 52: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L40
        Le:
            java.lang.String r1 = "4"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
            r0 = 4
            goto L41
        L18:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
            r0 = 3
            goto L41
        L22:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
            r0 = 2
            goto L41
        L2c:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
            r0 = 1
            goto L41
        L36:
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
            r0 = 0
            goto L41
        L40:
            r0 = -1
        L41:
            if (r0 == 0) goto L5a
            if (r0 == r5) goto L57
            if (r0 == r4) goto L54
            if (r0 == r3) goto L51
            if (r0 == r2) goto L4e
            java.lang.String r0 = "none"
            return r0
        L4e:
            java.lang.String r0 = "splash"
            return r0
        L51:
            java.lang.String r0 = "inter"
            return r0
        L54:
            java.lang.String r0 = "banner"
            return r0
        L57:
            java.lang.String r0 = "reward"
            return r0
        L5a:
            java.lang.String r0 = "native"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.ah.Z():java.lang.String");
    }

    public final void t(String str) {
        this.a = str;
    }

    public final void u(String str) {
        this.b = str;
    }

    public final void v(String str) {
        this.ar = str;
    }

    public final void w(String str) {
        this.an = str;
    }

    public final void x(String str) {
        this.ak = str;
    }

    public final void y(String str) {
        this.al = str;
    }

    public final void z(String str) {
        this.am = str;
    }

    private void a(String str) {
        this.ao = str;
    }

    private void b(int i2) {
        this.aq = i2;
    }

    private void a(int i2) {
        this.ap = i2;
    }
}
