package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class h implements Runnable {
    final /* synthetic */ AccsDataListener a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f18320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f18321d;

    h(AccsDataListener accsDataListener, String str, boolean z2, boolean z3) {
        this.a = accsDataListener;
        this.b = str;
        this.f18320c = z2;
        this.f18321d = z3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onConnected(new TaoBaseService.ConnectInfo(this.b, this.f18320c, this.f18321d));
    }
}
