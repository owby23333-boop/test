package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bm extends m implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList<String> f18669c;
    public String a = "";
    public ArrayList<String> b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.b(0, true);
        if (f18669c == null) {
            f18669c = new ArrayList<>();
            f18669c.add("");
        }
        this.b = (ArrayList) kVar.a(f18669c, 1, false);
    }
}
