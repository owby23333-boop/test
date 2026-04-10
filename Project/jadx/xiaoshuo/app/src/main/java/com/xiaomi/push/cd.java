package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes8.dex */
public class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cd f7845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f186a;

    private cd(Context context) {
        this.f186a = context;
    }

    public static cd a(Context context) {
        if (f7845a == null) {
            synchronized (cd.class) {
                if (f7845a == null) {
                    f7845a = new cd(context);
                }
            }
        }
        return f7845a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m265a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.f186a.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m264a(String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = this.f186a.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j);
        editorEdit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f186a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f186a.getSharedPreferences(str, 4).getLong(str2, j);
    }
}
