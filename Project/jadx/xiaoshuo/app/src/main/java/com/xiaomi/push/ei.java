package com.xiaomi.push;

import com.xiaomi.push.aj;
import com.xiaomi.push.eg;

/* JADX INFO: loaded from: classes8.dex */
class ei extends aj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    aj.b f7916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ eg f284a;

    public ei(eg egVar) {
        this.f284a = egVar;
    }

    @Override // com.xiaomi.push.aj.b
    public void b() {
        eg.b bVar = (eg.b) this.f284a.f272a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f284a.f272a.remove(bVar)) {
            this.f7916a = bVar;
        }
        aj.b bVar2 = this.f7916a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.aj.b
    /* JADX INFO: renamed from: c */
    public void mo323c() {
        aj.b bVar = this.f7916a;
        if (bVar != null) {
            bVar.mo323c();
        }
    }
}
