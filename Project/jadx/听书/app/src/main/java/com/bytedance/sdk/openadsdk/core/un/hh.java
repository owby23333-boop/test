package com.bytedance.sdk.openadsdk.core.un;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class hh {
    private static AtomicBoolean g = new AtomicBoolean(true);
    public static volatile Map<String, Boolean> z = new ConcurrentHashMap();

    private hh() {
    }

    private static final class z {
        private static final com.bytedance.sdk.component.a.g.dl z = com.bytedance.sdk.openadsdk.ats.a.z("tt_scheme_check_list_cache");
    }

    public static void z(String str, Boolean bool) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            string = "";
        } else {
            try {
                string = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", string);
        jSONObject.put("time", System.currentTimeMillis());
        z.z.put(str, jSONObject.toString());
        g.set(true);
    }

    public static Map<String, Boolean> z(long j) {
        try {
            if (g.get()) {
                synchronized (hh.class) {
                    if (g.get()) {
                        Map<String, Boolean> mapG = g(j);
                        g.set(false);
                        return mapG;
                    }
                }
            }
            return new HashMap(z);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public static Map<String, Boolean> g(long j) {
        HashMap map = new HashMap();
        try {
            Map all = z.z.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long jCurrentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String str = (String) entry.getKey();
                    if (jCurrentTimeMillis > 259200000) {
                        z(str);
                    } else if (jCurrentTimeMillis <= j) {
                        map.put(str, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get("value").toString())));
                    }
                }
                if (z == null) {
                    z = new ConcurrentHashMap();
                } else {
                    z.clear();
                }
                z.putAll(map);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static Boolean z(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectG = g(str);
            if (jSONObjectG == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectG.getLong("time") <= j) {
                return Boolean.valueOf(Boolean.parseBoolean(jSONObjectG.getString("value")));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void z(String str) {
        z.z.remove(str);
    }

    private static JSONObject g(String str) {
        String str2 = z.z.get(str, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String z(Uri uri) {
        if (uri == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme()).append("://").append(uri.getHost());
        int port = uri.getPort();
        if (port > 0) {
            sb.append(":").append(port);
        }
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            sb.append(path);
        }
        return sb.toString();
    }
}
