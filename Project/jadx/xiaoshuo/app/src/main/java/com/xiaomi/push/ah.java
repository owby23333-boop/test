package com.xiaomi.push;

import com.xiaomi.push.ag;

/* JADX INFO: loaded from: classes8.dex */
class ah extends ag.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ag f7787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f127a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, ag.a aVar, boolean z, String str) {
        super(aVar);
        this.f7787a = agVar;
        this.f127a = z;
        this.f126a = str;
    }

    @Override // com.xiaomi.push.ag.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ag.b
    public void b() {
        if (this.f127a) {
            return;
        }
        this.f7787a.f122a.edit().putLong(this.f126a, System.currentTimeMillis()).commit();
    }
}
