package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class dd {
    private static volatile dd b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1846a;

    private dd(Context context) {
        this.f1846a = context;
    }

    public static dd a(Context context) {
        if (b == null) {
            synchronized (dd.class) {
                if (b == null) {
                    b = new dd(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(dd.this.f1846a, "re_po_rt");
                    if (hVarA.b(df.aC, 1) == 1) {
                        long jA = df.a(dd.this.f1846a).a();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(df.aE, 8)) * bi.s;
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * bi.s && WeaponHI.isList != null) {
                            if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || i == 106) {
                            cp.a(dd.this.f1846a, new cn(dd.this.f1846a, i).a(ck.b), ck.b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
