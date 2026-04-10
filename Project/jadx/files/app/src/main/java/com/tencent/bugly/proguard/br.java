package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class br extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static byte[] f18720i = {0};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static Map<String, String> f18721j = new HashMap();
    public byte a = 0;
    public int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f18722c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18723d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18724e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18725f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18726g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f18727h = null;

    static {
        f18721j.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.f18722c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f18723d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f18724e, 4);
        String str2 = this.f18725f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f18726g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f18727h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.f18722c = kVar.c(2, false);
        this.f18723d = kVar.b(3, false);
        this.f18724e = kVar.a(this.f18724e, 4, false);
        this.f18725f = kVar.b(5, false);
        this.f18726g = kVar.b(6, false);
        this.f18727h = (Map) kVar.a(f18721j, 7, false);
    }
}
