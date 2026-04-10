package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2208a = Integer.MAX_VALUE;

    public static void a(int i) {
        f2208a = i;
    }

    public static void a(bv bvVar, byte b) throws bc {
        a(bvVar, b, f2208a);
    }

    public static void a(bv bvVar, byte b, int i) throws bc {
        if (i <= 0) {
            throw new bc("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                bvVar.t();
                return;
            case 3:
                bvVar.u();
                return;
            case 4:
                bvVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                bvVar.v();
                return;
            case 8:
                bvVar.w();
                return;
            case 10:
                bvVar.x();
                return;
            case 11:
                bvVar.A();
                return;
            case 12:
                bvVar.j();
                while (true) {
                    bq bqVarL = bvVar.l();
                    if (bqVarL.b != 0) {
                        a(bvVar, bqVarL.b, i - 1);
                        bvVar.m();
                    } else {
                        bvVar.k();
                        return;
                    }
                }
                break;
            case 13:
                bs bsVarN = bvVar.n();
                while (i2 < bsVarN.c) {
                    int i3 = i - 1;
                    a(bvVar, bsVarN.f2204a, i3);
                    a(bvVar, bsVarN.b, i3);
                    i2++;
                }
                bvVar.o();
                return;
            case 14:
                bz bzVarR = bvVar.r();
                while (i2 < bzVarR.b) {
                    a(bvVar, bzVarR.f2209a, i - 1);
                    i2++;
                }
                bvVar.s();
                return;
            case 15:
                br brVarP = bvVar.p();
                while (i2 < brVarP.b) {
                    a(bvVar, brVarP.f2203a, i - 1);
                    i2++;
                }
                bvVar.q();
                return;
        }
    }

    public static bx a(byte[] bArr, bx bxVar) {
        if (bArr[0] > 16) {
            return new bp.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? bxVar : new bp.a();
    }
}
