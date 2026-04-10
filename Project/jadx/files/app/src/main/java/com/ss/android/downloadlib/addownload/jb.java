package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jb implements IReserveWifiStatusListener {
    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(DownloadInfo downloadInfo, int i2, int i3) {
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.RESERVE_WIFI_SOURCE, Integer.valueOf(i3));
            jSONObject.putOpt(EventConstants.ExtraJson.RESERVE_WIFI_STATUS, Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_RESERVE_WIFI, jSONObject, oxVarMb);
    }
}
