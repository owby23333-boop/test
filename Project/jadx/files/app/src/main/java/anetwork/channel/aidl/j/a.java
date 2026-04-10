package anetwork.channel.aidl.j;

import android.os.Build;
import android.os.RemoteException;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.a;
import anetwork.channel.aidl.f;
import anetwork.channel.entity.h;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a extends a.AbstractBinderC0010a implements d.a.a, d.a.b, d.a.d {
    private h A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private c f535s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f536t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f537u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Map<String, List<String>> f538v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private StatisticData f539w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CountDownLatch f540x = new CountDownLatch(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CountDownLatch f541y = new CountDownLatch(1);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private anetwork.channel.aidl.e f542z;

    public a(h hVar) {
        this.A = hVar;
    }

    public void a(anetwork.channel.aidl.e eVar) {
        this.f542z = eVar;
    }

    @Override // anetwork.channel.aidl.a
    public void cancel() throws RemoteException {
        anetwork.channel.aidl.e eVar = this.f542z;
        if (eVar != null) {
            eVar.cancel(true);
        }
    }

    @Override // anetwork.channel.aidl.a
    public StatisticData e() {
        return this.f539w;
    }

    @Override // anetwork.channel.aidl.a
    public String getDesc() throws RemoteException {
        a(this.f540x);
        return this.f537u;
    }

    @Override // anetwork.channel.aidl.a
    public f getInputStream() throws RemoteException {
        a(this.f541y);
        return this.f535s;
    }

    @Override // anetwork.channel.aidl.a
    public int j() throws RemoteException {
        a(this.f540x);
        return this.f536t;
    }

    @Override // anetwork.channel.aidl.a
    public Map<String, List<String>> k() throws RemoteException {
        a(this.f540x);
        return this.f538v;
    }

    @Override // d.a.a
    public void a(d.a.e eVar, Object obj) {
        this.f536t = eVar.f();
        this.f537u = eVar.getDesc() != null ? eVar.getDesc() : ErrorConstant.getErrMsg(this.f536t);
        this.f539w = eVar.e();
        c cVar = this.f535s;
        if (cVar != null) {
            cVar.a();
        }
        this.f541y.countDown();
        this.f540x.countDown();
    }

    private void a(CountDownLatch countDownLatch) throws RemoteException {
        try {
            if (countDownLatch.await(this.A.b() + 1000, TimeUnit.MILLISECONDS)) {
                return;
            }
            if (this.f542z != null) {
                this.f542z.cancel(true);
            }
            throw a("wait time out");
        } catch (InterruptedException unused) {
            throw a("thread interrupt");
        }
    }

    private RemoteException a(String str) {
        if (Build.VERSION.SDK_INT >= 15) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }

    @Override // d.a.d
    public boolean a(int i2, Map<String, List<String>> map, Object obj) {
        this.f536t = i2;
        this.f537u = ErrorConstant.getErrMsg(this.f536t);
        this.f538v = map;
        this.f540x.countDown();
        return false;
    }

    @Override // d.a.b
    public void a(f fVar, Object obj) {
        this.f535s = (c) fVar;
        this.f541y.countDown();
    }
}
