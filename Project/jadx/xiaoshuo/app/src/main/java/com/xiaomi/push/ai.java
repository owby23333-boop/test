package com.xiaomi.push;

import com.xiaomi.push.ag;

/* JADX INFO: loaded from: classes8.dex */
class ai extends ag.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ag f7788a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ag agVar, ag.a aVar) {
        super(aVar);
        this.f7788a = agVar;
    }

    @Override // com.xiaomi.push.ag.b
    public void b() {
        synchronized (this.f7788a.f123a) {
            this.f7788a.f124a.remove(super.f7786a.mo239a());
        }
    }
}
