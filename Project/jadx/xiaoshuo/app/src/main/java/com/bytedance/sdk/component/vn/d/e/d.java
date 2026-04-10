package com.bytedance.sdk.component.vn.d.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class d {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> e;

    private static void bf(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = e;
        if (softReference == null || softReference.get() == null || (map = e.get().get(e(str))) == null) {
            return;
        }
        map.clear();
    }

    private static SharedPreferences d(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(e(str), 0);
    }

    private static String e(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static String d(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferencesD = d(context, str);
        return sharedPreferencesD == null ? str3 : sharedPreferencesD.getString(str2, str3);
    }

    private static Object e(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = e;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(e(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static Object bf(Context context, String str, String str2, String str3) {
        String strE = e(str);
        if (!e(context, strE, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
            return d(context, strE, str2, null);
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(e(context, strE, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(e(context, strE, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(e(context, strE, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(e(context, strE, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return d(context, strE, str2, null);
        }
        return null;
    }

    private static void e(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = e;
        if (softReference == null || softReference.get() == null) {
            e = new SoftReference<>(new ConcurrentHashMap());
        }
        String strE = e(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = e.get();
        if (concurrentHashMap.get(strE) == null) {
            concurrentHashMap.put(strE, new HashMap());
        }
        concurrentHashMap.get(strE).put(str2, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T> void e(Context context, String str, String str2, T t) {
        SharedPreferences sharedPreferencesD = d(context, str);
        if (sharedPreferencesD == null) {
            return;
        }
        if (t.equals(e(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesD.edit();
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
        e(str, str2, t);
    }

    public static void bf(Context context, String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesD = d(context, str);
            if (sharedPreferencesD == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesD.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = e;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strE = e(str);
            if (!TextUtils.isEmpty(strE) && (map = e.get().get(strE)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = e;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                e.get().put(strE, map);
            }
        } catch (Throwable unused) {
        }
    }

    public static Map<String, ?> bf(Context context, String str) {
        return d(context, str).getAll();
    }

    public static String e(Context context, String str, String str2, String str3) {
        Object objE = e(str, str2);
        if (objE != null) {
            return objE + "";
        }
        Object objBf = bf(context, str, str2, str3);
        e(str, str2, objBf);
        return objBf + "";
    }

    private static int e(Context context, String str, String str2, int i) {
        SharedPreferences sharedPreferencesD = d(context, str);
        return sharedPreferencesD == null ? i : sharedPreferencesD.getInt(str2, i);
    }

    private static float e(Context context, String str, String str2, float f) {
        SharedPreferences sharedPreferencesD = d(context, str);
        return sharedPreferencesD == null ? f : sharedPreferencesD.getFloat(str2, f);
    }

    private static boolean e(Context context, String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesD = d(context, str);
        return sharedPreferencesD == null ? z : sharedPreferencesD.getBoolean(str2, z);
    }

    private static long e(Context context, String str, String str2, long j) {
        SharedPreferences sharedPreferencesD = d(context, str);
        return sharedPreferencesD == null ? j : sharedPreferencesD.getLong(str2, j);
    }

    public static boolean e(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesD = d(context, str);
        return sharedPreferencesD != null && sharedPreferencesD.contains(str2);
    }

    public static void e(Context context, String str) {
        SharedPreferences.Editor editorEdit = d(context, str).edit();
        editorEdit.clear();
        editorEdit.apply();
        bf(str);
    }
}
