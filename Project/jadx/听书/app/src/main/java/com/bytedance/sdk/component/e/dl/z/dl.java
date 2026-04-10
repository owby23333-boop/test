package com.bytedance.sdk.component.e.dl.z;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.a.fo;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
class dl {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> z;

    private static SharedPreferences dl(String str) {
        return ((fo) com.bytedance.sdk.openadsdk.ats.dl.z("kv_store_factory")).get(a(str));
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object dl(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = z;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(a(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void g(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = z;
        if (softReference == null || softReference.get() == null) {
            z = new SoftReference<>(new ConcurrentHashMap());
        }
        String strA = a(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = z.get();
        if (concurrentHashMap.get(strA) == null) {
            concurrentHashMap.put(strA, new HashMap());
        }
        concurrentHashMap.get(strA).put(str2, obj);
    }

    private static void gc(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = z;
        if (softReference == null || softReference.get() == null || (map = z.get().get(a(str))) == null) {
            return;
        }
        map.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized <T> void z(String str, String str2, T t) {
        SharedPreferences sharedPreferencesDl = dl(str);
        if (sharedPreferencesDl == null) {
            return;
        }
        if (t.equals(dl(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesDl.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editorEdit.putString(str2, (String) t);
        }
        if (t instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editorEdit.putLong(str2, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editorEdit.putFloat(str2, ((Float) t).floatValue());
        }
        editorEdit.apply();
        g(str, str2, t);
    }

    static String z(String str, String str2, String str3) {
        Object objDl = dl(str, str2);
        if (objDl != null) {
            return String.valueOf(objDl);
        }
        Object objG = g(str, str2, str3);
        g(str, str2, objG);
        return String.valueOf(objG);
    }

    private static Object g(String str, String str2, String str3) {
        String strA = a(str);
        if (!z(strA, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
            return dl(strA, str2, null);
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(z(strA, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(z(strA, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(z(strA, str2, 0L));
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(z(strA, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return dl(strA, str2, null);
        }
        return null;
    }

    private static String dl(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesDl = dl(str);
        return sharedPreferencesDl == null ? str3 : sharedPreferencesDl.getString(str2, str3);
    }

    private static int z(String str, String str2, int i) {
        SharedPreferences sharedPreferencesDl = dl(str);
        return sharedPreferencesDl == null ? i : sharedPreferencesDl.getInt(str2, i);
    }

    private static float z(String str, String str2, float f) {
        SharedPreferences sharedPreferencesDl = dl(str);
        return sharedPreferencesDl == null ? f : sharedPreferencesDl.getFloat(str2, f);
    }

    private static boolean z(String str, String str2, boolean z2) {
        SharedPreferences sharedPreferencesDl = dl(str);
        return sharedPreferencesDl == null ? z2 : sharedPreferencesDl.getBoolean(str2, z2);
    }

    private static long z(String str, String str2, long j) {
        SharedPreferences sharedPreferencesDl = dl(str);
        return sharedPreferencesDl == null ? j : sharedPreferencesDl.getLong(str2, j);
    }

    static boolean z(String str, String str2) {
        SharedPreferences sharedPreferencesDl = dl(str);
        return sharedPreferencesDl != null && sharedPreferencesDl.contains(str2);
    }

    static void g(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesDl = dl(str);
            if (sharedPreferencesDl == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesDl.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = z;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strA = a(str);
            if (!TextUtils.isEmpty(strA) && (map = z.get().get(strA)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = z;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                z.get().put(strA, map);
            }
        } catch (Throwable unused) {
        }
    }

    static void z(String str) {
        SharedPreferences.Editor editorEdit = dl(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        gc(str);
    }

    static Map<String, ?> g(String str) {
        return dl(str).getAll();
    }
}
