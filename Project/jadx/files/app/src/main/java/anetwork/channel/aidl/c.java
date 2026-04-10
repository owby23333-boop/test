package anetwork.channel.aidl;

import android.os.RemoteException;
import anetwork.channel.aidl.b;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c extends b.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ NetworkService f531s;

    c(NetworkService networkService) {
        this.f531s = networkService;
    }

    @Override // anetwork.channel.aidl.b
    public h get(int i2) throws RemoteException {
        return i2 == 1 ? this.f531s.f517t : this.f531s.f518u;
    }
}
