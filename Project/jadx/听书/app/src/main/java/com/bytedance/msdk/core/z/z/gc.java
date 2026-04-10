package com.bytedance.msdk.core.z.z;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.hh.kb;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static String z = "dex";

    public static int z(String str, int i) {
        if (z(str) && i > 0) {
            if (i == 1) {
                return 20012;
            }
            if (i == 2) {
                return 20013;
            }
            if (i == 3) {
                return 20014;
            }
            if (i == 4) {
                return 20015;
            }
        }
        return 20016;
    }

    public static Integer z(String str, Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            if (z(str)) {
                Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8271).z(Integer.class).g());
                switch (objApply instanceof Integer ? ((Integer) objApply).intValue() : -1) {
                    case 20009:
                        return 2;
                    case 20010:
                        return 3;
                    case 20011:
                        return 4;
                    default:
                        return 1;
                }
            }
            Integer numZ = com.bytedance.sdk.openadsdk.core.ti.z.z.z(function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8121).z(20068, 1).z(Object.class).g()));
            if (numZ != null) {
                return numZ;
            }
        }
        return 1;
    }

    public static boolean z(String str) {
        return (str == null || a(str) == null) ? false : true;
    }

    public static Function<SparseArray<Object>, Object> g(String str) {
        Function<SparseArray<Object>, Object> functionA = a(str);
        if (functionA == null) {
            return null;
        }
        try {
            return (Function) functionA.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(10000).z(Function.class).g());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> g(String str, int i) {
        Function<SparseArray<Object>, Object> functionA = a(str);
        if (functionA == null) {
            return null;
        }
        try {
            return (Function) functionA.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(Function.class).g());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> a(String str) {
        m mVarZ = z.z(str);
        if (mVarZ == null) {
            com.bytedance.msdk.z.gc.dl.g(z, "strategy is null");
            return null;
        }
        if (!mVarZ.z()) {
            com.bytedance.msdk.z.gc.dl.g(z, "can not use dex load adn ad");
            return null;
        }
        if (!kb.e("com.byted.mixed")) {
            com.bytedance.msdk.z.gc.dl.g(z, "dex is not installed");
            return null;
        }
        if (!kb.m("com.byted.mixed")) {
            com.bytedance.msdk.z.gc.dl.g(z, "dex is not loaded");
            return null;
        }
        Function<SparseArray<Object>, Object> functionM = mVarZ.m();
        return functionM != null ? functionM : z(mVarZ);
    }

    private static Function<SparseArray<Object>, Object> z(m mVar) {
        if (mVar == null) {
            com.bytedance.msdk.z.gc.dl.g(z, "strategy is null");
            return null;
        }
        if (TextUtils.isEmpty(mVar.gz())) {
            com.bytedance.msdk.z.gc.dl.g(z, "adn name is empty");
            return null;
        }
        String strDl = mVar.dl();
        if (TextUtils.isEmpty(strDl)) {
            com.bytedance.msdk.z.gc.dl.g(z, "adn classname is empty");
            return null;
        }
        String strA = mVar.a();
        if (TextUtils.isEmpty(strA)) {
            com.bytedance.msdk.z.gc.dl.g(z, "adn versionListKey is empty");
            return null;
        }
        return z(mVar, strA, strDl);
    }

    private static Function<SparseArray<Object>, Object> z(m mVar, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObjectGc = kb.gc("com.byted.mixed");
            if (jSONObjectGc != null) {
                if (!jSONObjectGc.has("adn_version") || (jSONObjectOptJSONObject = jSONObjectGc.optJSONObject("adn_version")) == null || !jSONObjectOptJSONObject.has(str)) {
                    return null;
                }
                JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray(str);
                String strGc = mVar.gc();
                if (TextUtils.isEmpty(strGc) || jSONArray.length() <= 0) {
                    return null;
                }
                boolean z2 = false;
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    if (TextUtils.equals(jSONArray.getString(i), strGc)) {
                        z2 = true;
                        break;
                    }
                    i++;
                }
                if (z2) {
                    if (!jSONObjectGc.has(str2)) {
                        return null;
                    }
                    String strOptString = jSONObjectGc.optString(str2);
                    if (TextUtils.isEmpty(strOptString)) {
                        return null;
                    }
                    Object objNewInstance = Class.forName(strOptString).newInstance();
                    if (!(objNewInstance instanceof Function)) {
                        return null;
                    }
                    mVar.z((Function<SparseArray<Object>, Object>) objNewInstance);
                    return mVar.m();
                }
                mVar.z(strGc);
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g(z, "adn config json is null");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Function<SparseArray<Object>, Object> dl(String str) {
        m mVarZ = z.z(str);
        if (mVarZ != null) {
            return mVarZ.g();
        }
        return null;
    }

    public static void z(Map<String, Object> map) {
        if (map != null) {
            z.z(map);
        }
    }

    public static Function<SparseArray<Object>, Object> z(String str, int i, int i2) {
        try {
            if (!z.g(str)) {
                return null;
            }
            switch (i) {
                case 1:
                    return g(str, 20001);
                case 2:
                    return g(str, 20004);
                case 3:
                    return g(str, 20007);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (i2 == 4) {
                        return g(str, 20005);
                    }
                    if (i2 == 3) {
                        return g(str, 20001);
                    }
                    if (i2 == 5) {
                        return g(str, 20002);
                    }
                    return g(str, 20005);
                case 7:
                    return g(str, 20006);
                case 8:
                    return g(str, 20003);
                case 9:
                    return g(str, 20002);
                case 10:
                    if (i2 == 1) {
                        return g(str, 20004);
                    }
                    if (i2 == 2) {
                        return g(str, 20003);
                    }
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static com.bytedance.msdk.core.z.z.z.z g(String str, int i, int i2) {
        if (!TextUtils.equals(str, MediationConstant.ADN_GDT)) {
            return null;
        }
        switch (i) {
            case 1:
                return new com.bytedance.msdk.core.z.z.g.z.z.z();
            case 2:
                return new com.bytedance.msdk.core.z.z.g.z.gc.z();
            case 3:
                return new com.bytedance.msdk.core.z.z.g.z.e.z();
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new com.bytedance.msdk.core.z.z.g.z.dl.z();
                }
                if (i2 == 3) {
                    return new com.bytedance.msdk.core.z.z.g.z.z.z();
                }
                if (i2 == 5) {
                    return new com.bytedance.msdk.core.z.z.g.z.g.z();
                }
                return new com.bytedance.msdk.core.z.z.g.z.dl.z();
            case 7:
                return new com.bytedance.msdk.core.z.z.g.z.m.z();
            case 8:
                return new com.bytedance.msdk.core.z.z.g.z.a.z();
            case 9:
                return new com.bytedance.msdk.core.z.z.g.z.g.z();
            case 10:
                if (i2 == 1) {
                    return new com.bytedance.msdk.core.z.z.g.z.gc.z();
                }
                if (i2 == 2) {
                    return new com.bytedance.msdk.core.z.z.g.z.a.z();
                }
                return null;
        }
    }

    public static String z() {
        return com.bytedance.msdk.e.z.z.z().e() ? "load_plugin_gdt_adapter_v2" : "";
    }

    public static void z(com.bytedance.msdk.api.z.g gVar) {
        if (gVar != null) {
            gVar.e(1);
        }
    }

    public static void g(com.bytedance.msdk.api.z.g gVar) {
        if (gVar != null) {
            gVar.e(3);
        }
    }

    public static int dl(com.bytedance.msdk.api.z.g gVar) {
        if (gVar == null) {
            return 4;
        }
        if (com.bytedance.msdk.e.z.z.z().e()) {
            return gVar.kb() == 1 ? 1 : 2;
        }
        if (com.bytedance.msdk.e.z.z.z().gz() != 1) {
            return 3;
        }
        return gVar.kb();
    }

    public static int g() {
        return com.bytedance.msdk.e.z.z.z().gz();
    }
}
