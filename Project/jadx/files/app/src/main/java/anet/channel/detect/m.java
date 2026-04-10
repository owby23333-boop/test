package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ NetworkStatusHelper.NetworkStatus a;
    final /* synthetic */ l b;

    m(l lVar, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.b = lVar;
        this.a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a != NetworkStatusHelper.NetworkStatus.NO && this.a != NetworkStatusHelper.NetworkStatus.NONE) {
                this.b.a.a(NetworkStatusHelper.getUniqueId(this.a));
            }
        } catch (Throwable th) {
            ALog.e("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
        }
    }
}
