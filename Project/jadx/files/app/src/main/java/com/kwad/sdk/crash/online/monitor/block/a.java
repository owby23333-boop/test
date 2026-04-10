package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static volatile boolean arc;
    private static String ard;
    private static List<String> are;
    private static List<String> arf;
    private static volatile boolean arg;
    private static volatile boolean arh;

    public static boolean Ad() {
        if (arc) {
            return false;
        }
        try {
            return ((Printer) r.d(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e2);
            arc = true;
            return false;
        }
    }

    public static boolean Ae() {
        if (arh) {
            return arg;
        }
        try {
            String str = new String(com.kwad.sdk.core.kwai.c.vV().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            if (Class.forName(str) != null) {
                return true;
            }
        } catch (ClassNotFoundException unused) {
        }
        arg = false;
        arh = true;
        return arg;
    }

    public static void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        are = aVar.arB;
        arf = aVar.arC;
    }

    private static boolean a(List<String> list, boolean z2) {
        if (arc) {
            return false;
        }
        try {
            Printer printer = (Printer) r.d(Looper.getMainLooper(), "mLogging");
            if (printer != null) {
                ard = printer.getClass().getName();
                com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z2) {
                    e.dv(ard);
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str = new String(com.kwad.sdk.core.kwai.c.vV().decode(it.next()));
                    com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            } else {
                com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "printer not hook");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e2);
            arc = true;
        }
        return false;
    }

    public static boolean be(boolean z2) {
        List<String> list = are;
        return (list == null || list.isEmpty()) ? c("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true) : a(are, true);
    }

    public static boolean bf(boolean z2) {
        List<String> list = arf;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(arf, false);
    }

    private static boolean c(String str, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z2);
    }
}
