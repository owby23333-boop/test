package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ AccsSessionManager b;

    a(AccsSessionManager accsSessionManager, Intent intent) {
        this.b = accsSessionManager;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = AccsSessionManager.f205c.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.a);
            } catch (Exception e2) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", null, e2, new Object[0]);
            }
        }
    }
}
