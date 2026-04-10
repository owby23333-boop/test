package com.amgcyo.cuttadon.view.read.page;

import android.os.Looper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CommonEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5265c;

    public i(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static String d() {
        return Looper.myLooper() == Looper.getMainLooper() ? "主线程" : "子线程";
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.f5265c;
    }

    @NotNull
    public String toString() {
        return "携带的数据： {EventName:" + this.a + ", Content:" + this.b + "}, 当前线程状态：" + d();
    }

    public i(int i2) {
        this.f5265c = i2;
    }

    public i() {
    }
}
