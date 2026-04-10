package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ce implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailCommonInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailCommonInfo.middleEndcardShowTime = jSONObject.optInt("middleEndcardShowTime");
        detailCommonInfo.rewardFullClickSwitch = jSONObject.optInt("rewardFullClickSwitch");
        detailCommonInfo.rewardInteractionType = jSONObject.optInt("rewardInteractionType");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = detailCommonInfo.middleEndcardShowTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "middleEndcardShowTime", i2);
        }
        int i3 = detailCommonInfo.rewardFullClickSwitch;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardFullClickSwitch", i3);
        }
        int i4 = detailCommonInfo.rewardInteractionType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardInteractionType", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DetailCommonInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DetailCommonInfo) bVar, jSONObject);
    }
}
