package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private Map<INetworkQualityChangeListener, f> b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f339c = new f();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
            return;
        }
        if (fVar == null) {
            this.f339c.b = System.currentTimeMillis();
            this.b.put(iNetworkQualityChangeListener, this.f339c);
        } else {
            fVar.b = System.currentTimeMillis();
            this.b.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.b.remove(iNetworkQualityChangeListener);
    }

    public void a(double d2) {
        boolean zA;
        for (Map.Entry<INetworkQualityChangeListener, f> entry : this.b.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            f value = entry.getValue();
            if (key != null && value != null && !value.b() && value.a != (zA = value.a(d2))) {
                value.a = zA;
                key.onNetworkQualityChanged(zA ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}
