package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class cy {
    private static volatile cy b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1833a;

    private cy(Context context) {
        this.f1833a = context;
    }

    public static cy a(Context context) {
        if (b == null) {
            synchronized (cy.class) {
                if (b == null) {
                    b = new cy(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        try {
            h hVarA = h.a(this.f1833a, "re_po_rt");
            final boolean zE = hVarA.e("a1_p_s_p_s");
            final boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if ((zE || zE2) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        try {
                            h hVarA2 = h.a(cy.this.f1833a, "re_po_rt");
                            if (hVarA2.b(df.o, 0) == 1) {
                                if (zE || zE2) {
                                    long jA = df.a(cy.this.f1833a).a(df.bi);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    long jB = ((long) hVarA2.b(df.p, 8)) * bi.s;
                                    int iB = hVarA2.b(df.q, 0);
                                    if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * bi.s && WeaponHI.isList != null) {
                                        if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                            return;
                                        }
                                    }
                                    if (jCurrentTimeMillis - jA >= jB || (((i2 = i) == 100 && iB == 1) || i2 == 106)) {
                                        cp.a(cy.this.f1833a, new ci(cy.this.f1833a, i).a(ck.d), ck.d, true, true);
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
