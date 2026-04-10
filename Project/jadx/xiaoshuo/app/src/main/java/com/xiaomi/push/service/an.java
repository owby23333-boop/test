package com.xiaomi.push.service;

import com.xiaomi.push.ag;

/* JADX INFO: loaded from: classes8.dex */
class an extends ag.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f8213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ ax f951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f952a;

    public an(String str, ax axVar, int i) {
        this.f952a = str;
        this.f951a = axVar;
        this.f8213a = i;
    }

    @Override // com.xiaomi.push.ag.a
    /* JADX INFO: renamed from: a */
    public String mo239a() {
        return this.f952a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f951a.a(this.f8213a);
    }
}
