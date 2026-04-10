package com.anythink.expressad.mbbanner.a.e;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "b";

    private static String a(String str) {
        List<com.anythink.expressad.foundation.g.e.a> list;
        try {
            if (f.f10443i == null) {
                return "";
            }
            Map<String, List<com.anythink.expressad.foundation.g.e.a>> map = f.f10443i;
            if (!w.b(str) || !map.containsKey(str) || (list = map.get(str)) == null || list.size() <= 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                com.anythink.expressad.foundation.g.e.a aVar = list.get(i2);
                jSONObject.put("cid", aVar.a());
                jSONObject.put("crid", aVar.c());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void a() {
    }

    private static String b() {
        return "";
    }

    private static String c() {
        return "";
    }

    private static void a(String str, List<c> list) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> map = f.f10443i;
        if (map == null || list == null || list.size() <= 0) {
            return;
        }
        if (w.b(str)) {
            if (map.containsKey(str)) {
                map.put(str, a(map.get(str), list));
            } else {
                map.put(str, a(new ArrayList(), list));
            }
        }
        f.f10443i = map;
    }

    private static synchronized List<com.anythink.expressad.foundation.g.e.a> a(List<com.anythink.expressad.foundation.g.e.a> list, List<c> list2) {
        if (list2 != null) {
            if (list2.size() > 0) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                for (c cVar : list2) {
                    if (cVar != null) {
                        com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.r());
                        if (list.size() >= 20) {
                            list.remove(0);
                        }
                        list.add(aVar);
                    }
                }
            }
        }
        return list;
    }

    public static c a(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        if (TextUtils.isEmpty(str) && cVar == null) {
            return null;
        }
        if (!str.contains("notice")) {
            try {
                JSONObject jSONObjectA = c.a(cVar);
                c cVarB = c.b(jSONObjectA);
                if (cVarB == null) {
                    cVarB = cVar;
                }
                if (!TextUtils.isEmpty(str)) {
                    String strOptString = jSONObjectA.optString("unitId");
                    if (!TextUtils.isEmpty(strOptString)) {
                        cVarB.l(strOptString);
                    }
                    JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.anythink.expressad.foundation.g.a.ce);
                    if (jSONObjectOptJSONObject != null) {
                        String.valueOf(t.b(n.a().g(), Integer.valueOf(jSONObjectOptJSONObject.getString(com.anythink.expressad.foundation.g.a.cc)).intValue()));
                        String.valueOf(t.b(n.a().g(), Integer.valueOf(jSONObjectOptJSONObject.getString(com.anythink.expressad.foundation.g.a.cd)).intValue()));
                    }
                    cVarB.p(cVarB.ad());
                    String strAh = cVarB.ah();
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (itKeys.hasNext()) {
                            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                            String next = itKeys.next();
                            String strOptString2 = jSONObjectOptJSONObject.optString(next);
                            if (com.anythink.expressad.foundation.g.a.cc.equals(next) || com.anythink.expressad.foundation.g.a.cd.equals(next)) {
                                strOptString2 = String.valueOf(t.b(n.a().g(), Integer.valueOf(strOptString2).intValue()));
                            }
                            sb.append(next);
                            sb.append("=");
                            sb.append(strOptString2);
                        }
                        cVarB.q(strAh + ((Object) sb));
                    }
                }
                return cVarB;
            } catch (Throwable unused) {
                return cVar;
            }
        }
        try {
            JSONObject jSONObjectA2 = c.a(cVar);
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (!jSONObject.has(c.O)) {
                    jSONObjectA2.put(c.O, "");
                }
            } catch (Exception unused2) {
            }
            Iterator<String> itKeys2 = jSONObject.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                jSONObjectA2.put(next2, jSONObject.getString(next2));
            }
            c cVarB2 = c.b(jSONObjectA2);
            String strOptString3 = jSONObjectA2.optString("unitId");
            if (!TextUtils.isEmpty(strOptString3)) {
                cVarB2.l(strOptString3);
            }
            return cVarB2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return cVar;
        }
    }
}
