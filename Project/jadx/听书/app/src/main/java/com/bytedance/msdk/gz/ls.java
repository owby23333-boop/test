package com.bytedance.msdk.gz;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f490a = true;
    private static boolean dl = true;
    private static final Map<Integer, Map<String, List<List<String>>>> e = new HashMap();
    private static boolean g = true;
    private static boolean gc = true;
    private static boolean m = false;
    private static boolean z = true;

    public static boolean z() {
        return m;
    }

    public static void z(boolean z2) {
        m = z2;
    }

    public static void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                                Integer numValueOf = Integer.valueOf(jSONObject2.optInt("rit_type"));
                                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (jSONArrayOptJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                        JSONArray jSONArray = jSONArrayOptJSONArray2.getJSONArray(i2);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                String string = jSONArray.getString(i3);
                                                if (!TextUtils.isEmpty(string)) {
                                                    arrayList2.add(string);
                                                }
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        HashMap map = new HashMap();
                                        map.put(next, arrayList);
                                        e.put(numValueOf, map);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                com.bytedance.msdk.z.gc.dl.z("TMe", "supervisorFeature error: " + e2.toString());
                com.bytedance.sdk.component.utils.wp.z(e2);
                return;
            }
        }
        com.bytedance.msdk.z.gc.dl.z("TMe", "--==-- adn features:" + e);
    }

    private static boolean z(Object obj, List<List<String>> list) {
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i = 0; i < stackTraceElementArr.length; i++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (stackTraceElement != null) {
                        String string = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(string) && string.contains(list2.get(0)) && (list2.size() == 1 || z(stackTraceElementArr, i, list2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean z(Object obj, int i, List<String> list) {
        int i2;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            if (TextUtils.isEmpty(str) || (i2 = i + i3) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            if (stackTraceElement != null) {
                String string = stackTraceElement.toString();
                if (TextUtils.isEmpty(string) || !string.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g() {
        StackTraceElement[] stackTrace;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0 || (map = e.get(7)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return z(stackTrace, list);
    }

    public static boolean dl() {
        StackTraceElement[] stackTrace;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0 || (map = e.get(8)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return z(stackTrace, list);
    }

    public static boolean a() {
        if (!z) {
            return false;
        }
        z = false;
        return true;
    }

    public static boolean gc() {
        if (!g) {
            return false;
        }
        g = false;
        return true;
    }

    public static boolean m() {
        if (!dl) {
            return false;
        }
        dl = false;
        return true;
    }

    public static boolean e() {
        if (!f490a) {
            return false;
        }
        f490a = false;
        return true;
    }

    public static boolean gz() {
        if (!gc) {
            return false;
        }
        gc = false;
        return true;
    }
}
