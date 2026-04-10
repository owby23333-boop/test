package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences.Editor f291a;
    private final SharedPreferences dl;
    private final ReentrantReadWriteLock z = new ReentrantReadWriteLock();
    private final Map<String, String> g = new HashMap();

    public hh(Context context) {
        SharedPreferences sharedPreferencesG = o.g(context);
        this.dl = sharedPreferencesG;
        this.f291a = sharedPreferencesG.edit();
    }

    public void z(String str, String str2) {
        this.z.writeLock().lock();
        try {
            this.g.put(str, str2);
            js.z("__kite", "updateMemoryCacheBySync# update mem success, key: ".concat(String.valueOf(str)));
        } finally {
            this.z.writeLock().unlock();
        }
    }

    public void g(String str, String str2) {
        try {
            this.f291a.putString(str, str2);
            this.f291a.commit();
        } catch (Exception e) {
            js.g("__kiteupdateDiskCache# error " + e.getMessage());
        }
    }

    public String z(String str) {
        String str2 = this.g.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.z.readLock().lock();
        try {
            String string = this.g.get(str);
            if (TextUtils.isEmpty(string)) {
                string = this.dl.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    this.g.put(str, string);
                    if (js.g()) {
                        js.z("__kitegetCacheOrFromDisk# check cache: " + str + " is empty, read from sp and update cache.");
                    }
                }
            }
            return string != null ? string : "";
        } finally {
            this.z.readLock().unlock();
        }
    }
}
