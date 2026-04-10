package com.bytedance.sdk.openadsdk.core.dl;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private volatile String e;
    private volatile String m;
    public String z;
    private volatile int dl = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f1036a = -1;
    private volatile float gc = -1.0f;
    private volatile int gz = -1;
    private volatile int fo = -1;
    private volatile int uy = -1;
    private volatile int kb = -1;
    private volatile int wp = 0;
    private volatile int i = -1;
    private volatile int v = -1;
    private volatile int pf = -1;
    private volatile SharedPreferences g = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), fv(), 0);

    /* JADX INFO: Access modifiers changed from: private */
    public static String fv() {
        return "sp_exec_getad_config_bst";
    }

    private static class z {
        private static gc z = new gc();
    }

    public static gc z() {
        return z.z;
    }

    public long g() {
        if (this.f1036a == -1) {
            this.f1036a = z("duration", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
        return this.f1036a;
    }

    public int dl() {
        if (this.dl == -1) {
            this.dl = z("max", 50);
        }
        return this.dl;
    }

    public float a() {
        if (this.gc == -1.0f) {
            this.gc = z("aggMultiple", -1.0f);
        }
        return this.gc;
    }

    public String gc() {
        if (this.m == null) {
            this.m = g("ab_test_version", "");
        }
        return this.m;
    }

    public String m() {
        if (this.e == null) {
            this.e = g("ab_test_param", "");
        }
        return this.e;
    }

    public void e() {
        this.e = "";
        this.m = "";
        z("ab_test_version", "");
        z("ab_test_param", "");
    }

    public boolean gz() {
        if (this.i == -1) {
            this.i = z("dl_storage_internal", 1);
        }
        return this.i == 1;
    }

    public int fo() {
        if (this.v == -1) {
            this.v = z("cypher_version", 40001);
        }
        return this.v;
    }

    public boolean uy() {
        return z("is_spl_cache_remove_change", false);
    }

    public int kb() {
        if (this.gz == -1) {
            this.gz = z("spl_cache_conf", 14);
        }
        return this.gz;
    }

    public int wp() {
        if (this.uy == -1) {
            this.uy = z("spl_thread_conf", 1);
        }
        return this.uy;
    }

    public int i() {
        if (this.kb == -1) {
            this.kb = z("spl_common_conf", 0);
        }
        return this.kb;
    }

    public int v() {
        if (this.wp <= 0) {
            this.wp = z("splash_render_timeout_backup", 100);
        }
        return this.wp;
    }

    public int pf() {
        if (this.pf == -1) {
            this.pf = z("splash_policy", 0);
        }
        return this.pf;
    }

    public boolean z(String str, boolean z2) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z(fv(), str, z2);
            }
            return this.g.getBoolean(str, z2);
        } catch (Throwable unused) {
            return z2;
        }
    }

    public long z(String str, long j) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z(fv(), str, j);
            }
            return this.g.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float z(String str, float f) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z(fv(), str, f);
            }
            return this.g.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int z(String str, int i) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z(fv(), str, i);
            }
            return this.g.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void z(String str, String str2) {
        try {
            if (dl.z().g()) {
                com.bytedance.sdk.component.e.dl.z.g.z(fv(), str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = this.g.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String g(String str, String str2) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.g(fv(), str, str2);
            }
            return this.g.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void ls() {
        try {
            SharedPreferences.Editor editorEdit = this.g.edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static class g {
        private Map<String, Object> z = new HashMap();

        public g z(long j) {
            if (gc.z().f1036a == j) {
                return this;
            }
            gc.z().f1036a = j;
            this.z.put("duration", Long.valueOf(j));
            return this;
        }

        public g z(int i) {
            if (gc.z().dl == i) {
                return this;
            }
            gc.z().dl = i;
            this.z.put("max", Integer.valueOf(i));
            return this;
        }

        public g z(float f) {
            if (gc.z().gc == f) {
                return this;
            }
            gc.z().gc = f;
            this.z.put("aggMultiple", Float.valueOf(f));
            return this;
        }

        public g z(String str) {
            if (str != null && str.equals(gc.z().m)) {
                return this;
            }
            gc.z().m = str;
            Map<String, Object> map = this.z;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public g g(String str) {
            if (str != null && str.equals(gc.z().e)) {
                return this;
            }
            gc.z().e = str;
            Map<String, Object> map = this.z;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public g z(boolean z) {
            this.z.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public g g(int i) {
            if (gc.z().v == i) {
                return this;
            }
            gc.z().v = i;
            this.z.put("cypher_version", Integer.valueOf(i));
            return this;
        }

        public g dl(int i) {
            if (gc.z().gz == i) {
                return this;
            }
            gc.z().gz = i;
            this.z.put("spl_cache_conf", Integer.valueOf(i));
            return this;
        }

        public g a(int i) {
            if (gc.z().uy == i) {
                return this;
            }
            gc.z().uy = i;
            this.z.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public g gc(int i) {
            if (gc.z().kb == i) {
                return this;
            }
            gc.z().kb = i;
            this.z.put("spl_common_conf", Integer.valueOf(i));
            return this;
        }

        public g m(int i) {
            if (gc.z().fo == i) {
                return this;
            }
            gc.z().fo = i;
            this.z.put("spl_cache_expired", Integer.valueOf(i));
            return this;
        }

        public g dl(String str) {
            if (str != null && str.equals(gc.z().z)) {
                return this;
            }
            gc.z().z = str;
            Map<String, Object> map = this.z;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public g z(JSONObject jSONObject) {
            int iOptInt;
            if (jSONObject == null || gc.z().pf == (iOptInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            gc.z().pf = iOptInt;
            this.z.put("splash_policy", Integer.valueOf(iOptInt));
            return this;
        }

        public g e(int i) {
            if (gc.z().wp == i) {
                return this;
            }
            gc.z().wp = i;
            this.z.put("splash_render_timeout_backup", Integer.valueOf(i));
            return this;
        }

        public g gz(int i) {
            if (gc.z().i == i) {
                return this;
            }
            gc.z().i = i;
            this.z.put("dl_storage_internal", Integer.valueOf(i));
            return this;
        }

        public void z() {
            try {
                if (dl.z().g()) {
                    String strFv = gc.fv();
                    for (Map.Entry<String, Object> entry : this.z.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.e.dl.z.g.z(strFv, key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.e.dl.z.g.z(strFv, key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.e.dl.z.g.z(strFv, key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.e.dl.z.g.z(strFv, key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.e.dl.z.g.z(strFv, key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = gc.z().g.edit();
                for (Map.Entry<String, Object> entry2 : this.z.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.commit();
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }
}
