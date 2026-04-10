package com.anythink.expressad.foundation.g.f.h;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.anythink.expressad.foundation.g.f.d.c;
import com.anythink.expressad.foundation.g.f.d.d;
import com.anythink.expressad.foundation.g.f.d.g;
import com.anythink.expressad.foundation.g.f.e;
import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.l;
import com.anythink.expressad.foundation.g.f.m;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.out.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final String b = "a";
    protected Context a;

    public a(Context context) {
        if (context == null) {
            this.a = com.anythink.expressad.foundation.b.a.b().d();
        } else {
            this.a = context.getApplicationContext();
        }
    }

    private void b(int i2, String str, b bVar, e eVar) {
        b(i2, str, bVar, new com.anythink.expressad.foundation.g.f.b(), eVar);
    }

    public void a(String str, b bVar) {
        if (bVar != null) {
            bVar.a(ConnType.PK_OPEN, com.anythink.expressad.foundation.g.a.cy);
            StringBuilder sb = new StringBuilder();
            com.anythink.expressad.foundation.g.f.a.a();
            sb.append(com.anythink.expressad.foundation.g.f.a.b());
            bVar.a("band_width", sb.toString());
            String str2 = bVar.b().get("unit_id");
            if (str2 != null) {
                String strA = k.a().a(str2, str);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                bVar.a("ch_info", strA);
            }
        }
    }

    private void b(int i2, String str, b bVar, l lVar, e eVar) {
        if (bVar == null) {
            try {
                bVar = new b();
            } catch (Exception e2) {
                o.a(b, e2.getMessage());
            }
        }
        a(str, bVar);
        i gVar = null;
        if (i2 == 0) {
            gVar = new g(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", "application/x-www-form-urlencoded");
        } else if (i2 == 1) {
            gVar = new d(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", "application/x-www-form-urlencoded");
        } else if (i2 == 2) {
            gVar = new c(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        if (gVar != null) {
            gVar.a(lVar);
            m.a(gVar);
        }
    }

    public final void a(String str, b bVar, e eVar) {
        com.anythink.expressad.foundation.g.f.b bVar2 = new com.anythink.expressad.foundation.g.f.b();
        if (bVar == null) {
            try {
                bVar = new b();
            } catch (Exception e2) {
                o.a(b, e2.getMessage());
            }
        }
        a(str, bVar);
        String str2 = bVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        bVar.a("ts", String.valueOf(jCurrentTimeMillis));
        bVar.a("st", p.a(str2 + jCurrentTimeMillis));
        g gVar = new g(0, str + "?" + bVar.toString(), null, eVar);
        gVar.a((l) bVar2);
        m.a(gVar);
    }

    private void a(int i2, String str, b bVar, l lVar, e eVar) {
        i gVar;
        if (bVar == null) {
            try {
                bVar = new b();
            } catch (Exception e2) {
                o.a(b, e2.getMessage());
            }
        }
        a(str, bVar);
        String str2 = bVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        bVar.a("ts", String.valueOf(jCurrentTimeMillis));
        bVar.a("st", p.a(str2 + jCurrentTimeMillis));
        String str3 = str + "?" + bVar.toString();
        if (i2 == 0) {
            gVar = new g(0, str3, null, eVar);
        } else if (i2 != 1) {
            gVar = i2 != 2 ? null : new c(0, str3, null, eVar);
        } else {
            gVar = new d(0, str3, null, eVar);
        }
        if (gVar != null) {
            gVar.a(lVar);
            m.a(gVar);
        }
    }

    public static void a(File file, String str, e eVar) {
        m.a().a(file, str, (e<Void>) eVar);
    }

    private void a(int i2, String str, b bVar, e eVar) {
        String str2 = bVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        bVar.a("ts", String.valueOf(jCurrentTimeMillis));
        bVar.a("st", p.a(str2 + jCurrentTimeMillis));
        b(i2, str, bVar, new com.anythink.expressad.foundation.g.f.b(), eVar);
    }
}
