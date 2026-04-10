package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class am implements com.kwad.sdk.core.d<AdMatrixInfo.AggregationCardInfo> {
    private static void a(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aggregationCardInfo.changeTime = jSONObject.optInt("changeTime");
        aggregationCardInfo.maxTimesPerDay = jSONObject.optInt("maxTimesPerDay");
        aggregationCardInfo.intervalTime = jSONObject.optLong("intervalTime", new Long("1200").longValue());
    }

    private static JSONObject b(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aggregationCardInfo.changeTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "changeTime", i2);
        }
        int i3 = aggregationCardInfo.maxTimesPerDay;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "maxTimesPerDay", i3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "intervalTime", aggregationCardInfo.intervalTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.AggregationCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.AggregationCardInfo) bVar, jSONObject);
    }
}
