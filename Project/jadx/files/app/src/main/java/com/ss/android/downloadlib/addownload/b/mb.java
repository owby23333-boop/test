package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.lz;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements hj {
    private static com.ss.android.downloadlib.addownload.mb.b mb;

    public static com.ss.android.downloadlib.addownload.mb.b mb() {
        return mb;
    }

    @Override // com.ss.android.downloadlib.addownload.b.hj
    public boolean mb(final com.ss.android.downloadad.api.mb.ox oxVar, int i2, final b bVar) {
        DownloadInfo downloadInfoOx;
        if (oxVar == null || oxVar.kk() || !mb(oxVar) || (downloadInfoOx = ww.mb((Context) null).ox(oxVar.mb())) == null) {
            return false;
        }
        long jMb = lz.mb(downloadInfoOx.getId(), downloadInfoOx.getCurBytes(), downloadInfoOx.getTotalBytes());
        long totalBytes = downloadInfoOx.getTotalBytes();
        if (jMb <= 0 || totalBytes <= 0 || totalBytes > mb(oxVar.m())) {
            return false;
        }
        mb = new com.ss.android.downloadlib.addownload.mb.b() { // from class: com.ss.android.downloadlib.addownload.b.mb.1
            @Override // com.ss.android.downloadlib.addownload.mb.b
            public void mb() {
                com.ss.android.downloadlib.addownload.mb.b unused = mb.mb = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, EventConstants.ExtraJson.APK_SIZE);
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, "confirm");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
            }

            @Override // com.ss.android.downloadlib.addownload.mb.b
            public void ox() {
                com.ss.android.downloadlib.addownload.mb.b unused = mb.mb = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, EventConstants.ExtraJson.APK_SIZE);
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, com.anythink.expressad.d.a.b.dO);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                bVar.mb(oxVar);
            }
        };
        TTDelegateActivity.mb(oxVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", mb(totalBytes - jMb)), "继续", "暂停");
        oxVar.o(true);
        return true;
    }

    private int mb(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        return com.ss.android.downloadlib.utils.hj.mb(mbVar).optInt("pause_optimise_apk_size_switch", 0) == 1 && mbVar.e();
    }

    private static String mb(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j2 >= DownloadConstants.GB) {
            return (j2 / DownloadConstants.GB) + "G";
        }
        if (j2 >= 1048576) {
            return (j2 / 1048576) + "M";
        }
        return decimalFormat.format(j2 / 1048576.0f) + "M";
    }
}
