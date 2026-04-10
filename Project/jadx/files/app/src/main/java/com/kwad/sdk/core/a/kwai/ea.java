package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ea implements com.kwad.sdk.core.d<InstallActivateReminderConfigItem.InstallActivateReminderConfig> {
    private static void a(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installActivateReminderConfig.noticeTotalCount = jSONObject.optInt("noticeTotalCount", new Integer("3").intValue());
        installActivateReminderConfig.perAppNoticeCount = jSONObject.optInt("perAppNoticeCount", new Integer("2").intValue());
        installActivateReminderConfig.noticeAppearTime = jSONObject.optInt("noticeAppearTime", new Integer("15000").intValue());
        installActivateReminderConfig.noticeContinueTime = jSONObject.optInt("noticeContinueTime", new Integer("15000").intValue());
    }

    private static JSONObject b(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "noticeTotalCount", installActivateReminderConfig.noticeTotalCount);
        com.kwad.sdk.utils.s.putValue(jSONObject, "perAppNoticeCount", installActivateReminderConfig.perAppNoticeCount);
        com.kwad.sdk.utils.s.putValue(jSONObject, "noticeAppearTime", installActivateReminderConfig.noticeAppearTime);
        com.kwad.sdk.utils.s.putValue(jSONObject, "noticeContinueTime", installActivateReminderConfig.noticeContinueTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InstallActivateReminderConfigItem.InstallActivateReminderConfig) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InstallActivateReminderConfigItem.InstallActivateReminderConfig) bVar, jSONObject);
    }
}
