package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ag;

/* JADX INFO: loaded from: classes8.dex */
class ce extends ag.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f8277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Notification f1017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f1018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f1019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8278b;

    public ce(int i, String str, Context context, String str2, Notification notification) {
        this.f8277a = i;
        this.f1019a = str;
        this.f1018a = context;
        this.f8278b = str2;
        this.f1017a = notification;
    }

    @Override // com.xiaomi.push.ag.a
    /* JADX INFO: renamed from: a */
    public String mo239a() {
        return cd.b(this.f8277a, this.f1019a);
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        cd.c(this.f1018a, this.f8278b, this.f8277a, this.f1019a, this.f1017a);
    }
}
