package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c implements NetworkStatusHelper.INetworkStatusChangeListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.a.f351n.a();
        b.f343f = 0L;
        this.a.d();
    }
}
