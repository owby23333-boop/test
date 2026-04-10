package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class c implements Runnable {
    final /* synthetic */ GlobalClientInfo a;

    c(GlobalClientInfo globalClientInfo) {
        this.a = globalClientInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalClientInfo.f18117c = UtilityImpl.n(GlobalClientInfo.a);
    }
}
