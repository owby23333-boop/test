package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static volatile h a;
    private static HashMap<Integer, f> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashMap<Integer, a> f848c;

    private h() {
        b = new HashMap<>();
        f848c = new HashMap<>();
    }

    public static h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                synchronized (h.class) {
                    if (a == null) {
                        a = new h();
                    }
                }
            }
            hVar = a;
        }
        return hVar;
    }

    public a a(int i2, Context context) {
        a aVar = f848c.get(Integer.valueOf(i2));
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(context, i2);
        f848c.put(Integer.valueOf(i2), aVar2);
        return aVar2;
    }

    public f a(int i2) {
        f fVar = b.get(Integer.valueOf(i2));
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(i2);
        b.put(Integer.valueOf(i2), fVar2);
        return fVar2;
    }
}
