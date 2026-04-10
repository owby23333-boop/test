package com.kwad.components.core.q;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static volatile b XJ = null;
    private static volatile int XK = 204800;
    static volatile boolean XL = true;
    static volatile boolean XM;
    static volatile Set<c> XN = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static void register() {
        try {
            com.kwad.sdk.service.c.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    public static b sy() {
        if (XJ == null) {
            synchronized (b.class) {
                if (XJ == null) {
                    XJ = new b();
                }
            }
        }
        return XJ;
    }

    public static void f(boolean z, int i) {
        if (i > 0) {
            XK = i * 1024;
        }
        XL = z;
    }

    private static synchronized InputStream wrap(InputStream inputStream) {
        c cVar;
        cVar = new c(inputStream, XK / (XN.size() + 1));
        XN.add(cVar);
        return cVar;
    }

    public static synchronized void a(c cVar) {
        if (XN.contains(cVar)) {
            XN.remove(cVar);
        }
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public static boolean sz() {
        return XL;
    }

    public static int sA() {
        return XK / 1024;
    }

    public final synchronized int sB() {
        int iSC;
        iSC = 0;
        try {
            Iterator<c> it = XN.iterator();
            while (it.hasNext()) {
                iSC += (int) it.next().sC();
            }
        } catch (Exception unused) {
        }
        return iSC;
    }
}
