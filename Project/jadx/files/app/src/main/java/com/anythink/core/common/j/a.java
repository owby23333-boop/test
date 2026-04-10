package com.anythink.core.common.j;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ah;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.f;
import com.anythink.core.common.e.m;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.g.i;
import com.anythink.core.common.k.g;
import com.anythink.core.common.o;
import com.anythink.core.common.q;
import com.anythink.core.common.r;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class a extends o<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile a f7589f;

    private a(Context context) {
        super(context);
    }

    private void b(int i2, ah ahVar, ai aiVar) {
        if (i2 == 4) {
            m mVarN = aiVar != null ? aiVar.N() : null;
            if (mVarN != null) {
                mVarN.a(true, mVarN.getSortPrice(), true);
            }
            if (ahVar instanceof e) {
                a((e) ahVar, aiVar);
            }
        }
    }

    private static boolean c(int i2, ah ahVar) {
        Map<String, String> mapA;
        if (!(ahVar instanceof e)) {
            return false;
        }
        e eVar = (e) ahVar;
        if (eVar.H() == 67) {
            return true;
        }
        if (eVar.H() != 0 && !TextUtils.isEmpty(ahVar.Y()) && (mapA = com.anythink.core.c.b.a(n.a().g()).b(n.a().p()).a(i2)) != null) {
            if (mapA.containsKey("0")) {
                String str = mapA.get("0");
                return !TextUtils.isEmpty(str) && str.contains(ahVar.Y());
            }
            if (mapA.containsKey(String.valueOf(eVar.H()))) {
                String str2 = mapA.get(String.valueOf(eVar.H()));
                if (!TextUtils.isEmpty(str2) && str2.contains(ahVar.Y())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void d(int i2, ah ahVar) {
        if (4 == i2 && (ahVar instanceof e)) {
            q.a();
            q.a((e) ahVar);
        }
    }

    private static void e(int i2, ah ahVar) {
        if (ahVar instanceof e) {
            if (i2 == 4) {
                ((e) ahVar).c();
            } else if (i2 == 6) {
                ((e) ahVar).d();
            } else {
                if (i2 != 21) {
                    return;
                }
                n.a().M();
            }
        }
    }

    public static a a(Context context) {
        if (f7589f == null) {
            synchronized (a.class) {
                if (f7589f == null) {
                    f7589f = new a(context);
                }
            }
        }
        return f7589f;
    }

    private f b(int i2, ah ahVar, ai aiVar, long j2) {
        if (i2 == 13) {
            m mVarN = aiVar != null ? aiVar.N() : null;
            if (mVarN != null) {
                mVarN.a(aiVar);
            }
        }
        if (i2 == 4) {
            m mVarN2 = aiVar != null ? aiVar.N() : null;
            if (mVarN2 != null) {
                mVarN2.a(true, mVarN2.getSortPrice(), true);
            }
            if (ahVar instanceof e) {
                a((e) ahVar, aiVar);
            }
        }
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        f fVar = new f();
        fVar.a = i2;
        fVar.b = ahVar;
        if (j2 <= 0) {
            j2 = System.currentTimeMillis();
        }
        fVar.f7253c = j2;
        r.a(n.a().g()).a(i2, fVar, aVarB);
        if (a(i2, ahVar, aVarB)) {
            return null;
        }
        if (4 == i2 && (ahVar instanceof e)) {
            q.a();
            q.a((e) ahVar);
        }
        return fVar;
    }

    public final synchronized void a(int i2, ah ahVar) {
        a(i2, ahVar, null, -1L);
    }

    public final synchronized void a(int i2, ah ahVar, ai aiVar) {
        a(i2, ahVar, aiVar, -1L);
    }

    private static void a(int i2, ai aiVar) {
        if (i2 == 13) {
            m mVarN = aiVar != null ? aiVar.N() : null;
            if (mVarN != null) {
                mVarN.a(aiVar);
            }
        }
    }

    private static boolean a(int i2, ah ahVar, com.anythink.core.c.a aVar) {
        String strAk = aVar.ak();
        if (!TextUtils.isEmpty(strAk) && (ahVar instanceof e)) {
            try {
                JSONArray jSONArray = new JSONArray(strAk);
                int length = jSONArray.length();
                String strValueOf = String.valueOf(((e) ahVar).H());
                for (int i3 = 0; i3 < length; i3++) {
                    if (TextUtils.equals(strValueOf, jSONArray.optString(i3))) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Map<String, String> mapAi = aVar.ai();
        if (mapAi != null && mapAi.containsKey(String.valueOf(i2))) {
            String str = mapAi.get(String.valueOf(i2));
            if (!TextUtils.isEmpty(str) && str.contains(ahVar.Y())) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean b(int i2, ah ahVar) {
        Map<String, String> mapA;
        if (ahVar instanceof e) {
            e eVar = (e) ahVar;
            if (eVar.H() == 67) {
                return true;
            }
            if (eVar.H() != 0 && !TextUtils.isEmpty(ahVar.Y()) && (mapA = com.anythink.core.c.b.a(n.a().g()).b(n.a().p()).a(i2)) != null) {
                if (mapA.containsKey("0")) {
                    String str = mapA.get("0");
                    return !TextUtils.isEmpty(str) && str.contains(ahVar.Y());
                }
                if (mapA.containsKey(String.valueOf(eVar.H()))) {
                    String str2 = mapA.get(String.valueOf(eVar.H()));
                    if (!TextUtils.isEmpty(str2) && str2.contains(ahVar.Y())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.anythink.core.common.o
    protected final void a(List<f> list) {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        if (aVarB != null) {
            int iU = aVarB.u();
            if (iU == 1) {
                com.anythink.core.common.g.a.e eVar = new com.anythink.core.common.g.a.e(list);
                eVar.a(1, aVarB.t());
                eVar.a((c.a) null);
                return;
            } else {
                if (iU != 2) {
                    new com.anythink.core.common.g.m(this.f7838e, aVarB.u(), list).a(0, (i) null);
                    return;
                }
                new com.anythink.core.common.g.m(this.f7838e, aVarB.u(), list).a(0, (i) null);
                com.anythink.core.common.g.a.e eVar2 = new com.anythink.core.common.g.a.e(list);
                eVar2.a(2, aVarB.t());
                eVar2.a((c.a) null);
                return;
            }
        }
        new com.anythink.core.common.g.m(this.f7838e, 0, list).a(0, (i) null);
    }

    private void a(e eVar, ai aiVar) {
        List<String> listW;
        List<ai> listG;
        com.anythink.core.common.e.b bVarA;
        m mVarN;
        String strW = eVar.W();
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(this.f7838e).a(strW);
        if (dVarA == null || (listW = dVarA.w()) == null || listW.size() == 0 || (listG = dVarA.G()) == null || listG.size() == 0) {
            return;
        }
        for (ai aiVar2 : listG) {
            try {
                if (listW.contains(String.valueOf(aiVar2.c())) && (bVarA = com.anythink.core.common.a.a().a(strW, aiVar2)) != null && (mVarN = bVarA.e().getUnitGroupInfo().N()) != null) {
                    mVarN.a(false, g.a(aiVar), aiVar.j());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final synchronized void a(final int i2, final ah ahVar, final ai aiVar, final long j2) {
        if (ahVar instanceof e) {
            if (i2 == 4) {
                ((e) ahVar).c();
            } else if (i2 == 6) {
                ((e) ahVar).d();
            } else if (i2 == 21) {
                n.a().M();
            }
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if ((ahVar instanceof e) && n.a().H()) {
                    com.anythink.core.common.b.i.a().a(i2, (e) ahVar);
                }
                f fVarA = a.a(a.this, i2, ahVar, aiVar, j2);
                if (fVarA == null) {
                    return;
                }
                a.super.a(fVarA, a.b(i2, ahVar));
            }
        });
    }

    static /* synthetic */ f a(a aVar, int i2, ah ahVar, ai aiVar, long j2) {
        if (i2 == 13) {
            m mVarN = aiVar != null ? aiVar.N() : null;
            if (mVarN != null) {
                mVarN.a(aiVar);
            }
        }
        if (i2 == 4) {
            m mVarN2 = aiVar != null ? aiVar.N() : null;
            if (mVarN2 != null) {
                mVarN2.a(true, mVarN2.getSortPrice(), true);
            }
            if (ahVar instanceof e) {
                aVar.a((e) ahVar, aiVar);
            }
        }
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        f fVar = new f();
        fVar.a = i2;
        fVar.b = ahVar;
        if (j2 <= 0) {
            j2 = System.currentTimeMillis();
        }
        fVar.f7253c = j2;
        r.a(n.a().g()).a(i2, fVar, aVarB);
        if (a(i2, ahVar, aVarB)) {
            return null;
        }
        if (4 == i2 && (ahVar instanceof e)) {
            q.a();
            q.a((e) ahVar);
        }
        return fVar;
    }
}
