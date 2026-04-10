package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.api.ATRewardInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends ah implements Cloneable {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7229c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7230d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7231e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7232f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7233g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7234h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7235i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7236j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7237k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7238l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7239m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7240n = 2;
    int A;
    int B;
    public String C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected double H;
    boolean I;
    int J;
    String K;
    long L;
    long M;
    String N;
    private int aA;
    private String aB;
    private int aC;
    private int aE;
    private int aF;
    private boolean aG;
    private long aH;
    private long aI;
    private String aJ;
    private String aK;
    private String aL;
    private int aM;
    private String aO;
    private String aP;
    private double aQ;
    private String aR;
    private double aS;
    private double aT;
    private ATRewardInfo aU;
    private Map<String, ATRewardInfo> aV;
    private Map<String, Object> aW;
    private String aX;
    private long aY;
    private String aZ;
    private int aw;
    private String ax;
    private String ay;
    private int az;
    private String ba;
    private int bb;
    private int bc;
    private String bd;
    private long be;
    private int bf;
    private int bg;
    private int bh;
    private int bi;
    private long bj;
    private int bl;
    private int bm;
    private int bo;
    private String bp;
    private Map<String, Object> bq;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f7241o;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f7246t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f7247u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f7248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f7249w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected double f7250x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String f7251y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7252z;
    private int aD = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7242p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7243q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7244r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f7245s = 0;
    private String aN = "unknow";
    private int bk = -1;
    private int bn = 1;

    private void A(String str) {
        this.C = str;
    }

    private void B(String str) {
        this.f7247u = str;
    }

    private double aa() {
        return this.H;
    }

    private int ab() {
        return this.bh;
    }

    private int ac() {
        return this.bg;
    }

    private String ad() {
        return this.C;
    }

    private int ae() {
        return this.f7252z;
    }

    private void af() {
        this.f7252z = 1;
    }

    private String ag() {
        return this.f7247u;
    }

    private boolean ah() {
        return this.bi == 9;
    }

    private String ai() {
        return this.ax;
    }

    private String aj() {
        return this.f7242p;
    }

    private int ak() {
        return this.f7243q;
    }

    private int al() {
        return this.f7244r;
    }

    private int am() {
        return this.f7246t;
    }

    private boolean an() {
        return this.I;
    }

    private int ao() {
        return this.J;
    }

    private String ap() {
        return this.K;
    }

    private long aq() {
        return this.L;
    }

    private long ar() {
        return this.M;
    }

    private String as() {
        return this.N;
    }

    public final int C() {
        return this.aA;
    }

    public final String D() {
        return this.aB;
    }

    public final int E() {
        return this.aC;
    }

    public final int F() {
        return this.aD;
    }

    public final String G() {
        return this.ay;
    }

    public final int H() {
        return this.f7241o;
    }

    public final int I() {
        return this.aw;
    }

    public final long J() {
        return this.aH;
    }

    public final long K() {
        return this.aI;
    }

    public final int L() {
        return this.bk;
    }

    public final int M() {
        return this.bo;
    }

    public final e N() {
        try {
            e eVar = (e) super.clone();
            eVar.aU = this.aU;
            eVar.bq = this.bq;
            eVar.aV = this.aV;
            eVar.aW = this.aW;
            return eVar;
        } catch (Throwable unused) {
            return this;
        }
    }

    public final void a(Map<String, Object> map) {
        this.bq = map;
    }

    public final void b(int i2) {
        this.bm = i2;
    }

    public final void c(int i2) {
        this.bi = i2;
    }

    public final void d(int i2) {
        this.bh = i2;
    }

    public final void e(int i2) {
        this.bg = i2;
    }

    public final void f(int i2) {
        this.bf = i2;
    }

    public final double g() {
        return this.aQ;
    }

    public final String h() {
        return this.aR;
    }

    public final String i() {
        return this.aX;
    }

    public final String j() {
        return this.f7251y;
    }

    public final String k() {
        return this.aK;
    }

    public final String l() {
        return this.aL;
    }

    public final int m() {
        return this.aM;
    }

    public final String n() {
        return this.aN;
    }

    public final String o() {
        return this.aO;
    }

    public final String p() {
        return this.aP;
    }

    public final Map<String, ATRewardInfo> q() {
        return this.aV;
    }

    public final ATRewardInfo r() {
        return this.aU;
    }

    public final Map<String, Object> s() {
        return this.aW;
    }

    public final int t() {
        return this.A;
    }

    public final int u() {
        return this.B;
    }

    public final int v() {
        return this.f7249w;
    }

    public final double w() {
        return this.f7250x;
    }

    public final String x() {
        return this.aJ;
    }

    public final int y() {
        int i2 = this.bi;
        if (i2 != 8) {
            return i2 != 9 ? 0 : 1;
        }
        return 2;
    }

    public final int z() {
        return this.aE;
    }

    private void C(String str) {
        this.f7248v = str;
    }

    private void F(int i2) {
        this.f7243q = i2;
    }

    private void G(int i2) {
        this.f7244r = i2;
    }

    private void H(int i2) {
        this.f7245s = i2;
    }

    private void I(int i2) {
        this.f7246t = i2;
    }

    private JSONObject J(int i2) {
        return super.A(i2);
    }

    public final int A() {
        return this.aF;
    }

    public final int B() {
        return this.az;
    }

    public final Map<String, Object> a() {
        return this.bq;
    }

    public final int b() {
        return this.bf;
    }

    public final void c() {
        this.bc = 1;
    }

    public final void d() {
        if (this.bc != 1) {
            this.bb = 1;
        }
    }

    public final String e() {
        return this.ba;
    }

    public final double f() {
        return this.aT;
    }

    public final void g(int i2) {
        this.D = i2;
    }

    public final void h(int i2) {
        this.E = i2;
    }

    public final void i(int i2) {
        this.F = i2;
    }

    public final void j(int i2) {
        this.G = i2;
    }

    public final void k(int i2) {
        this.aM = i2;
    }

    public final void l(int i2) {
        this.A = i2;
    }

    public final void m(int i2) {
        this.B = i2;
    }

    public final void n(int i2) {
        this.f7249w = i2;
    }

    public final void o(int i2) {
        this.aE = i2;
    }

    public final void p(int i2) {
        this.aF = i2;
    }

    public final void q(int i2) {
        this.az = i2;
    }

    public final void r(int i2) {
        this.aA = i2;
    }

    public final void s(int i2) {
        this.aC = i2;
    }

    public final void t(int i2) {
        this.aD = i2;
    }

    public final void u(int i2) {
        this.f7241o = i2;
    }

    public final void v(int i2) {
        this.aw = i2;
    }

    public final void w(int i2) {
        this.bk = i2;
    }

    public final void x(int i2) {
        this.bn = i2;
    }

    public final void y(int i2) {
        this.bo = i2;
    }

    public final void z(int i2) {
        this.J = i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2 A[Catch: Exception -> 0x0354, TryCatch #0 {Exception -> 0x0354, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x001b, B:8:0x0023, B:9:0x002a, B:11:0x0034, B:27:0x0071, B:28:0x0078, B:29:0x008b, B:30:0x0093, B:34:0x00aa, B:33:0x00a3, B:35:0x00af, B:39:0x00e9, B:42:0x00fe, B:44:0x0102, B:45:0x0105, B:47:0x0109, B:49:0x010d, B:51:0x0117, B:54:0x0124, B:56:0x0133, B:57:0x013a, B:52:0x011b, B:53:0x0120, B:38:0x00e2, B:58:0x0150, B:64:0x016d, B:63:0x0166, B:65:0x017d, B:69:0x01a7, B:68:0x01a0, B:70:0x01ac, B:74:0x01b5, B:75:0x01d4, B:77:0x0205, B:78:0x020e, B:79:0x0240, B:81:0x0263, B:82:0x026a, B:84:0x02ad, B:85:0x02b4, B:87:0x02cb, B:88:0x02d4, B:89:0x0323, B:23:0x004c), top: B:94:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0133 A[Catch: Exception -> 0x0354, TryCatch #0 {Exception -> 0x0354, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x001b, B:8:0x0023, B:9:0x002a, B:11:0x0034, B:27:0x0071, B:28:0x0078, B:29:0x008b, B:30:0x0093, B:34:0x00aa, B:33:0x00a3, B:35:0x00af, B:39:0x00e9, B:42:0x00fe, B:44:0x0102, B:45:0x0105, B:47:0x0109, B:49:0x010d, B:51:0x0117, B:54:0x0124, B:56:0x0133, B:57:0x013a, B:52:0x011b, B:53:0x0120, B:38:0x00e2, B:58:0x0150, B:64:0x016d, B:63:0x0166, B:65:0x017d, B:69:0x01a7, B:68:0x01a0, B:70:0x01ac, B:74:0x01b5, B:75:0x01d4, B:77:0x0205, B:78:0x020e, B:79:0x0240, B:81:0x0263, B:82:0x026a, B:84:0x02ad, B:85:0x02b4, B:87:0x02cb, B:88:0x02d4, B:89:0x0323, B:23:0x004c), top: B:94:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ad A[Catch: Exception -> 0x0354, TryCatch #0 {Exception -> 0x0354, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x001b, B:8:0x0023, B:9:0x002a, B:11:0x0034, B:27:0x0071, B:28:0x0078, B:29:0x008b, B:30:0x0093, B:34:0x00aa, B:33:0x00a3, B:35:0x00af, B:39:0x00e9, B:42:0x00fe, B:44:0x0102, B:45:0x0105, B:47:0x0109, B:49:0x010d, B:51:0x0117, B:54:0x0124, B:56:0x0133, B:57:0x013a, B:52:0x011b, B:53:0x0120, B:38:0x00e2, B:58:0x0150, B:64:0x016d, B:63:0x0166, B:65:0x017d, B:69:0x01a7, B:68:0x01a0, B:70:0x01ac, B:74:0x01b5, B:75:0x01d4, B:77:0x0205, B:78:0x020e, B:79:0x0240, B:81:0x0263, B:82:0x026a, B:84:0x02ad, B:85:0x02b4, B:87:0x02cb, B:88:0x02d4, B:89:0x0323, B:23:0x004c), top: B:94:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02cb A[Catch: Exception -> 0x0354, TryCatch #0 {Exception -> 0x0354, blocks: (B:3:0x0008, B:5:0x0014, B:6:0x001b, B:8:0x0023, B:9:0x002a, B:11:0x0034, B:27:0x0071, B:28:0x0078, B:29:0x008b, B:30:0x0093, B:34:0x00aa, B:33:0x00a3, B:35:0x00af, B:39:0x00e9, B:42:0x00fe, B:44:0x0102, B:45:0x0105, B:47:0x0109, B:49:0x010d, B:51:0x0117, B:54:0x0124, B:56:0x0133, B:57:0x013a, B:52:0x011b, B:53:0x0120, B:38:0x00e2, B:58:0x0150, B:64:0x016d, B:63:0x0166, B:65:0x017d, B:69:0x01a7, B:68:0x01a0, B:70:0x01ac, B:74:0x01b5, B:75:0x01d4, B:77:0x0205, B:78:0x020e, B:79:0x0240, B:81:0x0263, B:82:0x026a, B:84:0x02ad, B:85:0x02b4, B:87:0x02cb, B:88:0x02d4, B:89:0x0323, B:23:0x004c), top: B:94:0x0008 }] */
    @Override // com.anythink.core.common.e.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A(int r17) {
        /*
            Method dump skipped, instruction units count: 902
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.e.A(int):org.json.JSONObject");
    }

    public final void a(double d2) {
        this.H = d2;
    }

    public final void b(String str) {
        this.bd = str;
    }

    public final void c(String str) {
        this.ba = str;
    }

    public final void e(String str) {
        this.aX = str;
    }

    public final void f(String str) {
        this.f7251y = str;
    }

    public final void g(String str) {
        this.aK = str;
    }

    public final void h(String str) {
        this.aL = str;
    }

    public final void i(String str) {
        this.aN = str;
    }

    public final void j(String str) {
        this.aO = str;
    }

    public final void k(String str) {
        this.aP = str;
    }

    public final void l(String str) {
        this.aJ = str;
    }

    public final void m(String str) {
        this.aB = str;
    }

    public final void n(String str) {
        this.ay = str;
    }

    public final void o(String str) {
        this.ax = str;
    }

    public final void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7242p = str;
    }

    public final void q(String str) {
        this.aZ = str;
    }

    public final void r(String str) {
        this.K = str;
    }

    public final void s(String str) {
        this.N = str;
    }

    public final void a(String str) {
        this.bp = str;
    }

    public final void b(long j2) {
        this.be = j2;
    }

    public final void c(double d2) {
        this.aQ = d2;
    }

    public final void d(String str) {
        this.aR = str;
    }

    public final void e(long j2) {
        this.L = j2;
    }

    public final void f(long j2) {
        this.M = j2;
    }

    public final void a(int i2) {
        this.bl = i2;
    }

    public final void b(double d2) {
        this.aT = d2;
    }

    public final void c(Map<String, Object> map) {
        this.aW = map;
    }

    public final void d(double d2) {
        this.f7250x = d2;
    }

    public final void a(long j2) {
        this.bj = j2;
    }

    public final void b(Map<String, ATRewardInfo> map) {
        this.aV = map;
    }

    public final void c(long j2) {
        this.aH = j2;
    }

    public final void d(long j2) {
        this.aI = j2;
    }

    private void b(boolean z2) {
        this.aG = z2;
    }

    public final void a(ATRewardInfo aTRewardInfo) {
        this.aU = aTRewardInfo;
    }

    public final void a(boolean z2) {
        this.I = z2;
    }

    private void a(int i2, JSONObject jSONObject) throws JSONException {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 13) {
            jSONObject.put("extra", this.aZ);
        }
    }
}
