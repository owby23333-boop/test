package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    private static void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer(AgooConstants.ACK_REMOVE_PACKAGE).intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer(AgooConstants.ACK_REMOVE_PACKAGE).intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (adInsertScreenInfo.retainWindowText == JSONObject.NULL) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
        adInsertScreenInfo.guideShowStyle = jSONObject.optInt("guideShowStyle");
        adInsertScreenInfo.guideShowTime = jSONObject.optInt("guideShowTime", new Integer("5").intValue());
    }

    private static JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = adInsertScreenInfo.cycleAggregateSwitch;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cycleAggregateSwitch", z2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i2 = adInsertScreenInfo.cycleAggregateStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cycleAggregateStyle", i2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i3 = adInsertScreenInfo.autoCloseTime;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "autoCloseTime", i3);
        }
        int i4 = adInsertScreenInfo.retainWindowStyle;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "retainWindowStyle", i4);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i5 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "retainWindowBasedAdShowCount", i5);
        }
        int i6 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "retainWindowDailyShowCount", i6);
        }
        int i7 = adInsertScreenInfo.guideShowStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "guideShowStyle", i7);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "guideShowTime", adInsertScreenInfo.guideShowTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdInsertScreenInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdInsertScreenInfo) bVar, jSONObject);
    }
}
