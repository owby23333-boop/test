package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ko {
    private static volatile ko mb;

    private ko() {
    }

    public static ko mb() {
        if (mb == null) {
            synchronized (hj.class) {
                if (mb == null) {
                    mb = new ko();
                }
            }
        }
        return mb;
    }

    public void mb(int i2, int i3, com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(oxVar.m());
        if (downloadSettingObtain.optInt("report_api_hijack", 0) == 0) {
            return;
        }
        int i4 = i3 - i2;
        if (i2 <= 0 || i4 <= downloadSettingObtain.optInt("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.ExtraJson.KEY_VERSION_CODE_DIFF, i4);
            jSONObject.put(EventConstants.ExtraJson.KEY_INSTALLED_VERSION_CODE, i3);
            jSONObject.put(EventConstants.ExtraJson.KEY_HIJACK_TYPE, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.API_HIJACK, jSONObject, oxVar);
    }
}
