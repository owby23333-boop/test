package com.xiaomi.onetrack.b;

import com.xiaomi.onetrack.util.p;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f7606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f7607b;

    public i(h hVar, ArrayList arrayList) {
        this.f7607b = hVar;
        this.f7606a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (p.f7764a) {
            p.a("ConfigDbManager", "update: " + this.f7606a);
        }
        this.f7607b.b((ArrayList<l>) this.f7606a);
    }
}
