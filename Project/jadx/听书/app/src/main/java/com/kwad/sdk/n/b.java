package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.p;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static final String TAG = "Ranger_b";
    private List<com.kwad.sdk.n.a.a> aWU;

    static class a {
        private static final b aWY = new b();
    }

    public static b OQ() {
        return a.aWY;
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.n.a.a> list = dVar.aWU;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.aWU = list;
    }

    public final void start() {
        OR();
        List<com.kwad.sdk.n.a.a> list = this.aWU;
        if (list == null) {
            com.kwad.sdk.core.d.c.w(TAG, "aggregationCheckConfigList is null");
            return;
        }
        for (com.kwad.sdk.n.a.a aVar : list) {
            try {
                if (N(aVar.aXm)) {
                    ey(aVar.aXl);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
            try {
                if (aVar.aXn != null) {
                    a(aVar);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e2));
            }
        }
    }

    private void a(com.kwad.sdk.n.a.a aVar) {
        String strA = c.OV().a(aVar.aXn);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        z(aVar.aXl, strA);
    }

    private boolean N(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean zGE = false;
            for (String str : gF(it.next())) {
                zGE = gE(str);
                int i = zGE ? 0 : i + 1;
            }
            z &= zGE;
        }
        return z;
    }

    private static boolean gE(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String[] gF(String str) {
        return str.contains("_") ? str.split("_") : new String[]{str};
    }

    public final void gG(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GlobalThreadPools.Jn().execute(new Runnable() { // from class: com.kwad.sdk.n.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.aWU != null && !b.this.aWU.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.aWU) {
                            if (b.b(str, aVar.aXo)) {
                                b.eC(aVar.aXl);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public final void c(final StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        GlobalThreadPools.Jn().execute(new Runnable() { // from class: com.kwad.sdk.n.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.aWU != null && !b.this.aWU.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.aWU) {
                            if (b.a(stackTraceElementArr, aVar.aXp)) {
                                b.eE(aVar.aXl);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(StackTraceElement[] stackTraceElementArr, List<String> list) {
        boolean z;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        do {
            z = true;
            if (!it.hasNext()) {
                return true;
            }
            String next = it.next();
            int length = stackTraceElementArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (p.a(stackTraceElementArr[i]).contains(next)) {
                    break;
                }
                i++;
            }
        } while (z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void OR() {
        long jPP = p.PP();
        if (jPP <= 0) {
            return;
        }
        aV(jPP);
    }

    public final void OS() {
        boolean z = false;
        for (int i = 0; i < this.aWU.size(); i++) {
            com.kwad.sdk.n.a.a aVar = this.aWU.get(i);
            if (ez(aVar.aXl)) {
                com.kwad.sdk.commercial.b.v(eA(aVar.aXl));
                z = true;
            }
        }
        if (z) {
            return;
        }
        com.kwad.sdk.commercial.b.v(eA(-1));
    }

    public final void clearAll() {
        for (int i = 0; i < this.aWU.size(); i++) {
            eB(i);
            eD(i);
            eF(i);
            OT();
            eG(i);
        }
    }

    private static void ey(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "aggregation_sdk" + ("_" + i), 1);
    }

    private static boolean ez(int i) {
        return ag.c("ksadsdk_perf_ranger_v2", new StringBuilder("aggregation_sdk").append(new StringBuilder("_").append(i).toString()).toString(), -1) == 1;
    }

    private static com.kwad.sdk.n.b.a.a eA(int i) {
        com.kwad.sdk.n.b.a.a aVar = new com.kwad.sdk.n.b.a.a();
        String str = "_" + i;
        aVar.eI(i);
        aVar.gI(ag.h("ksadsdk_perf_ranger_v2", "aggregation_version" + str, ""));
        aVar.eJ(ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, 0));
        aVar.eK(ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, 0));
        aVar.aW(ag.b("ksadsdk_perf_ranger_v2", "ks_launch_delay", -1L));
        aVar.aX(ag.b("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + str, -1L));
        return aVar;
    }

    private static void z(int i, String str) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i), str);
    }

    private static void eB(int i) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i), "");
    }

    public static void eC(int i) {
        String str = "_" + i;
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + str, ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, -1) + 1);
    }

    private static void eD(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + ("_" + i), 0);
    }

    public static void eE(int i) {
        String str = "_" + i;
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, -1) + 1);
    }

    private static void eF(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + ("_" + i), 0);
    }

    private static void aV(long j) {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", j);
    }

    private static void OT() {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", 0L);
    }

    private static void eG(int i) {
        ag.a("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + ("_" + i), 0L);
    }
}
