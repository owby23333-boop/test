package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class da {
    private static volatile da b;
    private Context a;

    private da(Context context) {
        this.a = context;
    }

    public static da a(Context context) {
        if (b == null) {
            synchronized (da.class) {
                if (b == null) {
                    b = new da(context);
                }
            }
        }
        return b;
    }

    public void a(final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(da.this.a, "re_po_rt");
                    if (hVarA.b(de.ah, 1) == 1) {
                        long jA = de.a(da.this.a).a(de.bd);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int iB = hVarA.b(de.ak, 0);
                        long j2 = jCurrentTimeMillis - jA;
                        if (j2 >= ((long) hVarA.b(de.aj, 6)) * 3600000 || (i2 == 100 && iB == 1 && j2 >= 14400000)) {
                            cf.a(da.this.a, new bv(da.this.a, i2, false).a(cj.f16630e), cj.f16630e, true);
                            de.a(da.this.a).a(de.bd, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
