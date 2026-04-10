package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static final String TAG = "c";
    private static int aJJ;
    private static int aJK;
    private static int aJL;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aJM = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aJN = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    static /* synthetic */ int JG() {
        int i = aJJ;
        aJJ = i + 1;
        return i;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aJM.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aJN.put(threadPoolExecutor, str);
    }

    public static void cS(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d dVarED;
                if (TextUtils.isEmpty(str) || (dVarED = c.eD(str)) == null || dVarED.aJK == 0) {
                    return;
                }
                int unused = c.aJK = dVarED.aJK;
                if (Math.random() * ((double) c.aJK) >= 1.0d) {
                    return;
                }
                c.a(dVarED);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aJR = true;
        com.kwad.sdk.core.threads.a.a.aJR = true;
        interval = dVar.interval;
        aJL = dVar.aJQ;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new bg() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ExecutorService executorServiceEC;
                for (String str : GlobalThreadPools.JA()) {
                    if (str != null && !c.aJN.containsValue(str) && (executorServiceEC = GlobalThreadPools.eC(str)) != null && (executorServiceEC instanceof ThreadPoolExecutor) && !c.aJM.containsKey(executorServiceEC)) {
                        c.a((ThreadPoolExecutor) executorServiceEC, str);
                    }
                }
                int poolSize = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aJN.keySet()) {
                    String str2 = (String) c.aJN.get(threadPoolExecutor);
                    poolSize += threadPoolExecutor.getPoolSize();
                    b bVarB = c.b(threadPoolExecutor, str2);
                    if (bVarB != null) {
                        com.kwad.sdk.commercial.b.s(bVarB);
                    }
                }
                b bVar = new b();
                bVar.aJz = "total";
                bVar.aJC = poolSize;
                com.kwad.sdk.commercial.b.s(bVar);
                c.JG();
                if (c.aJJ < c.aJL) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aJz = str;
        bVar.aJA = threadPoolExecutor.getCorePoolSize();
        bVar.aJB = threadPoolExecutor.getMaximumPoolSize();
        bVar.aJC = threadPoolExecutor.getPoolSize();
        bVar.aJD = threadPoolExecutor.getActiveCount();
        bVar.aJG = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aJM;
        long jLongValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aJF = completedTaskCount - jLongValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aJE = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).JK();
        } else {
            bVar.aJE = 0L;
        }
        bVar.aJH = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aJI = aJK;
        return bVar;
    }

    public static d eD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
