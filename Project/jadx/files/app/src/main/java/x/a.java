package x;

import com.google.gson.Gson;
import com.sntech.x2.topon.strategy.ARPUStrategy;

/* JADX INFO: compiled from: StrategyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f21738d;
    public ARPUStrategy a;
    public long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f21739c = new Object();

    public static a b() {
        if (f21738d == null) {
            synchronized (a.class) {
                if (f21738d == null) {
                    f21738d = new a();
                }
            }
        }
        return f21738d;
    }

    public ARPUStrategy a() {
        synchronized (this.f21739c) {
            if (this.a == null || System.currentTimeMillis() - this.b > 300000) {
                ARPUStrategy aRPUStrategy = null;
                try {
                    String strA = f.a.a(z.a.f21745c, null);
                    if (strA != null) {
                        aRPUStrategy = (ARPUStrategy) new Gson().fromJson(strA, ARPUStrategy.class);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (aRPUStrategy != null) {
                    this.a = aRPUStrategy;
                    this.b = System.currentTimeMillis();
                }
            }
        }
        return this.a;
    }
}
