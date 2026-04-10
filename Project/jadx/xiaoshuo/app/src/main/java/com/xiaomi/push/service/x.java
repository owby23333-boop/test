package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static x f8327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<String> f1060a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f8328b = new ArrayList();
    private final List<String> c = new ArrayList();

    private x(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1059a = applicationContext;
        if (applicationContext == null) {
            this.f1059a = context;
        }
        SharedPreferences sharedPreferences = this.f1059a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f1060a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f8328b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static x a(Context context) {
        if (f8327a == null) {
            f8327a = new x(context);
        }
        return f8327a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m816b(String str) {
        boolean zContains;
        synchronized (this.f8328b) {
            zContains = this.f8328b.contains(str);
        }
        return zContains;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m817c(String str) {
        boolean zContains;
        synchronized (this.c) {
            zContains = this.c.contains(str);
        }
        return zContains;
    }

    public void d(String str) {
        synchronized (this.f1060a) {
            if (this.f1060a.contains(str)) {
                this.f1060a.remove(str);
                this.f1059a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bo.a(this.f1060a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f8328b) {
            if (this.f8328b.contains(str)) {
                this.f8328b.remove(str);
                this.f1059a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bo.a(this.f8328b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f1059a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bo.a(this.c, ",")).commit();
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m815a(String str) {
        boolean zContains;
        synchronized (this.f1060a) {
            zContains = this.f1060a.contains(str);
        }
        return zContains;
    }

    public void b(String str) {
        synchronized (this.f8328b) {
            if (!this.f8328b.contains(str)) {
                this.f8328b.add(str);
                this.f1059a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bo.a(this.f8328b, ",")).commit();
            }
        }
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f1059a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bo.a(this.c, ",")).commit();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f1060a) {
            if (!this.f1060a.contains(str)) {
                this.f1060a.add(str);
                this.f1059a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bo.a(this.f1060a, ",")).commit();
            }
        }
    }
}
