package com.bytedance.sdk.openadsdk.hh;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class kb {
    private static Map<String, Field> z = new HashMap();

    public static void z(String str) {
        try {
            if (gk.dl < 5500) {
                gz(str);
                return;
            }
            Function<SparseArray<Object>, Object> functionM = com.bytedance.sdk.openadsdk.core.uy.ls().m(4);
            if (functionM != null) {
                functionM.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(100).z(Void.class).z(0, str).g());
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private static void gz(String str) {
        try {
            Class.forName("com.bytedance.pangle.Zeus").getDeclaredMethod("unInstallPlugin", String.class).invoke(null, str);
        } catch (Throwable unused) {
        }
    }

    public static int g(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return gk.dl;
        }
        return z(str, 101);
    }

    public static int dl(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7105;
        }
        return z(str, 103);
    }

    public static int a(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return gk.dl;
        }
        return z(str, 102);
    }

    private static int z(String str, int i) {
        Object objApply;
        try {
            Function<SparseArray<Object>, Object> functionM = com.bytedance.sdk.openadsdk.core.uy.ls().m(4);
            if (functionM != null && (objApply = functionM.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(Integer.class).z(0, str).g())) != null) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable th) {
            wp.g("ZeusUtil", th);
        }
        return 0;
    }

    public static JSONObject gc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> functionM = com.bytedance.sdk.openadsdk.core.uy.ls().m(4);
            if (functionM != null) {
                Object objApply = functionM.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(13).z(JSONObject.class).z(0, str).g());
                if (objApply instanceof JSONObject) {
                    return (JSONObject) objApply;
                }
            }
        } catch (Throwable th) {
            wp.g("ZeusUtil", th);
        }
        return null;
    }

    public static boolean m(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionM = com.bytedance.sdk.openadsdk.core.uy.ls().m(4);
            if (functionM != null && (objApply = functionM.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(104).z(Boolean.class).z(0, str).g())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
            wp.g("ZeusUtil", th);
        }
        return false;
    }

    public static boolean e(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionM = com.bytedance.sdk.openadsdk.core.uy.ls().m(4);
            if (functionM != null && (objApply = functionM.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(105).z(Boolean.class).z(0, str).g())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
            wp.g("ZeusUtil", th);
        }
        return false;
    }
}
