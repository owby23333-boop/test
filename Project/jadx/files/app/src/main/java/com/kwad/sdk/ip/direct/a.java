package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.service.kwai.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static int asN = -1;
    private static volatile boolean asO;
    private static c asW;
    private static HandlerThread asX;
    private static Handler asY;
    private static List<HttpDnsInfo.IpInfo> asP = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> asQ = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> asR = new ArrayList();
    private static List<c> asS = new ArrayList();
    private static List<c> asT = new ArrayList();
    private static PriorityBlockingQueue<c> asU = new PriorityBlockingQueue<>();
    private static AtomicInteger asV = new AtomicInteger(0);
    private static volatile boolean asZ = false;
    private static float ata = -1.0f;
    private static float atb = -1.0f;
    private static float atc = -1.0f;
    private static int atd = 0;
    private static volatile boolean ate = false;
    private static volatile boolean atf = false;
    private static NetworkMonitor.a atg = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.atf) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    };
    private static Runnable ath = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.AS();
        }
    };

    private static void AN() {
        Handler handler;
        if (asZ || (handler = asY) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String AO() {
        c cVar = asW;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float AP() {
        return ata;
    }

    public static float AQ() {
        return atb;
    }

    public static float AR() {
        return atc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AS() {
        AX();
        List<HttpDnsInfo.IpInfo> list = asP;
        List<HttpDnsInfo.IpInfo> list2 = asQ;
        clear();
        if (asZ) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "start pick");
        asZ = true;
        y(list);
        z(list2);
        if (asS.isEmpty() && asT.isEmpty()) {
            f fVar = (f) ServiceProvider.get(f.class);
            if (fVar == null) {
                asZ = false;
                return;
            } else {
                if (!fVar.sX()) {
                    com.kwad.sdk.core.d.b.d("IpDirect_Helper", "isIpPreferEnable:false");
                    asZ = false;
                    return;
                }
                AV();
            }
        }
        asZ = false;
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AT() {
        if (AU()) {
            return;
        }
        AW();
    }

    private static boolean AU() {
        List<c> list = asS;
        List<c> list2 = asT;
        if (!list.isEmpty()) {
            asW = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set from recommend:" + asW);
            atd = 1;
            return true;
        }
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        Iterator<c> it = list2.iterator();
        int weight = 0;
        while (it.hasNext()) {
            weight += it.next().getWeight();
        }
        int iNextInt = random.nextInt(weight);
        int i2 = 0;
        while (true) {
            if (i2 >= list2.size()) {
                i2 = 0;
                break;
            }
            iNextInt -= list2.get(i2).getWeight();
            if (iNextInt < 0) {
                break;
            }
            i2++;
        }
        asW = list2.get(i2);
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set from backUp:" + asW);
        atd = 2;
        return true;
    }

    private static void AV() {
        List<HttpDnsInfo.IpInfo> list = asR;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c cVarF = b.f(ipInfo.ip, asN);
                if (cVarF.isSuccess()) {
                    asU.offer(cVarF);
                }
            }
        }
        c cVarPeek = asU.peek();
        if (cVarPeek != null) {
            atc = cVarPeek.Bj();
        }
    }

    private static void AW() {
        if (asU.isEmpty()) {
            return;
        }
        c cVarPeek = asU.peek();
        if (cVarPeek.Bj() < asN) {
            asW = cVarPeek;
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set from Other:" + asW);
            atd = 3;
        }
    }

    private static void AX() {
        if (asN == -1) {
            f fVar = (f) ServiceProvider.get(f.class);
            if (fVar != null) {
                asN = fVar.sY();
            } else {
                asN = 200;
            }
        }
    }

    private static boolean AY() {
        if (ate) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i2 = asV.get();
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "value:" + i2);
        return i2 <= 3;
    }

    private static void AZ() {
        asV.getAndIncrement();
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "addFailedTimes:" + asV.intValue());
    }

    public static void Ba() {
        c cVar;
        Handler handler;
        if (!asO || (cVar = asW) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = asY) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void Bb() {
        AZ();
        Bc();
        Bd();
        atd = 0;
        AT();
        AS();
    }

    private static void Bc() {
        HttpDnsInfo.IpInfo next;
        c cVar = asW;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = asP.iterator();
        while (true) {
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
            asP.remove(next);
            next = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = asQ.iterator();
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
            asQ.remove(next);
            next = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = asR.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next3 = it3.next();
            if (next3 != null && TextUtils.equals(ip, next3.ip)) {
                next = next3;
                break;
            }
        }
        if (next != null) {
            asR.remove(next);
        }
    }

    private static void Bd() {
        c next;
        if (asW == null) {
            return;
        }
        List<c> list = asS;
        if (list != null && !list.isEmpty() && asS.contains(asW)) {
            asS.remove(asW);
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sRecommendEntityList remove:" + asW);
        }
        List<c> list2 = asT;
        if (list2 != null && !list2.isEmpty()) {
            if (asT.contains(asW)) {
                asT.remove(asW);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + asW);
            }
            Iterator<c> it = asT.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && TextUtils.equals(next.getIp(), asW.getIp())) {
                    com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set removeEntity:" + next.getIp());
                    break;
                }
            }
            if (next != null) {
                asT.remove(next);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + next);
            }
        }
        c cVarPeek = asU.peek();
        if (cVarPeek != null && cVarPeek == asW) {
            asU.poll();
        }
        asW = null;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zSW = fVar.sW();
        asO = zSW;
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "isEnable:" + zSW);
        if (zSW) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", httpDnsInfo.toString());
            asP = httpDnsInfo.recommendList;
            asQ = httpDnsInfo.backUpList;
            asR = httpDnsInfo.otherList;
            if (asP.isEmpty() && asQ.isEmpty() && asR.isEmpty()) {
                com.kwad.sdk.core.d.b.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                AN();
            }
        }
    }

    static /* synthetic */ boolean access$002(boolean z2) {
        atf = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z2) {
        ate = true;
        return true;
    }

    private static void clear() {
        asS.clear();
        asT.clear();
        asU.clear();
    }

    private static void d(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", ipInfo.toString());
                c cVarF = b.f(ipInfo.ip, asN);
                cVarF.bE(ipInfo.weight);
                if (cVarF.isSuccess() && cVarF.Bj() < asN) {
                    list2.add(cVarF);
                }
            }
        }
    }

    @Nullable
    public static String dI(String str) {
        String str2;
        if (!asO) {
            str2 = "getIpByHost return by sIpDirectEnable false";
        } else if (dJ(str)) {
            str2 = "isHostInvalid:false ：" + str;
        } else {
            if (AY()) {
                String strAO = AO();
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "getIpByHost ip:" + strAO);
                return strAO;
            }
            str2 = "canUseIpDirect:false";
        }
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", str2);
        return "";
    }

    private static boolean dJ(String str) {
        boolean z2 = !TextUtils.equals("https://" + str, com.kwad.sdk.c.ss());
        if (z2) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.c.ss() + "try direct host:https://" + str);
        }
        return z2;
    }

    public static int getType() {
        return atd;
    }

    private static void init() {
        if (asX != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        asX = handlerThread;
        handlerThread.start();
        asY = new Handler(asX.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    a.AS();
                    a.AT();
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    a.Bb();
                }
            }
        };
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            NetworkMonitor.getInstance().a(eVar.getContext(), atg);
        }
    }

    private static void y(List<HttpDnsInfo.IpInfo> list) {
        d(list, asS);
        if (asS.isEmpty()) {
            return;
        }
        Iterator<c> it = asS.iterator();
        float fBj = 0.0f;
        while (it.hasNext()) {
            fBj += it.next().Bj();
        }
        ata = fBj / asS.size();
    }

    private static void z(List<HttpDnsInfo.IpInfo> list) {
        d(list, asT);
        if (asT.isEmpty()) {
            return;
        }
        int weight = 0;
        float weight2 = 0.0f;
        for (c cVar : asT) {
            weight += cVar.getWeight();
            weight2 += cVar.getWeight() * cVar.Bj();
        }
        if (weight != 0) {
            atb = weight2 / weight;
        }
    }
}
