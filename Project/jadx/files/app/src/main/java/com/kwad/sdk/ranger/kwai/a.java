package com.kwad.sdk.ranger.kwai;

import android.util.Log;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.ranger.c;
import com.kwad.sdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final String TAG = "a";

    private static void CA() {
        x.clear("ksadsdk_perf_ranger");
    }

    private static List<com.kwad.sdk.ranger.kwai.kwai.a> Cz() {
        ArrayList arrayList = new ArrayList();
        try {
            Map<String, ?> mapEk = x.ek("ksadsdk_perf_ranger");
            if (mapEk != null && mapEk.size() > 0) {
                for (Map.Entry<String, ?> entry : mapEk.entrySet()) {
                    if (entry.getValue() instanceof Integer) {
                        com.kwad.sdk.ranger.kwai.kwai.a aVar = new com.kwad.sdk.ranger.kwai.kwai.a();
                        aVar.key = entry.getKey();
                        aVar.value = ((Integer) entry.getValue()).intValue();
                        arrayList.add(aVar);
                    }
                }
            }
        } catch (Exception e2) {
            b.e(TAG, "getAllRecordInfo:" + Log.getStackTraceString(e2));
        }
        return arrayList;
    }

    public static void e(c cVar) {
        List<com.kwad.sdk.ranger.kwai.kwai.a> listCz = Cz();
        if (listCz.isEmpty()) {
            return;
        }
        com.kwad.sdk.ranger.kwai.kwai.b bVar = new com.kwad.sdk.ranger.kwai.kwai.b();
        double d2 = cVar.axo;
        bVar.alY = d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE ? (int) (1.0d / d2) : 1;
        bVar.axE = listCz;
        b.d(TAG, "report:" + bVar.toJson().toString());
        KSLoggerReporter.x(bVar.toJson());
        CA();
    }
}
