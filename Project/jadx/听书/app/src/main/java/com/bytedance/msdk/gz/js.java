package com.bytedance.msdk.gz;

import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class js {
    private static final HashSet z = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String z() {
        StackTraceElement[] stackTrace;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && !z.contains(stackTraceElement.getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                }
            }
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return "";
        }
    }

    public static String z(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (z(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return "";
        }
    }

    private static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Class.forName(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String g() {
        StackTraceElement[] stackTrace;
        Map<String, List<String>> mapMc;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace != null && stackTrace.length != 0 && (mapMc = com.bytedance.msdk.core.g.g().mc()) != null && !mapMc.isEmpty()) {
            for (String str : mapMc.keySet()) {
                if (z(mapMc.get(str), stackTrace)) {
                    return str;
                }
            }
        }
        return null;
    }

    private static boolean z(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i) != null) {
                        try {
                            if (stackTraceElement.toString().contains(list.get(i))) {
                                return true;
                            }
                        } catch (OutOfMemoryError e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean z(com.bytedance.msdk.g.dl dlVar) {
        if (dlVar == null || !dlVar.jc()) {
            return false;
        }
        return a();
    }

    public static boolean z(com.bytedance.msdk.core.uy.uy uyVar) {
        if (uyVar == null || !uyVar.oq()) {
            return false;
        }
        return a();
    }

    private static boolean a() {
        Map<String, List<String>> mapMc = com.bytedance.msdk.core.g.g().mc();
        if (mapMc == null || mapMc.size() == 0) {
            return false;
        }
        return z(com.bytedance.msdk.core.g.g().un());
    }

    public static boolean z(double d) {
        return d > 0.0d && Math.random() <= d;
    }

    public static double dl() {
        return com.bytedance.msdk.core.g.g().un();
    }
}
