package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d implements d.a.m.a {
    private anetwork.channel.aidl.g a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private anetwork.channel.aidl.j.c f571c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f573e;

    public d(anetwork.channel.aidl.g gVar, h hVar) {
        this.f572d = false;
        this.f573e = null;
        this.a = gVar;
        this.f573e = hVar;
        if (gVar != null) {
            try {
                if ((gVar.g() & 8) != 0) {
                    this.f572d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // d.a.m.a
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onResponseCode]", this.b, new Object[0]);
        }
        anetwork.channel.aidl.g gVar = this.a;
        if (gVar != null) {
            a(new e(this, gVar, i2, map));
        }
    }

    @Override // d.a.m.a
    public void a(int i2, int i3, ByteArray byteArray) {
        anetwork.channel.aidl.g gVar = this.a;
        if (gVar != null) {
            a(new f(this, i2, byteArray, i3, gVar));
        }
    }

    @Override // d.a.m.a
    public void a(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onFinish] ", this.b, new Object[0]);
        }
        anetwork.channel.aidl.g gVar = this.a;
        if (gVar != null) {
            g gVar2 = new g(this, defaultFinishEvent, gVar);
            RequestStatistic requestStatistic = defaultFinishEvent.f504w;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
            }
            a(gVar2);
        }
        this.a = null;
    }

    private void a(Runnable runnable) {
        if (this.f573e.c()) {
            runnable.run();
        } else {
            String str = this.b;
            b.a(str != null ? str.hashCode() : hashCode(), runnable);
        }
    }

    public void a(String str) {
        this.b = str;
    }
}
