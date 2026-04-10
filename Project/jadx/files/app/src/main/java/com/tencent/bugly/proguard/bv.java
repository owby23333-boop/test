package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bv extends m implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static ArrayList<bu> f18748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Map<String, String> f18749g;
    public byte a = 0;
    public String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18750c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<bu> f18751d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f18752e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        String str = this.b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f18750c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.f18751d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f18752e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.b(1, false);
        this.f18750c = kVar.b(2, false);
        if (f18748f == null) {
            f18748f = new ArrayList<>();
            f18748f.add(new bu());
        }
        this.f18751d = (ArrayList) kVar.a(f18748f, 3, false);
        if (f18749g == null) {
            f18749g = new HashMap();
            f18749g.put("", "");
        }
        this.f18752e = (Map) kVar.a(f18749g, 4, false);
    }
}
