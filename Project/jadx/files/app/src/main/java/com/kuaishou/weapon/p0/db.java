package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class db {
    private static volatile db b;
    private Context a;

    private db(Context context) {
        this.a = context;
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

    public void a(final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(db.this.a, "re_po_rt");
                    if (hVarA.b(de.au, 1) == 1) {
                        long jA = de.a(db.this.a).a();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(de.aw, 8)) * 3600000;
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
                            co.a(db.this.a, new cm(db.this.a, i2).a(cj.b), cj.b, true, true);
                            de.a(db.this.a).a(jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
