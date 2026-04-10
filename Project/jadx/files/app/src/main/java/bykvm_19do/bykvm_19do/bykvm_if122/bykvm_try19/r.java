package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r {
    private static boolean a = true;
    private static boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1780c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1781d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1782e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f1783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<Integer, Map<String, List<List<String>>>> f1784g = new HashMap();

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        if (jSONArrayOptJSONArray != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                                int iOptInt = jSONObject2.optInt("rit_type");
                                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (jSONArrayOptJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                        JSONArray jSONArray = jSONArrayOptJSONArray2.getJSONArray(i3);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                                String string = jSONArray.getString(i4);
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
                                        f1784g.put(Integer.valueOf(iOptInt), map);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                Logger.d("TMe", "supervisorFeature error: " + e2.toString());
                e2.printStackTrace();
                return;
            }
        }
        Logger.d("TMe", "--==-- adn features:" + f1784g);
    }

    public static void a(boolean z2) {
        f1783f = z2;
    }

    public static boolean a() {
        return f1783f;
    }

    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = f1784g.get(8)) == null || (list = map.get("pangle")) == null || list.size() <= 1) {
            return true;
        }
        return a(stackTraceElementArr, list);
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, int i2, List<String> list) {
        int i3;
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4);
            if (TextUtils.isEmpty(str) || (i3 = i2 + i4) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            if (stackTraceElement != null) {
                String string = stackTraceElement.toString();
                if (TextUtils.isEmpty(string) || !string.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, List<List<String>> list) {
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (stackTraceElement != null) {
                        String string = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(string) && string.contains(list2.get(0)) && (list2.size() == 1 || a(stackTraceElementArr, i2, list2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean b() {
        if (!f1782e) {
            return false;
        }
        f1782e = false;
        return true;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = f1784g.get(7)) == null || (list = map.get("pangle")) == null || list.size() <= 1) {
            return true;
        }
        return a(stackTraceElementArr, list);
    }

    public static boolean c() {
        if (!f1781d) {
            return false;
        }
        f1781d = false;
        return true;
    }

    public static boolean d() {
        if (!b) {
            return false;
        }
        b = false;
        return true;
    }

    public static boolean e() {
        if (!a) {
            return false;
        }
        a = false;
        return true;
    }

    public static boolean f() {
        if (!f1780c) {
            return false;
        }
        f1780c = false;
        return true;
    }
}
