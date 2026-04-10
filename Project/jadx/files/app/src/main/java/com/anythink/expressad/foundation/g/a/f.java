package com.anythink.expressad.foundation.g.a;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static final String a = "native";
    public static final String b = "reward";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10437c = "interactive";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10438d = "interstitial";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10439e = "banner";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10440f = "splash";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10441g = "h5_native";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Map<String, Long> f10442h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10443i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10444j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10445k = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10446l = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10447m = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10448n = new HashMap();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10449o = new HashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> f10450p = new HashMap();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f10451q = "f";

    public static void a(String str, com.anythink.expressad.foundation.d.c cVar, String str2) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> mapB = b(str2);
        if (cVar == null || mapB == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(cVar.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.Z());
            if (!mapB.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                mapB.put(str, arrayList);
                return;
            }
            List<com.anythink.expressad.foundation.g.e.a> list = mapB.get(str);
            if (list != null && list.size() == 20) {
                list.remove(0);
            }
            if (list != null) {
                list.add(aVar);
            }
        } catch (Throwable th) {
            o.b(f10451q, th.getMessage(), th);
        }
    }

    private static void b(String str, com.anythink.expressad.foundation.d.c cVar, String str2) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> mapB = b(str2);
        if (cVar == null || mapB == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(cVar.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.Z());
            if (!mapB.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                mapB.put(str, arrayList);
            } else {
                List<com.anythink.expressad.foundation.g.e.a> list = mapB.get(str);
                if (list != null) {
                    list.add(aVar);
                }
            }
        } catch (Throwable th) {
            o.b(f10451q, th.getMessage(), th);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> b(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1396342996: goto L44;
                case -1052618729: goto L3a;
                case -934326481: goto L30;
                case -895866265: goto L26;
                case 538816457: goto L1c;
                case 604727084: goto L12;
                case 1844104930: goto L8;
                default: goto L7;
            }
        L7:
            goto L4e
        L8:
            java.lang.String r0 = "interactive"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 2
            goto L4f
        L12:
            java.lang.String r0 = "interstitial"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 3
            goto L4f
        L1c:
            java.lang.String r0 = "h5_native"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 6
            goto L4f
        L26:
            java.lang.String r0 = "splash"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 5
            goto L4f
        L30:
            java.lang.String r0 = "reward"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 1
            goto L4f
        L3a:
            java.lang.String r0 = "native"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 0
            goto L4f
        L44:
            java.lang.String r0 = "banner"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            r1 = 4
            goto L4f
        L4e:
            r1 = -1
        L4f:
            switch(r1) {
                case 0: goto L66;
                case 1: goto L63;
                case 2: goto L60;
                case 3: goto L5d;
                case 4: goto L5a;
                case 5: goto L57;
                case 6: goto L54;
                default: goto L52;
            }
        L52:
            r1 = 0
            goto L68
        L54:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10450p
            goto L68
        L57:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10449o
            goto L68
        L5a:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10448n
            goto L68
        L5d:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10447m
            goto L68
        L60:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10446l
            goto L68
        L63:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10445k
            goto L68
        L66:
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> r1 = com.anythink.expressad.foundation.g.a.f.f10444j
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.a.f.b(java.lang.String):java.util.Map");
    }

    private static String a(String str, String str2) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> mapB;
        List<com.anythink.expressad.foundation.g.e.a> list;
        JSONArray jSONArray = new JSONArray();
        if (TextUtils.isEmpty(str2)) {
            mapB = null;
            if (f10444j.containsKey(str)) {
                mapB = f10444j;
            } else if (f10445k.containsKey(str)) {
                mapB = f10445k;
            } else if (f10446l.containsKey(str)) {
                mapB = f10446l;
            } else if (f10447m.containsKey(str)) {
                mapB = f10447m;
            } else if (f10448n.containsKey(str)) {
                mapB = f10448n;
            } else if (f10449o.containsKey(str)) {
                mapB = f10449o;
            } else if (f10450p.containsKey(str)) {
                mapB = f10450p;
            }
        } else {
            mapB = b(str2);
        }
        if (mapB != null) {
            try {
                if (w.b(str) && mapB.containsKey(str) && (list = mapB.get(str)) != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("cid", list.get(i2).a());
                        jSONObject.put("rid", list.get(i2).b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    private static void a(Map... mapArr) {
        try {
            for (Map map : mapArr) {
                if (map != null) {
                    map.clear();
                }
            }
        } catch (Throwable th) {
            o.b(f10451q, th.getMessage(), th);
        }
    }

    private static Map<String, List<com.anythink.expressad.foundation.g.e.a>> a(String str) {
        if (f10444j.containsKey(str)) {
            return f10444j;
        }
        if (f10445k.containsKey(str)) {
            return f10445k;
        }
        if (f10446l.containsKey(str)) {
            return f10446l;
        }
        if (f10447m.containsKey(str)) {
            return f10447m;
        }
        if (f10448n.containsKey(str)) {
            return f10448n;
        }
        if (f10449o.containsKey(str)) {
            return f10449o;
        }
        if (f10450p.containsKey(str)) {
            return f10450p;
        }
        return null;
    }
}
