package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dc {
    private static volatile dc b;
    private Context a;

    private dc(Context context) {
        this.a = context;
    }

    public static dc a(Context context) {
        if (b == null) {
            synchronized (dc.class) {
                if (b == null) {
                    b = new dc(context);
                }
            }
        }
        return b;
    }

    public void a() {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(dc.this.a, "re_po_rt");
                    if (hVarA.b(de.f16705z, 0) == 1) {
                        long jA = de.a(dc.this.a).a(de.bf);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - jA >= ((long) hVarA.b(de.C, 2)) * 3600000) {
                            try {
                                String strA = new cn(dc.this.a).a(cj.f16633h);
                                int iIntValue = Integer.valueOf(cj.f16633h).intValue();
                                if (strA != null && strA.length() > 10) {
                                    new bb(dc.this.a, strA, iIntValue).a("1000");
                                }
                            } catch (Throwable unused) {
                            }
                            de.a(dc.this.a).a(de.bf, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
