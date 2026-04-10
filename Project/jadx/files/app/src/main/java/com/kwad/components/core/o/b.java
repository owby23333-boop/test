package com.kwad.components.core.o;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile b OY = null;
    private static volatile int OZ = 204800;
    static volatile boolean Pa = true;
    static volatile boolean Pb = false;
    static volatile Set<c> Pc = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static synchronized void a(c cVar) {
        if (Pc.contains(cVar)) {
            Pc.remove(cVar);
        }
    }

    public static void e(boolean z2, int i2) {
        if (i2 > 0) {
            OZ = i2 * 1024;
        }
        Pa = z2;
    }

    public static b pC() {
        if (OY == null) {
            synchronized (b.class) {
                if (OY == null) {
                    OY = new b();
                }
            }
        }
        return OY;
    }

    public static boolean pD() {
        return Pa;
    }

    public static int pE() {
        return OZ / 1024;
    }

    public static void register() {
        try {
            com.kwad.sdk.service.a.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        cVar = new c(inputStream, OZ / (Pc.size() + 1));
        Pc.add(cVar);
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int pF() {
        int iPG;
        iPG = 0;
        try {
            Iterator<c> it = Pc.iterator();
            while (it.hasNext()) {
                iPG += (int) it.next().pG();
            }
        } catch (Exception unused) {
        }
        return iPG;
    }
}
