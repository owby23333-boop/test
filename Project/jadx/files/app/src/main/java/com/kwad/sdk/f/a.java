package com.kwad.sdk.f;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static List<String> atw;
    private static volatile boolean atx;

    /* JADX INFO: renamed from: com.kwad.sdk.f.a$a, reason: collision with other inner class name */
    public static class C0453a extends com.kwad.sdk.core.response.kwai.a {
        public long atA;
        public String atB;
        public String atC;
        public String atD;
        public long aty;
        public long atz;
        public String sdkVersion;
    }

    static class b {
        private String atB;
        private String atC;
        private String atD;
        private String sdkVersion;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String a(b bVar) {
            return "exit&" + bVar.atB + DispatchConstants.SIGN_SPLIT_SYMBOL + bVar.atC + DispatchConstants.SIGN_SPLIT_SYMBOL + bVar.atD + DispatchConstants.SIGN_SPLIT_SYMBOL + bVar.sdkVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String c(String str, String str2, String str3, String str4) {
            return str + DispatchConstants.SIGN_SPLIT_SYMBOL + str2 + DispatchConstants.SIGN_SPLIT_SYMBOL + str3 + DispatchConstants.SIGN_SPLIT_SYMBOL + str4 + DispatchConstants.SIGN_SPLIT_SYMBOL + KsAdSDKImpl.get().getSDKVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b dM(String str) {
            String[] strArrSplit = str.split(DispatchConstants.SIGN_SPLIT_SYMBOL);
            b bVar = new b();
            bVar.atB = strArrSplit[1];
            bVar.atC = strArrSplit[2];
            bVar.atD = strArrSplit[3];
            bVar.sdkVersion = strArrSplit[4];
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void Bk() {
        List<C0453a> listBm = Bm();
        if (!listBm.isEmpty()) {
            com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "monitorInfoList:" + listBm);
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "monitor_info_list", listBm);
            KSLoggerReporter.p(jSONObject);
        }
        atx = true;
        Bl();
    }

    private static void Bl() {
        List<String> list = atw;
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            dK(it.next());
        }
        atw.clear();
    }

    private static synchronized List<C0453a> Bm() {
        ArrayList arrayList = new ArrayList();
        Map<String, ?> mapAf = x.af(ServiceProvider.getContext(), "dynamic_monitor_info");
        if (mapAf == null) {
            return arrayList;
        }
        for (String str : mapAf.keySet()) {
            if (str.startsWith("enter")) {
                Object obj = mapAf.get(str);
                long jLongValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                b bVarDM = b.dM(str);
                String strA = b.a(bVarDM);
                Object obj2 = mapAf.get(strA);
                long jLongValue2 = jLongValue - (obj2 instanceof Long ? ((Long) obj2).longValue() : 0L);
                long j2 = jLongValue2 > 0 ? jLongValue2 : 0L;
                C0453a c0453a = new C0453a();
                c0453a.aty = jLongValue;
                c0453a.atz = j2;
                c0453a.atA = jLongValue2;
                c0453a.atB = bVarDM.atB;
                c0453a.atC = bVarDM.atC;
                c0453a.atD = bVarDM.atD;
                c0453a.sdkVersion = bVarDM.sdkVersion;
                arrayList.add(c0453a);
                x.ab("dynamic_monitor_info", str);
                x.ab("dynamic_monitor_info", strA);
            }
        }
        return arrayList;
    }

    public static void T(String str, String str2) {
        e(str, str2, "other");
    }

    public static void U(String str, String str2) {
        f(str, str2, "other");
    }

    private static synchronized void b(String str, String str2, String str3, String str4) {
        String strC;
        try {
            strC = b.c(str, str2, str3, str4);
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
        if (atx) {
            dK(strC);
        } else {
            dL(strC);
        }
    }

    private static synchronized void dK(String str) {
        long jB = x.b("dynamic_monitor_info", str, 0L);
        com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + jB);
        x.a("dynamic_monitor_info", str, jB + 1);
    }

    private static void dL(String str) {
        if (atw == null) {
            atw = new CopyOnWriteArrayList();
        }
        com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "saveToCache: " + str);
        atw.add(str);
    }

    public static void e(String str, String str2, String str3) {
        b("enter", str, str2, str3);
    }

    public static void f(String str, String str2, String str3) {
        b("exit", str, str2, str3);
    }

    public static void report() {
        g.schedule(new av() { // from class: com.kwad.sdk.f.a.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                a.Bk();
            }
        }, 1L, TimeUnit.SECONDS);
    }
}
