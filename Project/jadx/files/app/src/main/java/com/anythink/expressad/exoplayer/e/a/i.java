package com.anythink.expressad.exoplayer.e.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;

/* JADX INFO: loaded from: classes2.dex */
final class i {
    private static final int a = 4096;
    private static final int[] b = {af.f("isom"), af.f("iso2"), af.f("iso3"), af.f("iso4"), af.f("iso5"), af.f("iso6"), af.f("avc1"), af.f("hvc1"), af.f("hev1"), af.f("mp41"), af.f("mp42"), af.f("3g2a"), af.f("3g2b"), af.f("3gr6"), af.f("3gs6"), af.f("3ge6"), af.f("3gg6"), af.f("M4V "), af.f("M4A "), af.f("f4v "), af.f("kddi"), af.f("M4VP"), af.f("qt  "), af.f("MSNV")};

    private i() {
    }

    public static boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return a(fVar, true);
    }

    public static boolean b(com.anythink.expressad.exoplayer.e.f fVar) {
        return a(fVar, false);
    }

    private static boolean a(com.anythink.expressad.exoplayer.e.f fVar, boolean z2) {
        boolean z3;
        long jD = fVar.d();
        long j2 = -1;
        if (jD == -1 || jD > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            jD = 4096;
        }
        int i2 = (int) jD;
        s sVar = new s(64);
        int i3 = 0;
        boolean z4 = false;
        while (i3 < i2) {
            sVar.a(8);
            fVar.d(sVar.a, 0, 8);
            long jH = sVar.h();
            int i4 = sVar.i();
            int i5 = 16;
            if (jH == 1) {
                fVar.d(sVar.a, 8, 8);
                sVar.b(16);
                jH = sVar.n();
            } else {
                if (jH == 0) {
                    long jD2 = fVar.d();
                    if (jD2 != j2) {
                        jH = 8 + (jD2 - fVar.c());
                    }
                }
                i5 = 8;
            }
            long j3 = i5;
            if (jH >= j3) {
                i3 += i5;
                if (i4 != a.G) {
                    if (i4 != a.P && i4 != a.R) {
                        if ((((long) i3) + jH) - j3 >= i2) {
                            break;
                        }
                        int i6 = (int) (jH - j3);
                        i3 += i6;
                        if (i4 == a.f8839f) {
                            if (i6 < 8) {
                                return false;
                            }
                            sVar.a(i6);
                            fVar.d(sVar.a, 0, i6);
                            int i7 = i6 / 4;
                            int i8 = 0;
                            while (true) {
                                if (i8 >= i7) {
                                    break;
                                }
                                if (i8 == 1) {
                                    sVar.d(4);
                                } else if (a(sVar.i())) {
                                    z4 = true;
                                    break;
                                }
                                i8++;
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i6 != 0) {
                            fVar.e(i6);
                        }
                        j2 = -1;
                    } else {
                        z3 = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        z3 = false;
        return z4 && z2 == z3;
    }

    private static boolean a(int i2) {
        if ((i2 >>> 8) == af.f("3gp")) {
            return true;
        }
        for (int i3 : b) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }
}
