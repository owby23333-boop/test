package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ii2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12491b;
    public final String c;

    public ii2(String str, String str2, String str3) {
        this.f12490a = str;
        this.f12491b = str2;
        this.c = str3;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f12491b) || TextUtils.isEmpty(this.c)) ? false : true;
    }
}
