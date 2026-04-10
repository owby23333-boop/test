package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.status.NetworkStatusHelper;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVarK;
        try {
            if (this.a.a.equals(c.b(NetworkStatusHelper.getStatus()))) {
                ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
                int iJ = c.j();
                if (this.a.b.ipStackType != iJ) {
                    c.f496e.put(this.a.a, Integer.valueOf(iJ));
                    this.a.b.lastIpStackType = this.a.b.ipStackType;
                    this.a.b.ipStackType = iJ;
                }
                if ((iJ == 2 || iJ == 3) && (fVarK = c.k()) != null) {
                    c.f495d.put(this.a.a, fVarK);
                    this.a.b.nat64Prefix = fVarK.toString();
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    AppMonitor.getInstance().commitStat(this.a.b);
                }
            }
        } catch (Exception unused) {
        }
    }
}
