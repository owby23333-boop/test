package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bu extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static Map<String, String> f18741i = new HashMap();
    public long a = 0;
    public byte b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18742c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18743d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18744e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f18745f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18746g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18747h = true;

    static {
        f18741i.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        String str = this.f18742c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f18743d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f18744e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f18745f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f18746g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f18747h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.f18742c = kVar.b(2, false);
        this.f18743d = kVar.b(3, false);
        this.f18744e = kVar.b(4, false);
        this.f18745f = (Map) kVar.a(f18741i, 5, false);
        this.f18746g = kVar.b(6, false);
        this.f18747h = kVar.a(7, false);
    }
}
