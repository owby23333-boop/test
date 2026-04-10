package com.bytedance.sdk.component.e.dl;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.component.a.g.dl {
    SharedPreferences z;

    @Override // com.bytedance.sdk.component.a.g.dl
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void applySync() {
    }

    public a(SharedPreferences sharedPreferences) {
        this.z = sharedPreferences;
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, int i) {
        try {
            this.z.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, long j) {
        try {
            this.z.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, float f) {
        try {
            this.z.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, boolean z) {
        try {
            this.z.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, String str2) {
        try {
            this.z.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, Set<String> set) {
        try {
            this.z.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void remove(String str) {
        try {
            this.z.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void clear() {
        try {
            this.z.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public int get(String str, int i) {
        try {
            return this.z.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public long get(String str, long j) {
        try {
            return this.z.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public float get(String str, float f) {
        try {
            return this.z.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public boolean get(String str, boolean z) {
        try {
            return this.z.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public String get(String str, String str2) {
        try {
            return this.z.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public Set<String> get(String str, Set<String> set) {
        try {
            return this.z.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.z.getAll();
        } catch (Exception unused) {
            return Collections.emptyMap();
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.z.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.z.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.z.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.z.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.z.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.z.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.z.contains(str);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.z.edit();
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.z.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.z.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
