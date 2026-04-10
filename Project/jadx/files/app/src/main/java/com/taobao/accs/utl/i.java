package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class i implements Runnable {
    final /* synthetic */ AccsDataListener a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f18322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f18323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f18324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f18325f;

    i(AccsDataListener accsDataListener, String str, boolean z2, boolean z3, int i2, String str2) {
        this.a = accsDataListener;
        this.b = str;
        this.f18322c = z2;
        this.f18323d = z3;
        this.f18324e = i2;
        this.f18325f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onDisconnected(new TaoBaseService.ConnectInfo(this.b, this.f18322c, this.f18323d, this.f18324e, this.f18325f));
    }
}
