package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bq extends m {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static byte[] f18696y = {0};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static Map<String, String> f18697z = new HashMap();
    public int a = 0;
    public String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18698c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18699d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18700e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18701f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18702g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f18703h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18704i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18705j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f18706k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18707l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f18708m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f18709n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f18710o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f18711p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f18712q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f18713r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f18714s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f18715t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f18716u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f18717v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f18718w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f18719x = "";

    static {
        f18697z.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.f18698c, 2);
        lVar.a(this.f18699d, 3);
        String str = this.f18700e;
        if (str != null) {
            lVar.a(str, 4);
        }
        lVar.a(this.f18701f, 5);
        lVar.a(this.f18702g, 6);
        lVar.a(this.f18703h, 7);
        String str2 = this.f18704i;
        if (str2 != null) {
            lVar.a(str2, 8);
        }
        String str3 = this.f18705j;
        if (str3 != null) {
            lVar.a(str3, 9);
        }
        Map<String, String> map = this.f18706k;
        if (map != null) {
            lVar.a((Map) map, 10);
        }
        String str4 = this.f18707l;
        if (str4 != null) {
            lVar.a(str4, 11);
        }
        lVar.a(this.f18708m, 12);
        String str5 = this.f18709n;
        if (str5 != null) {
            lVar.a(str5, 13);
        }
        String str6 = this.f18710o;
        if (str6 != null) {
            lVar.a(str6, 14);
        }
        String str7 = this.f18711p;
        if (str7 != null) {
            lVar.a(str7, 15);
        }
        lVar.a(this.f18712q, 16);
        String str8 = this.f18713r;
        if (str8 != null) {
            lVar.a(str8, 17);
        }
        String str9 = this.f18714s;
        if (str9 != null) {
            lVar.a(str9, 18);
        }
        String str10 = this.f18715t;
        if (str10 != null) {
            lVar.a(str10, 19);
        }
        String str11 = this.f18716u;
        if (str11 != null) {
            lVar.a(str11, 20);
        }
        String str12 = this.f18717v;
        if (str12 != null) {
            lVar.a(str12, 21);
        }
        String str13 = this.f18718w;
        if (str13 != null) {
            lVar.a(str13, 22);
        }
        String str14 = this.f18719x;
        if (str14 != null) {
            lVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.b(1, true);
        this.f18698c = kVar.b(2, true);
        this.f18699d = kVar.b(3, true);
        this.f18700e = kVar.b(4, false);
        this.f18701f = kVar.b(5, true);
        this.f18702g = kVar.a(this.f18702g, 6, true);
        this.f18703h = kVar.c(7, true);
        this.f18704i = kVar.b(8, false);
        this.f18705j = kVar.b(9, false);
        this.f18706k = (Map) kVar.a(f18697z, 10, false);
        this.f18707l = kVar.b(11, false);
        this.f18708m = kVar.a(this.f18708m, 12, false);
        this.f18709n = kVar.b(13, false);
        this.f18710o = kVar.b(14, false);
        this.f18711p = kVar.b(15, false);
        this.f18712q = kVar.a(this.f18712q, 16, false);
        this.f18713r = kVar.b(17, false);
        this.f18714s = kVar.b(18, false);
        this.f18715t = kVar.b(19, false);
        this.f18716u = kVar.b(20, false);
        this.f18717v = kVar.b(21, false);
        this.f18718w = kVar.b(22, false);
        this.f18719x = kVar.b(23, false);
    }
}
