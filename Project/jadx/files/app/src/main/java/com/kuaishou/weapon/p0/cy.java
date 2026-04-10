package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class cy {
    private static volatile cy b;
    private Context a;

    private cy(Context context) {
        this.a = context;
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

    public void a() {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(cy.this.a, "re_po_rt");
                    if (hVarA.b(de.E, 1) == 1) {
                        long jA = de.a(cy.this.a).a(de.be);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(de.G, 12)) * 3600000;
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(jCurrentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB) {
                            co.a(cy.this.a, new ci(cy.this.a).a(cj.f16632g), cj.f16632g, true, true);
                            de.a(cy.this.a).a(de.be, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
