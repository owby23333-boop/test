package com.bytedance.sdk.component.e.g.z;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.a.g.dl;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z implements dl {
    private Keva z;
    private static final Map<String, dl> g = new HashMap();
    private static volatile boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f703a = true;

    @Override // com.bytedance.sdk.component.a.g.dl
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void applySync() {
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public static dl z(Context context, String str, boolean z, int i) {
        if (!f703a) {
            return null;
        }
        try {
            if (!dl) {
                dl = z(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!f703a) {
                return null;
            }
            Map<String, dl> map = g;
            dl zVar = map.get(str);
            if (zVar == null) {
                zVar = new z(str, z, i);
                if (f703a) {
                    map.put(str, zVar);
                }
            }
            if (f703a) {
                return zVar;
            }
            return null;
        } catch (Throwable unused) {
            f703a = false;
            return null;
        }
    }

    private static boolean z(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.e.g.z.z.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private z(String str, boolean z, int i) {
        if (i == 1) {
            z(str, z);
        } else {
            g(str, z);
        }
    }

    private void z(String str, boolean z) {
        if (z) {
            this.z = Keva.getRepo(str, 1);
        } else {
            this.z = Keva.getRepo(str, 0);
        }
    }

    private void g(String str, boolean z) {
        if (z) {
            this.z = Keva.getRepoSync(str, 1);
        } else {
            this.z = Keva.getRepoSync(str, 0);
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, int i) {
        this.z.storeInt(str, i);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, long j) {
        this.z.storeLong(str, j);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, float f) {
        this.z.storeFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, boolean z) {
        this.z.storeBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, String str2) {
        this.z.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, Set<String> set) {
        this.z.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void remove(String str) {
        this.z.erase(str);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void clear() {
        this.z.clear();
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.z.getAll();
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.z.getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.z.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.z.getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.z.getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.z.getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.z.getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.z.contains(str);
    }
}
