package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.a) {
            if (this.a.f18169f == 0) {
                ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, this.a.b);
                this.a.f18169f = 1;
                this.a.f18171h.clear();
                AppMonitor.getInstance().commitStat(new AssembleMonitor(this.a.b, String.valueOf(this.a.f18169f)));
            }
        }
    }
}
