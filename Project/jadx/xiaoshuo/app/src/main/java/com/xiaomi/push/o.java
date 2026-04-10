package com.xiaomi.push;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes8.dex */
class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f8163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8164b;
    final /* synthetic */ String c;

    public o(n nVar, String str, String str2, String str3) {
        this.f8163a = nVar;
        this.f881a = str;
        this.f8164b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        SharedPreferences.Editor editorEdit = this.f8163a.f878a.getSharedPreferences(this.f881a, 4).edit();
        editorEdit.putString(this.f8164b, this.c);
        editorEdit.commit();
    }
}
