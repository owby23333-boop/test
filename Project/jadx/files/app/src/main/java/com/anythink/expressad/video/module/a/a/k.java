package com.anythink.expressad.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.w;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k extends f {
    public static final int V = 2;
    public static final int a = 1;
    private static final String ag = "camp_position";
    protected boolean W;
    protected com.anythink.expressad.foundation.d.c X;
    protected List<com.anythink.expressad.foundation.d.c> Y;
    protected boolean Z;
    protected com.anythink.expressad.videocommon.b.c aa;
    protected com.anythink.expressad.videocommon.c.c ab;
    protected String ac;
    protected String ad;
    protected com.anythink.expressad.video.module.a.a ae;
    protected int af;
    private boolean ah = false;
    private boolean ai = false;
    private boolean aj = false;

    public k(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i2, boolean z2) {
        this.Z = false;
        this.ae = new f();
        this.af = 1;
        if (!z2 && cVar != null && w.b(str2) && cVar2 != null && aVar != null) {
            this.X = cVar;
            this.ad = str;
            this.ac = str2;
            this.aa = cVar2;
            this.ab = cVar3;
            this.ae = aVar;
            this.W = true;
            this.af = i2;
            this.Z = false;
            return;
        }
        if (!z2 || cVar == null || !w.b(str2) || aVar == null) {
            return;
        }
        this.X = cVar;
        this.ad = str;
        this.ac = str2;
        this.aa = cVar2;
        this.ab = cVar3;
        this.ae = aVar;
        this.W = true;
        this.af = i2;
        this.Z = true;
    }

    private static void g() {
    }

    private static void h() {
    }

    private static void i() {
        com.anythink.expressad.videocommon.b.e.a().a(false);
    }

    private static void j() {
    }

    private void k() {
        if (!this.W || com.anythink.expressad.foundation.g.a.f.f10445k == null || TextUtils.isEmpty(this.X.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(this.ac, this.X, "reward");
    }

    private static void l() {
    }

    private static void m() {
    }

    private static void n() {
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.X = cVar;
    }

    public final void b(int i2) {
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar != null) {
            String strAh = cVar.ah();
            if (TextUtils.isEmpty(strAh)) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                if (!strAh.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(strAh);
                    if (strAh.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i2);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i2);
                    }
                    strAh = sb.toString();
                } else if (i2 == 2) {
                    if (strAh.contains("endscreen_type=1")) {
                        strAh = strAh.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (strAh.contains("endscreen_type=2")) {
                    strAh = strAh.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.X.q(strAh);
            }
        }
    }

    protected final void c() {
        String str;
        try {
            if (this.X != null && this.X.j() && this.Z && !this.X.l()) {
                this.ai = true;
                return;
            }
            if (!this.W || TextUtils.isEmpty(this.X.ai()) || com.anythink.expressad.foundation.g.a.f.f10442h == null || com.anythink.expressad.foundation.g.a.f.f10442h.containsKey(this.X.ai()) || this.ai) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.f10442h.put(this.X.ai(), Long.valueOf(System.currentTimeMillis()));
            String strAi = this.X.ai();
            if (this.X.n() == 1) {
                str = strAi + "&to=1&cbt=" + this.X.az() + "&tmorl=" + this.af;
            } else {
                str = strAi + "&to=0&cbt=" + this.X.az() + "&tmorl=" + this.af;
            }
            String str2 = str;
            if (!this.Z) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str2, true);
            } else if (this.X.l()) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str2, false, true, com.anythink.expressad.a.a.a.f8007j);
            }
            this.ai = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected final void d() {
        String str;
        try {
            if (!this.W || this.ah || TextUtils.isEmpty(this.X.ag())) {
                return;
            }
            this.ah = true;
            this.X.A();
            String strAg = this.X.ag();
            if (this.X.n() == 1) {
                str = strAg + "&to=1&cbt=" + this.X.az() + "&tmorl=" + this.af;
            } else {
                str = strAg + "&to=0&cbt=" + this.X.az() + "&tmorl=" + this.af;
            }
            com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str, false, true, com.anythink.expressad.a.a.a.f8006i);
            com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.n.a().g(), this.X);
            if (!this.W || com.anythink.expressad.foundation.g.a.f.f10445k == null || TextUtils.isEmpty(this.X.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.a(this.ac, this.X, "reward");
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b("NotifyListener", th.getMessage(), th);
        }
    }

    protected final void e() {
        List<String> listE;
        try {
            if (!this.W || this.aj || this.X == null) {
                return;
            }
            this.aj = true;
            if ((this.X.j() && this.Z && !this.X.l()) || this.Z || (listE = this.X.e()) == null || listE.size() <= 0) {
                return;
            }
            Iterator<String> it = listE.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, it.next(), true);
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d("NotifyListener", th.getMessage());
        }
    }

    protected final void f() {
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar == null || TextUtils.isEmpty(cVar.K()) || this.X.L() == null || this.X.L().n() == null) {
            return;
        }
        Context contextG = com.anythink.core.common.b.n.a().g();
        com.anythink.expressad.foundation.d.c cVar2 = this.X;
        com.anythink.expressad.a.a.a(contextG, cVar2, cVar2.K(), this.X.L().n(), false);
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.Y = list;
    }

    @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public void a(int i2, Object obj) {
        super.a(i2, obj);
        this.ae.a(i2, obj);
    }

    public final void a(int i2) {
        if (this.X != null) {
            if (i2 == 1 || i2 == 2) {
                com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.n.a().g(), this.X, i2, this.af);
            }
        }
    }

    public final void a() {
        if (!this.W || this.X == null) {
            return;
        }
        com.anythink.core.common.b.n.a().g();
        new r(r.f10370q, this.X.aZ(), this.X.Z(), this.X.aa(), this.ac, com.anythink.expressad.foundation.h.k.a()).a(this.X.H() ? r.aQ : r.aR);
    }

    public final void a(int i2, String str) {
        if (this.X != null) {
            com.anythink.core.common.b.n.a().g();
            new r(r.f10371r, this.X.aZ(), this.X.Z(), this.X.aa(), this.ac, com.anythink.expressad.foundation.h.k.a(), i2, str);
        }
    }

    protected final void b() {
        com.anythink.expressad.videocommon.b.c cVar = this.aa;
        if (cVar != null) {
            cVar.b(true);
        }
    }

    protected final void a(String str) {
        List<com.anythink.expressad.foundation.d.c> list;
        if (this.X == null || (list = this.Y) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(ag)) {
                this.X = this.Y.get(jSONObject.getInt(ag));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
