package com.yuewen;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class yg1 {
    public static volatile yg1 d;
    public static final Object e = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20347b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20346a = false;
    public ConcurrentHashMap<String, Map<String, List<String>>> c = new ConcurrentHashMap<>();

    public yg1(Context context) {
        this.f20347b = "";
        this.f20347b = e(context);
    }

    public static synchronized yg1 a() {
        return d;
    }

    public static synchronized void m(Context context) {
        if (d == null) {
            d = new yg1(context);
        }
    }

    public final List<String> b(String str) {
        Map<String, List<String>> map;
        if (TextUtils.isEmpty(str) || !g() || this.c.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, Map<String, List<String>>> concurrentHashMap = this.c;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty() && (map = concurrentHashMap.get(str)) != null && !map.isEmpty()) {
            if (g72.h().m() && !TextUtils.isEmpty(d())) {
                String strD = d();
                strD.hashCode();
                switch (strD) {
                    case "46000":
                    case "46002":
                        i(map.get(xg1.e), arrayList);
                        break;
                    case "46001":
                        i(map.get(xg1.f), arrayList);
                        break;
                    case "46003":
                        i(map.get(xg1.g), arrayList);
                        break;
                }
            }
            if (arrayList.size() == 0) {
                i(map.get(xg1.h), arrayList);
            }
        }
        return arrayList;
    }

    public String c(String str) {
        return !h(str) ? "" : f(b(str));
    }

    public final String d() {
        return this.f20347b;
    }

    public final String e(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(com.xiaomi.onetrack.api.at.d);
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? "" : telephonyManager.getSimOperator();
    }

    public final String f(List<String> list) {
        return (list == null || list.size() <= 0) ? "" : list.get((int) (Math.random() * ((double) list.size())));
    }

    public boolean g() {
        return this.f20346a;
    }

    public final boolean h(String str) {
        ConcurrentHashMap<String, Map<String, List<String>>> concurrentHashMap = this.c;
        return (concurrentHashMap == null || concurrentHashMap.isEmpty() || concurrentHashMap.get(str) == null) ? false : true;
    }

    public final void i(List<String> list, List<String> list2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list2.addAll(list);
    }

    public final void j(Map<String, List<String>> map, JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add((String) jSONArrayOptJSONArray.opt(i));
            }
            map.put(str, arrayList);
        }
    }

    public void k(String str) {
        try {
            JSONArray jSONArray = (JSONArray) new JSONObject(str).get("data");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    HashMap map = new HashMap();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString(xg1.k);
                    j(map, jSONObject, xg1.h);
                    j(map, jSONObject, xg1.e);
                    j(map, jSONObject, xg1.g);
                    j(map, jSONObject, xg1.f);
                    this.c.put(strOptString, map);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void l(boolean z) {
        this.f20346a = z;
    }
}
