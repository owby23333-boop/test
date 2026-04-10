package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class cx {
    private static volatile cx b;
    private Context a;

    private cx(Context context) {
        this.a = context;
    }

    public static cx a(Context context) {
        if (b == null) {
            synchronized (cx.class) {
                if (b == null) {
                    b = new cx(context);
                }
            }
        }
        return b;
    }

    public void a(final int i2) {
        try {
            h hVarA = h.a(this.a, "re_po_rt");
            final boolean zE = hVarA.e("a1_p_s_p_s");
            final boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if ((zE || zE2) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long j2;
                        try {
                            h hVarA2 = h.a(cx.this.a, "re_po_rt");
                            if (hVarA2.b(de.f16692m, 1) == 1) {
                                if (zE || zE2) {
                                    long jA = de.a(cx.this.a).a(de.ba);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    long jB = ((long) hVarA2.b(de.f16693n, 8)) * 3600000;
                                    int iB = hVarA2.b(de.f16694o, 0);
                                    long jB2 = ((long) hVarA2.b(de.f16696q, 20)) * 60000;
                                    if (jA > 0) {
                                        j2 = jA;
                                        if (jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                                            int hours = new Date(jCurrentTimeMillis).getHours();
                                            List<Integer> list = WeaponHI.isList;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(hours);
                                            if (list.contains(sb.toString())) {
                                                return;
                                            }
                                        }
                                    } else {
                                        j2 = jA;
                                    }
                                    long j3 = jCurrentTimeMillis - j2;
                                    if (j3 >= jB || ((i2 == 100 && iB == 1) || ((i2 == 101 || i2 == 102) && j3 >= jB2))) {
                                        co.a(cx.this.a, new ch(cx.this.a, i2).a(cj.f16629d), cj.f16629d, true, true);
                                        de.a(cx.this.a).a(de.ba, jCurrentTimeMillis);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
