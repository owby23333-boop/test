package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class je {
    private static com.ss.android.downloadlib.addownload.mb.b mb;

    public static com.ss.android.downloadlib.addownload.mb.b mb() {
        return mb;
    }

    public static boolean mb(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8;
    }

    public static void mb(com.ss.android.downloadlib.addownload.mb.b bVar) {
        mb = bVar;
    }

    public static boolean mb(final com.ss.android.downloadad.api.mb.ox oxVar, DownloadInfo downloadInfo, int i2, final com.ss.android.downloadlib.addownload.b.b bVar) {
        if (oxVar == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        boolean zOx = com.ss.android.downloadlib.utils.hj.ox(oxVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.SWITCH_STATUS, Integer.valueOf(zOx ? 1 : 0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_RESERVE_WIFI_SWITCH_STATUS, jSONObject, oxVar);
        if (!zOx || !mb(i2) || DownloadUtils.isWifi(x.getContext()) || downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        mb(new com.ss.android.downloadlib.addownload.mb.b() { // from class: com.ss.android.downloadlib.addownload.je.1
            @Override // com.ss.android.downloadlib.addownload.mb.b
            public void mb() {
                je.mb((com.ss.android.downloadlib.addownload.mb.b) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(x.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo2);
                    AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_CONFIRM, oxVar);
                }
                bVar.mb(oxVar);
            }

            @Override // com.ss.android.downloadlib.addownload.mb.b
            public void ox() {
                je.mb((com.ss.android.downloadlib.addownload.mb.b) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(x.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_CANCEL, oxVar);
                bVar.mb(oxVar);
            }
        });
        TTDelegateActivity.ox(oxVar);
        return true;
    }
}
