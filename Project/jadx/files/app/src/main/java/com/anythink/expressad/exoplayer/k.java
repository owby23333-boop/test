package com.anythink.expressad.exoplayer;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.e;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.i.h;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class k implements Handler.Callback, e.a, r.a, s.b, h.a, x.a {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9779c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9780d = "ExoPlayerImplInternal";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9781e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9782f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9783g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9784h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9785i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9786j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9787k = 6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9788l = 7;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9789m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9790n = 9;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f9791o = 10;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f9792p = 11;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f9793q = 12;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f9794r = 13;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f9795s = 14;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f9796t = 15;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f9797u = 10;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f9798v = 10;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f9799w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final long f9800x = 500;
    private final com.anythink.expressad.exoplayer.i.h A;
    private final com.anythink.expressad.exoplayer.i.i B;
    private final p C;
    private final com.anythink.expressad.exoplayer.k.k D;
    private final HandlerThread E;
    private final Handler F;
    private final h G;
    private final ae.b H;
    private final ae.a I;
    private final e L;
    private final ArrayList<b> N;
    private final com.anythink.expressad.exoplayer.k.c O;
    private u R;
    private com.anythink.expressad.exoplayer.h.s S;
    private y[] T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private int Z;
    private d aa;
    private long ab;
    private int ac;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final y[] f9801y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final z[] f9802z;
    private final s P = new s();
    private final long J = 0;
    private final boolean K = false;
    private ac Q = ac.f8462e;
    private final c M = new c(0);

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.k$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ x a;

        AnonymousClass1(x xVar) {
            this.a = xVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                k.f(this.a);
            } catch (g e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class a {
        public final com.anythink.expressad.exoplayer.h.s a;
        public final ae b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f9803c;

        public a(com.anythink.expressad.exoplayer.h.s sVar, ae aeVar, Object obj) {
            this.a = sVar;
            this.b = aeVar;
            this.f9803c = obj;
        }
    }

    private static final class c {
        private u a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9807d;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final boolean a(u uVar) {
            return uVar != this.a || this.b > 0 || this.f9806c;
        }

        public final void b(u uVar) {
            this.a = uVar;
            this.b = 0;
            this.f9806c = false;
        }

        public final void a(int i2) {
            this.b += i2;
        }

        public final void b(int i2) {
            if (this.f9806c && this.f9807d != 4) {
                com.anythink.expressad.exoplayer.k.a.a(i2 == 4);
            } else {
                this.f9806c = true;
                this.f9807d = i2;
            }
        }
    }

    private static final class d {
        public final ae a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f9808c;

        public d(ae aeVar, int i2, long j2) {
            this.a = aeVar;
            this.b = i2;
            this.f9808c = j2;
        }
    }

    public k(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.i.i iVar, p pVar, boolean z2, int i2, boolean z3, Handler handler, h hVar2, com.anythink.expressad.exoplayer.k.c cVar) {
        this.f9801y = yVarArr;
        this.A = hVar;
        this.B = iVar;
        this.C = pVar;
        this.V = z2;
        this.X = i2;
        this.Y = z3;
        this.F = handler;
        this.G = hVar2;
        this.O = cVar;
        this.R = new u(ae.a, com.anythink.expressad.exoplayer.b.b, af.a, iVar);
        this.f9802z = new z[yVarArr.length];
        for (int i3 = 0; i3 < yVarArr.length; i3++) {
            yVarArr[i3].a(i3);
            this.f9802z[i3] = yVarArr[i3].b();
        }
        this.L = new e(this, cVar);
        this.N = new ArrayList<>();
        this.T = new y[0];
        this.H = new ae.b();
        this.I = new ae.a();
        hVar.a((h.a) this);
        this.E = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.E.start();
        this.D = cVar.a(this.E.getLooper(), this);
    }

    private void d(boolean z2) {
        u uVar = this.R;
        if (uVar.f10064g != z2) {
            this.R = uVar.a(z2);
        }
    }

    private void e(boolean z2) {
        this.W = false;
        this.V = z2;
        if (!z2) {
            f();
            g();
            return;
        }
        int i2 = this.R.f10063f;
        if (i2 == 3) {
            e();
            this.D.b(2);
        } else if (i2 == 2) {
            this.D.b(2);
        }
    }

    private void f(boolean z2) throws g {
        this.Y = z2;
        if (this.P.a(z2)) {
            return;
        }
        g(true);
    }

    private void g(boolean z2) throws g {
        s.a aVar = this.P.c().f10016h.a;
        long jA = a(aVar, this.R.f10067j, true);
        if (jA != this.R.f10067j) {
            u uVar = this.R;
            this.R = uVar.a(aVar, jA, uVar.f10062e);
            if (z2) {
                this.M.b(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() throws com.anythink.expressad.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.h():void");
    }

    private void i() {
        a(true, true, true);
        this.C.c();
        b(1);
        if (Build.VERSION.SDK_INT >= 18) {
            this.E.quitSafely();
        } else {
            this.E.quit();
        }
        synchronized (this) {
            this.U = true;
            notifyAll();
        }
    }

    private int j() {
        ae aeVar = this.R.a;
        if (aeVar.a()) {
            return 0;
        }
        return aeVar.a(aeVar.b(this.Y), this.H, false).f8476f;
    }

    private void k() {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            if (!a(this.N.get(size))) {
                this.N.get(size).a.a(false);
                this.N.remove(size);
            }
        }
        Collections.sort(this.N);
    }

    private void l() throws g {
        if (this.P.f()) {
            float f2 = this.L.e().b;
            q qVarD = this.P.d();
            boolean z2 = true;
            for (q qVarC = this.P.c(); qVarC != null && qVarC.f10014f; qVarC = qVarC.f10017i) {
                if (qVarC.a(f2)) {
                    if (z2) {
                        q qVarC2 = this.P.c();
                        boolean zA = this.P.a(qVarC2);
                        boolean[] zArr = new boolean[this.f9801y.length];
                        long jA = qVarC2.a(this.R.f10067j, zA, zArr);
                        a(qVarC2.f10019k);
                        u uVar = this.R;
                        if (uVar.f10063f != 4 && jA != uVar.f10067j) {
                            u uVar2 = this.R;
                            this.R = uVar2.a(uVar2.f10060c, jA, uVar2.f10062e);
                            this.M.b(4);
                            a(jA);
                        }
                        boolean[] zArr2 = new boolean[this.f9801y.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            y[] yVarArr = this.f9801y;
                            if (i2 >= yVarArr.length) {
                                break;
                            }
                            y yVar = yVarArr[i2];
                            zArr2[i2] = yVar.a_() != 0;
                            com.anythink.expressad.exoplayer.h.y yVar2 = qVarC2.f10011c[i2];
                            if (yVar2 != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (yVar2 != yVar.f()) {
                                    b(yVar);
                                } else if (zArr[i2]) {
                                    yVar.a(this.ab);
                                }
                            }
                            i2++;
                        }
                        this.R = this.R.a(qVarC2.f10018j, qVarC2.f10019k);
                        a(zArr2, i3);
                    } else {
                        this.P.a(qVarC);
                        if (qVarC.f10014f) {
                            qVarC.b(Math.max(qVarC.f10016h.b, this.ab - qVarC.f10013e));
                            a(qVarC.f10019k);
                        }
                    }
                    if (this.R.f10063f != 4) {
                        r();
                        g();
                        this.D.b(2);
                        return;
                    }
                    return;
                }
                if (qVarC == qVarD) {
                    z2 = false;
                }
            }
        }
    }

    private boolean m() {
        q qVarC = this.P.c();
        long j2 = qVarC.f10016h.f10026e;
        if (j2 == com.anythink.expressad.exoplayer.b.b || this.R.f10067j < j2) {
            return true;
        }
        q qVar = qVarC.f10017i;
        if (qVar != null) {
            return qVar.f10014f || qVar.f10016h.a.a();
        }
        return false;
    }

    private void n() {
        q qVarB = this.P.b();
        q qVarD = this.P.d();
        if (qVarB == null || qVarB.f10014f) {
            return;
        }
        if (qVarD == null || qVarD.f10017i == qVarB) {
            for (y yVar : this.T) {
                if (!yVar.g()) {
                    return;
                }
            }
            qVarB.a.a();
        }
    }

    private void o() {
        b(4);
        a(false, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() throws com.anythink.expressad.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.p():void");
    }

    private void q() {
        this.P.a(this.ab);
        if (this.P.a()) {
            r rVarA = this.P.a(this.ab, this.R);
            if (rVarA == null) {
                this.S.b();
                return;
            }
            this.P.a(this.f9802z, this.A, this.C.d(), this.S, this.R.a.a(rVarA.a.a, this.I, true).b, rVarA).a(this, rVarA.b);
            d(true);
        }
    }

    private void r() {
        q qVarB = this.P.b();
        long jB = qVarB.b();
        if (jB == Long.MIN_VALUE) {
            d(false);
            return;
        }
        boolean zA = this.C.a(jB - (this.ab - qVarB.f10013e), this.L.e().b);
        d(zA);
        if (zA) {
            qVarB.a(this.ab);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.z zVar) {
        this.D.a(10, (com.anythink.expressad.exoplayer.h.r) zVar).sendToTarget();
    }

    public final void c(boolean z2) {
        this.D.a(6, z2 ? 1 : 0).sendToTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0409 A[Catch: RuntimeException -> 0x08c5, IOException -> 0x08c9, g -> 0x08ce, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x08c5, blocks: (B:8:0x0017, B:449:0x08c1, B:9:0x0029, B:11:0x0035, B:12:0x003a, B:14:0x003e, B:17:0x0043, B:19:0x004e, B:20:0x005a, B:21:0x005f, B:22:0x006b, B:26:0x0072, B:28:0x007c, B:29:0x0081, B:31:0x008d, B:32:0x0092, B:34:0x009a, B:36:0x00b1, B:39:0x00b7, B:43:0x00c0, B:45:0x00c5, B:47:0x00e9, B:49:0x00f1, B:50:0x010c, B:51:0x0113, B:53:0x0118, B:57:0x0125, B:59:0x012d, B:60:0x012f, B:62:0x0133, B:64:0x0139, B:65:0x013d, B:67:0x0141, B:68:0x0146, B:69:0x0149, B:73:0x0177, B:75:0x017d, B:70:0x0159, B:72:0x0162, B:76:0x018a, B:78:0x0196, B:79:0x01a2, B:81:0x01ae, B:83:0x0206, B:84:0x0216, B:85:0x021b, B:87:0x0225, B:89:0x0244, B:91:0x0252, B:92:0x0265, B:93:0x0268, B:95:0x0271, B:98:0x027b, B:100:0x027f, B:102:0x028a, B:103:0x028f, B:107:0x02b0, B:108:0x02b8, B:110:0x02c0, B:112:0x02c6, B:113:0x02cb, B:117:0x02f6, B:124:0x0309, B:126:0x0319, B:128:0x031f, B:132:0x0330, B:133:0x033a, B:135:0x0342, B:137:0x034e, B:139:0x0355, B:141:0x035b, B:142:0x0360, B:144:0x038b, B:145:0x0397, B:147:0x039b, B:149:0x03a5, B:150:0x03b0, B:151:0x03b9, B:155:0x03c1, B:157:0x03d3, B:158:0x03db, B:160:0x03e5, B:162:0x03f1, B:166:0x03f9, B:167:0x0409, B:136:0x034c, B:172:0x0419, B:174:0x041e, B:178:0x0425, B:179:0x042b, B:180:0x0433, B:181:0x043e, B:183:0x044e, B:226:0x0504, B:228:0x050e, B:216:0x04eb, B:213:0x04dc, B:215:0x04e8, B:230:0x0513, B:232:0x0520, B:234:0x0523, B:240:0x0531, B:185:0x045d, B:188:0x047e, B:241:0x0532, B:243:0x053c, B:245:0x0540, B:246:0x0547, B:248:0x0556, B:250:0x0562, B:251:0x0568, B:252:0x059c, B:254:0x05a4, B:257:0x05ab, B:259:0x05b1, B:261:0x05b9, B:263:0x05c1, B:264:0x05ce, B:267:0x05d4, B:270:0x05e0, B:271:0x05e3, B:275:0x05ec, B:276:0x0619, B:279:0x0620, B:281:0x0625, B:283:0x062f, B:285:0x0635, B:287:0x063b, B:288:0x063e, B:289:0x0641, B:291:0x0645, B:295:0x064e, B:297:0x0653, B:300:0x0663, B:303:0x066b, B:304:0x066e, B:309:0x0686, B:311:0x068b, B:314:0x0697, B:316:0x069d, B:320:0x06b5, B:322:0x06bf, B:325:0x06c7, B:326:0x06d5, B:327:0x06d8, B:260:0x05b5, B:328:0x06e0, B:330:0x06ea, B:331:0x06f2, B:333:0x071e, B:335:0x0727, B:339:0x0730, B:341:0x0736, B:343:0x073c, B:345:0x0746, B:347:0x074c, B:356:0x075d, B:361:0x0767, B:363:0x0770, B:364:0x0773, B:368:0x0782, B:370:0x078a, B:372:0x0790, B:408:0x0815, B:410:0x081c, B:412:0x0822, B:413:0x082a, B:415:0x082e, B:419:0x083c, B:426:0x0859, B:417:0x0835, B:420:0x0842, B:422:0x0847, B:424:0x084e, B:425:0x0854, B:373:0x0799, B:375:0x07a0, B:377:0x07a5, B:393:0x07e9, B:395:0x07f1, B:379:0x07ac, B:382:0x07b4, B:386:0x07c3, B:388:0x07cd, B:396:0x07f5, B:398:0x07fc, B:400:0x0801, B:404:0x080a, B:406:0x080f, B:407:0x0812, B:427:0x085d, B:431:0x0864, B:433:0x086b, B:434:0x0872, B:436:0x0879, B:437:0x0883, B:439:0x088a, B:440:0x0890, B:444:0x089b, B:448:0x08a2), top: B:471:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0500 A[Catch: all -> 0x0512, TRY_LEAVE, TryCatch #4 {all -> 0x0512, blocks: (B:194:0x0492, B:196:0x0496, B:201:0x049f, B:202:0x04a8, B:204:0x04b2, B:208:0x04be, B:210:0x04c8, B:212:0x04d8, B:219:0x04f1, B:223:0x04fc, B:224:0x0500), top: B:472:0x0492 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x050e A[Catch: RuntimeException -> 0x08c5, IOException -> 0x08c9, g -> 0x08ce, TryCatch #2 {RuntimeException -> 0x08c5, blocks: (B:8:0x0017, B:449:0x08c1, B:9:0x0029, B:11:0x0035, B:12:0x003a, B:14:0x003e, B:17:0x0043, B:19:0x004e, B:20:0x005a, B:21:0x005f, B:22:0x006b, B:26:0x0072, B:28:0x007c, B:29:0x0081, B:31:0x008d, B:32:0x0092, B:34:0x009a, B:36:0x00b1, B:39:0x00b7, B:43:0x00c0, B:45:0x00c5, B:47:0x00e9, B:49:0x00f1, B:50:0x010c, B:51:0x0113, B:53:0x0118, B:57:0x0125, B:59:0x012d, B:60:0x012f, B:62:0x0133, B:64:0x0139, B:65:0x013d, B:67:0x0141, B:68:0x0146, B:69:0x0149, B:73:0x0177, B:75:0x017d, B:70:0x0159, B:72:0x0162, B:76:0x018a, B:78:0x0196, B:79:0x01a2, B:81:0x01ae, B:83:0x0206, B:84:0x0216, B:85:0x021b, B:87:0x0225, B:89:0x0244, B:91:0x0252, B:92:0x0265, B:93:0x0268, B:95:0x0271, B:98:0x027b, B:100:0x027f, B:102:0x028a, B:103:0x028f, B:107:0x02b0, B:108:0x02b8, B:110:0x02c0, B:112:0x02c6, B:113:0x02cb, B:117:0x02f6, B:124:0x0309, B:126:0x0319, B:128:0x031f, B:132:0x0330, B:133:0x033a, B:135:0x0342, B:137:0x034e, B:139:0x0355, B:141:0x035b, B:142:0x0360, B:144:0x038b, B:145:0x0397, B:147:0x039b, B:149:0x03a5, B:150:0x03b0, B:151:0x03b9, B:155:0x03c1, B:157:0x03d3, B:158:0x03db, B:160:0x03e5, B:162:0x03f1, B:166:0x03f9, B:167:0x0409, B:136:0x034c, B:172:0x0419, B:174:0x041e, B:178:0x0425, B:179:0x042b, B:180:0x0433, B:181:0x043e, B:183:0x044e, B:226:0x0504, B:228:0x050e, B:216:0x04eb, B:213:0x04dc, B:215:0x04e8, B:230:0x0513, B:232:0x0520, B:234:0x0523, B:240:0x0531, B:185:0x045d, B:188:0x047e, B:241:0x0532, B:243:0x053c, B:245:0x0540, B:246:0x0547, B:248:0x0556, B:250:0x0562, B:251:0x0568, B:252:0x059c, B:254:0x05a4, B:257:0x05ab, B:259:0x05b1, B:261:0x05b9, B:263:0x05c1, B:264:0x05ce, B:267:0x05d4, B:270:0x05e0, B:271:0x05e3, B:275:0x05ec, B:276:0x0619, B:279:0x0620, B:281:0x0625, B:283:0x062f, B:285:0x0635, B:287:0x063b, B:288:0x063e, B:289:0x0641, B:291:0x0645, B:295:0x064e, B:297:0x0653, B:300:0x0663, B:303:0x066b, B:304:0x066e, B:309:0x0686, B:311:0x068b, B:314:0x0697, B:316:0x069d, B:320:0x06b5, B:322:0x06bf, B:325:0x06c7, B:326:0x06d5, B:327:0x06d8, B:260:0x05b5, B:328:0x06e0, B:330:0x06ea, B:331:0x06f2, B:333:0x071e, B:335:0x0727, B:339:0x0730, B:341:0x0736, B:343:0x073c, B:345:0x0746, B:347:0x074c, B:356:0x075d, B:361:0x0767, B:363:0x0770, B:364:0x0773, B:368:0x0782, B:370:0x078a, B:372:0x0790, B:408:0x0815, B:410:0x081c, B:412:0x0822, B:413:0x082a, B:415:0x082e, B:419:0x083c, B:426:0x0859, B:417:0x0835, B:420:0x0842, B:422:0x0847, B:424:0x084e, B:425:0x0854, B:373:0x0799, B:375:0x07a0, B:377:0x07a5, B:393:0x07e9, B:395:0x07f1, B:379:0x07ac, B:382:0x07b4, B:386:0x07c3, B:388:0x07cd, B:396:0x07f5, B:398:0x07fc, B:400:0x0801, B:404:0x080a, B:406:0x080f, B:407:0x0812, B:427:0x085d, B:431:0x0864, B:433:0x086b, B:434:0x0872, B:436:0x0879, B:437:0x0883, B:439:0x088a, B:440:0x0890, B:444:0x089b, B:448:0x08a2), top: B:471:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x06d5 A[Catch: RuntimeException -> 0x08c5, IOException -> 0x08c9, g -> 0x08ce, TryCatch #2 {RuntimeException -> 0x08c5, blocks: (B:8:0x0017, B:449:0x08c1, B:9:0x0029, B:11:0x0035, B:12:0x003a, B:14:0x003e, B:17:0x0043, B:19:0x004e, B:20:0x005a, B:21:0x005f, B:22:0x006b, B:26:0x0072, B:28:0x007c, B:29:0x0081, B:31:0x008d, B:32:0x0092, B:34:0x009a, B:36:0x00b1, B:39:0x00b7, B:43:0x00c0, B:45:0x00c5, B:47:0x00e9, B:49:0x00f1, B:50:0x010c, B:51:0x0113, B:53:0x0118, B:57:0x0125, B:59:0x012d, B:60:0x012f, B:62:0x0133, B:64:0x0139, B:65:0x013d, B:67:0x0141, B:68:0x0146, B:69:0x0149, B:73:0x0177, B:75:0x017d, B:70:0x0159, B:72:0x0162, B:76:0x018a, B:78:0x0196, B:79:0x01a2, B:81:0x01ae, B:83:0x0206, B:84:0x0216, B:85:0x021b, B:87:0x0225, B:89:0x0244, B:91:0x0252, B:92:0x0265, B:93:0x0268, B:95:0x0271, B:98:0x027b, B:100:0x027f, B:102:0x028a, B:103:0x028f, B:107:0x02b0, B:108:0x02b8, B:110:0x02c0, B:112:0x02c6, B:113:0x02cb, B:117:0x02f6, B:124:0x0309, B:126:0x0319, B:128:0x031f, B:132:0x0330, B:133:0x033a, B:135:0x0342, B:137:0x034e, B:139:0x0355, B:141:0x035b, B:142:0x0360, B:144:0x038b, B:145:0x0397, B:147:0x039b, B:149:0x03a5, B:150:0x03b0, B:151:0x03b9, B:155:0x03c1, B:157:0x03d3, B:158:0x03db, B:160:0x03e5, B:162:0x03f1, B:166:0x03f9, B:167:0x0409, B:136:0x034c, B:172:0x0419, B:174:0x041e, B:178:0x0425, B:179:0x042b, B:180:0x0433, B:181:0x043e, B:183:0x044e, B:226:0x0504, B:228:0x050e, B:216:0x04eb, B:213:0x04dc, B:215:0x04e8, B:230:0x0513, B:232:0x0520, B:234:0x0523, B:240:0x0531, B:185:0x045d, B:188:0x047e, B:241:0x0532, B:243:0x053c, B:245:0x0540, B:246:0x0547, B:248:0x0556, B:250:0x0562, B:251:0x0568, B:252:0x059c, B:254:0x05a4, B:257:0x05ab, B:259:0x05b1, B:261:0x05b9, B:263:0x05c1, B:264:0x05ce, B:267:0x05d4, B:270:0x05e0, B:271:0x05e3, B:275:0x05ec, B:276:0x0619, B:279:0x0620, B:281:0x0625, B:283:0x062f, B:285:0x0635, B:287:0x063b, B:288:0x063e, B:289:0x0641, B:291:0x0645, B:295:0x064e, B:297:0x0653, B:300:0x0663, B:303:0x066b, B:304:0x066e, B:309:0x0686, B:311:0x068b, B:314:0x0697, B:316:0x069d, B:320:0x06b5, B:322:0x06bf, B:325:0x06c7, B:326:0x06d5, B:327:0x06d8, B:260:0x05b5, B:328:0x06e0, B:330:0x06ea, B:331:0x06f2, B:333:0x071e, B:335:0x0727, B:339:0x0730, B:341:0x0736, B:343:0x073c, B:345:0x0746, B:347:0x074c, B:356:0x075d, B:361:0x0767, B:363:0x0770, B:364:0x0773, B:368:0x0782, B:370:0x078a, B:372:0x0790, B:408:0x0815, B:410:0x081c, B:412:0x0822, B:413:0x082a, B:415:0x082e, B:419:0x083c, B:426:0x0859, B:417:0x0835, B:420:0x0842, B:422:0x0847, B:424:0x084e, B:425:0x0854, B:373:0x0799, B:375:0x07a0, B:377:0x07a5, B:393:0x07e9, B:395:0x07f1, B:379:0x07ac, B:382:0x07b4, B:386:0x07c3, B:388:0x07cd, B:396:0x07f5, B:398:0x07fc, B:400:0x0801, B:404:0x080a, B:406:0x080f, B:407:0x0812, B:427:0x085d, B:431:0x0864, B:433:0x086b, B:434:0x0872, B:436:0x0879, B:437:0x0883, B:439:0x088a, B:440:0x0890, B:444:0x089b, B:448:0x08a2), top: B:471:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x07f5 A[Catch: RuntimeException -> 0x08c5, IOException -> 0x08c9, g -> 0x08ce, TryCatch #2 {RuntimeException -> 0x08c5, blocks: (B:8:0x0017, B:449:0x08c1, B:9:0x0029, B:11:0x0035, B:12:0x003a, B:14:0x003e, B:17:0x0043, B:19:0x004e, B:20:0x005a, B:21:0x005f, B:22:0x006b, B:26:0x0072, B:28:0x007c, B:29:0x0081, B:31:0x008d, B:32:0x0092, B:34:0x009a, B:36:0x00b1, B:39:0x00b7, B:43:0x00c0, B:45:0x00c5, B:47:0x00e9, B:49:0x00f1, B:50:0x010c, B:51:0x0113, B:53:0x0118, B:57:0x0125, B:59:0x012d, B:60:0x012f, B:62:0x0133, B:64:0x0139, B:65:0x013d, B:67:0x0141, B:68:0x0146, B:69:0x0149, B:73:0x0177, B:75:0x017d, B:70:0x0159, B:72:0x0162, B:76:0x018a, B:78:0x0196, B:79:0x01a2, B:81:0x01ae, B:83:0x0206, B:84:0x0216, B:85:0x021b, B:87:0x0225, B:89:0x0244, B:91:0x0252, B:92:0x0265, B:93:0x0268, B:95:0x0271, B:98:0x027b, B:100:0x027f, B:102:0x028a, B:103:0x028f, B:107:0x02b0, B:108:0x02b8, B:110:0x02c0, B:112:0x02c6, B:113:0x02cb, B:117:0x02f6, B:124:0x0309, B:126:0x0319, B:128:0x031f, B:132:0x0330, B:133:0x033a, B:135:0x0342, B:137:0x034e, B:139:0x0355, B:141:0x035b, B:142:0x0360, B:144:0x038b, B:145:0x0397, B:147:0x039b, B:149:0x03a5, B:150:0x03b0, B:151:0x03b9, B:155:0x03c1, B:157:0x03d3, B:158:0x03db, B:160:0x03e5, B:162:0x03f1, B:166:0x03f9, B:167:0x0409, B:136:0x034c, B:172:0x0419, B:174:0x041e, B:178:0x0425, B:179:0x042b, B:180:0x0433, B:181:0x043e, B:183:0x044e, B:226:0x0504, B:228:0x050e, B:216:0x04eb, B:213:0x04dc, B:215:0x04e8, B:230:0x0513, B:232:0x0520, B:234:0x0523, B:240:0x0531, B:185:0x045d, B:188:0x047e, B:241:0x0532, B:243:0x053c, B:245:0x0540, B:246:0x0547, B:248:0x0556, B:250:0x0562, B:251:0x0568, B:252:0x059c, B:254:0x05a4, B:257:0x05ab, B:259:0x05b1, B:261:0x05b9, B:263:0x05c1, B:264:0x05ce, B:267:0x05d4, B:270:0x05e0, B:271:0x05e3, B:275:0x05ec, B:276:0x0619, B:279:0x0620, B:281:0x0625, B:283:0x062f, B:285:0x0635, B:287:0x063b, B:288:0x063e, B:289:0x0641, B:291:0x0645, B:295:0x064e, B:297:0x0653, B:300:0x0663, B:303:0x066b, B:304:0x066e, B:309:0x0686, B:311:0x068b, B:314:0x0697, B:316:0x069d, B:320:0x06b5, B:322:0x06bf, B:325:0x06c7, B:326:0x06d5, B:327:0x06d8, B:260:0x05b5, B:328:0x06e0, B:330:0x06ea, B:331:0x06f2, B:333:0x071e, B:335:0x0727, B:339:0x0730, B:341:0x0736, B:343:0x073c, B:345:0x0746, B:347:0x074c, B:356:0x075d, B:361:0x0767, B:363:0x0770, B:364:0x0773, B:368:0x0782, B:370:0x078a, B:372:0x0790, B:408:0x0815, B:410:0x081c, B:412:0x0822, B:413:0x082a, B:415:0x082e, B:419:0x083c, B:426:0x0859, B:417:0x0835, B:420:0x0842, B:422:0x0847, B:424:0x084e, B:425:0x0854, B:373:0x0799, B:375:0x07a0, B:377:0x07a5, B:393:0x07e9, B:395:0x07f1, B:379:0x07ac, B:382:0x07b4, B:386:0x07c3, B:388:0x07cd, B:396:0x07f5, B:398:0x07fc, B:400:0x0801, B:404:0x080a, B:406:0x080f, B:407:0x0812, B:427:0x085d, B:431:0x0864, B:433:0x086b, B:434:0x0872, B:436:0x0879, B:437:0x0883, B:439:0x088a, B:440:0x0890, B:444:0x089b, B:448:0x08a2), top: B:471:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x080a A[Catch: RuntimeException -> 0x08c5, IOException -> 0x08c9, g -> 0x08ce, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x08c5, blocks: (B:8:0x0017, B:449:0x08c1, B:9:0x0029, B:11:0x0035, B:12:0x003a, B:14:0x003e, B:17:0x0043, B:19:0x004e, B:20:0x005a, B:21:0x005f, B:22:0x006b, B:26:0x0072, B:28:0x007c, B:29:0x0081, B:31:0x008d, B:32:0x0092, B:34:0x009a, B:36:0x00b1, B:39:0x00b7, B:43:0x00c0, B:45:0x00c5, B:47:0x00e9, B:49:0x00f1, B:50:0x010c, B:51:0x0113, B:53:0x0118, B:57:0x0125, B:59:0x012d, B:60:0x012f, B:62:0x0133, B:64:0x0139, B:65:0x013d, B:67:0x0141, B:68:0x0146, B:69:0x0149, B:73:0x0177, B:75:0x017d, B:70:0x0159, B:72:0x0162, B:76:0x018a, B:78:0x0196, B:79:0x01a2, B:81:0x01ae, B:83:0x0206, B:84:0x0216, B:85:0x021b, B:87:0x0225, B:89:0x0244, B:91:0x0252, B:92:0x0265, B:93:0x0268, B:95:0x0271, B:98:0x027b, B:100:0x027f, B:102:0x028a, B:103:0x028f, B:107:0x02b0, B:108:0x02b8, B:110:0x02c0, B:112:0x02c6, B:113:0x02cb, B:117:0x02f6, B:124:0x0309, B:126:0x0319, B:128:0x031f, B:132:0x0330, B:133:0x033a, B:135:0x0342, B:137:0x034e, B:139:0x0355, B:141:0x035b, B:142:0x0360, B:144:0x038b, B:145:0x0397, B:147:0x039b, B:149:0x03a5, B:150:0x03b0, B:151:0x03b9, B:155:0x03c1, B:157:0x03d3, B:158:0x03db, B:160:0x03e5, B:162:0x03f1, B:166:0x03f9, B:167:0x0409, B:136:0x034c, B:172:0x0419, B:174:0x041e, B:178:0x0425, B:179:0x042b, B:180:0x0433, B:181:0x043e, B:183:0x044e, B:226:0x0504, B:228:0x050e, B:216:0x04eb, B:213:0x04dc, B:215:0x04e8, B:230:0x0513, B:232:0x0520, B:234:0x0523, B:240:0x0531, B:185:0x045d, B:188:0x047e, B:241:0x0532, B:243:0x053c, B:245:0x0540, B:246:0x0547, B:248:0x0556, B:250:0x0562, B:251:0x0568, B:252:0x059c, B:254:0x05a4, B:257:0x05ab, B:259:0x05b1, B:261:0x05b9, B:263:0x05c1, B:264:0x05ce, B:267:0x05d4, B:270:0x05e0, B:271:0x05e3, B:275:0x05ec, B:276:0x0619, B:279:0x0620, B:281:0x0625, B:283:0x062f, B:285:0x0635, B:287:0x063b, B:288:0x063e, B:289:0x0641, B:291:0x0645, B:295:0x064e, B:297:0x0653, B:300:0x0663, B:303:0x066b, B:304:0x066e, B:309:0x0686, B:311:0x068b, B:314:0x0697, B:316:0x069d, B:320:0x06b5, B:322:0x06bf, B:325:0x06c7, B:326:0x06d5, B:327:0x06d8, B:260:0x05b5, B:328:0x06e0, B:330:0x06ea, B:331:0x06f2, B:333:0x071e, B:335:0x0727, B:339:0x0730, B:341:0x0736, B:343:0x073c, B:345:0x0746, B:347:0x074c, B:356:0x075d, B:361:0x0767, B:363:0x0770, B:364:0x0773, B:368:0x0782, B:370:0x078a, B:372:0x0790, B:408:0x0815, B:410:0x081c, B:412:0x0822, B:413:0x082a, B:415:0x082e, B:419:0x083c, B:426:0x0859, B:417:0x0835, B:420:0x0842, B:422:0x0847, B:424:0x084e, B:425:0x0854, B:373:0x0799, B:375:0x07a0, B:377:0x07a5, B:393:0x07e9, B:395:0x07f1, B:379:0x07ac, B:382:0x07b4, B:386:0x07c3, B:388:0x07cd, B:396:0x07f5, B:398:0x07fc, B:400:0x0801, B:404:0x080a, B:406:0x080f, B:407:0x0812, B:427:0x085d, B:431:0x0864, B:433:0x086b, B:434:0x0872, B:436:0x0879, B:437:0x0883, B:439:0x088a, B:440:0x0890, B:444:0x089b, B:448:0x08a2), top: B:471:0x0012 }] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.anythink.expressad.exoplayer.h.r$a, com.anythink.expressad.exoplayer.h.s$b, com.anythink.expressad.exoplayer.k] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v113 */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v182 */
    /* JADX WARN: Type inference failed for: r2v183 */
    /* JADX WARN: Type inference failed for: r2v184 */
    /* JADX WARN: Type inference failed for: r2v185 */
    /* JADX WARN: Type inference failed for: r2v186 */
    /* JADX WARN: Type inference failed for: r2v187 */
    /* JADX WARN: Type inference failed for: r2v188 */
    /* JADX WARN: Type inference failed for: r2v189 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v190 */
    /* JADX WARN: Type inference failed for: r2v191 */
    /* JADX WARN: Type inference failed for: r2v192 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v84, types: [int] */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v94 */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r23) {
        /*
            Method dump skipped, instruction units count: 2364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.handleMessage(android.os.Message):boolean");
    }

    public final void b(boolean z2) {
        this.D.a(13, z2 ? 1 : 0).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.i.h.a
    public final void c() {
        this.D.b(11);
    }

    private static final class b implements Comparable<b> {
        public final x a;
        public int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f9805d;

        public b(x xVar) {
            this.a = xVar;
        }

        public final void a(int i2, long j2, Object obj) {
            this.b = i2;
            this.f9804c = j2;
            this.f9805d = obj;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(@NonNull b bVar) {
            b bVar2 = bVar;
            if ((this.f9805d == null) != (bVar2.f9805d == null)) {
                return this.f9805d != null ? -1 : 1;
            }
            if (this.f9805d == null) {
                return 0;
            }
            int i2 = this.b - bVar2.b;
            return i2 != 0 ? i2 : com.anythink.expressad.exoplayer.k.af.b(this.f9804c, bVar2.f9804c);
        }

        private int a(@NonNull b bVar) {
            if ((this.f9805d == null) != (bVar.f9805d == null)) {
                return this.f9805d != null ? -1 : 1;
            }
            if (this.f9805d == null) {
                return 0;
            }
            int i2 = this.b - bVar.b;
            return i2 != 0 ? i2 : com.anythink.expressad.exoplayer.k.af.b(this.f9804c, bVar.f9804c);
        }
    }

    private void c(int i2) throws g {
        this.X = i2;
        if (this.P.a(i2)) {
            return;
        }
        g(true);
    }

    private void d() {
        if (this.M.a(this.R)) {
            this.F.obtainMessage(0, this.M.b, this.M.f9806c ? this.M.f9807d : -1, this.R).sendToTarget();
            this.M.b(this.R);
        }
    }

    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z2, boolean z3) {
        this.D.a(z2 ? 1 : 0, z3 ? 1 : 0, sVar).sendToTarget();
    }

    public final void b(v vVar) {
        this.D.a(4, vVar).sendToTarget();
    }

    private void f() {
        this.L.b();
        for (y yVar : this.T) {
            a(yVar);
        }
    }

    public final Looper b() {
        return this.E.getLooper();
    }

    private void b(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(10, rVar).sendToTarget();
    }

    private void b(int i2) {
        u uVar = this.R;
        if (uVar.f10063f != i2) {
            this.R = uVar.b(i2);
        }
    }

    private void c(v vVar) {
        this.L.a(vVar);
    }

    public final void a(boolean z2) {
        this.D.a(1, z2 ? 1 : 0).sendToTarget();
    }

    private void c(x xVar) {
        if (xVar.f() == com.anythink.expressad.exoplayer.b.b) {
            d(xVar);
            return;
        }
        if (this.S != null && this.Z <= 0) {
            b bVar = new b(xVar);
            if (a(bVar)) {
                this.N.add(bVar);
                Collections.sort(this.N);
                return;
            } else {
                xVar.a(false);
                return;
            }
        }
        this.N.add(new b(xVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(x xVar) {
        if (xVar.j()) {
            return;
        }
        try {
            xVar.b().a(xVar.c(), xVar.d());
        } finally {
            xVar.a(true);
        }
    }

    public final void a(int i2) {
        this.D.a(12, i2).sendToTarget();
    }

    private void b(com.anythink.expressad.exoplayer.h.s sVar, boolean z2, boolean z3) {
        this.Z++;
        a(true, z2, z3);
        this.C.a();
        this.S = sVar;
        b(2);
        sVar.a(this.G, true, this);
        this.D.b(2);
    }

    private void g() {
        long jA;
        if (this.P.f()) {
            q qVarC = this.P.c();
            long jC = qVarC.a.c();
            if (jC != com.anythink.expressad.exoplayer.b.b) {
                a(jC);
                if (jC != this.R.f10067j) {
                    u uVar = this.R;
                    this.R = uVar.a(uVar.f10060c, jC, uVar.f10062e);
                    this.M.b(4);
                }
            } else {
                this.ab = this.L.c();
                long j2 = this.ab - qVarC.f10013e;
                b(this.R.f10067j, j2);
                this.R.f10067j = j2;
            }
            u uVar2 = this.R;
            if (this.T.length == 0) {
                jA = qVarC.f10016h.f10026e;
            } else {
                jA = qVarC.a(true);
            }
            uVar2.f10068k = jA;
        }
    }

    public final void a(ae aeVar, int i2, long j2) {
        this.D.a(3, new d(aeVar, i2, j2)).sendToTarget();
    }

    private void e() {
        this.W = false;
        this.L.a();
        for (y yVar : this.T) {
            yVar.b_();
        }
    }

    public final void a(ac acVar) {
        this.D.a(5, acVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.x.a
    public final synchronized void a(x xVar) {
        if (this.U) {
            xVar.a(false);
        } else {
            this.D.a(14, xVar).sendToTarget();
        }
    }

    private void d(x xVar) {
        if (xVar.e().getLooper() == this.D.a()) {
            f(xVar);
            int i2 = this.R.f10063f;
            if (i2 == 3 || i2 == 2) {
                this.D.b(2);
                return;
            }
            return;
        }
        this.D.a(15, xVar).sendToTarget();
    }

    private void e(x xVar) {
        xVar.e().post(new AnonymousClass1(xVar));
    }

    private void b(ac acVar) {
        this.Q = acVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0036, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x006f, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r7, long r9) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.b(long, long):void");
    }

    private void c(com.anythink.expressad.exoplayer.h.r rVar) throws g {
        if (this.P.a(rVar)) {
            q qVarB = this.P.b();
            float f2 = this.L.e().b;
            qVarB.f10014f = true;
            qVarB.f10018j = qVarB.a.b();
            qVarB.a(f2);
            long jB = qVarB.b(qVarB.f10016h.b);
            long j2 = qVarB.f10013e;
            r rVar2 = qVarB.f10016h;
            qVarB.f10013e = j2 + (rVar2.b - jB);
            qVarB.f10016h = new r(rVar2.a, jB, rVar2.f10024c, rVar2.f10025d, rVar2.f10026e, rVar2.f10027f, rVar2.f10028g);
            a(qVarB.f10019k);
            if (!this.P.f()) {
                a(this.P.h().f10016h.b);
                a((q) null);
            }
            r();
        }
    }

    public final synchronized void a() {
        if (!this.U && this.E.isAlive()) {
            this.D.b(7);
            long jA = 500;
            long jA2 = this.O.a() + 500;
            boolean z2 = false;
            while (!this.U && jA > 0) {
                try {
                    wait(jA);
                } catch (InterruptedException unused) {
                    z2 = true;
                }
                jA = jA2 - this.O.a();
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void d(com.anythink.expressad.exoplayer.h.r rVar) {
        if (this.P.a(rVar)) {
            this.P.a(this.ab);
            r();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s.b
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, ae aeVar, Object obj) {
        this.D.a(8, new a(sVar, aeVar, obj)).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(9, rVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.e.a
    public final void a(v vVar) {
        this.F.obtainMessage(1, vVar).sendToTarget();
        float f2 = vVar.b;
        for (q qVarE = this.P.e(); qVarE != null; qVarE = qVarE.f10017i) {
            com.anythink.expressad.exoplayer.i.i iVar = qVarE.f10019k;
            if (iVar != null) {
                for (com.anythink.expressad.exoplayer.i.f fVar : iVar.f9568c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private boolean c(y yVar) {
        q qVar = this.P.d().f10017i;
        return qVar != null && qVar.f10014f && yVar.g();
    }

    private void a(long j2, long j3) {
        this.D.b();
        this.D.a(j2 + j3);
    }

    private void b(y yVar) {
        this.L.b(yVar);
        a(yVar);
        yVar.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7 A[Catch: all -> 0x00db, TRY_LEAVE, TryCatch #0 {all -> 0x00db, blocks: (B:15:0x005d, B:17:0x0061, B:22:0x006a, B:23:0x0072, B:25:0x007c, B:29:0x0088, B:31:0x0092, B:33:0x00a2, B:39:0x00b9, B:43:0x00c3, B:44:0x00c7), top: B:57:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.exoplayer.k.d r21) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.a(com.anythink.expressad.exoplayer.k$d):void");
    }

    private long a(s.a aVar, long j2) {
        return a(aVar, j2, this.P.c() != this.P.d());
    }

    private long a(s.a aVar, long j2, boolean z2) throws g {
        f();
        this.W = false;
        b(2);
        q qVarC = this.P.c();
        q qVarH = qVarC;
        while (true) {
            if (qVarH == null) {
                break;
            }
            if (a(aVar, j2, qVarH)) {
                this.P.a(qVarH);
                break;
            }
            qVarH = this.P.h();
        }
        if (qVarC != qVarH || z2) {
            for (y yVar : this.T) {
                b(yVar);
            }
            this.T = new y[0];
            qVarC = null;
        }
        if (qVarH != null) {
            a(qVarC);
            if (qVarH.f10015g) {
                long jB = qVarH.a.b(j2);
                qVarH.a.a(jB - this.J, this.K);
                j2 = jB;
            }
            a(j2);
            r();
        } else {
            this.P.b(true);
            a(j2);
        }
        this.D.b(2);
        return j2;
    }

    private boolean a(s.a aVar, long j2, q qVar) {
        if (aVar.equals(qVar.f10016h.a) && qVar.f10014f) {
            this.R.a.a(qVar.f10016h.a.a, this.I, false);
            int iB = this.I.b(j2);
            if (iB == -1 || this.I.a(iB) == qVar.f10016h.f10024c) {
                return true;
            }
        }
        return false;
    }

    private void a(long j2) {
        if (this.P.f()) {
            j2 += this.P.c().f10013e;
        }
        this.ab = j2;
        this.L.a(this.ab);
        for (y yVar : this.T) {
            yVar.a(this.ab);
        }
    }

    private void a(boolean z2, boolean z3) {
        a(true, z2, z2);
        this.M.a(this.Z + (z3 ? 1 : 0));
        this.Z = 0;
        this.C.b();
        b(1);
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        com.anythink.expressad.exoplayer.h.s sVar;
        this.D.b();
        this.W = false;
        this.L.b();
        this.ab = 0L;
        for (y yVar : this.T) {
            try {
                b(yVar);
            } catch (g | RuntimeException unused) {
            }
        }
        this.T = new y[0];
        this.P.b(!z3);
        d(false);
        if (z3) {
            this.aa = null;
        }
        if (z4) {
            this.P.a(ae.a);
            Iterator<b> it = this.N.iterator();
            while (it.hasNext()) {
                it.next().a.a(false);
            }
            this.N.clear();
            this.ac = 0;
        }
        ae aeVar = z4 ? ae.a : this.R.a;
        Object obj = z4 ? null : this.R.b;
        s.a aVar = z3 ? new s.a(j()) : this.R.f10060c;
        long j2 = com.anythink.expressad.exoplayer.b.b;
        long j3 = z3 ? -9223372036854775807L : this.R.f10067j;
        if (!z3) {
            j2 = this.R.f10062e;
        }
        long j4 = j2;
        u uVar = this.R;
        this.R = new u(aeVar, obj, aVar, j3, j4, uVar.f10063f, false, z4 ? af.a : uVar.f10065h, z4 ? this.B : this.R.f10066i);
        if (!z2 || (sVar = this.S) == null) {
            return;
        }
        sVar.a(this);
        this.S = null;
    }

    private boolean h(boolean z2) {
        if (this.T.length == 0) {
            return m();
        }
        if (!z2) {
            return false;
        }
        if (!this.R.f10064g) {
            return true;
        }
        q qVarB = this.P.b();
        long jA = qVarB.a(!qVarB.f10016h.f10028g);
        return jA == Long.MIN_VALUE || this.C.a(jA - (this.ab - qVarB.f10013e), this.L.e().b, this.W);
    }

    private boolean a(b bVar) {
        Object obj = bVar.f9805d;
        if (obj == null) {
            Pair<Integer, Long> pairA = a(new d(bVar.a.a(), bVar.a.g(), com.anythink.expressad.exoplayer.b.b(bVar.a.f())), false);
            if (pairA == null) {
                return false;
            }
            bVar.a(((Integer) pairA.first).intValue(), ((Long) pairA.second).longValue(), this.R.a.a(((Integer) pairA.first).intValue(), this.I, true).b);
        } else {
            int iA = this.R.a.a(obj);
            if (iA == -1) {
                return false;
            }
            bVar.b = iA;
        }
        return true;
    }

    private static void a(y yVar) {
        if (yVar.a_() == 2) {
            yVar.k();
        }
    }

    private void a(com.anythink.expressad.exoplayer.i.i iVar) {
        this.C.a(this.f9801y, iVar.f9568c);
    }

    private void a(float f2) {
        for (q qVarE = this.P.e(); qVarE != null; qVarE = qVarE.f10017i) {
            com.anythink.expressad.exoplayer.i.i iVar = qVarE.f10019k;
            if (iVar != null) {
                for (com.anythink.expressad.exoplayer.i.f fVar : iVar.f9568c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private void a(a aVar) throws g {
        if (aVar.a != this.S) {
            return;
        }
        ae aeVar = this.R.a;
        ae aeVar2 = aVar.b;
        Object obj = aVar.f9803c;
        this.P.a(aeVar2);
        this.R = this.R.a(aeVar2, obj);
        for (int size = this.N.size() - 1; size >= 0; size--) {
            if (!a(this.N.get(size))) {
                this.N.get(size).a.a(false);
                this.N.remove(size);
            }
        }
        Collections.sort(this.N);
        int i2 = this.Z;
        if (i2 > 0) {
            this.M.a(i2);
            this.Z = 0;
            d dVar = this.aa;
            if (dVar != null) {
                Pair<Integer, Long> pairA = a(dVar, true);
                this.aa = null;
                if (pairA == null) {
                    o();
                    return;
                }
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue = ((Long) pairA.second).longValue();
                s.a aVarA = this.P.a(iIntValue, jLongValue);
                this.R = this.R.a(aVarA, aVarA.a() ? 0L : jLongValue, jLongValue);
                return;
            }
            if (this.R.f10061d == com.anythink.expressad.exoplayer.b.b) {
                if (aeVar2.a()) {
                    o();
                    return;
                }
                Pair<Integer, Long> pairA2 = a(aeVar2, aeVar2.b(this.Y));
                int iIntValue2 = ((Integer) pairA2.first).intValue();
                long jLongValue2 = ((Long) pairA2.second).longValue();
                s.a aVarA2 = this.P.a(iIntValue2, jLongValue2);
                this.R = this.R.a(aVarA2, aVarA2.a() ? 0L : jLongValue2, jLongValue2);
                return;
            }
            return;
        }
        u uVar = this.R;
        int i3 = uVar.f10060c.a;
        long j2 = uVar.f10062e;
        if (aeVar.a()) {
            if (aeVar2.a()) {
                return;
            }
            s.a aVarA3 = this.P.a(i3, j2);
            this.R = this.R.a(aVarA3, aVarA3.a() ? 0L : j2, j2);
            return;
        }
        q qVarE = this.P.e();
        int iA = aeVar2.a(qVarE == null ? aeVar.a(i3, this.I, true).b : qVarE.b);
        if (iA == -1) {
            int iA2 = a(i3, aeVar, aeVar2);
            if (iA2 == -1) {
                o();
                return;
            }
            Pair<Integer, Long> pairA3 = a(aeVar2, aeVar2.a(iA2, this.I, false).f8469c);
            int iIntValue3 = ((Integer) pairA3.first).intValue();
            long jLongValue3 = ((Long) pairA3.second).longValue();
            s.a aVarA4 = this.P.a(iIntValue3, jLongValue3);
            aeVar2.a(iIntValue3, this.I, true);
            if (qVarE != null) {
                Object obj2 = this.I.b;
                qVarE.f10016h = qVarE.f10016h.a();
                while (true) {
                    qVarE = qVarE.f10017i;
                    if (qVarE == null) {
                        break;
                    } else if (qVarE.b.equals(obj2)) {
                        qVarE.f10016h = this.P.a(qVarE.f10016h, iIntValue3);
                    } else {
                        qVarE.f10016h = qVarE.f10016h.a();
                    }
                }
            }
            this.R = this.R.a(aVarA4, a(aVarA4, aVarA4.a() ? 0L : jLongValue3), jLongValue3);
            return;
        }
        if (iA != i3) {
            this.R = this.R.a(iA);
        }
        s.a aVar2 = this.R.f10060c;
        if (aVar2.a()) {
            s.a aVarA5 = this.P.a(iA, j2);
            if (!aVarA5.equals(aVar2)) {
                this.R = this.R.a(aVarA5, a(aVarA5, aVarA5.a() ? 0L : j2), j2);
                return;
            }
        }
        if (this.P.a(aVar2, this.ab)) {
            return;
        }
        g(false);
    }

    private int a(int i2, ae aeVar, ae aeVar2) {
        int iC = aeVar.c();
        int iA = i2;
        int iA2 = -1;
        for (int i3 = 0; i3 < iC && iA2 == -1; i3++) {
            iA = aeVar.a(iA, this.I, this.H, this.X, this.Y);
            if (iA == -1) {
                break;
            }
            iA2 = aeVar2.a(aeVar.a(iA, this.I, true).b);
        }
        return iA2;
    }

    private Pair<Integer, Long> a(d dVar, boolean z2) {
        int iA;
        ae aeVar = this.R.a;
        ae aeVar2 = dVar.a;
        if (aeVar.a()) {
            return null;
        }
        if (aeVar2.a()) {
            aeVar2 = aeVar;
        }
        try {
            Pair<Integer, Long> pairA = aeVar2.a(this.H, this.I, dVar.b, dVar.f9808c);
            if (aeVar == aeVar2) {
                return pairA;
            }
            int iA2 = aeVar.a(aeVar2.a(((Integer) pairA.first).intValue(), this.I, true).b);
            if (iA2 != -1) {
                return Pair.create(Integer.valueOf(iA2), (Long) pairA.second);
            }
            if (!z2 || (iA = a(((Integer) pairA.first).intValue(), aeVar2, aeVar)) == -1) {
                return null;
            }
            return a(aeVar, aeVar.a(iA, this.I, false).f8469c);
        } catch (IndexOutOfBoundsException unused) {
            throw new o(aeVar, dVar.b, dVar.f9808c);
        }
    }

    private Pair<Integer, Long> a(ae aeVar, int i2) {
        return aeVar.a(this.H, this.I, i2, com.anythink.expressad.exoplayer.b.b);
    }

    private void a(@Nullable q qVar) throws g {
        q qVarC = this.P.c();
        if (qVarC == null || qVar == qVarC) {
            return;
        }
        boolean[] zArr = new boolean[this.f9801y.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            y[] yVarArr = this.f9801y;
            if (i2 < yVarArr.length) {
                y yVar = yVarArr[i2];
                zArr[i2] = yVar.a_() != 0;
                if (qVarC.f10019k.a(i2)) {
                    i3++;
                }
                if (zArr[i2] && (!qVarC.f10019k.a(i2) || (yVar.i() && yVar.f() == qVar.f10011c[i2]))) {
                    b(yVar);
                }
                i2++;
            } else {
                this.R = this.R.a(qVarC.f10018j, qVarC.f10019k);
                a(zArr, i3);
                return;
            }
        }
    }

    private void a(boolean[] zArr, int i2) throws g {
        this.T = new y[i2];
        q qVarC = this.P.c();
        int i3 = 0;
        for (int i4 = 0; i4 < this.f9801y.length; i4++) {
            if (qVarC.f10019k.a(i4)) {
                a(i4, zArr[i4], i3);
                i3++;
            }
        }
    }

    private void a(int i2, boolean z2, int i3) throws g {
        q qVarC = this.P.c();
        y yVar = this.f9801y[i2];
        this.T[i3] = yVar;
        if (yVar.a_() == 0) {
            com.anythink.expressad.exoplayer.i.i iVar = qVarC.f10019k;
            aa aaVar = iVar.b[i2];
            m[] mVarArrA = a(iVar.f9568c.a(i2));
            boolean z3 = this.V && this.R.f10063f == 3;
            yVar.a(aaVar, mVarArrA, qVarC.f10011c[i2], this.ab, !z2 && z3, qVarC.f10013e);
            this.L.a(yVar);
            if (z3) {
                yVar.b_();
            }
        }
    }

    @NonNull
    private static m[] a(com.anythink.expressad.exoplayer.i.f fVar) {
        int iG = fVar != null ? fVar.g() : 0;
        m[] mVarArr = new m[iG];
        for (int i2 = 0; i2 < iG; i2++) {
            mVarArr[i2] = fVar.a(i2);
        }
        return mVarArr;
    }
}
