package com.anythink.expressad.videocommon.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.core.common.res.a.a;
import com.anythink.expressad.foundation.g.f.d.b;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable {
    public static final String a = "2000077";
    protected static final String b = "CampaignDownLoadTask";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f12135d = -510642107992871538L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12136e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12137f = 2000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f12138h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f12139i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f12140j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f12141k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f12142l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f12143m = "errorMsg";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f12144p = 10010;
    private Object A;
    private Class B;
    private Object C;
    private com.anythink.expressad.foundation.d.c D;
    private String E;
    private Context G;
    private long H;
    private String I;
    private String L;
    private long O;
    private com.anythink.expressad.videocommon.d.b P;
    private com.anythink.expressad.videocommon.d.b Q;
    private String U;
    private b.a V;
    private int Z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f12145c;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f12148o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f12149q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f12150r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f12151s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Runnable f12152t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f f12155w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ExecutorService f12156x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private o f12157y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Class f12158z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12146g = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f12147n = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile int f12153u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CopyOnWriteArrayList<f> f12154v = new CopyOnWriteArrayList<>();
    private boolean F = false;
    private long J = 0;
    private int K = 0;
    private boolean M = false;
    private boolean N = false;
    private int R = 100;
    private boolean S = false;
    private boolean T = false;
    private int W = 1;
    private f X = new f() { // from class: com.anythink.expressad.videocommon.b.c.1
        @Override // com.anythink.expressad.videocommon.b.f
        public final void a(long j2, int i2) {
            if (c.this.F) {
                return;
            }
            c.a(c.this, j2, i2);
        }
    };
    private Handler Y = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.videocommon.b.c.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                c cVar = c.this;
                c.a(cVar, cVar.J, c.this.f12153u);
                return;
            }
            if (i2 == 2) {
                if (c.this.f12153u != 2) {
                    c.this.f12153u = 2;
                    c cVar2 = c.this;
                    c.a(cVar2, cVar2.J, c.this.f12153u);
                    return;
                }
                return;
            }
            if (i2 == 3) {
                if (c.this.f12153u == 4 || c.this.f12153u == 2 || c.this.f12153u == 5) {
                    return;
                }
                c.this.f12153u = 4;
                c cVar3 = c.this;
                c.a(cVar3, cVar3.J, c.this.f12153u);
                return;
            }
            if (i2 == 4) {
                c.this.f12153u = 5;
                c.d(c.this);
                c cVar4 = c.this;
                c.a(cVar4, cVar4.J, c.this.f12153u);
                return;
            }
            if (i2 == 5) {
                c.this.h();
            } else if (i2 == 10010 && message.obj != null) {
                c.s();
            }
        }
    };

    public c(Context context, com.anythink.expressad.foundation.d.c cVar, ExecutorService executorService, String str) {
        this.f12148o = false;
        if (context == null && cVar == null) {
            return;
        }
        this.O = System.currentTimeMillis();
        this.G = com.anythink.expressad.foundation.b.a.b().d();
        this.D = cVar;
        this.E = str;
        this.f12156x = executorService;
        com.anythink.expressad.foundation.d.c cVar2 = this.D;
        if (cVar2 != null) {
            this.I = cVar2.S();
        }
        this.U = com.anythink.expressad.foundation.h.m.d(this.I);
        a.a();
        this.L = a.a(this.I);
        this.f12148o = false;
        try {
            if (!TextUtils.isEmpty(this.I) && this.f12147n != 3) {
                x();
            }
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.b(b, e2.getMessage());
        }
    }

    private void A() {
        try {
            if (this.f12158z == null || this.A == null) {
                this.f12158z = Class.forName("com.anythink.expressad.reward.b.a");
                this.A = this.f12158z.newInstance();
                this.f12158z.getMethod("insertExcludeId", String.class, com.anythink.expressad.foundation.d.c.class).invoke(this.A, this.E, this.D);
            }
            if (this.B == null || this.C == null) {
                this.B = Class.forName("com.anythink.expressad.atnative.controller.NativeController");
                this.C = this.B.newInstance();
                this.B.getMethod("insertExcludeId", String.class, com.anythink.expressad.foundation.d.c.class).invoke(this.C, this.E, this.D);
            }
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.d(b, e2.getMessage());
        }
    }

    private static void B() {
    }

    private void C() {
        String str;
        Message messageObtain = Message.obtain();
        messageObtain.what = 10010;
        if (this.D == null || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D.Z()) || TextUtils.isEmpty(this.D.S())) {
            str = "";
        } else {
            str = "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.f12149q + "&cid=" + this.D.aZ() + "&type=" + this.f12153u;
        }
        messageObtain.obj = str;
        this.Y.sendMessage(messageObtain);
    }

    private static void D() {
        com.anythink.expressad.foundation.b.a.b().d();
    }

    private String E() {
        if (this.D == null || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D.Z()) || TextUtils.isEmpty(this.D.S())) {
            return "";
        }
        return "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.f12149q + "&cid=" + this.D.aZ() + "&type=" + this.f12153u;
    }

    static /* synthetic */ boolean d(c cVar) {
        cVar.f12146g = false;
        return false;
    }

    static /* synthetic */ void s() {
        com.anythink.expressad.foundation.b.a.b().d();
    }

    private void t() {
        try {
            if (!TextUtils.isEmpty(this.I) && this.f12147n != 3) {
                x();
            }
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.b(b, e2.getMessage());
        }
    }

    private void u() {
        if (this.f12145c == null) {
            this.f12145c = new b(this.I, this.R, this.W);
            this.f12145c.a(new a.AbstractC0170a() { // from class: com.anythink.expressad.videocommon.b.c.3
                @Override // com.anythink.core.common.res.a.a.AbstractC0170a
                public final boolean a(int i2, long j2, long j3) {
                    if (c.this.H != j3) {
                        c.this.H = j3;
                    }
                    c cVar = c.this;
                    c.a(cVar, j2, cVar.f12153u);
                    if (i2 >= c.this.R) {
                        c.this.g();
                        c.this.q();
                        return true;
                    }
                    if (c.this.f12153u != 2 && c.this.f12153u != 4) {
                        return false;
                    }
                    int i3 = c.this.f12153u == 4 ? 3 : 2;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i3;
                    c.this.Y.sendMessage(messageObtain);
                    return true;
                }

                @Override // com.anythink.core.common.res.a.a.AbstractC0170a
                public final void a(String str, String str2) {
                    c.a(c.this, "errorCode:" + str + ",errorMsg:" + str2);
                }
            });
        }
    }

    private void v() {
        if (this.S) {
            return;
        }
        this.S = true;
        com.anythink.expressad.videocommon.d.b bVar = this.P;
        if (bVar != null) {
            bVar.a(this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar2 = this.Q;
        if (bVar2 != null) {
            bVar2.a(this.I);
        }
    }

    private boolean w() {
        return this.F;
    }

    private void x() {
        com.anythink.core.common.a.i iVarA;
        a.a();
        this.L = a.a(this.I);
        File file = new File(this.L);
        if (file.exists()) {
            this.J = file.length();
        } else {
            this.J = 0L;
        }
        if (this.H != 0 || (iVarA = com.anythink.core.common.a.j.a().a(this.I)) == null) {
            return;
        }
        this.H = iVarA.d();
    }

    private f y() {
        return this.X;
    }

    private static void z() {
    }

    public final void h() {
        if (TextUtils.isEmpty(this.I)) {
            return;
        }
        if (this.f12153u == 5) {
            v();
            return;
        }
        if (this.f12147n == 3) {
            g();
            return;
        }
        if (this.R == 0) {
            g();
            return;
        }
        x();
        u();
        b bVar = this.f12145c;
        if (bVar != null) {
            this.f12153u = 1;
            this.F = true;
            bVar.a();
        }
    }

    public final void i() {
        x();
        u();
        b bVar = this.f12145c;
        if (bVar != null) {
            this.f12153u = 1;
            this.F = true;
            bVar.b();
        }
    }

    public final void j() {
        A();
        this.f12153u = 4;
    }

    public final int k() {
        return this.f12153u;
    }

    public final void l() {
        this.f12153u = 0;
    }

    public final String m() {
        if (this.f12147n == 3) {
            return "";
        }
        File file = new File(this.L);
        try {
            return file.exists() ? file.canRead() ? file.length() > 0 ? "" : "file length is 0 " : "file can not read " : "file is not exist ";
        } catch (Throwable th) {
            String message = th.getMessage();
            if (!com.anythink.expressad.a.a) {
                return message;
            }
            th.printStackTrace();
            return message;
        }
    }

    public final com.anythink.expressad.foundation.d.c n() {
        return this.D;
    }

    public final void o() {
        if (this.f12154v != null) {
            this.f12154v = null;
        }
    }

    public final long p() {
        return this.J;
    }

    public final void q() {
        String str;
        Message messageObtain = Message.obtain();
        messageObtain.what = 10010;
        if (this.D == null || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D.Z()) || TextUtils.isEmpty(this.D.S())) {
            str = "";
        } else {
            str = "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.f12149q + "&cid=" + this.D.aZ() + "&type=" + this.f12153u;
        }
        messageObtain.obj = str;
        this.Y.sendMessage(messageObtain);
    }

    public final String r() {
        return this.f12150r;
    }

    public final void b(int i2) {
        this.f12149q = i2;
    }

    public final void c(int i2) {
        this.W = i2;
        com.anythink.expressad.foundation.h.o.b(b, "mVideoCtnType:" + this.W);
    }

    public final boolean d() {
        return this.N;
    }

    public final String e() {
        return this.L;
    }

    public final long f() {
        return this.H;
    }

    public final void g() {
        Message messageObtain = Message.obtain();
        this.f12153u = 5;
        messageObtain.what = 4;
        this.Y.sendMessage(messageObtain);
    }

    public final boolean b() {
        return this.T;
    }

    public final void d(int i2) {
        this.R = i2;
        com.anythink.expressad.foundation.h.o.b(b, "mReadyRate:" + this.R);
    }

    public final void e(int i2) {
        this.Z = i2;
    }

    public final void a(int i2) {
        this.f12147n = i2;
    }

    public final void b(boolean z2) {
        this.N = z2;
    }

    public final long c() {
        return this.O;
    }

    private void b(String str) {
        if (this.P != null) {
            com.anythink.expressad.foundation.h.o.d(b, "video load retry fail");
            this.P.a(str, this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar = this.Q;
        if (bVar != null) {
            bVar.a(str, this.I);
        }
        this.f12153u = 4;
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        this.Y.sendMessage(messageObtain);
    }

    @SuppressLint({"MissingPermission"})
    private void c(String str) {
        this.K++;
        try {
            if (this.G != null) {
                Object systemService = this.G.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    if (!connectivityManager.getActiveNetworkInfo().isAvailable()) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.K <= 1) {
            com.anythink.expressad.foundation.h.o.d(b, "delFileAndDB");
            this.Y.sendEmptyMessageDelayed(5, com.anythink.expressad.exoplayer.i.a.f9492f);
            return;
        }
        A();
        if (this.P != null) {
            com.anythink.expressad.foundation.h.o.d(b, "video load retry fail");
            this.P.a(str, this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar = this.Q;
        if (bVar != null) {
            bVar.a(str, this.I);
        }
        this.f12153u = 4;
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        this.Y.sendMessage(messageObtain);
    }

    public final String a() {
        return this.I;
    }

    public final void a(boolean z2) {
        if (!z2) {
            this.f12148o = false;
        }
        this.T = z2;
    }

    private static double a(double d2, double d3, int i2) throws IllegalAccessException {
        if (i2 >= 0) {
            return new BigDecimal(Double.toString(d2)).divide(new BigDecimal(Double.toString(d3)), i2, 4).doubleValue();
        }
        throw new IllegalAccessException("精确度不能小于0");
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.D = cVar;
    }

    public final void a(com.anythink.expressad.videocommon.d.b bVar) {
        this.P = bVar;
    }

    private void b(com.anythink.expressad.videocommon.d.b bVar) {
        this.Q = bVar;
    }

    public final void a(f fVar) {
        this.f12155w = fVar;
    }

    private void a(long j2, int i2) {
        this.J = j2;
        int i3 = this.R;
        if (100 * j2 >= ((long) i3) * this.H && !this.S && i2 != 4) {
            if (i3 == 100 && i2 != 5) {
                this.f12153u = 5;
                return;
            }
            v();
        }
        if (this.F) {
            CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f12154v;
            if (copyOnWriteArrayList != null) {
                for (f fVar : copyOnWriteArrayList) {
                    if (fVar != null) {
                        fVar.a(j2, i2);
                    }
                }
            }
            if (this.f12155w != null) {
                if (this.f12153u == 5 || this.f12153u == 4 || this.f12153u == 2 || this.f12153u == 6) {
                    this.f12155w.a(j2, i2);
                    this.f12155w = null;
                }
            }
        }
    }

    private void b(f fVar) {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f12154v;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(fVar);
        }
    }

    public final void a(String str) {
        this.f12150r = str;
    }

    static /* synthetic */ void a(c cVar, long j2, int i2) {
        cVar.J = j2;
        int i3 = cVar.R;
        if (100 * j2 >= ((long) i3) * cVar.H && !cVar.S && i2 != 4) {
            if (i3 == 100 && i2 != 5) {
                cVar.f12153u = 5;
                return;
            }
            cVar.v();
        }
        if (cVar.F) {
            CopyOnWriteArrayList<f> copyOnWriteArrayList = cVar.f12154v;
            if (copyOnWriteArrayList != null) {
                for (f fVar : copyOnWriteArrayList) {
                    if (fVar != null) {
                        fVar.a(j2, i2);
                    }
                }
            }
            if (cVar.f12155w != null) {
                if (cVar.f12153u == 5 || cVar.f12153u == 4 || cVar.f12153u == 2 || cVar.f12153u == 6) {
                    cVar.f12155w.a(j2, i2);
                    cVar.f12155w = null;
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        cVar.K++;
        try {
            if (cVar.G != null) {
                Object systemService = cVar.G.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    if (!connectivityManager.getActiveNetworkInfo().isAvailable()) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (cVar.K <= 1) {
            com.anythink.expressad.foundation.h.o.d(b, "delFileAndDB");
            cVar.Y.sendEmptyMessageDelayed(5, com.anythink.expressad.exoplayer.i.a.f9492f);
            return;
        }
        cVar.A();
        if (cVar.P != null) {
            com.anythink.expressad.foundation.h.o.d(b, "video load retry fail");
            cVar.P.a(str, cVar.I);
        }
        com.anythink.expressad.videocommon.d.b bVar = cVar.Q;
        if (bVar != null) {
            bVar.a(str, cVar.I);
        }
        cVar.f12153u = 4;
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        cVar.Y.sendMessage(messageObtain);
    }
}
