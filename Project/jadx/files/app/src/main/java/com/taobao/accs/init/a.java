package com.taobao.accs.init;

import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class a implements Runnable {
    final /* synthetic */ Launcher_CrossActivityStarted a;

    a(Launcher_CrossActivityStarted launcher_CrossActivityStarted) {
        this.a = launcher_CrossActivityStarted;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
        } catch (AccsException e2) {
            ALog.e("Launcher_CrossActivityStarted", "bindApp", e2, new Object[0]);
        }
    }
}
