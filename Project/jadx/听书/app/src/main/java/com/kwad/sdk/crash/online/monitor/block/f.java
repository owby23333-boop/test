package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.ExoPlayer;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private static String b(String str, long j, long j2, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            str = fK(b.fI(str));
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (j2 == 0) {
                j2 = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", Log.getStackTraceString(e));
        }
        return c(str, j, j2, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j, long j2, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j2;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.aPI = str;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        aVar.aPG = j;
        aVar.repeatCount = (int) (j2 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    private static String fK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean zStartsWith = str.startsWith(" \n");
            com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "oldVersion:" + zStartsWith);
            if (zStartsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(":", "\\.") + "\n";
            }
            String strReplaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (strReplaceAll.contains("\n")) {
                strReplaceAll = strReplaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (strReplaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", Log.getStackTraceString(e));
            return str;
        }
    }

    public static void a(String str, long j, long j2, String str2, String str3, boolean z) {
        try {
            h(b(str, j, j2, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    private static void h(final String str, final boolean z) {
        h.execute(new bg() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z || f.LO() == 1) {
                    com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "report now :" + str);
                    com.kwad.sdk.crash.report.h.ah("perf-block", str);
                    return;
                }
                BlockReportAction blockReportAction = new BlockReportAction(str);
                com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                final Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                if (context == null) {
                    return;
                }
                com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).l(blockReportAction);
                if (f.Ij()) {
                    final List<com.kwad.sdk.core.report.e> listIr = com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).Ir();
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.kwad.sdk.core.report.e> it = listIr.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BlockReportAction) it.next()).msg);
                    }
                    com.kwad.sdk.crash.report.h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onSuccess() {
                            com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).B(listIr);
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onError(int i, String str2) {
                            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", "errorCode:" + i + " errorMsg:" + str2);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int LO() {
        com.kwad.sdk.crash.online.monitor.a.a aVarLM = e.LM();
        if (aVarLM != null) {
            return aVarLM.aQd;
        }
        return 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Ij() {
        int iLO = LO();
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).size();
        com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "size:" + size + " limit:" + iLO);
        return size >= ((long) iLO);
    }

    public static void fL(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (e.LN()) {
            d dVar = new d();
            dVar.aPO = str;
            dVar.aPQ = a.LL();
            com.kwad.sdk.commercial.b.q(dVar);
        }
    }

    public static void fM(String str) {
        try {
            d dVar = new d();
            dVar.errorMsg = str;
            dVar.aPQ = a.LL();
            com.kwad.sdk.commercial.b.q(dVar);
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", str);
    }
}
