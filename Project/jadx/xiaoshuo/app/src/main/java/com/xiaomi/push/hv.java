package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.aj;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
class hv extends aj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f8058a;

    public hv(Context context) {
        this.f8058a = context;
    }

    @Override // com.xiaomi.push.aj.b
    public void b() {
        ArrayList arrayList;
        synchronized (hu.f514a) {
            arrayList = new ArrayList(hu.f516a);
            hu.f516a.clear();
        }
        hu.b(this.f8058a, arrayList);
    }
}
