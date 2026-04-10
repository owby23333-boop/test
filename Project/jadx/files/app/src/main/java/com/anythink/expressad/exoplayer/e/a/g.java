package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.e.a.a;
import com.anythink.expressad.exoplayer.e.a.b;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.anythink.expressad.exoplayer.e.e, com.anythink.expressad.exoplayer.e.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8944e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8945f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8946g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8947h = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f8949j = 262144;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f8950k = 10485760;
    private long[][] A;
    private int B;
    private long C;
    private boolean D;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f8951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final s f8952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final s f8953n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final s f8954o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayDeque<a.C0187a> f8955p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8956q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8957r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f8958s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8959t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private s f8960u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8961v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8962w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8963x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.e.g f8964y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b[] f8965z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.anythink.expressad.exoplayer.e.h f8943d = new com.anythink.expressad.exoplayer.e.h() { // from class: com.anythink.expressad.exoplayer.e.a.g.1
        @Override // com.anythink.expressad.exoplayer.e.h
        public final com.anythink.expressad.exoplayer.e.e[] a() {
            return new com.anythink.expressad.exoplayer.e.e[]{new g()};
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8948i = af.f("qt  ");

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private static final class b {
        public final j a;
        public final m b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.e.m f8966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8967d;

        public b(j jVar, m mVar, com.anythink.expressad.exoplayer.e.m mVar2) {
            this.a = jVar;
            this.b = mVar;
            this.f8966c = mVar2;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface c {
    }

    public g() {
        this(0);
    }

    private int c(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        int i2;
        com.anythink.expressad.exoplayer.e.j jVar2;
        long jC = fVar.c();
        if (this.f8961v == -1) {
            int i3 = 0;
            boolean z2 = true;
            long j2 = Long.MAX_VALUE;
            boolean z3 = true;
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            long j4 = Long.MAX_VALUE;
            while (true) {
                b[] bVarArr = this.f8965z;
                if (i3 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i3];
                int i6 = bVar.f8967d;
                m mVar = bVar.b;
                if (i6 != mVar.b) {
                    long j5 = mVar.f9001c[i6];
                    long j6 = this.A[i3][i6];
                    long j7 = j5 - jC;
                    boolean z4 = j7 < 0 || j7 >= 262144;
                    if ((!z4 && z2) || (z4 == z2 && j7 < j4)) {
                        i5 = i3;
                        j4 = j7;
                        z2 = z4;
                        j3 = j6;
                    }
                    if (j6 < j2) {
                        i4 = i3;
                        z3 = z4;
                        j2 = j6;
                    }
                }
                i3++;
            }
            this.f8961v = (j2 == Long.MAX_VALUE || !z3 || j3 < j2 + f8950k) ? i5 : i4;
            if (this.f8961v == -1) {
                return -1;
            }
        }
        b bVar2 = this.f8965z[this.f8961v];
        com.anythink.expressad.exoplayer.e.m mVar2 = bVar2.f8966c;
        int i7 = bVar2.f8967d;
        m mVar3 = bVar2.b;
        long j8 = mVar3.f9001c[i7];
        int i8 = mVar3.f9002d[i7];
        long j9 = (j8 - jC) + ((long) this.f8962w);
        if (j9 < 0) {
            i2 = 1;
            jVar2 = jVar;
        } else {
            if (j9 < 262144) {
                if (bVar2.a.f8975i == 1) {
                    j9 += 8;
                    i8 -= 8;
                }
                fVar.c((int) j9);
                int i9 = bVar2.a.f8978l;
                if (i9 == 0) {
                    while (true) {
                        int i10 = this.f8962w;
                        if (i10 >= i8) {
                            break;
                        }
                        int iA = mVar2.a(fVar, i8 - i10, false);
                        this.f8962w += iA;
                        this.f8963x -= iA;
                    }
                } else {
                    byte[] bArr = this.f8953n.a;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i11 = 4 - i9;
                    while (this.f8962w < i8) {
                        int i12 = this.f8963x;
                        if (i12 == 0) {
                            fVar.b(this.f8953n.a, i11, i9);
                            this.f8953n.c(0);
                            this.f8963x = this.f8953n.m();
                            this.f8952m.c(0);
                            mVar2.a(this.f8952m, 4);
                            this.f8962w += 4;
                            i8 += i11;
                        } else {
                            int iA2 = mVar2.a(fVar, i12, false);
                            this.f8962w += iA2;
                            this.f8963x -= iA2;
                        }
                    }
                }
                m mVar4 = bVar2.b;
                mVar2.a(mVar4.f9004f[i7], mVar4.f9005g[i7], i8, 0, null);
                bVar2.f8967d++;
                this.f8961v = -1;
                this.f8962w = 0;
                this.f8963x = 0;
                return 0;
            }
            jVar2 = jVar;
            i2 = 1;
        }
        jVar2.a = j8;
        return i2;
    }

    private void d() {
        this.f8956q = 0;
        this.f8959t = 0;
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return i.b(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final long b() {
        return this.C;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void c() {
    }

    public g(int i2) {
        this.f8951l = i2;
        this.f8954o = new s(16);
        this.f8955p = new ArrayDeque<>();
        this.f8952m = new s(p.a);
        this.f8953n = new s(4);
        this.f8961v = -1;
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar) throws t {
        if (this.f8959t == 0) {
            if (!fVar.a(this.f8954o.a, 0, 8, true)) {
                return false;
            }
            this.f8959t = 8;
            this.f8954o.c(0);
            this.f8958s = this.f8954o.h();
            this.f8957r = this.f8954o.i();
        }
        long j2 = this.f8958s;
        if (j2 == 1) {
            fVar.b(this.f8954o.a, 8, 8);
            this.f8959t += 8;
            this.f8958s = this.f8954o.n();
        } else if (j2 == 0) {
            long jD = fVar.d();
            if (jD == -1 && !this.f8955p.isEmpty()) {
                jD = this.f8955p.peek().aV;
            }
            if (jD != -1) {
                this.f8958s = (jD - fVar.c()) + ((long) this.f8959t);
            }
        }
        if (this.f8958s < this.f8959t) {
            throw new t("Atom size less than header length (unsupported).");
        }
        int i2 = this.f8957r;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.U) {
            long jC = (fVar.c() + this.f8958s) - ((long) this.f8959t);
            this.f8955p.push(new a.C0187a(this.f8957r, jC));
            if (this.f8958s == this.f8959t) {
                b(jC);
            } else {
                d();
            }
        } else {
            int i3 = this.f8957r;
            if (i3 == com.anythink.expressad.exoplayer.e.a.a.W || i3 == com.anythink.expressad.exoplayer.e.a.a.H || i3 == com.anythink.expressad.exoplayer.e.a.a.X || i3 == com.anythink.expressad.exoplayer.e.a.a.Y || i3 == com.anythink.expressad.exoplayer.e.a.a.ar || i3 == com.anythink.expressad.exoplayer.e.a.a.as || i3 == com.anythink.expressad.exoplayer.e.a.a.at || i3 == com.anythink.expressad.exoplayer.e.a.a.V || i3 == com.anythink.expressad.exoplayer.e.a.a.au || i3 == com.anythink.expressad.exoplayer.e.a.a.av || i3 == com.anythink.expressad.exoplayer.e.a.a.aw || i3 == com.anythink.expressad.exoplayer.e.a.a.ax || i3 == com.anythink.expressad.exoplayer.e.a.a.ay || i3 == com.anythink.expressad.exoplayer.e.a.a.T || i3 == com.anythink.expressad.exoplayer.e.a.a.f8839f || i3 == com.anythink.expressad.exoplayer.e.a.a.aF) {
                com.anythink.expressad.exoplayer.k.a.b(this.f8959t == 8);
                com.anythink.expressad.exoplayer.k.a.b(this.f8958s <= 2147483647L);
                this.f8960u = new s((int) this.f8958s);
                System.arraycopy(this.f8954o.a, 0, this.f8960u.a, 0, 8);
                this.f8956q = 1;
            } else {
                this.f8960u = null;
                this.f8956q = 1;
            }
        }
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(com.anythink.expressad.exoplayer.e.g gVar) {
        this.f8964y = gVar;
    }

    private void d(long j2) {
        for (b bVar : this.f8965z) {
            m mVar = bVar.b;
            int iA = mVar.a(j2);
            if (iA == -1) {
                iA = mVar.b(j2);
            }
            bVar.f8967d = iA;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(long j2, long j3) {
        this.f8955p.clear();
        this.f8959t = 0;
        this.f8961v = -1;
        this.f8962w = 0;
        this.f8963x = 0;
        if (j2 == 0) {
            d();
            return;
        }
        b[] bVarArr = this.f8965z;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                m mVar = bVar.b;
                int iA = mVar.a(j3);
                if (iA == -1) {
                    iA = mVar.b(j3);
                }
                bVar.f8967d = iA;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0347 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.anythink.expressad.exoplayer.e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.anythink.expressad.exoplayer.e.f r32, com.anythink.expressad.exoplayer.e.j r33) throws com.anythink.expressad.exoplayer.t {
        /*
            Method dump skipped, instruction units count: 851
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.g.a(com.anythink.expressad.exoplayer.e.f, com.anythink.expressad.exoplayer.e.j):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.anythink.expressad.exoplayer.e.f r10, com.anythink.expressad.exoplayer.e.j r11) throws com.anythink.expressad.exoplayer.t {
        /*
            r9 = this;
            long r0 = r9.f8958s
            int r2 = r9.f8959t
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.c()
            long r2 = r2 + r0
            com.anythink.expressad.exoplayer.k.s r4 = r9.f8960u
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L64
            byte[] r11 = r4.a
            int r4 = r9.f8959t
            int r1 = (int) r0
            r10.b(r11, r4, r1)
            int r10 = r9.f8957r
            int r11 = com.anythink.expressad.exoplayer.e.a.a.f8839f
            if (r10 != r11) goto L47
            com.anythink.expressad.exoplayer.k.s r10 = r9.f8960u
            r11 = 8
            r10.c(r11)
            int r11 = r10.i()
            int r0 = com.anythink.expressad.exoplayer.e.a.g.f8948i
            if (r11 != r0) goto L30
        L2e:
            r10 = 1
            goto L44
        L30:
            r11 = 4
            r10.d(r11)
        L34:
            int r11 = r10.a()
            if (r11 <= 0) goto L43
            int r11 = r10.i()
            int r0 = com.anythink.expressad.exoplayer.e.a.g.f8948i
            if (r11 != r0) goto L34
            goto L2e
        L43:
            r10 = 0
        L44:
            r9.D = r10
            goto L6f
        L47:
            java.util.ArrayDeque<com.anythink.expressad.exoplayer.e.a.a$a> r10 = r9.f8955p
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L6f
            java.util.ArrayDeque<com.anythink.expressad.exoplayer.e.a.a$a> r10 = r9.f8955p
            java.lang.Object r10 = r10.peek()
            com.anythink.expressad.exoplayer.e.a.a$a r10 = (com.anythink.expressad.exoplayer.e.a.a.C0187a) r10
            com.anythink.expressad.exoplayer.e.a.a$b r11 = new com.anythink.expressad.exoplayer.e.a.a$b
            int r0 = r9.f8957r
            com.anythink.expressad.exoplayer.k.s r1 = r9.f8960u
            r11.<init>(r0, r1)
            r10.a(r11)
            goto L6f
        L64:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L71
            int r11 = (int) r0
            r10.c(r11)
        L6f:
            r10 = 0
            goto L79
        L71:
            long r7 = r10.c()
            long r7 = r7 + r0
            r11.a = r7
            r10 = 1
        L79:
            r9.b(r2)
            if (r10 == 0) goto L84
            int r10 = r9.f8956q
            r11 = 2
            if (r10 == r11) goto L84
            return r6
        L84:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.g.b(com.anythink.expressad.exoplayer.e.f, com.anythink.expressad.exoplayer.e.j):boolean");
    }

    private int c(long j2) {
        int i2 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        int i3 = -1;
        int i4 = -1;
        boolean z3 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            b[] bVarArr = this.f8965z;
            if (i2 >= bVarArr.length) {
                break;
            }
            b bVar = bVarArr[i2];
            int i5 = bVar.f8967d;
            m mVar = bVar.b;
            if (i5 != mVar.b) {
                long j6 = mVar.f9001c[i5];
                long j7 = this.A[i2][i5];
                long j8 = j6 - j2;
                boolean z4 = j8 < 0 || j8 >= 262144;
                if ((!z4 && z3) || (z4 == z3 && j8 < j5)) {
                    z3 = z4;
                    i4 = i2;
                    j5 = j8;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z2 = z4;
                    i3 = i2;
                    j3 = j7;
                }
            }
            i2++;
        }
        return (j3 == Long.MAX_VALUE || !z2 || j4 < j3 + f8950k) ? i4 : i3;
    }

    private void b(long j2) throws t {
        while (!this.f8955p.isEmpty() && this.f8955p.peek().aV == j2) {
            a.C0187a c0187aPop = this.f8955p.pop();
            if (c0187aPop.aU == com.anythink.expressad.exoplayer.e.a.a.G) {
                a(c0187aPop);
                this.f8955p.clear();
                this.f8956q = 2;
            } else if (!this.f8955p.isEmpty()) {
                this.f8955p.peek().a(c0187aPop);
            }
        }
        if (this.f8956q != 2) {
            d();
        }
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.U;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073 A[EDGE_INSN: B:37:0x0073->B:31:0x0073 BREAK  A[LOOP:0: B:23:0x0057->B:30:0x0070], SYNTHETIC] */
    @Override // com.anythink.expressad.exoplayer.e.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.exoplayer.e.k.a a(long r13) {
        /*
            r12 = this;
            com.anythink.expressad.exoplayer.e.a.g$b[] r0 = r12.f8965z
            int r1 = r0.length
            if (r1 != 0) goto Ld
            com.anythink.expressad.exoplayer.e.k$a r13 = new com.anythink.expressad.exoplayer.e.k$a
            com.anythink.expressad.exoplayer.e.l r14 = com.anythink.expressad.exoplayer.e.l.a
            r13.<init>(r14)
            return r13
        Ld:
            r1 = -1
            int r3 = r12.B
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == r4) goto L4e
            r0 = r0[r3]
            com.anythink.expressad.exoplayer.e.a.m r0 = r0.b
            int r3 = a(r0, r13)
            if (r3 != r4) goto L2b
            com.anythink.expressad.exoplayer.e.k$a r13 = new com.anythink.expressad.exoplayer.e.k$a
            com.anythink.expressad.exoplayer.e.l r14 = com.anythink.expressad.exoplayer.e.l.a
            r13.<init>(r14)
            return r13
        L2b:
            long[] r7 = r0.f9004f
            r8 = r7[r3]
            long[] r7 = r0.f9001c
            r10 = r7[r3]
            int r7 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r7 >= 0) goto L54
            int r7 = r0.b
            int r7 = r7 + (-1)
            if (r3 >= r7) goto L54
            int r13 = r0.b(r13)
            if (r13 == r4) goto L54
            if (r13 == r3) goto L54
            long[] r14 = r0.f9004f
            r1 = r14[r13]
            long[] r14 = r0.f9001c
            r13 = r14[r13]
            goto L56
        L4e:
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8 = r13
        L54:
            r13 = r1
            r1 = r5
        L56:
            r0 = 0
        L57:
            com.anythink.expressad.exoplayer.e.a.g$b[] r3 = r12.f8965z
            int r4 = r3.length
            if (r0 >= r4) goto L73
            int r4 = r12.B
            if (r0 == r4) goto L70
            r3 = r3[r0]
            com.anythink.expressad.exoplayer.e.a.m r3 = r3.b
            long r10 = a(r3, r8, r10)
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 == 0) goto L70
            long r13 = a(r3, r1, r13)
        L70:
            int r0 = r0 + 1
            goto L57
        L73:
            com.anythink.expressad.exoplayer.e.l r0 = new com.anythink.expressad.exoplayer.e.l
            r0.<init>(r8, r10)
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L82
            com.anythink.expressad.exoplayer.e.k$a r13 = new com.anythink.expressad.exoplayer.e.k$a
            r13.<init>(r0)
            return r13
        L82:
            com.anythink.expressad.exoplayer.e.l r3 = new com.anythink.expressad.exoplayer.e.l
            r3.<init>(r1, r13)
            com.anythink.expressad.exoplayer.e.k$a r13 = new com.anythink.expressad.exoplayer.e.k$a
            r13.<init>(r0, r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.g.a(long):com.anythink.expressad.exoplayer.e.k$a");
    }

    private void a(a.C0187a c0187a) throws t {
        com.anythink.expressad.exoplayer.g.a aVarA;
        ArrayList<m> arrayListA;
        ArrayList arrayList = new ArrayList();
        com.anythink.expressad.exoplayer.e.i iVar = new com.anythink.expressad.exoplayer.e.i();
        a.b bVarD = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.aF);
        if (bVarD != null) {
            aVarA = com.anythink.expressad.exoplayer.e.a.b.a(bVarD, this.D);
            if (aVarA != null) {
                iVar.a(aVarA);
            }
        } else {
            aVarA = null;
        }
        int i2 = 1;
        int i3 = 0;
        try {
            arrayListA = a(c0187a, iVar, (this.f8951l & 1) != 0);
        } catch (b.g unused) {
            iVar = new com.anythink.expressad.exoplayer.e.i();
            arrayListA = a(c0187a, iVar, true);
        }
        int size = arrayListA.size();
        int size2 = -1;
        long jMax = com.anythink.expressad.exoplayer.b.b;
        while (i3 < size) {
            m mVar = arrayListA.get(i3);
            j jVar = mVar.a;
            b bVar = new b(jVar, mVar, this.f8964y.a(i3, jVar.f8970d));
            com.anythink.expressad.exoplayer.m mVarA = jVar.f8974h.a(mVar.f9003e + 30);
            if (jVar.f8970d == i2) {
                if (iVar.a()) {
                    mVarA = mVarA.a(iVar.b, iVar.f9020c);
                }
                if (aVarA != null) {
                    mVarA = mVarA.a(aVarA);
                }
            }
            bVar.f8966c.a(mVarA);
            long j2 = jVar.f8973g;
            if (j2 == com.anythink.expressad.exoplayer.b.b) {
                j2 = mVar.f9006h;
            }
            jMax = Math.max(jMax, j2);
            if (jVar.f8970d == 2 && size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(bVar);
            i3++;
            i2 = 1;
        }
        this.B = size2;
        this.C = jMax;
        this.f8965z = (b[]) arrayList.toArray(new b[arrayList.size()]);
        this.A = a(this.f8965z);
        this.f8964y.c_();
        this.f8964y.a(this);
    }

    private ArrayList<m> a(a.C0187a c0187a, com.anythink.expressad.exoplayer.e.i iVar, boolean z2) throws t {
        j jVarA;
        ArrayList<m> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < c0187a.aX.size(); i2++) {
            a.C0187a c0187a2 = c0187a.aX.get(i2);
            if (c0187a2.aU == com.anythink.expressad.exoplayer.e.a.a.I && (jVarA = com.anythink.expressad.exoplayer.e.a.b.a(c0187a2, c0187a.d(com.anythink.expressad.exoplayer.e.a.a.H), com.anythink.expressad.exoplayer.b.b, (com.anythink.expressad.exoplayer.d.e) null, z2, this.D)) != null) {
                m mVarA = com.anythink.expressad.exoplayer.e.a.b.a(jVarA, c0187a2.e(com.anythink.expressad.exoplayer.e.a.a.J).e(com.anythink.expressad.exoplayer.e.a.a.K).e(com.anythink.expressad.exoplayer.e.a.a.L), iVar);
                if (mVarA.b != 0) {
                    arrayList.add(mVarA);
                }
            }
        }
        return arrayList;
    }

    private static long[][] a(b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            jArr[i2] = new long[bVarArr[i2].b.b];
            jArr2[i2] = bVarArr[i2].b.f9004f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < bVarArr.length) {
            int i4 = -1;
            long j3 = Long.MAX_VALUE;
            for (int i5 = 0; i5 < bVarArr.length; i5++) {
                if (!zArr[i5] && jArr2[i5] <= j3) {
                    j3 = jArr2[i5];
                    i4 = i5;
                }
            }
            int i6 = iArr[i4];
            jArr[i4][i6] = j2;
            j2 += (long) bVarArr[i4].b.f9002d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr[i4].length) {
                jArr2[i4] = bVarArr[i4].b.f9004f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private static long a(m mVar, long j2, long j3) {
        int iA = a(mVar, j2);
        return iA == -1 ? j3 : Math.min(mVar.f9001c[iA], j3);
    }

    private static int a(m mVar, long j2) {
        int iA = mVar.a(j2);
        return iA == -1 ? mVar.b(j2) : iA;
    }

    private static boolean a(s sVar) {
        sVar.c(8);
        if (sVar.i() == f8948i) {
            return true;
        }
        sVar.d(4);
        while (sVar.a() > 0) {
            if (sVar.i() == f8948i) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.W || i2 == com.anythink.expressad.exoplayer.e.a.a.H || i2 == com.anythink.expressad.exoplayer.e.a.a.X || i2 == com.anythink.expressad.exoplayer.e.a.a.Y || i2 == com.anythink.expressad.exoplayer.e.a.a.ar || i2 == com.anythink.expressad.exoplayer.e.a.a.as || i2 == com.anythink.expressad.exoplayer.e.a.a.at || i2 == com.anythink.expressad.exoplayer.e.a.a.V || i2 == com.anythink.expressad.exoplayer.e.a.a.au || i2 == com.anythink.expressad.exoplayer.e.a.a.av || i2 == com.anythink.expressad.exoplayer.e.a.a.aw || i2 == com.anythink.expressad.exoplayer.e.a.a.ax || i2 == com.anythink.expressad.exoplayer.e.a.a.ay || i2 == com.anythink.expressad.exoplayer.e.a.a.T || i2 == com.anythink.expressad.exoplayer.e.a.a.f8839f || i2 == com.anythink.expressad.exoplayer.e.a.a.aF;
    }
}
