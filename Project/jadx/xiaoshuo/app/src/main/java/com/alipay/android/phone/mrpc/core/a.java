package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f1626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f1627b;
    public String c;
    public int d;
    public String e;
    public boolean f;

    public a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.f1626a = method;
        this.d = i;
        this.c = str;
        this.f1627b = bArr;
        this.e = str2;
        this.f = z;
    }
}
