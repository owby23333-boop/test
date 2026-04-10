package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private static volatile ThreadPoolExecutor b;

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    private a() {
        b = e.a();
        e.c();
        e.b();
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

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("param is not be null");
        }
        if (b != null) {
            b.execute(cVar);
        }
    }
}
