package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8149a = Integer.MAX_VALUE;

    public static void a(jx jxVar, byte b2) {
        a(jxVar, b2, f8149a);
    }

    public static void a(jx jxVar, byte b2, int i) throws jr {
        if (i <= 0) {
            throw new jr("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b2) {
            case 2:
                jxVar.mo688a();
                return;
            case 3:
                jxVar.a();
                return;
            case 4:
                jxVar.mo675a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jxVar.mo685a();
                return;
            case 8:
                jxVar.mo676a();
                return;
            case 10:
                jxVar.mo677a();
                return;
            case 11:
                jxVar.mo684a();
                return;
            case 12:
                jxVar.mo682a();
                while (true) {
                    byte b3 = jxVar.mo678a().f8143a;
                    if (b3 == 0) {
                        jxVar.f();
                        return;
                    } else {
                        a(jxVar, b3, i - 1);
                        jxVar.g();
                    }
                }
                break;
            case 13:
                jw jwVarMo680a = jxVar.mo680a();
                while (i2 < jwVarMo680a.f871a) {
                    int i3 = i - 1;
                    a(jxVar, jwVarMo680a.f8145a, i3);
                    a(jxVar, jwVarMo680a.f8146b, i3);
                    i2++;
                }
                jxVar.h();
                return;
            case 14:
                kb kbVarMo681a = jxVar.mo681a();
                while (i2 < kbVarMo681a.f872a) {
                    a(jxVar, kbVarMo681a.f8150a, i - 1);
                    i2++;
                }
                jxVar.j();
                return;
            case 15:
                jv jvVarMo679a = jxVar.mo679a();
                while (i2 < jvVarMo679a.f870a) {
                    a(jxVar, jvVarMo679a.f8144a, i - 1);
                    i2++;
                }
                jxVar.i();
                return;
        }
    }
}
