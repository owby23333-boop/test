package com.taobao.accs.init;

import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.init.Launcher_InitAccs;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class c implements Runnable {
    final /* synthetic */ Launcher_InitAccs a;

    c(Launcher_InitAccs launcher_InitAccs) {
        this.a = launcher_InitAccs;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ACCSClient.getAccsClient().setLoginInfo(new Launcher_InitAccs.a());
            ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
            l.a().b();
        } catch (AccsException e2) {
            ALog.e("Launcher_InitAccs", "bindApp", e2, new Object[0]);
        }
    }
}
