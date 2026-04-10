package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ int f577s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ ByteArray f578t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ int f579u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f580v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ d f581w;

    f(d dVar, int i2, ByteArray byteArray, int i3, anetwork.channel.aidl.g gVar) {
        this.f581w = dVar;
        this.f577s = i2;
        this.f578t = byteArray;
        this.f579u = i3;
        this.f580v = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f581w.f572d) {
                try {
                    if (this.f581w.f571c == null) {
                        this.f581w.f571c = new anetwork.channel.aidl.j.c();
                        this.f581w.f571c.a(this.f581w.f573e, this.f579u);
                        this.f581w.f571c.a(this.f578t);
                        this.f580v.a(this.f581w.f571c);
                    } else {
                        this.f581w.f571c.a(this.f578t);
                    }
                } catch (Exception unused) {
                    if (this.f581w.f571c == null) {
                    } else {
                        this.f581w.f571c.close();
                    }
                }
            } else {
                this.f580v.a(new DefaultProgressEvent(this.f577s, this.f578t.getDataLength(), this.f579u, this.f578t.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
