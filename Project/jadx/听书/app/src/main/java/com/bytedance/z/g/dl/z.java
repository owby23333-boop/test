package com.bytedance.z.g.dl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.z.g.gz.uy;
import com.bytedance.z.g.gz.v;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
import com.umeng.umcrash.UMCrash;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    protected JSONObject z;

    public z() {
        this.z = new JSONObject();
    }

    public z(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public static z z(long j, Context context, Thread thread, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        z zVar = new z();
        zVar.z("isJava", (Object) 1);
        zVar.z("event_type", "java_crash");
        zVar.z(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        zVar.z("data", v.z(th));
        zVar.z("isOOM", Boolean.valueOf(v.g(th)));
        zVar.z("crash_time", Long.valueOf(j));
        zVar.z(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.z.g.gz.z.a(context));
        if (!com.bytedance.z.g.gz.z.g(context)) {
            zVar.z("remote_process", (Object) 1);
        }
        com.bytedance.z.g.gz.z.z(context, zVar.z());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            zVar.z("crash_thread_name", name);
        }
        zVar.z("all_thread_stacks", v.z(name));
        return zVar;
    }

    public JSONObject z() {
        return this.z;
    }

    public z z(g gVar) {
        z("header", gVar.z());
        return this;
    }

    public z z(long j) {
        try {
            z(d.p, Long.valueOf(j));
            z("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            wp.z(e);
        }
        return this;
    }

    public z z(String str) {
        if (!TextUtils.isEmpty(str)) {
            z("session_id", str);
        }
        return this;
    }

    public z z(com.bytedance.z.g.gc.z.g gVar) {
        z("activity_trace", gVar.z());
        z("running_tasks", gVar.g());
        return this;
    }

    public z z(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.z.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(an.o, str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.z.put("plugin_info", jSONArray);
        return this;
    }

    public z g(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    uy.g(e);
                }
            }
            try {
                this.z.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                wp.z(e2);
            }
        }
        return this;
    }

    public z z(int i, String str) {
        try {
            this.z.put("miniapp_id", i);
            this.z.put("miniapp_version", str);
        } catch (JSONException e) {
            wp.z(e);
        }
        return this;
    }

    public z z(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            z("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        z("patch_info", jSONArray);
        return this;
    }

    public z z(JSONObject jSONObject) {
        z("storage", jSONObject);
        return this;
    }

    public z g(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        z("logcat", jSONArray);
        return this;
    }

    public z dl(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
            z("filters", jSONObject);
        }
        return this;
    }

    public void z(String str, Object obj) {
        try {
            this.z.put(str, obj);
        } catch (Exception e) {
            uy.g(e);
        }
    }
}
