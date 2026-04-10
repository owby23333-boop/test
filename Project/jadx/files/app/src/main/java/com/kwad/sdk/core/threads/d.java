package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final String TAG = "d";
    private static int alZ;
    private static int ama;
    private static int amb;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> amc = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> amd = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(e eVar) {
        com.kwad.sdk.core.threads.kwai.b.amh = true;
        com.kwad.sdk.core.threads.kwai.a.amh = true;
        interval = eVar.interval;
        amb = eVar.amg;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new av() { // from class: com.kwad.sdk.core.threads.d.2
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                ExecutorService executorServiceCr;
                for (String str : b.yh()) {
                    if (str != null && !d.amd.containsKey(str) && (executorServiceCr = b.cr(str)) != null && (executorServiceCr instanceof ThreadPoolExecutor) && !d.amc.containsKey(executorServiceCr)) {
                        d.a((ThreadPoolExecutor) executorServiceCr, str);
                    }
                }
                for (ThreadPoolExecutor threadPoolExecutor : d.amd.keySet()) {
                    c cVarB = d.b(threadPoolExecutor, (String) d.amd.get(threadPoolExecutor));
                    if (cVarB != null) {
                        KSLoggerReporter.y(cVarB.toJson());
                    }
                }
                d.yn();
                if (d.alZ < d.amb) {
                    handler.postDelayed(this, d.interval);
                }
            }
        });
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        amc.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        amd.put(threadPoolExecutor, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        c cVar = new c();
        cVar.alP = str;
        cVar.alQ = threadPoolExecutor.getCorePoolSize();
        cVar.alR = threadPoolExecutor.getMaximumPoolSize();
        cVar.alS = threadPoolExecutor.getPoolSize();
        cVar.alT = threadPoolExecutor.getActiveCount();
        cVar.alW = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        long jLongValue = (!amc.containsKey(threadPoolExecutor) || amc.get(threadPoolExecutor) == null) ? 0L : amc.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        cVar.alV = completedTaskCount - jLongValue;
        amc.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.kwai.c) {
            cVar.alU = ((com.kwad.sdk.core.threads.kwai.c) threadPoolExecutor).yr();
        } else {
            cVar.alU = 0L;
        }
        cVar.alX = SystemClock.elapsedRealtime() - startTime;
        cVar.interval = interval;
        cVar.alY = ama;
        return cVar;
    }

    public static void cs(final String str) {
        g.execute(new av() { // from class: com.kwad.sdk.core.threads.d.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                e eVarCt;
                int i2;
                if (TextUtils.isEmpty(str) || (eVarCt = d.ct(str)) == null || (i2 = eVarCt.ama) == 0) {
                    return;
                }
                int unused = d.ama = i2;
                double dRandom = Math.random();
                double d2 = d.ama;
                Double.isNaN(d2);
                if (dRandom * d2 >= 1.0d) {
                    return;
                }
                d.a(eVarCt);
            }
        });
    }

    public static e ct(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            e eVar = new e();
            eVar.parseJson(jSONObject);
            return eVar;
        } catch (Exception e2) {
            com.kwai.sodler.lib.a.w(TAG, e2.toString());
            return null;
        }
    }

    static /* synthetic */ int yn() {
        int i2 = alZ;
        alZ = i2 + 1;
        return i2;
    }
}
