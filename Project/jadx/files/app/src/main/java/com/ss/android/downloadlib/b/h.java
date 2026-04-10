package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h implements InnerEventListener {
    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        if (MonitorConstants.EventLabel.INSTALL_VIEW_RESULT.equals(str)) {
            jSONObject = jb.mb(jSONObject);
            com.ss.android.downloadlib.mb.mb(jSONObject, downloadInfo);
            jb.mb(jSONObject, EventConstants.ExtraJson.MODEL_ID, Long.valueOf(oxVarMb.ox()));
        }
        AdEventHandler.mb().ox(str, jSONObject, oxVarMb);
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        AdEventHandler.mb().mb(str, jSONObject, oxVarMb);
    }
}
