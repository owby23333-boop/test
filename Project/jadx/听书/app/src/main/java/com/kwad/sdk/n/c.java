package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static final String TAG = "Ranger_c";
    private String value;

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ com.kwad.sdk.n.b.a.d a(c cVar, String str, String str2) {
        return an(str, str2);
    }

    private c() {
    }

    static class a {
        private static final c aXb = new c(0);
    }

    public static c OV() {
        return a.aXb;
    }

    public final void c(d dVar) {
        if (dVar == null || dVar.aXe == null || dVar.aXe.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.n.a.b> list = dVar.aXe;
        h.schedule(new bg() { // from class: com.kwad.sdk.n.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.n.a.b bVar : list) {
                    if (bVar != null && !TextUtils.isEmpty(bVar.aXu)) {
                        String str = bVar.aXu;
                        c cVar = c.this;
                        cVar.value = cVar.a(bVar);
                        c cVar2 = c.this;
                        com.kwad.sdk.n.b.a.d dVarA = c.a(cVar2, str, cVar2.value);
                        if (dVarA != null) {
                            arrayList.add(dVarA);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.n.b.a.e eVar = new com.kwad.sdk.n.b.a.e();
                eVar.aXP = arrayList;
                com.kwad.sdk.n.b.a.a(eVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    public final String a(com.kwad.sdk.n.a.b bVar) {
        if (bVar.aXw != null && !bVar.aXw.Pb()) {
            if (!TextUtils.isEmpty(bVar.aXs)) {
                bVar.aXw.aXq = c(bVar);
            } else if (bVar.aXv != null && !bVar.aXv.Pb()) {
                bVar.aXw.aXq = b(bVar);
            }
            return a(bVar.aXw);
        }
        if (!TextUtils.isEmpty(bVar.aXs)) {
            return o(c(bVar));
        }
        if (bVar.aXv != null && !bVar.aXv.Pb()) {
            return o(b(bVar));
        }
        com.kwad.sdk.core.d.c.d(TAG, "node.nodeClassName:" + bVar.aXr);
        return z.classExists(bVar.aXr) ? "true" : "false";
    }

    private Object b(com.kwad.sdk.n.a.b bVar) {
        Class<?> cls;
        if (bVar.aXv.aXE) {
            try {
                if (!TextUtils.isEmpty(bVar.aXr)) {
                    cls = Class.forName(bVar.aXr);
                } else {
                    cls = bVar.aXq != null ? bVar.aXq.getClass() : null;
                }
                if (cls != null) {
                    return a(bVar, true, cls);
                }
                return null;
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
                return null;
            }
        }
        if (bVar.aXq != null) {
            return a(bVar, false, (Class<?>) null);
        }
        return null;
    }

    private static Object a(com.kwad.sdk.n.a.b bVar, boolean z, Class<?> cls) {
        Object[] objArrPe = bVar.aXv.Pe();
        if (objArrPe == null || objArrPe.length == 0) {
            if (z) {
                return z.callStaticMethod(cls, bVar.aXv.name, new Object[0]);
            }
            return z.callMethod(bVar.aXq, bVar.aXv.name, new Object[0]);
        }
        if (z) {
            return z.callStaticMethod(cls, bVar.aXv.name, objArrPe);
        }
        return z.callMethod(bVar.aXq, bVar.aXv.name, objArrPe);
    }

    private static Object c(com.kwad.sdk.n.a.b bVar) {
        if (bVar.aXt) {
            try {
                return z.c(Class.forName(bVar.aXr), bVar.aXs);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
        } else if (bVar.aXq != null) {
            return z.getField(bVar.aXq, bVar.aXs);
        }
        return null;
    }

    private static String o(Object obj) {
        if (obj != null) {
            return String.valueOf(obj);
        }
        com.kwad.sdk.core.d.c.w(TAG, "value is null by ob null");
        return "";
    }

    private static com.kwad.sdk.n.b.a.d an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.n.b.a.d dVar = new com.kwad.sdk.n.b.a.d();
        dVar.name = str;
        dVar.aXO = str2;
        return dVar;
    }
}
