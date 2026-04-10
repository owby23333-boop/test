package com.xiaomi.push;

import com.xiaomi.push.ag;
import com.xiaomi.push.cq;

/* JADX INFO: loaded from: classes8.dex */
class cr extends ag.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cq f7864a;

    public cr(cq cqVar) {
        this.f7864a = cqVar;
    }

    @Override // com.xiaomi.push.ag.a
    /* JADX INFO: renamed from: a */
    public String mo239a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f7864a.f200a) {
            if (this.f7864a.f200a.size() > 0) {
                if (this.f7864a.f200a.size() > 1) {
                    cq cqVar = this.f7864a;
                    cqVar.a(cqVar.f200a);
                } else {
                    cq cqVar2 = this.f7864a;
                    cqVar2.b((cq.a) cqVar2.f200a.get(0));
                }
                this.f7864a.f200a.clear();
                System.gc();
            }
        }
    }
}
