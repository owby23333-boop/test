package com.taobao.accs.net;

import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class m implements Runnable {
    final /* synthetic */ TaoBaseService.ConnectInfo a;
    final /* synthetic */ AccsConnectStateListener b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ l f18233c;

    m(l lVar, TaoBaseService.ConnectInfo connectInfo, AccsConnectStateListener accsConnectStateListener) {
        this.f18233c = lVar;
        this.a = connectInfo;
        this.b = accsConnectStateListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ConnectInfo connectInfo = this.a;
        if (connectInfo.connected) {
            this.b.onConnected(connectInfo);
        } else {
            this.b.onDisconnected(connectInfo);
        }
    }
}
