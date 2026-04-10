package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ba implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.a> {
    private static void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.arz = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                aVar.arz.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
        aVar.arA = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                aVar.arA.add((String) jSONArrayOptJSONArray2.opt(i3));
            }
        }
        aVar.arB = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                aVar.arB.add((String) jSONArrayOptJSONArray3.opt(i4));
            }
        }
        aVar.arC = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                aVar.arC.add((String) jSONArrayOptJSONArray4.opt(i5));
            }
        }
        aVar.arD = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                com.kwad.sdk.crash.online.monitor.kwai.b bVar = new com.kwad.sdk.crash.online.monitor.kwai.b();
                bVar.parseJson(jSONArrayOptJSONArray5.optJSONObject(i6));
                aVar.arD.add(bVar);
            }
        }
        aVar.arF = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.arG = jSONObject.optInt("batchNum", new Integer(AgooConstants.ACK_REMOVE_PACKAGE).intValue());
        aVar.ahM = jSONObject.optDouble("ratio", new Double("0.01").doubleValue());
        aVar.arH = jSONObject.optInt("monitorSwitch");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "systemFilterList", aVar.arz);
        com.kwad.sdk.utils.s.putValue(jSONObject, "sdkFilterList", aVar.arA);
        com.kwad.sdk.utils.s.putValue(jSONObject, "matrixPrinterNameList", aVar.arB);
        com.kwad.sdk.utils.s.putValue(jSONObject, "commonPrinterNameList", aVar.arC);
        com.kwad.sdk.utils.s.putValue(jSONObject, "featureConfigList", aVar.arD);
        com.kwad.sdk.utils.s.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.arF);
        com.kwad.sdk.utils.s.putValue(jSONObject, "batchNum", aVar.arG);
        com.kwad.sdk.utils.s.putValue(jSONObject, "ratio", aVar.ahM);
        int i2 = aVar.arH;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "monitorSwitch", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.kwai.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.kwai.a) bVar, jSONObject);
    }
}
