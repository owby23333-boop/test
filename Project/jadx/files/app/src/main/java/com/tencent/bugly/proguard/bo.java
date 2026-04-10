package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bo extends m {
    static ArrayList<bn> A;
    static Map<String, String> B;
    static Map<String, String> C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static Map<String, String> f18672v = new HashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static bm f18673w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static bl f18674x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static ArrayList<bl> f18675y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static ArrayList<bl> f18676z;
    public String a = "";
    public long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18677c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18678d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18679e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18680f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18681g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f18682h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18683i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public bm f18684j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18685k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18686l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18687m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public bl f18688n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<bl> f18689o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<bl> f18690p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<bn> f18691q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f18692r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, String> f18693s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f18694t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f18695u = true;

    static {
        f18672v.put("", "");
        f18673w = new bm();
        f18674x = new bl();
        f18675y = new ArrayList<>();
        f18675y.add(new bl());
        f18676z = new ArrayList<>();
        f18676z.add(new bl());
        A = new ArrayList<>();
        A.add(new bn());
        B = new HashMap();
        B.put("", "");
        C = new HashMap();
        C.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.f18677c, 2);
        String str = this.f18678d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f18679e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f18680f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f18681g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f18682h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f18683i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bm bmVar = this.f18684j;
        if (bmVar != null) {
            lVar.a((m) bmVar, 9);
        }
        lVar.a(this.f18685k, 10);
        String str6 = this.f18686l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f18687m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bl blVar = this.f18688n;
        if (blVar != null) {
            lVar.a((m) blVar, 13);
        }
        ArrayList<bl> arrayList = this.f18689o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.f18690p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.f18691q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f18692r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f18693s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.f18694t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.f18695u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.b(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.f18677c = kVar.b(2, true);
        this.f18678d = kVar.b(3, false);
        this.f18679e = kVar.b(4, false);
        this.f18680f = kVar.b(5, false);
        this.f18681g = kVar.b(6, false);
        this.f18682h = (Map) kVar.a(f18672v, 7, false);
        this.f18683i = kVar.b(8, false);
        this.f18684j = (bm) kVar.a((m) f18673w, 9, false);
        this.f18685k = kVar.a(this.f18685k, 10, false);
        this.f18686l = kVar.b(11, false);
        this.f18687m = kVar.b(12, false);
        this.f18688n = (bl) kVar.a((m) f18674x, 13, false);
        this.f18689o = (ArrayList) kVar.a(f18675y, 14, false);
        this.f18690p = (ArrayList) kVar.a(f18676z, 15, false);
        this.f18691q = (ArrayList) kVar.a(A, 16, false);
        this.f18692r = (Map) kVar.a(B, 17, false);
        this.f18693s = (Map) kVar.a(C, 18, false);
        this.f18694t = kVar.b(19, false);
        this.f18695u = kVar.a(20, false);
    }
}
