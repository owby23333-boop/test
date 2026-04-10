package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class de {
    private static volatile de b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1848a;

    private de(Context context) {
        this.f1848a = context;
    }

    public static de a(Context context) {
        if (b == null) {
            synchronized (de.class) {
                if (b == null) {
                    b = new de(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(de.this.f1848a, "re_po_rt");
                    if (hVarA.b(df.B, 0) == 1) {
                        long jA = df.a(de.this.f1848a).a(df.bn);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - jA >= ((long) hVarA.b(df.E, 2)) * bi.s || i == 106) {
                            try {
                                String strA = new co(de.this.f1848a).a(ck.h);
                                int iIntValue = Integer.valueOf(ck.h).intValue();
                                if (strA != null && strA.length() > 10) {
                                    new bc(de.this.f1848a, strA, iIntValue).a("1000");
                                }
                            } catch (Throwable unused) {
                            }
                            df.a(de.this.f1848a).a(df.bn, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
