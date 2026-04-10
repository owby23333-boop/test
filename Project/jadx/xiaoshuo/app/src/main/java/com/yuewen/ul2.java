package com.yuewen;

import android.content.SharedPreferences;
import com.duokan.reader.DkApp;

/* JADX INFO: loaded from: classes3.dex */
public class ul2 {
    public static final String c = "experiment";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f18506b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f18505a = com.duokan.utils.mmkv.a.e().f(e(), DkApp.get());

    public synchronized void a() {
        SharedPreferences.Editor editor = this.f18506b;
        if (editor != null) {
            editor.apply();
            this.f18506b = null;
        }
    }

    public boolean b(String str, boolean z) {
        return this.f18505a.getBoolean(str, z);
    }

    public int c(String str, int i) {
        return this.f18505a.getInt(str, i);
    }

    public long d(String str, long j) {
        return this.f18505a.getLong(str, j);
    }

    public String e() {
        return c;
    }

    public SharedPreferences.Editor f() {
        if (this.f18506b == null) {
            this.f18506b = this.f18505a.edit();
        }
        return this.f18506b;
    }

    public String g(String str, String str2) {
        return this.f18505a.getString(str, str2);
    }

    public void h(String str, boolean z) {
        f().putBoolean(str, z);
        a();
    }

    public void i(String str, int i) {
        f().putInt(str, i);
        a();
    }

    public void j(String str, long j) {
        f().putLong(str, j);
        a();
    }

    public void k(String str, String str2) {
        f().putString(str, str2);
        a();
    }
}
