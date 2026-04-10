package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class cw {
    private static volatile cw b;
    private Context a;

    private cw(Context context) {
        this.a = context;
    }

    public static cw a(Context context) {
        if (b == null) {
            synchronized (cw.class) {
                if (b == null) {
                    b = new cw(context);
                }
            }
        }
        return b;
    }

    public void a(final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(cw.this.a, "re_po_rt");
                    if (hVarA.b(de.f16702w, 0) == 1) {
                        long jA = de.a(cw.this.a).a(de.aZ);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(de.f16703x, 8)) * 3600000;
                        int iB = hVarA.b(de.f16694o, 0);
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(jCurrentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || i2 == 106 || (i2 == 100 && iB == 1)) {
                            co.a(cw.this.a, new cg(cw.this.a, i2).a(cj.f16634i), cj.f16634i, false, true);
                            de.a(cw.this.a).a(de.aZ, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
