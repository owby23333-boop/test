package com.anythink.expressad.video.dynview.j;

import android.content.Context;
import android.view.View;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.dynview.c;
import com.anythink.expressad.videocommon.e.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String a = "ViewOptionWrapper";
    private static final String b = "\\.xml";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11688c = "\\/xml";

    public static com.anythink.expressad.video.dynview.c a(Context context, List<com.anythink.expressad.foundation.d.c> list) {
        int iC;
        if (list == null) {
            return null;
        }
        try {
            float f2 = t.f(n.a().g());
            float fE = t.e(n.a().g());
            if (list.size() <= 0 || list.get(0) == null) {
                iC = 1;
            } else {
                com.anythink.expressad.foundation.d.c cVar = list.get(0);
                iC = (cVar == null || cVar.M() == null) ? 1 : cVar.M().c();
                list.get(0).as();
                list.get(0).aq();
            }
            String str = com.anythink.expressad.video.dynview.a.a.f11576i;
            if (iC == 1) {
                str = com.anythink.expressad.video.dynview.a.a.f11577j;
            } else if (iC != 2) {
                if (com.anythink.expressad.video.dynview.i.c.a(context)) {
                    iC = 2;
                } else {
                    str = com.anythink.expressad.video.dynview.a.a.f11577j;
                    iC = 1;
                }
            }
            return new c.a().a(context).a(str).a(1).a(fE).b(f2).a(list).b(iC).b("").a();
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            return null;
        }
    }

    private static String a(int i2) {
        return i2 != 3 ? i2 != 302 ? i2 != 802 ? i2 != 904 ? "anythink_reward_layer_floor" : com.anythink.expressad.video.dynview.a.a.f11574g : com.anythink.expressad.video.dynview.a.a.f11573f : com.anythink.expressad.video.dynview.a.a.f11572e : com.anythink.expressad.video.dynview.a.a.f11575h;
    }

    public static com.anythink.expressad.video.dynview.c b(View view, com.anythink.expressad.foundation.d.c cVar) {
        String strA;
        if (cVar == null) {
            return null;
        }
        String strK = "";
        if (cVar != null) {
            try {
                strK = cVar.K();
                strA = a(3);
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
                return null;
            }
        } else {
            strA = "";
        }
        d dVarA = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), strK, false);
        int iH = dVarA != null ? dVarA.h() : 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        return new c.a().a(strA).a(3).a(arrayList).a(view.getContext()).a(view).c(iH).b(k.b(view.getContext())).d(3).a();
    }

    public static com.anythink.expressad.video.dynview.c b(Context context, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        try {
            float f2 = t.f(n.a().g());
            float fE = t.e(n.a().g());
            int i2 = 0;
            if (list.get(0) != null) {
                int iK = list.get(0).k();
                list.get(0).as();
                list.get(0).aq();
                i2 = iK;
            }
            int iB = k.b(context);
            return new c.a().a(iB == 1 ? com.anythink.expressad.video.dynview.a.a.f11578k : com.anythink.expressad.video.dynview.a.a.f11579l).a(5).a(context).a(fE).b(f2).a(list).b(iB).b("").e(i2).d(i2).a();
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c a(View view, com.anythink.expressad.foundation.d.c cVar) {
        String strK;
        String strE;
        String strA;
        boolean zA;
        if (cVar == null) {
            return null;
        }
        int iB = 102;
        if (cVar != null) {
            try {
                strK = cVar.K();
                if (cVar.M() != null) {
                    iB = cVar.M().b();
                    strE = cVar.M().e();
                } else {
                    strE = "";
                }
                strA = a(iB);
                zA = com.anythink.expressad.video.dynview.i.c.a(strE);
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
                return null;
            }
        } else {
            strK = "";
            strA = strK;
            zA = false;
        }
        d dVarA = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), strK, false);
        int iH = dVarA != null ? dVarA.h() : 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        return new c.a().a(strA).a(iB).a(arrayList).a(view.getContext()).a(view).c(iH).b(k.b(view.getContext())).d(iB).a(zA).b("").e(cVar.k()).a();
    }

    public static com.anythink.expressad.video.dynview.c a(Context context, com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (cVar == null) {
            return null;
        }
        try {
            return new c.a().a(k.b(context) == 1 ? com.anythink.expressad.video.dynview.a.a.b : com.anythink.expressad.video.dynview.a.a.a).a(4).a(context).b(k.b(context)).b("").e(cVar.k()).d(i2).a();
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            return null;
        }
    }
}
