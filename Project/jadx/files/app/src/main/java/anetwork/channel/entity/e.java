package anetwork.channel.entity;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableHeader;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ int f575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ Map f576u;

    e(d dVar, anetwork.channel.aidl.g gVar, int i2, Map map) {
        this.f574s = gVar;
        this.f575t = i2;
        this.f576u = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f574s.a(this.f575t, new ParcelableHeader(this.f575t, this.f576u));
        } catch (RemoteException unused) {
        }
    }
}
