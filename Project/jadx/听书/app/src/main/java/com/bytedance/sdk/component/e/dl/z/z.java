package com.bytedance.sdk.component.e.dl.z;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.a.g.dl {
    private static final Map<String, com.bytedance.sdk.component.a.g.dl> g = new ConcurrentHashMap();
    private String z;

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

    public static com.bytedance.sdk.component.a.g.dl z(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.a.g.dl> map = g;
        com.bytedance.sdk.component.a.g.dl dlVar = map.get(str);
        if (dlVar != null) {
            return dlVar;
        }
        z zVar = new z(str);
        map.put(str, zVar);
        return zVar;
    }

    private z(String str) {
        this.z = str;
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, int i) {
        g.z(this.z, str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, long j) {
        g.z(this.z, str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, float f) {
        g.z(this.z, str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, boolean z) {
        g.z(this.z, str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, String str2) {
        g.z(this.z, str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, Set<String> set) {
        g.z(this.z, str, set);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return g.g(this.z);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return g.g(this.z, str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return g.g(this.z, str, set);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return g.z(this.z, str, i);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return g.z(this.z, str, j);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return g.z(this.z, str, f);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return g.z(this.z, str, z);
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean contains(String str) {
        return g.z(this.z, str);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void remove(String str) {
        g.g(this.z, str);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void clear() {
        g.z(this.z);
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
}
