package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h implements hj {
    private boolean ox(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.b.hj
    public boolean mb(com.ss.android.downloadad.api.mb.ox oxVar, int i2, b bVar) {
        if (oxVar == null || !ox(oxVar.m())) {
            return false;
        }
        if (System.currentTimeMillis() - oxVar.sa() > mb(oxVar.m())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "mistake_click");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
        return true;
    }

    private long mb(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_mistake_click_interval", 300);
    }
}
