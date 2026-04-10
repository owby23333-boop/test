package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class db {
    private static volatile db b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1842a;

    private db(Context context) {
        this.f1842a = context;
    }

    public static db a(Context context) {
        if (b == null) {
            synchronized (db.class) {
                if (b == null) {
                    b = new db(context);
                }
            }
        }
        return b;
    }

    public void a(final int i, final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                long j;
                int i3;
                try {
                    h hVarA = h.a(db.this.f1842a, "re_po_rt");
                    if (hVarA.b(df.P, 1) == 1) {
                        long jA = df.a(db.this.f1842a).a(df.bj);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(df.R, 1)) * bi.s;
                        long jB2 = ((long) hVarA.b(df.S, 5)) * 60000;
                        int iB = hVarA.b(df.T, 0);
                        if (jA > 0) {
                            j = jA;
                            if (jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * bi.s && WeaponHI.isList != null) {
                                if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                    return;
                                }
                            }
                        } else {
                            j = jA;
                        }
                        long j2 = jCurrentTimeMillis - j;
                        if (j2 >= jB || (((i3 = i) == 100 && iB == 1) || i3 == 106 || (i3 != 100 && i3 > 0 && j2 >= jB2))) {
                            cp.a(db.this.f1842a, new cl(db.this.f1842a, i, i2).a(ck.c), ck.c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
