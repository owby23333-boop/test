package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class cx {
    private static volatile cx b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1831a;

    private cx(Context context) {
        this.f1831a = context;
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

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                try {
                    h hVarA = h.a(cx.this.f1831a, "re_po_rt");
                    if (hVarA.b(df.y, 0) == 1) {
                        long jA = df.a(cx.this.f1831a).a(df.bh);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(df.z, 8)) * bi.s;
                        int iB = hVarA.b(df.q, 0);
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * bi.s && WeaponHI.isList != null) {
                            if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || (i2 = i) == 106 || (i2 == 100 && iB == 1)) {
                            cp.a(cx.this.f1831a, new ch(cx.this.f1831a, i).a(ck.i), ck.i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
