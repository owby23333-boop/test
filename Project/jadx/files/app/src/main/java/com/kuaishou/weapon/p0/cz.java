package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class cz {
    private static volatile cz b;
    private Context a;

    private cz(Context context) {
        this.a = context;
    }

    public static cz a(Context context) {
        if (b == null) {
            synchronized (cz.class) {
                if (b == null) {
                    b = new cz(context);
                }
            }
        }
        return b;
    }

    public void a(final int i2, final int i3) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(cz.this.a, "re_po_rt");
                    if (hVarA.b(de.N, 1) == 1) {
                        long jA = de.a(cz.this.a).a(de.bb);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(de.P, 1)) * 3600000;
                        long jB2 = ((long) hVarA.b(de.Q, 5)) * 60000;
                        int iB = hVarA.b(de.R, 0);
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(jCurrentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                dd.a(cz.this.a, bp.f16592f, Integer.valueOf(cj.f16628c).intValue(), (((long) (new Random().nextInt(60) + 1)) * 60000) + 3600000, "env://");
                                return;
                            }
                        }
                        long j2 = jCurrentTimeMillis - jA;
                        if (j2 < jB && ((i2 != 100 || iB != 1) && i2 != 106 && (i2 == 100 || i2 <= 0 || j2 < jB2))) {
                            dd.a(cz.this.a, bp.f16592f, Integer.valueOf(cj.f16628c).intValue(), jB - j2, "env://");
                            return;
                        }
                        co.a(cz.this.a, new ck(cz.this.a, i2, i3).a(cj.f16628c), cj.f16628c, true, true);
                        de.a(cz.this.a).a(de.bb, jCurrentTimeMillis);
                        dd.a(cz.this.a, bp.f16592f, Integer.valueOf(cj.f16628c).intValue(), jB, "env://");
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
