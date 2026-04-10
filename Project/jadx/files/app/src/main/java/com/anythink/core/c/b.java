package com.anythink.core.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.af;
import com.anythink.core.common.g.i;
import com.anythink.core.common.k.p;
import com.anythink.core.common.r;
import com.anythink.core.common.res.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final String a = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f6659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.anythink.core.c.a f6660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f6661e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f6663g = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6662f = false;
    List<a> b = Collections.synchronizedList(new ArrayList(3));

    public interface a {
        void a();

        void b();
    }

    private b(Context context) {
        this.f6661e = context;
    }

    private Context c() {
        return this.f6661e;
    }

    private void d() {
        synchronized (this.f6663g) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.b.clear();
        }
    }

    private static com.anythink.core.c.a e() {
        com.anythink.core.c.a aVar = new com.anythink.core.c.a();
        aVar.b = true;
        aVar.Q();
        aVar.b("0");
        aVar.a(0L);
        aVar.W();
        aVar.Z();
        aVar.ab();
        aVar.c("");
        aVar.ae();
        aVar.ag();
        aVar.d("");
        aVar.O();
        aVar.K();
        aVar.C();
        aVar.E();
        aVar.a("[\"com.anythink\"]");
        aVar.y();
        aVar.e();
        aVar.i();
        aVar.g();
        aVar.k();
        return aVar;
    }

    private boolean f() {
        return this.f6662f;
    }

    private static void g() {
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.f6662f = false;
        return false;
    }

    static /* synthetic */ void c(b bVar) {
        synchronized (bVar.f6663g) {
            Iterator<a> it = bVar.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            bVar.b.clear();
        }
    }

    public static b a(Context context) {
        if (f6659c == null) {
            synchronized (b.class) {
                if (f6659c == null) {
                    f6659c = new b(context);
                }
            }
        }
        return f6659c;
    }

    private void b(Context context) {
        this.f6661e = context;
    }

    private void b(a aVar) {
        synchronized (this.f6663g) {
            if (aVar != null) {
                this.b.remove(aVar);
            }
        }
    }

    public final synchronized com.anythink.core.c.a b(String str) {
        af afVar;
        if (f6660d == null) {
            try {
                if (this.f6661e == null) {
                    this.f6661e = n.a().g();
                }
                List<af> listA = com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(this.f6661e)).a(str, g.o.a);
                com.anythink.core.c.a aVarF = null;
                if (listA != null && listA.size() > 0 && (afVar = listA.get(0)) != null && (aVarF = com.anythink.core.c.a.f(afVar.d())) != null) {
                    aVarF.a(Long.parseLong(afVar.a()));
                }
                f6660d = aVarF;
                if (aVarF == null) {
                    com.anythink.core.c.a aVar = new com.anythink.core.c.a();
                    aVar.b = true;
                    aVar.Q();
                    aVar.b("0");
                    aVar.a(0L);
                    aVar.W();
                    aVar.Z();
                    aVar.ab();
                    aVar.c("");
                    aVar.ae();
                    aVar.ag();
                    aVar.d("");
                    aVar.O();
                    aVar.K();
                    aVar.C();
                    aVar.E();
                    aVar.a("[\"com.anythink\"]");
                    aVar.y();
                    aVar.e();
                    aVar.i();
                    aVar.g();
                    aVar.k();
                    f6660d = aVar;
                }
            } catch (Exception unused) {
            }
        }
        return f6660d;
    }

    private void a(a aVar) {
        synchronized (this.f6663g) {
            if (this.f6663g != null) {
                this.b.add(aVar);
            }
        }
    }

    public final boolean a(String str) {
        boolean z2;
        com.anythink.core.c.a aVarB = b(str);
        if (aVarB != null) {
            c cVarA = aVarB.a();
            long jP = aVarB.P();
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = aVarB.L() + jP <= jCurrentTimeMillis;
            boolean z4 = cVarA != null && aVarB.L() + cVarA.a() <= jCurrentTimeMillis;
            Map<String, Object> map = aVarB.f6611c;
            Map<String, Object> mapM = n.a().m();
            if (map != null) {
                z2 = !map.equals(mapM);
            } else {
                z2 = mapM != null;
            }
            if (!z3 && !z4 && !z2) {
                return false;
            }
        }
        return true;
    }

    public static long a() {
        com.anythink.core.c.a aVar = f6660d;
        if (aVar == null || aVar.J() == 0) {
            return 51200L;
        }
        return f6660d.J();
    }

    private static com.anythink.core.c.a a(Context context, String str) {
        af afVar;
        List<af> listA = com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(context)).a(str, g.o.a);
        com.anythink.core.c.a aVarF = null;
        if (listA != null && listA.size() > 0 && (afVar = listA.get(0)) != null && (aVarF = com.anythink.core.c.a.f(afVar.d())) != null) {
            aVarF.a(Long.parseLong(afVar.a()));
        }
        return aVarF;
    }

    public static com.anythink.core.c.a a(Context context, String str, String str2) {
        com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(context)).a(str, str2, g.o.a);
        com.anythink.core.c.a aVarF = com.anythink.core.c.a.f(str2);
        aVarF.a(System.currentTimeMillis());
        p.a(context, g.f6799o, g.o.f6918j, aVarF.U());
        return aVarF;
    }

    public final synchronized void a(final String str, String str2) {
        if (this.f6662f) {
            return;
        }
        this.f6662f = true;
        new com.anythink.core.common.g.d(this.f6661e, str, str2).a(0, new i() { // from class: com.anythink.core.c.b.1
            @Override // com.anythink.core.common.g.i
            public final void onLoadCanceled(int i2) {
                b.a(b.this);
                b.c(b.this);
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadError(int i2, String str3, AdError adError) {
                b.a(b.this);
                b.c(b.this);
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadFinish(int i2, Object obj) {
                b.a(b.this);
                if (obj != null) {
                    com.anythink.core.c.a unused = b.f6660d = b.a(b.this.f6661e, str, obj.toString());
                    if (b.f6660d != null) {
                        String strS = b.f6660d.s();
                        if (!TextUtils.isEmpty(strS) && TextUtils.isEmpty(n.a().y())) {
                            n.a().i(strS);
                        }
                        r.a(b.this.f6661e).a(b.f6660d);
                        Context unused2 = b.this.f6661e;
                        com.anythink.core.c.a unused3 = b.f6660d;
                        b.a(b.this.f6661e, b.f6660d);
                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.c.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.anythink.core.common.n.a().a(b.f6660d.c());
                            }
                        });
                        com.anythink.core.common.c.a().a(b.f6660d.b());
                    }
                    b.c(b.this);
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadStart(int i2) {
            }
        });
    }

    static /* synthetic */ void a(Context context, com.anythink.core.c.a aVar) {
        if (aVar != null) {
            String strN = aVar.n();
            if (TextUtils.isEmpty(strN)) {
                return;
            }
            com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, strN), (b.a) null);
        }
    }

    private static void b(Context context, com.anythink.core.c.a aVar) {
        if (aVar == null) {
            return;
        }
        String strN = aVar.n();
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, strN), (b.a) null);
    }
}
