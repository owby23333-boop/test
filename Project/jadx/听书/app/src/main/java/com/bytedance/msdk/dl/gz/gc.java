package com.bytedance.msdk.dl.gz;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.sdk.component.utils.wp;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static final Map<String, z> z = new ConcurrentHashMap();

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<String> f451a;
        public Set<String> dl;
        public int g;
        public int gc;
        public String z;
    }

    public static void z(JSONArray jSONArray) {
        int iOptInt;
        if (jSONArray == null || jSONArray.length() <= 0) {
            z.clear();
            return;
        }
        z.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("id");
                if (!TextUtils.isEmpty(strOptString)) {
                    z zVar = new z();
                    int iOptInt2 = jSONObjectOptJSONObject.optInt(an.aI);
                    zVar.z = strOptString;
                    zVar.g = iOptInt2;
                    if (iOptInt2 == 1) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("a");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            zVar.f451a = new HashSet();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                zVar.f451a.add(jSONArrayOptJSONArray.optString(i2));
                            }
                            z.put(strOptString, zVar);
                        }
                    } else if (iOptInt2 == 2) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("r");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            zVar.dl = new HashSet();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                zVar.dl.add(jSONArrayOptJSONArray2.optString(i3));
                            }
                            z.put(strOptString, zVar);
                        }
                    } else if ((iOptInt2 == 3 || iOptInt2 == 4) && (iOptInt = jSONObjectOptJSONObject.optInt("c", -1)) != -1) {
                        zVar.gc = iOptInt;
                        z.put(strOptString, zVar);
                    }
                }
            }
        }
    }

    public static z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.get(str);
    }

    private static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
            case "pangle":
                return "376434";
            case "sigmob":
                return "476747";
            case "ks":
                return "575683";
            case "gdt":
                return "384735";
            case "admob":
                return "547957";
            case "baidu":
                return "476385";
            case "unity":
                return "846469";
            case "mintegral":
                return "765380";
            default:
                return str;
        }
    }

    private static boolean z(z zVar, double d, String str, String str2) {
        if (!z.isEmpty() && zVar != null) {
            int i = zVar.g;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && d > 0.0d && d <= zVar.gc) {
                            return true;
                        }
                    } else if (d > 0.0d && d >= zVar.gc) {
                        return true;
                    }
                } else if (zVar.dl.contains(str2)) {
                    return true;
                }
            } else if (zVar.f451a.contains(g(str))) {
                return true;
            }
        }
        return false;
    }

    public static z z(com.bytedance.msdk.api.z.g gVar, uy uyVar) {
        if (z.isEmpty()) {
            return null;
        }
        Map<String, Object> mapOq = gVar.oq();
        Object obj = mapOq.get("on_shield");
        Object obj2 = mapOq.get("id_list");
        if ((obj instanceof Integer) && (obj2 instanceof List) && uyVar != null && ((Integer) obj).intValue() == 1) {
            ArrayList<z> arrayList = new ArrayList();
            try {
                Iterator it = ((List) obj2).iterator();
                boolean z2 = false;
                boolean z3 = false;
                while (it.hasNext()) {
                    z zVarZ = z((String) it.next());
                    if (zVarZ != null) {
                        if (zVarZ.g == 3) {
                            if (!z2) {
                                arrayList.add(zVarZ);
                                z2 = true;
                            }
                        } else if (zVarZ.g != 4) {
                            arrayList.add(zVarZ);
                        } else if (!z3) {
                            arrayList.add(zVarZ);
                            z3 = true;
                        }
                    }
                }
                Collections.sort(arrayList, new Comparator<z>() { // from class: com.bytedance.msdk.dl.gz.gc.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                    public int compare(z zVar, z zVar2) {
                        return zVar.g - zVar2.g;
                    }
                });
            } catch (Throwable th) {
                wp.z(th);
            }
            if (!arrayList.isEmpty()) {
                z(arrayList);
                for (z zVar : arrayList) {
                    if (z(zVar, uyVar.zw(), uyVar.p(), uyVar.fv())) {
                        return zVar;
                    }
                }
            }
        }
        return null;
    }

    private static void z(List<z> list) {
        if (list.size() >= 2) {
            int size = list.size();
            int i = size - 1;
            if (list.get(i).g != 4) {
                return;
            }
            int i2 = size - 2;
            if (list.get(i2).g == 3 && list.get(i2).gc <= list.get(i).gc) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
