package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.b;
import anetwork.channel.aidl.h;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class NetworkService extends Service {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private h.a f517t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private h.a f518u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    b.a f519v = new c(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f516s = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkService", "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.f517t = new d.a.l.a(this.f516s);
        this.f518u = new anetwork.channel.http.a(this.f516s);
        if (b.class.getName().equals(intent.getAction())) {
            return this.f519v;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }
}
