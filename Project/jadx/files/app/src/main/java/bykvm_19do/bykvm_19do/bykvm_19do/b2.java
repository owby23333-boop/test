package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class b2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static long f645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static b f646o;
    private final j2 a;
    private final k2 b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b0 f647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b0 f648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f652h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f655k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f656l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private z f657m;

    static class b extends d0 {
        private b() {
        }
    }

    b2(k2 k2Var, j2 j2Var) {
        this.b = k2Var;
        this.a = j2Var;
    }

    public static long a(j2 j2Var) {
        f645n++;
        long j2 = f645n;
        if (j2 % 1000 == 0) {
            j2Var.a(j2 + 1000);
        }
        return f645n;
    }

    private void a(u uVar, ArrayList<u> arrayList, boolean z2) {
        synchronized (this) {
            long j2 = uVar instanceof b ? -1L : uVar.a;
            this.f649e = UUID.randomUUID().toString();
            f645n = this.a.b();
            this.f652h = j2;
            this.f653i = z2;
            this.f654j = 0L;
            if (l0.a) {
                l0.a("startSession, " + this.f649e + ", hadUi:" + z2 + " data:" + uVar, null);
            }
            if (z2) {
                Calendar calendar = Calendar.getInstance();
                String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
                if (TextUtils.isEmpty(this.f656l)) {
                    this.f656l = this.a.u();
                    this.f655k = this.a.v();
                }
                if (str.equals(this.f656l)) {
                    this.f655k++;
                } else {
                    this.f656l = str;
                    this.f655k = 1;
                }
                this.a.a(str, this.f655k);
                this.f651g = 0;
            }
            if (j2 != -1) {
                z zVar = new z();
                zVar.f749c = this.f649e;
                zVar.b = a(this.a);
                zVar.a = this.f652h;
                zVar.f785j = this.b.d();
                zVar.f784i = this.b.c();
                if (this.a.N()) {
                    zVar.f751e = bykvm_19do.bykvm_19do.bykvm_19do.a.c();
                    zVar.f752f = bykvm_19do.bykvm_19do.bykvm_19do.a.d();
                }
                arrayList.add(zVar);
                this.f657m = zVar;
                if (l0.a) {
                    l0.a("gen launch, " + zVar.f749c + ", hadUi:" + z2, null);
                }
            }
        }
    }

    public static boolean b(u uVar) {
        if (uVar instanceof b0) {
            return ((b0) uVar).j();
        }
        return false;
    }

    static b d() {
        if (f646o == null) {
            f646o = new b();
        }
        f646o.a = System.currentTimeMillis();
        return f646o;
    }

    Bundle a(long j2, long j3) {
        Bundle bundle;
        synchronized (this) {
            if (this.a.x() && c() && j2 - this.f650f > j3) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.f655k);
                int i2 = this.f651g + 1;
                this.f651g = i2;
                bundle.putInt("send_times", i2);
                bundle.putLong("current_duration", (j2 - this.f650f) / 1000);
                bundle.putString(com.umeng.analytics.pro.u.a, u.a(this.f652h));
                this.f650f = j2;
            } else {
                bundle = null;
            }
        }
        return bundle;
    }

    z a() {
        z zVar;
        synchronized (this) {
            zVar = this.f657m;
        }
        return zVar;
    }

    public void a(u uVar) {
        if (uVar != null) {
            uVar.f750d = this.b.f();
            uVar.f749c = this.f649e;
            uVar.b = a(this.a);
            if (this.a.N()) {
                uVar.f751e = bykvm_19do.bykvm_19do.bykvm_19do.a.c();
                uVar.f752f = bykvm_19do.bykvm_19do.bykvm_19do.a.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean a(bykvm_19do.bykvm_19do.bykvm_19do.u r12, java.util.ArrayList<bykvm_19do.bykvm_19do.bykvm_19do.u> r13) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof bykvm_19do.bykvm_19do.bykvm_19do.b0
            boolean r1 = b(r12)
            long r2 = r11.f652h
            r4 = 0
            r6 = 1
            r7 = -1
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 != 0) goto L19
            boolean r1 = b(r12)
        L15:
            r11.a(r12, r13, r1)
            goto L45
        L19:
            boolean r2 = r11.f653i
            if (r2 != 0) goto L23
            if (r1 == 0) goto L23
            r11.a(r12, r13, r6)
            goto L45
        L23:
            long r2 = r11.f654j
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L37
            long r7 = r12.a
            bykvm_19do.bykvm_19do.bykvm_19do.j2 r9 = r11.a
            long r9 = r9.P()
            long r2 = r2 + r9
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 <= 0) goto L37
            goto L43
        L37:
            long r2 = r11.f652h
            long r7 = r12.a
            r9 = 7200000(0x6ddd00, double:3.5572727E-317)
            long r7 = r7 + r9
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 <= 0) goto L44
        L43:
            goto L15
        L44:
            r6 = 0
        L45:
            if (r0 == 0) goto Lae
            r0 = r12
            bykvm_19do.bykvm_19do.bykvm_19do.b0 r0 = (bykvm_19do.bykvm_19do.bykvm_19do.b0) r0
            boolean r1 = r0.j()
            if (r1 == 0) goto L89
            long r1 = r12.a
            r11.f650f = r1
            r11.f654j = r4
            r13.add(r12)
            java.lang.String r13 = r0.f642j
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto Lb5
            bykvm_19do.bykvm_19do.bykvm_19do.b0 r13 = r11.f648d
            r1 = 500(0x1f4, double:2.47E-321)
            if (r13 == 0) goto L78
            long r3 = r0.a
            long r7 = r13.a
            long r3 = r3 - r7
            long r7 = r13.f641i
            long r3 = r3 - r7
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L78
        L73:
            java.lang.String r13 = r13.f643k
            r0.f642j = r13
            goto Lb5
        L78:
            bykvm_19do.bykvm_19do.bykvm_19do.b0 r13 = r11.f647c
            if (r13 == 0) goto Lb5
            long r3 = r0.a
            long r7 = r13.a
            long r3 = r3 - r7
            long r7 = r13.f641i
            long r3 = r3 - r7
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto Lb5
            goto L73
        L89:
            long r1 = r12.a
            android.os.Bundle r1 = r11.a(r1, r4)
            if (r1 == 0) goto L96
            java.lang.String r2 = "play_session"
            bykvm_19do.bykvm_19do.bykvm_19do.a.a(r2, r1)
        L96:
            r11.f650f = r4
            long r1 = r0.a
            r11.f654j = r1
            r13.add(r12)
            boolean r13 = r0.k()
            if (r13 == 0) goto La8
            r11.f647c = r0
            goto Lb5
        La8:
            r11.f648d = r0
            r13 = 0
            r11.f647c = r13
            goto Lb5
        Lae:
            boolean r0 = r12 instanceof bykvm_19do.bykvm_19do.bykvm_19do.b2.b
            if (r0 != 0) goto Lb5
            r13.add(r12)
        Lb5:
            r11.a(r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.b2.a(bykvm_19do.bykvm_19do.bykvm_19do.u, java.util.ArrayList):boolean");
    }

    public boolean b() {
        return this.f653i;
    }

    boolean c() {
        return b() && this.f654j == 0;
    }
}
