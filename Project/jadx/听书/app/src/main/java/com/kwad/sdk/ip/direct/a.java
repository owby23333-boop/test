package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static c aRD = null;
    private static HandlerThread aRE = null;
    private static Handler aRF = null;
    private static int aRu = -1;
    private static volatile boolean aRv;
    private static List<HttpDnsInfo.IpInfo> aRw = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aRx = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aRy = new CopyOnWriteArrayList();
    private static List<c> aRz = new CopyOnWriteArrayList();
    private static List<c> aRA = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> aRB = new PriorityBlockingQueue<>();
    private static AtomicInteger aRC = new AtomicInteger(0);
    private static volatile boolean aRG = false;
    private static float aRH = -1.0f;
    private static float aRI = -1.0f;
    private static float aRJ = -1.0f;
    private static int aRK = 0;
    private static volatile boolean aRL = false;
    private static volatile boolean aRM = false;
    private static NetworkMonitor.a aRN = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (a.aRM) {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            } else {
                a.access$002(true);
            }
        }
    };
    private static Runnable aRO = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.MA();
        }
    };

    static /* synthetic */ boolean access$002(boolean z) {
        aRM = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z) {
        aRL = true;
        return true;
    }

    private static void init() {
        if (aRE != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aRE = handlerThread;
        handlerThread.start();
        aRF = new Handler(aRE.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    a.MA();
                    a.MB();
                } else {
                    if (i != 2) {
                        return;
                    }
                    a.MJ();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aRN);
        }
    }

    private static void Mv() {
        Handler handler;
        if (aRG || (handler = aRF) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String Mw() {
        c cVar = aRD;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float Mx() {
        return aRH;
    }

    public static float My() {
        return aRI;
    }

    public static float Mz() {
        return aRJ;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zBG = hVar.BG();
        aRv = zBG;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isEnable:" + zBG);
        if (zBG) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", httpDnsInfo.toString());
            aRw = httpDnsInfo.recommendList;
            aRx = httpDnsInfo.backUpList;
            aRy = httpDnsInfo.otherList;
            if (aRw.isEmpty() && aRx.isEmpty() && aRy.isEmpty()) {
                com.kwad.sdk.core.d.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                Mv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MA() {
        MF();
        List<HttpDnsInfo.IpInfo> list = aRw;
        List<HttpDnsInfo.IpInfo> list2 = aRx;
        clear();
        if (aRG) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "start pick");
        aRG = true;
        J(list);
        K(list2);
        if (aRz.isEmpty() && aRA.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aRG = false;
                return;
            } else {
                if (!hVar.BH()) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    aRG = false;
                    return;
                }
                MD();
            }
        }
        aRG = false;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MB() {
        if (MC()) {
            return;
        }
        ME();
    }

    private static boolean MC() {
        List<c> list = aRz;
        List<c> list2 = aRA;
        if (!list.isEmpty()) {
            aRD = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from recommend:" + aRD);
            aRK = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int weight = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                weight += cVar.getWeight();
            }
        }
        if (weight <= 0) {
            return false;
        }
        int iNextInt = random.nextInt(weight);
        int i2 = 0;
        while (true) {
            if (i2 >= list2.size()) {
                break;
            }
            if (list2.get(i2) != null) {
                iNextInt -= list2.get(i2).getWeight();
            }
            if (iNextInt < 0) {
                i = i2;
                break;
            }
            i2++;
        }
        aRD = list2.get(i);
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from backUp:" + aRD);
        aRK = 2;
        return true;
    }

    public static int getType() {
        return aRK;
    }

    private static void clear() {
        aRz.clear();
        aRA.clear();
        aRB.clear();
    }

    private static void MD() {
        List<HttpDnsInfo.IpInfo> list = aRy;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c cVarF = b.f(ipInfo.ip, aRu);
                if (cVarF.isSuccess()) {
                    aRB.offer(cVarF);
                }
            }
        }
        c cVarPeek = aRB.peek();
        if (cVarPeek != null) {
            aRJ = cVarPeek.MR();
        }
    }

    private static void ME() {
        if (aRB.isEmpty()) {
            return;
        }
        c cVarPeek = aRB.peek();
        if (cVarPeek.MR() < aRu) {
            aRD = cVarPeek;
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from Other:" + aRD);
            aRK = 3;
        }
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", ipInfo.toString());
                c cVarF = b.f(ipInfo.ip, aRu);
                cVarF.dZ(ipInfo.weight);
                if (cVarF.isSuccess() && cVarF.MR() < aRu) {
                    list2.add(cVarF);
                }
            }
        }
    }

    private static void J(List<HttpDnsInfo.IpInfo> list) {
        b(list, aRz);
        if (aRz.isEmpty()) {
            return;
        }
        Iterator<c> it = aRz.iterator();
        float fMR = 0.0f;
        while (it.hasNext()) {
            fMR += it.next().MR();
        }
        aRH = fMR / aRz.size();
    }

    private static void K(List<HttpDnsInfo.IpInfo> list) {
        b(list, aRA);
        if (aRA.isEmpty()) {
            return;
        }
        int weight = 0;
        float weight2 = 0.0f;
        for (c cVar : aRA) {
            if (cVar != null) {
                weight += cVar.getWeight();
                weight2 += cVar.getWeight() * cVar.MR();
            }
        }
        if (weight != 0) {
            aRI = weight2 / weight;
        }
    }

    private static void MF() {
        if (aRu == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aRu = hVar.BI();
            } else {
                aRu = 200;
            }
        }
    }

    private static boolean MG() {
        if (aRL) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aRC.get();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "value:" + i);
        return i <= 3;
    }

    private static void MH() {
        aRC.getAndIncrement();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "addFailedTimes:" + aRC.intValue());
    }

    public static String fY(String str) {
        if (!aRv) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (fZ(str)) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        }
        if (!MG()) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String strMw = Mw();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost ip:" + strMw);
        return strMw;
    }

    private static boolean fZ(String str) {
        boolean z = !TextUtils.equals("https://" + str, com.kwad.sdk.h.AK());
        if (z) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.h.AK() + "try direct host:https://" + str);
        }
        return z;
    }

    public static void MI() {
        c cVar;
        Handler handler;
        if (!aRv || (cVar = aRD) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = aRF) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void MJ() {
        MH();
        MK();
        ML();
        aRK = 0;
        MB();
        MA();
    }

    private static void MK() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo next;
        c cVar = aRD;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aRw.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                break;
            }
        }
        if (next != null) {
            aRw.remove(next);
            next = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aRx.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it2.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                next = next2;
                break;
            }
        }
        if (next != null) {
            aRx.remove(next);
        } else {
            ipInfo = next;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aRy.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next3 = it3.next();
            if (next3 != null && TextUtils.equals(ip, next3.ip)) {
                ipInfo = next3;
                break;
            }
        }
        if (ipInfo != null) {
            aRy.remove(ipInfo);
        }
    }

    private static void ML() {
        c next;
        if (aRD == null) {
            return;
        }
        List<c> list = aRz;
        if (list != null && !list.isEmpty() && aRz.contains(aRD)) {
            aRz.remove(aRD);
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aRD);
        }
        List<c> list2 = aRA;
        if (list2 != null && !list2.isEmpty()) {
            if (aRA.contains(aRD)) {
                aRA.remove(aRD);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aRD);
            }
            Iterator<c> it = aRA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && TextUtils.equals(next.getIp(), aRD.getIp())) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set removeEntity:" + next.getIp());
                    break;
                }
            }
            if (next != null) {
                aRA.remove(next);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + next);
            }
        }
        c cVarPeek = aRB.peek();
        if (cVarPeek != null && cVarPeek == aRD) {
            aRB.poll();
        }
        aRD = null;
    }
}
