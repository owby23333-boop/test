package com.xiaomi.push;

import com.xiaomi.push.cq;

/* JADX INFO: loaded from: classes8.dex */
public class cm extends cq.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f7854a;

    public cm(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f7854a = str3;
    }

    public static cm a(String str) {
        return new cm(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
