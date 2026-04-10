package com.xiaomi.ad.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class SharedPreferencesWrapper {
    public SharedPreferences mSharedPref;

    public SharedPreferencesWrapper(Context context, String str) {
        this.mSharedPref = context.getSharedPreferences(str, 0);
    }

    public static Set<String> getSetCanBeModified(SharedPreferencesWrapper sharedPreferencesWrapper, String str, Set<String> set) {
        Set<String> stringSet;
        if (sharedPreferencesWrapper != null && (stringSet = sharedPreferencesWrapper.getStringSet(str, set)) != null) {
            return new HashSet(stringSet);
        }
        return new HashSet();
    }

    public void clear() {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public boolean contains(String str) {
        return this.mSharedPref.contains(str);
    }

    public Map<String, ?> getAll() {
        return this.mSharedPref.getAll();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mSharedPref.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return this.mSharedPref.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        return this.mSharedPref.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.mSharedPref.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.mSharedPref.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.mSharedPref.getStringSet(str, set);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public void putFloat(String str, float f) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.putFloat(str, f);
        editorEdit.apply();
    }

    public void putInt(String str, int i) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public void putLong(String str, long j) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public void putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.putStringSet(str, set);
        editorEdit.apply();
    }

    public void remove(String str) {
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public void remove(String[] strArr) {
        if (CollectionUtils.isEmpty(strArr)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mSharedPref.edit();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                editorEdit.remove(str);
            }
        }
        editorEdit.apply();
    }
}
