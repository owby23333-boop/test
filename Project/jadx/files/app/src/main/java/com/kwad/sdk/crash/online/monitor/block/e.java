package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static int Ah() {
        com.kwad.sdk.crash.online.monitor.kwai.a aVarAf = d.Af();
        if (aVarAf != null) {
            return aVarAf.arG;
        }
        return 20;
    }

    public static void a(String str, long j2, long j3, String str2, String str3, boolean z2) {
        try {
            e(b(str, j2, j3, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static String b(String str, long j2, long j3, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            str = du(b.dp(str));
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (j3 == 0) {
                j3 = com.anythink.expressad.exoplayer.i.a.f9492f;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", Log.getStackTraceString(e2));
        }
        return c(str, j2, j3, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j2, long j3, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j3;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.ark = str;
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
        }
        aVar.ari = j2;
        aVar.repeatCount = (int) (j3 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    public static void d(String str, boolean z2) {
        String strDr = dr(str);
        if (TextUtils.isEmpty(strDr)) {
            return;
        }
        e(strDr, false);
    }

    @Nullable
    private static String dr(String str) {
        String strDs = ds(b.dp(str));
        return !TextUtils.isEmpty(strDs) ? c(strDs, 0L, com.anythink.expressad.exoplayer.i.a.f9492f, "", "").toJson().toString() : "";
    }

    private static String ds(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (str.contains("at ")) {
                str = str.substring(str.indexOf("at "));
            }
            String strReplaceAll = dt(str.replaceAll("at ", "")).replaceAll("\\)", "\\)\n");
            if (strReplaceAll.contains("\n")) {
                strReplaceAll = strReplaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (strReplaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e2) {
            Log.getStackTraceString(e2);
            return str;
        }
    }

    private static String dt(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    private static String du(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean zStartsWith = str.startsWith(" \n");
            com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "oldVersion:" + zStartsWith);
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
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", Log.getStackTraceString(e2));
            return str;
        }
    }

    public static void dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (d.Ag()) {
            c cVar = new c();
            cVar.arr = str;
            cVar.art = a.Ae();
            KSLoggerReporter.v(cVar.toJson());
        }
    }

    public static void dw(String str) {
        try {
            c cVar = new c();
            cVar.errorMsg = str;
            cVar.art = a.Ae();
            KSLoggerReporter.v(cVar.toJson());
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", str);
    }

    private static void e(final String str, final boolean z2) {
        g.execute(new av() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z2 || e.Ah() == 1) {
                    com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "report now :" + str);
                    h.Q("perf-block", str);
                    return;
                }
                BlockReportAction blockReportAction = new BlockReportAction(str);
                com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                final Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                if (context == null) {
                    return;
                }
                com.kwad.sdk.crash.online.monitor.block.report.a.by(context).e(blockReportAction);
                if (e.xa()) {
                    final List<f> listXh = com.kwad.sdk.crash.online.monitor.block.report.a.by(context).xh();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = listXh.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BlockReportAction) it.next()).msg);
                    }
                    h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1.1
                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onError(int i2, String str2) {
                            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", "errorCode:" + i2 + " errorMsg:" + str2);
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onSuccess() {
                            com.kwad.sdk.crash.online.monitor.block.report.a.by(context).q(listXh);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xa() {
        int iAh = Ah();
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.by(context).size();
        com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "size:" + size + " limit:" + iAh);
        return size >= ((long) iAh);
    }
}
