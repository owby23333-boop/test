package com.bytedance.sdk.component.vn.d.bf;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static Map<String, e> e = new HashMap();
    private SharedPreferences bf;

    private e(String str, Context context) {
        if (context != null) {
            this.bf = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static e e(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        e eVar = e.get(str);
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(str, context);
        e.put(str, eVar2);
        return eVar2;
    }

    public String bf(String str, String str2) {
        try {
            return this.bf.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int bf(String str, int i) {
        try {
            return this.bf.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public long bf(String str, long j) {
        try {
            return this.bf.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float bf(String str, float f) {
        try {
            return this.bf.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public boolean bf(String str, boolean z) {
        try {
            return this.bf.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public void e(String str, String str2) {
        try {
            this.bf.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public Set<String> bf(String str, Set<String> set) {
        try {
            return this.bf.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void e(String str, int i) {
        try {
            this.bf.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    public void bf() {
        try {
            this.bf.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    public void e(String str, long j) {
        try {
            this.bf.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    public void e(String str, float f) {
        try {
            this.bf.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    public void e(String str, boolean z) {
        try {
            this.bf.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    public void e(String str, Set<String> set) {
        try {
            this.bf.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    public Map<String, ?> e() {
        try {
            return this.bf.getAll();
        } catch (Throwable unused) {
            return Collections.emptyMap();
        }
    }

    public void e(String str) {
        try {
            this.bf.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
