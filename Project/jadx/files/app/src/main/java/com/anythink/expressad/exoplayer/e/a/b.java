package com.anythink.expressad.exoplayer.e.a;

import android.util.Pair;
import com.anythink.expressad.exoplayer.e.a.a;
import com.anythink.expressad.exoplayer.e.a.d;
import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class b {
    private static final String a = "AtomParsers";
    private static final int b = af.f("vide");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8860c = af.f("soun");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8861d = af.f("text");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8862e = af.f("sbtl");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8863f = af.f("subt");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8864g = af.f("clcp");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8865h = af.f(TTDownloadField.TT_META);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8866i = 3;

    private static final class a {
        public final int a;
        public int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f8869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final s f8870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final s f8871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f8872h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f8873i;

        public a(s sVar, s sVar2, boolean z2) {
            this.f8871g = sVar;
            this.f8870f = sVar2;
            this.f8869e = z2;
            sVar2.c(12);
            this.a = sVar2.m();
            sVar.c(12);
            this.f8873i = sVar.m();
            com.anythink.expressad.exoplayer.k.a.b(sVar.i() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public final boolean a() {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == this.a) {
                return false;
            }
            this.f8868d = this.f8869e ? this.f8870f.n() : this.f8870f.h();
            if (this.b == this.f8872h) {
                this.f8867c = this.f8871g.m();
                this.f8871g.d(4);
                int i3 = this.f8873i - 1;
                this.f8873i = i3;
                this.f8872h = i3 > 0 ? this.f8871g.m() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.e.a.b$b, reason: collision with other inner class name */
    private interface InterfaceC0188b {
        int a();

        int b();

        boolean c();
    }

    private static final class c {
        public static final int a = 8;
        public final k[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.anythink.expressad.exoplayer.m f8874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8875d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8876e = 0;

        public c(int i2) {
            this.b = new k[i2];
        }
    }

    static final class d implements InterfaceC0188b {
        private final int a;
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final s f8877c;

        public d(a.b bVar) {
            this.f8877c = bVar.aV;
            this.f8877c.c(12);
            this.a = this.f8877c.m();
            this.b = this.f8877c.m();
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0188b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0188b
        public final int b() {
            int i2 = this.a;
            return i2 == 0 ? this.f8877c.m() : i2;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0188b
        public final boolean c() {
            return this.a != 0;
        }
    }

    static final class e implements InterfaceC0188b {
        private final s a;
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8880e;

        public e(a.b bVar) {
            this.a = bVar.aV;
            this.a.c(12);
            this.f8878c = this.a.m() & 255;
            this.b = this.a.m();
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0188b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0188b
        public final int b() {
            int i2 = this.f8878c;
            if (i2 == 8) {
                return this.a.d();
            }
            if (i2 == 16) {
                return this.a.e();
            }
            int i3 = this.f8879d;
            this.f8879d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f8880e & 15;
            }
            this.f8880e = this.a.d();
            return (this.f8880e & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0188b
        public final boolean c() {
            return false;
        }
    }

    private static final class f {
        private final int a;
        private final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8881c;

        public f(int i2, long j2, int i3) {
            this.a = i2;
            this.b = j2;
            this.f8881c = i3;
        }
    }

    public static final class g extends t {
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.exoplayer.e.a.j a(com.anythink.expressad.exoplayer.e.a.a.C0187a r24, com.anythink.expressad.exoplayer.e.a.a.b r25, long r26, com.anythink.expressad.exoplayer.d.e r28, boolean r29, boolean r30) throws com.anythink.expressad.exoplayer.t {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.b.a(com.anythink.expressad.exoplayer.e.a.a$a, com.anythink.expressad.exoplayer.e.a.a$b, long, com.anythink.expressad.exoplayer.d.e, boolean, boolean):com.anythink.expressad.exoplayer.e.a.j");
    }

    private static com.anythink.expressad.exoplayer.g.a b(s sVar, int i2) {
        sVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (sVar.c() < i2) {
            a.InterfaceC0191a interfaceC0191aA = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
            if (interfaceC0191aA != null) {
                arrayList.add(interfaceC0191aA);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.g.a(arrayList);
    }

    private static int c(s sVar) {
        sVar.c(16);
        int i2 = sVar.i();
        if (i2 == f8860c) {
            return 1;
        }
        if (i2 == b) {
            return 2;
        }
        if (i2 == f8861d || i2 == f8862e || i2 == f8863f || i2 == f8864g) {
            return 3;
        }
        return i2 == f8865h ? 4 : -1;
    }

    private static Pair<Long, String> d(s sVar) {
        sVar.c(8);
        int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(iA == 0 ? 8 : 16);
        long jH = sVar.h();
        sVar.d(iA == 0 ? 4 : 8);
        int iE = sVar.e();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((iE >> 10) & 31) + 96));
        sb.append((char) (((iE >> 5) & 31) + 96));
        sb.append((char) ((iE & 31) + 96));
        return Pair.create(Long.valueOf(jH), sb.toString());
    }

    private static int e(s sVar) {
        int iD = sVar.d();
        int i2 = iD & 127;
        while ((iD & 128) == 128) {
            iD = sVar.d();
            i2 = (i2 << 7) | (iD & 127);
        }
        return i2;
    }

    private static f b(s sVar) {
        boolean z2;
        sVar.c(8);
        int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(iA == 0 ? 8 : 16);
        int i2 = sVar.i();
        sVar.d(4);
        int iC = sVar.c();
        int i3 = iA == 0 ? 4 : 8;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                z2 = true;
                break;
            }
            if (sVar.a[iC + i5] != -1) {
                z2 = false;
                break;
            }
            i5++;
        }
        long j2 = com.anythink.expressad.exoplayer.b.b;
        if (z2) {
            sVar.d(i3);
        } else {
            long jH = iA == 0 ? sVar.h() : sVar.n();
            if (jH != 0) {
                j2 = jH;
            }
        }
        sVar.d(16);
        int i6 = sVar.i();
        int i7 = sVar.i();
        sVar.d(4);
        int i8 = sVar.i();
        int i9 = sVar.i();
        if (i6 == 0 && i7 == 65536 && i8 == -65536 && i9 == 0) {
            i4 = 90;
        } else if (i6 == 0 && i7 == -65536 && i8 == 65536 && i9 == 0) {
            i4 = SubsamplingScaleImageView.ORIENTATION_270;
        } else if (i6 == -65536 && i7 == 0 && i8 == 0 && i9 == -65536) {
            i4 = 180;
        }
        return new f(i2, j2, i4);
    }

    private static float c(s sVar, int i2) {
        sVar.c(i2 + 8);
        return sVar.m() / sVar.m();
    }

    private static Pair<Integer, k> c(s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        String strO = null;
        Integer numValueOf = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i7 = sVar.i();
            int i8 = sVar.i();
            if (i8 == com.anythink.expressad.exoplayer.e.a.a.ag) {
                numValueOf = Integer.valueOf(sVar.i());
            } else if (i8 == com.anythink.expressad.exoplayer.e.a.a.ab) {
                sVar.d(4);
                strO = sVar.o();
            } else if (i8 == com.anythink.expressad.exoplayer.e.a.a.ac) {
                i5 = i4;
                i6 = i7;
            }
            i4 += i7;
        }
        if (!com.anythink.expressad.exoplayer.b.bd.equals(strO) && !com.anythink.expressad.exoplayer.b.be.equals(strO) && !com.anythink.expressad.exoplayer.b.bf.equals(strO) && !com.anythink.expressad.exoplayer.b.bg.equals(strO)) {
            return null;
        }
        com.anythink.expressad.exoplayer.k.a.a(numValueOf != null, "frma atom is mandatory");
        com.anythink.expressad.exoplayer.k.a.a(i5 != -1, "schi atom is mandatory");
        k kVarA = a(sVar, i5, i6, strO);
        com.anythink.expressad.exoplayer.k.a.a(kVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, kVarA);
    }

    private static Pair<String, byte[]> d(s sVar, int i2) {
        sVar.c(i2 + 8 + 4);
        sVar.d(1);
        e(sVar);
        sVar.d(2);
        int iD = sVar.d();
        if ((iD & 128) != 0) {
            sVar.d(2);
        }
        if ((iD & 64) != 0) {
            sVar.d(sVar.e());
        }
        if ((iD & 32) != 0) {
            sVar.d(2);
        }
        sVar.d(1);
        e(sVar);
        String strA = o.a(sVar.d());
        if (!o.f9875t.equals(strA) && !o.D.equals(strA) && !o.E.equals(strA)) {
            sVar.d(12);
            sVar.d(1);
            int iE = e(sVar);
            byte[] bArr = new byte[iE];
            sVar.a(bArr, 0, iE);
            return Pair.create(strA, bArr);
        }
        return Pair.create(strA, null);
    }

    private static Pair<Integer, k> b(s sVar, int i2, int i3) {
        Pair<Integer, k> pairC;
        int iC = sVar.c();
        while (iC - i2 < i3) {
            sVar.c(iC);
            int i4 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i4 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aa && (pairC = c(sVar, iC, i4)) != null) {
                return pairC;
            }
            iC += i4;
        }
        return null;
    }

    private static byte[] d(s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i5 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                return Arrays.copyOfRange(sVar.a, i4, i5 + i4);
            }
            i4 += i5;
        }
        return null;
    }

    public static m a(j jVar, a.C0187a c0187a, com.anythink.expressad.exoplayer.e.i iVar) throws t {
        InterfaceC0188b eVar;
        boolean z2;
        int iM;
        int iM2;
        long[] jArr;
        int[] iArr;
        long j2;
        int i2;
        long[] jArr2;
        int[] iArr2;
        long j3;
        int[] iArr3;
        long[] jArr3;
        int[] iArr4;
        int i3;
        int i4;
        int i5;
        int i6;
        j jVar2 = jVar;
        a.b bVarD = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.av);
        if (bVarD != null) {
            eVar = new d(bVarD);
        } else {
            a.b bVarD2 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.aw);
            if (bVarD2 != null) {
                eVar = new e(bVarD2);
            } else {
                throw new t("Track has no sample table size information");
            }
        }
        int iA = eVar.a();
        if (iA == 0) {
            return new m(jVar, new long[0], new int[0], 0, new long[0], new int[0], com.anythink.expressad.exoplayer.b.b);
        }
        a.b bVarD3 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.ax);
        if (bVarD3 == null) {
            bVarD3 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.ay);
            z2 = true;
        } else {
            z2 = false;
        }
        s sVar = bVarD3.aV;
        s sVar2 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.au).aV;
        s sVar3 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.ar).aV;
        a.b bVarD4 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.as);
        s sVar4 = bVarD4 != null ? bVarD4.aV : null;
        a.b bVarD5 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.at);
        s sVar5 = bVarD5 != null ? bVarD5.aV : null;
        a aVar = new a(sVar2, sVar, z2);
        sVar3.c(12);
        int iM3 = sVar3.m() - 1;
        int iM4 = sVar3.m();
        int iM5 = sVar3.m();
        if (sVar5 != null) {
            sVar5.c(12);
            iM = sVar5.m();
        } else {
            iM = 0;
        }
        int iM6 = -1;
        if (sVar4 != null) {
            sVar4.c(12);
            iM2 = sVar4.m();
            if (iM2 > 0) {
                iM6 = sVar4.m() - 1;
            } else {
                sVar4 = null;
            }
        } else {
            iM2 = 0;
        }
        long j4 = 0;
        if (!(eVar.c() && o.f9878w.equals(jVar2.f8974h.f9990h) && iM3 == 0 && iM == 0 && iM2 == 0)) {
            long[] jArr4 = new long[iA];
            int[] iArr5 = new int[iA];
            long[] jArr5 = new long[iA];
            int i7 = iM2;
            iArr2 = new int[iA];
            int i8 = iM3;
            int iM7 = iM4;
            int i9 = iM5;
            int i10 = iM;
            int iM8 = iM6;
            long j5 = 0;
            long j6 = 0;
            int i11 = 0;
            int i12 = 0;
            int iM9 = 0;
            int i13 = 0;
            int i14 = i7;
            int i15 = 0;
            while (i12 < iA) {
                long j7 = j6;
                int i16 = i15;
                while (i16 == 0) {
                    com.anythink.expressad.exoplayer.k.a.b(aVar.a());
                    j7 = aVar.f8868d;
                    i16 = aVar.f8867c;
                    i14 = i14;
                    i9 = i9;
                }
                int i17 = i14;
                int i18 = i9;
                if (sVar5 != null) {
                    while (iM9 == 0 && i10 > 0) {
                        iM9 = sVar5.m();
                        i13 = sVar5.i();
                        i10--;
                    }
                    iM9--;
                }
                int i19 = i13;
                jArr4[i12] = j7;
                iArr5[i12] = eVar.b();
                if (iArr5[i12] > i11) {
                    i11 = iArr5[i12];
                }
                InterfaceC0188b interfaceC0188b = eVar;
                long[] jArr6 = jArr4;
                jArr5[i12] = ((long) i19) + j5;
                iArr2[i12] = sVar4 == null ? 1 : 0;
                if (i12 == iM8) {
                    iArr2[i12] = 1;
                    int i20 = i17 - 1;
                    if (i20 > 0) {
                        iM8 = sVar4.m() - 1;
                    }
                    i6 = iM8;
                    i17 = i20;
                } else {
                    i6 = iM8;
                }
                int i21 = i18;
                j5 += (long) i21;
                iM7--;
                int i22 = i8;
                if (iM7 != 0 || i22 <= 0) {
                    i8 = i22;
                } else {
                    i8 = i22 - 1;
                    iM7 = sVar3.m();
                    i21 = sVar3.i();
                }
                long j8 = j7 + ((long) iArr5[i12]);
                i12++;
                int i23 = i21;
                iM8 = i6;
                i15 = i16 - 1;
                i9 = i23;
                i13 = i19;
                i14 = i17;
                j6 = j8;
                eVar = interfaceC0188b;
                jArr4 = jArr6;
            }
            int i24 = i14;
            int i25 = i13;
            int i26 = i8;
            long[] jArr7 = jArr4;
            j2 = j5 + ((long) i25);
            com.anythink.expressad.exoplayer.k.a.a(iM9 == 0);
            while (i10 > 0) {
                com.anythink.expressad.exoplayer.k.a.a(sVar5.m() == 0);
                sVar5.i();
                i10--;
            }
            if (i24 == 0 && iM7 == 0 && i15 == 0 && i26 == 0) {
                i5 = i11;
                jVar2 = jVar;
            } else {
                StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
                i5 = i11;
                jVar2 = jVar;
                sb.append(jVar2.f8969c);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i24);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(iM7);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i15);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i26);
                sb.toString();
            }
            jArr2 = jArr5;
            iArr = iArr5;
            i2 = i5;
            jArr = jArr7;
        } else {
            int i27 = aVar.a;
            long[] jArr8 = new long[i27];
            int[] iArr6 = new int[i27];
            while (aVar.a()) {
                int i28 = aVar.b;
                jArr8[i28] = aVar.f8868d;
                iArr6[i28] = aVar.f8867c;
            }
            com.anythink.expressad.exoplayer.m mVar = jVar2.f8974h;
            d.a aVarA = com.anythink.expressad.exoplayer.e.a.d.a(af.b(mVar.f10005w, mVar.f10003u), jArr8, iArr6, iM5);
            jArr = aVarA.a;
            iArr = aVarA.b;
            int i29 = aVarA.f8884c;
            long[] jArr9 = aVarA.f8885d;
            int[] iArr7 = aVarA.f8886e;
            j2 = aVarA.f8887f;
            i2 = i29;
            jArr2 = jArr9;
            iArr2 = iArr7;
        }
        long jA = af.a(j2, 1000000L, jVar2.f8971e);
        if (jVar2.f8976j != null && !iVar.a()) {
            long[] jArr10 = jVar2.f8976j;
            if (jArr10.length == 1 && jVar2.f8970d == 1 && jArr2.length >= 2) {
                long j9 = jVar2.f8977k[0];
                long jA2 = j9 + af.a(jArr10[0], jVar2.f8971e, jVar2.f8972f);
                int length = jArr2.length - 1;
                if (jArr2[0] <= j9 && j9 < jArr2[af.a(3, 0, length)] && jArr2[af.a(jArr2.length - 3, 0, length)] < jA2 && jA2 <= j2) {
                    long jA3 = af.a(j9 - jArr2[0], jVar2.f8974h.f10004v, jVar2.f8971e);
                    long jA4 = af.a(j2 - jA2, jVar2.f8974h.f10004v, jVar2.f8971e);
                    if ((jA3 != 0 || jA4 != 0) && jA3 <= 2147483647L && jA4 <= 2147483647L) {
                        iVar.b = (int) jA3;
                        iVar.f9020c = (int) jA4;
                        af.a(jArr2, jVar2.f8971e);
                        return new m(jVar, jArr, iArr, i2, jArr2, iArr2, jA);
                    }
                }
            }
            long[] jArr11 = jVar2.f8976j;
            if (jArr11.length == 1 && jArr11[0] == 0) {
                long j10 = jVar2.f8977k[0];
                for (int i30 = 0; i30 < jArr2.length; i30++) {
                    jArr2[i30] = af.a(jArr2[i30] - j10, 1000000L, jVar2.f8971e);
                }
                return new m(jVar, jArr, iArr, i2, jArr2, iArr2, af.a(j2 - j10, 1000000L, jVar2.f8971e));
            }
            boolean z3 = jVar2.f8970d == 1;
            int i31 = 0;
            boolean z4 = false;
            int i32 = 0;
            int i33 = 0;
            while (true) {
                long[] jArr12 = jVar2.f8976j;
                j3 = -1;
                if (i31 >= jArr12.length) {
                    break;
                }
                int[] iArr8 = iArr2;
                int i34 = i2;
                long j11 = jVar2.f8977k[i31];
                if (j11 != -1) {
                    long jA5 = af.a(jArr12[i31], jVar2.f8971e, jVar2.f8972f);
                    int iA2 = af.a(jArr2, j11, true, true);
                    int iA3 = af.a(jArr2, j11 + jA5, z3, false);
                    i32 += iA3 - iA2;
                    boolean z5 = i33 != iA2;
                    i33 = iA3;
                    z4 = z5 | z4;
                }
                i31++;
                iArr2 = iArr8;
                i2 = i34;
            }
            int[] iArr9 = iArr2;
            int i35 = i2;
            boolean z6 = (i32 != iA) | z4;
            long[] jArr13 = z6 ? new long[i32] : jArr;
            int[] iArr10 = z6 ? new int[i32] : iArr;
            if (z6) {
                i35 = 0;
            }
            int[] iArr11 = z6 ? new int[i32] : iArr9;
            long[] jArr14 = new long[i32];
            int i36 = 0;
            int i37 = 0;
            while (true) {
                long[] jArr15 = jVar2.f8976j;
                if (i36 < jArr15.length) {
                    int[] iArr12 = iArr11;
                    long[] jArr16 = jArr14;
                    long j12 = jVar2.f8977k[i36];
                    long j13 = jArr15[i36];
                    if (j12 != j3) {
                        long jA6 = af.a(j13, jVar2.f8971e, jVar2.f8972f) + j12;
                        int iA4 = af.a(jArr2, j12, true, true);
                        int iA5 = af.a(jArr2, jA6, z3, false);
                        if (z6) {
                            int i38 = iA5 - iA4;
                            System.arraycopy(jArr, iA4, jArr13, i37, i38);
                            System.arraycopy(iArr, iA4, iArr10, i37, i38);
                            iArr3 = iArr9;
                            jArr3 = jArr;
                            iArr4 = iArr12;
                            System.arraycopy(iArr3, iA4, iArr4, i37, i38);
                        } else {
                            iArr3 = iArr9;
                            jArr3 = jArr;
                            iArr4 = iArr12;
                        }
                        if (iA4 < iA5 && (iArr4[i37] & 1) == 0) {
                            throw new g();
                        }
                        int i39 = i37;
                        int i40 = i35;
                        while (iA4 < iA5) {
                            int i41 = i36;
                            int i42 = i40;
                            long j14 = j12;
                            jArr16[i39] = af.a(j4, 1000000L, jVar2.f8972f) + af.a(jArr2[iA4] - j12, 1000000L, jVar2.f8971e);
                            if (z6) {
                                i4 = i42;
                                if (iArr10[i39] > i4) {
                                    i40 = iArr[iA4];
                                }
                                i39++;
                                iA4++;
                                j12 = j14;
                                i36 = i41;
                            } else {
                                i4 = i42;
                            }
                            i40 = i4;
                            i39++;
                            iA4++;
                            j12 = j14;
                            i36 = i41;
                        }
                        i3 = i36;
                        i35 = i40;
                        i37 = i39;
                    } else {
                        iArr3 = iArr9;
                        jArr3 = jArr;
                        iArr4 = iArr12;
                        i3 = i36;
                    }
                    j4 += j13;
                    i36 = i3 + 1;
                    iArr11 = iArr4;
                    jArr14 = jArr16;
                    jArr = jArr3;
                    iArr9 = iArr3;
                    j3 = -1;
                } else {
                    return new m(jVar, jArr13, iArr10, i35, jArr14, iArr11, af.a(j4, 1000000L, jVar2.f8971e));
                }
            }
        } else {
            int i43 = i2;
            af.a(jArr2, jVar2.f8971e);
            return new m(jVar, jArr, iArr, i43, jArr2, iArr2, jA);
        }
    }

    public static com.anythink.expressad.exoplayer.g.a a(a.b bVar, boolean z2) {
        if (z2) {
            return null;
        }
        s sVar = bVar.aV;
        sVar.c(8);
        while (sVar.a() >= 8) {
            int iC = sVar.c();
            int i2 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aG) {
                sVar.c(iC);
                int i3 = iC + i2;
                sVar.d(12);
                while (true) {
                    if (sVar.c() >= i3) {
                        break;
                    }
                    int iC2 = sVar.c();
                    int i4 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aH) {
                        sVar.c(iC2);
                        int i5 = iC2 + i4;
                        sVar.d(8);
                        ArrayList arrayList = new ArrayList();
                        while (sVar.c() < i5) {
                            a.InterfaceC0191a interfaceC0191aA = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
                            if (interfaceC0191aA != null) {
                                arrayList.add(interfaceC0191aA);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new com.anythink.expressad.exoplayer.g.a(arrayList);
                        }
                    } else {
                        sVar.d(i4 - 8);
                    }
                }
                return null;
            }
            sVar.d(i2 - 8);
        }
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.a a(s sVar, int i2) {
        sVar.d(12);
        while (sVar.c() < i2) {
            int iC = sVar.c();
            int i3 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aH) {
                sVar.c(iC);
                int i4 = iC + i3;
                sVar.d(8);
                ArrayList arrayList = new ArrayList();
                while (sVar.c() < i4) {
                    a.InterfaceC0191a interfaceC0191aA = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
                    if (interfaceC0191aA != null) {
                        arrayList.add(interfaceC0191aA);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new com.anythink.expressad.exoplayer.g.a(arrayList);
            }
            sVar.d(i3 - 8);
        }
        return null;
    }

    private static long a(s sVar) {
        sVar.c(8);
        sVar.d(com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) != 0 ? 16 : 8);
        return sVar.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0347  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.e.a.b.c a(com.anythink.expressad.exoplayer.k.s r47, int r48, int r49, java.lang.String r50, com.anythink.expressad.exoplayer.d.e r51, boolean r52) throws com.anythink.expressad.exoplayer.t {
        /*
            Method dump skipped, instruction units count: 1349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.b.a(com.anythink.expressad.exoplayer.k.s, int, int, java.lang.String, com.anythink.expressad.exoplayer.d.e, boolean):com.anythink.expressad.exoplayer.e.a.b$c");
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, String str, c cVar) {
        sVar.c(i3 + 8 + 8);
        int i6 = com.anythink.expressad.exoplayer.e.a.a.ao;
        String str2 = o.Z;
        List listSingletonList = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != i6) {
            if (i2 == com.anythink.expressad.exoplayer.e.a.a.az) {
                int i7 = (i4 - 8) - 8;
                byte[] bArr = new byte[i7];
                sVar.a(bArr, 0, i7);
                listSingletonList = Collections.singletonList(bArr);
                str2 = o.aa;
            } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aA) {
                str2 = o.ab;
            } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aB) {
                j2 = 0;
            } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aC) {
                cVar.f8876e = 1;
                str2 = o.ac;
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.f8874c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str2, (String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j2, (List<byte[]>) listSingletonList);
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, int i6, com.anythink.expressad.exoplayer.d.e eVar, c cVar, int i7) throws t {
        int i8 = i3;
        com.anythink.expressad.exoplayer.d.e eVarA = eVar;
        sVar.c(i8 + 8 + 8);
        sVar.d(16);
        int iE = sVar.e();
        int iE2 = sVar.e();
        sVar.d(50);
        int iC = sVar.c();
        int iIntValue = i2;
        if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.ae) {
            Pair<Integer, k> pairB = b(sVar, i8, i4);
            if (pairB != null) {
                iIntValue = ((Integer) pairB.first).intValue();
                eVarA = eVarA == null ? null : eVarA.a(((k) pairB.second).b);
                cVar.b[i7] = (k) pairB.second;
            }
            sVar.c(iC);
        }
        com.anythink.expressad.exoplayer.d.e eVar2 = eVarA;
        String str = null;
        boolean z2 = false;
        List<byte[]> listSingletonList = null;
        float fM = 1.0f;
        byte[] bArrCopyOfRange = null;
        int i9 = -1;
        while (iC - i8 < i4) {
            sVar.c(iC);
            int iC2 = sVar.c();
            int i10 = sVar.i();
            if (i10 == 0 && sVar.c() - i8 == i4) {
                break;
            }
            com.anythink.expressad.exoplayer.k.a.a(i10 > 0, "childAtomSize should be positive");
            int i11 = sVar.i();
            if (i11 == com.anythink.expressad.exoplayer.e.a.a.M) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                sVar.c(iC2 + 8);
                com.anythink.expressad.exoplayer.l.a aVarA = com.anythink.expressad.exoplayer.l.a.a(sVar);
                listSingletonList = aVarA.a;
                cVar.f8875d = aVarA.b;
                if (!z2) {
                    fM = aVarA.f9933e;
                }
                str = o.f9863h;
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.N) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                sVar.c(iC2 + 8);
                com.anythink.expressad.exoplayer.l.d dVarA = com.anythink.expressad.exoplayer.l.d.a(sVar);
                listSingletonList = dVarA.a;
                cVar.f8875d = dVarA.b;
                str = o.f9864i;
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.aR) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                str = iIntValue == com.anythink.expressad.exoplayer.e.a.a.aP ? o.f9865j : o.f9866k;
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.f8845l) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                str = o.f9862g;
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.O) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                Pair<String, byte[]> pairD = d(sVar, iC2);
                String str2 = (String) pairD.first;
                listSingletonList = Collections.singletonList((byte[]) pairD.second);
                str = str2;
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.an) {
                sVar.c(iC2 + 8);
                fM = sVar.m() / sVar.m();
                z2 = true;
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.aN) {
                int i12 = iC2 + 8;
                while (true) {
                    if (i12 - iC2 >= i10) {
                        bArrCopyOfRange = null;
                        break;
                    }
                    sVar.c(i12);
                    int i13 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                        bArrCopyOfRange = Arrays.copyOfRange(sVar.a, i12, i13 + i12);
                        break;
                    }
                    i12 += i13;
                }
            } else if (i11 == com.anythink.expressad.exoplayer.e.a.a.aM) {
                int iD = sVar.d();
                sVar.d(3);
                if (iD == 0) {
                    int iD2 = sVar.d();
                    if (iD2 == 0) {
                        i9 = 0;
                    } else if (iD2 == 1) {
                        i9 = 1;
                    } else if (iD2 == 2) {
                        i9 = 2;
                    } else if (iD2 == 3) {
                        i9 = 3;
                    }
                }
            }
            iC += i10;
            i8 = i3;
        }
        if (str == null) {
            return;
        }
        cVar.f8874c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str, null, -1, -1, iE, iE2, -1.0f, listSingletonList, i6, fM, bArrCopyOfRange, i9, null, eVar2);
    }

    private static Pair<long[], long[]> a(a.C0187a c0187a) {
        a.b bVarD;
        if (c0187a != null && (bVarD = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.V)) != null) {
            s sVar = bVarD.aV;
            sVar.c(8);
            int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
            int iM = sVar.m();
            long[] jArr = new long[iM];
            long[] jArr2 = new long[iM];
            for (int i2 = 0; i2 < iM; i2++) {
                jArr[i2] = iA == 1 ? sVar.n() : sVar.h();
                jArr2[i2] = iA == 1 ? sVar.j() : sVar.i();
                if (sVar.f() == 1) {
                    sVar.d(2);
                } else {
                    throw new IllegalArgumentException("Unsupported media rate.");
                }
            }
            return Pair.create(jArr, jArr2);
        }
        return Pair.create(null, null);
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, String str, boolean z2, com.anythink.expressad.exoplayer.d.e eVar, c cVar, int i6) {
        int iE;
        int iE2;
        int iK;
        String str2;
        int i7;
        String str3;
        int i8;
        String str4;
        com.anythink.expressad.exoplayer.d.e eVar2;
        int iC;
        int i9 = i3;
        com.anythink.expressad.exoplayer.d.e eVarA = eVar;
        sVar.c(i9 + 8 + 8);
        if (z2) {
            iE = sVar.e();
            sVar.d(6);
        } else {
            sVar.d(8);
            iE = 0;
        }
        if (iE == 0 || iE == 1) {
            iE2 = sVar.e();
            sVar.d(6);
            iK = sVar.k();
            if (iE == 1) {
                sVar.d(16);
            }
        } else {
            if (iE != 2) {
                return;
            }
            sVar.d(16);
            int iRound = (int) Math.round(Double.longBitsToDouble(sVar.j()));
            int iM = sVar.m();
            sVar.d(20);
            iE2 = iM;
            iK = iRound;
        }
        int iC2 = sVar.c();
        int iIntValue = i2;
        if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.af) {
            Pair<Integer, k> pairB = b(sVar, i9, i4);
            if (pairB != null) {
                iIntValue = ((Integer) pairB.first).intValue();
                eVarA = eVarA == null ? null : eVarA.a(((k) pairB.second).b);
                cVar.b[i6] = (k) pairB.second;
            }
            sVar.c(iC2);
        }
        com.anythink.expressad.exoplayer.d.e eVar3 = eVarA;
        int i10 = com.anythink.expressad.exoplayer.e.a.a.f8852s;
        String str5 = o.f9878w;
        if (iIntValue == i10) {
            str2 = o.f9881z;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8854u) {
            str2 = o.A;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8856w) {
            str2 = o.D;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8857x || iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8858y) {
            str2 = o.E;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8859z) {
            str2 = o.F;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.aD) {
            str2 = o.I;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.aE) {
            str2 = o.J;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8850q || iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8851r) {
            str2 = o.f9878w;
        } else if (iIntValue == com.anythink.expressad.exoplayer.e.a.a.f8848o) {
            str2 = o.f9875t;
        } else {
            str2 = iIntValue == com.anythink.expressad.exoplayer.e.a.a.aT ? o.L : null;
        }
        int i11 = iK;
        int i12 = iC2;
        int iIntValue2 = iE2;
        byte[] bArr = null;
        String str6 = str2;
        while (i12 - i9 < i4) {
            sVar.c(i12);
            int i13 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i13 > 0, "childAtomSize should be positive");
            int i14 = sVar.i();
            if (i14 != com.anythink.expressad.exoplayer.e.a.a.O && (!z2 || i14 != com.anythink.expressad.exoplayer.e.a.a.f8849p)) {
                if (i14 == com.anythink.expressad.exoplayer.e.a.a.f8853t) {
                    sVar.c(i12 + 8);
                    cVar.f8874c = com.anythink.expressad.exoplayer.b.a.a(sVar, Integer.toString(i5), str, eVar3);
                } else if (i14 == com.anythink.expressad.exoplayer.e.a.a.f8855v) {
                    sVar.c(i12 + 8);
                    cVar.f8874c = com.anythink.expressad.exoplayer.b.a.b(sVar, Integer.toString(i5), str, eVar3);
                } else {
                    if (i14 == com.anythink.expressad.exoplayer.e.a.a.A) {
                        i7 = i13;
                        i8 = i12;
                        str4 = str5;
                        eVar2 = eVar3;
                        str3 = str6;
                        cVar.f8874c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str6, null, -1, iIntValue2, i11, null, eVar3, str);
                    } else {
                        i7 = i13;
                        str3 = str6;
                        i8 = i12;
                        str4 = str5;
                        eVar2 = eVar3;
                        if (i14 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                            byte[] bArr2 = new byte[i7];
                            sVar.c(i8);
                            sVar.a(bArr2, 0, i7);
                            str6 = str3;
                            bArr = bArr2;
                        }
                    }
                    str6 = str3;
                }
                i7 = i13;
                str3 = str6;
                i8 = i12;
                str4 = str5;
                eVar2 = eVar3;
                str6 = str3;
            } else {
                i7 = i13;
                str3 = str6;
                i8 = i12;
                str4 = str5;
                eVar2 = eVar3;
                if (i14 != com.anythink.expressad.exoplayer.e.a.a.O) {
                    iC = sVar.c();
                    while (true) {
                        if (iC - i8 >= i7) {
                            iC = -1;
                            break;
                        }
                        sVar.c(iC);
                        int i15 = sVar.i();
                        com.anythink.expressad.exoplayer.k.a.a(i15 > 0, "childAtomSize should be positive");
                        if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                            break;
                        } else {
                            iC += i15;
                        }
                    }
                } else {
                    iC = i8;
                }
                if (iC != -1) {
                    Pair<String, byte[]> pairD = d(sVar, iC);
                    String str7 = (String) pairD.first;
                    bArr = (byte[]) pairD.second;
                    if (o.f9873r.equals(str7)) {
                        Pair<Integer, Integer> pairA = com.anythink.expressad.exoplayer.k.d.a(bArr);
                        int iIntValue3 = ((Integer) pairA.first).intValue();
                        iIntValue2 = ((Integer) pairA.second).intValue();
                        str6 = str7;
                        i11 = iIntValue3;
                    } else {
                        str6 = str7;
                    }
                } else {
                    str6 = str3;
                }
            }
            i12 = i8 + i7;
            i9 = i3;
            eVar3 = eVar2;
            str5 = str4;
        }
        String str8 = str6;
        String str9 = str5;
        com.anythink.expressad.exoplayer.d.e eVar4 = eVar3;
        if (cVar.f8874c != null || str8 == null) {
            return;
        }
        cVar.f8874c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str8, (String) null, -1, iIntValue2, i11, str9.equals(str8) ? 2 : -1, (List<byte[]>) (bArr == null ? null : Collections.singletonList(bArr)), eVar4, str);
    }

    private static int a(s sVar, int i2, int i3) {
        int iC = sVar.c();
        while (iC - i2 < i3) {
            sVar.c(iC);
            int i4 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i4 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                return iC;
            }
            iC += i4;
        }
        return -1;
    }

    private static k a(s sVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            sVar.c(i6);
            int i7 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.ad) {
                int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
                sVar.d(1);
                if (iA == 0) {
                    sVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int iD = sVar.d();
                    i4 = iD & 15;
                    i5 = (iD & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4;
                }
                boolean z2 = sVar.d() == 1;
                int iD2 = sVar.d();
                byte[] bArr2 = new byte[16];
                sVar.a(bArr2, 0, 16);
                if (z2 && iD2 == 0) {
                    int iD3 = sVar.d();
                    bArr = new byte[iD3];
                    sVar.a(bArr, 0, iD3);
                }
                return new k(z2, str, iD2, bArr2, i5, i4, bArr);
            }
            i6 += i7;
        }
    }

    private static boolean a(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        return jArr[0] <= j3 && j3 < jArr[af.a(3, 0, length)] && jArr[af.a(jArr.length - 3, 0, length)] < j4 && j4 <= j2;
    }
}
